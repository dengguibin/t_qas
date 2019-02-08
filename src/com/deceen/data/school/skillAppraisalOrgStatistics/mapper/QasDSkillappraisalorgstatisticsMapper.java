package	com.deceen.data.school.skillAppraisalOrgStatistics.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.school.skillAppraisalOrgStatistics.model.QasDSkillappraisalorgstatistics;

@Component("qasDSkillappraisalorgstatisticsMapper")
public interface QasDSkillappraisalorgstatisticsMapper {

	QasDSkillappraisalorgstatistics select(Object id);
	
	int insert(QasDSkillappraisalorgstatistics bean);
	
	int update(QasDSkillappraisalorgstatistics bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDSkillappraisalorgstatistics bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDSkillappraisalorgstatistics bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

