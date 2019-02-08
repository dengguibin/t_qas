package com.deceen.data.base.course.service;

import java.util.*;

import com.deceen.data.base.course.model.QasDCourse;
import com.deceen.data.base.course.mapper.QasDCourseMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName: QasDCourseAction.java
 * @Description: qas_d_course
 * @author upaths@gmail.com
 * @date 2017-11-22 16:32:04
 * @version V1.0
 */
@Component("qasDCourseService")
@SuppressWarnings("rawtypes")
public class QasDCourseService extends CommonService {

	private QasDCourseMapper mapper;

	public QasDCourse select(Object id) {
		return mapper.select(id);
	}

	public int insert(QasDCourse bean) {
		bean.setId(IDGenerator.getUUID());
		bean.setCreatedtime(new Date());
		return mapper.insert(bean);
	}

	public int update(QasDCourse bean) {
		bean.setUpdatedtime(new Date());
		return mapper.update(bean);
	}

	/** 动态进行更新 */
	public int updateWithDyna(QasDCourse bean) {
		bean.setUpdatedtime(new Date());
		return mapper.updateWithDyna(bean);
	}

	/** 批量插入 */

	public int[] batchInsert(List list) {
		return batchDelete(list, QasDCourseMapper.class.getName() + ".insert");
	}

	public List list(QasDCourse bean) {
		return queryPageList(QasDCourseMapper.class.getName() + ".list", bean);
	}

	public int delete(Object id) {
		return mapper.delete(id);
	};

	public int delete(Object[] ids) {
		return mapper.batchDelete(ids);
	};

	public QasDCourseMapper getMapper() {
		return mapper;
	}

	@Autowired
	public void setMapper(QasDCourseMapper mapper) {
		this.mapper = mapper;
	}

	public Class getMapperClass() {
		return QasDCourseMapper.class;
	}
}
