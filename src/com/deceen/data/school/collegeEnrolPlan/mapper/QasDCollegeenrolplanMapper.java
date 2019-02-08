package	com.deceen.data.school.collegeEnrolPlan.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.school.collegeEnrolPlan.model.QasDCollegeenrolplan;

@Component("qasDCollegeenrolplanMapper")
public interface QasDCollegeenrolplanMapper {

	QasDCollegeenrolplan select(Object id);
	
	int insert(QasDCollegeenrolplan bean);
	
	int update(QasDCollegeenrolplan bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDCollegeenrolplan bean);
	
	@SuppressWarnings("rawtypes")
	List  list(Map map);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

