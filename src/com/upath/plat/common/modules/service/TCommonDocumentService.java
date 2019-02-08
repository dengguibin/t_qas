/**
*/
package	com.upath.plat.common.modules.service;

import java.util.*;
import com.upath.plat.common.modules.model.TCommonDocument;
import com.upath.plat.common.modules.mapper.TCommonDocumentMapper;
import com.upath.plat.common.service.CommonService;
/**
* 
* @ClassName: TCommonDocumentAction.java
* @Description: t_common_document
* @author upaths@gmail.com  
* @date 2013-1-21 22:58:38
* @version V1.0   
*/
@SuppressWarnings({ "rawtypes" })
public class TCommonDocumentService extends CommonService  {
		
		private TCommonDocumentMapper mapper;
	
		public TCommonDocument select(TCommonDocument bean){
			return	mapper.select(bean);
		}
		
		public void insert(TCommonDocument  bean){
			mapper.insert(bean);
		}
		
		public void update(TCommonDocument bean){
			mapper.update(bean);
		}
		
		public List list(TCommonDocument bean){
			return mapper.list(bean);
		}
		
		public void delete(TCommonDocument bean){
			mapper.delete(bean);
		}
		
		public TCommonDocumentMapper getMapper() {
			return mapper;
		}

		public void setMapper(TCommonDocumentMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return TCommonDocumentMapper.class;
		}
}
