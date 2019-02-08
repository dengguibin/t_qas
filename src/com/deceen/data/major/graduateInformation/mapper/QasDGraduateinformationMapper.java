package	com.deceen.data.major.graduateInformation.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.major.graduateInformation.model.QasDGraduateinformation;

@Component("qasDGraduateinformationMapper")
public interface QasDGraduateinformationMapper {

	QasDGraduateinformation select(Object id);
	
	int insert(QasDGraduateinformation bean);
	
	int update(QasDGraduateinformation bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDGraduateinformation bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDGraduateinformation bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

