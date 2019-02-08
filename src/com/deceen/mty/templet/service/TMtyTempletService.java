package com.deceen.mty.templet.service;

import java.util.*;

import com.deceen.mty.templet.model.TMtyTemplet;
import com.deceen.mty.templet.mapper.TMtyTempletMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName: TMtyTempletAction.java
 * @Description: t_mty_templet
 * @author upaths@gmail.com
 * @date 2017-11-10 10:41:30
 * @version V1.0
 */
@SuppressWarnings("rawtypes")
@Component("tMtyTempletService")
public class TMtyTempletService extends CommonService {

	private TMtyTempletMapper mapper;

	public TMtyTemplet select(Object id) {
		return mapper.select(id);
	}

	public int insert(TMtyTemplet bean) {
		bean.setId(IDGenerator.getUUID());
		bean.setCjsj(new Date());
		return mapper.insert(bean);
	}

	public int update(TMtyTemplet bean) {
		return mapper.update(bean);
	}

	/** 动态进行更新 */
	public int updateWithDyna(TMtyTemplet bean) {
		bean.setXgsj(new Date());
		return mapper.updateWithDyna(bean);
	}

	/** 批量插入实现 */
	public int[] batchInsert(List list) {
		return batchDelete(list, TMtyTempletMapper.class.getName() + ".insert");
	}

	public List list(TMtyTemplet bean) {
		return queryPageList(TMtyTempletMapper.class.getName() + ".list", bean);
	}

	public int delete(Object id) {
		return mapper.delete(id);
	};

	public int delete(Object[] ids) {
		List list = Arrays.asList(ids);
		batchDelete(list, TMtyTempletMapper.class.getName() + ".delete");
		return 0;
	};

	public TMtyTempletMapper getMapper() {
		return mapper;
	}

	@Autowired
	public void setMapper(TMtyTempletMapper mapper) {
		this.mapper = mapper;
	}

	public Class getMapperClass() {
		return TMtyTempletMapper.class;
	}
}
