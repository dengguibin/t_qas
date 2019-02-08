package	com.deceen.data.major.graduateEmploymentUnits.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.major.graduateEmploymentUnits.model.QasDGraduateemploymentunits;

@Component("qasDGraduateemploymentunitsMapper")
public interface QasDGraduateemploymentunitsMapper {

	QasDGraduateemploymentunits select(Object id);
	
	int insert(QasDGraduateemploymentunits bean);
	
	int update(QasDGraduateemploymentunits bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDGraduateemploymentunits bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDGraduateemploymentunits bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

