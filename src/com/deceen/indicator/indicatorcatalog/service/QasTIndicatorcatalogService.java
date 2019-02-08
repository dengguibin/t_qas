package	com.deceen.indicator.indicatorcatalog.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deceen.indicator.indicatorcatalog.mapper.QasTIndicatorcatalogMapper;
import com.deceen.indicator.indicatorcatalog.model.QasTIndicatorcatalog;
import com.deceen.indicator.indicatorcatalogextend.mapper.QasTIndicatorcatalogextendMapper;
import com.deceen.indicator.indicatorcatalogextend.model.QasTIndicatorcatalogextend;
import com.deceen.indicator.indicatorcontent.mapper.QasTIndicatorcontentMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;
/**
* 
* @ClassName: QasTIndicatorcatalogAction.java
* @Description: qas_t_indicatorcatalog
* @author upaths@gmail.com  
* @date 2017-11-8 14:18:50
* @version V1.0   
*/
@Component("qasTIndicatorcatalogService")	
public class QasTIndicatorcatalogService  extends CommonService {

	private QasTIndicatorcatalogMapper mapper;
	@Autowired
	private QasTIndicatorcontentMapper indicatorcontent;
	@Autowired
	private QasTIndicatorcatalogextendMapper indicatorcatalogextendmapper;

	public QasTIndicatorcatalog select(Object id){
		return	mapper.select(id);
	}
	
	public QasTIndicatorcatalogextend selectextend(Object indicatorcatalogid){
		return indicatorcatalogextendmapper.select(indicatorcatalogid);
	}
	
	public int insert(QasTIndicatorcatalog bean, QasTIndicatorcatalogextend extend){
		if(null == bean.getSort()){
			bean.setSort(bean.createSort(mapper, bean.getParentid()));
		}
		bean.setId(IDGenerator.getUUID());
		bean.setCreatedtime(new Date());
		bean.setUpdatedtime(new Date());
		String name_ = bean.getName_();
		if (null != name_) {
			name_=name_.replace("&ldquo;", "“").replace("&rdquo;", "”");
		}
		String remark = bean.getRemark();
		if (null != remark) {
			remark=remark.replace("&ldquo;", "“").replace("&rdquo;", "”");
		}
		bean.setName_(name_);
		bean.setRemark(remark);
		bean.setIsvalid(QasTIndicatorcatalog.ISVALID_DEFAULT);
		bean.setIsmonitor("0");//是否支持实时监控：0：不支持，1支持
		if(extend!=null){
			extend.setId(IDGenerator.getUUID());
			extend.setIndicatorcatalogid(bean.getId());
			indicatorcatalogextendmapper.insert(extend);
		}
		return	mapper.insert(bean);
	}
	
	public int update(QasTIndicatorcatalog bean){
		bean.setUpdatedtime(new Date());
		return mapper.update(bean);
	}
	
	public int updateWithDyna(QasTIndicatorcatalog bean, QasTIndicatorcatalogextend extend){
		if (null != extend) {
			if(extend.getIndicatorcatalogid() != null && "".equals(extend.getIndicatorcatalogid()) == false){
				indicatorcatalogextendmapper.updateWithDyna(extend);
			}else{
				extend.setId(IDGenerator.getUUID());
				extend.setIndicatorcatalogid(bean.getId());
				indicatorcatalogextendmapper.insert(extend);//新增指标目录扩展表（QAS_T_INDICATORCATALOGEXTEND）
			}
		}
		String name_=bean.getName_().replace("&ldquo;", "“").replace("&rdquo;", "”");
		String remark=bean.getRemark().replace("&ldquo;", "“").replace("&rdquo;", "”");
		bean.setName_(name_);
		bean.setRemark(remark);
		bean.setUpdatedtime(new Date());
		return mapper.updateWithDyna(bean);
	}
	
	public int updateWithDynas(QasTIndicatorcatalog bean){
		String name_=bean.getName_().replace("&ldquo;", "“").replace("&rdquo;", "”");
		String remark=bean.getRemark().replace("&ldquo;", "“").replace("&rdquo;", "”");
		bean.setName_(name_);
		bean.setRemark(remark);
		bean.setUpdatedtime(new Date());
		return mapper.updateWithDyna(bean);
	}
	
	public int updateWithIsMmonitor(QasTIndicatorcatalog bean) {
		return mapper.updateWithDyna(bean);
	}
	
/*	public int[] batchInsert(List list){
		batchDelete(list, QasTIndicatorcatalogMapper.class.getName()+".insert");
		return 0;
	}
	*/
	@SuppressWarnings("rawtypes")
	public List list(QasTIndicatorcatalog bean){
		return queryPageList(QasTIndicatorcatalogMapper.class.getName()+".list", bean);
	}
	
	/**
	 * 删除指标目录与全部子目录
	 * @param id
	 * @return
	 */
	public int delete(Object id){
		indicatorcontent.delete(id);
		indicatorcatalogextendmapper.delete(id);
		return 	mapper.delete(id);
	}
	
	/**
	 * 获取指定目录的所有子目录id
	 * @param id
	 * @return
	 */
	private List<Object> getChildIds(String id){
		List<Object> ids = new ArrayList<Object>();
		List<QasTIndicatorcatalog> bean = mapper.queryByParentId(id);
		for (QasTIndicatorcatalog indicatorcatalog : bean) {
			ids.add(indicatorcatalog.getId());
			ids.addAll(getChildIds(indicatorcatalog.getId()));
		}
		return ids;
	}
	
	public int delete(Object[] ids) {
		List<Object> list = new ArrayList<Object>();
		list.addAll(Arrays.asList(ids));
		for (Object id : ids) {
			list.addAll(getChildIds((String)id));
		}
		indicatorcontent.batchDelete(list);
		return mapper.batchDelete(list);
	}
		
	
	public QasTIndicatorcatalog findById(String id) {
		return  mapper.select(id);
	}
	
	public QasTIndicatorcatalogMapper getMapper() {
		return mapper;
	}
	
	@Autowired
	public void setMapper(QasTIndicatorcatalogMapper mapper) {
		this.mapper = mapper;
	}
	
	@SuppressWarnings("rawtypes")
	public Class getMapperClass(){
		return QasTIndicatorcatalogMapper.class;
	}

	public List<QasTIndicatorcatalog> getTree() {
		return mapper.list();
	}
	
	public List<QasTIndicatorcatalog> selectTree(String name) {
		return mapper.selectTree(name);
	}
	
	public List<QasTIndicatorcatalog> selectChilds(String id){
		return mapper.queryByParentId(id);
	}

	public List<Map<String, Object>> inditorCount(Object vague) {
		return mapper.inditorCount(vague);
	}

	public List<QasTIndicatorcatalog> queryParams(Integer sort) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("sort", sort);
		return mapper.queryParams(params);
	}
	public List<String> selectIndicatorType(){
		
		return mapper.selectIndicatorType();
	}
}
