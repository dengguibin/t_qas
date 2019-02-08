package	com.deceen.data.major.graduateEmployment.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.major.graduateEmployment.model.QasDGraduateemployment;

@Component("qasDGraduateemploymentMapper")
public interface QasDGraduateemploymentMapper {

	QasDGraduateemployment select(Object id);
	
	int insert(QasDGraduateemployment bean);
	
	int update(QasDGraduateemployment bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDGraduateemployment bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDGraduateemployment bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

