/**
*/
package	com.upath.plat.auth.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.upath.plat.auth.model.TRmsRoleMenu;

@Component("tRmsRoleMenuMapper")
@SuppressWarnings({ "rawtypes" })
public interface TRmsRoleMenuMapper {

	TRmsRoleMenu select(TRmsRoleMenu bean);
	
	void insert(TRmsRoleMenu bean);
	
	void update(TRmsRoleMenu bean);
	
	List  list(TRmsRoleMenu bean);
	
	void delete(TRmsRoleMenu bean);
}

