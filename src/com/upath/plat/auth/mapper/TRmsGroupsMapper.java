/**
*/
package	com.upath.plat.auth.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.upath.plat.auth.model.TRmsGroups;

@Component("tRmsGroupsMapper")
@SuppressWarnings({ "rawtypes" })
public interface TRmsGroupsMapper {

	TRmsGroups select(TRmsGroups bean);
	
	void insert(TRmsGroups bean);
	
	void update(TRmsGroups bean);
	
	List  list(TRmsGroups bean);
	
	List  listUser(TRmsGroups bean);
	
	List  listGroups(TRmsGroups bean);
	
	void delete(TRmsGroups bean);
}

