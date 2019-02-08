package	com.deceen.diagnoseformat.scheme.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deceen.diagnoseformat.scheme.mapper.QasTIndicatorratedefinitionMapper;
import com.deceen.diagnoseformat.scheme.mapper.QasTSchemecatalogMapper;
import com.deceen.diagnoseformat.scheme.model.QasTIndicatorratedefinition;
import com.deceen.diagnoseformat.scheme.model.QasTSchemecatalog;
import com.deceen.indicator.indicatorcatalog.mapper.QasTIndicatorcatalogMapper;
import com.deceen.indicator.indicatorcatalog.model.QasTIndicatorcatalog;
import com.deceen.indicator.indicatorcontent.mapper.QasTIndicatorcontentMapper;
import com.deceen.indicator.indicatorcontent.model.QasTIndicatorcontent;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;
/**
* 
* @ClassName: QasTSchemecatalogAction.java
* @Description: qas_t_schemecatalog
* @author upaths@gmail.com  
* @date 2017-11-15 18:15:21
* @version V1.0   
*/
@Component("qasTSchemecatalogService")	
@SuppressWarnings("rawtypes")
public class QasTSchemecatalogService  extends CommonService {

	private QasTSchemecatalogMapper schemecatalogMapper;
	
	@Autowired
	private QasTIndicatorratedefinitionMapper indicatorratedefinition;
	
	@Autowired
	private QasTIndicatorcontentMapper indicatorcontentMapper;
	
	@Autowired
	private QasTIndicatorcatalogMapper indicatorcatalogMapper;

	public QasTSchemecatalog select(String id){
		QasTSchemecatalog scheme = new QasTSchemecatalog();
		scheme.setId(id);
		return	schemecatalogMapper.select(scheme);
	}
	
	public int insert(QasTSchemecatalog  bean){
		return	schemecatalogMapper.insert(bean);
	}
	
	public int insertlist(List<QasTSchemecatalog> list, String schemeid){
		//删除之前关联指标积分预警
		QasTSchemecatalog scheme = new QasTSchemecatalog();
		scheme.setSchemeid(schemeid);
		indicatorratedefinition.deleteBySchemeId(scheme);
		//删除之前模板指标关联信息
		schemecatalogMapper.deleteschemeId(schemeid);
		//插入新的模板指标信息
		return schemecatalogMapper.insertlist(list);
	}
	
	public int insertlistAll(List<QasTIndicatorratedefinition> indicatorratede,List<QasTSchemecatalog> list, String schemeid){
		//删除之前关联指标积分预警
		QasTSchemecatalog scheme = new QasTSchemecatalog();
		scheme.setSchemeid(schemeid);
		/*scheme = schemecatalogMapper.select(scheme);
		QasTIndicatorcontent indicatorcontent = indicatorcontentMapper.select(scheme.getIndicatorcatalogid());*/
		for (int i=0;i<indicatorratede.size();i++) {
			indicatorratede.get(i).setId(IDGenerator.getUUID());
			indicatorratede.get(i).setSchemeid(scheme.getSchemeid());
			/*indicatorratedes.get(i).setIndicatorcontentid(indicatorcontent.getId());*/
			indicatorratede.get(i).setSort(i);
		}
		indicatorratedefinition.deleteBySchemeId(scheme);
		//插入内容
		indicatorratedefinition.batchInsert(indicatorratede);
		//删除之前模板指标关联信息
		schemecatalogMapper.deleteschemeId(schemeid);
		//插入新的模板指标信息
		return schemecatalogMapper.insertlist(list);
	}

	public int update(QasTSchemecatalog bean){
		return schemecatalogMapper.update(bean);
	}
	
	public int updateWithDyna(QasTSchemecatalog bean, String parentId){
		//修改父级状态
		schemecatalogMapper.updateWithDyna(bean);
		updateparentSchemeIsValid(parentId,bean.getSchemeid());
		return 1;
	}
	/* 
	public int[] batchInsert(List list){
		batchDelete(list, QasTSchemecatalogMapper.class.getName()+".insert");
		return 0;
	}
	*/
	public List list(QasTSchemecatalog bean){
		return queryPageList(QasTSchemecatalogMapper.class.getName()+".list", bean);
	}
		
	public int delete(Object id){
		return 	schemecatalogMapper.delete(id);
	};
	
	public int deleteschemeId(Object schemeid){
		return 	schemecatalogMapper.deleteschemeId(schemeid);
	};
	
	public int delete(Object[] ids){
		List list = Arrays.asList(ids);
		batchDelete(list, QasTSchemecatalogMapper.class.getName()+".delete");
		return 0;
	};
		
	public QasTSchemecatalogMapper getMapper() {
		return schemecatalogMapper;
	}
	
	@Autowired
	public void setMapper(QasTSchemecatalogMapper mapper) {
		this.schemecatalogMapper = mapper;
	}
	
