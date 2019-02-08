package	com.deceen.data.school.socialDonation.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.school.socialDonation.model.QasDSocialdonation;

@Component("qasDSocialdonationMapper")
public interface QasDSocialdonationMapper {

	QasDSocialdonation select(Object id);
	
	int insert(QasDSocialdonation bean);
	
	int update(QasDSocialdonation bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDSocialdonation bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDSocialdonation bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

