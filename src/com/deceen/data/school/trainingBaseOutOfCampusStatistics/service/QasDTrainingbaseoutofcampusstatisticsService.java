package	com.deceen.data.school.trainingBaseOutOfCampusStatistics.service;

import java.util.*;
import com.deceen.data.school.trainingBaseOutOfCampusStatistics.model.QasDTrainingbaseoutofcampusstatistics;
import com.deceen.data.school.trainingBaseOutOfCampusStatistics.mapper.QasDTrainingbaseoutofcampusstatisticsMapper;
import com.sun.tools.apt.Main;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDTrainingbaseoutofcampusstatisticsAction.java
* @Description: qas_d_trainingbaseoutofcampusstatistics
* @author upaths@gmail.com  
* @date 2017-11-22 17:58:43
* @version V1.0   
*/
@Component("qasDTrainingbaseoutofcampusstatisticsService") 
@SuppressWarnings({ "rawtypes" })
public class QasDTrainingbaseoutofcampusstatisticsService  extends CommonService {

		private QasDTrainingbaseoutofcampusstatisticsMapper mapper;
	
		public QasDTrainingbaseoutofcampusstatistics select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDTrainingbaseoutofcampusstatistics  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			
			return	mapper.insert(bean);
		}
		
		public int update(QasDTrainingbaseoutofcampusstatistics bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */   
		public int updateWithDyna(QasDTrainingbaseoutofcampusstatistics bean){
		bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		/** 批量插入 */
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDTrainingbaseoutofcampusstatisticsMapper.class.getName()+".insert");
		}
		
		public List list(Map map){
			return queryPageList(QasDTrainingbaseoutofcampusstatisticsMapper.class.getName()+".list", map);
		}
		
		public List list(QasDTrainingbaseoutofcampusstatistics bean){
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
			
			if(bean.getNumofprojectname()!=null && bean.getNumofprojectname()!=""){
				String numofprojectname=bean.getNumofprojectname();
				map.put("numofprojectname", numofprojectname);
			}
			
			//获取下拉列表的范围(eg:5000-8000)
			if(bean.getNumofstureceivedScope()!=null && bean.getNumofstureceivedScope()!=""  && "--请选择--".equals(bean.getNumofstureceivedScope())==false){
				String numofstureceivedScope=bean.getNumofstureceivedScope();
				if(!numofstureceivedScope.contains("以上")){
					Integer minnumofstureceivedScope=Integer.parseInt(numofstureceivedScope.split("-")[0]);
					Integer maxnumofstureceivedScope=Integer.parseInt(numofstureceivedScope.split("-")[1]);
					map.put("minnumofstureceivedScope", minnumofstureceivedScope);
					map.put("maxnumofstureceivedScope", maxnumofstureceivedScope);
				}else{
					numofstureceivedScope=numofstureceivedScope.replace("以上", "");
					map.put("numofstureceivedScope", numofstureceivedScope);
				}
			}
			
			if(bean.getBaseusetimeScope()!=null && bean.getBaseusetimeScope()!=""  && "--请选择--".equals(bean.getBaseusetimeScope())==false){
				String baseusetimeScope=bean.getBaseusetimeScope();
				if(!baseusetimeScope.contains("以上")){
					Integer minbaseusetimeScope=Integer.parseInt(baseusetimeScope.split("-")[0]);
					Integer maxbaseusetimeScope=Integer.parseInt(baseusetimeScope.split("-")[1]);
					map.put("minbaseusetimeScope", minbaseusetimeScope);
					map.put("maxbaseusetimeScope", maxbaseusetimeScope);
				}else{
					baseusetimeScope=baseusetimeScope.replace("以上", "");
					map.put("baseusetimeScope", baseusetimeScope);
				}
			}
			
			//获取下拉列表的范围(eg:5000-8000)
			if(bean.getHalfyearinternshipstudentScope()!=null && bean.getHalfyearinternshipstudentScope()!=""  && "--请选择--".equals(bean.getHalfyearinternshipstudentScope())==false){
				String halfyearinternshipstudentScope=bean.getHalfyearinternshipstudentScope();
				if(!halfyearinternshipstudentScope.contains("以上")){
					Integer minhalfyearinternshipstudentScope=Integer.parseInt(halfyearinternshipstudentScope.split("-")[0]);
					Integer maxhalfyearinternshipstudentScope=Integer.parseInt(halfyearinternshipstudentScope.split("-")[1]);
					map.put("minhalfyearinternshipstudentScope", minhalfyearinternshipstudentScope);
					map.put("maxhalfyearinternshipstudentScope", maxhalfyearinternshipstudentScope);
				}else{
					halfyearinternshipstudentScope=halfyearinternshipstudentScope.replace("以上", "");
					map.put("halfyearinternshipstudentScope", halfyearinternshipstudentScope);
				}
			}
			
			if(bean.getIsaccommodationconditions()!=null && bean.getIsaccommodationconditions()!=""){
				String isaccommodationconditions=bean.getIsaccommodationconditions();
				map.put("isaccommodationconditions", isaccommodationconditions);
			}
			return this.list(map);
		}
		
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDTrainingbaseoutofcampusstatisticsMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDTrainingbaseoutofcampusstatisticsMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDTrainingbaseoutofcampusstatisticsMapper.class;
		}
}
