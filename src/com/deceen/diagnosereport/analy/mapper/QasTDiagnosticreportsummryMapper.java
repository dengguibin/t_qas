/**
*/
package	com.deceen.diagnosereport.analy.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.deceen.diagnosereport.analy.model.QasTDiagnosticreportsummry;

@SuppressWarnings("rawtypes")
@Component("qasTDiagnosticreportsummryMapper")
public interface QasTDiagnosticreportsummryMapper {

	QasTDiagnosticreportsummry select(Object id);
	
	int insert(QasTDiagnosticreportsummry bean);
	
	int update(QasTDiagnosticreportsummry bean);
	/* 需要时请开启,动态进行更新
	int updateWithDyna(QasTDiagnosticreportsummry bean);
	*/
	List  list(QasTDiagnosticreportsummry bean);
	
	int delete(Object id);

	void insertBatch(List<QasTDiagnosticreportsummry> diagnosticreportsummrys);
	
	/**
	 * 
	 * 对t_pond_DiagnoseObjsIndicatorResult表添加LIST类型新分区
	 * 例如：分区名称为“p20180425”,分区内容为“20180425”
	 * @param 
	 * @return 
	 * @author dengguibin
	 */
	void newPartition(@Param("sql")String sql);
}

