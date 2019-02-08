package	com.deceen.data.major.cooperate.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.major.cooperate.model.QasDCooperate;

@Component("qasDCooperateMapper")
public interface QasDCooperateMapper {

	QasDCooperate select(Object id);
	
	int insert(QasDCooperate bean);
	
	int update(QasDCooperate bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDCooperate bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDCooperate bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

