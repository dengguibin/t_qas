package	com.deceen.data.major.graduateEmployment.service;

import java.util.*;
import com.deceen.data.major.graduateEmployment.model.QasDGraduateemployment;
import com.deceen.data.major.graduateEmployment.mapper.QasDGraduateemploymentMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDGraduateemploymentAction.java
* @Description: qas_d_graduateemployment
* @author upaths@gmail.com  
* @date 2017-11-23 16:13:42
* @version V1.0   
*/
@Component("qasDGraduateemploymentService")	
@SuppressWarnings( "rawtypes" )
public class QasDGraduateemploymentService  extends CommonService {

		private QasDGraduateemploymentMapper mapper;
	
		public QasDGraduateemployment select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDGraduateemployment  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDGraduateemployment bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */  
		public int updateWithDyna(QasDGraduateemployment bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		/** 批量插入 */
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDGraduateemploymentMapper.class.getName()+".insert");
		}
		
		public List list(QasDGraduateemployment bean){
			return queryPageList(QasDGraduateemploymentMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDGraduateemploymentMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDGraduateemploymentMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDGraduateemploymentMapper.class;
		}
}
