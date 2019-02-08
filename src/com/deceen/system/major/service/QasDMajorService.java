/**
*/
package	com.deceen.system.major.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deceen.diagnoseformat.task.model.QasTDiagnosetaskobj;
import com.deceen.system.major.mapper.QasDMajorMapper;
import com.deceen.system.major.model.QasDMajor;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;
/**
* 
* @ClassName: QasDMajorAction.java
* @Description: qas_d_major
* @author upaths@gmail.com  
* @date 2017-11-30 10:54:53
* @version V1.0   
*/
@Component("qasDMajorService")	
@SuppressWarnings({ "rawtypes"})
public class QasDMajorService  extends CommonService {

		private QasDMajorMapper mapper;
		
		public List<QasDMajor> getTree(QasDMajor major){
			return mapper.listAll(major);
		}
		
		public QasDMajor select(Object id){
			return	mapper.select(id);
		}
		
		public QasDMajor selectinfo(Object id){
			return	mapper.selectinfo(id);
		}
		
		public String selectParentId(Object id){
			return	mapper.selectParentId(id);
		}
		
		public String selectParentName(Object id){
			return	mapper.selectParentName(id);
		}
		
		public int insert(QasDMajor  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDMajor bean){
			return mapper.update(bean);
		}
		
	
		public int updateWithDyna(QasDMajor bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		
		/*public int[] batchInsert(List list){
			batchDelete(list, QasDMajorMapper.class.getName()+".insert");
			return 0;
		}*/
	
		public List list(QasDMajor bean){
			return queryPageList(QasDMajorMapper.class.getName()+".list", bean);
		}
		
		public List listByDwid(QasDMajor bean){
			return mapper.listByDwid(bean);
		}
		
		
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			List list = Arrays.asList(ids);
			batchDelete(list, QasDMajorMapper.class.getName()+".delete");
			return 0;
		};
			
		public QasDMajorMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDMajorMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDMajorMapper.class;
		}
}
