package	com.deceen.data.school.practiceBaseInCampusStatistics.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.school.practiceBaseInCampusStatistics.model.QasDPracticebaseincampusstatistics;

@Component("qasDPracticebaseincampusstatisticsMapper")
public interface QasDPracticebaseincampusstatisticsMapper {

	QasDPracticebaseincampusstatistics select(Object id);
	
	int insert(QasDPracticebaseincampusstatistics bean);
	
	int update(QasDPracticebaseincampusstatistics bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDPracticebaseincampusstatistics bean);
	
	@SuppressWarnings("rawtypes")
	List  list(Map map);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

