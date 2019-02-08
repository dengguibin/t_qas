/**
*/
package	com.upath.plat.common.modules.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.upath.plat.common.modules.model.TRmsLogininfo;

@Component("tRmsLogininfoMapper")
@SuppressWarnings({ "rawtypes" })
public interface TRmsLogininfoMapper {

	TRmsLogininfo select(TRmsLogininfo bean);
	
	void insert(TRmsLogininfo bean);
	
	void update(TRmsLogininfo bean);
	
	List  list(TRmsLogininfo bean);
	
	//通过登陆的IP登陆查询
	int queryLogCountByAddr(TRmsLogininfo bean);
	
	void delete(TRmsLogininfo bean);
}

