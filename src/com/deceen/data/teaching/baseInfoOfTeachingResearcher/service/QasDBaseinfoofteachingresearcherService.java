package	com.deceen.data.teaching.baseInfoOfTeachingResearcher.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deceen.data.teaching.baseInfoOfTeachingResearcher.mapper.QasDBaseinfoofteachingresearcherMapper;
import com.deceen.data.teaching.baseInfoOfTeachingResearcher.model.QasDBaseinfoofteachingresearcher;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;
/**
* 
* @ClassName: QasDBaseinfoofteachingresearcherAction.java
* @Description: qas_d_baseinfoofteachingresearcher
* @author upaths@gmail.com  
* @date 2017-11-24 12:15:52
* @version V1.0   
*/
@Component("qasDBaseinfoofteachingresearcherService")	
@SuppressWarnings({ "rawtypes" })
public class QasDBaseinfoofteachingresearcherService  extends CommonService {

		private QasDBaseinfoofteachingresearcherMapper mapper;
	
		public QasDBaseinfoofteachingresearcher select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDBaseinfoofteachingresearcher  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDBaseinfoofteachingresearcher bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
//		 需要时请开启,动态进行更新,批量插入实现
		public int updateWithDyna(QasDBaseinfoofteachingresearcher bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		
		public int[] batchInsert(List list){
			return batchDelete(list, QasDBaseinfoofteachingresearcherMapper.class.getName()+".insert");
		}
		
		public List list(QasDBaseinfoofteachingresearcher bean){
			return queryPageList(QasDBaseinfoofteachingresearcherMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDBaseinfoofteachingresearcherMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDBaseinfoofteachingresearcherMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDBaseinfoofteachingresearcherMapper.class;
		}
}
