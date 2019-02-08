package	com.deceen.diagnoseformat.scheme.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.deceen.diagnoseformat.scheme.model.QasTSchemecatalog;
import com.deceen.indicator.indicatorcatalog.model.QasTIndicatorcatalog;

@Component("qasTSchemecatalogMapper")
public interface QasTSchemecatalogMapper {

	QasTSchemecatalog select(QasTSchemecatalog scheme);
	
	QasTSchemecatalog select(Map<String,String> params);
	
	int insert(QasTSchemecatalog bean);
	
	int update(QasTSchemecatalog bean);
	
	int updateWithDyna(QasTSchemecatalog bean);
	
	List<QasTSchemecatalog>  list(QasTSchemecatalog bean);
	
	int delete(Object id);
	
	int deleteschemeId(Object schemeid);
	
	List<QasTSchemecatalog>  listAll();
	
	List<Map<String, Object>> inditorCount();
	
	List<Map<String, Object>> selectTree(Map<String, String> params);

	int insertlist(List<QasTSchemecatalog> list);

	List<QasTSchemecatalog> selectSchemeId(Map<String, String> params);

	List<QasTSchemecatalog> selectParams(Map<String, Object> params);
	
	//测试
	//QasTIndicatorcatalog selectIndicatorcatalog(Map<String, Object> params);

	List<QasTSchemecatalog> selectByTaskId(String taskid);

	void updateCountParentScore(Map<String, String> parems);

	float selectCountWeightByProject(QasTSchemecatalog scheme);

	float selectCountWeightByElement(QasTSchemecatalog scheme);

	int countIsvalid(Map<String, String> parems);

	void updateParentIsvalid(Map<String, String> parems);

	List<QasTIndicatorcatalog> selectElementByUser(Map<String, Object> params);
	
}

