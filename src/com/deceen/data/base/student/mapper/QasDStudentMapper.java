package com.deceen.data.base.student.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.base.student.model.QasDStudent;

@Component("qasDStudentMapper")
public interface QasDStudentMapper {

	QasDStudent select(Object id);

	int insert(QasDStudent bean);

	int update(QasDStudent bean);

	/** 动态进行更新 */
	int updateWithDyna(QasDStudent bean);

	@SuppressWarnings("rawtypes")
	List list(QasDStudent bean);

	int delete(Object id);

	int batchDelete(Object[] ids);

}
