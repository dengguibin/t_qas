package	com.deceen.data.student.qualification.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.student.qualification.model.QasDQualification;

@Component("qasDQualificationMapper")
public interface QasDQualificationMapper {

	QasDQualification select(Object id);
	
	int insert(QasDQualification bean);
	
	int update(QasDQualification bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDQualification bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDQualification bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

