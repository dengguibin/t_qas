package	com.upath.plat.auth.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.upath.plat.auth.model.TRmsMenuinfo;

@Component("tRmsMenuinfoMapper")
@SuppressWarnings({ "rawtypes" })
public interface TRmsMenuinfoMapper {

	TRmsMenuinfo select(TRmsMenuinfo bean);
	
	void insert(TRmsMenuinfo bean);
	
	void update(TRmsMenuinfo bean);
	
	List  list(TRmsMenuinfo bean);
	
	List  listMenus(TRmsMenuinfo bean);
	
	void delete(TRmsMenuinfo bean);
}

