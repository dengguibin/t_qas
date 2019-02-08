/**
*/
package	com.deceen.system.majordirection.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.system.majordirection.model.QasDMajordirection;

@Component("qasDMajordirectionMapper")
@SuppressWarnings({ "rawtypes" })
public interface QasDMajordirectionMapper {

	QasDMajordirection select(Object id);
	
	int insert(QasDMajordirection bean);
	
	int update(QasDMajordirection bean);

	int updateWithDyna(QasDMajordirection bean);

	List  list(QasDMajordirection bean);
	
	int delete(Object id);
	
}

