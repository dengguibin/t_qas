/**
*/
package	com.upath.plat.auth.service;

import java.util.*;
import com.upath.plat.auth.model.TRmsGorupsUser;
import com.upath.plat.auth.mapper.TRmsGorupsUserMapper;
import com.upath.plat.common.service.CommonService;
/**
* 
* @ClassName: TRmsGorupsUserAction.java
* @Description: t_rms_gorups_user
* @author upaths@gmail.com  
* @date 2012-11-17 17:22:21
* @version V1.0   
*/
@SuppressWarnings({ "rawtypes" })
public class TRmsGorupsUserService extends CommonService  {
		
		private TRmsGorupsUserMapper mapper;
	
		public TRmsGorupsUser select(TRmsGorupsUser bean){
			return	mapper.select(bean);
		}
		
		public void insert(TRmsGorupsUser  bean){
			mapper.insert(bean);
		}
		
		public void update(TRmsGorupsUser bean){
			mapper.update(bean);
		}
		
		public List list(TRmsGorupsUser bean){
			return mapper.list(bean);
		}
		
		public void delete(TRmsGorupsUser bean){
			mapper.delete(bean);
		}
		
		public TRmsGorupsUserMapper getMapper() {
			return mapper;
		}

		public void setMapper(TRmsGorupsUserMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return TRmsGorupsUserMapper.class;
		}
}
