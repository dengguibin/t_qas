/**
*/
package	com.upath.plat.auth.action;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletOutputStream;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.upath.plat.auth.facade.IDepartMent;
import com.upath.plat.auth.facade.IRole;
import com.upath.plat.auth.facade.IUser;
import com.upath.plat.auth.model.TRmsDeptment;
import com.upath.plat.auth.model.TRmsRole;
import com.upath.plat.auth.model.TRmsUser;
import com.upath.plat.auth.service.TRmsDeptmentService;
import com.upath.plat.auth.service.TRmsRoleService;
import com.upath.plat.auth.service.TRmsUserService;
import com.upath.plat.auth.util.OrgInfoExcelUtil;
import com.upath.plat.common.PlatConstant;
import com.upath.plat.common.PlatConstant.UserStatus;
import com.upath.plat.common.action.BaseActionSupport;
import com.upath.plat.common.cache.AuthCacheManager;
import com.upath.plat.common.cache.CacheManager;
import com.upath.plat.common.cache.ICacheCode;
import com.upath.plat.common.exception.PlatformException;
import com.upath.plat.common.service.ISequence;
import com.upath.plat.common.util.IDGenerator;
import com.upath.plat.common.util.PlatUtil;
import com.upath.plat.common.util.PropertyUtil;
import com.upath.plat.common.util.VTree;



/**
* strut2 config :
* spring config :
* @ClassName: TRmsDeptmentAction.java
* @Description: t_rms_deptment
* @author upaths@gmail.com  
* @date2012-11-3 22:06:29
* @version V1.0   
*/

@Scope("prototype")
@Component("tRmsDeptmentAction")
@SuppressWarnings({ "rawtypes", "serial", "unchecked", "unused" })
public class TRmsDeptmentAction extends BaseActionSupport {

	private static final Logger log = Logger.getLogger(TRmsDeptmentAction.class);
	
	/**
	 * 模板对应的列
	 */
	private final  String[] columnDefind={"bmid","bmmc","unit_type","bmbh",
			"fbmid","bmms","yhid","yhmc",
			"yhmm","sjhm","dzyj","gzdh","caid"};
	/**
	 * 模板地址
	 */
	private  String templatePath="/template/orginfo.xls";
	
	
	/*服务类*/
	private  TRmsDeptmentService service;

	
	private  TRmsRoleService roleSerive;
	
	private  TRmsUserService userService;
	
	/*操作实体*/
	private TRmsDeptment bean;
	
	/*查询列表数据*/
	private List datas ;
	
		// 上传的文件类型.
		private String docContentType;
		// 上传的文件名.
		private String docFileName;
		
		// 上传的文件.
		private File doc;
	
	/**
	 * 查询单个实体
	 * @return select
	 */
	public String select(){
		TRmsDeptment data = service.select(bean);
		if(data != null){
			bean = data;
		}
			if(bean != null && bean.getFbmid() != null){
				data = new TRmsDeptment();
				data.setBmid(bean.getFbmid());;
				data = service.select(data);
				request.setAttribute("pdept", data);
				
			}
			if(bean != null && bean.getBmhjr() != null){
				TRmsUser use = new TRmsUser();
				use.setYhid(bean.getBmhjr());
				use = userService.select(use);
				request.setAttribute("use", use);
				
			}
		return FORWARD_SELECT;
	}
	
	/**
	 * 查询数据列表
	 * @return select
	 */
	public String list(){
		request.setAttribute("mapper",service.getMapperClass());
		return FORWARD_LIST;
	}
	
	/**
	 * 数据保存，首先从数据库检测一次是否存在 ，存在调用更新，否则调用插入
	 * @return select
	 */
	public String save(){
		boolean isNew = false;
		TRmsDeptment data = service.select(bean);
			if(bean != null){
				if(bean.getFbmid() == null || "".equals(bean.getFbmid())){
					bean.setFbmid(null);
				}
			}
		
			if(data != null){
				bean.setXgr(getLoginUser().getUserId());
				bean.setXgsj(new Date());
				service.update(bean);
			}else{
				isNew = true;
				bean.setCjr(getLoginUser().getUserId());
				bean.setCjsj(new Date());
				service.insert(bean);
			}
		return FORWARD_SAVEOK;
	}
	
