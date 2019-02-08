/**
*/
package	com.deceen.diagnosereport.analy.mapper;

import java.util.*;

import org.springframework.stereotype.Component;

import com.deceen.diagnosereport.analy.model.QasTDiagnosticitem;

@SuppressWarnings("rawtypes")
@Component("qasTDiagnosticitemMapper")
public interface QasTDiagnosticitemMapper {

	QasTDiagnosticitem select(Object id);
	
	int insert(QasTDiagnosticitem bean);
	
	int update(QasTDiagnosticitem bean);
	/* 需要时请开启,动态进行更新
	int updateWithDyna(QasTDiagnosticitem bean);
	*/
	List  list(QasTDiagnosticitem bean);
	
	int delete(Object id);

	void insertBatch(List<QasTDiagnosticitem> diagnosticitems);
	
}

