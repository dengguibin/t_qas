package com.deceen.personal.monitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deceen.diagnosereport.dengguibin.loadScheme.model.IndicatorSchemeCatalog;
import com.deceen.personal.monitoring.mapper.MonitoringContentMapper;
import com.deceen.personal.monitoring.model.Monitoringcontent;

@Component("monitoringcontentService")
public class MonitoringcontentService {

	@Autowired
	private MonitoringContentMapper monitoringContentMapper;

	public MonitoringContentMapper getMonitoringContentMapper() {
		return monitoringContentMapper;
	}

	public void setMonitoringContentMapper(
			MonitoringContentMapper monitoringContentMapper) {
		this.monitoringContentMapper = monitoringContentMapper;
	}

	// 根据用户以及是否被监视查询相关的指标(目前只查询指标名称)
	public List<Monitoringcontent> findNameBywarning(String user) {
		return monitoringContentMapper.findNameBywarning(user);
	}
	
	//根据指标id查询指标目录以及指标内容
	public IndicatorSchemeCatalog findDetailsById(String id) {
		return  monitoringContentMapper.findDetailsById(id);
	}
}
