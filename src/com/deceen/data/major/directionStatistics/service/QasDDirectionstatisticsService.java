package	com.deceen.data.major.directionStatistics.service;

import java.util.*;
import com.deceen.data.major.directionStatistics.model.QasDDirectionstatistics;
import com.deceen.data.major.directionStatistics.mapper.QasDDirectionstatisticsMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDDirectionstatisticsAction.java
* @Description: qas_d_directionstatistics
* @author upaths@gmail.com  
* @date 2017-11-23 16:05:48
* @version V1.0   
*/
@Component("qasDDirectionstatisticsService")
@SuppressWarnings("rawtypes")
public class QasDDirectionstatisticsService  extends CommonService {

		private QasDDirectionstatisticsMapper mapper;
	
		public QasDDirectionstatistics select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDDirectionstatistics  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDDirectionstatistics bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */  
		public int updateWithDyna(QasDDirectionstatistics bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		/** 批量插入 */
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDDirectionstatisticsMapper.class.getName()+".insert");
		}
		
		public List list(QasDDirectionstatistics bean){
			return queryPageList(QasDDirectionstatisticsMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDDirectionstatisticsMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDDirectionstatisticsMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDDirectionstatisticsMapper.class;
		}
}