	public String listUser(){
		TRmsRole role = new TRmsRole();
		datas = roleSerive.listUser(role);
		if(datas != null){
			for(Object o : datas){
				String type =	PropertyUtil.getMapValue(o, "TYPE");
				if("D".equals(type) == true){
					String bmid = PropertyUtil.getMapValue(o, "YHID");
					PropertyUtil.setMapValue(o, "CHECKED", null);
				}
			}
			JSONArray json = JSONArray.fromObject(datas);
			request.setAttribute("json", json.toString());
		}		
		return "listUser";
	}
	
	/**
	 * 单位自己进行管理信息
	 * @return
	 */
	public String listDeptInfo(){
		IUser user = getLoginUser();
		if(user != null){
			String deptId = user.getDepartId();
			if(deptId != null && "".equals(deptId) == false){
				if(bean == null){
					bean = new TRmsDeptment();
				}
				bean.setBmid(deptId);
				bean = service.select(bean);
				if(bean != null){
					datas = service.listSubDepts(bean);
				}
				if(datas != null && datas.size() > 0){
					datas = VTree.buildMapVTree(datas, "BMID", "FBMID", deptId).asDataList();
				}
			}
		}
		return FORWARD_LIST;
	}
	
	
	public String toEditDeptInfo(){
		IUser user = getLoginUser();
		if(user != null){
			String deptId = user.getDepartId();
			if(deptId != null && "".equals(deptId) == false){
				if(bean == null){
					bean = new TRmsDeptment();
				}
				bean = service.select(bean);
				List<IUser>	users = user.getDepartMent().getAllUsers();
				request.setAttribute("users", users);
				TRmsDeptment querys = new TRmsDeptment();
				querys.setBmid(deptId);
				datas = service.listSubDepts(querys);
			}
		}
		return FORWARD_TOEDIT;
	}
	
	
	
	public String removeDept()  throws Exception{
		if(bean != null){
		IUser user = 	getLoginUser();
			if(bean.getBmid().equals(user.getDepartId())){
				throw new PlatformException("用户禁止删除本单位部门信息");
			}
		}
		return delete();
	}
	
	public String saveDept()  throws Exception{
		return save();
	}
	
	
	/**
	 * 删除数据
	 * @return select
	 */
	public String delete() throws Exception{
		Map result = new HashMap();
		result.put("status", "0");
		String msg = null;
		if(bean != null && bean.getBmid() != null){
			boolean checkResult = true;
			datas = service.listSubDepts(bean);
			if(datas != null && datas.size() > 1){
				//存在子部门数据
				checkResult = false;
				msg = "子部门数据";
			}else{
				IDepartMent dept = AuthCacheManager.getInstance().getDepartMent(bean.getBmid());
				List<IUser> usrs = dept.getDepartUsers();
				if(usrs != null && usrs.size() > 0){
					checkResult = false;
					msg = "用户数据";
				}
			}
			if(checkResult == true){
				try{
					service.delete(bean);;
					result.put("status", "1");
				}catch(Exception e){
					e.printStackTrace();
					result.put("message", e.getMessage());
				}
			}else{
				result.put("status", "2");
				result.put("message", "已经存在相关联的数据，请先删除:"+msg);
			}
		}else{
			result.put("message","错误参数");
		}
		response.setContentType("text/json; charset=UTF-8");
		JSONObject json = JSONObject.fromObject(result);
		response.getWriter().print(json.toString());
		return null;
	}
	
	
	/**
	 * 删除数据
	 * @return select
	 */
	public String listTree(){
		datas = service.list(bean);
		if(datas != null){
			JSONArray  json = JSONArray.fromObject(datas);
			request.setAttribute("json", json);
			/*
			List<ICacheCode> types =  CacheManager.getInstance().getCodes("UNIT_TYPE");
			if(types != null){
				JSONArray arrTypes = JSONArray.fromObject(types);
				request.setAttribute("jsonTypes", arrTypes);
			}*/
		}
		return "listTree";
	}
	
	
	public String listOrgJson() throws Exception{
		List datas = CacheManager.getInstance().getCodes("ORGS");
		if(datas != null && datas.size() > 0){
			List result = new ArrayList();
			for(int i = 0 ; i < datas.size() ; i++){
				Map data = new HashMap();
				ICacheCode code = (ICacheCode) datas.get(i);
				data.put("value", code.getCname());
				data.put("data", code);
				result.add(data);
			}
			response.setContentType("text/json; charset=UTF-8");
			JSONArray json = JSONArray.fromObject(result);
			response.getWriter().print(json.toString());
		}
		return null;
	}
	
