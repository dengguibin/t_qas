/**
*/
package	com.upath.plat.common.modules.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.upath.plat.common.modules.model.TCommonSeqvalue;
import com.upath.plat.common.modules.model.TSequence;

@Component("tCommonSeqvalueMapper")
@SuppressWarnings({ "rawtypes" })
public interface TCommonSeqvalueMapper {

	TCommonSeqvalue select(TCommonSeqvalue bean);
	
	void insert(TCommonSeqvalue bean);
	
	void update(TCommonSeqvalue bean);
	
	List  list(TCommonSeqvalue bean);
	
	void delete(TCommonSeqvalue bean);
	
	TSequence selectSequnce(TSequence seq);
	
	void updateSequnce(TSequence seq);
	
	void insertSequnce(TSequence seq);
}

