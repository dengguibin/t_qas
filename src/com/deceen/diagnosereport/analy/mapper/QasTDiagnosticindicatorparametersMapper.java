/**
*/
package	com.deceen.diagnosereport.analy.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.diagnosereport.analy.model.QasTDiagnosticindicatorparameters;

@SuppressWarnings("rawtypes")
@Component("qasTDiagnosticindicatorparametersMapper")
public interface QasTDiagnosticindicatorparametersMapper {

	QasTDiagnosticindicatorparameters select(Object id);
	
	int insert(QasTDiagnosticindicatorparameters bean);
	
	int update(QasTDiagnosticindicatorparameters bean);
	/* 需要时请开启,动态进行更新
	int updateWithDyna(QasTDiagnosticindicatorparameters bean);
	*/
	List  list(QasTDiagnosticindicatorparameters bean);
	
	int delete(Object id);
	
}

