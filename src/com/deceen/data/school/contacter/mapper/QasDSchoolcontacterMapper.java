package	com.deceen.data.school.contacter.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.school.contacter.model.QasDSchoolcontacter;

@Component("qasDSchoolcontacterMapper")
public interface QasDSchoolcontacterMapper {

	QasDSchoolcontacter select(Object id);
	
	int insert(QasDSchoolcontacter bean);
	
	int update(QasDSchoolcontacter bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDSchoolcontacter bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDSchoolcontacter bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

