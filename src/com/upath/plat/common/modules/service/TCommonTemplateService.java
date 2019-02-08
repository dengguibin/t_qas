/**
*/
package	com.upath.plat.common.modules.service;

import java.util.*;
import com.upath.plat.common.modules.model.TCommonTemplate;
import com.upath.plat.common.modules.mapper.TCommonTemplateMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;
/**
* 
* @ClassName: TCommonTemplateAction.java
* @Description: T_COMMON_TEMPLATE
* @author upaths@gmail.com  
* @date 2013-5-15 10:21:41
* @version V1.0   
*/
@SuppressWarnings({ "rawtypes" })
public class TCommonTemplateService extends CommonService  {
		
		private TCommonTemplateMapper mapper;
	
		public TCommonTemplate select(TCommonTemplate bean){
			return	mapper.select(bean);
		}
		
		public void insert(TCommonTemplate  bean){
			bean.setTid(IDGenerator.getDateId());
			mapper.insert(bean);
		}
		
		public void update(TCommonTemplate bean){
			mapper.update(bean);
		}
		
		public List list(TCommonTemplate bean){
			return mapper.list(bean);
		}
		
		public void delete(TCommonTemplate bean){
			mapper.delete(bean);
		}
		
		public TCommonTemplateMapper getMapper() {
			return mapper;
		}

		public void setMapper(TCommonTemplateMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return TCommonTemplateMapper.class;
		}
}
