/**
*/
package	com.upath.plat.auth.service;

import java.util.ArrayList;
import java.util.List;

import com.upath.plat.auth.mapper.TRmsDeptmentMapper;
import com.upath.plat.auth.mapper.TRmsUserMapper;
import com.upath.plat.auth.mapper.TRmsUserRoleMapper;
import com.upath.plat.auth.model.TRmsDeptment;
import com.upath.plat.auth.model.TRmsUser;
import com.upath.plat.auth.model.TRmsUserRole;
import com.upath.plat.common.cache.AuthCacheManager;
import com.upath.plat.common.exception.PlatformException;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.service.ISequence;
import com.upath.plat.common.util.IDGenerator;
/**
* 
* @ClassName: TRmsDeptmentAction.java
* @Description: t_rms_deptment
* @author upaths@gmail.com  
* @date 2012-11-3 22:06:30
* @version V1.0   
*/
@SuppressWarnings({ "rawtypes"})
public class TRmsDeptmentService extends CommonService  {
		
		private TRmsDeptmentMapper mapper;
	
		public TRmsDeptment select(TRmsDeptment bean){
			return	mapper.select(bean);
		}
		
		public void insert(TRmsDeptment  bean){
			ISequence seq = getPlatSequence();
			int id = seq.getNextDeaultId("department")+1000;
			//为了防止数据的安全使用随机进行编码
			bean.setBmid(id+"-"+IDGenerator.getId());
			if(bean.getFbmid() == null){
				bean.setFdncode(bean.getBmid());
				bean.setCj(1);
			}else{
				TRmsDeptment query = new TRmsDeptment();
				query.setBmid(bean.getFbmid());
				TRmsDeptment parent = mapper.select(query);
				if(parent == null){
					throw new PlatformException("错误参数，无法找到对应的上级单位信息");
				}
				bean.setFdncode(parent.getFdncode() + "|"+bean.getBmid());
				bean.setCj(parent.getCj() + 1);
			}
			mapper.insert(bean);
			AuthCacheManager.getInstance().reload(AuthCacheManager.CODE_ORGS);
			AuthCacheManager.getInstance().reload();
		}
		
		public void update(TRmsDeptment bean){
			if(bean.getFbmid() == null){
				bean.setFdncode(bean.getBmid());
				bean.setCj(1);
			}else{
				TRmsDeptment query = new TRmsDeptment();
				query.setBmid(bean.getFbmid());
				TRmsDeptment parent = mapper.select(query);
				if(parent == null){
					throw new PlatformException("错误参数，无法找到对应的上级单位信息");
				}
				bean.setFdncode(parent.getFdncode() + "|"+bean.getBmid());
				bean.setCj(parent.getCj() + 1);
			}
			mapper.update(bean);
			AuthCacheManager.getInstance().reload(AuthCacheManager.CODE_ORGS);
			AuthCacheManager.getInstance().reload();
		}
		
		public List list(TRmsDeptment bean){
			return mapper.list(bean);
		}
		
		
		
		
		public void saveExcelDepts(List<TRmsDeptment> depts,List<TRmsUser> users){
			List<TRmsUserRole> urs = new ArrayList<TRmsUserRole>();
			for(int i = 0 ; i < users.size() ; i++){
				TRmsUser user = users.get(i);
				if(user.getRoleIds() != null){
					for(int j = 0 ; j < user.getRoleIds().length ; j++){
						String rid = user.getRoleIds()[j];
						TRmsUserRole uRole = new TRmsUserRole()	;
						uRole.setJsid(Integer.valueOf(rid));
						uRole.setYhid(user.getYhid());
						uRole.setYhjsgxid(IDGenerator.getUUID());
						urs.add(uRole);
					}
				}
			}
			for(int i = 0 ; i < depts.size() ; i++){
				initFdnCode(depts.get(i),depts);
			}
			this.batchInsert(depts,TRmsDeptmentMapper.class.getName() + ".insert");
			this.batchInsert(users,TRmsUserMapper.class.getName() + ".insert");
			if(urs.isEmpty() == false){
				this.batchInsert(urs,TRmsUserRoleMapper.class.getName() + ".insert");
			}
			AuthCacheManager.getInstance().reload(AuthCacheManager.CODE_ORGS);
			AuthCacheManager.getInstance().reload();
		}
		
		void initFdnCode(TRmsDeptment dept,List<TRmsDeptment> depts){
			if(dept.getFbmid() == null){
				dept.setCj(1);
				dept.setFdncode(dept.getBmid());
			}else{
				String fid = dept.getFbmid();
				TRmsDeptment parent = null;
				for(int i = 0 ; i < depts.size() ; i++){
					if(fid.equals(depts.get(i).getBmid()) == true){
						parent = depts.get(i);
						break;
					}
				}
				if(parent == null ){
					throw new PlatformException("错误 的数据格式，无法找到上级单位信息");
				}
				if(parent.getFdncode() == null){
					initFdnCode(parent,depts);
				}
				dept.setFdncode(parent.getFdncode() + "|"+dept.getBmid());
				dept.setCj(parent.getCj() + 1);
			}
		}
		
		
		
		public List listSubDepts(TRmsDeptment bean){
			return mapper.listSubDepts(bean);
		}
		
		public void delete(TRmsDeptment bean){
			mapper.delete(bean);
			AuthCacheManager.getInstance().reload(AuthCacheManager.CODE_ORGS);
			AuthCacheManager.getInstance().reload();
		}
		
		public TRmsDeptmentMapper getMapper() {
			return mapper;
		}

		public void setMapper(TRmsDeptmentMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return TRmsDeptmentMapper.class;
		}
}
