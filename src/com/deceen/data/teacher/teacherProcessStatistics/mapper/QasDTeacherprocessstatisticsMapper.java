package	com.deceen.data.teacher.teacherProcessStatistics.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.teacher.teacherProcessStatistics.model.QasDTeacherprocessstatistics;

@Component("qasDTeacherprocessstatisticsMapper")
public interface QasDTeacherprocessstatisticsMapper {

	QasDTeacherprocessstatistics select(Object id);
	
	int insert(QasDTeacherprocessstatistics bean);
	
	int update(QasDTeacherprocessstatistics bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDTeacherprocessstatistics bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDTeacherprocessstatistics bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

