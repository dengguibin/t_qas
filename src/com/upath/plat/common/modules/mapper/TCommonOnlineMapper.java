/**
*/
package	com.upath.plat.common.modules.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.upath.plat.common.modules.model.TCommonOnline;

@Component("tCommonOnlineMapper")
@SuppressWarnings({ "rawtypes"})
public interface TCommonOnlineMapper {

	TCommonOnline select(TCommonOnline bean);
	
	void insert(TCommonOnline bean);
	
	void update(TCommonOnline bean);
	
	List  list(TCommonOnline bean);
	
	void delete(TCommonOnline bean);
}

