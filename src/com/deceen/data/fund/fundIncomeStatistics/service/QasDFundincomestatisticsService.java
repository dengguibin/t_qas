package	com.deceen.data.fund.fundIncomeStatistics.service;

import java.util.*;

import com.deceen.data.fund.fundCostStatistics.mapper.QasDFundcoststatisticsMapper;
import com.deceen.data.fund.fundIncomeStatistics.model.QasDFundincomestatistics;
import com.deceen.data.fund.fundIncomeStatistics.mapper.QasDFundincomestatisticsMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDFundincomestatisticsAction.java
* @Description: qas_d_fundincomestatistics
* @author upaths@gmail.com  
* @date 2017-11-23 12:15:54
* @version V1.0   
*/
@Component("qasDFundincomestatisticsService")	
@SuppressWarnings("rawtypes")
public class QasDFundincomestatisticsService  extends CommonService {

		private QasDFundincomestatisticsMapper mapper;
	
		public QasDFundincomestatistics select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDFundincomestatistics  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			
			return	mapper.insert(bean);
		}
		
		public int update(QasDFundincomestatistics bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/**动态进行更新*/ 
		public int updateWithDyna(QasDFundincomestatistics bean){
		bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		/**批量插入*/
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDFundincomestatisticsMapper.class.getName()+".insert");
		}
		
		public List list(Map map){
			return queryPageList(QasDFundincomestatisticsMapper.class.getName()+ ".list", map);
			
		}
		
		
		public List list(QasDFundincomestatistics bean){
			
			Map map=new HashMap();
			//获取下拉列表的范围(eg:5000-8000)
			if(bean.getSchoolincomeScope()!=null && bean.getSchoolincomeScope()!=""  && "--请选择--".equals(bean.getSchoolincomeScope())==false){
				String getSchoolincomeScope=bean.getSchoolincomeScope();
					if(!getSchoolincomeScope.contains("以上")){
						Integer minScope=Integer.parseInt(getSchoolincomeScope.split("-")[0]);
						Integer maxScope=Integer.parseInt(getSchoolincomeScope.split("-")[1]);
						map.put("minScope", minScope);
						map.put("maxScope", maxScope);
					}else{
						getSchoolincomeScope=getSchoolincomeScope.replace("以上", "");
						map.put("getSchoolincomeScope", getSchoolincomeScope);
					}
			}
			if(bean.getTenantid()!=null && bean.getTenantid()!=""){
				String tenantid=bean.getTenantid();
				map.put("tenantid", tenantid);
			}
			if(bean.getCreatedby()!=null && bean.getCreatedby()!=""){
				String createdby=bean.getCreatedby();
				map.put("createdby", createdby);
			}
			if(bean.getUpdatedby()!=null && bean.getUpdatedby()!=""){
				String updatedby=bean.getUpdatedby();
				map.put("updatedby", updatedby);
			}
			if(bean.getCreatedtime()!=null){
				Date createdtime=bean.getCreatedtime();
				map.put("createdtime", createdtime);
			}
			if(bean.getUpdatedtime()!=null){
				Date updatedtime=bean.getUpdatedtime();
				map.put("updatedtime", updatedtime);
			}
			//return queryPageList(QasDFundincomestatisticsMapper.class.getName()+ ".list", map);
			return this.list(map);
			
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDFundincomestatisticsMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDFundincomestatisticsMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDFundincomestatisticsMapper.class;
		}
}
