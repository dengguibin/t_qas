/**
*/
package	com.upath.plat.common.modules.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.upath.plat.common.modules.model.TCommonTemplate;

@Component("tCommonTemplateMapper")
@SuppressWarnings({ "rawtypes" })
public interface TCommonTemplateMapper {

	TCommonTemplate select(TCommonTemplate bean);
	
	void insert(TCommonTemplate bean);
	
	void update(TCommonTemplate bean);
	
	List  list(TCommonTemplate bean);
	
	void delete(TCommonTemplate bean);
}

