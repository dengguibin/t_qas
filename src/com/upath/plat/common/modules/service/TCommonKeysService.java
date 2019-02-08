/**
*/
package	com.upath.plat.common.modules.service;

import java.util.List;

import com.upath.plat.common.modules.mapper.TCommonKeysMapper;
import com.upath.plat.common.modules.model.TCommonKeys;
import com.upath.plat.common.service.CommonService;
/**
* 
* @ClassName: TCommonKeysAction.java
* @Description: t_common_keys
* @author upaths@gmail.com  
* @date 2012-10-25 22:01:03
* @version V1.0   
*/
@SuppressWarnings({ "rawtypes" })
public class TCommonKeysService extends CommonService  {
		
		private TCommonKeysMapper mapper;
	
		public TCommonKeys select(TCommonKeys bean){
			return	mapper.select(bean);
		}
		
		public void insert(TCommonKeys  bean){
			mapper.insert(bean);
		}
		
		public void update(TCommonKeys bean){
			mapper.update(bean);
		}
		
		public List list(TCommonKeys bean){
			return mapper.list(bean);
		}
		
		public void delete(TCommonKeys bean){
			mapper.delete(bean);
		}
		
		public TCommonKeysMapper getMapper() {
			return mapper;
		}

		public void setMapper(TCommonKeysMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return TCommonKeysMapper.class;
		}
}
