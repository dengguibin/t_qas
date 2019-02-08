/**
*/
package	com.deceen.system.majordirection.service;

import java.util.*;

import com.deceen.system.majordirection.model.QasDMajordirection;
import com.deceen.system.majordirection.mapper.QasDMajordirectionMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDMajordirectionAction.java
* @Description: qas_d_majordirection
* @author upaths@gmail.com  
* @date 2017-11-30 10:31:54
* @version V1.0   
*/
@Component("qasDMajordirectionService")	
@SuppressWarnings({ "rawtypes" })
public class QasDMajordirectionService  extends CommonService {

		private QasDMajordirectionMapper mapper;
	
		public QasDMajordirection select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDMajordirection  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDMajordirection bean){
			return mapper.update(bean);
		}
		
		
		public int updateWithDyna(QasDMajordirection bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		
	/*	public int[] batchInsert(List list){
			batchDelete(list, QasDMajordirectionMapper.class.getName()+".insert");
			return 0;
		}*/
		
		public List list(QasDMajordirection bean){
			return queryPageList(QasDMajordirectionMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			List list = Arrays.asList(ids);
			batchDelete(list, QasDMajordirectionMapper.class.getName()+".delete");
			return 0;
		};
			
		public QasDMajordirectionMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDMajordirectionMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDMajordirectionMapper.class;
		}
}
