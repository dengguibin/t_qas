package	com.deceen.data.base.course.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.base.course.model.QasDCourse;

@Component("qasDCourseMapper")
public interface QasDCourseMapper {

	QasDCourse select(Object id);
	
	int insert(QasDCourse bean);
	
	int update(QasDCourse bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDCourse bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDCourse bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

