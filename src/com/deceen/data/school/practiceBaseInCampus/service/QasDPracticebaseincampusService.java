package	com.deceen.data.school.practiceBaseInCampus.service;

import java.util.*;
import com.deceen.data.school.practiceBaseInCampus.model.QasDPracticebaseincampus;
import com.deceen.data.school.practiceBaseInCampus.mapper.QasDPracticebaseincampusMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDPracticebaseincampusAction.java
* @Description: qas_d_practicebaseincampus
* @author upaths@gmail.com  
* @date 2017-11-22 17:51:44
* @version V1.0   
*/
@Component("qasDPracticebaseincampusService")	
@SuppressWarnings({ "rawtypes" })
public class QasDPracticebaseincampusService  extends CommonService {

		private QasDPracticebaseincampusMapper mapper;
	
		public QasDPracticebaseincampus select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDPracticebaseincampus  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			
			return	mapper.insert(bean);
		}
		
		public int update(QasDPracticebaseincampus bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */  
		public int updateWithDyna(QasDPracticebaseincampus bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		 /** 批量插入 */
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDPracticebaseincampusMapper.class.getName()+".insert");
		}
		
		public List list(Map map){
			return queryPageList(QasDPracticebaseincampusMapper.class.getName()+".list", map);
		}
			
		public List list(QasDPracticebaseincampus bean){
			
			Map map=new HashMap();
			if(bean.getName()!=null && bean.getName()!=""){
				String name=bean.getName();
				map.put("name", name);
			}
			
			if(bean.getSupportdepartment()!=null && bean.getSupportdepartment()!=""){
				String supportdepartment=bean.getSupportdepartment();
				map.put("supportdepartment", supportdepartment);
			}
			
			if(bean.getApprovaldate()!=null && bean.getApprovaldate()!=""){
				String approvaldate=bean.getApprovaldate();
				map.put("approvaldate", approvaldate);
			}
			//获取下拉列表的范围(eg:5000-8000)
			if(bean.getConstructionareaScope()!=null && bean.getConstructionareaScope()!=""  && "--请选择--".equals(bean.getConstructionareaScope())==false){
				String constructionareaScope=bean.getConstructionareaScope();
				if(!constructionareaScope.contains("以上")){
					Integer minconstructionareaScope=Integer.parseInt(constructionareaScope.split("-")[0]);
					Integer maxconstructionareaScope=Integer.parseInt(constructionareaScope.split("-")[1]);
					map.put("minconstructionareaScope", minconstructionareaScope);
					map.put("maxconstructionareaScope", maxconstructionareaScope);
				}else{
					constructionareaScope=constructionareaScope.replace("以上", "");
					map.put("constructionareaScope", constructionareaScope);
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
			
		public QasDPracticebaseincampusMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDPracticebaseincampusMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDPracticebaseincampusMapper.class;
		}
}
