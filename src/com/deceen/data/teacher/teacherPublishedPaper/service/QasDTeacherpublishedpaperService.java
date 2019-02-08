package com.deceen.data.teacher.teacherPublishedPaper.service;

import java.util.*;
import com.deceen.data.teacher.teacherPublishedPaper.model.QasDTeacherpublishedpaper;
import com.deceen.data.teacher.teacherPublishedPaper.mapper.QasDTeacherpublishedpaperMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName: QasDTeacherpublishedpaperAction.java
 * @Description: qas_d_teacherpublishedpaper
 * @author upaths@gmail.com
 * @date 2017-11-23 12:33:51
 * @version V1.0
 */
@Component("qasDTeacherpublishedpaperService")
@SuppressWarnings({ "rawtypes" })
public class QasDTeacherpublishedpaperService extends CommonService {

	private QasDTeacherpublishedpaperMapper mapper;

	public QasDTeacherpublishedpaper select(Object id) {
		return mapper.select(id);
	}

	public int insert(QasDTeacherpublishedpaper bean) {
		bean.setId(IDGenerator.getUUID());
		bean.setCreatedtime(new Date());
		return mapper.insert(bean);
	}

	public int update(QasDTeacherpublishedpaper bean) {
		bean.setUpdatedtime(new Date());
		return mapper.update(bean);
	}

	/** 动态进行更新 */  
	public int updateWithDyna(QasDTeacherpublishedpaper bean) {
		bean.setUpdatedtime(new Date());
		return mapper.updateWithDyna(bean);
	}
	/** 批量插入 */
	public int[] batchInsert(List list) {

		return batchDelete(list,
				QasDTeacherpublishedpaperMapper.class.getName() + ".insert");
	}

	public List list(QasDTeacherpublishedpaper bean) {
		return queryPageList(QasDTeacherpublishedpaperMapper.class.getName()
				+ ".list", bean);
	}

	public int delete(Object id) {
		return mapper.delete(id);
	};

	public int delete(Object[] ids) {
		return mapper.batchDelete(ids);
	};

	public QasDTeacherpublishedpaperMapper getMapper() {
		return mapper;
	}

	@Autowired
	public void setMapper(QasDTeacherpublishedpaperMapper mapper) {
		this.mapper = mapper;
	}

	public Class getMapperClass() {
		return QasDTeacherpublishedpaperMapper.class;
	}
}
