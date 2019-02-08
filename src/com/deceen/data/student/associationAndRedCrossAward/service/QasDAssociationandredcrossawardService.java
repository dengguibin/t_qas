package	com.deceen.data.student.associationAndRedCrossAward.service;

import java.util.*;
import com.deceen.data.student.associationAndRedCrossAward.model.QasDAssociationandredcrossaward;
import com.deceen.data.student.associationAndRedCrossAward.mapper.QasDAssociationandredcrossawardMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDAssociationandredcrossawardAction.java
* @Description: qas_d_associationandredcrossaward
* @author upaths@gmail.com  
* @date 2017-11-24 10:29:35
* @version V1.0   
*/
@Component("qasDAssociationandredcrossawardService")	
@SuppressWarnings({ "rawtypes" })
public class QasDAssociationandredcrossawardService  extends CommonService {

		private QasDAssociationandredcrossawardMapper mapper;
	
		public QasDAssociationandredcrossaward select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDAssociationandredcrossaward  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDAssociationandredcrossaward bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
//		 需要时请开启,动态进行更新,批量插入实现
		public int updateWithDyna(QasDAssociationandredcrossaward bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		
		public int[] batchInsert(List list){
			return batchDelete(list, QasDAssociationandredcrossawardMapper.class.getName()+".insert");
		}
		
		public List list(QasDAssociationandredcrossaward bean){
			return queryPageList(QasDAssociationandredcrossawardMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDAssociationandredcrossawardMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDAssociationandredcrossawardMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDAssociationandredcrossawardMapper.class;
		}
}
