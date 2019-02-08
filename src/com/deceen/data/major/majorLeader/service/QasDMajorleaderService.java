package	com.deceen.data.major.majorLeader.service;

import java.util.*;
import com.deceen.data.major.majorLeader.model.QasDMajorleader;
import com.deceen.data.major.majorLeader.mapper.QasDMajorleaderMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDMajorleaderAction.java
* @Description: qas_d_majorleader
* @author upaths@gmail.com  
* @date 2017-11-23 16:06:36
* @version V1.0   
*/
@Component("qasDMajorleaderService")	
@SuppressWarnings({ "rawtypes" })
public class QasDMajorleaderService  extends CommonService {

		private QasDMajorleaderMapper mapper;
	
		public QasDMajorleader select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDMajorleader  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDMajorleader bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */  
		public int updateWithDyna(QasDMajorleader bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		/** 批量插入 */
		public int[] batchInsert(List list){
			return batchDelete(list, QasDMajorleaderMapper.class.getName()+".insert");
		}
		
		public List list(QasDMajorleader bean){
			return queryPageList(QasDMajorleaderMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDMajorleaderMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDMajorleaderMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDMajorleaderMapper.class;
		}
}
