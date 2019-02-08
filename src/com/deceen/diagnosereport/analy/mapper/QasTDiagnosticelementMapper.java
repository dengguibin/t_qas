/**
*/
package	com.deceen.diagnosereport.analy.mapper;

import java.util.*;

import org.springframework.stereotype.Component;

import com.deceen.diagnosereport.analy.model.QasTDiagnosticelement;

@SuppressWarnings("rawtypes")
@Component("qasTDiagnosticelementMapper")
public interface QasTDiagnosticelementMapper {

	QasTDiagnosticelement select(Object id);
	
	int insert(QasTDiagnosticelement bean);
	
	int update(QasTDiagnosticelement bean);
	/* 需要时请开启,动态进行更新
	int updateWithDyna(QasTDiagnosticelement bean);
	*/
	List  list(QasTDiagnosticelement bean);
	
	int delete(Object id);

	void insertBatch(List<QasTDiagnosticelement> diagnosticelements);
	
}

