/**
*/
package	com.upath.plat.quartz.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.upath.plat.quartz.model.TCommonSchedulingLogs;

@Component("tCommonSchedulingLogsMapper")
@SuppressWarnings({ "rawtypes" })
public interface TCommonSchedulingLogsMapper {

	TCommonSchedulingLogs select(Object id);
	
	int insert(TCommonSchedulingLogs bean);
	
	int update(TCommonSchedulingLogs bean);
	/* 需要时请开启,动态进行更新
	int updateWithDyna(TCommonSchedulingLogs bean);
	*/
	List  list(TCommonSchedulingLogs bean);
	
	int delete(Object id);
	
}

