package	com.deceen.data.teaching.majorSysInnovation.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deceen.data.teaching.majorSysInnovation.mapper.QasDMajorsysinnovationMapper;
import com.deceen.data.teaching.majorSysInnovation.model.QasDMajorsysinnovation;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;
/**
* 
* @ClassName: QasDMajorsysinnovationAction.java
* @Description: qas_d_majorsysinnovation
* @author upaths@gmail.com  
* @date 2017-11-24 12:20:23
* @version V1.0   
*/
@Component("qasDMajorsysinnovationService")	
@SuppressWarnings({ "rawtypes" })
public class QasDMajorsysinnovationService  extends CommonService {

		private QasDMajorsysinnovationMapper mapper;
	
		public QasDMajorsysinnovation select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDMajorsysinnovation  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDMajorsysinnovation bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
//		 需要时请开启,动态进行更新,批量插入实现
		public int updateWithDyna(QasDMajorsysinnovation bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDMajorsysinnovationMapper.class.getName()+".insert");
		}
		
		public List list(QasDMajorsysinnovation bean){
			return queryPageList(QasDMajorsysinnovationMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDMajorsysinnovationMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDMajorsysinnovationMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDMajorsysinnovationMapper.class;
		}
}
