package	com.deceen.data.student.studentNormal.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.student.studentNormal.model.QasDStudentnormal;

@Component("qasDStudentnormalMapper")
public interface QasDStudentnormalMapper {

	QasDStudentnormal select(Object id);
	
	int insert(QasDStudentnormal bean);
	
	int update(QasDStudentnormal bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDStudentnormal bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDStudentnormal bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

