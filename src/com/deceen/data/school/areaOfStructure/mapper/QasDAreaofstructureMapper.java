/**
*/
package	com.deceen.data.school.areaOfStructure.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.school.areaOfStructure.model.QasDAreaofstructure;

@Component("qasDAreaofstructureMapper")
public interface QasDAreaofstructureMapper {

	QasDAreaofstructure select(Object id);
	
	int insert(QasDAreaofstructure bean);
	
	int update(QasDAreaofstructure bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDAreaofstructure bean);
	
	@SuppressWarnings("rawtypes")
	List  list(Map map);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

