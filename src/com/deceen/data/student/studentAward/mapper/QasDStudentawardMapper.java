package	com.deceen.data.student.studentAward.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.student.studentAward.model.QasDStudentaward;

@Component("qasDStudentawardMapper")
public interface QasDStudentawardMapper {

	QasDStudentaward select(Object id);
	
	int insert(QasDStudentaward bean);
	
	int update(QasDStudentaward bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDStudentaward bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDStudentaward bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

