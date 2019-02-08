package	com.deceen.data.teacher.teacherSecondment.service;

import java.util.*;
import com.deceen.data.teacher.teacherSecondment.model.QasDTeachersecondment;
import com.deceen.data.teacher.teacherSecondment.mapper.QasDTeachersecondmentMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDTeachersecondmentAction.java
* @Description: qas_d_teachersecondment
* @author upaths@gmail.com  
* @date 2017-11-23 14:56:55
* @version V1.0   
*/
@Component("qasDTeachersecondmentService")	
@SuppressWarnings({ "rawtypes" })
public class QasDTeachersecondmentService  extends CommonService {

		private QasDTeachersecondmentMapper mapper;
	
		public QasDTeachersecondment select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDTeachersecondment  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDTeachersecondment bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */  
		public int updateWithDyna(QasDTeachersecondment bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
	    /** 批量插入 */
		public int[] batchInsert(List list){
			return batchDelete(list, QasDTeachersecondmentMapper.class.getName()+".insert");
		}
		
		public List list(QasDTeachersecondment bean){
			return queryPageList(QasDTeachersecondmentMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDTeachersecondmentMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDTeachersecondmentMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDTeachersecondmentMapper.class;
		}
}
