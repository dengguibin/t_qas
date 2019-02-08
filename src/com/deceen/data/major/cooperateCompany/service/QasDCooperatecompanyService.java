package com.deceen.data.major.cooperateCompany.service;

import java.util.*;
import com.deceen.data.major.cooperateCompany.model.QasDCooperatecompany;
import com.deceen.data.major.cooperateCompany.mapper.QasDCooperatecompanyMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName: QasDCooperatecompanyAction.java
 * @Description: qas_d_cooperatecompany
 * @author upaths@gmail.com
 * @date 2017-11-23 16:08:53
 * @version V1.0
 */
@Component("qasDCooperatecompanyService")
@SuppressWarnings("rawtypes")
public class QasDCooperatecompanyService extends CommonService {

	private QasDCooperatecompanyMapper mapper;

	public QasDCooperatecompany select(Object id) {
		return mapper.select(id);
	}

	public int insert(QasDCooperatecompany bean) {
		bean.setId(IDGenerator.getUUID());
		bean.setCreatedtime(new Date());
		return mapper.insert(bean);
	}

	public int update(QasDCooperatecompany bean) {
		bean.setUpdatedtime(new Date());
		return mapper.update(bean);
	}

	/** 动态进行更新 */
	public int updateWithDyna(QasDCooperatecompany bean) {
		bean.setUpdatedtime(new Date());
		return mapper.updateWithDyna(bean);
	}

	/** 批量插入 */
	public int[] batchInsert(List list) {

		return batchDelete(list, QasDCooperatecompanyMapper.class.getName()
				+ ".insert");
	}

	public List list(QasDCooperatecompany bean) {
		return queryPageList(QasDCooperatecompanyMapper.class.getName()
				+ ".list", bean);
	}

	public int delete(Object id) {
		return mapper.delete(id);
	};

	public int delete(Object[] ids) {
		return mapper.batchDelete(ids);
	};

	public QasDCooperatecompanyMapper getMapper() {
		return mapper;
	}

	@Autowired
	public void setMapper(QasDCooperatecompanyMapper mapper) {
		this.mapper = mapper;
	}

	public Class getMapperClass() {
		return QasDCooperatecompanyMapper.class;
	}
}
