package com.deceen.mty.atom.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deceen.mty.atom.mapper.TMtyAtomMapper;
import com.deceen.mty.atom.model.TMtyAtom;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

/**
 * 
 * @ClassName: TMtyAtomAction.java
 * @Description: t_mty_atom
 * @author upaths@gmail.com
 * @date 2017-11-5 11:00:49
 * @version V1.0
 */
@Component("tMtyAtomService")
@SuppressWarnings("rawtypes")
public class TMtyAtomService extends CommonService {

	private TMtyAtomMapper mapper;
	

	public TMtyAtom select(Object id) {
		TMtyAtom atom = mapper.select(id);
		return atom;
	}

	public int insert(TMtyAtom bean) {
		bean.setId(IDGenerator.getUUID());
		bean.setCjsj(new Date());
		return mapper.insert(bean);
	}

	public int update(TMtyAtom bean) {
		return mapper.update(bean);
	}

	/** 动态进行更新 */
	public int updateWithDyna(TMtyAtom bean) {
		String front_html = bean.getFront_html();
		front_html = front_html.replaceAll("&lt;", "<");
		front_html = front_html.replaceAll("&#39;", "'");
		front_html = front_html.replaceAll("&gt;", ">");
		bean.setFront_html(front_html);
		String back_html = bean.getBack_html();
		back_html = back_html.replaceAll("&lt;", "<");
		back_html = back_html.replaceAll("&#39;", "'");
		back_html = back_html.replaceAll("&gt;", ">");
		bean.setBack_html(back_html);
		bean.setXgsj(new Date());
		return mapper.updateWithDyna(bean);
	}

	/** 批量插入实现 */
	public int[] batchInsert(List list) {
		return batchDelete(list, TMtyAtomMapper.class.getName() + ".insert");
	}

	public List list(TMtyAtom bean) {
		return queryPageList(TMtyAtomMapper.class.getName() + ".list", bean);
	}

	public int delete(Object id) {
		return mapper.delete(id);
	}

	public int delete(Object[] ids) {
		List list = Arrays.asList(ids);
		batchDelete(list, TMtyAtomMapper.class.getName() + ".delete");
		return 0;
	}

	public TMtyAtomMapper getMapper() {
		return mapper;
	}

	@Autowired
	public void setMapper(TMtyAtomMapper mapper) {
		this.mapper = mapper;
	}

	public Class getMapperClass() {
		return TMtyAtomMapper.class;
	}

	// 查询所有适用该模板的指标样式
	public List listAll(String templetId) {
		return mapper.listAll(templetId);
	}
}
