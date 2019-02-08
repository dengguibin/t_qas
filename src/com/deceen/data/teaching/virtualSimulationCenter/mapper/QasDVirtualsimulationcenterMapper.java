package	com.deceen.data.teaching.virtualSimulationCenter.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.data.teaching.virtualSimulationCenter.model.QasDVirtualsimulationcenter;

@Component("qasDVirtualsimulationcenterMapper")
public interface QasDVirtualsimulationcenterMapper {

	QasDVirtualsimulationcenter select(Object id);
	
	int insert(QasDVirtualsimulationcenter bean);
	
	int update(QasDVirtualsimulationcenter bean);
//	 需要时请开启,动态进行更新
	int updateWithDyna(QasDVirtualsimulationcenter bean);
	
	@SuppressWarnings("rawtypes")
	List  list(QasDVirtualsimulationcenter bean);
	
	int delete(Object id);

	int batchDelete(Object[] ids);
	
}

