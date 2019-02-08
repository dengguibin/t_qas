package	com.deceen.data.student.retiredSoldiers.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.student.retiredSoldiers.model.QasDRetiredsoldiers;

@Component("qasDRetiredsoldiersMapper")
public interface QasDRetiredsoldiersMapper {

	QasDRetiredsoldiers select(Object id);
	
	int insert(QasDRetiredsoldiers bean);
	
	int update(QasDRetiredsoldiers bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDRetiredsoldiers bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDRetiredsoldiers bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

