/**
*/
package	com.upath.plat.common.modules.service;

import java.util.*;
import com.upath.plat.common.modules.model.TCommonOnline;
import com.upath.plat.common.modules.mapper.TCommonOnlineMapper;
import com.upath.plat.common.service.CommonService;
/**
* 
* @ClassName: TCommonOnlineAction.java
* @Description: t_common_online
* @author upaths@gmail.com  
* @date 2012-11-28 22:24:13
* @version V1.0   
*/
@SuppressWarnings({ "rawtypes" })
public class TCommonOnlineService extends CommonService  {
		
		private TCommonOnlineMapper mapper;
	
		public TCommonOnline select(TCommonOnline bean){
			return	mapper.select(bean);
		}
		
		public void insert(TCommonOnline  bean){
			mapper.insert(bean);
		}
		
		public void update(TCommonOnline bean){
			mapper.update(bean);
		}
		
		public List list(TCommonOnline bean){
			return mapper.list(bean);
		}
		
		public void delete(TCommonOnline bean){
			mapper.delete(bean);
		}
		
		public TCommonOnlineMapper getMapper() {
			return mapper;
		}

		public void setMapper(TCommonOnlineMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return TCommonOnlineMapper.class;
		}
}
