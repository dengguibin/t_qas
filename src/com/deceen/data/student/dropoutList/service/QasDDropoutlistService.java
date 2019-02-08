package	com.deceen.data.student.dropoutList.service;

import java.util.*;
import com.deceen.data.student.dropoutList.model.QasDDropoutlist;
import com.deceen.data.student.dropoutList.mapper.QasDDropoutlistMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDDropoutlistAction.java
* @Description: qas_d_dropoutlist
* @author upaths@gmail.com  
* @date 2017-11-24 10:32:29
* @version V1.0   
*/
@Component("qasDDropoutlistService")	
@SuppressWarnings({ "rawtypes" })
public class QasDDropoutlistService  extends CommonService {

		private QasDDropoutlistMapper mapper;
	
		public QasDDropoutlist select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDDropoutlist  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDDropoutlist bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
//		 需要时请开启,动态进行更新,批量插入实现
		public int updateWithDyna(QasDDropoutlist bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		
		public int[] batchInsert(List list){
			return batchDelete(list, QasDDropoutlistMapper.class.getName()+".insert");
		}
		
		public List list(QasDDropoutlist bean){
			return queryPageList(QasDDropoutlistMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDDropoutlistMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDDropoutlistMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDDropoutlistMapper.class;
		}
}
