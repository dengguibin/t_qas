package	com.deceen.data.major.recruit.service;

import java.util.*;
import com.deceen.data.major.recruit.model.QasDRecruit;
import com.deceen.data.major.recruit.mapper.QasDRecruitMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDRecruitAction.java
* @Description: qas_d_recruit
* @author upaths@gmail.com  
* @date 2017-11-23 16:10:01
* @version V1.0   
*/
@Component("qasDRecruitService")	
@SuppressWarnings({ "rawtypes" })
public class QasDRecruitService  extends CommonService {

		private QasDRecruitMapper mapper;
	
		public QasDRecruit select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDRecruit  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDRecruit bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */  
		public int updateWithDyna(QasDRecruit bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		/** 批量插入 */
		public int[] batchInsert(List list){
			return batchDelete(list, QasDRecruitMapper.class.getName()+".insert");
		}
		
		public List list(QasDRecruit bean){
			return queryPageList(QasDRecruitMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDRecruitMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDRecruitMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDRecruitMapper.class;
		}
}
