/**
*/
package	com.upath.plat.common.modules.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.upath.plat.common.modules.model.TCommonWorkday;

@Component("tCommonWorkdayMapper")
@SuppressWarnings({ "rawtypes"})
public interface TCommonWorkdayMapper {

	TCommonWorkday select(TCommonWorkday bean);
	
	void insert(TCommonWorkday bean);
	
	void update(TCommonWorkday bean);
	
	List  list(TCommonWorkday bean);
	
	void delete(TCommonWorkday bean);
}

