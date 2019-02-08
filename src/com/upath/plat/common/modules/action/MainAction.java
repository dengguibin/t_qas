package com.upath.plat.common.modules.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.deceen.diagnoseformat.task.model.QasTDiagnosetask;
import com.deceen.diagnoseformat.task.service.QasTDiagnosetaskService;
import com.deceen.diagnosereport.analy.model.QasTDiagnosticreport;
import com.deceen.diagnosereport.analy.service.QasTDiagnosticreportService;
import com.deceen.diagnosereport.reveal.service.QasTDiagnosticmenuinfoService;
import com.upath.plat.auth.facade.IMenu;
import com.upath.plat.auth.facade.IUser;
import com.upath.plat.auth.model.TRmsMenuinfo;
import com.upath.plat.common.PlatConstant.UserStatus;
import com.upath.plat.common.action.BaseActionSupport;
import com.upath.plat.common.util.RequestHelper;
import com.upath.plat.common.util.SystemConfig;
import com.upath.plat.common.util.VTree;

/**
 * @author upaths
 * version 1.0.0
 * create date :2012-11-6 
 * modify time
 */
@Scope("prototype")
@Component("mainAction")
@SuppressWarnings({ "rawtypes", "serial", "unchecked", "unused" })
public class MainAction extends BaseActionSupport{
	
	private static final Logger log = Logger.getLogger(MainAction.class);

	/**操作实体*/
	private TRmsMenuinfo bean;
	
	@Autowired
	private QasTDiagnosticmenuinfoService diagnosticmenuinfoService;
	
	private static Map systemInfo = null;
	
	@Autowired
	private  QasTDiagnosetaskService diagnosetaskService;
	
	@Autowired
	private  QasTDiagnosticreportService diagnosticreportService;
	
	private String  taskId;//诊断任务id
	
	private String  datetime;//诊断时间
	
	private String  objId;//诊断对象id
	
	private String  taskName;//诊断任务名称
	
	private String  datetimeId;//诊断时间id
	
	private String  objName;//诊断对象名称
	
	private QasTDiagnosticreport diagnosticreport;
	
	private List<Map<String,Object>>  datas;
	
	private List<Map<String,Object>> listTime;
	
	private List<Map<String,Object>> listObj;
	
	/**
	 * 页面前台的配置信息
	 */
	static{
		systemInfo = new HashMap();
		systemInfo.put("SYSTEM_BUILD_UNIT", SystemConfig.SYSTEM_BUILD_UNIT);
		systemInfo.put("SYSTEM_BUILD_UNIT_SITEINFO", SystemConfig.SYSTEM_BUILD_UNIT_SITEINFO);
		systemInfo.put("SYSTEM_TECHNICAL_SUPPORT", SystemConfig.SYSTEM_TECHNICAL_SUPPORT);
		systemInfo.put("SYSTEM_TECHNICAL_SUPPORT_SITEINFO", SystemConfig.SYSTEM_TECHNICAL_SUPPORT_SITEINFO);
	}
	
