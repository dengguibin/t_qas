package	com.deceen.data.teacher.teacherTraining.service;

import java.util.*;
import com.deceen.data.teacher.teacherTraining.model.QasDTeachertraining;
import com.deceen.data.teacher.teacherTraining.mapper.QasDTeachertrainingMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDTeachertrainingAction.java
* @Description: qas_d_teachertraining
* @author upaths@gmail.com  
* @date 2017-11-23 12:30:17
* @version V1.0   
*/
@Component("qasDTeachertrainingService")	
@SuppressWarnings({ "rawtypes" })
public class QasDTeachertrainingService  extends CommonService {

		private QasDTeachertrainingMapper mapper;
	
		public QasDTeachertraining select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDTeachertraining  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDTeachertraining bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */   
		public int updateWithDyna(QasDTeachertraining bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		/** 批量插入 */
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDTeachertrainingMapper.class.getName()+".insert");
		}
		
		public List list(QasDTeachertraining bean){
			return queryPageList(QasDTeachertrainingMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDTeachertrainingMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDTeachertrainingMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDTeachertrainingMapper.class;
		}
}
