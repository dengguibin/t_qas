package com.deceen.data.major.cooperate.service;

import java.util.*;
import com.deceen.data.major.cooperate.model.QasDCooperate;
import com.deceen.data.major.cooperate.mapper.QasDCooperateMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName: QasDCooperateAction.java
 * @Description: qas_d_cooperate
 * @author upaths@gmail.com
 * @date 2017-11-23 16:09:27
 * @version V1.0
 */
@Component("qasDCooperateService")
@SuppressWarnings("rawtypes")
public class QasDCooperateService extends CommonService {

	private QasDCooperateMapper mapper;

	public QasDCooperate select(Object id) {
		return mapper.select(id);
	}

	public int insert(QasDCooperate bean) {
		bean.setId(IDGenerator.getUUID());
		bean.setCreatedtime(new Date());
		return mapper.insert(bean);
	}

	public int update(QasDCooperate bean) {
		bean.setUpdatedtime(new Date());
		return mapper.update(bean);
	}

	/** 动态进行更新 */
	public int updateWithDyna(QasDCooperate bean) {
		bean.setUpdatedtime(new Date());
		return mapper.updateWithDyna(bean);
	}

	/** 批量插入 */
	public int[] batchInsert(List list) {

		return batchDelete(list, QasDCooperateMapper.class.getName()
				+ ".insert");
	}

	public List list(QasDCooperate bean) {
		return queryPageList(QasDCooperateMapper.class.getName() + ".list",
				bean);
	}

	public int delete(Object id) {
		return mapper.delete(id);
	};

	public int delete(Object[] ids) {
		return mapper.batchDelete(ids);
	};

	public QasDCooperateMapper getMapper() {
		return mapper;
	}

	@Autowired
	public void setMapper(QasDCooperateMapper mapper) {
		this.mapper = mapper;
	}

	public Class getMapperClass() {
		return QasDCooperateMapper.class;
	}
}
