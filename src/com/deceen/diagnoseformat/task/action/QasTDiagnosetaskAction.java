package com.deceen.diagnoseformat.task.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import oracle.net.aso.d;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.HttpHeaderResult;
import org.apache.tools.ant.taskdefs.condition.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import com.deceen.diagnoseformat.scheme.model.QasTDiagnosescheme;
import com.deceen.diagnoseformat.scheme.service.QasTDiagnoseschemeService;
import com.deceen.diagnoseformat.task.model.QasTDiagnosetask;
import com.deceen.diagnoseformat.task.model.QasTDiagnosetaskdates;
import com.deceen.diagnoseformat.task.model.QasTDiagnosetasklevel;
import com.deceen.diagnoseformat.task.model.QasTDiagnosetaskobj;
import com.deceen.diagnoseformat.task.service.QasTDiagnosetaskService;
import com.deceen.diagnosereport.analy.model.QasTDiagnosticreport;
import com.deceen.diagnosereport.analy.service.QasTDiagnosticreportServiceNew2;
import com.deceen.system.major.model.QasDMajor;
import com.deceen.system.major.service.QasDMajorService;
import com.deceen.system.organization.service.QasEOrganizationService;
import com.deceen.utils.ResultMap;
import com.upath.plat.auth.facade.IRole;
import com.upath.plat.auth.facade.IUser;
import com.upath.plat.auth.model.TRmsRole;
import com.upath.plat.auth.service.TRmsRoleService;
import com.upath.plat.auth.service.TRmsUserService;
import com.upath.plat.common.action.BaseActionSupport;
import com.upath.plat.common.dao.PageHelperPlug;
import com.upath.plat.common.page.Ipage;
import com.upath.plat.common.page.Page;
import com.upath.plat.common.util.IDGenerator;
import com.upath.plat.common.util.RequestHelper;
import com.upath.plat.quartz.service.TCommonSchedulingService;

/**
 * @ClassName: QasTDiagnosetaskAction.java
 * @Description: qas_t_diagnosetask
 * @author upaths@gmail.com
 * @date2017-11-20 10:19:21
 * @version V1.0
 */
@Scope("prototype")
@Component("qasTDiagnosetaskAction")
@SuppressWarnings({ "rawtypes", "serial", "unused", "unchecked" })
public class QasTDiagnosetaskAction extends BaseActionSupport {

	private static final Logger log = Logger
			.getLogger(QasTDiagnosetaskAction.class);

	private QasTDiagnosetaskService diagnosetaskService;

	private QasTDiagnoseschemeService diagnoseschemeService;

	private QasEOrganizationService QasTDiagnosetaskService;

	private QasDMajorService majorservice;

	private QasTDiagnosetask diagnosetask;

	private QasTDiagnosetaskdates diagnosetaskdates;

	private QasTDiagnosetaskobj diagnosetaskobj;

	private List<QasTDiagnosetasklevel> diagnosetasklevels;

	private List<QasTDiagnosetaskobj> diagnosetaskobjlist;

	private QasTDiagnosescheme diagnosescheme;

	@Autowired
	private TRmsRoleService rmsRoleService;
	@Autowired
	private TRmsUserService userService;
	@Autowired
	private TCommonSchedulingService tCommonSchedulingService;
	@Autowired
	private QasTDiagnosticreportServiceNew2 diagnosticreportService;

	private String idsCopy;// 装有父类id和子类对象id的数据(eg:"1,2,3,4")

	private List datas;

	private List<TRmsRole> roleList;

	private TRmsRole bean;

