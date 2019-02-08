package	com.deceen.data.teaching.innovativeTrainProj.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.teaching.innovativeTrainProj.model.QasDInnovativetrainproj;

@Component("qasDInnovativetrainprojMapper")
public interface QasDInnovativetrainprojMapper {

	QasDInnovativetrainproj select(Object id);
	
	int insert(QasDInnovativetrainproj bean);
	
	int update(QasDInnovativetrainproj bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDInnovativetrainproj bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDInnovativetrainproj bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

