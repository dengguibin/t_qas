/**
*/
package	com.upath.plat.auth.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.upath.plat.auth.model.TRmsRolePermisions;

@Component("tRmsRolePermisionsMapper")
@SuppressWarnings({ "rawtypes"})
public interface TRmsRolePermisionsMapper {

	TRmsRolePermisions select(TRmsRolePermisions bean);
	
	void insert(TRmsRolePermisions bean);
	
	void update(TRmsRolePermisions bean);
	
	List  list(TRmsRolePermisions bean);
	
	void delete(TRmsRolePermisions bean);
}

