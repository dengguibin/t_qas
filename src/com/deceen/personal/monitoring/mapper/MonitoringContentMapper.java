package com.deceen.personal.monitoring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.deceen.diagnosereport.dengguibin.loadScheme.model.IndicatorSchemeCatalog;
import com.deceen.personal.monitoring.model.Monitoringcontent;


public interface MonitoringContentMapper {
	// 根据用户以及是否被监视查询相关的指标(目前只查询指标名称)
	List<Monitoringcontent> findNameBywarning(@Param("user") String user);
	
	//根据指标id查询指标目录以及指标内容
	IndicatorSchemeCatalog findDetailsById(@Param("id")String id);
}
