package	com.deceen.data.student.skillTraining.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.student.skillTraining.model.QasDSkilltraining;

@Component("qasDSkilltrainingMapper")
public interface QasDSkilltrainingMapper {

	QasDSkilltraining select(Object id);
	
	int insert(QasDSkilltraining bean);
	
	int update(QasDSkilltraining bean);
//	 |?需要时请开启,动态进行更新
	int updateWithDyna(QasDSkilltraining bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDSkilltraining bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

