package	com.deceen.data.school.school.service;

import java.util.*;
import com.deceen.data.school.school.model.QasDSchool;
import com.deceen.data.school.school.mapper.QasDSchoolMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDSchoolAction.java
* @Description: qas_d_school
* @author upaths@gmail.com  
* @date 2017-11-22 17:18:45
* @version V1.0   
*/
@Component("qasDSchoolService")	
@SuppressWarnings({ "rawtypes"  })
public class QasDSchoolService  extends CommonService {

		private QasDSchoolMapper mapper;
	
		public QasDSchool select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDSchool  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDSchool bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */  
		public int updateWithDyna(QasDSchool bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		/** 批量插入 */
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDSchoolMapper.class.getName()+".insert");
		}
		
		public List list(QasDSchool bean){
			return queryPageList(QasDSchoolMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDSchoolMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDSchoolMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDSchoolMapper.class;
		}
}
