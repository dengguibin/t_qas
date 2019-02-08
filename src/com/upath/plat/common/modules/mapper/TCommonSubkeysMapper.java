/**
*/
package	com.upath.plat.common.modules.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.upath.plat.common.modules.model.TCommonSubkeys;

@Component("tCommonSubkeysMapper")
@SuppressWarnings({ "rawtypes"})
public interface TCommonSubkeysMapper {

	TCommonSubkeys select(TCommonSubkeys bean);
	
	void insert(TCommonSubkeys bean);
	
	void update(TCommonSubkeys bean);
	
	List  list(TCommonSubkeys bean);
	
	void delete(TCommonSubkeys bean);
	
	
}

