/**
*/
package	com.upath.plat.quartz.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.upath.plat.quartz.model.TCommonScheduling;

@Component("tCommonSchedulingMapper")
@SuppressWarnings({ "rawtypes"})
public interface TCommonSchedulingMapper {

	TCommonScheduling select(Object id);
	
	int insert(TCommonScheduling bean);
	
	int update(TCommonScheduling bean);

	int updateWithDyna(TCommonScheduling bean);
	
	List  list(TCommonScheduling bean);
	
	List<TCommonScheduling> querylist(TCommonScheduling bean);
	
	int delete(Object id);
	
	/**
	 * -修改调度的任务状态(id,status)
	 * 
	 */
	int updateQuartzStatus(Map<String, Object> params);
	
}

