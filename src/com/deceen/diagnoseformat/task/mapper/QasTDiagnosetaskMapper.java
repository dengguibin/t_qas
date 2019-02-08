package	com.deceen.diagnoseformat.task.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.deceen.diagnoseformat.task.model.QasTDiagnosetask;
import com.deceen.system.major.model.QasDMajor;

@Component("qasTDiagnosetaskMapper")
@SuppressWarnings("rawtypes")
public interface QasTDiagnosetaskMapper {

	QasTDiagnosetask select(Object id);
	
	int insert(QasTDiagnosetask bean);
	
	int update(QasTDiagnosetask bean);
	
	/** 动态进行更新*/
	int updateWithDyna(QasTDiagnosetask bean);
	
	List  list(QasTDiagnosetask bean);
	
	int delete(Object id);

	List<QasTDiagnosetask> selectPublishTask(QasTDiagnosetask diagnosetask);
	
	List<QasDMajor> listAll(QasTDiagnosetask gnosetask);
	
	List listAllzy(QasDMajor bean);

	int updateStatus(Map<String, Object> params); 
	
	
}

