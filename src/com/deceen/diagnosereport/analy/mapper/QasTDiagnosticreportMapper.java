/**
*/
package	com.deceen.diagnosereport.analy.mapper;

import java.util.*;

import org.springframework.stereotype.Component;

import com.deceen.diagnosereport.analy.model.QasTDiagnosticreport;

@SuppressWarnings("rawtypes")
@Component("qasTDiagnosticreportMapper")
public interface QasTDiagnosticreportMapper {

	/*List<Map<String, Object>> select(QasTDiagnosticreport diagnosticreport);*/
	List<Map<String,Object>> select(QasTDiagnosticreport diagnosticreport);
	
	List<Map<String,Object>> selectDiagnosetaskId();
	
	QasTDiagnosticreport selectById(String id);
	
	int insert(QasTDiagnosticreport bean);
	
	int update(QasTDiagnosticreport bean);
	/* 需要时请开启,动态进行更新
	int updateWithDyna(QasTDiagnosticreport bean);
	*/
	List  list(QasTDiagnosticreport bean);
	
	int delete(Object id);
	
	List<Map<String, Object>> selectDisgnoseObjByTaskId(QasTDiagnosticreport diagnosticreport);
	
	List<Map<String, Object>> selectDisgnoseObj(QasTDiagnosticreport diagnosticreport);
	
}

