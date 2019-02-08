/**
*/
package	com.upath.plat.auth.service;

import java.util.*;
import com.upath.plat.auth.model.TRmsUserRole;
import com.upath.plat.auth.mapper.TRmsUserRoleMapper;
import com.upath.plat.common.service.CommonService;
/**
* 
* @ClassName: TRmsUserRoleAction.java
* @Description: t_rms_user_role
* @author upaths@gmail.com  
* @date 2012-11-17 17:22:21
* @version V1.0   
*/
@SuppressWarnings({ "rawtypes"})
public class TRmsUserRoleService extends CommonService  {
		
		private TRmsUserRoleMapper mapper;
	
		public TRmsUserRole select(TRmsUserRole bean){
			return	mapper.select(bean);
		}
		
		public void insert(TRmsUserRole  bean){
			mapper.insert(bean);
		}
		
		public void update(TRmsUserRole bean){
			mapper.update(bean);
		}
		
		public List list(TRmsUserRole bean){
			return mapper.list(bean);
		}
		
		public void delete(TRmsUserRole bean){
			mapper.delete(bean);
		}
		
		public TRmsUserRoleMapper getMapper() {
			return mapper;
		}

		public void setMapper(TRmsUserRoleMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return TRmsUserRoleMapper.class;
		}
}
