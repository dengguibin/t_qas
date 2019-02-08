package	com.deceen.data.teaching.baseInfoOfEmploymentGuidance.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deceen.data.teaching.baseInfoOfEmploymentGuidance.mapper.QasDBaseinfoofemploymentguidanceMapper;
import com.deceen.data.teaching.baseInfoOfEmploymentGuidance.model.QasDBaseinfoofemploymentguidance;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;
/**
* 
* @ClassName: QasDBaseinfoofemploymentguidanceAction.java
* @Description: qas_d_baseinfoofemploymentguidance
* @author upaths@gmail.com  
* @date 2017-11-24 12:14:53
* @version V1.0   
*/
@Component("qasDBaseinfoofemploymentguidanceService")	
@SuppressWarnings({ "rawtypes" })
public class QasDBaseinfoofemploymentguidanceService  extends CommonService {

		private QasDBaseinfoofemploymentguidanceMapper mapper;
	
		public QasDBaseinfoofemploymentguidance select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDBaseinfoofemploymentguidance  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDBaseinfoofemploymentguidance bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
//		 需要时请开启,动态进行更新,批量插入实现
		public int updateWithDyna(QasDBaseinfoofemploymentguidance bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDBaseinfoofemploymentguidanceMapper.class.getName()+".insert");
		}
		
		public List list(QasDBaseinfoofemploymentguidance bean){
			return queryPageList(QasDBaseinfoofemploymentguidanceMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDBaseinfoofemploymentguidanceMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDBaseinfoofemploymentguidanceMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDBaseinfoofemploymentguidanceMapper.class;
		}
}
