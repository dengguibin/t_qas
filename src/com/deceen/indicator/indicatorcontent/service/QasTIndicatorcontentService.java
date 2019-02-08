package	com.deceen.indicator.indicatorcontent.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.deceen.indicator.indicatorcatalog.model.QasTIndicatorcatalog;
import com.deceen.indicator.indicatorcatalog.service.QasTIndicatorcatalogService;
import com.deceen.indicator.indicatorcatalogextend.mapper.QasTIndicatorcatalogextendMapper;
import com.deceen.indicator.indicatorcatalogextend.model.QasTIndicatorcatalogextend;
import com.deceen.indicator.indicatorcontent.mapper.QasTIndicatorcontentMapper;
import com.deceen.indicator.indicatorcontent.model.QasTIndicatorcontent;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;
/**
* 指标内容的Service
* @ClassName: QasTIndicatorcontentAction.java
* @Description: qas_t_indicatorcontent
* @author upaths@gmail.com  
* @date 2017-11-9 15:56:08
* @version V1.0   
*/
@Component("qasTIndicatorcontentService")	
public class QasTIndicatorcontentService  extends CommonService {
		
	private QasTIndicatorcontentMapper indicatorcontentMapper;
	
	@Autowired
	private QasTIndicatorcatalogService indicatorcatalogService;
	
	@Autowired
	private QasTIndicatorcatalogextendMapper indicatorcatalogextendmapper;

	public QasTIndicatorcontent select(Object indicatorcatalogid){
		return	indicatorcontentMapper.select(indicatorcatalogid);
	}
	
	public QasTIndicatorcatalogextend selectextend(Object indicatorcatalogid){
		return indicatorcatalogextendmapper.select(indicatorcatalogid);
	}
	
	
	

	public int insert(QasTIndicatorcontent  bean, QasTIndicatorcatalogextend extend){
		
		//指标目录
		QasTIndicatorcatalog indicatorcatalog = new QasTIndicatorcatalog();
		indicatorcatalog.setId(IDGenerator.getUUID());
		indicatorcatalog.setName_(bean.getName_());
		indicatorcatalog.setParentid(bean.getParentindicatorcontentid());
		indicatorcatalog.setRemark(bean.getRemark());
		indicatorcatalog.setIndicatortype(0);
		indicatorcatalog.setCreatedby(bean.getCreatedby());
		indicatorcatalog.setCreatedtime(new Date());
		indicatorcatalog.setUpdatedtime(new Date());
		indicatorcatalog.setIsvalid(QasTIndicatorcatalog.ISVALID_DEFAULT);
		indicatorcatalogService.insert(indicatorcatalog, null);
		
		//指标内容
		bean.setId(IDGenerator.getUUID());
		bean.setIndicatorcatalogid(indicatorcatalog.getId());
		bean.setCreatedtime(new Date());
		bean.setUpdatedtime(new Date());
		
		if(extend!=null){
			extend.setId(IDGenerator.getUUID());
			extend.setIndicatorcatalogid(bean.getIndicatorcatalogid());
			indicatorcatalogextendmapper.insert(extend);
			
		}
		return	indicatorcontentMapper.insert(bean);
	}
	
	public int update(QasTIndicatorcontent bean){
		return indicatorcontentMapper.update(bean);
	}
	
	/** 动态更新*/
	public int updateWithDyna(QasTIndicatorcontent bean,QasTIndicatorcatalogextend extend){
		
		if (null != extend) {
			if(extend.getIndicatorcatalogid() != null && "".equals(extend.getIndicatorcatalogid()) == false){
				indicatorcatalogextendmapper.updateWithDyna(extend);
			}else{
				extend.setId(IDGenerator.getUUID());
				extend.setIndicatorcatalogid(bean.getIndicatorcatalogid());
				indicatorcatalogextendmapper.insert(extend);
			}
		}
		
		//修改指标目录
		QasTIndicatorcatalog dsIndicatorcatalog =new QasTIndicatorcatalog();
		dsIndicatorcatalog.setId(bean.getIndicatorcatalogid());
		dsIndicatorcatalog.setName_(bean.getName_());		//重复了，后期看是否可以优化！
		dsIndicatorcatalog.setRemark(bean.getRemark());		//重复了，后期看是否可以优化！
		indicatorcatalogService.updateWithDynas(dsIndicatorcatalog);
		
		//修改指标内容
		bean.setUpdatedtime(new Date());
		return indicatorcontentMapper.updateWithDyna(bean);
	}
	
	/** 批量插入*/
	@SuppressWarnings("rawtypes")
	public int[] batchInsert(List list){
		return batchDelete(list, QasTIndicatorcontentMapper.class.getName()+".insert");
	}
	
	@SuppressWarnings("rawtypes")
	public List list(QasTIndicatorcontent bean){
		return queryPageList(QasTIndicatorcontentMapper.class.getName()+".list", bean);
	}
		
	public int delete(Object id){
		return 	indicatorcontentMapper.delete(id);
	}
	
	public int delete(Object[] ids){
		for (Object id : ids) {
			this.delete(id);
		}
		return 0;
	}
	
	public QasTIndicatorcontent selectBypersonal(Object indicatorcatalogid) {
		return indicatorcontentMapper.selectBypersonal(indicatorcatalogid);
	}
		
	public QasTIndicatorcontentMapper getMapper() {
		return indicatorcontentMapper;
	}
	
	@Autowired
	public void setMapper(QasTIndicatorcontentMapper mapper) {
		this.indicatorcontentMapper = mapper;
	}
	
	@SuppressWarnings("rawtypes")
	public Class getMapperClass(){
		return QasTIndicatorcontentMapper.class;
	}
}
