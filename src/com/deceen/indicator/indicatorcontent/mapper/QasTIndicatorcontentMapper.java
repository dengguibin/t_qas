package	com.deceen.indicator.indicatorcontent.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.deceen.indicator.indicatorcontent.model.QasTIndicatorcontent;

@Component("qasTIndicatorcontentMapper")
@SuppressWarnings("rawtypes")
public interface QasTIndicatorcontentMapper {
	
	 //根据用户以及是否被监视查询相关的指标(目前只查询指标名称)
	List<QasTIndicatorcontent> findNameBywarning(@Param("user")String user);
	
	QasTIndicatorcontent select(Object indicatorcatalogid);
	
	int insert(QasTIndicatorcontent bean);
	
	int update(QasTIndicatorcontent bean);

	/**动态更新*/
	int updateWithDyna(QasTIndicatorcontent bean);
	
	List  list(QasTIndicatorcontent bean);
	
	int delete(Object id);

	int batchDelete(List<Object> list);

	/**
	 * 获取某个模型的某个要素下的所有指标
	 * @param params(INDICATORCATALOGID:要素的id, SCHEMEID:模型的id)
	 * @return
	 */
	List<QasTIndicatorcontent> selectByParams(Map<String, Object> params);
	
	List<HashMap<String,Object>> queryDataBySql(@Param("sql")String sql);
	
	List<HashMap<String,Object>> queryDataBySql1(HashMap map);

	List<QasTIndicatorcontent> selectIndicatorByElementAndUser(Map<String, Object> params);
	
	/**
	 * 个人面板模块（根据指标id查询指标内容）
	 * @param indicatorcatalogid
	 * @param userid
	 * @return
	 */
	QasTIndicatorcontent selectBypersonal(@Param("indicatorcatalogid")Object indicatorcatalogid);
}

