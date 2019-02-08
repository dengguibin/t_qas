package	com.deceen.data.teaching.filesOfTeachingManageMent.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deceen.data.teaching.filesOfTeachingManageMent.mapper.QasDFilesofteachingmanagementMapper;
import com.deceen.data.teaching.filesOfTeachingManageMent.model.QasDFilesofteachingmanagement;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;
/**
* 
* @ClassName: QasDFilesofteachingmanagementAction.java
* @Description: qas_d_filesofteachingmanagement
* @author upaths@gmail.com  
* @date 2017-11-24 12:13:39
* @version V1.0   
*/
@Component("qasDFilesofteachingmanagementService")	
@SuppressWarnings({ "rawtypes" })
public class QasDFilesofteachingmanagementService  extends CommonService {

		private QasDFilesofteachingmanagementMapper mapper;
	
		public QasDFilesofteachingmanagement select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDFilesofteachingmanagement  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDFilesofteachingmanagement bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
//		 需要时请开启,动态进行更新,批量插入实现
		public int updateWithDyna(QasDFilesofteachingmanagement bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		
		public int[] batchInsert(List list){
			return batchDelete(list, QasDFilesofteachingmanagementMapper.class.getName()+".insert");
		}
		
		public List list(QasDFilesofteachingmanagement bean){
			return queryPageList(QasDFilesofteachingmanagementMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDFilesofteachingmanagementMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDFilesofteachingmanagementMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDFilesofteachingmanagementMapper.class;
		}
}
