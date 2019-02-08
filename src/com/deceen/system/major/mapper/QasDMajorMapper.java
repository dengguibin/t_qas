/**
*/
package	com.deceen.system.major.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.deceen.diagnoseformat.task.model.QasTDiagnosetaskobj;
import com.deceen.system.major.model.QasDMajor;

@Component("qasDMajorMapper")
@SuppressWarnings({ "rawtypes"})
public interface QasDMajorMapper {

	QasDMajor select(Object id);
	
	QasDMajor selectinfo(Object id);
	
	String selectParentId(Object id);
	
	String selectParentName(Object id);
	
	int insert(QasDMajor bean);
	
	int update(QasDMajor bean);

	int updateWithDyna(QasDMajor bean);

	List  list(QasDMajor bean);
	
	List<QasDMajor> listAll(QasDMajor major);
	
	List<QasDMajor> listselect();
	
	List listByDwid(QasDMajor bean);
	
	int delete(Object id);
	
}

