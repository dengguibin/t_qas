package	com.deceen.data.teacher.teacherResearch.service;

import java.util.*;
import com.deceen.data.teacher.teacherResearch.model.QasDTeacherresearch;
import com.deceen.data.teacher.teacherResearch.mapper.QasDTeacherresearchMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDTeacherresearchAction.java
* @Description: qas_d_teacherresearch
* @author upaths@gmail.com  
* @date 2017-11-23 12:33:15
* @version V1.0   
*/
@Component("qasDTeacherresearchService")	
@SuppressWarnings({ "rawtypes" })
public class QasDTeacherresearchService  extends CommonService {

		private QasDTeacherresearchMapper mapper;
	
		public QasDTeacherresearch select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDTeacherresearch  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDTeacherresearch bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */  
		public int updateWithDyna(QasDTeacherresearch bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		/** 批量插入 */
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDTeacherresearchMapper.class.getName()+".insert");
		}
		
		public List list(QasDTeacherresearch bean){
			return queryPageList(QasDTeacherresearchMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDTeacherresearchMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDTeacherresearchMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDTeacherresearchMapper.class;
		}
}
