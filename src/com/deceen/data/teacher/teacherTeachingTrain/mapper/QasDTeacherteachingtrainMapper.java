package	com.deceen.data.teacher.teacherTeachingTrain.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.teacher.teacherTeachingTrain.model.QasDTeacherteachingtrain;

@Component("qasDTeacherteachingtrainMapper")
public interface QasDTeacherteachingtrainMapper {

	QasDTeacherteachingtrain select(Object id);
	
	int insert(QasDTeacherteachingtrain bean);
	
	int update(QasDTeacherteachingtrain bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDTeacherteachingtrain bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDTeacherteachingtrain bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

