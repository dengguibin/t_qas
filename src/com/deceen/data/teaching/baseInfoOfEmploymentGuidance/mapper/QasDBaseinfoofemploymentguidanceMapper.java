package	com.deceen.data.teaching.baseInfoOfEmploymentGuidance.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.teaching.baseInfoOfEmploymentGuidance.model.QasDBaseinfoofemploymentguidance;

@Component("qasDBaseinfoofemploymentguidanceMapper")
public interface QasDBaseinfoofemploymentguidanceMapper {

	QasDBaseinfoofemploymentguidance select(Object id);
	
	int insert(QasDBaseinfoofemploymentguidance bean);
	
	int update(QasDBaseinfoofemploymentguidance bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDBaseinfoofemploymentguidance bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDBaseinfoofemploymentguidance bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

