/**
*/
package	com.deceen.diagnosereport.analy.mapper;

import java.util.*;

import org.springframework.stereotype.Component;

import com.deceen.diagnoseformat.task.model.QasTDiagnosetaskobj;
import com.deceen.diagnosereport.analy.model.QasTDiagnosticintermediary;

@SuppressWarnings("rawtypes")
@Component("qasTDiagnosticintermediaryMapper")
public interface QasTDiagnosticintermediaryMapper {

	QasTDiagnosticintermediary select(Object id);
	
	int insert(QasTDiagnosticintermediary bean);
	
	int update(QasTDiagnosticintermediary bean);
	/* 需要时请开启,动态进行更新
	int updateWithDyna(QasTDiagnosticintermediary bean);
	*/
	List  list(QasTDiagnosticintermediary bean);
	
	int delete(Object id);

	void insertBatch(List<QasTDiagnosticintermediary> diagnosticIntermediarys);
	
	String selectBytaskId(Map<String, String> reportMap);
	
}

