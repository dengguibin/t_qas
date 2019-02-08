package	com.deceen.data.teacher.teacherProcessStatistics.service;

import java.util.*;
import com.deceen.data.teacher.teacherProcessStatistics.model.QasDTeacherprocessstatistics;
import com.deceen.data.teacher.teacherProcessStatistics.mapper.QasDTeacherprocessstatisticsMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDTeacherprocessstatisticsAction.java
* @Description: qas_d_teacherprocessstatistics
* @author upaths@gmail.com  
* @date 2017-11-23 12:35:03
* @version V1.0   
*/
@Component("qasDTeacherprocessstatisticsService")	
@SuppressWarnings({ "rawtypes" })
public class QasDTeacherprocessstatisticsService  extends CommonService {

		private QasDTeacherprocessstatisticsMapper mapper;
	
		public QasDTeacherprocessstatistics select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDTeacherprocessstatistics  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			
			return	mapper.insert(bean);
		}
		
		public int update(QasDTeacherprocessstatistics bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */  
		public int updateWithDyna(QasDTeacherprocessstatistics bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		/** 批量插入 */
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDTeacherprocessstatisticsMapper.class.getName()+".insert");
		}
		
		public List list(QasDTeacherprocessstatistics bean){
			return queryPageList(QasDTeacherprocessstatisticsMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDTeacherprocessstatisticsMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDTeacherprocessstatisticsMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDTeacherprocessstatisticsMapper.class;
		}
}
