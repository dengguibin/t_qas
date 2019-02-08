package	com.deceen.data.teaching.innovativeTrainProj.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deceen.data.teaching.innovativeTrainProj.mapper.QasDInnovativetrainprojMapper;
import com.deceen.data.teaching.innovativeTrainProj.model.QasDInnovativetrainproj;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;
/**
* 
* @ClassName: QasDInnovativetrainprojAction.java
* @Description: qas_d_innovativetrainproj
* @author upaths@gmail.com  
* @date 2017-11-24 12:24:09
* @version V1.0   
*/
@Component("qasDInnovativetrainprojService")	
@SuppressWarnings({ "rawtypes" })
public class QasDInnovativetrainprojService  extends CommonService {

		private QasDInnovativetrainprojMapper mapper;
	
		public QasDInnovativetrainproj select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDInnovativetrainproj  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDInnovativetrainproj bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
//		 需要时请开启,动态进行更新,批量插入实现
		public int updateWithDyna(QasDInnovativetrainproj bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		
		public int[] batchInsert(List list){
			return batchDelete(list, QasDInnovativetrainprojMapper.class.getName()+".insert");
		}
		
		public List list(QasDInnovativetrainproj bean){
			return queryPageList(QasDInnovativetrainprojMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDInnovativetrainprojMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDInnovativetrainprojMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDInnovativetrainprojMapper.class;
		}
}
