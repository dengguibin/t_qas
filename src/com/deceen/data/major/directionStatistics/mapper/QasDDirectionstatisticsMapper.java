package	com.deceen.data.major.directionStatistics.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.major.directionStatistics.model.QasDDirectionstatistics;

@Component("qasDDirectionstatisticsMapper")
public interface QasDDirectionstatisticsMapper {

	QasDDirectionstatistics select(Object id);
	
	int insert(QasDDirectionstatistics bean);
	
	int update(QasDDirectionstatistics bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDDirectionstatistics bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDDirectionstatistics bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

