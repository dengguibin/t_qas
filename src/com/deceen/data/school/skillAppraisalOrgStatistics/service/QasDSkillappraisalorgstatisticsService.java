package	com.deceen.data.school.skillAppraisalOrgStatistics.service;

import java.util.*;
import com.deceen.data.school.skillAppraisalOrgStatistics.model.QasDSkillappraisalorgstatistics;
import com.deceen.data.school.skillAppraisalOrgStatistics.mapper.QasDSkillappraisalorgstatisticsMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDSkillappraisalorgstatisticsAction.java
* @Description: qas_d_skillappraisalorgstatistics
* @author upaths@gmail.com  
* @date 2017-11-22 17:59:47
* @version V1.0   
*/
@Component("qasDSkillappraisalorgstatisticsService")	
@SuppressWarnings({ "rawtypes" })
public class QasDSkillappraisalorgstatisticsService  extends CommonService {

		private QasDSkillappraisalorgstatisticsMapper mapper;
	
		public QasDSkillappraisalorgstatistics select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDSkillappraisalorgstatistics  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			
			return	mapper.insert(bean);
		}
		
		public int update(QasDSkillappraisalorgstatistics bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */   
		public int updateWithDyna(QasDSkillappraisalorgstatistics bean){
		bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		/** 批量插入 */
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDSkillappraisalorgstatisticsMapper.class.getName()+".insert");
		}
		
		public List list(Map map){
			return queryPageList(QasDSkillappraisalorgstatisticsMapper.class.getName()+".list", map);
		}
		
		public List list(QasDSkillappraisalorgstatistics bean){
			Map map=new HashMap();
			if(bean.getSkillappraisalorgid()!=null && bean.getSkillappraisalorgid()!=""){
				String skillappraisalorgid=bean.getSkillappraisalorgid();
				map.put("skillappraisalorgid", skillappraisalorgid);
			}
			
			//获取下拉列表的范围(eg:5000-8000)
			if(bean.getSocietyScope()!=null && bean.getSocietyScope()!=""  && "--请选择--".equals(bean.getSocietyScope())==false){
				String societyScope=bean.getSocietyScope();
				if(!societyScope.contains("以上")){
					Integer minsocietyScope=Integer.parseInt(societyScope.split("-")[0]);
					Integer maxsocietyScope=Integer.parseInt(societyScope.split("-")[1]);
					map.put("minsocietyScope", minsocietyScope);
					map.put("maxsocietyScope", maxsocietyScope);
				}else{
					societyScope=societyScope.replace("以上", "");
					map.put("societyScope", societyScope);
				}
			}

			//获取下拉列表的范围(eg:5000-8000)
			if(bean.getStudentinschoolScope()!=null && bean.getStudentinschoolScope()!=""  && "--请选择--".equals(bean.getStudentinschoolScope())==false){
				String studentinschoolScope=bean.getStudentinschoolScope();
				if(!studentinschoolScope.contains("以上")){
					Integer minstudentinschoolScope=Integer.parseInt(studentinschoolScope.split("-")[0]);
					Integer maxstudentinschoolScope=Integer.parseInt(studentinschoolScope.split("-")[1]);
					map.put("minstudentinschoolScope", minstudentinschoolScope);
					map.put("maxstudentinschoolScope", maxstudentinschoolScope);
				}else{
					studentinschoolScope=studentinschoolScope.replace("以上", "");
					map.put("studentinschoolScope", studentinschoolScope);
				}
			}
			
			if(bean.getCertificate()!=null && bean.getCertificate()!=""){
				String certificate=bean.getCertificate();
				map.put("certificate", certificate);
			}
			
			if(bean.getLevel()!=null && bean.getLevel()!=""){
				String level=bean.getLevel();
				map.put("level", level);
			}
			return this.list(map);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDSkillappraisalorgstatisticsMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDSkillappraisalorgstatisticsMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDSkillappraisalorgstatisticsMapper.class;
		}
}
