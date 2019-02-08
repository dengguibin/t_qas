package	com.deceen.data.teaching.filesOfTeachingManageMent.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.teaching.filesOfTeachingManageMent.model.QasDFilesofteachingmanagement;

@Component("qasDFilesofteachingmanagementMapper")
public interface QasDFilesofteachingmanagementMapper {

	QasDFilesofteachingmanagement select(Object id);
	
	int insert(QasDFilesofteachingmanagement bean);
	
	int update(QasDFilesofteachingmanagement bean);
//	 ?需要时请开启,动态进行更新
	int updateWithDyna(QasDFilesofteachingmanagement bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDFilesofteachingmanagement bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