	// 查询单条记录信息
	@SuppressWarnings("unchecked")
	public String queryInfo() throws Exception {

		if (diagnosetask != null && diagnosetask.getId() != null
				&& "".equals(diagnosetask.getId()) == false) {
			diagnosetask = diagnosetaskService.select(diagnosetask.getId());
			diagnosetasklevels = diagnosetaskService.selectLevels(diagnosetask
					.getId());
			diagnosetaskdates = diagnosetaskService.selectDatas(diagnosetask
					.getId());
			diagnosetaskobjlist = diagnosetaskService.selectfind(diagnosetask
					.getId());
			diagnosescheme = diagnoseschemeService.select(diagnosetask
					.getSchemeid());

			/*
			 * diagnosescheme =
			 * diagnosetaskService.selectcheme(diagnosetask.getSchemeid());
			 */
			if (diagnosetaskobj == null) {
				diagnosetaskobj = new QasTDiagnosetaskobj();
			}
			String taskobj = "";
			String taskobjid = "";

			for (QasTDiagnosetaskobj objid : diagnosetaskobjlist) {
				taskobjid = objid.getDiagnoseobjid() + "," + taskobjid;
			}
			for (QasTDiagnosetaskobj obj : diagnosetaskobjlist) {
				taskobj = obj.getDiagnoseobjname() + "," + taskobj;
			}
			taskobjid = StringUtils.substringBeforeLast(taskobjid, ",");
			diagnosetaskobj.setDiagnoseobjid(taskobjid);
			taskobj = StringUtils.substringBeforeLast(taskobj, ",");
			diagnosetaskobj.setDiagnoseobjname(taskobj);
			/*
			 * diagnosescheme =
			 * diagnoseschemeService.select(diagnosetask.getSchemeid());
			 */// 查询关联模型类型
			if (diagnosescheme != null) {
				request.setAttribute("type", diagnosescheme.getRangetype());

				String idsStr = diagnosetask.getRoleid();
				if (idsStr != null) {
					String[] idsStrs = idsStr.split(",");
					List<String> ids = Arrays.asList(idsStrs);
					String jsmc = rmsRoleService.selectByIds(ids);
					request.setAttribute("jsmc", jsmc);
				} else {
					request.setAttribute("jsmc", "所有角色");
				}
			}
		}
		// 获取角色列表
		bean = new TRmsRole();
		roleList = rmsRoleService.list(bean);

		return FORWARD_SELECT;
	}

