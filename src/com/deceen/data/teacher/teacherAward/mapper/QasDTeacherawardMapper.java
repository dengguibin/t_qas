package	com.deceen.data.teacher.teacherAward.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.teacher.teacherAward.model.QasDTeacheraward;

@Component("qasDTeacherawardMapper")
public interface QasDTeacherawardMapper {

	QasDTeacheraward select(Object id);
	
	int insert(QasDTeacheraward bean);
	
	int update(QasDTeacheraward bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDTeacheraward bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDTeacheraward bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

