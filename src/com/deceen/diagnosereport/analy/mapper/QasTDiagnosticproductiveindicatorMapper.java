/**
*/
package	com.deceen.diagnosereport.analy.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.diagnosereport.analy.model.QasTDiagnosticproductiveindicator;

@SuppressWarnings("rawtypes")
@Component("qasTDiagnosticproductiveindicatorMapper")
public interface QasTDiagnosticproductiveindicatorMapper {

	QasTDiagnosticproductiveindicator select(Object id);
	
	int insert(QasTDiagnosticproductiveindicator bean);
	
	int update(QasTDiagnosticproductiveindicator bean);
	/* 需要时请开启,动态进行更新
	int updateWithDyna(QasTDiagnosticproductiveindicator bean);
	*/
	List  list(QasTDiagnosticproductiveindicator bean);
	
	int delete(Object id);
	
}

