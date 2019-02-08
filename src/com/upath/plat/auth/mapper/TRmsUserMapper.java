/**
*/
package	com.upath.plat.auth.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.upath.plat.auth.model.TRmsUser;

@Component("tRmsUserMapper")
@SuppressWarnings({ "rawtypes"})
public interface TRmsUserMapper {

	TRmsUser select(TRmsUser bean);
	
	void insert(TRmsUser bean);
	
	void update(TRmsUser bean);
	
	void updateStatus(TRmsUser bean);
	
	List  list(TRmsUser bean);
	
	List  listDeptUsers(TRmsUser bean);
	
	void delete(TRmsUser bean);
	
	/**
	 * 查询用户所属的专业id;
	 * */
	String selectById(String yhid);
}

