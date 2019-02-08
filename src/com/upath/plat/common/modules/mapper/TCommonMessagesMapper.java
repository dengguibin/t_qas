/**
 */
package com.upath.plat.common.modules.mapper;

import java.util.*;

import org.springframework.stereotype.Component;

import com.upath.plat.common.modules.model.TCommonMessages;

@Component("tCommonMessagesMapper")
@SuppressWarnings({ "rawtypes"})
public interface TCommonMessagesMapper {

	TCommonMessages select(Object id);

	int insert(TCommonMessages bean);

	int update(TCommonMessages bean);

	int batchUpdate(List<TCommonMessages> list);

	List<TCommonMessages> list(TCommonMessages bean);

	List<TCommonMessages> listqueue(int count);

	int delete(Object id);
	
	Map queryUserMessageInfos(Object params);
	
	

}
