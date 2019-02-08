package	com.deceen.data.school.leaderAction.service;

import java.util.*;
import com.deceen.data.school.leaderAction.model.QasDLeaderaction;
import com.deceen.data.school.leaderAction.mapper.QasDLeaderactionMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDLeaderactionAction.java
* @Description: qas_d_leaderaction
* @author upaths@gmail.com  
* @date 2017-11-22 17:43:40
* @version V1.0   
*/
@Component("qasDLeaderactionService")	
@SuppressWarnings({ "rawtypes" })
public class QasDLeaderactionService  extends CommonService {

		private QasDLeaderactionMapper mapper;
	
		public QasDLeaderaction select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDLeaderaction  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDLeaderaction bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */   
		public int updateWithDyna(QasDLeaderaction bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		 /** 批量插入 */
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDLeaderactionMapper.class.getName()+".insert");
		}
		
		
		public List list(Map map){
			return queryPageList(QasDLeaderactionMapper.class.getName()+".list", map);
		}
		
		public List list(QasDLeaderaction bean){
			Map map=new HashMap();
			if(bean.getEmployeeid()!=null && bean.getEmployeeid()!=""){
				String employeeid=bean.getEmployeeid();
				map.put("employeeid", employeeid);
			}
			//获取下拉列表的范围(eg:5000-8000)
			if(bean.getLecturecountScope()!=null && bean.getLecturecountScope()!=""  && "--请选择--".equals(bean.getLecturecountScope())==false){
				String lecturecountScope=bean.getLecturecountScope();
				if(!lecturecountScope.contains("以上")){
					Integer minlecturecountScope=Integer.parseInt(lecturecountScope.split("-")[0]);
					Integer maxlecturecountScope=Integer.parseInt(lecturecountScope.split("-")[1]);
					map.put("minlecturecountScope", minlecturecountScope);
					map.put("maxlecturecountScope", maxlecturecountScope);
				}else{
					lecturecountScope=lecturecountScope.replace("以上", "");
					map.put("lecturecountScope", lecturecountScope);
				}
			}
			
			//获取下拉列表的范围(eg:5000-8000)
			if(bean.getInterviewcountScope()!=null && bean.getInterviewcountScope()!=""  && "--请选择--".equals(bean.getInterviewcountScope())==false){
				String interviewcountScope=bean.getInterviewcountScope();
				if(!interviewcountScope.contains("以上")){
					Integer mininterviewcountScope=Integer.parseInt(interviewcountScope.split("-")[0]);
					Integer maxinterviewcountScope=Integer.parseInt(interviewcountScope.split("-")[1]);
					map.put("mininterviewcountScope", mininterviewcountScope);
					map.put("maxinterviewcountScope", maxinterviewcountScope);
				}else{
					interviewcountScope=interviewcountScope.replace("以上", "");
					map.put("interviewcountScope", interviewcountScope);
				}
			}
			
			//获取下拉列表的范围(eg:5000-8000)
			if(bean.getPracticalsessioncountScope()!=null && bean.getPracticalsessioncountScope()!=""  && "--请选择--".equals(bean.getPracticalsessioncountScope())==false){
				String practicalsessioncountScope=bean.getPracticalsessioncountScope();
				if(!practicalsessioncountScope.contains("以上")){
					Integer minpracticalsessioncountScope=Integer.parseInt(practicalsessioncountScope.split("-")[0]);
					Integer maxpracticalsessioncountScope=Integer.parseInt(practicalsessioncountScope.split("-")[1]);
					map.put("minpracticalsessioncountScope", minpracticalsessioncountScope);
					map.put("maxpracticalsessioncountScope", maxpracticalsessioncountScope);
				}else{
					practicalsessioncountScope=practicalsessioncountScope.replace("以上", "");
					map.put("practicalsessioncountScope", practicalsessioncountScope);
				}
			}
			
			//获取下拉列表的范围(eg:5000-8000)
			if(bean.getStudentassociationcountScope()!=null && bean.getStudentassociationcountScope()!=""  && "--请选择--".equals(bean.getStudentassociationcountScope())==false){
				String studentassociationcountScope=bean.getStudentassociationcountScope();
				if(!studentassociationcountScope.contains("以上")){
					Integer minstudentassociationcountScope=Integer.parseInt(studentassociationcountScope.split("-")[0]);
					Integer maxstudentassociationcountScope=Integer.parseInt(studentassociationcountScope.split("-")[1]);
					map.put("minstudentassociationcountScope", minstudentassociationcountScope);
					map.put("maxstudentassociationcountScope", maxstudentassociationcountScope);
				}else{
					studentassociationcountScope=studentassociationcountScope.replace("以上", "");
					map.put("studentassociationcountScope", studentassociationcountScope);
				}
			}
			
			//获取下拉列表的范围(eg:5000-8000)
			if(bean.getParttimecountScope()!=null && bean.getParttimecountScope()!=""  && "--请选择--".equals(bean.getParttimecountScope())==false){
				String parttimecountScope=bean.getParttimecountScope();
				if(!parttimecountScope.contains("以上")){
					Integer minparttimecountScope=Integer.parseInt(parttimecountScope.split("-")[0]);
					Integer maxparttimecountScope=Integer.parseInt(parttimecountScope.split("-")[1]);
					map.put("minparttimecountScope", minparttimecountScope);
					map.put("maxparttimecountScope", maxparttimecountScope);
				}else{
					parttimecountScope=parttimecountScope.replace("以上", "");
					map.put("parttimecountScope", parttimecountScope);
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
			
		public QasDLeaderactionMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDLeaderactionMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDLeaderactionMapper.class;
		}
}
