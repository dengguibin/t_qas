/**
*/
package	com.deceen.diagnosereport.analy.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.deceen.diagnosereport.analy.model.QasTDiagnosticinterdoc;

@Component("qasTDiagnosticinterdocMapper")
public interface QasTDiagnosticinterdocMapper {
	
	
	void insert(QasTDiagnosticinterdoc bean);
	
	String selectBytaskId(Map<String, String> reportMap);
	
}

