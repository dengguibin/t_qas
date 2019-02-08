package	com.deceen.data.student.studRegionInfo.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.student.studRegionInfo.model.QasDStudregioninfo;

@Component("qasDStudregioninfoMapper")
public interface QasDStudregioninfoMapper {

	QasDStudregioninfo select(Object id);
	
	int insert(QasDStudregioninfo bean);
	
	int update(QasDStudregioninfo bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDStudregioninfo bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDStudregioninfo bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

