package	com.deceen.data.major.lastYearEmployment.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.major.lastYearEmployment.model.QasDLastyearemployment;

@Component("qasDLastyearemploymentMapper")
public interface QasDLastyearemploymentMapper {

	QasDLastyearemployment select(Object id);
	
	int insert(QasDLastyearemployment bean);
	
	int update(QasDLastyearemployment bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDLastyearemployment bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDLastyearemployment bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

