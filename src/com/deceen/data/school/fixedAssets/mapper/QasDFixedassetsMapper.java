package	com.deceen.data.school.fixedAssets.mapper;

import java.util.*;

import org.springframework.stereotype.Component;

import com.deceen.data.school.fixedAssets.model.QasDFixedassets;

@Component("qasDFixedassetsMapper")
public interface QasDFixedassetsMapper {

	QasDFixedassets select(Object id);
	
	int insert(QasDFixedassets bean);
	
	int update(QasDFixedassets bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDFixedassets bean);
	
	@SuppressWarnings("rawtypes")
	List  list(Map map);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

