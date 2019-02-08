package	com.deceen.data.school.practiceBaseInCampus.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.school.practiceBaseInCampus.model.QasDPracticebaseincampus;

@Component("qasDPracticebaseincampusMapper")
public interface QasDPracticebaseincampusMapper {

	QasDPracticebaseincampus select(Object id);
	
	int insert(QasDPracticebaseincampus bean);
	
	int update(QasDPracticebaseincampus bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDPracticebaseincampus bean);
	
	@SuppressWarnings("rawtypes")
	List  list(Map map);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

