package	com.deceen.data.teaching.scholarship.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.teaching.scholarship.model.QasDScholarship;

@Component("qasDScholarshipMapper")
public interface QasDScholarshipMapper {

	QasDScholarship select(Object id);
	
	int insert(QasDScholarship bean);
	
	int update(QasDScholarship bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDScholarship bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDScholarship bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

