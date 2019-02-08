/**
*/
package	com.upath.plat.auth.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.upath.plat.auth.mapper.TRmsGorupsUserMapper;
import com.upath.plat.auth.mapper.TRmsGroupsMapper;
import com.upath.plat.auth.model.TRmsGorupsUser;
import com.upath.plat.auth.model.TRmsGroups;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.service.ISequence;
import com.upath.plat.common.util.IDGenerator;
/**
* 
* @ClassName: TRmsGroupsAction.java
* @Description: t_rms_groups
* @author upaths@gmail.com  
* @date 2012-11-17 17:22:21
* @version V1.0   
*/
@SuppressWarnings({ "rawtypes", "unused" })
public class TRmsGroupsService extends CommonService  {
		
		private TRmsGroupsMapper mapper;
		
		private TRmsGorupsUserMapper gMapper;
	
		public TRmsGroups select(TRmsGroups bean){
			return	mapper.select(bean);
		}
		
		public void insert(TRmsGroups  bean){
			ISequence seq = getPlatSequence();
			int id = seq.getNextDeaultId("groups");
			bean.setYhzid(id);
			mapper.insert(bean);
		}
		
		public void batchMaintUser(TRmsGroups bean,List<TRmsGorupsUser> adds ,List<TRmsGorupsUser> dels){
			SqlSession session = this.dao.getSqlSession();
			TRmsGorupsUserMapper rmMapper = session.getMapper(TRmsGorupsUserMapper.class);
			boolean flag = false;
			if(adds != null && adds.isEmpty() == false){
				flag = true;
				for(TRmsGorupsUser m : adds){
					m.setYhzyhgxid(IDGenerator.getDateId());
					rmMapper.insert(m);
				}
			}
			if(dels != null && dels.isEmpty() == false){
				flag = true;
				for(TRmsGorupsUser m : dels){
					rmMapper.delete(m);
				}
			}
		}
		
		public void deleteGroupUsers(TRmsGroups bean){
			TRmsGorupsUser group = new TRmsGorupsUser();
			group.setYhzid(bean.getYhzid());
			gMapper.delete(group);
		}
		
		public void update(TRmsGroups bean){
			mapper.update(bean);
		}
		
		public List list(TRmsGroups bean){
			return mapper.list(bean);
		}
		
		public List listUser(TRmsGroups bean){
			return mapper.listUser(bean);
		}
		
		public List listGroups(TRmsGroups bean){
			return mapper.listGroups(bean);
		}
		
		public void delete(TRmsGroups bean){
			mapper.delete(bean);
		}
		
		public TRmsGroupsMapper getMapper() {
			return mapper;
		}

		public void setMapper(TRmsGroupsMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return TRmsGroupsMapper.class;
		}

		public TRmsGorupsUserMapper getGMapper() {
			return gMapper;
		}

		public void setGMapper(TRmsGorupsUserMapper mapper) {
			gMapper = mapper;
		}
}
