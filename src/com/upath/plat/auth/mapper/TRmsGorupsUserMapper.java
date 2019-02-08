/**
*/
package	com.upath.plat.auth.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.upath.plat.auth.model.TRmsGorupsUser;

@Component("tRmsGorupsUserMapper")
@SuppressWarnings({ "rawtypes"})
public interface TRmsGorupsUserMapper {

	TRmsGorupsUser select(TRmsGorupsUser bean);
	
	void insert(TRmsGorupsUser bean);
	
	void update(TRmsGorupsUser bean);
	
	List  list(TRmsGorupsUser bean);
	
	void delete(TRmsGorupsUser bean);
}

