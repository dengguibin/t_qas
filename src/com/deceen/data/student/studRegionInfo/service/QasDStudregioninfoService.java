package	com.deceen.data.student.studRegionInfo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deceen.data.student.studRegionInfo.mapper.QasDStudregioninfoMapper;
import com.deceen.data.student.studRegionInfo.model.QasDStudregioninfo;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;
/**
* 
* @ClassName: QasDStudregioninfoAction.java
* @Description: qas_d_studregioninfo
* @author upaths@gmail.com  
* @date 2017-11-24 10:33:04
* @version V1.0   
*/
@Component("qasDStudregioninfoService")	
@SuppressWarnings({ "rawtypes" })
public class QasDStudregioninfoService  extends CommonService {

		private QasDStudregioninfoMapper mapper;
	
		public QasDStudregioninfo select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDStudregioninfo  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDStudregioninfo bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
//		 需要时请开启,动态进行更新,批量插入实现
		public int updateWithDyna(QasDStudregioninfo bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDStudregioninfoMapper.class.getName()+".insert");
		}
		
		public List list(QasDStudregioninfo bean){
			return queryPageList(QasDStudregioninfoMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDStudregioninfoMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDStudregioninfoMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDStudregioninfoMapper.class;
		}
}
