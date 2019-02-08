package	com.deceen.data.teaching.cooperateProject.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deceen.data.teaching.cooperateProject.mapper.QasDCooperateprojectMapper;
import com.deceen.data.teaching.cooperateProject.model.QasDCooperateproject;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;
/**
* 
* @ClassName: QasDCooperateprojectAction.java
* @Description: qas_d_cooperateproject
* @author upaths@gmail.com  
* @date 2017-11-24 12:25:18
* @version V1.0   
*/
@Component("qasDCooperateprojectService")	
@SuppressWarnings({ "rawtypes" })
public class QasDCooperateprojectService  extends CommonService {

		private QasDCooperateprojectMapper mapper;
	
		public QasDCooperateproject select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDCooperateproject  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDCooperateproject bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
//		 需要时请开启,动态进行更新,批量插入实现
		public int updateWithDyna(QasDCooperateproject bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		
		public int[] batchInsert(List list){
			return batchDelete(list, QasDCooperateprojectMapper.class.getName()+".insert");
		}
		
		public List list(QasDCooperateproject bean){
			return queryPageList(QasDCooperateprojectMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDCooperateprojectMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDCooperateprojectMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDCooperateprojectMapper.class;
		}
}
