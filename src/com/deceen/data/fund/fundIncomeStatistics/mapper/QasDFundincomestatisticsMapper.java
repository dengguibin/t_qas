package	com.deceen.data.fund.fundIncomeStatistics.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.fund.fundIncomeStatistics.model.QasDFundincomestatistics;

@Component("qasDFundincomestatisticsMapper")
public interface QasDFundincomestatisticsMapper {

	QasDFundincomestatistics select(Object id);
	
	int insert(QasDFundincomestatistics bean);
	
	int update(QasDFundincomestatistics bean);
	/** 需要时请开启,动态进行更新*/
	int updateWithDyna(QasDFundincomestatistics bean);
	
	@SuppressWarnings("rawtypes")
	List  list(Map map);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

