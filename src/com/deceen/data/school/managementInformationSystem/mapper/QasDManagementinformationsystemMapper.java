package	com.deceen.data.school.managementInformationSystem.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.school.managementInformationSystem.model.QasDManagementinformationsystem;

@Component("qasDManagementinformationsystemMapper")
public interface QasDManagementinformationsystemMapper {

	QasDManagementinformationsystem select(Object id);
	
	int insert(QasDManagementinformationsystem bean);
	
	int update(QasDManagementinformationsystem bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDManagementinformationsystem bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDManagementinformationsystem bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

