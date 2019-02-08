package	com.deceen.data.teacher.teacherTeachingTrain.service;

import java.util.*;
import com.deceen.data.teacher.teacherTeachingTrain.model.QasDTeacherteachingtrain;
import com.deceen.data.teacher.teacherTeachingTrain.mapper.QasDTeacherteachingtrainMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDTeacherteachingtrainAction.java
* @Description: qas_d_teacherteachingtrain
* @author upaths@gmail.com  
* @date 2017-11-23 12:29:49
* @version V1.0   
*/
@Component("qasDTeacherteachingtrainService")	
@SuppressWarnings({ "rawtypes" })
public class QasDTeacherteachingtrainService  extends CommonService {

		private QasDTeacherteachingtrainMapper mapper;
	
		public QasDTeacherteachingtrain select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDTeacherteachingtrain  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDTeacherteachingtrain bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */  
		public int updateWithDyna(QasDTeacherteachingtrain bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		/** 批量插入 */
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDTeacherteachingtrainMapper.class.getName()+".insert");
		}
		
		public List list(QasDTeacherteachingtrain bean){
			return queryPageList(QasDTeacherteachingtrainMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDTeacherteachingtrainMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDTeacherteachingtrainMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDTeacherteachingtrainMapper.class;
		}
}
