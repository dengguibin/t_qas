package	com.deceen.data.major.recruit.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.major.recruit.model.QasDRecruit;

@Component("qasDRecruitMapper")
public interface QasDRecruitMapper {

	QasDRecruit select(Object id);
	
	int insert(QasDRecruit bean);
	
	int update(QasDRecruit bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDRecruit bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDRecruit bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

