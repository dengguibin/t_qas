package	com.deceen.data.student.studAssociation.service;

import java.util.*;
import com.deceen.data.student.studAssociation.model.QasDStudassociation;
import com.deceen.data.student.studAssociation.mapper.QasDStudassociationMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDStudassociationAction.java
* @Description: qas_d_studassociation
* @author upaths@gmail.com  
* @date 2017-11-24 10:29:01
* @version V1.0   
*/
@Component("qasDStudassociationService")	
@SuppressWarnings({ "rawtypes" })
public class QasDStudassociationService  extends CommonService {

		private QasDStudassociationMapper mapper;
	
		public QasDStudassociation select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDStudassociation  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDStudassociation bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
//		 需要时请开启,动态进行更新,批量插入实现
		public int updateWithDyna(QasDStudassociation bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDStudassociationMapper.class.getName()+".insert");
		}
		
		public List list(QasDStudassociation bean){
			return queryPageList(QasDStudassociationMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDStudassociationMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDStudassociationMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDStudassociationMapper.class;
		}
}
