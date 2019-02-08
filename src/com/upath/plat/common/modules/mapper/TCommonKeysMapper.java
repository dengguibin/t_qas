/**
*/
package	com.upath.plat.common.modules.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.upath.plat.common.modules.model.TCommonKeys;

@Component("tCommonKeysMapper")
@SuppressWarnings({ "rawtypes" })
public interface TCommonKeysMapper {

	TCommonKeys select(TCommonKeys bean);
	
	void insert(TCommonKeys bean);
	
	void update(TCommonKeys bean);
	
	List  list(TCommonKeys bean);
	
	void delete(TCommonKeys bean);
}

