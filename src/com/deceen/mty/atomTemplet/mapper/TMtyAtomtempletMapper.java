package	com.deceen.mty.atomTemplet.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.mty.atomTemplet.model.TMtyAtomtemplet;

@Component("tMtyAtomtempletMapper")
public interface TMtyAtomtempletMapper {

	TMtyAtomtemplet select(Object id);
	
	int insert(TMtyAtomtemplet bean);
	
	int update(TMtyAtomtemplet bean);
	/* 需要时请开启,动态进行更新
	int updateWithDyna(TMtyAtomtemplet bean);
	*/
	@SuppressWarnings("rawtypes")
	List  list(TMtyAtomtemplet bean);
	
	int delete(Object id);
	
}

