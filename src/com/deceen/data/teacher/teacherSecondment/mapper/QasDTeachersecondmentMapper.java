package	com.deceen.data.teacher.teacherSecondment.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.teacher.teacherSecondment.model.QasDTeachersecondment;

@Component("qasDTeachersecondmentMapper")
public interface QasDTeachersecondmentMapper {

	QasDTeachersecondment select(Object id);
	
	int insert(QasDTeachersecondment bean);
	
	int update(QasDTeachersecondment bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDTeachersecondment bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDTeachersecondment bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

