package com.deceen.data.base.empolyee.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deceen.data.base.empolyee.mapper.QasDEmpolyeeMapper;
import com.deceen.data.base.empolyee.model.QasDEmpolyee;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

/**
 * 
 * @ClassName: QasDEmpolyeeAction.java
 * @Description: qas_d_empolyee
 * @author upaths@gmail.com
 * @date 2017-11-22 11:09:27
 * @version V1.0
 */
@Component("qasDEmpolyeeService")
@SuppressWarnings("rawtypes")
public class QasDEmpolyeeService extends CommonService {

	private QasDEmpolyeeMapper mapper;

	public QasDEmpolyee select(Object id) {
		return mapper.select(id);
	}

	public int insert(QasDEmpolyee bean) {
		bean.setId(IDGenerator.getUUID());
		bean.setCreatedtime(new Date());
		return mapper.insert(bean);
	}

	public int update(QasDEmpolyee bean) {
		bean.setUpdatedtime(new Date());
		return mapper.update(bean);
	}

	 /**动态进行更新*/ 
	public int updateWithDyna(QasDEmpolyee bean) {
		bean.setUpdatedtime(new Date());
		return mapper.updateWithDyna(bean);
	}
	/**批量插入实现*/
	public int[] batchInsert(List list) {
		return batchDelete(list, QasDEmpolyeeMapper.class.getName() + ".insert");
	}

	public List list(QasDEmpolyee bean) {
		return queryPageList(QasDEmpolyeeMapper.class.getName() + ".list", bean);
	}

	public int delete(Object id) {
		return mapper.delete(id);
	};

	public int delete(Object[] ids) {
		return mapper.batchDelete(ids);
	};

	public QasDEmpolyeeMapper getMapper() {
		return mapper;
	}

	@Autowired
	public void setMapper(QasDEmpolyeeMapper mapper) {
		this.mapper = mapper;
	}

	public Class getMapperClass() {
		return QasDEmpolyeeMapper.class;
	}
}
