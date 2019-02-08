package	com.deceen.data.school.practiceBaseInCampusStatistics.service;

import java.util.*;
import com.deceen.data.school.practiceBaseInCampusStatistics.model.QasDPracticebaseincampusstatistics;
import com.deceen.data.school.practiceBaseInCampusStatistics.mapper.QasDPracticebaseincampusstatisticsMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDPracticebaseincampusstatisticsAction.java
* @Description: qas_d_practicebaseincampusstatistics
* @author upaths@gmail.com  
* @date 2017-11-22 17:52:24
* @version V1.0   
*/
@Component("qasDPracticebaseincampusstatisticsService")	
@SuppressWarnings({ "rawtypes" })
public class QasDPracticebaseincampusstatisticsService  extends CommonService {

		private QasDPracticebaseincampusstatisticsMapper mapper;
	
		public QasDPracticebaseincampusstatistics select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDPracticebaseincampusstatistics  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			
			return	mapper.insert(bean);
		}
		
		public int update(QasDPracticebaseincampusstatistics bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */   
		public int updateWithDyna(QasDPracticebaseincampusstatistics bean){
		bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		/** 批量插入 */
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDPracticebaseincampusstatisticsMapper.class.getName()+".insert");
		}
		
		public List list(Map map){
			return queryPageList(QasDPracticebaseincampusstatisticsMapper.class.getName()+".list", map);
		}
		
		public List list(QasDPracticebaseincampusstatistics bean){
			Map map=new HashMap();
			if(bean.getPracticebaseincampusid()!=null && bean.getPracticebaseincampusid()!=""){
				String practicebaseincampusid=bean.getPracticebaseincampusid();
				map.put("practicebaseincampusid", practicebaseincampusid);
			}
			
			if(bean.getMajorid()!=null && bean.getMajorid()!=""){
				String majorid=bean.getMajorid();
				map.put("majorid", majorid);
			}
			
			//获取下拉列表的范围(eg:5000-8000)
			if(bean.getAveragetimeperyearScope()!=null && bean.getAveragetimeperyearScope()!=""  && "--请选择--".equals(bean.getAveragetimeperyearScope())==false){
				String averagetimeperyearScope=bean.getAveragetimeperyearScope();
				if(!averagetimeperyearScope.contains("以上")){
					Integer minaveragetimeperyearScope=Integer.parseInt(averagetimeperyearScope.split("-")[0]);
					Integer maxaveragetimeperyearScope=Integer.parseInt(averagetimeperyearScope.split("-")[1]);
					map.put("minaveragetimeperyearScope", minaveragetimeperyearScope);
					map.put("maxaveragetimeperyearScope", maxaveragetimeperyearScope);
				}else{
					averagetimeperyearScope=averagetimeperyearScope.replace("以上", "");
					map.put("averagetimeperyearScope", averagetimeperyearScope);
				}
			}
			
			if(bean.getNumoftrainingprojectScope()!=null && bean.getNumoftrainingprojectScope()!=""  && "--请选择--".equals(bean.getNumoftrainingprojectScope())==false){
				String numoftrainingprojectScope=bean.getNumoftrainingprojectScope();
				if(!numoftrainingprojectScope.contains("以上")){
					Integer minnumoftrainingprojectScope=Integer.parseInt(numoftrainingprojectScope.split("-")[0]);
					Integer maxnumoftrainingprojectScope=Integer.parseInt(numoftrainingprojectScope.split("-")[1]);
					map.put("minnumoftrainingprojectScope", minnumoftrainingprojectScope);
					map.put("maxnumoftrainingprojectScope", maxnumoftrainingprojectScope);
				}else{
					numoftrainingprojectScope=numoftrainingprojectScope.replace("以上", "");
					map.put("numoftrainingprojectScope", numoftrainingprojectScope);
				}
			}
			
			if(bean.getNumofprojectnameScope()!=null && bean.getNumofprojectnameScope()!=""  && "--请选择--".equals(bean.getNumofprojectnameScope())==false){
				String numofprojectnameScope=bean.getNumofprojectnameScope();
				if(!numofprojectnameScope.contains("以上")){
					Integer minnumofprojectnameScope=Integer.parseInt(numofprojectnameScope.split("-")[0]);
					Integer maxnumofprojectnameScope=Integer.parseInt(numofprojectnameScope.split("-")[1]);
					map.put("minnumofprojectnameScope", minnumofprojectnameScope);
					map.put("maxnumofprojectnameScope", maxnumofprojectnameScope);
				}else{
					numofprojectnameScope=numofprojectnameScope.replace("以上", "");
					map.put("numofprojectnameScope", numofprojectnameScope);
				}
			}
			
			if(bean.getNumofworkerScope()!=null && bean.getNumofworkerScope()!=""  && "--请选择--".equals(bean.getNumofworkerScope())==false){
				String numofworkerScope=bean.getNumofworkerScope();
				if(!numofworkerScope.contains("以上")){
					Integer minnumofworkerScope=Integer.parseInt(numofworkerScope.split("-")[0]);
					Integer maxnumofworkerScope=Integer.parseInt(numofworkerScope.split("-")[1]);
					map.put("minnumofworkerScope", minnumofworkerScope);
					map.put("maxnumofworkerScope", maxnumofworkerScope);
				}else{
					numofworkerScope=numofworkerScope.replace("以上", "");
					map.put("numofworkerScope", numofworkerScope);
				}
			}
			
			if(bean.getCostofconsumptiveScope()!=null && bean.getCostofconsumptiveScope()!=""  && "--请选择--".equals(bean.getCostofconsumptiveScope())==false){
				String costofconsumptiveScope=bean.getCostofconsumptiveScope();
				if(!costofconsumptiveScope.contains("以上")){
					Integer mincostofconsumptiveScope=Integer.parseInt(costofconsumptiveScope.split("-")[0]);
					Integer maxcostofconsumptiveScope=Integer.parseInt(costofconsumptiveScope.split("-")[1]);
					map.put("mincostofconsumptiveScope", mincostofconsumptiveScope);
					map.put("maxcostofconsumptiveScope", maxcostofconsumptiveScope);
				}else{
					costofconsumptiveScope=costofconsumptiveScope.replace("以上", "");
					map.put("costofconsumptiveScope", costofconsumptiveScope);
				}
			}
			
			if(bean.getCostofmaterialsScope()!=null && bean.getCostofmaterialsScope()!=""  && "--请选择--".equals(bean.getCostofmaterialsScope())==false){
				String costofmaterialsScope=bean.getCostofmaterialsScope();
				if(!costofmaterialsScope.contains("以上")){
					Integer mincostofmaterialsScope=Integer.parseInt(costofmaterialsScope.split("-")[0]);
					Integer maxcostofmaterialsScope=Integer.parseInt(costofmaterialsScope.split("-")[1]);
					map.put("mincostofmaterialsScope", mincostofmaterialsScope);
					map.put("maxcostofmaterialsScope", maxcostofmaterialsScope);
				}else{
					costofmaterialsScope=costofmaterialsScope.replace("以上", "");
					map.put("costofmaterialsScope", costofmaterialsScope);
				}
			}
			
			if(bean.getFulltimemanagementScope()!=null && bean.getFulltimemanagementScope()!=""  && "--请选择--".equals(bean.getFulltimemanagementScope())==false){
				String fulltimemanagementScope=bean.getFulltimemanagementScope();
				if(!fulltimemanagementScope.contains("以上")){
					Integer minfulltimemanagementScope=Integer.parseInt(fulltimemanagementScope.split("-")[0]);
					Integer maxfulltimemanagementScope=Integer.parseInt(fulltimemanagementScope.split("-")[1]);
					map.put("minfulltimemanagementScope", minfulltimemanagementScope);
					map.put("maxfulltimemanagementScope", maxfulltimemanagementScope);
				}else{
					fulltimemanagementScope=fulltimemanagementScope.replace("以上", "");
					map.put("fulltimemanagementScope", fulltimemanagementScope);
				}
			}
			
			if(bean.getParttimemanagementScope()!=null && bean.getParttimemanagementScope()!=""  && "--请选择--".equals(bean.getParttimemanagementScope())==false){
				String parttimemanagementScope=bean.getParttimemanagementScope();
				if(!parttimemanagementScope.contains("以上")){
					Integer minparttimemanagementScope=Integer.parseInt(parttimemanagementScope.split("-")[0]);
					Integer maxparttimemanagementScope=Integer.parseInt(parttimemanagementScope.split("-")[1]);
					map.put("minparttimemanagementScope", minparttimemanagementScope);
					map.put("maxparttimemanagementScope", maxparttimemanagementScope);
				}else{
					parttimemanagementScope=parttimemanagementScope.replace("以上", "");
					map.put("parttimemanagementScope", parttimemanagementScope);
				}
			}
			return this.list(map);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDPracticebaseincampusstatisticsMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDPracticebaseincampusstatisticsMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDPracticebaseincampusstatisticsMapper.class;
		}
}
