package	com.deceen.data.teaching.baseInfoOfSupervisor.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.teaching.baseInfoOfSupervisor.model.QasDBaseinfoofsupervisor;

@Component("qasDBaseinfoofsupervisorMapper")
public interface QasDBaseinfoofsupervisorMapper {

	QasDBaseinfoofsupervisor select(Object id);
	
	int insert(QasDBaseinfoofsupervisor bean);
	
	int update(QasDBaseinfoofsupervisor bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDBaseinfoofsupervisor bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDBaseinfoofsupervisor bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

