package	com.deceen.data.teacher.teacherPartTimeWork.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.teacher.teacherPartTimeWork.model.QasDTeacherparttimework;

@Component("qasDTeacherparttimeworkMapper")
public interface QasDTeacherparttimeworkMapper {

	QasDTeacherparttimework select(Object id);
	
	int insert(QasDTeacherparttimework bean);
	
	int update(QasDTeacherparttimework bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDTeacherparttimework bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDTeacherparttimework bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

