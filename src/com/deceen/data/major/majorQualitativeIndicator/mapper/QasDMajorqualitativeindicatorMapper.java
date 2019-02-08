package	com.deceen.data.major.majorQualitativeIndicator.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.major.majorQualitativeIndicator.model.QasDMajorqualitativeindicator;

@Component("qasDMajorqualitativeindicatorMapper")
public interface QasDMajorqualitativeindicatorMapper {

	QasDMajorqualitativeindicator select(Object id);
	
	int insert(QasDMajorqualitativeindicator bean);
	
	int update(QasDMajorqualitativeindicator bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDMajorqualitativeindicator bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDMajorqualitativeindicator bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

