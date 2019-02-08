/**
*/
package	com.upath.plat.common.modules.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.upath.plat.common.modules.model.TCommonSql;

@Component("tCommonSqlMapper")
@SuppressWarnings({ "rawtypes" })
public interface TCommonSqlMapper {

	TCommonSql select(TCommonSql bean);
	
	void insert(TCommonSql bean);
	
	void update(TCommonSql bean);
	
	void backupSql(TCommonSql bean);
	
	List  list(TCommonSql bean);
	
	void delete(TCommonSql bean);
}

