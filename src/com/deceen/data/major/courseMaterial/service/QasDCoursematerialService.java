package com.deceen.data.major.courseMaterial.service;

import java.util.*;
import com.deceen.data.major.courseMaterial.model.QasDCoursematerial;
import com.deceen.data.major.courseMaterial.mapper.QasDCoursematerialMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName: QasDCoursematerialAction.java
 * @Description: qas_d_coursematerial
 * @author upaths@gmail.com
 * @date 2017-11-23 16:07:12
 * @version V1.0
 */
@Component("qasDCoursematerialService")
@SuppressWarnings("rawtypes")
public class QasDCoursematerialService extends CommonService {

	private QasDCoursematerialMapper mapper;

	public QasDCoursematerial select(Object id) {
		return mapper.select(id);
	}

	public int insert(QasDCoursematerial bean) {
		bean.setId(IDGenerator.getUUID());
		bean.setCreatedtime(new Date());
		return mapper.insert(bean);
	}

	public int update(QasDCoursematerial bean) {
		bean.setUpdatedtime(new Date());
		return mapper.update(bean);
	}

	/** 动态进行更新 */
	public int updateWithDyna(QasDCoursematerial bean) {
		bean.setUpdatedtime(new Date());
		return mapper.updateWithDyna(bean);
	}

	/** 批量插入实现 */
	public int[] batchInsert(List list) {

		return batchDelete(list, QasDCoursematerialMapper.class.getName() + ".insert");
	}

	public List list(QasDCoursematerial bean) {
		return queryPageList(
				QasDCoursematerialMapper.class.getName() + ".list", bean);
	}

	public int delete(Object id) {
		return mapper.delete(id);
	};

	public int delete(Object[] ids) {
		return mapper.batchDelete(ids);
	};

	public QasDCoursematerialMapper getMapper() {
		return mapper;
	}

	@Autowired
	public void setMapper(QasDCoursematerialMapper mapper) {
		this.mapper = mapper;
	}

	public Class getMapperClass() {
		return QasDCoursematerialMapper.class;
	}
}
