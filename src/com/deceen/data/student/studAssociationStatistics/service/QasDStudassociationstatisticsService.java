package	com.deceen.data.student.studAssociationStatistics.service;

import java.util.*;
import com.deceen.data.student.studAssociationStatistics.model.QasDStudassociationstatistics;
import com.deceen.data.student.studAssociationStatistics.mapper.QasDStudassociationstatisticsMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDStudassociationstatisticsAction.java
* @Description: qas_d_studassociationstatistics
* @author upaths@gmail.com  
* @date 2017-11-24 10:30:46
* @version V1.0   
*/
@Component("qasDStudassociationstatisticsService")	
@SuppressWarnings({ "rawtypes" })
public class QasDStudassociationstatisticsService  extends CommonService {

		private QasDStudassociationstatisticsMapper mapper;
	
		public QasDStudassociationstatistics select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDStudassociationstatistics  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDStudassociationstatistics bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
//		 需要时请开启,动态进行更新,批量插入实现
		public int updateWithDyna(QasDStudassociationstatistics bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDStudassociationstatisticsMapper.class.getName()+".insert");
		}
		
		public List list(QasDStudassociationstatistics bean){
			return queryPageList(QasDStudassociationstatisticsMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDStudassociationstatisticsMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDStudassociationstatisticsMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDStudassociationstatisticsMapper.class;
		}
}
