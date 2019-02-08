package	com.deceen.data.major.practice.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.major.practice.model.QasDPractice;

@Component("qasDPracticeMapper")
public interface QasDPracticeMapper {

	QasDPractice select(Object id);
	
	int insert(QasDPractice bean);
	
	int update(QasDPractice bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDPractice bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDPractice bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

