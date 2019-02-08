/**
*/
package	com.upath.plat.auth.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.upath.plat.auth.model.TRmsUserRole;

@Component("tRmsUserRoleMapper")
@SuppressWarnings({ "rawtypes" })
public interface TRmsUserRoleMapper {

	TRmsUserRole select(TRmsUserRole bean);
	
	void insert(TRmsUserRole bean);
	
	void update(TRmsUserRole bean);
	
	List  list(TRmsUserRole bean);
	
	void delete(TRmsUserRole bean);
}

