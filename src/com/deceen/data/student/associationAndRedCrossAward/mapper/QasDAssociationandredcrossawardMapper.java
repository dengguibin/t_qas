package	com.deceen.data.student.associationAndRedCrossAward.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.student.associationAndRedCrossAward.model.QasDAssociationandredcrossaward;

@Component("qasDAssociationandredcrossawardMapper")
public interface QasDAssociationandredcrossawardMapper {

	QasDAssociationandredcrossaward select(Object id);
	
	int insert(QasDAssociationandredcrossaward bean);
	
	int update(QasDAssociationandredcrossaward bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDAssociationandredcrossaward bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDAssociationandredcrossaward bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

