package	com.deceen.diagnoseformat.task.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.deceen.diagnoseformat.task.model.QasTDiagnosetaskdates;

@Component("qasTDiagnosetaskdatesMapper")
public interface QasTDiagnosetaskdatesMapper {

	QasTDiagnosetaskdates select(Object id);
	
	int insert(QasTDiagnosetaskdates bean);
	
	int update(QasTDiagnosetaskdates bean);

	int updateWithDyna(QasTDiagnosetaskdates bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasTDiagnosetaskdates bean);
	
	int delete(Object id);
	
}

