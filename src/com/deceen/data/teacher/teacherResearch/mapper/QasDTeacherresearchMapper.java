package	com.deceen.data.teacher.teacherResearch.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.teacher.teacherResearch.model.QasDTeacherresearch;

@Component("qasDTeacherresearchMapper")
public interface QasDTeacherresearchMapper {

	QasDTeacherresearch select(Object id);
	
	int insert(QasDTeacherresearch bean);
	
	int update(QasDTeacherresearch bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDTeacherresearch bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDTeacherresearch bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

