package	com.deceen.data.major.majorCourse.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.major.majorCourse.model.QasDMajorcourse;

@Component("qasDMajorcourseMapper")
public interface QasDMajorcourseMapper {

	QasDMajorcourse select(Object id);
	
	int insert(QasDMajorcourse bean);
	
	int update(QasDMajorcourse bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDMajorcourse bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDMajorcourse bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

