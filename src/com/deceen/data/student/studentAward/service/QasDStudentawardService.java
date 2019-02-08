package	com.deceen.data.student.studentAward.service;

import java.util.*;
import com.deceen.data.student.studentAward.model.QasDStudentaward;
import com.deceen.data.student.studentAward.mapper.QasDStudentawardMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDStudentawardAction.java
* @Description: qas_d_studentaward
* @author upaths@gmail.com  
* @date 2017-11-24 10:26:48
* @version V1.0   
*/
@Component("qasDStudentawardService")	
@SuppressWarnings({ "rawtypes" })
public class QasDStudentawardService  extends CommonService {

		private QasDStudentawardMapper mapper;
	
		public QasDStudentaward select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDStudentaward  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDStudentaward bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
//		 需要时请开启,动态进行更新,批量插入实现
		public int updateWithDyna(QasDStudentaward bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDStudentawardMapper.class.getName()+".insert");
		}
		
		public List list(QasDStudentaward bean){
			return queryPageList(QasDStudentawardMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDStudentawardMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDStudentawardMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDStudentawardMapper.class;
		}
}
