package	com.deceen.data.teaching.teachingStdResearchProj.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.teaching.teachingStdResearchProj.model.QasDTeachingstdresearchproj;

@Component("qasDTeachingstdresearchprojMapper")
public interface QasDTeachingstdresearchprojMapper {

	QasDTeachingstdresearchproj select(Object id);
	
	int insert(QasDTeachingstdresearchproj bean);
	
	int update(QasDTeachingstdresearchproj bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDTeachingstdresearchproj bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDTeachingstdresearchproj bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

