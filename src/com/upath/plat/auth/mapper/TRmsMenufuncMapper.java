/**
*/
package	com.upath.plat.auth.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.upath.plat.auth.model.TRmsMenufunc;


@Component("tRmsMenufuncMapper")
@SuppressWarnings({ "rawtypes" })
public interface TRmsMenufuncMapper {

	TRmsMenufunc select(Object id);
	
	int insert(TRmsMenufunc bean);
	
	int update(TRmsMenufunc bean);
	/* 需要时请开启,动态进行更新
	int updateWithDyna(TRmsMenufunc bean);
	*/
	List  list(TRmsMenufunc bean);
	
	int delete(Object id);
	
}