	/**
	 * 获取诊断对象
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getTree() throws Exception {
		try {
			ResultMap result = new ResultMap();
			String status = request.getParameter("status");
			String taskid = request.getParameter("taskid");
			QasTDiagnosetask gnosetask = new QasTDiagnosetask();
			if (status == null || status.equals(""))
				status = "6"; // 如果没有选模型类型，默认查询的对象是专业
			int rangeType = Integer.parseInt(status);
			gnosetask.setRangeType(rangeType);
			gnosetask.setId(taskid);
			List<QasDMajor> list = new ArrayList<QasDMajor>();
			list = diagnosetaskService.getTree(gnosetask);
			result.setObj(list);
			response.setContentType("text/json; charset=UTF-8");
			response.getWriter().print(result.getJsonStr());
		} catch (Exception e) {
			System.err.println("功能待完善");
		}
		return null;
	}

	// 查询 列表信息
	@SuppressWarnings("unchecked")
	public String queryList() throws Exception {
		if (diagnosetask == null) {
			diagnosetask = new QasTDiagnosetask();
		}

		datas = getDataForUser();
		Ipage page = null;
		try{
			page = 	RequestHelper.getInstance().getCurrentPagination();
			if(page == null ){
				page = new Page();
			}
		}catch(Exception e){
			page = new Page();
		}
		page.init();
		page.setMode(1);
		page.setRows(datas.size());
//		int pages=0;
//		if(datas.size()%10==0){
//			 pages=datas.size()/10;
//		}else{
//			 pages=datas.size()/10+1;
//		}
//		page.setPages(pages);
//		page.setCurrent(0);
		page.setPages(1);
		page.setCurrent(0);
		
		try{
			PageHelperPlug.startPage(page);
			try {
				HttpServletRequest request = 	RequestHelper.getInstance().getReuest();
				request.setAttribute("pdata", page);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}finally{
			PageHelperPlug.endPage();
		}
		return FORWARD_LIST;
	}

	// 页面跳转
	public String Professional() throws Exception {
		return FORWARD_SELECT;
	}

	// 进行更新和增加 的进入页面
	public String toEdit() throws Exception {
		// 查询一次数据信息
		queryInfo();
		return FORWARD_TOEDIT;
	}

	// 新增和动态更新操作
	@SuppressWarnings("unchecked")
	public String save() throws Exception {
		if (diagnosetask != null) {
			// 主键记录已经存在，需要进行更新操作
			IUser user = getLoginUser();
			if (diagnosetask.getId() != null
					&& "".equals(diagnosetask.getId()) == false) {
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasTDiagnosetask dsBean = diagnosetaskService
						.select(diagnosetask.getId());
				if (dsBean != null) {
					// 如果数据库中有此记录信息，进行更新操作
					// int rows = service.update(bean);
					diagnosetask.setUpdatedby(user.getUserId());
					diagnosetask.setUpdatedtime(new Date());
					diagnosetaskService.updateWithDyna(diagnosetask,
							diagnosetasklevels, diagnosetaskdates,
							diagnosetaskobj);
				} else {
					// 是否需要输出数据不存在的异常
				}
			} else {
				if (diagnosetask.getRoleid() != null
						&& "".equals(diagnosetask.getRoleid()) == false) {
					diagnosetask.setRoleid("5001");// 无设置可视角色，默认可视角色为管理员；
				}
				diagnosetask.setCreatedby(user.getUserId());
				diagnosetask.setCreatedtime(new Date());
				diagnosetask.setUpdatedby(user.getUserId());
				diagnosetask.setUpdatedtime(new Date());
				diagnosetaskService.insert(diagnosetask, diagnosetasklevels,
						diagnosetaskdates, diagnosetaskobj);
			}

		}
		return FORWARD_SAVE;
	}

	public QasTDiagnosetaskobj getDiagnosetaskobj() {
		return diagnosetaskobj;
	}

	public void setDiagnosetaskobj(QasTDiagnosetaskobj diagnosetaskobj) {
		this.diagnosetaskobj = diagnosetaskobj;
	}

	// 新增和动态更新操作
	public String toPublish() throws Exception {
		if (diagnosetask != null) {
			// 主键记录已经存在，需要进行更新操作
			IUser user = getLoginUser();
			if (diagnosetask.getId() != null
					&& "".equals(diagnosetask.getId()) == false) {
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasTDiagnosetask dsBean = diagnosetaskService
						.select(diagnosetask.getId());
				if (dsBean != null) {
					// 如果数据库中有此记录信息，进行更新操作
					// int rows = service.update(bean);
					diagnosetask.setUpdatedby(user.getUserId());
					diagnosetask.setSchemeid(dsBean.getSchemeid());
					diagnosetask.setUpdatedtime(new Date());
					diagnosetask.setPublishtime(new Date());
					diagnosetask.setPublishstatus(1);// 已发布状态
					diagnosetaskService.updateWithDyna(diagnosetask);

					// 启用任务调度；
					Map<String, Object> p1 = new HashMap<String, Object>();
					p1.put("id", (Object) diagnosetask.getId());
					p1.put("valid", 1);
					p1.put("status", 1);
					int rowsp1 = tCommonSchedulingService
							.updateQuartzStatus(p1);

				} else {
					// 是否需要输出数据不存在的异常
				}

			}

		}
		return FORWARD_LIST;
	}

	/**
	 * 删除方法，如果ID 上是以","隔开的字符，会认为是一个数组,批量删除数据
	 */
	public String remove() throws Exception {
		ResultMap result = new ResultMap();
		if (diagnosetask != null && diagnosetask.getId() != null) {
			// String idArrs[] = diagnosetask.getId().split("[,]");
			boolean checkResult = true;
			// 程序是否需要对此数据进行数据检验,如果是请开启此部分的数据检验
			// for(int i = 0 ; i < idArrs.length ; i++){
			// //是否有对应的数据存在
			// int rows = Integer.valueOf(((Map)service.get2Object("查询数据的行数",
			// bean)).get("CNUM").toString());
			// if(rows > 0){
			// checkResult = false;
			// break;
			// }
			// }
			if (checkResult == true) {
				try {
					int rows = diagnosetaskService.delete((Object) diagnosetask
							.getId());
					// 删除相对应的任务关联的诊断对象；
					int rowObj = diagnosetaskService
							.deleteTaskObj((Object) diagnosetask.getId());
				} catch (Exception e) {
					e.printStackTrace();
					result.put("message", e.getMessage());
				}
			} else {
				result.setSuccess(false);
				result.setMsg("已经存在相关联的数据，请先删除");
			}
		} else {
			result.put("message", "错误参数");
		}

		response.setContentType("text/json; charset=UTF-8");
		response.getWriter().print(result.getJsonStr());
		return null;
	}