	public String execute() throws Exception {
		IUser user = RequestHelper.getInstance().getLoginUser();
		request.setAttribute("configs", systemInfo);
		Map<String,String> map=new HashMap<String,String>();
		
		if(SystemConfig.ANALY_MENUID.equals(menuId)){
			/**查询诊断分析查询左侧栏的列表信息的参数**/
			//组装参数(else中的都是给默认值)
			if(taskId!=null && taskId!=""){
				System.out.println("taskId是："+taskId);
				System.out.println("datetime是："+datetime);
				System.out.println("objId是："+objId);
				System.out.println("taskName是："+taskName);
				System.out.println("datetimeId是："+datetimeId);
				System.out.println("objName是："+objName);
				map.put("taskId", taskId);
			}else{
				datas=diagnosticreportService.selectDiagnosetaskId();
				if(datas!=null&&!datas.isEmpty()&&datas.size()>0){
					taskId=(String) datas.get(0).get("DIAGNOSETASKID");
					System.out.println("查出来的taskId是："+taskId);
					map.put("taskId",taskId );//取第一个默认值(根据诊断时间降序排列)
				}
			}
			
			if(datetime!=null && datetime!=""){
				map.put("datetime", datetime);
			}else{
				if(datas!=null&&!datas.isEmpty()&&datas.size()>0){
					datetime=(String) datas.get(0).get("DIAGNOSEDATATIME");
					System.out.println("查出来的datetime是："+datetime);
					map.put("datetime", datetime);//取第一个默认值
				}
			}
			
			if(objId!=null && objId!=""){
				map.put("objId", objId);
			}else{
				listObj = new ArrayList<Map<String,Object>>();
				diagnosticreport=new QasTDiagnosticreport();
				if(datas!=null&&!datas.isEmpty()&&datas.size()>0){
					diagnosticreport.setDiagnosetaskid((String) datas.get(0).get("DIAGNOSETASKID"));
				}else{
					diagnosticreport.setDiagnosetaskid(null);
				}
				listObj = diagnosticreportService.selectDisgnoseObjByTaskId(diagnosticreport);
				if(listObj!=null&&!listObj.isEmpty()&&listObj.size()>0){
					objId=(String)listObj.get(0).get("ID");
					System.out.println("查出来的objId是："+objId);
					map.put("objId",objId);//取第一个默认值
				}
			}
			//到时候要在sql中通过这三个参数将诊断中介的id查出来
			/**查询诊断分析查询左侧栏的列表信息的参数**/
		}
		
		if (user != null) {
			List<IMenu> menus = user.getMenus();
			request.setAttribute("menus", menus);
			
			if (SystemConfig.ANALY_MENUID.equals(menuId)) {	//获取诊断分析的左侧菜单.
				//根据诊断中介的id获取左侧菜单数据
				List<IMenu> menuAnaly = diagnosticmenuinfoService.menuAnaly(map);
				user.setMenuAnaly(menuAnaly);
			}
		}
		if ((user.getStatus() & UserStatus.STATUS_INIT.getStatus()) > 0) {
			// 进行初始化密码的操作
			return "toModify";
		}
		return super.execute();
	}
	
	public String listMenus(){
		List menus = new ArrayList();
		IUser loginUser = getLoginUser();
		if(loginUser != null){
			List<IMenu> allMenus = loginUser.getMenus();
			if(allMenus != null && bean != null && bean.getCdid() != null){
				/**
				 * 加载此菜单节点，及其所有的子节点,包括子节点的有所子节点
				 */
				IMenu rootMenu = null;
				for(IMenu menu : allMenus){
					if(bean.getCdid() == menu.getMenuId()){
						rootMenu = menu;
						break;
					}
				}
				if(rootMenu != null){
					menus.add(rootMenu);
					for(IMenu menu : allMenus){
						if(menu.isDescendants(rootMenu) == true){
							menus.add(menu);
						}
					}
				}
			}else{
				menus.addAll(allMenus);
			}
		}
		if(menus != null){
			JsonConfig config = new JsonConfig();
			config.setExcludes(new String[]{"children","parent","page","url"});
			VTree tree;
			try {
				tree = VTree.buildVTree(menus, "cdid", "pcdid", null);
				List objs = tree.asMapDataList();
				JSONArray arr = JSONArray.fromObject(objs,config);
				try {
					response.getWriter().print(arr.toString());
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			} 	
		}
		return null;
	}

	public TRmsMenuinfo getBean() {
		return bean;
	}

	public void setBean(TRmsMenuinfo bean) {
		this.bean = bean;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getObjId() {
		return objId;
	}

	public void setObjId(String objId) {
		this.objId = objId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getObjName() {
		return objName;
	}

	public void setObjName(String objName) {
		this.objName = objName;
	}

	public String getDatetimeId() {
		return datetimeId;
	}

	public void setDatetimeId(String datetimeId) {
		this.datetimeId = datetimeId;
	}

	public List<Map<String, Object>> getListTime() {
		return listTime;
	}

	public void setListTime(List<Map<String, Object>> listTime) {
		this.listTime = listTime;
	}
	
}
