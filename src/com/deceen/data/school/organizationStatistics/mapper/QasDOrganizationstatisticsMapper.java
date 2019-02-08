package	com.deceen.data.school.organizationStatistics.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.school.organizationStatistics.model.QasDOrganizationstatistics;

@Component("qasDOrganizationstatisticsMapper")
public interface QasDOrganizationstatisticsMapper {

	QasDOrganizationstatistics select(Object id);
	
	int insert(QasDOrganizationstatistics bean);
	
	int update(QasDOrganizationstatistics bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDOrganizationstatistics bean);
	
	@SuppressWarnings("rawtypes")
	List  list(Map map);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

