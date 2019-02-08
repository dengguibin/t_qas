package	com.deceen.data.student.dropoutList.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.student.dropoutList.model.QasDDropoutlist;

@Component("qasDDropoutlistMapper")
public interface QasDDropoutlistMapper {

	QasDDropoutlist select(Object id);
	
	int insert(QasDDropoutlist bean);
	
	int update(QasDDropoutlist bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDDropoutlist bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDDropoutlist bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

