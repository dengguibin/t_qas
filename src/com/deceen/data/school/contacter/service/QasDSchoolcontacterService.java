package	com.deceen.data.school.contacter.service;

import java.util.*;
import com.deceen.data.school.contacter.model.QasDSchoolcontacter;
import com.deceen.data.school.contacter.mapper.QasDSchoolcontacterMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDSchoolcontacterAction.java
* @Description: qas_d_schoolcontacter
* @author upaths@gmail.com  
* @date 2017-11-22 17:30:20
* @version V1.0   
*/
@Component("qasDSchoolcontacterService")
@SuppressWarnings({ "rawtypes" })
public class QasDSchoolcontacterService  extends CommonService {

		private QasDSchoolcontacterMapper mapper;
	
		public QasDSchoolcontacter select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDSchoolcontacter  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDSchoolcontacter bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */   
		public int updateWithDyna(QasDSchoolcontacter bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		 /** 批量插入 */
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDSchoolcontacterMapper.class.getName()+".insert");
		}
		
		public List list(QasDSchoolcontacter bean){
			return queryPageList(QasDSchoolcontacterMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDSchoolcontacterMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDSchoolcontacterMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDSchoolcontacterMapper.class;
		}
}
