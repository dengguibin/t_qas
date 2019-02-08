/**
*/
package	com.upath.plat.auth.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.upath.plat.auth.model.TRmsDeptment;

@Component("tRmsDeptmentMapper")
@SuppressWarnings({ "rawtypes" })
public interface TRmsDeptmentMapper {

	TRmsDeptment select(TRmsDeptment bean);
	
	void insert(TRmsDeptment bean);
	
	void update(TRmsDeptment bean);
	
	List  list(TRmsDeptment bean);
	
	List  listSubDepts(TRmsDeptment bean);
	
	void delete(TRmsDeptment bean);
}