	public Class getMapperClass(){
		return QasTSchemecatalogMapper.class;
	}

	public List<QasTSchemecatalog> getTree() {
		return schemecatalogMapper.listAll();
	}

	public List<Map<String, Object>> inditorCount() {
		return schemecatalogMapper.inditorCount();
	}

	public List<Map<String, Object>> selectTree(Map<String, String> params) {
		return schemecatalogMapper.selectTree(params);
	}

	public List<QasTSchemecatalog> selectSchemeId(Map<String, String> params) {
		return schemecatalogMapper.selectSchemeId(params);
	}

	public void updateIndicatorRate(List<QasTIndicatorratedefinition> indicatorratedes,QasTSchemecatalog scheme, String parentId) {
		//修改当前模型指标分值
		schemecatalogMapper.updateWithDyna(scheme);
		scheme = schemecatalogMapper.select(scheme);
		QasTIndicatorcontent indicatorcontent = indicatorcontentMapper.select(scheme.getIndicatorcatalogid());
		scheme.setIndicatorcatalogid(indicatorcontent.getId());
		indicatorratedefinition.deleteBySchemeId(scheme);
		for (int i=0;i<indicatorratedes.size();i++) {
			indicatorratedes.get(i).setId(IDGenerator.getUUID());
			indicatorratedes.get(i).setSchemeid(scheme.getSchemeid());
			indicatorratedes.get(i).setIndicatorcontentid(indicatorcontent.getId());
			indicatorratedes.get(i).setSort(i);
		}
		//修改统计父级模型指标分值
		//updateParentSchemeScore(parentId,scheme.getSchemeid());
		//修改父级状态
		updateparentSchemeIsValid(parentId,scheme.getSchemeid());
		
		indicatorratedefinition.batchInsert(indicatorratedes);
	}
	
	/**
	 * 统计当前同一父指标总分赋值给父指标
	 * @param parentId
	 * @param schemeId
	 */
	private void updateParentSchemeScore(String parentId,String schemeId){
		if(null != parentId && !"".equals(parentId)){
			Map<String,String> parems = new HashMap<String, String>();
			parems.put("schemeid", schemeId);
			parems.put("parentid", parentId);
			schemecatalogMapper.updateCountParentScore(parems);
			
			QasTIndicatorcatalog ic = indicatorcatalogMapper.select(parentId);
			if(ic != null){
				updateParentSchemeScore(ic.getParentid(),schemeId);
			}
		}
	}
	
	/**
	 * 判断当前同一父指标是否全部有效，有效则修改父指标有效
	 * @param scheme 
	 * @param parentId 
	 */
	private void updateparentSchemeIsValid(String parentId, String schemeId){
		if(null != parentId && !"".equals(parentId)){
			//统计父指标下的子指标isvalid为0的个数
			Map<String,String> parems = new HashMap<String, String>();
			parems.put("schemeid", schemeId);
			parems.put("parentid", parentId);
			int count = schemecatalogMapper.countIsvalid(parems);
			QasTSchemecatalog schemecatalog = new QasTSchemecatalog();
			schemecatalog.setIndicatorcatalogid(parentId);
			schemecatalog.setSchemeid(schemeId);
			schemecatalog = schemecatalogMapper.select(schemecatalog);
			if(count == 0){
				schemecatalogMapper.updateCountParentScore(parems);
				if(schemecatalog.getWeight()>=0){
					schemecatalogMapper.updateParentIsvalid(parems);
					QasTIndicatorcatalog ic = indicatorcatalogMapper.select(parentId);
					if(ic != null){
						updateparentSchemeIsValid(ic.getParentid(),schemeId);
					}
				}
			}
		}
		
	}
	
	public List selectIndicatorRate(String id) {
		return indicatorratedefinition.selectIndicatorRate(id);
	}
	
	public List selectIndicatorRateAll(String id) {
		return indicatorratedefinition.selectIndicatorRateAll(id);
	}

	public float selectCountWeight(QasTSchemecatalog scheme) {
		float weight = (float)0;
		QasTIndicatorcatalog ic = indicatorcatalogMapper.select(scheme.getIndicatorcatalogid());
		if(ic.getIndicatortype()!=null && ic.getIndicatortype()==3){  //当前指标为要素类型
			weight = schemecatalogMapper.selectCountWeightByElement(scheme);
		}else if(ic.getIndicatortype()!=null && ic.getIndicatortype()==2){//当前指标为项目类型
			weight = schemecatalogMapper.selectCountWeightByProject(scheme);
		}
		return weight;
	}

	public int countIsvalid(String id) {
		Map<String,String> parems = new HashMap<String, String>();
		parems.put("schemeid", id);
		return schemecatalogMapper.countIsvalid(parems);
	}
}
