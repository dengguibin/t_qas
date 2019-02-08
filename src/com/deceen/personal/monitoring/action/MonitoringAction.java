package com.deceen.personal.monitoring.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

import com.deceen.data.base.course.model.QasDCourse;
import com.deceen.data.base.course.service.QasDCourseService;
import com.deceen.diagnosereport.dengguibin.analy.service.DiagnoseObjService;
import com.deceen.diagnosereport.dengguibin.loadScheme.model.IndicatorSchemeCatalog;
import com.deceen.personal.monitoring.model.Monitoringcontent;
import com.deceen.personal.monitoring.model.ZtreeSelect;
import com.deceen.personal.monitoring.service.MonitoringcontentService;
import com.deceen.utils.MathUtil;
import com.deceen.utils.ResultMap;
import com.upath.plat.auth.facade.IUser;
import com.upath.plat.common.action.BaseActionSupport;
import com.upath.plat.common.util.IDGenerator;
import com.upath.plat.common.util.RequestHelper;



@Scope("prototype")
@Component("monitoringAction")
@SuppressWarnings({"serial", "unused" })
public class MonitoringAction extends BaseActionSupport {

	private static final Logger log = Logger.getLogger(MonitoringAction.class);

	private List<Monitoringcontent> findNameBywarning = new ArrayList<Monitoringcontent>();

	@Autowired
	private MonitoringcontentService monitoringcontentService;
	
	private int type;
	
	private String indicatorid;

	
	private QasDCourse bean;
	
	@Autowired
	private QasDCourseService qasDCourseService;

	private List datas;

	// 查询单条记录信息
	public String query() throws Exception {
		IUser user = RequestHelper.getInstance().getLoginUser();
		findNameBywarning = monitoringcontentService.findNameBywarning(user.getUserId());
		return FORWARD_SELECT;
	}
	
	/**
	 * 动态生成单柱状图，双柱状图数据
	 * @return
	 * @throws Exception
	 */
	public String barChart() throws Exception {
		ResultMap result = new ResultMap();
		DiagnoseObjService dobj = new DiagnoseObjService(null, null);
		//根据id查询指标目录以及指标内容
		IndicatorSchemeCatalog  Scheme = monitoringcontentService.findDetailsById(indicatorid);
		int type =Integer.parseInt(MathUtil.getMark(Scheme.getIndicatorCatalogName()));
		String monitoring = dobj.getEcharts(Scheme);
		List<ZtreeSelect> select = new ArrayList<ZtreeSelect>();
		ZtreeSelect zs1 = new ZtreeSelect();
		zs1.setId(1);
		zs1.setPid(0);
		zs1.setName("食品药品学院");
		ZtreeSelect zs2 = new ZtreeSelect();
		zs2.setId(11);
		zs2.setPid(1);
		zs2.setName("土木与建筑工程学院");
		ZtreeSelect zs3 = new ZtreeSelect();
		zs3.setId(111);
		zs3.setPid(11);
		zs3.setName("计算机应用技术");
		ZtreeSelect zs4 = new ZtreeSelect();
		zs4.setId(112);
		zs4.setPid(11);
		zs4.setName("文秘速录");
		ZtreeSelect zs5 = new ZtreeSelect();
		zs5.setId(12);
		zs5.setPid(1);
		zs5.setName("机电与汽车工程学院");
		ZtreeSelect zs6 = new ZtreeSelect();
		zs6.setId(121);
		zs6.setPid(12);
		zs6.setName("挖掘机专业");
		select.add(zs1);
		select.add(zs2);
		select.add(zs4);
		select.add(zs4);
		select.add(zs5);
		select.add(zs6);
		result.put("selectData",select);
		result.put("monitoring",monitoring);
		result.put("type",type);
		response.setContentType("text/json; charset=UTF-8");
		JSONObject json = JSONObject.fromObject(result);
		response.getWriter().print(json.toString());
		return null;
	}
	
	public String barcharChange() throws Exception{
		ResultMap result = new ResultMap();
		String data=null;
		if(type == 1) {
			 data="[{name:'201804',value:5276.0},{name:'201803',value:5674.0},{name:'201802',value:4000.0},{name:'201801',value:4678.0},{name:'201712',value:3856.0}]";
		}
		if(type == 2) {
			data="[{name:'201804',value1:624.0,value2:14978.0},{name:'201803',value1:192.0,value2:29356.0},{name:'201802',value1:96.0,value2:14678.0},{name:'201801',value1:544.0,value2:15478.0},{name:'201712',value1:608.0,value2:16178.0}]";
		}
		result.put("monitoring",data);
		response.setContentType("text/json; charset=UTF-8");
		JSONObject json = JSONObject.fromObject(result);
		response.getWriter().print(json.toString());
		return null;
	}
	
	//指标详情弹框显示
		public String details() throws Exception {
			String id = request.getParameter("id");//指标id
			String name = request.getParameter("name");//指标名称
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("id", id);
			map.put("name", name);
			request.getSession().setAttribute("detailsId", id);
			request.getSession().setAttribute("name", name);
			if (bean == null) {
				bean = new QasDCourse();
			}
			datas = qasDCourseService.list(bean);
			
			return FORWARD_LIST;
		}
		
		//指标对比
		public String detailsVs() throws Exception {
			String id = (String)request.getSession().getAttribute("detailsId");
			
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("id", id);
			
			if (bean == null) {
				bean = new QasDCourse();
			}
			datas = qasDCourseService.list(bean);
			return FORWARD_LIST;
		}

	
	public MonitoringcontentService getMonitoringcontentService() {
		return monitoringcontentService;
	}

	public void setMonitoringcontentService(
			MonitoringcontentService monitoringcontentService) {
		this.monitoringcontentService = monitoringcontentService;
	}
	
	public List<Monitoringcontent> getFindNameBywarning() {
		return findNameBywarning;
	}

	public void setFindNameBywarning(List<Monitoringcontent> findNameBywarning) {
		this.findNameBywarning = findNameBywarning;
	}
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public String getIndicatorid() {
		return indicatorid;
	}

	public void setIndicatorid(String indicatorid) {
		this.indicatorid = indicatorid;
	}

	public QasDCourse getBean() {
		return bean;
	}


	public void setBean(QasDCourse bean) {
		this.bean = bean;
	}


	public List getDatas() {
		return datas;
	}


	public void setDatas(List datas) {
		this.datas = datas;
	}
	
	


}
