package	com.deceen.data.major.lastYearEmployment.service;

import java.util.*;
import com.deceen.data.major.lastYearEmployment.model.QasDLastyearemployment;
import com.deceen.data.major.lastYearEmployment.mapper.QasDLastyearemploymentMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDLastyearemploymentAction.java
* @Description: qas_d_lastyearemployment
* @author upaths@gmail.com  
* @date 2017-11-23 16:14:22
* @version V1.0   
*/
@Component("qasDLastyearemploymentService")	
@SuppressWarnings({ "rawtypes"  })
public class QasDLastyearemploymentService  extends CommonService {

		private QasDLastyearemploymentMapper mapper;
	
		public QasDLastyearemployment select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDLastyearemployment  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDLastyearemployment bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */ 
		public int updateWithDyna(QasDLastyearemployment bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		 /** 批量插入 */
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDLastyearemploymentMapper.class.getName()+".insert");
		}
		
		public List list(QasDLastyearemployment bean){
			return queryPageList(QasDLastyearemploymentMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDLastyearemploymentMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDLastyearemploymentMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDLastyearemploymentMapper.class;
		}
}
