package	com.deceen.data.major.majorCourse.service;

import java.util.*;
import com.deceen.data.major.majorCourse.model.QasDMajorcourse;
import com.deceen.data.major.majorCourse.mapper.QasDMajorcourseMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDMajorcourseAction.java
* @Description: qas_d_majorcourse
* @author upaths@gmail.com  
* @date 2017-11-23 16:07:46
* @version V1.0   
*/
@Component("qasDMajorcourseService")	
@SuppressWarnings({ "rawtypes" })
public class QasDMajorcourseService  extends CommonService {

		private QasDMajorcourseMapper mapper;
	
		public QasDMajorcourse select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDMajorcourse  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDMajorcourse bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */  
		public int updateWithDyna(QasDMajorcourse bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		/** 批量插入 */
		public int[] batchInsert(List list){
			return batchDelete(list, QasDMajorcourseMapper.class.getName()+".insert");
		}
		
		public List list(QasDMajorcourse bean){
			return queryPageList(QasDMajorcourseMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDMajorcourseMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDMajorcourseMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDMajorcourseMapper.class;
		}
}
