/**
*/
package	com.deceen.diagnoseformat.task.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.deceen.diagnoseformat.task.model.QasTDiagnosetasklevel;
import com.deceen.diagnoseformat.task.model.QasTDiagnosetaskobj;

@SuppressWarnings("rawtypes")
@Component("qasTDiagnosetaskobjMapper")
public interface QasTDiagnosetaskobjMapper {

	List<QasTDiagnosetaskobj> selectByTaskId(String taskid);
	List<QasTDiagnosetaskobj> selectAlltaskObj();
	List<QasTDiagnosetaskobj> selectfind(String id);
	
	List<QasTDiagnosetaskobj> selectById(String id);
	
	int insert(QasTDiagnosetaskobj bean);
	
	int batchInsert(List<QasTDiagnosetaskobj> list);
	
	int update(QasTDiagnosetaskobj bean);
	
	int updateWithDyna(QasTDiagnosetaskobj bean);
	
	List  list(QasTDiagnosetaskobj bean);
	
	int delete(Object id);

	List<QasTDiagnosetaskobj> selectObjsByUser(String userId);
	
	/**
	 * 通过任务id去查找相关联的诊断对象（状态为已发布 1）
	 * @param taskid
	 * @return
	 */
	List<QasTDiagnosetaskobj> selectByTaskIdToStatus(String taskid);
	List<QasTDiagnosetasklevel> selectTasklevel(String taskId);
	
}

