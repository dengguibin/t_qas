package com.deceen.data.teaching.skillMasterStudio.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deceen.data.teaching.skillMasterStudio.mapper.QasDSkillmasterstudioMapper;
import com.deceen.data.teaching.skillMasterStudio.model.QasDSkillmasterstudio;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

/**
 * 
 * @ClassName: QasDSkillmasterstudioAction.java
 * @Description: qas_d_skillmasterstudio
 * @author upaths@gmail.com
 * @date 2017-11-24 12:22:47
 * @version V1.0
 */
@Component("qasDSkillmasterstudioService")
@SuppressWarnings({ "rawtypes"})
public class QasDSkillmasterstudioService extends CommonService {

	private QasDSkillmasterstudioMapper mapper;

	public QasDSkillmasterstudio select(Object id) {
		return mapper.select(id);
	}

	public int insert(QasDSkillmasterstudio bean) {

		bean.setId(IDGenerator.getUUID());
		bean.setCreatedtime(new Date());

		return mapper.insert(bean);
	}

	public int update(QasDSkillmasterstudio bean) {
		bean.setUpdatedtime(new Date());
		return mapper.update(bean);
	}

	// 需要时请开启,动态进行更新,批量插入实现
	public int updateWithDyna(QasDSkillmasterstudio bean) {
		bean.setUpdatedtime(new Date());
		return mapper.updateWithDyna(bean);
	}

	public int[] batchInsert(List list) {
		
		return batchDelete(list, QasDSkillmasterstudioMapper.class.getName()
				+ ".insert");
	}

	public List list(QasDSkillmasterstudio bean) {
		return queryPageList(QasDSkillmasterstudioMapper.class.getName()
				+ ".list", bean);
	}

	public int delete(Object id) {
		return mapper.delete(id);
	};

	public int delete(Object[] ids) {
		return mapper.batchDelete(ids);
	};

	public QasDSkillmasterstudioMapper getMapper() {
		return mapper;
	}

	@Autowired
	public void setMapper(QasDSkillmasterstudioMapper mapper) {
		this.mapper = mapper;
	}

	public Class getMapperClass() {
		return QasDSkillmasterstudioMapper.class;
	}
}
