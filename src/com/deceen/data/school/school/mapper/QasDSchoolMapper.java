package	com.deceen.data.school.school.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.school.school.model.QasDSchool;

@Component("qasDSchoolMapper")
public interface QasDSchoolMapper {

	QasDSchool select(Object id);
	
	int insert(QasDSchool bean);
	
	int update(QasDSchool bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDSchool bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDSchool bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

