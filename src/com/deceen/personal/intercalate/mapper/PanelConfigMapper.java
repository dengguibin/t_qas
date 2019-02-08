package com.deceen.personal.intercalate.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.deceen.indicator.indicatorcatalog.model.QasTIndicatorcatalog;
import com.deceen.personal.intercalate.bean.EarlyWarning;

@Component("panelConfigMapper")
public interface PanelConfigMapper {

	/**
	 * 加载指标树形结构
	 * @param vague
	 * @return
	 */
	List<QasTIndicatorcatalog> intercalateIsMonitorTree(@Param("vague")Object vague);
	
	
	/**
	 * 根据指标id,当前用户 查询是否存在监视记录
	 * @param indicatorid
	 * @param userid
	 * @return
	 */
	EarlyWarning selectEarlyWarning(@Param("indicatorid")Object indicatorid
			,@Param("userid")Object userid);
	
	/**
	 * 新增监视记录表
	 * @param earlyWarning
	 * @return
	 */
	int insertEarlyWarning(EarlyWarning earlyWarning);
	
	/**
	 * 根据指标id，当前用户id修改监视记录表
	 * @param earlyWarning
	 * @return
	 */
	int updateByIndicatorid(EarlyWarning earlyWarning);
	
	/**
	 * 根据指标id，当前用户id删除监视记录表
	 * @param earlyWarning
	 * @return
	 */
	int delect(EarlyWarning earlyWarning);
	
	
	/**
	 * 获取树形结构各层的总数
	 */
	List<Map<String, Object>> intercalatecount(@Param("vague")Object vague);
}
