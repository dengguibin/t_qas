package	com.deceen.data.school.trainingBaseOutOfCampusStatistics.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.school.trainingBaseOutOfCampusStatistics.model.QasDTrainingbaseoutofcampusstatistics;

@Component("qasDTrainingbaseoutofcampusstatisticsMapper")
public interface QasDTrainingbaseoutofcampusstatisticsMapper {

	QasDTrainingbaseoutofcampusstatistics select(Object id);
	
	int insert(QasDTrainingbaseoutofcampusstatistics bean);
	
	int update(QasDTrainingbaseoutofcampusstatistics bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDTrainingbaseoutofcampusstatistics bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDTrainingbaseoutofcampusstatistics bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

