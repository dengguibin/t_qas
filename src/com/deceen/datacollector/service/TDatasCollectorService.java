/**
*/
package	com.deceen.datacollector.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deceen.datacollector.mapper.TDatasCollectorMapper;
import com.deceen.datacollector.model.TDatasCollector;
import com.upath.plat.common.service.CommonService;
/**
* 
* @ClassName: TDatasCollectorAction.java
* @Description: t_datas_collector
* @author upaths@gmail.com  
* @date 2015-7-2 15:51:46
* @version V1.0   
*/
@Component("tDatasCollectorService")	
@SuppressWarnings({ "rawtypes" })
public class TDatasCollectorService  extends CommonService {

		private TDatasCollectorMapper mapper;
	
		public TDatasCollector select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(TDatasCollector  bean){
			return	mapper.insert(bean);
		}
		
		public int update(TDatasCollector bean){
			return mapper.update(bean);
		}
		
		public int updateWithDyna(TDatasCollector bean){
			return mapper.updateWithDyna(bean);
		}
		
		/* 	public int[] batchInsert(List list){
			batchDelete(list, TDatasCollectorMapper.class.getName()+".insert");
			return 0;
		}
		*/
		public List list(TDatasCollector bean){
			return queryPageList(TDatasCollectorMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			List list = Arrays.asList(ids);
			batchDelete(list, TDatasCollectorMapper.class.getName()+".delete");
			return 0;
		};
			
		public TDatasCollectorMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(TDatasCollectorMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return TDatasCollectorMapper.class;
		}
}
