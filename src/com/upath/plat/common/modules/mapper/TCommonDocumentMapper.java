/**
*/
package	com.upath.plat.common.modules.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.upath.plat.common.modules.model.TCommonDocument;

@Component("tCommonDocumentMapper")
@SuppressWarnings({ "rawtypes" })
public interface TCommonDocumentMapper {

	TCommonDocument select(TCommonDocument bean);
	
	void insert(TCommonDocument bean);
	
	void update(TCommonDocument bean);
	
	List  list(TCommonDocument bean);
	
	void delete(TCommonDocument bean);
}

