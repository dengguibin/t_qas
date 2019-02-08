package com.deceen.data.base.student.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deceen.data.base.student.mapper.QasDStudentMapper;
import com.deceen.data.base.student.model.QasDStudent;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

/**
 * 
 * @ClassName: QasDStudentAction.java
 * @Description: qas_d_student
 * @author upaths@gmail.com
 * @date 2017-11-25 10:28:59
 * @version V1.0
 */
@Component("qasDStudentService")
@SuppressWarnings("rawtypes")
public class QasDStudentService extends CommonService {

	private QasDStudentMapper mapper;

	public QasDStudent select(Object id) {
		return mapper.select(id);
	}

	public int insert(QasDStudent bean) {
		bean.setId(IDGenerator.getUUID());
		bean.setCreatedtime(new Date());
		return mapper.insert(bean);
	}

	public int update(QasDStudent bean) {
		bean.setUpdatedtime(new Date());
		return mapper.update(bean);
	}

	/** 动态进行更新 */
	public int updateWithDyna(QasDStudent bean) {
		bean.setUpdatedtime(new Date());
		return mapper.updateWithDyna(bean);
	}

	/** 批量插入 */
	public int[] batchInsert(List list) {
		return batchDelete(list, QasDStudentMapper.class.getName() + ".insert");
	}

	public List list(QasDStudent bean) {
		return queryPageList(QasDStudentMapper.class.getName() + ".list", bean);
	}

	public int delete(Object id) {
		return mapper.delete(id);
	};

	public int delete(Object[] ids) {
		return mapper.batchDelete(ids);
	};

	public QasDStudentMapper getMapper() {
		return mapper;
	}

	@Autowired
	public void setMapper(QasDStudentMapper mapper) {
		this.mapper = mapper;
	}

	public Class getMapperClass() {
		return QasDStudentMapper.class;
	}
}
