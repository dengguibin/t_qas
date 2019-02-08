package	com.deceen.indicator.indicatorcatalogextend.mapper;

import java.util.*;
import org.springframework.stereotype.Component;

import com.deceen.indicator.indicatorcatalogextend.model.QasTIndicatorcatalogextend;

@Component("qasTIndicatorcatalogextendMapper")
public interface QasTIndicatorcatalogextendMapper {

	QasTIndicatorcatalogextend select(Object indicatorcatalogid);
	
	int insert(QasTIndicatorcatalogextend bean);
	
	int update(QasTIndicatorcatalogextend bean);
	
	int updateWithDyna(QasTIndicatorcatalogextend bean);

	@SuppressWarnings("rawtypes")
	List  list(QasTIndicatorcatalogextend bean);
	
	int delete(Object id);
	
}

