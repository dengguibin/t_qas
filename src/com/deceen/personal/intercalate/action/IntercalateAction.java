package com.deceen.personal.intercalate.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.deceen.diagnoseformat.scheme.service.QasTSchemecatalogService;
import com.deceen.indicator.indicatorcatalog.mapper.QasTIndicatorcatalogMapper;
import com.deceen.indicator.indicatorcatalog.model.QasTIndicatorcatalog;
import com.deceen.indicator.indicatorcatalog.service.QasTIndicatorcatalogService;
import com.deceen.indicator.indicatorcontent.model.QasTIndicatorcontent;
import com.deceen.indicator.indicatorcontent.service.QasTIndicatorcontentService;
import com.deceen.personal.intercalate.bean.EarlyWarning;
import com.deceen.personal.intercalate.service.PanelConfigService;
import com.deceen.utils.ResultMap;
import com.upath.plat.auth.facade.IUser;
import com.upath.plat.common.action.BaseActionSupport;
import com.upath.plat.common.util.IDGenerator;
import com.upath.plat.common.util.RequestHelper;
import com.upath.plat.common.util.StringUtil;


/**
 * 
 * 个人面板下的过程监控
 * 
 * @param 
 * 
 * @return 
 * @author dengguibin
 */
@Scope("prototype")
@Component("intercalateAction")
@SuppressWarnings({"serial", "unused" })
public class IntercalateAction extends BaseActionSupport {

	private static final Logger log = Logger.getLogger(IntercalateAction.class);

	@Autowired
	private  PanelConfigService service;
	
	@Autowired
	private   QasTIndicatorcatalogService catalogService;
	
	@Autowired
	private  QasTIndicatorcontentService contentService;

	private String indicatorId;
	
	private EarlyWarning early;
	
	// 查询单条记录信息
	public String query() throws Exception {
		return FORWARD_SELECT;
	}

	
	public String querInfo() throws Exception {
		ResultMap result = new ResultMap(); 
		IUser user = RequestHelper.getInstance().getLoginUser();
		try {
			//根据指标id,当前用户id获取监视记录
			EarlyWarning earlywarning=service.selectEarlyWarning(indicatorId,user.getUserId());
			if(null != earlywarning && null == earlywarning.getBeMonitored()) {
				earlywarning.setBeMonitored(0);
			}
			//获取指标内容
			QasTIndicatorcontent content = contentService.selectBypersonal(indicatorId);
			result.put("content",content);
			result.put("early",earlywarning);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setMsg("参数异常！请联系管理员");
		}
		result.setSuccess(true);
		result.setMsg("操作成功");
		response.setContentType("text/json; charset=UTF-8");
		response.getWriter().print(result.getJsonStr());
		return null;
	}
	

	/**
	 * 加载指标树形结构
	 * @return
	 * @throws Exception
	 */
	public String intercalateIsMonitorTree() throws Exception {
		ResultMap result = new ResultMap();
		try {
			String key = request.getParameter("key");//指标名称(模糊查询)
			List<QasTIndicatorcatalog> list = service.intercalateIsMonitorTree(key);
			List<Map<String,Object>> count = service.count(key);
			result.setObj(list);
			result.put("count",count);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setMsg("系统异常！");
		}
		
		response.setContentType("text/json; charset=UTF-8");
		result.setMsg("操作成功");
		JSONObject json = JSONObject.fromObject(result);
		response.getWriter().print(json.toString());
		return null;
	}

	/**
	 * 修改或者新增
	 * @return
	 * @throws Exception
	 */
	public String addEarlyWarning() throws Exception {
		ResultMap result = new ResultMap(); 
		IUser user = RequestHelper.getInstance().getLoginUser();
		try {
			//根据指标id，当前用户id查询是否存在监视记录
			EarlyWarning earlywarningRecord = service.selectEarlyWarning(early.getIndicatorID(),user.getUserId());
			if(earlywarningRecord == null) {//判断监视记录表是否存在记录（不存在：监视新增）
				if(early.getBeMonitored() == 0) {
					
				}
				else if(early.getBeMonitored() == 1) {
					//获取指标创建人
					QasTIndicatorcatalog qastindicatorcatalog = catalogService.select(early.getIndicatorID());
					EarlyWarning insert = new EarlyWarning();
					insert.setIndicatorID(qastindicatorcatalog.getId());
					insert.setUserID(user.getUserId());
					insert.setWarningValueCeiling(early.getWarningValueCeiling());
					insert.setWarningValueFloor(early.getWarningValueFloor());
					insert.setBeMonitored(1);
					service.insertEarlyWarning(insert);
				}
			}
			else {		//判断监视记录表是否存在记录（存在：不监视时删除，监视修改）
				early.setUserID(earlywarningRecord.getUserID());//获取监视记录创建人
				if(early.getBeMonitored() == 0) {        //删除
					service.delect(earlywarningRecord);       
				}
				else if(early.getBeMonitored() == 1) {   //修改
					service.updateByIndicatorid(early);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		result.put("id", early.getIndicatorID());
		response.setContentType("text/json; charset=UTF-8");
		response.getWriter().print(result.getJsonStr());
		return null;	
	}
	
	public QasTIndicatorcatalogService getCatalogService() {
		return catalogService;
	}


	public void setCatalogService(QasTIndicatorcatalogService catalogService) {
		this.catalogService = catalogService;
	}

	
	public String getIndicatorId() {
		return indicatorId;
	}

	public void setIndicatorId(String indicatorId) {
		this.indicatorId = indicatorId;
	}

	public EarlyWarning getEarly() {
		return early;
	}


	public void setEarly(EarlyWarning early) {
		this.early = early;
	}
	
	public QasTIndicatorcontentService getContentService() {
		return contentService;
	}


	public void setContentService(QasTIndicatorcontentService contentService) {
		this.contentService = contentService;
	}
}
