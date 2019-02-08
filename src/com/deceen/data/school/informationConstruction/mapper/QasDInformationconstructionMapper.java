package	com.deceen.data.school.informationConstruction.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.school.informationConstruction.model.QasDInformationconstruction;

@Component("qasDInformationconstructionMapper")
public interface QasDInformationconstructionMapper {

	QasDInformationconstruction select(Object id);
	
	int insert(QasDInformationconstruction bean);
	
	int update(QasDInformationconstruction bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDInformationconstruction bean);
	
	@SuppressWarnings("rawtypes")
	List  list(Map map);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

