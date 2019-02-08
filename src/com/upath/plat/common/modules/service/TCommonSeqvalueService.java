/**
*/
package	com.upath.plat.common.modules.service;

import java.util.List;

import com.upath.plat.common.modules.mapper.TCommonSeqvalueMapper;
import com.upath.plat.common.modules.model.TCommonSeqvalue;
import com.upath.plat.common.service.CommonService;
/**
* 
* @ClassName: TCommonSeqvalueAction.java
* @Description: t_common_seqvalue
* @author upaths@gmail.com  
* @date 2012-10-31 21:16:23
* @version V1.0   
*/
@SuppressWarnings({ "rawtypes" })
public class TCommonSeqvalueService extends CommonService  {
		
		private TCommonSeqvalueMapper mapper;
	
		public TCommonSeqvalue select(TCommonSeqvalue bean){
			return	mapper.select(bean);
		}
		
		public void insert(TCommonSeqvalue  bean){
			mapper.insert(bean);
		}
		
		public void update(TCommonSeqvalue bean){
			mapper.update(bean);
		}
		
		public List list(TCommonSeqvalue bean){
			return mapper.list(bean);
		}
		
		public void delete(TCommonSeqvalue bean){
			mapper.delete(bean);
		}
		
		public TCommonSeqvalueMapper getMapper() {
			return mapper;
		}

		public void setMapper(TCommonSeqvalueMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return TCommonSeqvalueMapper.class;
		}
}
