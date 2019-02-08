/**
*/
package	com.upath.plat.auth.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.deceen.data.major.majorCourse.model.QasDMajorcourse;
import com.deceen.data.major.majorCourse.service.QasDMajorcourseService;
import com.deceen.diagnoseformat.scheme.model.QasTDiagnosescheme;
import com.deceen.system.major.model.QasDMajor;
import com.deceen.system.major.service.QasDMajorService;
import com.deceen.utils.ResultMap;
import com.upath.plat.common.PlatConstant.UserStatus;
import com.upath.plat.common.action.BaseActionSupport;
import com.upath.plat.common.cache.AuthCacheManager;
import com.upath.plat.common.exception.PlatformException;
import com.upath.plat.common.util.PlatUtil;
import com.upath.plat.common.util.PropertyUtil;
import com.upath.plat.auth.facade.IRole;
import com.upath.plat.auth.model.TRmsDeptment;
import com.upath.plat.auth.model.TRmsUser;
import com.upath.plat.auth.service.TRmsDeptmentService;
import com.upath.plat.auth.service.TRmsUserService;



/**
* strut2 config :
* spring config :
* @ClassName: TRmsUserAction.java
* @Description: t_rms_user
* @author upaths@gmail.com  
* @date2012-11-3 22:06:30
* @version V1.0   
*/

@Scope("prototype")
@Component("tRmsUserAction")
@SuppressWarnings({ "rawtypes", "serial", "unchecked", "unused" })
public class TRmsUserAction extends BaseActionSupport {

	private static final Logger log = Logger.getLogger(TRmsUserAction.class);
	
	/*服务类*/
	private  TRmsUserService service;
	
	/*服务类*/
	private  TRmsDeptmentService deptService;
	
	
	@Autowired
	private QasDMajorService majorService;
	
	/*操作实体*/
	private TRmsUser bean;
	
    private QasDMajor majorBean;
	
	private List majorDatas;
	

	public List getMajorDatas() {
		return majorDatas;
	}

	public void setMajorDatas(List majorDatas) {
		this.majorDatas = majorDatas;
	}

	/*查询列表数据*/
	private List datas ;
	
	/**
	 * 查询单个实体
	 * @return select
	 */
	public String select(){
		TRmsUser data = service.select(bean);
		if(data != null){
			bean = data;
			if(bean.getYhmm() != null){
				bean.setYhmm(PlatUtil.decrypt(bean.getYhmm()));
			}
		}
		if(bean != null && bean.getBmid() != null){
			//个体的单位名称
			TRmsDeptment dept = service.selectDeptment(bean.getBmid());
			request.setAttribute("dept", dept);
			//个体的所属专业
			majorBean = majorService.select(bean.getZyid());
			request.setAttribute("major", majorBean);
		}
		//只能当前登陆用户管理他可以分配的角色
		List<IRole> roles = 	getLoginUser().getRoles();
		request.setAttribute("roles", roles);
		
		
		
		
		return FORWARD_SELECT;
	}
	
	/**
	 * 查询数据列表
	 * @return select
	 */
	public String list(){
		if(bean == null){
			bean = new TRmsUser();
		}
		
		datas = service.list(bean);
		  if(datas != null && datas.isEmpty() == false){
		    	for(int i = 0 ; i < datas.size() ; i++){
		    		Map map = (Map) datas.get(i);
		    		String yhzt = PropertyUtil.getMapValue(map, "YHZT");
		    		if(yhzt != null){
		    			int status = Integer.valueOf(yhzt);
		    			map.put("USTATUS", UserStatus.getName(status));
		    			if((status & UserStatus.STATUS_DISABLE.getStatus()) > 0){
		    				map.put("DISABLE", 1);
		    			}
		    		}
		    	}
		    }
		return FORWARD_LIST;
	}
	
	/**
	 * 查询单位数据列表
	 * @return select
	 */
	public String listOrgUserInfo(){
		if(bean == null ){
			bean = new TRmsUser();
		}
		if(getLoginUser() != null){
			bean.setBmid(getLoginUser().getDepartId());
		    datas = service.listDeptUsers(bean);
		    
		    if(datas != null && datas.isEmpty() == false){
		    	for(int i = 0 ; i < datas.size() ; i++){
		    		Map map = (Map) datas.get(i);
		    		String yhzt = PropertyUtil.getMapValue(map, "YHZT");
		    		if(yhzt != null){
		    			int status = Integer.valueOf(yhzt);
		    			map.put("USTATUS", UserStatus.getName(status));
		    			if((status & UserStatus.STATUS_DISABLE.getStatus()) > 0){
		    				map.put("DISABLE", 1);
		    			}
		    		}
		    	}
		    }
		}
		return FORWARD_LIST;
	}
	
	/**
	 * 编辑单位用户数据信息
	 * @return select
	 */
	public String toEditOrgUserInfo(){
		if(bean != null){
			TRmsUser data = service.select(bean);
			bean = data;
		}
		if(bean == null){
			bean = new TRmsUser();
			bean.setSfyx(1);
		}
		TRmsDeptment querys = new TRmsDeptment();
		querys.setBmid(getLoginUser().getDepartId());
		//子部门相关信息
		datas = deptService.listSubDepts(querys);
		List<IRole> roles = 	getLoginUser().getRoles();
		request.setAttribute("roles", roles);
		return FORWARD_TOEDIT;
	}
	
