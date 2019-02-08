package	com.deceen.data.major.majorLeader.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.major.majorLeader.model.QasDMajorleader;

@Component("qasDMajorleaderMapper")
public interface QasDMajorleaderMapper {

	QasDMajorleader select(Object id);
	
	int insert(QasDMajorleader bean);
	
	int update(QasDMajorleader bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDMajorleader bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDMajorleader bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

