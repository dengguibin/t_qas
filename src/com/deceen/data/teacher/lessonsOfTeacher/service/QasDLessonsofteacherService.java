package	com.deceen.data.teacher.lessonsOfTeacher.service;

import java.util.*;
import com.deceen.data.teacher.lessonsOfTeacher.model.QasDLessonsofteacher;
import com.deceen.data.teacher.lessonsOfTeacher.mapper.QasDLessonsofteacherMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDLessonsofteacherAction.java
* @Description: qas_d_lessonsofteacher
* @author upaths@gmail.com  
* @date 2017-11-23 12:34:30
* @version V1.0   
*/
@Component("qasDLessonsofteacherService")	
@SuppressWarnings({ "rawtypes" })
public class QasDLessonsofteacherService  extends CommonService {

		private QasDLessonsofteacherMapper mapper;
	
		public QasDLessonsofteacher select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDLessonsofteacher  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			
			return	mapper.insert(bean);
		}
		
		public int update(QasDLessonsofteacher bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */  
		public int updateWithDyna(QasDLessonsofteacher bean){
		bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		/** 批量插入 */
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDLessonsofteacherMapper.class.getName()+".insert");
		}
		
		public List list(QasDLessonsofteacher bean){
			return queryPageList(QasDLessonsofteacherMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDLessonsofteacherMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDLessonsofteacherMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDLessonsofteacherMapper.class;
		}
}
