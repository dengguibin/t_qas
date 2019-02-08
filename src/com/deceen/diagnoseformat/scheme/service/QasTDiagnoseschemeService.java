package	com.deceen.diagnoseformat.scheme.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deceen.diagnoseformat.scheme.mapper.QasTDiagnoseschemeMapper;
import com.deceen.diagnoseformat.scheme.mapper.QasTIndicatorratedefinitionMapper;
import com.deceen.diagnoseformat.scheme.mapper.QasTSchemecatalogMapper;
import com.deceen.diagnoseformat.scheme.model.QasTDiagnosescheme;
import com.deceen.diagnoseformat.scheme.model.QasTSchemecatalog;
import com.upath.plat.common.cache.CacheManager;
import com.upath.plat.common.cache.ICacheCode;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;
/**
* 
* @ClassName: QasTDiagnoseschemeAction.java
* @Description: qas_t_diagnosescheme
* @author upaths@gmail.com  
* @date 2017-11-15 17:50:55
* @version V1.0   
*/
@SuppressWarnings("rawtypes")
@Component("qasTDiagnoseschemeService")	
public class QasTDiagnoseschemeService extends CommonService {

	private QasTDiagnoseschemeMapper diagnoseschemeMapper;
	
	private QasTSchemecatalogMapper schemecatalogMapper;
	
	@Autowired
	private QasTIndicatorratedefinitionMapper indicatorratedefinition;

	public QasTDiagnosescheme select(Object id) {
		return diagnoseschemeMapper.select(id);
	}
	
	public List getdiagnosescheme(QasTDiagnosescheme bean){
		return diagnoseschemeMapper.findtype(bean);
	}
	
	public int insert(QasTDiagnosescheme bean) {
		bean.setId(IDGenerator.getUUID());
		bean.setStatus(0);
		return diagnoseschemeMapper.insert(bean);
	}
	

	public int update(QasTDiagnosescheme bean) {
		return diagnoseschemeMapper.update(bean);
	}
	
	public int updateWithDyna(QasTDiagnosescheme bean){
	return diagnoseschemeMapper.updateWithDyna(bean); }
	  
	/* public int[] batchInsert(List list){ batchDelete(list,
	 QasTDiagnoseschemeMapper.class.getName()+".insert"); return 0; }*/
	 
	
	public List list(QasTDiagnosescheme bean){
		return queryPageList(QasTDiagnoseschemeMapper.class.getName()+".list", bean);
	}

	public int delete(String id) {
		QasTSchemecatalog scheme = new QasTSchemecatalog();
		scheme.setSchemeid(id);
		//删除指标预警设置表
		indicatorratedefinition.deleteBySchemeId(scheme);
		//删除模板指标
		schemecatalogMapper.deleteschemeId(id);
		return diagnoseschemeMapper.delete(id);
	};

	public int delete(Object[] ids) {
		List list = Arrays.asList(ids);
		batchDelete(list, QasTDiagnoseschemeMapper.class.getName() + ".delete");
		return 0;
	};

	public QasTDiagnoseschemeMapper getDiagnoseschemeMapper() {
		return diagnoseschemeMapper;
	}
	@Autowired
	public void setDiagnoseschemeMapper(
			QasTDiagnoseschemeMapper diagnoseschemeMapper) {
		this.diagnoseschemeMapper = diagnoseschemeMapper;
	}

	public QasTSchemecatalogMapper getSchemecatalogMapper() {
		return schemecatalogMapper;
	}
	@Autowired
	public void setSchemecatalogMapper(QasTSchemecatalogMapper schemecatalogMapper) {
		this.schemecatalogMapper = schemecatalogMapper;
	}

	public Class getMapperClass() {
		return QasTDiagnoseschemeMapper.class;
	}

	public List<QasTDiagnosescheme> selectBean(QasTDiagnosescheme diagnose) {
		return diagnoseschemeMapper.selectBean(diagnose);
	}

	public int selectTask(String id) {
		return diagnoseschemeMapper.selectTask(id);
	}

	@SuppressWarnings("unchecked")
	public Map<String,List<QasTDiagnosescheme>> typeList(QasTDiagnosescheme diagnose) {
		List<QasTDiagnosescheme> list = diagnoseschemeMapper.typeList(diagnose);
		Map<String,List<QasTDiagnosescheme>> maps= null;
		if(diagnose.getRangetype()!=null){// 按类型分类
			maps = new TreeMap<String,List<QasTDiagnosescheme>>(new Comparator<String>(){  
				//重写TreeMap的比较器
		        /* 
		         * int compare(Object o1, Object o2) 返回一个基本类型的整型， 
		         * 返回负数表示：o1 小于o2， 
		         * 返回0 表示：o1和o2相等， 
		         * 返回正数表示：o1大于o2。 
		         */  
		        public int compare(String o1, String o2) {  

		            //指定排序器按照降序排列  
		            return o2.compareTo(o1);  
		        }     
		    });
			List<ICacheCode> codes = CacheManager.getInstance().getCodes("INDICATORTYPE");
			Map<String,String> type = new HashMap<String,String>();
			for (ICacheCode code : codes) {
				type.put(code.getSubcode(), code.getCname());
			}
			for (QasTDiagnosescheme ds : list) {
				String name = type.get(ds.getRangetype()+"");
				if(StringUtils.isEmpty(name)){
					name = "null";
				}
				if(maps.containsKey(name)){
					maps.get(name).add(ds);
				}else{
					maps.put(name, (new ArrayList<QasTDiagnosescheme>()));
					maps.get(name).add(ds);
				}
			}
		}else{// 按时间分类
			maps = new LinkedHashMap<String,List<QasTDiagnosescheme>>();
			for (QasTDiagnosescheme ds : list) {
				if(maps.containsKey(ds.getYear())){
					maps.get(ds.getYear()).add(ds);
				}else{
					maps.put(ds.getYear(), (new ArrayList<QasTDiagnosescheme>()));
					maps.get(ds.getYear()).add(ds);
				}
			}
		}
		return maps;
	}

	public void publish(QasTDiagnosescheme diagnose) {
		diagnoseschemeMapper.updateWithDyna(diagnose);
	}
}
