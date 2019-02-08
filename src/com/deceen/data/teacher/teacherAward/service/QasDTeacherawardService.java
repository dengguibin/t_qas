package	com.deceen.data.teacher.teacherAward.service;

import java.util.*;
import com.deceen.data.teacher.teacherAward.model.QasDTeacheraward;
import com.deceen.data.teacher.teacherAward.mapper.QasDTeacherawardMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDTeacherawardAction.java
* @Description: qas_d_teacheraward
* @author upaths@gmail.com  
* @date 2017-11-23 12:32:07
* @version V1.0   
*/
@Component("qasDTeacherawardService")	
@SuppressWarnings({ "rawtypes" })
public class QasDTeacherawardService  extends CommonService {

		private QasDTeacherawardMapper mapper;
	
		public QasDTeacheraward select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDTeacheraward  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			
			return	mapper.insert(bean);
		}
		
		public int update(QasDTeacheraward bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */  
		public int updateWithDyna(QasDTeacheraward bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		/** 批量插入 */
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDTeacherawardMapper.class.getName()+".insert");
		}
		
		public List list(QasDTeacheraward bean){
			return queryPageList(QasDTeacherawardMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDTeacherawardMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDTeacherawardMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDTeacherawardMapper.class;
		}
}
