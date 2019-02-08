package	com.deceen.diagnoseformat.scheme.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.deceen.diagnoseformat.scheme.model.QasTDiagnosescheme;

@Component("qasTDiagnoseschemeMapper")
@SuppressWarnings("rawtypes")
public interface QasTDiagnoseschemeMapper {

	QasTDiagnosescheme select(Object id);
	
	int insert(QasTDiagnosescheme bean);
	
	int update(QasTDiagnosescheme bean);

	int updateWithDyna(QasTDiagnosescheme bean);

	List  list(QasTDiagnosescheme bean);
	
	int delete(Object id);

	List<QasTDiagnosescheme> selectBean(QasTDiagnosescheme diagnose);

	int selectTask(String id);

	List<QasTDiagnosescheme> typeList(QasTDiagnosescheme diagnose);
	
	List findtype(QasTDiagnosescheme bean);
}