	/**
	 * 修改任务状态同时与定时任务统一状态
	 */
	public String updateStatus() throws Exception {
		ResultMap result = new ResultMap();

		HttpServletRequest request = ServletActionContext.getRequest();
		String statusStr = request.getParameter("status");// 要修改的状态
		int status = Integer.valueOf(statusStr);

		if (diagnosetask != null && diagnosetask.getId() != null) {

			boolean checkResult = true;
			if (checkResult == true) {
				try {
					Map<String, Object> params = new HashMap<String, Object>();
					params.put("id", (Object) diagnosetask.getId());
					params.put("status", status);

					int rows = diagnosetaskService.updateStatus(params);
					// 状态已发布后，可能会有（停止，继续，结束）3种状态，考虑任务调度；
					if (status != 0) {// 未发布0，其余状态分别是停止2，继续1，结束3
						Map<String, Object> p1 = new HashMap<String, Object>();

						if (status == 1) {// 将调度的任务继续开启
							p1.put("id", (Object) diagnosetask.getId());
							p1.put("valid", 1);
							p1.put("status", 1);
							int rowsp1 = tCommonSchedulingService
									.updateQuartzStatus(p1);

						} else {// 停用任务调度
							p1.put("id", (Object) diagnosetask.getId());
							p1.put("valid", 0);
							p1.put("status", 0);
							int rowsp1 = tCommonSchedulingService
									.updateQuartzStatus(p1);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					result.put("message", e.getMessage());
				}
			} else {
				result.setSuccess(false);
				result.setMsg("执行错误，请联系管理员");
			}
		} else {
			result.put("message", "错误参数");
		}
		response.setContentType("text/json; charset=UTF-8");
		response.getWriter().print(result.getJsonStr());
		return null;
	}

	public QasTDiagnosetaskService getDiagnosetaskService() {
		return diagnosetaskService;
	}

	@Autowired
	public void setDiagnosetaskService(
			QasTDiagnosetaskService diagnosetaskService) {
		this.diagnosetaskService = diagnosetaskService;
	}

	public QasTDiagnoseschemeService getDiagnoseschemeService() {
		return diagnoseschemeService;
	}

	@Autowired
	public void setDiagnoseschemeService(
			QasTDiagnoseschemeService diagnoseschemeService) {
		this.diagnoseschemeService = diagnoseschemeService;
	}

	public QasTDiagnosetask getDiagnosetask() {
		return diagnosetask;
	}

	public void setDiagnosetask(QasTDiagnosetask diagnosetask) {
		this.diagnosetask = diagnosetask;
	}

	public List getDiagnosetasklevels() {
		return diagnosetasklevels;
	}

	public void setDiagnosetasklevels(
			List<QasTDiagnosetasklevel> diagnosetasklevels) {
		this.diagnosetasklevels = diagnosetasklevels;
	}

	public QasTDiagnosetaskdates getDiagnosetaskdates() {
		return diagnosetaskdates;
	}

	public void setDiagnosetaskdates(QasTDiagnosetaskdates diagnosetaskdates) {
		this.diagnosetaskdates = diagnosetaskdates;
	}

	public QasTDiagnosetask getBean() {
		return diagnosetask;
	}

	public void setBean(QasTDiagnosetask bean) {
		this.diagnosetask = bean;
	}

	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}

	// 返回json数据额
	@SuppressWarnings("unchecked")
	public String toList() throws Exception {
		ResultMap result = new ResultMap();
		if (diagnosetask == null) {
			diagnosetask = new QasTDiagnosetask();
		}
		List<QasTDiagnosetask> datas2 = new ArrayList<QasTDiagnosetask>();
		datas2 = getZdfx();
		result.setObj(datas2);
		response.setContentType("text/json; charset=UTF-8");
		response.getWriter().print(result.getJsonStr());
		return null;
	}

	public List<QasTDiagnosetaskobj> getDiagnosetaskobjlist() {
		return diagnosetaskobjlist;
	}

	public void setDiagnosetaskobjlist(
			List<QasTDiagnosetaskobj> diagnosetaskobjlist) {
		this.diagnosetaskobjlist = diagnosetaskobjlist;
	}

	public QasTDiagnosescheme getDiagnosescheme() {
		return diagnosescheme;
	}

	public void setDiagnosescheme(QasTDiagnosescheme diagnosescheme) {
		this.diagnosescheme = diagnosescheme;
	}

	public String getIdsCopy() {
		return idsCopy;
	}

	public void setIdsCopy(String idsCopy) {
		this.idsCopy = idsCopy;
	}

	public List<TRmsRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<TRmsRole> roleList) {
		this.roleList = roleList;
	}

	public void setBean(TRmsRole bean) {
		this.bean = bean;
	}

