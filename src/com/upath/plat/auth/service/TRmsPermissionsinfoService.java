/**
*/
package	com.upath.plat.auth.service;

import java.util.*;
import com.upath.plat.auth.model.TRmsPermissionsinfo;
import com.upath.plat.auth.mapper.TRmsPermissionsinfoMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.service.ISequence;
/**
* 
* @ClassName: TRmsPermissionsinfoAction.java
* @Description: t_rms_permissionsinfo
* @author upaths@gmail.com  
* @date 2012-11-11 21:51:25
* @version V1.0   
*/
@SuppressWarnings({ "rawtypes", "unused" })
public class TRmsPermissionsinfoService extends CommonService  {
		
		private TRmsPermissionsinfoMapper mapper;
	
		public TRmsPermissionsinfo select(TRmsPermissionsinfo bean){
			return	mapper.select(bean);
		}
		
		public void insert(TRmsPermissionsinfo  bean){
			mapper.insert(bean);
		}
		
		public void update(TRmsPermissionsinfo bean){
			mapper.update(bean);
		}
		
		public List list(TRmsPermissionsinfo bean){
			return mapper.list(bean);
		}
		
		public void delete(TRmsPermissionsinfo bean){
			mapper.delete(bean);
		}
		
		public TRmsPermissionsinfoMapper getMapper() {
			return mapper;
		}

		public void setMapper(TRmsPermissionsinfoMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return TRmsPermissionsinfoMapper.class;
		}
}
