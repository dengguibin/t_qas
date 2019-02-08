/**
*/
package	com.upath.plat.common.modules.service;

import java.util.List;

import com.upath.plat.common.exception.PlatformException;
import com.upath.plat.common.modules.mapper.TCommonSeqMapper;
import com.upath.plat.common.modules.model.TCommonSeq;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.service.ISequence;
/**
* 
* @ClassName: TCommonSeqAction.java
* @Description: t_common_seq
* @author upaths@gmail.com  
* @date 2012-10-31 21:16:23
* @version V1.0   
*/
@SuppressWarnings({ "rawtypes" })
public class TCommonSeqService extends CommonService  {
		
		private TCommonSeqMapper mapper;
	
		public TCommonSeq select(TCommonSeq bean){
			return	mapper.select(bean);
		}
		
		public void insert(TCommonSeq  bean) throws PlatformException{
			ISequence seq = getPlatSequence();
			bean.setSeqid(seq.getNextId());
			mapper.insert(bean);
		}
		
		public void update(TCommonSeq bean){
			mapper.update(bean);
		}
		
		public List list(TCommonSeq bean){
			return mapper.list(bean);
		}
		
		public void delete(TCommonSeq bean){
			mapper.delete(bean);
		}
		
		public TCommonSeqMapper getMapper() {
			return mapper;
		}

		public void setMapper(TCommonSeqMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return TCommonSeqMapper.class;
		}
}