	public String downTemplate() throws Exception {
		ServletOutputStream ops = response.getOutputStream();
		OrgInfoExcelUtil orgInfoExcelUtil = new OrgInfoExcelUtil(columnDefind,3, 0, 0);
		URL path = Thread.currentThread().getContextClassLoader().getResource(templatePath);
		File templateFile = new File(path.toURI());
		if(templateFile.exists() == false){	
			response.reset();
    		response.setContentType("text/html; charset=UTF-8");
    		String script = "<script>alert('模板源文件不存在')</script>";
    		response.getWriter().print(script);
    		response.flushBuffer();
    		return null;
		}
		
		HashMap<String, List<String>> proMap = new HashMap<String, List<String>>();
		List<String> list = new ArrayList<String>();
		List<ICacheCode> codes = CacheManager.getInstance().getCodes("UNIT_TYPE");
		if(codes != null && codes.isEmpty() == false){
			for(int i = 0 ; i < codes.size() ; i++){
				list.add(codes.get(i).getCname());
			}
		}else{
			response.setContentType("text/html; charset=UTF-8");
    		String script = "<script>alert('系统中还未配置单位类型信息：字典【UNIT_TYPE】')</script>";
    		response.getWriter().print(script);
    		return null;
		}
		List<String> list2 = new ArrayList<String>();
		List<IRole> roles = AuthCacheManager.getInstance().getAllRoles();
		if(roles != null && roles.isEmpty() == false){
			for(int i = 0 ; i < roles.size() ; i++){
				IRole role = roles.get(i);
				if(role.isAdmin() == false){
					list2.add(role.getRoleName());
				}
			}
		}
		proMap.put("unit_type", list);
		proMap.put("caid", list2);
		String encodetittle = new String("单位信息初始模板".getBytes("GBK"),"ISO-8859-1");
		response.setContentType("application/vnd.ms-excel");
		response.addHeader("Content-Disposition", "attachment;filename="+ encodetittle + ".xls");
		orgInfoExcelUtil.downTemplate(templateFile, proMap, ops);
		return null;
	}
	
	
	public String toEditExcel(){
		
		return "toEditExcel";
	}
	
