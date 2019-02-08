package	com.deceen.data.major.practice.service;

import java.util.*;
import com.deceen.data.major.practice.model.QasDPractice;
import com.deceen.data.major.practice.mapper.QasDPracticeMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDPracticeAction.java
* @Description: qas_d_practice
* @author upaths@gmail.com  
* @date 2017-11-23 16:08:21
* @version V1.0   
*/
@Component("qasDPracticeService")	
@SuppressWarnings({ "rawtypes" })
public class QasDPracticeService  extends CommonService {

		private QasDPracticeMapper mapper;
	
		public QasDPractice select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDPractice  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDPractice bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */  
		public int updateWithDyna(QasDPractice bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		/** 批量插入 */
		public int[] batchInsert(List list){
			return batchDelete(list, QasDPracticeMapper.class.getName()+".insert");
		}
		
		public List list(QasDPractice bean){
			return queryPageList(QasDPracticeMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDPracticeMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDPracticeMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDPracticeMapper.class;
		}
}
