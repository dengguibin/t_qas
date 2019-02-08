package	com.deceen.data.teacher.teacherTechnicalMonopoly.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.teacher.teacherTechnicalMonopoly.model.QasDTeachertechnicalmonopoly;

@Component("qasDTeachertechnicalmonopolyMapper")
public interface QasDTeachertechnicalmonopolyMapper {

	QasDTeachertechnicalmonopoly select(Object id);
	
	int insert(QasDTeachertechnicalmonopoly bean);
	
	int update(QasDTeachertechnicalmonopoly bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDTeachertechnicalmonopoly bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDTeachertechnicalmonopoly bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

