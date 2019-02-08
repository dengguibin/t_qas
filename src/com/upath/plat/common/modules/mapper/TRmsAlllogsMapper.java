/**
*/
package	com.upath.plat.common.modules.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.upath.plat.common.modules.model.TRmsAlllogs;

@Component("tRmsAlllogsMapper")
@SuppressWarnings({ "rawtypes" })
public interface TRmsAlllogsMapper {

	TRmsAlllogs select(TRmsAlllogs bean);
	
	void insert(TRmsAlllogs bean);
	
	void update(TRmsAlllogs bean);
	
	List  list(TRmsAlllogs bean);
	
	List  listParseLogs(int rows);
	
	void delete(TRmsAlllogs bean);
}

