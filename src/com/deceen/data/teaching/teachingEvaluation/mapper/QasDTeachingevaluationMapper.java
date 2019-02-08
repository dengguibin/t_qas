package	com.deceen.data.teaching.teachingEvaluation.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.teaching.teachingEvaluation.model.QasDTeachingevaluation;

@Component("qasDTeachingevaluationMapper")
public interface QasDTeachingevaluationMapper {

	QasDTeachingevaluation select(Object id);
	
	int insert(QasDTeachingevaluation bean);
	
	int update(QasDTeachingevaluation bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDTeachingevaluation bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDTeachingevaluation bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

