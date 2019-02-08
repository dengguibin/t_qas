/**
*/
package	com.deceen.diagnosereport.analy.mapper;

import java.util.*;

import org.springframework.stereotype.Component;

import com.deceen.diagnosereport.analy.model.QasTDiagnosticquantitativeindicator;

@SuppressWarnings("rawtypes")
@Component("qasTDiagnosticquantitativeindicatorMapper")
public interface QasTDiagnosticquantitativeindicatorMapper {

	QasTDiagnosticquantitativeindicator select(Object id);
	
	int insert(QasTDiagnosticquantitativeindicator bean);
	
	int update(QasTDiagnosticquantitativeindicator bean);
	/* 需要时请开启,动态进行更新
	int updateWithDyna(QasTDiagnosticquantitativeindicator bean);
	*/
	List  list(QasTDiagnosticquantitativeindicator bean);
	
	int delete(Object id);

	void insertBatch(
			List<QasTDiagnosticquantitativeindicator> diagnosticquantitativeindicators);
	
}

