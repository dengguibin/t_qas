package	com.deceen.data.teacher.teacherPartTimeWork.service;

import java.util.*;
import com.deceen.data.teacher.teacherPartTimeWork.model.QasDTeacherparttimework;
import com.deceen.data.teacher.teacherPartTimeWork.mapper.QasDTeacherparttimeworkMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDTeacherparttimeworkAction.java
* @Description: qas_d_teacherparttimework
* @author upaths@gmail.com  
* @date 2017-11-23 12:31:22
* @version V1.0   
*/
@Component("qasDTeacherparttimeworkService")	
@SuppressWarnings({ "rawtypes" })
public class QasDTeacherparttimeworkService  extends CommonService {

		private QasDTeacherparttimeworkMapper mapper;
	
		public QasDTeacherparttimework select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDTeacherparttimework  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			
			return	mapper.insert(bean);
		}
		
		public int update(QasDTeacherparttimework bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */ 
		public int updateWithDyna(QasDTeacherparttimework bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		/** 批量插入 */
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDTeacherparttimeworkMapper.class.getName()+".insert");
		}
		
		public List list(QasDTeacherparttimework bean){
			return queryPageList(QasDTeacherparttimeworkMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDTeacherparttimeworkMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDTeacherparttimeworkMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDTeacherparttimeworkMapper.class;
		}
}