	public String excuteAnaly() throws Exception {
		ResultMap result = new ResultMap();
		result.setMsg("诊断成功");
		String taskId = request.getParameter("taskId");
		String objId = request.getParameter("objId");
		if (taskId == null || taskId == "") {
			return null;
		}
		IUser user = getLoginUser();
		// 生成诊断报告
		QasTDiagnosticreport diagnosticreport = new QasTDiagnosticreport();
		diagnosticreport.setId(IDGenerator.getUUID());
		diagnosticreport.setDiagnosetaskid(taskId);
		diagnosticreport.setDiagnoseway(1);// 手动诊断方式1，自动诊断方式2
		diagnosticreport.setCreatedby(user.getUserId());
		diagnosticreport.setCreatedtime(new Date());
		diagnosticreport
				.setDiagnosedatatime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.format(diagnosticreport.getCreatedtime()));
		boolean b = false;
		int s = 0;
		diagnosetaskobjlist = diagnosetaskService
				.selectByTaskIdToStatus(taskId);
		if (diagnosetaskobjlist != null) {
			s = diagnosetaskobjlist.size();
		}
		if (s == 0) {
			result.setSuccess(false);
			result.setMsg("请选择*已发布*任务进行诊断！！！");

		} else {
			try {
				/*
				 * private QasTDiagnosticreportServiceNew
				 * diagnosticreportService; private QasTDiagnosticreportService
				 * diagnosticreportService;
				 */
				b = diagnosticreportService.excuteAnaly(diagnosticreport, null);

				if (diagnosetaskobjlist != null) {
					s = diagnosetaskobjlist.size();
				}

			} catch (Exception e) {
				result.setSuccess(false);
				result.setMsg("诊断过程出现异常！请联系管理员");
				e.printStackTrace();
			}
			if (!b) {
				result.setSuccess(false);
				result.setMsg("诊断过程出现异常！请联系管理员");
			}

		}
		response.setContentType("text/json; charset=UTF-8");
		response.getWriter().print(result.getJsonStr());
		return null;
	}

	@SuppressWarnings("unchecked")
	public List getDataForUser() {

		IUser user = getLoginUser();
		List<IRole> roles = user.getRoles();
		datas = new ArrayList<QasTDiagnosetask>();
		List<String> roleIds = new ArrayList<String>();
		for (int i = 0; i < roles.size(); i++) {
			roleIds.add(roles.get(i).getRoleId());
		}
		if (roleIds.contains("5001")) {
			datas = diagnosetaskService.listNoPage(diagnosetask);
		} else {
			for (int i = 0; i < roles.size(); i++) {
				if ("5018".equals(roles.get(i).getRoleId())) {// 老师角色
					List<QasTDiagnosetask> datas1 = new ArrayList<QasTDiagnosetask>();
					String zyid = userService.selectById(user.getUserId());
					List<String> zyidList = new ArrayList<String>();
					// 将字符串数组转换成集合list
					if (zyid != null && "".equals(zyid) == false) {
						zyidList = Arrays.asList(zyid.split(","));
						diagnosetask.setRoleid(roles.get(i).getRoleId());
						datas1 = diagnosetaskService.listNoPage(diagnosetask);
						for (int j = 0; j < datas1.size(); j++) {
							Map<String, Object> map1 = new HashMap<String, Object>();
							map1 = (Map<String, Object>) datas1.get(j);
							diagnosetaskobjlist = diagnosetaskService
									.selectfind((String) map1.get("ID"));
							for (int k = 0; k < diagnosetaskobjlist.size(); k++) {
								String zy = diagnosetaskobjlist.get(k)
										.getDiagnoseobjid();
								if (zyidList.contains(zy)) {
									int status = (Integer) map1
											.get("PUBLISHSTATUS");
									if (status == 1) {
										datas.add(map1);
									}
								}
							}
						}
					}
				} else {// 非老师角色
					List<QasTDiagnosetask> datas1 = new ArrayList<QasTDiagnosetask>();
					diagnosetask.setRoleid(roles.get(i).getRoleId());
					if (i == 0) {// 第一个角色拥有的任务可视列表；
						datas1 = diagnosetaskService.listNoPage(diagnosetask);
						for (int j = 0; j < datas1.size(); j++) {
							Map<String, Object> map1 = new HashMap<String, Object>();
							map1 = (Map<String, Object>) datas1.get(j);
							datas.add(map1);
						}
					} else {
						datas1 = diagnosetaskService.listNoPage(diagnosetask);
						for (int j = 0; j < datas1.size(); j++) {
							Map<String, Object> map1 = new HashMap<String, Object>();
							map1 = (Map<String, Object>) datas1.get(j);
							String taskId1 = (String) map1.get("ID");
							List<String> ids2 = new ArrayList<String>();
							for (int j2 = 0; j2 < datas.size(); j2++) {
								Map<String, Object> map2 = new HashMap<String, Object>();
								map2 = (Map<String, Object>) datas.get(j2);
								String taskId2 = (String) map2.get("ID");
								ids2.add(taskId2);
							}
							if (!ids2.contains(taskId1)) {
								datas.add(map1);
							}
						}
					}
				}

			}
		}
		return datas;

	}

	private List<QasTDiagnosetask> getZdfx() {
		List<QasTDiagnosetask> datas2 = new ArrayList<QasTDiagnosetask>();
		List<QasTDiagnosetask> datas1 = new ArrayList<QasTDiagnosetask>();
		// 获取当前登录角色
		IUser user = getLoginUser();
		List<IRole> roles = user.getRoles();
		datas = new ArrayList<QasTDiagnosetask>();
		List<String> roleIds = new ArrayList<String>();
		for (int i = 0; i < roles.size(); i++) {
			roleIds.add(roles.get(i).getRoleId());
		}

		if (roleIds.contains("5001")) {
			diagnosetask.setPublishstatus(1);
			datas2 = diagnosetaskService.selectPublishTask(diagnosetask);
		} else {// 非管理员
			for (int i = 0; i < roles.size(); i++) {
				if ("5018".equals(roles.get(i).getRoleId())) {// 老师角色
					datas1 = new ArrayList<QasTDiagnosetask>();
					String zyid = userService.selectById(user.getUserId());
					List<String> zyidList = new ArrayList<String>();
					// 将字符串数组转换成集合list
					if (zyid != null && "".equals(zyid) == false) {
						zyidList = Arrays.asList(zyid.split(","));
						diagnosetask.setRoleid(roles.get(i).getRoleId());
						datas1 = diagnosetaskService.list(diagnosetask);
						for (int j = 0; j < datas1.size(); j++) {
							Map<String, Object> map1 = new HashMap<String, Object>();
							map1 = (Map<String, Object>) datas1.get(j);
							diagnosetaskobjlist = diagnosetaskService
									.selectfind((String) map1.get("ID"));
							for (int k = 0; k < diagnosetaskobjlist.size(); k++) {
								if (zyidList.contains(diagnosetaskobjlist
										.get(k).getDiagnoseobjid())) {
									int status = (Integer) map1
											.get("PUBLISHSTATUS");
									if (status == 1) {
										datas.add(map1);
									}
								}
							}
						}
					}
				} else {// 非老师角色
					datas1 = new ArrayList<QasTDiagnosetask>();
					diagnosetask.setRoleid(roles.get(i).getRoleId());
					if (i == 0) {// 第一个角色拥有的任务可视列表；
						datas1 = diagnosetaskService.list(diagnosetask);
						for (int j = 0; j < datas1.size(); j++) {
							Map<String, Object> map1 = new HashMap<String, Object>();
							map1 = (Map<String, Object>) datas1.get(j);
							datas.add(map1);
						}
					} else {
						datas1 = diagnosetaskService.list(diagnosetask);
						for (int j = 0; j < datas1.size(); j++) {
							Map<String, Object> map1 = new HashMap<String, Object>();
							map1 = (Map<String, Object>) datas1.get(j);
							String taskId1 = (String) map1.get("ID");
							List<String> ids2 = new ArrayList<String>();
							for (int j2 = 0; j2 < datas.size(); j2++) {
								Map<String, Object> map2 = new HashMap<String, Object>();
								map2 = (Map<String, Object>) datas.get(j2);
								String taskId2 = (String) map2.get("ID");
								ids2.add(taskId2);
							}
							if (!ids2.contains(taskId1)) {
								datas.add(map1);
							}

						}
					}

				}

			}
			diagnosetask.setPublishstatus(1);
			datas1 = diagnosetaskService.selectPublishTask(diagnosetask);

			for (int l = 0; l < datas1.size(); l++) {
				String id1 = datas1.get(l).getId();
				for (int j = 0; j < datas.size(); j++) {
					Map<String, Object> map2 = (Map<String, Object>) datas
							.get(j);
					String id2 = (String) map2.get("ID");
					if (id1.equals(id2)) {
						int publishstatus = (Integer) map2.get("PUBLISHSTATUS");
						if (publishstatus == 1) {
							datas2.add(datas1.get(l));
						}
					}

				}

			}
		}
		return datas2;
	}

}
