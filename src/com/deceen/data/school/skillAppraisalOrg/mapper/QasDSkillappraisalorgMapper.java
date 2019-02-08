package	com.deceen.data.school.skillAppraisalOrg.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.school.skillAppraisalOrg.model.QasDSkillappraisalorg;

@Component("qasDSkillappraisalorgMapper")
public interface QasDSkillappraisalorgMapper {

	QasDSkillappraisalorg select(Object id);
	
	int insert(QasDSkillappraisalorg bean);
	
	int update(QasDSkillappraisalorg bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDSkillappraisalorg bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDSkillappraisalorg bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

