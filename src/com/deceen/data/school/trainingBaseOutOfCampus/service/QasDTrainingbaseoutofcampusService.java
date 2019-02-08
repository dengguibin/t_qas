package	com.deceen.data.school.trainingBaseOutOfCampus.service;

import java.util.*;
import com.deceen.data.school.trainingBaseOutOfCampus.model.QasDTrainingbaseoutofcampus;
import com.deceen.data.school.trainingBaseOutOfCampus.mapper.QasDTrainingbaseoutofcampusMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDTrainingbaseoutofcampusAction.java
* @Description: qas_d_trainingbaseoutofcampus
* @author upaths@gmail.com  
* @date 2017-11-22 17:58:05
* @version V1.0   
*/
@Component("qasDTrainingbaseoutofcampusService")	
@SuppressWarnings({ "rawtypes" })
public class QasDTrainingbaseoutofcampusService  extends CommonService {

		private QasDTrainingbaseoutofcampusMapper mapper;
	
		public QasDTrainingbaseoutofcampus select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDTrainingbaseoutofcampus  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			
			return	mapper.insert(bean);
		}
		
		public int update(QasDTrainingbaseoutofcampus bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */  
		public int updateWithDyna(QasDTrainingbaseoutofcampus bean){
		bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		/** 批量插入 */
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDTrainingbaseoutofcampusMapper.class.getName()+".insert");
		}
		
		public List list(QasDTrainingbaseoutofcampus bean){
			return queryPageList(QasDTrainingbaseoutofcampusMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDTrainingbaseoutofcampusMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDTrainingbaseoutofcampusMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDTrainingbaseoutofcampusMapper.class;
		}
}
