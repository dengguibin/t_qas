package	com.deceen.data.school.leaderAction.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.school.leaderAction.model.QasDLeaderaction;

@Component("qasDLeaderactionMapper")
public interface QasDLeaderactionMapper {

	QasDLeaderaction select(Object id);
	
	int insert(QasDLeaderaction bean);
	
	int update(QasDLeaderaction bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDLeaderaction bean);
	
	@SuppressWarnings("rawtypes")
	List  list(Map map);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

