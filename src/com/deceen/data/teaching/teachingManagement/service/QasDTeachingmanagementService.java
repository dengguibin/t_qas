package	com.deceen.data.teaching.teachingManagement.service;

import java.util.*;
import com.deceen.data.teaching.teachingManagement.model.QasDTeachingmanagement;
import com.deceen.data.teaching.teachingManagement.mapper.QasDTeachingmanagementMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDTeachingmanagementAction.java
* @Description: qas_d_teachingmanagement
* @author upaths@gmail.com  
* @date 2017-11-24 12:12:21
* @version V1.0   
*/
@Component("qasDTeachingmanagementService")	
@SuppressWarnings({ "rawtypes" })
public class QasDTeachingmanagementService  extends CommonService {

		private QasDTeachingmanagementMapper mapper;
	
		public QasDTeachingmanagement select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDTeachingmanagement  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDTeachingmanagement bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
//		 需要时请开启,动态进行更新,批量插入实现
		public int updateWithDyna(QasDTeachingmanagement bean){
		bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDTeachingmanagementMapper.class.getName()+".insert");
		}
		
		public List list(QasDTeachingmanagement bean){
			return queryPageList(QasDTeachingmanagementMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDTeachingmanagementMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDTeachingmanagementMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDTeachingmanagementMapper.class;
		}
}
