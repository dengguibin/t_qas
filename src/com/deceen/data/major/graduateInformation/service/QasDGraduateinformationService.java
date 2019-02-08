package	com.deceen.data.major.graduateInformation.service;

import java.util.*;
import com.deceen.data.major.graduateInformation.model.QasDGraduateinformation;
import com.deceen.data.major.graduateInformation.mapper.QasDGraduateinformationMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDGraduateinformationAction.java
* @Description: qas_d_graduateinformation
* @author upaths@gmail.com  
* @date 2017-11-23 16:10:43
* @version V1.0   
*/
@Component("qasDGraduateinformationService")	
@SuppressWarnings({ "rawtypes" })
public class QasDGraduateinformationService  extends CommonService {

		private QasDGraduateinformationMapper mapper;
	
		public QasDGraduateinformation select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDGraduateinformation  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDGraduateinformation bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */  
		public int updateWithDyna(QasDGraduateinformation bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		/** 批量插入 */
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDGraduateinformationMapper.class.getName()+".insert");
		}
		
		public List list(QasDGraduateinformation bean){
			return queryPageList(QasDGraduateinformationMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDGraduateinformationMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDGraduateinformationMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDGraduateinformationMapper.class;
		}
}
