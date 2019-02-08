package	com.deceen.data.teaching.studentManagement.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deceen.data.teaching.studentManagement.mapper.QasDStudentmanagementMapper;
import com.deceen.data.teaching.studentManagement.model.QasDStudentmanagement;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;
/**
* 
* @ClassName: QasDStudentmanagementAction.java
* @Description: qas_d_studentmanagement
* @author upaths@gmail.com  
* @date 2017-11-24 12:14:24
* @version V1.0   
*/
@Component("qasDStudentmanagementService")	
@SuppressWarnings({ "rawtypes" })
public class QasDStudentmanagementService  extends CommonService {

		private QasDStudentmanagementMapper mapper;
	
		public QasDStudentmanagement select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDStudentmanagement  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDStudentmanagement bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
//		 ？需要时请开启,动态进行更新,批量插入实现
		public int updateWithDyna(QasDStudentmanagement bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDStudentmanagementMapper.class.getName()+".insert");
		}
		
		public List list(QasDStudentmanagement bean){
			return queryPageList(QasDStudentmanagementMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDStudentmanagementMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDStudentmanagementMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDStudentmanagementMapper.class;
		}
}
