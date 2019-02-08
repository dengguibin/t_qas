package	com.deceen.data.teaching.baseInfoOfSupervisor.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deceen.data.teaching.baseInfoOfSupervisor.mapper.QasDBaseinfoofsupervisorMapper;
import com.deceen.data.teaching.baseInfoOfSupervisor.model.QasDBaseinfoofsupervisor;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;
/**
* 
* @ClassName: QasDBaseinfoofsupervisorAction.java
* @Description: qas_d_baseinfoofsupervisor
* @author upaths@gmail.com  
* @date 2017-11-24 12:15:23
* @version V1.0   
*/
@Component("qasDBaseinfoofsupervisorService")	
@SuppressWarnings({ "rawtypes" })
public class QasDBaseinfoofsupervisorService  extends CommonService {

		private QasDBaseinfoofsupervisorMapper mapper;
	
		public QasDBaseinfoofsupervisor select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDBaseinfoofsupervisor  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDBaseinfoofsupervisor bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
//		 需要时请开启,动态进行更新,批量插入实现
		public int updateWithDyna(QasDBaseinfoofsupervisor bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		
		public int[] batchInsert(List list){
			return batchDelete(list, QasDBaseinfoofsupervisorMapper.class.getName()+".insert");
		}
		
		public List list(QasDBaseinfoofsupervisor bean){
			return queryPageList(QasDBaseinfoofsupervisorMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDBaseinfoofsupervisorMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDBaseinfoofsupervisorMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDBaseinfoofsupervisorMapper.class;
		}
}
