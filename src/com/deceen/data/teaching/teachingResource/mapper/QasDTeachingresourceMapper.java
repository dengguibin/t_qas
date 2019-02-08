package	com.deceen.data.teaching.teachingResource.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.teaching.teachingResource.model.QasDTeachingresource;

@Component("qasDTeachingresourceMapper")
public interface QasDTeachingresourceMapper {

	QasDTeachingresource select(Object id);
	
	int insert(QasDTeachingresource bean);
	
	int update(QasDTeachingresource bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDTeachingresource bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDTeachingresource bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

