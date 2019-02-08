/**
*/
package	com.deceen.diagnosereport.analy.mapper;

import java.util.*;

import org.springframework.stereotype.Component;

import com.deceen.diagnosereport.analy.model.QasTDiagnostictype;

@SuppressWarnings("rawtypes")
@Component("qasTDiagnostictypeMapper")
public interface QasTDiagnostictypeMapper {

	QasTDiagnostictype select(Object id);
	
	int insert(QasTDiagnostictype bean);
	
	int update(QasTDiagnostictype bean);
	/* 需要时请开启,动态进行更新
	int updateWithDyna(QasTDiagnostictype bean);
	*/
	List  list(QasTDiagnostictype bean);
	
	int delete(Object id);

	void insertBatch(List<QasTDiagnostictype> diagnostictypes);
	
}

