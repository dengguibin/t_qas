package	com.deceen.data.student.studAssociation.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.student.studAssociation.model.QasDStudassociation;

@Component("qasDStudassociationMapper")
public interface QasDStudassociationMapper {

	QasDStudassociation select(Object id);
	
	int insert(QasDStudassociation bean);
	
	int update(QasDStudassociation bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDStudassociation bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDStudassociation bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

