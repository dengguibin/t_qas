/**
*/
package	com.upath.plat.common.modules.service;

import java.util.*;
import com.upath.plat.common.modules.model.TRmsAlllogs;
import com.upath.plat.common.modules.mapper.TRmsAlllogsMapper;
import com.upath.plat.common.service.CommonService;
/**
* 
* @ClassName: TRmsAlllogsAction.java
* @Description: T_RMS_ALLLOGS
* @author upaths@gmail.com  
* @date 2015-2-11 16:20:31
* @version V1.0   
*/
@SuppressWarnings({ "rawtypes" })
public class TRmsAlllogsService extends CommonService  {
		
		private TRmsAlllogsMapper mapper;
	
		public TRmsAlllogs select(TRmsAlllogs bean){
			return	mapper.select(bean);
		}
		
		public void insert(TRmsAlllogs  bean){
			mapper.insert(bean);
		}
		
		public void update(TRmsAlllogs bean){
			mapper.update(bean);
		}
		
		public List list(TRmsAlllogs bean){
			return queryPageListWithPlug(TRmsAlllogsMapper.class.getName()+".list", bean);
		}
		
		/**
		 * 查询日志解释的数据
		 * @param rows
		 * @return
		 */
		public List listParseLogs(int rows){
			return mapper.listParseLogs(rows);
		}
		
		
		public void updateBatch(List datas){
			if(datas != null && datas.isEmpty() == false){
				batchUpdate(datas, TRmsAlllogsMapper.class.getName()+".update");
			}
		}
		
		public void delete(TRmsAlllogs bean){
			mapper.delete(bean);
		}
		
		public TRmsAlllogsMapper getMapper() {
			return mapper;
		}

		public void setMapper(TRmsAlllogsMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return TRmsAlllogsMapper.class;
		}
}
