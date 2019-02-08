package	com.deceen.data.teaching.cooperateProject.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.teaching.cooperateProject.model.QasDCooperateproject;

@Component("qasDCooperateprojectMapper")
public interface QasDCooperateprojectMapper {

	QasDCooperateproject select(Object id);
	
	int insert(QasDCooperateproject bean);
	
	int update(QasDCooperateproject bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDCooperateproject bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDCooperateproject bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

