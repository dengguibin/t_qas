package	com.deceen.data.teacher.teacherTechnicalMonopoly.service;

import java.util.*;
import com.deceen.data.teacher.teacherTechnicalMonopoly.model.QasDTeachertechnicalmonopoly;
import com.deceen.data.teacher.teacherTechnicalMonopoly.mapper.QasDTeachertechnicalmonopolyMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDTeachertechnicalmonopolyAction.java
* @Description: qas_d_teachertechnicalmonopoly
* @author upaths@gmail.com  
* @date 2017-11-23 12:32:42
* @version V1.0   
*/
@Component("qasDTeachertechnicalmonopolyService")	
@SuppressWarnings({ "rawtypes" })
public class QasDTeachertechnicalmonopolyService  extends CommonService {

		private QasDTeachertechnicalmonopolyMapper mapper;
	
		public QasDTeachertechnicalmonopoly select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDTeachertechnicalmonopoly  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDTeachertechnicalmonopoly bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */   
		public int updateWithDyna(QasDTeachertechnicalmonopoly bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		/** 批量插入 */
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDTeachertechnicalmonopolyMapper.class.getName()+".insert");
		}
		
		public List list(QasDTeachertechnicalmonopoly bean){
			return queryPageList(QasDTeachertechnicalmonopolyMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDTeachertechnicalmonopolyMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDTeachertechnicalmonopolyMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDTeachertechnicalmonopolyMapper.class;
		}
}
