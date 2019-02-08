package	com.deceen.data.school.managementInformationSystem.service;

import java.util.*;

import com.deceen.data.school.managementInformationSystem.model.QasDManagementinformationsystem;
import com.deceen.data.school.managementInformationSystem.mapper.QasDManagementinformationsystemMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDManagementinformationsystemAction.java
* @Description: qas_d_managementinformationsystem
* @author upaths@gmail.com  
* @date 2017-11-22 17:50:47
* @version V1.0   
*/
@Component("qasDManagementinformationsystemService")	
@SuppressWarnings({ "rawtypes" })
public class QasDManagementinformationsystemService  extends CommonService {

		private QasDManagementinformationsystemMapper mapper;
	
		public QasDManagementinformationsystem select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDManagementinformationsystem  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDManagementinformationsystem bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */   
		public int updateWithDyna(QasDManagementinformationsystem bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		 /** 批量插入 */
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDManagementinformationsystemMapper.class.getName()+".insert");
		}
		
		public List list(QasDManagementinformationsystem bean){
			return queryPageList(QasDManagementinformationsystemMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDManagementinformationsystemMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDManagementinformationsystemMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDManagementinformationsystemMapper.class;
		}
}
