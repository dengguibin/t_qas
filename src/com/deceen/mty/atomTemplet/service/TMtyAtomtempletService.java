package com.deceen.mty.atomTemplet.service;

import java.util.*;
import com.deceen.mty.atomTemplet.model.TMtyAtomtemplet;
import com.deceen.mty.atomTemplet.mapper.TMtyAtomtempletMapper;
import com.upath.plat.common.service.CommonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName: TMtyAtomtempletAction.java
 * @Description: t_mty_atomtemplet
 * @author upaths@gmail.com
 * @date 2017-11-10 12:04:39
 * @version V1.0
 */
@SuppressWarnings("rawtypes")
@Component("tMtyAtomtempletService")
public class TMtyAtomtempletService extends CommonService {

	private TMtyAtomtempletMapper mapper;

	public TMtyAtomtemplet select(Object id) {
		return mapper.select(id);
	}

	public int insert(TMtyAtomtemplet bean) {
		return mapper.insert(bean);
	}

	public int update(TMtyAtomtemplet bean) {
		return mapper.update(bean);
	}

	/*
	 * 需要时请开启,动态进行更新,批量插入实现 public int updateWithDyna(TMtyAtomtemplet bean){
	 * return mapper.updateWithDyna(bean); }
	 * 
	 * public int[] batchInsert(List list){ batchDelete(list,
	 * TMtyAtomtempletMapper.class.getName()+".insert"); return 0; }
	 */
	public List list(TMtyAtomtemplet bean) {
		return queryPageList(TMtyAtomtempletMapper.class.getName() + ".list",
				bean);
	}

	public int delete(Object id) {
		return mapper.delete(id);
	};

	public int delete(Object[] ids) {
		List list = Arrays.asList(ids);
		batchDelete(list, TMtyAtomtempletMapper.class.getName() + ".delete");
		return 0;
	};

	public TMtyAtomtempletMapper getMapper() {
		return mapper;
	}

	@Autowired
	public void setMapper(TMtyAtomtempletMapper mapper) {
		this.mapper = mapper;
	}

	public Class getMapperClass() {
		return TMtyAtomtempletMapper.class;
	}
}
