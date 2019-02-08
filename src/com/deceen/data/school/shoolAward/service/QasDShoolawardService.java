package	com.deceen.data.school.shoolAward.service;

import java.util.*;
import com.deceen.data.school.shoolAward.model.QasDShoolaward;
import com.deceen.data.school.shoolAward.mapper.QasDShoolawardMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDShoolawardAction.java
* @Description: qas_d_shoolaward
* @author upaths@gmail.com  
* @date 2017-11-22 18:01:28
* @version V1.0   
*/
@Component("qasDShoolawardService")	
@SuppressWarnings({ "rawtypes" })
public class QasDShoolawardService  extends CommonService {

		private QasDShoolawardMapper mapper;
	
		public QasDShoolaward select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDShoolaward  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			
			return	mapper.insert(bean);
		}
		
		public int update(QasDShoolaward bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */   
		public int updateWithDyna(QasDShoolaward bean){
		bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		/** 批量插入 */
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDShoolawardMapper.class.getName()+".insert");
			
		}
		
		public List list(QasDShoolaward bean){
			return queryPageList(QasDShoolawardMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDShoolawardMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDShoolawardMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDShoolawardMapper.class;
		}
}
