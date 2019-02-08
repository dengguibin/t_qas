package	com.deceen.data.teaching.teachingManagement.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.teaching.teachingManagement.model.QasDTeachingmanagement;

@Component("qasDTeachingmanagementMapper")
public interface QasDTeachingmanagementMapper {

	QasDTeachingmanagement select(Object id);
	
	int insert(QasDTeachingmanagement bean);
	
	int update(QasDTeachingmanagement bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDTeachingmanagement bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDTeachingmanagement bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

