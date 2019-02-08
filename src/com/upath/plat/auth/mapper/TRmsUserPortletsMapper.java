/**
*/
package	com.upath.plat.auth.mapper;

import java.util.*;

import org.springframework.stereotype.Component;

import com.upath.plat.auth.model.TRmsUserPortlets;

@Component("tRmsUserPortletsMapper")
@SuppressWarnings({ "rawtypes"})
public interface TRmsUserPortletsMapper {

	TRmsUserPortlets select(Object id);
	
	int insert(TRmsUserPortlets bean);
	
	int update(TRmsUserPortlets bean);
	/* 需要时请开启,动态进行更新
	int updateWithDyna(TRmsUserPortlets bean);
	*/
	List  list(TRmsUserPortlets bean);
	
	int delete(Object id);

	List<Map<String, Object>> findList(TRmsUserPortlets trmsUserPortlets);

	void deleteByPro(TRmsUserPortlets trmsUserPortlets);

	List<String> findRowList(TRmsUserPortlets trmsUserPortlets);

	void deleteByList(Map<String, Object> objMap);
	
}