	/**
	 * 改变用户是禁用？启用
	 * @return select
	 */
	public String changeOrgUser()  throws Exception{
		Map result = new HashMap();
		result.put("status", "0");
		String msg = null;
		if(bean != null && bean.getYhid() != null){
			TRmsUser data = service.select(bean);
			if(data != null){
			bean.setXgr(getLoginUser().getUserId());
			bean.setXgsj(new Date());
			int style = data.getYhzt();
			//禁用
			if((style & UserStatus.STATUS_DISABLE.getStatus() ) > 0){
				style &= ~UserStatus.STATUS_DISABLE.getStatus();
			}else{
				style |= UserStatus.STATUS_DISABLE.getStatus();
			}
			bean.setYhzt(style);
			service.updateStatus(bean);
			result.put("status", "1");
			}
			
		}
		response.setContentType("text/json; charset=UTF-8");
		JSONObject json = JSONObject.fromObject(result);
		response.getWriter().print(json.toString());
		return null;
	}
	/**
	 * 重置用户密码
	 * @return select
	 */
	public String resetUserPwd()  throws Exception{
		Map result = new HashMap();
		result.put("status", "0");
		String msg = null;
		if(bean != null && bean.getYhid() != null){
			TRmsUser data = service.select(bean);
			if(data != null){
			bean.setXgr(getLoginUser().getUserId());
			bean.setXgsj(new Date());
			//重置
			int style = data.getYhzt();
			style |= UserStatus.STATUS_INIT.getStatus();
			bean.setYhzt(style);
			service.updateStatus(bean);
			result.put("status", "1");
			}
		}
		response.setContentType("text/json; charset=UTF-8");
		JSONObject json = JSONObject.fromObject(result);
		response.getWriter().print(json.toString());
		return null;
	}
	
	/**
	 * 查询用户数据是否已经存在
	 * @return select
	 */
	public String queryUser() throws Exception{
		Map result = new HashMap();
		result.put("status", "0");
		String msg = null;
		if(bean != null && bean.getYhid() != null){
			TRmsUser data = service.select(bean);
			if(data != null){
				result.put("status", "2");
				result.put("message", "用户已经存在");
			}else{
				result.put("status", "1");
			}
		}
		response.setContentType("text/json; charset=UTF-8");
		JSONObject json = JSONObject.fromObject(result);
		response.getWriter().print(json.toString());
		return null;
	}
	
	
	/**
	 * 查询数据列表
	 * @return select
	 */
	public String saveOrgUser(){
		return save();
	}
	
	
	
	
	/**
	 * 数据保存，首先从数据库检测一次是否存在 ，存在调用更新，否则调用插入
	 * @return select
	 */
	public String save(){
		boolean isNew = false;
		if(bean != null){
			//设置此次更新的范围只是此用户关联的角色关系
			bean.setRolesScope(getLoginUser().getRoles());
		}
		
		TRmsUser data = service.select(bean);
		if(bean.getUid() != null && "".equals(bean.getUid().trim()) == false && data == null){
			throw new PlatformException("错误的数据格式，保存用户信息失败。");
		}
		
		
			if(data != null && data.getUid().equals(bean.getUid())){
				bean.setXgr(getLoginUser().getUserId());
				bean.setXgsj(new Date());
				if(bean.getYhmm() != null){
					bean.setYhmm(PlatUtil.encrypt(bean.getYhmm()));
				}
				service.update(bean);
			}else{
				if(data != null){
					throw new PlatformException("用户帐号信息已经存在。");
				}
				isNew = true;
				bean.setCjr(getLoginUser().getUserId());
				bean.setCjsj(new Date());
				if(bean.getYhmm() != null){
					bean.setYhmm(PlatUtil.encrypt(bean.getYhmm()));
				}
				bean.setYhzt(UserStatus.STATUS_INIT.getStatus());
				service.insert(bean);
			}
		return FORWARD_SAVEOK;
	}
	
	public String manage(){
		
		return "manage";
	}
	/**
	 * 删除数据
	 * @return select
	 */
	public String delete() throws Exception{
		Map result = new HashMap();
		result.put("status", "0");
		if(bean != null ){
			boolean checkResult = true;
//程序是否需要对此数据进行数据检验,如果是请开启此部分的数据检验			
//			for(int i = 0 ; i < idArrs.length ; i++){
//					//是否有对应的数据存在
//					int rows = Integer.valueOf(((Map)service.get2Object("查询数据的行数", bean)).get("CNUM").toString());
//					if(rows > 0){
//						checkResult = false;
//						break;
//					}
//			}	
			if(checkResult == true){
				try{
					 service.delete(bean);;
					result.put("status", "1");
				}catch(Exception e){
					result.put("status", "2");
					e.printStackTrace();
					result.put("message", "已经存在相关联的数据，请先删除");
				}
			}else{
				result.put("status", "2");
				result.put("message", "已经存在相关联的数据，请先删除");
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
	 * 获取单位下的专业
	 * @throws Exception
	 */
	public void getMajor() throws Exception {
		ResultMap result = new ResultMap();
		if(majorBean.getOrganizationid() != null){
			majorDatas = majorService.listByDwid(majorBean);
		}
		result.setObj(majorDatas);
		response.setContentType("text/json; charset=UTF-8");
		response.getWriter().print(result.getJsonStr());
	}
	
	@Autowired
	public void setService(TRmsUserService service) {
		this.service = service;
	}
	
	@Autowired
	public void setDeptService(TRmsDeptmentService deptService) {
		this.deptService = deptService;
	}

	public TRmsUser getBean() {
		return bean;
	}

	public void setBean(TRmsUser bean) {
		this.bean = bean;
	}

	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}

	public QasDMajor getMajorBean() {
		return majorBean;
	}

	public void setMajorBean(QasDMajor majorBean) {
		this.majorBean = majorBean;
	}

}
