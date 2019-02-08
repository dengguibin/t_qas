package	com.deceen.data.teacher.lessonsOfTeacher.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.teacher.lessonsOfTeacher.model.QasDLessonsofteacher;

@Component("qasDLessonsofteacherMapper")
public interface QasDLessonsofteacherMapper {

	QasDLessonsofteacher select(Object id);
	
	int insert(QasDLessonsofteacher bean);
	
	int update(QasDLessonsofteacher bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDLessonsofteacher bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDLessonsofteacher bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

