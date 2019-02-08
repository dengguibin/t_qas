package	com.deceen.data.teaching.scholarship.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deceen.data.teaching.scholarship.mapper.QasDScholarshipMapper;
import com.deceen.data.teaching.scholarship.model.QasDScholarship;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;
/**
* 
* @ClassName: QasDScholarshipAction.java
* @Description: qas_d_scholarship
* @author upaths@gmail.com  
* @date 2017-11-24 12:19:49
* @version V1.0   
*/
@Component("qasDScholarshipService")	
@SuppressWarnings({ "rawtypes" })
public class QasDScholarshipService  extends CommonService {

		private QasDScholarshipMapper mapper;
	
		public QasDScholarship select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDScholarship  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDScholarship bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
//		 需要时请开启,动态进行更新,批量插入实现
		public int updateWithDyna(QasDScholarship bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDScholarshipMapper.class.getName()+".insert");
		}
		
		public List list(QasDScholarship bean){
			return queryPageList(QasDScholarshipMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDScholarshipMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDScholarshipMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDScholarshipMapper.class;
		}
}
