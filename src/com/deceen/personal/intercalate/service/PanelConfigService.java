package com.deceen.personal.intercalate.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deceen.indicator.indicatorcatalog.model.QasTIndicatorcatalog;
import com.deceen.personal.intercalate.bean.EarlyWarning;
import com.deceen.personal.intercalate.mapper.PanelConfigMapper;

/**
 * 
 * 个人面板标的面板配置
 * @param 
 * @return 
 * @author dengguibin
 */
@Component("panelConfigService")	
public class PanelConfigService {

	@Autowired
	private PanelConfigMapper mapper;
	
	/**
	 * 加载所有被监控的指标节点数
	 * 
	 * 模糊查询字段
	 * @param vague
	 * @return
	 */
	public List<QasTIndicatorcatalog> intercalateIsMonitorTree(Object vague) {
		return mapper.intercalateIsMonitorTree(vague);
	}
	
	/**
	 * 根据指标id查询监视记录表
	 * @param indicatorid
	 * @return
	 */
	public EarlyWarning selectEarlyWarning(Object indicatorid,Object userid) {
		return mapper.selectEarlyWarning(indicatorid,userid);
	}
	
	/**
	 * 新增监视记录表
	 * @param earlyWarning
	 * @return
	 */
	public int insertEarlyWarning(EarlyWarning earlyWarning) {
		return mapper.insertEarlyWarning(earlyWarning);
	}
	
	/**
	 * 根据指标id,当前用户id修改监视记录表
	 * @param earlyWarning
	 * @return
	 */
	public int updateByIndicatorid(EarlyWarning earlyWarning) {
		return mapper.updateByIndicatorid(earlyWarning);
	}
	
	/**
	 * 根据指标id,当前用户id删除监视记录表
	 * @param earlyWarning
	 * @return
	 */
	public int delect(EarlyWarning earlyWarning) {
		return mapper.delect(earlyWarning);
	}
	
	/**
	 * 获取树形结构各层的总数
	 * @return
	 */
	public List<Map<String, Object>> count(Object vague) {
		return mapper.intercalatecount(vague);
	}
}
