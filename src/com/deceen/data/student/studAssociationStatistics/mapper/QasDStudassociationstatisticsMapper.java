package	com.deceen.data.student.studAssociationStatistics.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.student.studAssociationStatistics.model.QasDStudassociationstatistics;

@Component("qasDStudassociationstatisticsMapper")
public interface QasDStudassociationstatisticsMapper {

	QasDStudassociationstatistics select(Object id);
	
	int insert(QasDStudassociationstatistics bean);
	
	int update(QasDStudassociationstatistics bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDStudassociationstatistics bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDStudassociationstatistics bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

