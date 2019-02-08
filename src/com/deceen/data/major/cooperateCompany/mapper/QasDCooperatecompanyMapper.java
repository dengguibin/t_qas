package	com.deceen.data.major.cooperateCompany.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.major.cooperateCompany.model.QasDCooperatecompany;

@Component("qasDCooperatecompanyMapper")
public interface QasDCooperatecompanyMapper {

	QasDCooperatecompany select(Object id);
	
	int insert(QasDCooperatecompany bean);
	
	int update(QasDCooperatecompany bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDCooperatecompany bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDCooperatecompany bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

