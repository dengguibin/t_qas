package	com.deceen.data.teacher.teacherPublishedPaper.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.teacher.teacherPublishedPaper.model.QasDTeacherpublishedpaper;

@Component("qasDTeacherpublishedpaperMapper")
public interface QasDTeacherpublishedpaperMapper {

	QasDTeacherpublishedpaper select(Object id);
	
	int insert(QasDTeacherpublishedpaper bean);
	
	int update(QasDTeacherpublishedpaper bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDTeacherpublishedpaper bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDTeacherpublishedpaper bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

