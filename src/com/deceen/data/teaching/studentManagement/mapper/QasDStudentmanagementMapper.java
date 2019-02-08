package	com.deceen.data.teaching.studentManagement.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.teaching.studentManagement.model.QasDStudentmanagement;

@Component("qasDStudentmanagementMapper")
public interface QasDStudentmanagementMapper {

	QasDStudentmanagement select(Object id);
	
	int insert(QasDStudentmanagement bean);
	
	int update(QasDStudentmanagement bean);
	 /*需要时请开启,动态进行更新*/
	int updateWithDyna(QasDStudentmanagement bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDStudentmanagement bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

