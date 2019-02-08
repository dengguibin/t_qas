/**
*/
package	com.upath.plat.common.modules.service;

import java.util.List;

import com.upath.plat.common.modules.mapper.TCommonSubkeysMapper;
import com.upath.plat.common.modules.model.TCommonSubkeys;
import com.upath.plat.common.service.CommonService;

/**
* 
* @ClassName: TCommonSubkeysAction.java
* @Description: t_common_subkeys
* @author upaths@gmail.com  
* @date 2012-10-28 20:29:26
* @version V1.0   
*/
@SuppressWarnings({ "rawtypes" })
public class TCommonSubkeysService extends CommonService  {
		
		private TCommonSubkeysMapper mapper;
	
		public TCommonSubkeys select(TCommonSubkeys bean){
			return	mapper.select(bean);
		}
		
		public void insert(TCommonSubkeys  bean){
			mapper.insert(bean);
		}
		
		public void update(TCommonSubkeys bean){
			mapper.update(bean);
		}
		
		public List list(TCommonSubkeys bean){
			return mapper.list(bean);
		}
		
		public void delete(TCommonSubkeys bean){
			mapper.delete(bean);
		}
		
		public TCommonSubkeysMapper getMapper() {
			return mapper;
		}

		public void setMapper(TCommonSubkeysMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return TCommonSubkeysMapper.class;
		}
}
