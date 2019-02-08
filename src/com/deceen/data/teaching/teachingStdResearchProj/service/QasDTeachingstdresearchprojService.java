package	com.deceen.data.teaching.teachingStdResearchProj.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deceen.data.teaching.teachingStdResearchProj.mapper.QasDTeachingstdresearchprojMapper;
import com.deceen.data.teaching.teachingStdResearchProj.model.QasDTeachingstdresearchproj;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;
/**
* 
* @ClassName: QasDTeachingstdresearchprojAction.java
* @Description: qas_d_teachingstdresearchproj
* @author upaths@gmail.com  
* @date 2017-11-24 12:21:04
* @version V1.0   
*/
@Component("qasDTeachingstdresearchprojService")	
@SuppressWarnings({ "rawtypes" })
public class QasDTeachingstdresearchprojService  extends CommonService {

		private QasDTeachingstdresearchprojMapper mapper;
	
		public QasDTeachingstdresearchproj select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDTeachingstdresearchproj  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDTeachingstdresearchproj bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
//		 需要时请开启,动态进行更新,批量插入实现
		public int updateWithDyna(QasDTeachingstdresearchproj bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		
		public int[] batchInsert(List list){
			return batchDelete(list, QasDTeachingstdresearchprojMapper.class.getName()+".insert");
		}
		
		public List list(QasDTeachingstdresearchproj bean){
			return queryPageList(QasDTeachingstdresearchprojMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDTeachingstdresearchprojMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDTeachingstdresearchprojMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDTeachingstdresearchprojMapper.class;
		}
}
