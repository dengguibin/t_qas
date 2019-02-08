package	com.deceen.data.teaching.technologyInnovationCenter.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.teaching.technologyInnovationCenter.model.QasDTechnologyinnovationcenter;

@Component("qasDTechnologyinnovationcenterMapper")
public interface QasDTechnologyinnovationcenterMapper {

	QasDTechnologyinnovationcenter select(Object id);
	
	int insert(QasDTechnologyinnovationcenter bean);
	
	int update(QasDTechnologyinnovationcenter bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDTechnologyinnovationcenter bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDTechnologyinnovationcenter bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

