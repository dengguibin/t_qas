package	com.deceen.data.major.courseMaterial.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.major.courseMaterial.model.QasDCoursematerial;

@Component("qasDCoursematerialMapper")
public interface QasDCoursematerialMapper {

	QasDCoursematerial select(Object id);
	
	int insert(QasDCoursematerial bean);
	
	int update(QasDCoursematerial bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDCoursematerial bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDCoursematerial bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

