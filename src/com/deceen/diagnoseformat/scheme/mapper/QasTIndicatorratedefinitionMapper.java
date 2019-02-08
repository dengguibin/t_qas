package	com.deceen.diagnoseformat.scheme.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.deceen.diagnoseformat.scheme.model.QasTIndicatorratedefinition;
import com.deceen.diagnoseformat.scheme.model.QasTSchemecatalog;

@Component("qasTIndicatorratedefinitionMapper")
public interface QasTIndicatorratedefinitionMapper {

	QasTIndicatorratedefinition select(Object id);
	
	int insert(QasTIndicatorratedefinition bean);
	
	int update(QasTIndicatorratedefinition bean);
	/* 需要时请开启,动态进行更新
	int updateWithDyna(QasTIndicatorratedefinition bean);
	*/
	@SuppressWarnings("rawtypes")
	List  list(QasTIndicatorratedefinition bean);
	
	int delete(Object id);

	List<QasTIndicatorratedefinition> selectByParams(Map<String, Object> params);

	void batchInsert(List<QasTIndicatorratedefinition> indicatorratedes);

	void deleteBySchemeId(QasTSchemecatalog scheme);
	
	@SuppressWarnings("rawtypes")
	List selectIndicatorRate(String id);
	@SuppressWarnings("rawtypes")
	List selectIndicatorRateAll(String id);
	
}

