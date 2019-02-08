/**
*/
package	com.upath.plat.auth.service;

import java.util.List;

import com.upath.plat.auth.facade.IRole;
import com.upath.plat.auth.facade.IUser;
import com.upath.plat.auth.mapper.TRmsDeptmentMapper;
import com.upath.plat.auth.mapper.TRmsUserMapper;
import com.upath.plat.auth.mapper.TRmsUserRoleMapper;
import com.upath.plat.auth.model.TRmsDeptment;
import com.upath.plat.auth.model.TRmsUser;
import com.upath.plat.auth.model.TRmsUserRole;
import com.upath.plat.common.cache.AuthCacheManager;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;
/**
* 
* @ClassName: TRmsUserAction.java
* @Description: t_rms_user
* @author upaths@gmail.com  
* @date 2012-11-3 22:06:30
* @version V1.0   
*/
@SuppressWarnings({ "rawtypes"})
public class TRmsUserService extends CommonService  {
		
		private TRmsUserMapper mapper;
		
		private TRmsDeptmentMapper dMapper;
		
		private TRmsUserRoleMapper userRoleMapper;
	
		public String selectById(String yhid){
			return	mapper.selectById(yhid);
		}

		public TRmsUser select(TRmsUser bean){
			return	mapper.select(bean);
		}
		
		public TRmsDeptment selectDeptment(String depId){
			TRmsDeptment bean = new TRmsDeptment();
			bean.setBmid(depId+"");
			return dMapper.select(bean);
		}
		
		public void insert(TRmsUser  bean){
			bean.setUid(IDGenerator.getUUID());
			mapper.insert(bean);
			//需要指定更新角色组
			if(bean.getRolesScope() != null){
				if(bean.getRoleIds() != null){
					String rids[] = bean.getRoleIds();
					for(int j = 0 ; j < rids.length ; j++){
						String roleId = rids[j];
						if(roleId != null){
							for(int i = 0 ; i < bean.getRolesScope().size() ; i++){
								IRole role = bean.getRolesScope().get(i);
								if(roleId.equals(role.getRoleId()) == true){
									TRmsUserRole uRole = new TRmsUserRole()	;
									uRole.setJsid(Integer.valueOf(roleId));
									uRole.setYhid(bean.getYhid());
									uRole.setYhjsgxid(IDGenerator.getUUID());
									userRoleMapper.insert(uRole);
								}
							}
						}
					}
					AuthCacheManager.getInstance().reload(AuthCacheManager.CODE_USER_ROLES);
				}
			}
			
		}
		
		public void update(TRmsUser bean){
			mapper.update(bean);
			//需要指定更新角色组
			
			IUser user = AuthCacheManager.getInstance().getUserById(bean.getYhid());
			if(user != null){
				List<IRole> extRoles = user.getRoles();
				String extRoleIds[] = null;
				if(extRoles != null){
					extRoleIds = new String[extRoles.size()];
					for(int i = 0 ; i < extRoles.size() ; i++){
						extRoleIds[i] = extRoles.get(i).getRoleId();
					}
				}
				
				if(bean.getRolesScope() != null){
					
						
						String rids[] = bean.getRoleIds();
					
						for(int i = 0 ; i < bean.getRolesScope().size() ; i++){
							
							IRole role = bean.getRolesScope().get(i);
							
							if(role.isAdmin() == true){
								//管理员角色不允许进行在这里进行操作更新,在前台应该屏蔽此权限的操作
								continue;
							}
							
							boolean matched = false;
							if(rids != null){
								for(int j = 0 ; j < rids.length ; j++){
									String roleId = rids[j];
									if(roleId != null  && roleId.equals(role.getRoleId()) == true){
										matched = true;
										break;
									}
								}
							}
							
							boolean extMatched = false;
							
							if(extRoleIds != null){
								for(int j = 0 ; j < extRoleIds.length ; j++){
									String roleId = extRoleIds[j];
									if(roleId != null  && roleId.equals(role.getRoleId()) == true){
										extMatched = true;
										break;
									}
								}
							}
							
							TRmsUserRole uRole = new TRmsUserRole()	;
							uRole.setJsid(Integer.valueOf(role.getRoleId()));
							uRole.setYhid(bean.getYhid());
							
							if(matched == true && extMatched == false){
								uRole.setYhjsgxid(IDGenerator.getUUID());
								userRoleMapper.insert(uRole);
							}
							
							if(matched == false && extMatched == true){
								userRoleMapper.delete(uRole);
							}
							
					}
					AuthCacheManager.getInstance().reload(AuthCacheManager.CODE_USER_ROLES);	
				}
				
			}
			
			
		}
		
		public void updateStatus(TRmsUser bean){
			mapper.updateStatus(bean);
		}
		
		public List list(TRmsUser bean){
			return queryPageList(TRmsUserMapper.class.getName()+".list", bean);
		}
		
		public List  listDeptUsers(TRmsUser bean){
			return queryPageList(TRmsUserMapper.class.getName()+".listDeptUsers", bean);
		}
		
		public void delete(TRmsUser bean){
			mapper.delete(bean);
		}
		
		public TRmsUserMapper getMapper() {
			return mapper;
		}

		public void setMapper(TRmsUserMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return TRmsUserMapper.class;
		}

		public TRmsDeptmentMapper getDMapper() {
			return dMapper;
		}

		public void setDMapper(TRmsDeptmentMapper mapper) {
			dMapper = mapper;
		}
		
		public void setUserRoleMapper(TRmsUserRoleMapper userRoleMapper) {
			this.userRoleMapper = userRoleMapper;
		}
}
