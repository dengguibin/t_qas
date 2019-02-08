package	com.deceen.data.teaching.majorSysInnovation.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.teaching.majorSysInnovation.model.QasDMajorsysinnovation;

@Component("qasDMajorsysinnovationMapper")
public interface QasDMajorsysinnovationMapper {

	QasDMajorsysinnovation select(Object id);
	
	int insert(QasDMajorsysinnovation bean);
	
	int update(QasDMajorsysinnovation bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDMajorsysinnovation bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDMajorsysinnovation bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

