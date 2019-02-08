package	com.deceen.data.school.trainingBaseOutOfCampus.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.school.trainingBaseOutOfCampus.model.QasDTrainingbaseoutofcampus;

@Component("qasDTrainingbaseoutofcampusMapper")
public interface QasDTrainingbaseoutofcampusMapper {

	QasDTrainingbaseoutofcampus select(Object id);
	
	int insert(QasDTrainingbaseoutofcampus bean);
	
	int update(QasDTrainingbaseoutofcampus bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDTrainingbaseoutofcampus bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDTrainingbaseoutofcampus bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

