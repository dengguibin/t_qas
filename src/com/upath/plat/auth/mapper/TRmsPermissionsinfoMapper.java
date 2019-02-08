/**
*/
package	com.upath.plat.auth.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.upath.plat.auth.model.TRmsPermissionsinfo;

@Component("tRmsPermissionsinfoMapper")
@SuppressWarnings({ "rawtypes" })
public interface TRmsPermissionsinfoMapper {

	TRmsPermissionsinfo select(TRmsPermissionsinfo bean);
	
	void insert(TRmsPermissionsinfo bean);
	
	void update(TRmsPermissionsinfo bean);
	
	List  list(TRmsPermissionsinfo bean);
	
	void delete(TRmsPermissionsinfo bean);
}

