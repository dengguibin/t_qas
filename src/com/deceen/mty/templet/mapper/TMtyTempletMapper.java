package	com.deceen.mty.templet.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.mty.templet.model.TMtyTemplet;

@Component("tMtyTempletMapper")
public interface TMtyTempletMapper {

	TMtyTemplet select(Object id);
	
	int insert(TMtyTemplet bean);
	
	int update(TMtyTemplet bean);
	
	/**动态进行更新*/
	int updateWithDyna(TMtyTemplet bean);
	
	@SuppressWarnings("rawtypes")
	List  list(TMtyTemplet bean);
	
	int delete(Object id);
	
}

