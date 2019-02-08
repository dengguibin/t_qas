/**
*/
package	com.upath.plat.common.modules.service;

import java.util.*;
import com.upath.plat.common.modules.model.TCommonWorkday;
import com.upath.plat.common.modules.mapper.TCommonWorkdayMapper;
import com.upath.plat.common.service.CommonService;
/**
* 
* @ClassName: TCommonWorkdayAction.java
* @Description: T_COMMON_WORKDAY
* @author upaths@gmail.com  
* @date 2013-3-22 14:36:14
* @version V1.0   
*/
@SuppressWarnings({ "rawtypes" })
public class TCommonWorkdayService extends CommonService  {
		
		private TCommonWorkdayMapper mapper;
	
		public TCommonWorkday select(TCommonWorkday bean){
			return	mapper.select(bean);
		}
		
		public void insert(TCommonWorkday  bean){
			mapper.insert(bean);
		}
		
		public void update(TCommonWorkday bean){
			mapper.update(bean);
		}
		
		public List list(TCommonWorkday bean){
			return mapper.list(bean);
		}
		
		public void delete(TCommonWorkday bean){
			mapper.delete(bean);
		}
		
		public TCommonWorkdayMapper getMapper() {
			return mapper;
		}

		public void setMapper(TCommonWorkdayMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return TCommonWorkdayMapper.class;
		}
}
