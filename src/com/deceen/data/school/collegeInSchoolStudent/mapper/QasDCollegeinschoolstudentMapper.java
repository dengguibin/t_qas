package	com.deceen.data.school.collegeInSchoolStudent.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.school.collegeInSchoolStudent.model.QasDCollegeinschoolstudent;

@Component("qasDCollegeinschoolstudentMapper")
public interface QasDCollegeinschoolstudentMapper {

	QasDCollegeinschoolstudent select(Object id);
	
	int insert(QasDCollegeinschoolstudent bean);
	
	int update(QasDCollegeinschoolstudent bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDCollegeinschoolstudent bean);
	
	@SuppressWarnings("rawtypes")
	List  list(Map map);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

