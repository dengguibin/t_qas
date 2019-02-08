package	com.deceen.data.school.collegeEnrolType.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.school.collegeEnrolType.model.QasDCollegeenroltype;

@Component("qasDCollegeenroltypeMapper")
public interface QasDCollegeenroltypeMapper {

	QasDCollegeenroltype select(Object id);
	
	int insert(QasDCollegeenroltype bean);
	
	int update(QasDCollegeenroltype bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDCollegeenroltype bean);
	
	@SuppressWarnings("rawtypes")
	List  list(Map map);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

