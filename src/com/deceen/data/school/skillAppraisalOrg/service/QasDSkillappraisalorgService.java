package	com.deceen.data.school.skillAppraisalOrg.service;

import java.util.*;
import com.deceen.data.school.skillAppraisalOrg.model.QasDSkillappraisalorg;
import com.deceen.data.school.skillAppraisalOrg.mapper.QasDSkillappraisalorgMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDSkillappraisalorgAction.java
* @Description: qas_d_skillappraisalorg
* @author upaths@gmail.com  
* @date 2017-11-22 17:59:15
* @version V1.0   
*/
@Component("qasDSkillappraisalorgService")	
@SuppressWarnings({ "rawtypes" })
public class QasDSkillappraisalorgService  extends CommonService {

		private QasDSkillappraisalorgMapper mapper;
	
		public QasDSkillappraisalorg select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDSkillappraisalorg  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			
			return	mapper.insert(bean);
		}
		
		public int update(QasDSkillappraisalorg bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */  
		public int updateWithDyna(QasDSkillappraisalorg bean){
		bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		/** 批量插入 */
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDSkillappraisalorgMapper.class.getName()+".insert");
		}
		
		public List list(QasDSkillappraisalorg bean){
			return queryPageList(QasDSkillappraisalorgMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDSkillappraisalorgMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDSkillappraisalorgMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDSkillappraisalorgMapper.class;
		}
}
