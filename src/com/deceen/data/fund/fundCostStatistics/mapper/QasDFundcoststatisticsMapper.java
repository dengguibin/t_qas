package	com.deceen.data.fund.fundCostStatistics.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.fund.fundCostStatistics.model.QasDFundcoststatistics;

@Component("qasDFundcoststatisticsMapper")
public interface QasDFundcoststatisticsMapper {

	QasDFundcoststatistics select(Object id);
	
	int insert(QasDFundcoststatistics bean);
	
	int update(QasDFundcoststatistics bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDFundcoststatistics bean);
	
	@SuppressWarnings("rawtypes")
	List  list(Map map);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

