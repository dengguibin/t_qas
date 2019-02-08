package com.deceen.android.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.deceen.indicator.indicatorcatalog.mapper.QasTIndicatorcatalogMapper;
import com.deceen.indicator.indicatorcatalog.model.QasTIndicatorcatalog;

@Component("decAandroidService")
public class DecAandroidService {
	
	private QasTIndicatorcatalogMapper qasTIndicatorcatalogMapper;

	public List<QasTIndicatorcatalog> getIndicatorcatalogTypeMapper(Integer indicatortype,String parentid){
		Map<String, Object> parems = new HashMap<String, Object>();
		parems.put("indicatortype", indicatortype);
		parems.put("parentid", parentid);
		return qasTIndicatorcatalogMapper.queryParams(parems);
	}
	
	
	
	
	
	
	
	
	public QasTIndicatorcatalogMapper getQasTIndicatorcatalogMapper() {
		return qasTIndicatorcatalogMapper;
	}
	@Autowired
	public void setQasTIndicatorcatalogMapper(
			QasTIndicatorcatalogMapper qasTIndicatorcatalogMapper) {
		this.qasTIndicatorcatalogMapper = qasTIndicatorcatalogMapper;
	}

	
	
	
	
	
}
