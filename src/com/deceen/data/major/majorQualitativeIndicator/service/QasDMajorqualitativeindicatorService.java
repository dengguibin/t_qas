package	com.deceen.data.major.majorQualitativeIndicator.service;

import java.util.*;
import com.deceen.data.major.majorQualitativeIndicator.model.QasDMajorqualitativeindicator;
import com.deceen.data.major.majorQualitativeIndicator.mapper.QasDMajorqualitativeindicatorMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDMajorqualitativeindicatorAction.java
* @Description: qas_d_majorqualitativeindicator
* @author upaths@gmail.com  
* @date 2017-11-23 16:15:03
* @version V1.0   
*/
@Component("qasDMajorqualitativeindicatorService")	
@SuppressWarnings({ "rawtypes" })
public class QasDMajorqualitativeindicatorService  extends CommonService {

		private QasDMajorqualitativeindicatorMapper mapper;
	
		public QasDMajorqualitativeindicator select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDMajorqualitativeindicator  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDMajorqualitativeindicator bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */  
		public int updateWithDyna(QasDMajorqualitativeindicator bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		/** 批量插入 */
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDMajorqualitativeindicatorMapper.class.getName()+".insert");
		}
		
		public List list(QasDMajorqualitativeindicator bean){
			return queryPageList(QasDMajorqualitativeindicatorMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDMajorqualitativeindicatorMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDMajorqualitativeindicatorMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDMajorqualitativeindicatorMapper.class;
		}
}
