package	com.deceen.data.teaching.teachingResource.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deceen.data.teaching.teachingResource.mapper.QasDTeachingresourceMapper;
import com.deceen.data.teaching.teachingResource.model.QasDTeachingresource;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;
/**
* 
* @ClassName: QasDTeachingresourceAction.java
* @Description: qas_d_teachingresource
* @author upaths@gmail.com  
* @date 2017-11-24 12:23:34
* @version V1.0   
*/
@Component("qasDTeachingresourceService")	
@SuppressWarnings({ "rawtypes" })
public class QasDTeachingresourceService  extends CommonService {

		private QasDTeachingresourceMapper mapper;
	
		public QasDTeachingresource select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDTeachingresource  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDTeachingresource bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
//		 需要时请开启,动态进行更新,批量插入实现
		public int updateWithDyna(QasDTeachingresource bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDTeachingresourceMapper.class.getName()+".insert");
		}
		
		public List list(QasDTeachingresource bean){
			return queryPageList(QasDTeachingresourceMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDTeachingresourceMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDTeachingresourceMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDTeachingresourceMapper.class;
		}
}
