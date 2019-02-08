/**
*/
package	com.upath.plat.auth.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.upath.plat.auth.model.TRmsAppinfo;
import com.upath.plat.common.dao.IMapper;

@Component("tRmsAppinfoMapper")
@SuppressWarnings({ "rawtypes"})
public interface TRmsAppinfoMapper extends IMapper {

	TRmsAppinfo select(TRmsAppinfo bean);
	
	void insert(TRmsAppinfo bean);
	
	void update(TRmsAppinfo bean);
	
	List  list(TRmsAppinfo bean);
	
	void delete(TRmsAppinfo bean);
}

