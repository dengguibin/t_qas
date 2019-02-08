package	com.deceen.data.teaching.innovationMatch.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.teaching.innovationMatch.model.QasDInnovationmatch;

@Component("qasDInnovationmatchMapper")
public interface QasDInnovationmatchMapper {

	QasDInnovationmatch select(Object id);
	
	int insert(QasDInnovationmatch bean);
	
	int update(QasDInnovationmatch bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDInnovationmatch bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDInnovationmatch bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

