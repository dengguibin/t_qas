package	com.deceen.diagnoseformat.task.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.deceen.diagnoseformat.task.model.QasTDiagnosetasklevel;

@Component("qasTDiagnosetasklevelMapper")
public interface QasTDiagnosetasklevelMapper {

	QasTDiagnosetasklevel select(Object id);
	
	List<QasTDiagnosetasklevel> select(String id);
	
	int insert(QasTDiagnosetasklevel bean);
	
	int update(QasTDiagnosetasklevel bean);
	
	int updateWithDyna(QasTDiagnosetasklevel bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasTDiagnosetasklevel bean);
	
	int delete(Object id);

	int batchInsert(List<QasTDiagnosetasklevel> diagnosetasklevels);

	void updateBatch(List<QasTDiagnosetasklevel> diagnosetasklevels);
	
}

