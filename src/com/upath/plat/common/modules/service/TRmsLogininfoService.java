/**
*/
package	com.upath.plat.common.modules.service;

import java.util.*;
import com.upath.plat.common.modules.model.TRmsLogininfo;
import com.upath.plat.common.modules.mapper.TRmsLogininfoMapper;
import com.upath.plat.common.service.CommonService;
/**
* 
* @ClassName: TRmsLogininfoAction.java
* @Description: T_RMS_LOGININFO
* @author upaths@gmail.com  
* @date 2015-2-9 15:07:41
* @version V1.0   
*/
@SuppressWarnings({ "rawtypes" })
public class TRmsLogininfoService extends CommonService  {
		
		private TRmsLogininfoMapper mapper;
	
		public TRmsLogininfo select(TRmsLogininfo bean){
			return	mapper.select(bean);
		}
		
		public void insert(TRmsLogininfo  bean){
			mapper.insert(bean);
		}
		
		public void update(TRmsLogininfo bean){
			mapper.update(bean);
		}
		
		public int  queryLogCountByAddr(TRmsLogininfo bean){
			return mapper.queryLogCountByAddr(bean);
		}
		
		public List list(TRmsLogininfo bean){
			return mapper.list(bean);
		}
		
		public void delete(TRmsLogininfo bean){
			mapper.delete(bean);
		}
		
		
		
		public TRmsLogininfoMapper getMapper() {
			return mapper;
		}

		public void setMapper(TRmsLogininfoMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return TRmsLogininfoMapper.class;
		}
}
