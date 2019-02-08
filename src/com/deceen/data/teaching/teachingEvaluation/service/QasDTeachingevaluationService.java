package	com.deceen.data.teaching.teachingEvaluation.service;

import java.util.*;
import com.deceen.data.teaching.teachingEvaluation.model.QasDTeachingevaluation;
import com.deceen.data.teaching.teachingEvaluation.mapper.QasDTeachingevaluationMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDTeachingevaluationAction.java
* @Description: qas_d_teachingevaluation
* @author upaths@gmail.com  
* @date 2017-11-24 12:17:59
* @version V1.0   
*/
@Component("qasDTeachingevaluationService")	
@SuppressWarnings({ "rawtypes" })
public class QasDTeachingevaluationService  extends CommonService {

		private QasDTeachingevaluationMapper mapper;
	
		public QasDTeachingevaluation select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDTeachingevaluation  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDTeachingevaluation bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
//		 需要时请开启,动态进行更新,批量插入实现
		public int updateWithDyna(QasDTeachingevaluation bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDTeachingevaluationMapper.class.getName()+".insert");
		}
		
		public List list(QasDTeachingevaluation bean){
			return queryPageList(QasDTeachingevaluationMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDTeachingevaluationMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDTeachingevaluationMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDTeachingevaluationMapper.class;
		}
}
