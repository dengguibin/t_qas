/**
 */
package com.upath.plat.common.modules.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.upath.plat.common.modules.model.TCommonMessagesRecivers;

@Component("tCommonMessagesReciversMapper")
public interface TCommonMessagesReciversMapper {

	TCommonMessagesRecivers select(Object id);

	int insert(TCommonMessagesRecivers bean);

	int batchInsert(List<TCommonMessagesRecivers> list);

	int batchUpdate(List<TCommonMessagesRecivers> list);

	List<TCommonMessagesRecivers> list(Object id);

	List<TCommonMessagesRecivers> listqueue(int count);
	
	int delete(Object id);

	int deleteByPid(Object id);
}
