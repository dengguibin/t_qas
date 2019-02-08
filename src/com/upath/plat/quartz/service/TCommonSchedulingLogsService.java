/**
*/
package	com.upath.plat.quartz.service;

import java.util.*;

import com.upath.plat.quartz.model.TCommonSchedulingLogs;
import com.upath.plat.quartz.mapper.TCommonSchedulingLogsMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: TCommonSchedulingLogsAction.java
* @Description: t_common_scheduling_logs
* @author upaths@gmail.com  
* @date 2015-7-9 19:13:31
* @version V1.0   
*/
@Component("tCommonSchedulingLogsService")	
@SuppressWarnings({ "rawtypes"})
public class TCommonSchedulingLogsService  extends CommonService {

		private TCommonSchedulingLogsMapper mapper;
	
		public TCommonSchedulingLogs select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(TCommonSchedulingLogs  bean){
			bean.setLogid(IDGenerator.getUUID());
			return	mapper.insert(bean);
		}
		
		public int update(TCommonSchedulingLogs bean){
			return mapper.update(bean);
		}
		
		/* 需要时请开启,动态进行更新,批量插入实现
		public int updateWithDyna(TCommonSchedulingLogs bean){
			return mapper.updateWithDyna(bean);
		}
		
		public int[] batchInsert(List list){
			batchDelete(list, TCommonSchedulingLogsMapper.class.getName()+".insert");
			return 0;
		}
		*/
		public List list(TCommonSchedulingLogs bean){
			return queryPageList(TCommonSchedulingLogsMapper.class.getName()+".list", bean);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			List list = Arrays.asList(ids);
			batchDelete(list, TCommonSchedulingLogsMapper.class.getName()+".delete");
			return 0;
		};
			
		public TCommonSchedulingLogsMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(TCommonSchedulingLogsMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return TCommonSchedulingLogsMapper.class;
		}
}
