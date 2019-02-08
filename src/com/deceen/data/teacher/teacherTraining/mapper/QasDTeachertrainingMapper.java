package	com.deceen.data.teacher.teacherTraining.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.teacher.teacherTraining.model.QasDTeachertraining;

@Component("qasDTeachertrainingMapper")
public interface QasDTeachertrainingMapper {

	QasDTeachertraining select(Object id);
	
	int insert(QasDTeachertraining bean);
	
	int update(QasDTeachertraining bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDTeachertraining bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDTeachertraining bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

