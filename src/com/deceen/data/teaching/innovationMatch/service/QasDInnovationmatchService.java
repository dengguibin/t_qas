package	com.deceen.data.teaching.innovationMatch.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deceen.data.teaching.innovationMatch.mapper.QasDInnovationmatchMapper;
import com.deceen.data.teaching.innovationMatch.model.QasDInnovationmatch;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;
/**
* 
* @ClassName: QasDInnovationmatchAction.java
* @Description: qas_d_innovationmatch
* @author upaths@gmail.com  
* @date 2017-11-24 12:24:43
* @version V1.0   
*/
@Component("qasDInnovationmatchService")	
@SuppressWarnings({ "rawtypes" })
public class QasDInnovationmatchService  extends CommonService {

		private QasDInnovationmatchMapper mapper;
	
		public QasDInnovationmatch select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDInnovationmatch  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDInnovationmatch bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
//		 需要时请开启,动态进行更新,批量插入实现
		public int updateWithDyna(QasDInnovationmatch bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		
		public int[] batchInsert(List list){
			return batchDelete(list, QasDInnovationmatchMapper.class.getName()+".insert");
		}
		
		public List list(QasDInnovationmatch bean){
			return queryPageList(QasDInnovationmatchMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDInnovationmatchMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDInnovationmatchMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDInnovationmatchMapper.class;
		}
}