	public String saveExcel(){
		 String dynaCode = request.getParameter("code");
		//如果是验证码功能已经开启，那么需要验证此功能
			Object obj = request.getSession().getAttribute(PlatConstant.SESSION_PATCHCA);
			if(dynaCode == null || dynaCode.equalsIgnoreCase(obj+"") == false){
				this.addActionError("验证码信息不正确请重新输入");
				return toEditExcel();
			}
		
		OrgInfoExcelUtil orgInfoExcelUtil = new OrgInfoExcelUtil(columnDefind,3, 0, 0);
		if(this.doc == null){
			this.addActionError("没有上传的数据文档信息");
			return toEditExcel();
		}
		try{
		 datas = 	orgInfoExcelUtil.getExcelValue(this.doc,1);
		if(datas == null || datas.isEmpty() == true){
			this.addActionError("数据文档中没有发现任何填报的数据！");
			return toEditExcel();
		}
		
		List<TRmsDeptment> depts = new ArrayList<TRmsDeptment>();
		List<TRmsUser> users = new ArrayList<TRmsUser>();
		List<IRole> roles = AuthCacheManager.getInstance().getAllRoles();
		
		Set<String> deptNames  = new HashSet<String>();
		Set<String> userNames  = new HashSet<String>();
		
		List<ICacheCode> codes = CacheManager.getInstance().getCodes("UNIT_TYPE");
				ISequence seq = PlatUtil.getPlatSequence();
				String[] ids = IDGenerator.getIds(datas.size());
				for(int i = 0 ; i < datas.size() ; i++){
					Map data = (Map) datas.get(i);
					TRmsDeptment dept = new TRmsDeptment();
					TRmsUser user = new TRmsUser();
					BeanUtils.copyProperties(dept, data);
					BeanUtils.copyProperties(user, data);
					if(dept.getBmmc() == null || dept.getUnit_type() == null || dept.getBmbh() == null
							|| user.getYhid() == null || user.getYhmm() == null || user.getYhmc() == null
							){
						this.addActionError("请检查上传的数据文件信息，缺少的数据项内容");
						return toEditExcel();
					}
					
					
					String uType = dept.getUnit_type();
					dept.setUnit_type(null);
					if(codes != null && codes.isEmpty() == false){
						for(int j = 0 ; j < codes.size() ; j++){
							ICacheCode code = 	codes.get(j);
							if(uType.equals(code.getCname()) == true){
								dept.setUnit_type(code.getSubcode());
								break;
							}
						}
					}
					//保证单位的FDN排序的问题
					if(dept.getBmid() == null){
						dept.setBmid(ids[i]+"-"+IDGenerator.getId());
					}
					dept.setCjr(getLoginUser().getUserId());
					dept.setCjsj(new Date());
					String roleName = user.getCaid();
					user.setCaid(null);
					if(roles != null && roles.isEmpty() == false && roleName != null){
						for(int j = 0 ; j < roles.size() ; j++){
							IRole role = roles.get(j);
							if(role.isAdmin() == false && role.getRoleName().equals(roleName)){
								user.setRoleIds(new String[]{role.getRoleId()});
								break;
							}
						}
					}
					user.setUid(IDGenerator.getUUID());
					user.setYhmm(PlatUtil.encrypt(user.getYhmm()));
					user.setYhzt(UserStatus.STATUS_INIT.getStatus());
					user.setCjr(getLoginUser().getUserId());
					user.setCjsj(new Date());
					user.setBmid(dept.getBmid());
					//设置成有效
					user.setSfyx(1);
					depts.add(dept);
					user.setPxh(i+1);
					dept.setPxh(i + 1);
					users.add(user);
					deptNames.add(dept.getBmmc());
					userNames.add(user.getYhid());
			}
		
				for(int i = 0 ; i < depts.size() ; i++){
					TRmsDeptment dept = depts.get(i);
					String pName = dept.getFbmid();
					if(pName != null){
						dept.setFbmid(null);
						for(int j = 0 ; j < depts.size() ; j++){
							TRmsDeptment cMp = depts.get(j);
							if(pName.equals(cMp.getBmmc()) == true){
								dept.setFbmid(cMp.getBmid());
								break;
							}
						}
						
					if(dept.getFbmid() == null){
						this.addActionError(pName+":，无法找到对应的上级单位名称。");
						return toEditExcel();
					}	
					}
				}
				
				if(depts.size() !=  deptNames.size() || userNames.size() != users.size()){
					this.addActionError("存在重复的单位名称信息或者是用户ID信息");
					return toEditExcel();
				}
			service.saveExcelDepts(depts, users);	
		}catch(Exception e){
			log.error(e);
			this.addActionError("解释数据文档出错，请检查数据文件格式");
			return toEditExcel();
		}
		return FORWARD_SAVEOK;
	}

	@Autowired
	public void setService(TRmsDeptmentService service) {
		this.service = service;
	}

	public TRmsRoleService getRoleSerive() {
		return roleSerive;
	}
	@Autowired
	public void setRoleSerive(TRmsRoleService roleSerive) {
		this.roleSerive = roleSerive;
	}

	public TRmsUserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(TRmsUserService userService) {
		this.userService = userService;
	}

	public TRmsDeptment getBean() {
		return bean;
	}

	public void setBean(TRmsDeptment bean) {
		this.bean = bean;
	}

	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}
	

	public String getDocContentType() {
		return docContentType;
	}

	public void setDocContentType(String docContentType) {
		this.docContentType = docContentType;
	}

	public String getDocFileName() {
		return docFileName;
	}

	public void setDocFileName(String docFileName) {
		this.docFileName = docFileName;
	}

	public File getDoc() {
		return doc;
	}

	public void setDoc(File doc) {
		this.doc = doc;
	}

}
