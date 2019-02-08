package	com.deceen.data.teaching.virtualSimulationCenter.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deceen.data.teaching.virtualSimulationCenter.mapper.QasDVirtualsimulationcenterMapper;
import com.deceen.data.teaching.virtualSimulationCenter.model.QasDVirtualsimulationcenter;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;
/**
* 
* @ClassName: QasDVirtualsimulationcenterAction.java
* @Description: qas_d_virtualsimulationcenter
* @author upaths@gmail.com  
* @date 2017-11-24 12:21:32
* @version V1.0   
*/
@Component("qasDVirtualsimulationcenterService")	
@SuppressWarnings({ "rawtypes" })
public class QasDVirtualsimulationcenterService  extends CommonService {

		private QasDVirtualsimulationcenterMapper mapper;
	
		public QasDVirtualsimulationcenter select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDVirtualsimulationcenter  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDVirtualsimulationcenter bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
//		 需要时请开启,动态进行更新,批量插入实现
		public int updateWithDyna(QasDVirtualsimulationcenter bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		
		public int[] batchInsert(List list){
			return batchDelete(list, QasDVirtualsimulationcenterMapper.class.getName()+".insert");
		}
		
		public List list(QasDVirtualsimulationcenter bean){
			return queryPageList(QasDVirtualsimulationcenterMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDVirtualsimulationcenterMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDVirtualsimulationcenterMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDVirtualsimulationcenterMapper.class;
		}
}
