package	com.deceen.data.school.shoolAward.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.school.shoolAward.model.QasDShoolaward;

@Component("qasDShoolawardMapper")
public interface QasDShoolawardMapper {

	QasDShoolaward select(Object id);
	
	int insert(QasDShoolaward bean);
	
	int update(QasDShoolaward bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDShoolaward bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDShoolaward bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

