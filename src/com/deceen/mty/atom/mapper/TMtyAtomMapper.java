package com.deceen.mty.atom.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.mty.atom.model.TMtyAtom;

@Component("tMtyAtomMapper")
@SuppressWarnings("rawtypes")
public interface TMtyAtomMapper {

	TMtyAtom select(Object id);

	int insert(TMtyAtom bean);

	int update(TMtyAtom bean);

	/** 动态进行更新 */
	int updateWithDyna(TMtyAtom bean);

	List list(TMtyAtom bean);
	
	int delete(Object id);

	// 查询所有适用该模板的指标样式
	List listAll(String templetId);

}
