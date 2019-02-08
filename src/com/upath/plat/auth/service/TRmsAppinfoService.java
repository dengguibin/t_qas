/**
*/
package	com.upath.plat.auth.service;

import java.util.List;

import com.upath.plat.auth.mapper.TRmsAppinfoMapper;
import com.upath.plat.auth.model.TRmsAppinfo;
import com.upath.plat.common.service.CommonService;
/**
* 
* @ClassName: TRmsAppinfoAction.java
* @Description: t_rms_appinfo
* @author upaths@gmail.com  
* @date 2012-9-21 23:23:14
* @version V1.0   
*/
@SuppressWarnings({ "rawtypes" })
public class TRmsAppinfoService extends CommonService  {
		
		private TRmsAppinfoMapper mapper;
	
		public TRmsAppinfo select(TRmsAppinfo bean){
			return	mapper.select(bean);
		}
		
		public void insert(TRmsAppinfo  bean){
			int nextId =	this.getPlatSequence().getNextId();
			bean.setAppid(nextId);
			mapper.insert(bean);
		}
		
		public void update(TRmsAppinfo bean){
			mapper.update(bean);
		}
		
		public List list(TRmsAppinfo bean){
			return queryPageList(TRmsAppinfoMapper.class.getName()+".list", bean);
		}
		
		public void delete(TRmsAppinfo bean){
			mapper.delete(bean);
		}

		public TRmsAppinfoMapper getMapper() {
			return mapper;
		}

		public void setMapper(TRmsAppinfoMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return TRmsAppinfoMapper.class;
		}
}
