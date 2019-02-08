/**
*/
package	com.upath.plat.auth.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.upath.plat.auth.model.TRmsRole;

@Component("tRmsRoleMapper")
@SuppressWarnings({ "rawtypes"})
public interface TRmsRoleMapper {

	TRmsRole select(TRmsRole bean);
	
	void insert(TRmsRole bean);
	
	void update(TRmsRole bean);
	
	List  list(TRmsRole bean);
	
	List  menuList(TRmsRole bean);
	
	List  listUser(TRmsRole bean);
	//角色与权限 的关系
	List  listPermissions(TRmsRole bean);
	
	void delete(TRmsRole bean);
	
	List<TRmsRole> selectByIds(List<String> ids);
}

