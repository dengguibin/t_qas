/**
 */
package com.deceen.data.base.grade.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deceen.data.base.grade.mapper.QasDGradeMapper;
import com.deceen.data.base.grade.model.QasDGrade;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

/**
 * 
 * @ClassName: QasDGradeAction.java
 * @Description: qas_d_grade
 * @author upaths@gmail.com
 * @date 2017-11-22 15:41:25
 * @version V1.0
 */
@Component("qasDGradeService")
@SuppressWarnings("rawtypes")
public class QasDGradeService extends CommonService {

	private QasDGradeMapper mapper;

	public QasDGrade select(Object id) {
		return mapper.select(id);
	}

	public int insert(QasDGrade bean) {
		bean.setId(IDGenerator.getUUID());
		bean.setCreatedtime(new Date());
		return mapper.insert(bean);
	}

	public int update(QasDGrade bean) {
		bean.setUpdatedtime(new Date());
		return mapper.update(bean);
	}

	/**动态进行更新*/
	public int updateWithDyna(QasDGrade bean) {
		bean.setUpdatedtime(new Date());
		return mapper.updateWithDyna(bean);
	}
	/**批量插入*/
	public int[] batchInsert(List list) {

		return batchDelete(list, QasDGradeMapper.class.getName() + ".insert");
	}

	public List list(QasDGrade bean) {
		return queryPageList(QasDGradeMapper.class.getName() + ".list", bean);
	}

	public int delete(Object id) {
		return mapper.delete(id);
	};

	public int delete(Object[] ids) {
		return mapper.batchDelete(ids);
	};

	public QasDGradeMapper getMapper() {
		return mapper;
	}

	@Autowired
	public void setMapper(QasDGradeMapper mapper) {
		this.mapper = mapper;
	}

	public Class getMapperClass() {
		return QasDGradeMapper.class;
	}
}
