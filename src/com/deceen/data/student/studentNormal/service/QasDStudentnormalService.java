package	com.deceen.data.student.studentNormal.service;

import java.util.*;
import com.deceen.data.student.studentNormal.model.QasDStudentnormal;
import com.deceen.data.student.studentNormal.mapper.QasDStudentnormalMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDStudentnormalAction.java
* @Description: qas_d_studentnormal
* @author upaths@gmail.com  
* @date 2017-11-24 10:39:24
* @version V1.0   
*/
@Component("qasDStudentnormalService")	
@SuppressWarnings({ "rawtypes" })
public class QasDStudentnormalService  extends CommonService {

		private QasDStudentnormalMapper mapper;
	
		public QasDStudentnormal select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDStudentnormal  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDStudentnormal bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
//		 需要时请开启,动态进行更新,批量插入实现
		public int updateWithDyna(QasDStudentnormal bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDStudentnormalMapper.class.getName()+".insert");
		}
		
		public List list(QasDStudentnormal bean){
			return queryPageList(QasDStudentnormalMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDStudentnormalMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDStudentnormalMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDStudentnormalMapper.class;
		}
}
