/**
*/
package	com.upath.plat.auth.mapper;

import java.util.*;

import org.springframework.stereotype.Component;

import com.upath.plat.auth.model.TRmsRolePortlets;

@Component("tRmsRolePortletsMapper")
@SuppressWarnings({ "rawtypes" })
public interface TRmsRolePortletsMapper {

	TRmsRolePortlets select(Object id);
	
	int insert(TRmsRolePortlets bean);
	
	int update(TRmsRolePortlets bean);
	/* 需要时请开启,动态进行更新
	int updateWithDyna(TRmsRolePortlets bean);
	*/
	List  list(TRmsRolePortlets bean);
	
	int delete(Object id);

	void deleteByProjectId(String projectId);

	List queryNoPage(TRmsRolePortlets trmsRolePortlets);

	List queryModuleId(TRmsRolePortlets trmsRolePortlets);
	
}

