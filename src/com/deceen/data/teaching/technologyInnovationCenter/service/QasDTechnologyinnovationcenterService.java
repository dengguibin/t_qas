package	com.deceen.data.teaching.technologyInnovationCenter.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deceen.data.teaching.technologyInnovationCenter.mapper.QasDTechnologyinnovationcenterMapper;
import com.deceen.data.teaching.technologyInnovationCenter.model.QasDTechnologyinnovationcenter;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;
/**
* 
* @ClassName: QasDTechnologyinnovationcenterAction.java
* @Description: qas_d_technologyinnovationcenter
* @author upaths@gmail.com  
* @date 2017-11-24 12:22:05
* @version V1.0   
*/
@Component("qasDTechnologyinnovationcenterService")	
@SuppressWarnings({ "rawtypes" })
public class QasDTechnologyinnovationcenterService  extends CommonService {

		private QasDTechnologyinnovationcenterMapper mapper;
	
		public QasDTechnologyinnovationcenter select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDTechnologyinnovationcenter  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDTechnologyinnovationcenter bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
//		 需要时请开启,动态进行更新,批量插入实现
		public int updateWithDyna(QasDTechnologyinnovationcenter bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		
		public int[] batchInsert(List list){
			return batchDelete(list, QasDTechnologyinnovationcenterMapper.class.getName()+".insert");
		}
		
		public List list(QasDTechnologyinnovationcenter bean){
			return queryPageList(QasDTechnologyinnovationcenterMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDTechnologyinnovationcenterMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDTechnologyinnovationcenterMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDTechnologyinnovationcenterMapper.class;
		}
}
