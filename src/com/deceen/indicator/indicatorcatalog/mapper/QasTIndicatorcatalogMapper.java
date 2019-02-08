package	com.deceen.indicator.indicatorcatalog.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import com.deceen.indicator.indicatorcatalog.model.QasTIndicatorcatalog;

@Component("qasTIndicatorcatalogMapper")
public interface QasTIndicatorcatalogMapper {

	QasTIndicatorcatalog select(Object id);
	
	int insert(QasTIndicatorcatalog bean);
	
	int update(QasTIndicatorcatalog bean);

	int updateWithDyna(QasTIndicatorcatalog bean);

	@SuppressWarnings("rawtypes")
	List  list(QasTIndicatorcatalog bean);
	
	int delete(Object id);

	List<QasTIndicatorcatalog>  list();
	
	List<QasTIndicatorcatalog> queryByParentId(String id);
	
	List<QasTIndicatorcatalog> selectTree(String name);

	int batchDelete(List<Object> ids);
	
	/**
	 * 根据任意表字段查询
	 * @param parems
	 * @return
	 */
	List<QasTIndicatorcatalog> queryParams(Map<String, Object> parems);

	QasTIndicatorcatalog queryByParentIdToMaxSort(String id);

	List<Map<String, Object>> inditorCount(@Param("vague")Object vague);

	/**
	 * 获取某个模型的某个类型下的所有项目
	 * @param params(INDICATORCATALOGID:类型的id, SCHEMEID:模型的id)
	 * 获取某个模型的某个项目下的所有要素
	 * @param params(INDICATORCATALOGID:项目的id, SCHEMEID:模型的id)
	 * @return
	 */
	List<QasTIndicatorcatalog> selectByParams(Map<String, Object> params);
	
	/**
	 * 获取目录类型为1的父级目录Id列表
	 * @return
	 */
	List<String> selectIndicatorType();
}

