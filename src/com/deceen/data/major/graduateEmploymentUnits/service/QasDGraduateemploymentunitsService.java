package	com.deceen.data.major.graduateEmploymentUnits.service;

import java.util.*;
import com.deceen.data.major.graduateEmploymentUnits.model.QasDGraduateemploymentunits;
import com.deceen.data.major.graduateEmploymentUnits.mapper.QasDGraduateemploymentunitsMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDGraduateemploymentunitsAction.java
* @Description: qas_d_graduateemploymentunits
* @author upaths@gmail.com  
* @date 2017-11-23 16:11:24
* @version V1.0   
*/
@Component("qasDGraduateemploymentunitsService")	
@SuppressWarnings({ "rawtypes" })
public class QasDGraduateemploymentunitsService  extends CommonService {

		private QasDGraduateemploymentunitsMapper mapper;
	
		public QasDGraduateemploymentunits select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDGraduateemploymentunits  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDGraduateemploymentunits bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */  
		public int updateWithDyna(QasDGraduateemploymentunits bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		/** 批量插入 */
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDGraduateemploymentunitsMapper.class.getName()+".insert");
		}
		
		public List list(QasDGraduateemploymentunits bean){
			return queryPageList(QasDGraduateemploymentunitsMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDGraduateemploymentunitsMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDGraduateemploymentunitsMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDGraduateemploymentunitsMapper.class;
		}
}
