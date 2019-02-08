/**
*/
package	com.upath.plat.common.modules.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.upath.plat.common.modules.model.TCommonSeq;

@Component("tCommonSeqMapper")
@SuppressWarnings({ "rawtypes"})
public interface TCommonSeqMapper {

	TCommonSeq select(TCommonSeq bean);
	
	void insert(TCommonSeq bean);
	
	void update(TCommonSeq bean);
	
	List  list(TCommonSeq bean);
	
	void delete(TCommonSeq bean);
}

