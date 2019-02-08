package	com.deceen.data.teaching.baseInfoOfTeachingResearcher.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.teaching.baseInfoOfTeachingResearcher.model.QasDBaseinfoofteachingresearcher;

@Component("qasDBaseinfoofteachingresearcherMapper")
public interface QasDBaseinfoofteachingresearcherMapper {

	QasDBaseinfoofteachingresearcher select(Object id);
	
	int insert(QasDBaseinfoofteachingresearcher bean);
	
	int update(QasDBaseinfoofteachingresearcher bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDBaseinfoofteachingresearcher bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDBaseinfoofteachingresearcher bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

