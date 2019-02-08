package	com.deceen.data.base.grade.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.deceen.data.base.grade.model.QasDGrade;

@Component("qasDGradeMapper")
public interface QasDGradeMapper {

	QasDGrade select(Object id);
	
	int insert(QasDGrade bean);
	
	int update(QasDGrade bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDGrade bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDGrade bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);

}

