package	com.deceen.data.base.empolyee.mapper;

import java.util.*;

import org.springframework.stereotype.Component;

import com.deceen.data.base.empolyee.model.QasDEmpolyee;

@Component("qasDEmpolyeeMapper")
public interface QasDEmpolyeeMapper {

	QasDEmpolyee select(Object id);
	
	int insert(QasDEmpolyee bean);
	
	int update(QasDEmpolyee bean);
	/* 需要时请开启,动态进行更新*/
	int updateWithDyna(QasDEmpolyee bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDEmpolyee bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

