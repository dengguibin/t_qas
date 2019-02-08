package com.upath.plat.common.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.upath.plat.auth.facade.IDepartMent;
import com.upath.plat.auth.facade.IFunction;
import com.upath.plat.auth.facade.IGroup;
import com.upath.plat.auth.facade.IMenu;
import com.upath.plat.auth.facade.IPermissions;
import com.upath.plat.auth.facade.IRole;
import com.upath.plat.auth.facade.IUser;
import com.upath.plat.auth.facade.Relations;
import com.upath.plat.common.exception.PlatformException;
import com.upath.plat.common.service.ICommonService;
import com.upath.plat.common.util.PlatUtil;
@SuppressWarnings({ "rawtypes","unchecked"})
public class AuthCacheManager implements ISystemCache {

	/**
	 * 系统所有的菜单数据
	 */
	private final static List<IMenu> MENUS = new ArrayList<IMenu>();
	
	/**
	 * 字典-菜单
	 */
	public static final String CODE_MENUS = "_menus";
	
	/**
	 * 功能缓存
	 */
	private final static List<IFunction> FUNCS = new ArrayList<IFunction>();
	
	/**
	 * 
	 */
	public static final String CODE_FUNCS = "_funcs";
	
	/**
	 * 系统所有的角色数据
	 */
	private final static List<IRole> ROLES = new ArrayList<IRole>();
	
	/**
	 * 
	 */
	public static final String CODE_USER_ROLES = "_user_roles";
	
	/**
	 * 角色与菜单 的关系
	 */
	public static final String CODE_ROLES_MENUS = "_roles_menus";
	
	/**
	 * 系统所有的部门数据
	 */
	private final static List<IDepartMent> DEPARTMENTS = new ArrayList<IDepartMent>();
	
	/**
	 * 字典-菜单
	 */
	public static final String CODE_ORGS = "_orgs";

	/**
	 * 系统所有的用户组数据
	 */
	private final static List<IGroup> GROUPS = new ArrayList<IGroup>();
	
	/**
	 * 
	 */
	private final static List<IPermissions> PERMISSIONS = new ArrayList<IPermissions>();
	
	/**
	 * 存储系统中 角色与用户的关系
	 *        用户组与用户的关系
	 *        角色与菜单的关系
	 *        角色与权限的关系
	 */
	private final static Map<String, List<Relations>> RELATIONSSTORES = new HashMap<String, List<Relations>>();
	
	private static final Logger log = Logger.getLogger(AuthCacheManager.class);
	
	private static AuthCacheManager caceManager = null;
	
	private ICommonService service;
	
	
	public List<IFunction> getAllFunctions(){
		List<IFunction> list = new ArrayList<IFunction>();
		list.addAll(FUNCS);
		return list;
	}
	
	public List<IFunction> getFunctions(IMenu menu){
		List<IFunction> list = new ArrayList<IFunction>();
		for(int j = 0 ; j < FUNCS.size() ; j++){
			IFunction func = FUNCS.get(j);
			if(menu.getMenuId() == func.getMenuId() ){
				list.add(func);
			}
		}
		return list;
	}
	
	/**
	 * 查询用户下面所有已经分配的权限代码
	 * @param user
	 * @return
	 */
	public List<IFunction> getFunctions(IUser user){
		if(user.isAdmin() == true){
			return getAllFunctions();
		}
		List<IFunction> list = new ArrayList<IFunction>();
		List<IMenu> menus = user.getMenus();
		if(menus != null){
			if(FUNCS != null){
				for(int i = 0 ; i < menus.size() ; i++){
					IMenu menu = menus.get(i);
					for(int j = 0 ; j < FUNCS.size() ; j++){
						IFunction func = FUNCS.get(j);
						if(menu.getMenuId() == func.getMenuId() ){
							list.add(func);
						}
					}
				}
			}
		}
		return list;
	}
	
	public List<IPermissions> getAllPermissions() {
		List<IPermissions> list = new ArrayList<IPermissions>();
		list.addAll(PERMISSIONS);
		return list;
	}
	
	/**
	 * 返回用户对 菜单 的权限控制信息
	 * @param menuId 菜单ID
	 * @param user 用户
	 * @return
	 */
	public List<IPermissions> getMenuPermissions(String menuId, IUser user) {
		List<IPermissions> list = null;
		if (user != null && menuId != null) {
			if (user.isAdmin() == true && user.getCurrentRole() == null) {
				return getAllPermissions();
			}
			int style = 0;
			// 转换成指定的角色下面进行工作
			List<IRole> roles = user.getRoles();
			if (user.getCurrentRole() != null) {
				roles = new ArrayList<IRole>();
				roles.add(user.getCurrentRole());
			}
			if (roles != null) {
				for (IRole r : roles) {
					// RM 角色与菜单关系,查看SQL selectRoleMenu
					List<Relations> rs = RELATIONSSTORES.get("RM");
					if (rs != null) {
						for (Relations t : rs) {
							String rId = t.getKey();
							if (r.getRoleId().equals(rId) == true) {
								String mId = t.getValue();
								if (menuId.equals(mId) == true) {
									if (t.getStat() != null) {
										style |= t.getStat();
									}
								}
							}
						}
					}
				}
			}
			if (style != 0) {
				list = new ArrayList<IPermissions>();
				if (PERMISSIONS != null) {
					for (IPermissions p : PERMISSIONS) {
						if (p.getStat() != null) {
							int value = 1 << p.getStat();
							if ((value & style) > 0) {
								list.add(p);
							}
						}
					}
				}
			}
		}
		return list;
	}
	
	public static AuthCacheManager getInstance() {
		if (caceManager == null) {
			caceManager = (AuthCacheManager)PlatUtil.getApplicationContext().getBean("authCacheManager");
		}
		return caceManager;
	}
	
	public IMenu getMenu(int menuId){
		for(IMenu menu : MENUS){
			if(menu.getMenuId() == menuId){
				return menu;
			}
		}
		return null;
	}
	
	/**
	 * 通过用户ID查找对应的用户
	 * @param userId
	 * @return
	 */
	public  IUser getUserById(String userId){
		IUser user = (IUser)service.queryObject("selectUser", userId);
		return user;
	}
	
	/**
	 * 通过角色ID返回对应的角色
	 * @param roleId
	 * @return
	 */
	public IRole getRoleById(String roleId) {
		IRole role = null;
		for (IRole r : ROLES) {
			if (r.getRoleId().equals(roleId) == true) {
				role = r;
				break;
			}
		}
		return role;
	}

	/**
	 * 获取系统所有的用户
	 * @return
	 */
	public List<IUser> getAllUsers(){
		List<IUser> users = service.queryList("selectUser", null);
		return users;
	}
	
	public List<IUser> getDeptUsers(IDepartMent dept){
		List<IUser> deptUsers = null;
		if (dept != null) {
			List<IUser> users = getAllUsers();
			deptUsers = new ArrayList<IUser>();
			if (users != null && users.isEmpty() == false) {
				for (int i = 0; i < users.size(); i++) {
					IUser user = users.get(i);
					if (dept.equals(user.getDepartMent()) == true) {
						deptUsers.add(user);
					}
				}
			}
		}
		return deptUsers;
	}
	
	/**
	 * 通过菜单ID收集他的所有子菜单 ，但是不包括 他的 子菜单 的后代节点菜单
	 * @param menuId
	 * @return
	 */
	@SuppressWarnings("null")
	public List<IMenu> getChildenById(int menuId){
		List<IMenu> menus = null;
		for (IMenu menu : menus) {
			if (menuId == menu.getPId()) {
				if (menus == null) {
					menus = new ArrayList<IMenu>();
				}
				menus.add(menu);
			}
		}
		return menus;
	}
	
	/**
	 * 返回此用户组下面所有关联的用户
	 * @param group
	 * @return
	 */
	public List<IUser> getGroupUsers(IGroup group){
		List<Relations> reList = RELATIONSSTORES.get("GU");
		List<IUser> allUsers = getAllUsers();
		List<IUser> results = null;
		for (Relations r : reList) {
			if (group.getGroupId().equals(r.getKey()) == true) {
				for (IUser u : allUsers) {
					if (u.getUserId().equals(r.getValue()) == true) {
						if (results == null) {
							results = new ArrayList<IUser>();
						}
						results.add(u);
					}
				}
			}
		}
		return results;
	}
	
	/**
	 * 返回指定角色下面所拥有的权限
	 * @param role
	 * @return
	*/ 
	public List<IPermissions> getRolePermissions(IRole role){
		List<Relations> reList = RELATIONSSTORES.get("RP");
		List<IPermissions> results = null;
		for (Relations r : reList) {
			if (role.getRoleId().equals(r.getKey()) == true) {
				for (IPermissions p : PERMISSIONS) {
					if (p.getId().equals(r.getValue()) == true) {
						if (results == null) {
							results = new ArrayList<IPermissions>();
						}
						results.add(p);
					}
				}
			}
		}
		return results;
	}

	/**
	 * 返回拥有此权限的所有 角色
	 * @param p
	 * @return
	 */
	public List<IRole> getPermissionRole(IPermissions p){
		List<Relations> reList = RELATIONSSTORES.get("RP");
		List<IRole> roles = null;
		for(Relations r : reList){
			if(r.getValue().equals(p) == true){
				for(IRole role : ROLES){
					if(role.getRoleId().equals(r.getKey()) == true){
						if(roles == null){
							roles = new ArrayList<IRole>();
						}
						roles.add(role);
					}
				}
			}
		}
		return roles;
	}
	
	/**
	 * 返回此角色下面所有关联的用户
	 * @param role
	 * @return
	 */
	public List<IUser> getRoleUsers(IRole role){
		List<Relations> reList = RELATIONSSTORES.get("RU");
		List<IUser> allUsers = getAllUsers();
		List<IUser> results = null;
		for (Relations r : reList) {
			if (role.getRoleId().equals(r.getKey()) == true) {
				for (IUser u : allUsers) {
					if (u.getUserId().equals(r.getValue()) == true) {
						if (results == null) {
							results = new ArrayList<IUser>();
						}
						results.add(u);
					}
				}
			}
		}
		return results;
	}
	
	public List<IGroup> getGroups(IUser user){
		List<IGroup> groups = null;
		List<Relations> reList = RELATIONSSTORES.get("GU");
		for (IGroup g : GROUPS) {
			for (Relations r : reList) {
				if (r.getKey().equals(g.getGroupId()) == true) {
					if (user.getUserId().equals(r.getValue()) == true) {
						if (groups == null) {
							groups = new ArrayList<IGroup>();
						}
						groups.add(g);
						break;
					}
				}
			}
		}
		return groups;
	}
	
	/**
	 * 通过用户组ID 获取用户组信息
	 * @param groupId
	 * @return
	 */
	public IGroup getGroup(String groupId){
		for(IGroup g : GROUPS){
			if(g.getGroupId().equals(groupId) == true){
				return g;
			}
		}
		return null;
	}
	
	/**
	 * 查询用户组下面的子用户组，但是不包括子组的所有 组
	 * @param group
	 * @return
	 */
	public List<IGroup> getGroupChildren(IGroup group){
		List<IGroup> groups = null;
		for (IGroup g : GROUPS) {
			IGroup pGroup = g.getParent();
			if (pGroup != null) {
				if (pGroup.getGroupId().equals(group.getGroupId()) == true) {
					if (groups == null) {
						groups = new ArrayList<IGroup>();
					}
					groups.add(g);
				}
			}
		}
		return groups;
	}
	
	/**
	 * 通过部门ID 获取部门的相关信息
	 * @param deptId
	 * @return
	 */
	public IDepartMent getDepartMent(String deptId){
		IDepartMent dept  = null;
		for(IDepartMent d : DEPARTMENTS){
			if(d.getDeptId().equals(deptId) == true){
				dept = d;
				break;
			}
		}
		return dept;
	}
	
	/**
	 * 通过部门ID 获取部门的相关信息
	 * @param deptId
	 * @return
	 */
	public List<IDepartMent> getSubDepartMent(String deptId){
		List<IDepartMent> depts = null;
		for(IDepartMent d : DEPARTMENTS){
			if(d.getParent() != null){
				if(d.getParent().getDeptId().equals(deptId) == true){
					if(depts == null){
						depts = new ArrayList<IDepartMent>();
					}
					depts.add(d);
				}
			}
		}
		return depts;
	}
	
	public void load() throws PlatformException {
		reload();
	
	}

	public synchronized  void reload() throws PlatformException {
		log.info("*********************权限相关缓存数据开始进行加载******************************");
		MENUS.clear();
		log.info(":菜单数据进行查询加载");
		List<IMenu> list = service.queryList("plat.menuCache", null);
		MENUS.addAll(list);
		
		/**
		 * 菜单功能缓存加载
		 */
		FUNCS.clear();
		log.info(":菜单功能缓存加载");
		List<IFunction> funcList = service.queryList("plat.funcCache", null);
		if( funcList != null){
			FUNCS.addAll(funcList);
		}
		
		/**
		 * 重新加载角色信息
		 */
		log.info(":角色数据进行查询加载");
		ROLES.clear();
		List<IRole> rs = service.queryList("selectAllRole", null);
		ROLES.addAll(rs);
		
		/**
		 * 部门信息数据
		 */
		log.info(":部门信息数据进行查询加载");
		DEPARTMENTS.clear();
		List<IDepartMent> depList = service.queryList("selectDeptment", null);
		DEPARTMENTS.addAll(depList);
		
		log.info(":用户组数据进行查询加载");
		GROUPS.clear();
		List<IGroup> gp = service.queryList("selectGroup", null);
		GROUPS.addAll(gp);
		
		/**
		 * 加载授权信息表数据
		 */
		log.info(":权限数据进行查询加载");
		PERMISSIONS.clear();
		List<IPermissions> ps = service.queryList("selectPermissions", null);
		PERMISSIONS.addAll(ps);
		
		log.info(":角色与用户、角色与菜单、角色与权限、用户与用户组关系 进行查询加载");
		RELATIONSSTORES.clear();
		//角色与用户的关系
		RELATIONSSTORES.put("RU", service.queryList("selectRoleUser", null));
		/*角色与菜单关系里面 同时 STAT 这个字段里面绑定了此角色对此菜单的权限关系值*/
		//角色与菜单的关系缓存
		RELATIONSSTORES.put("RM", service.queryList("selectRoleMenu", null));
		//角色与权限的关系缓存
		RELATIONSSTORES.put("RP", service.queryList("selectRolePermissions", null));
		//用户与用户组的关系
		RELATIONSSTORES.put("GU", service.queryList("selectGroupUser", null));
		log.info("********************权限相关数据加载完成*******************************");
	}
	
	/**
	 * 查看指定用户拥有的系统权限
	 * @param user
	 * @return
	 */
	public List<IRole> getRoles(IUser user){
		List<IRole> rls = null;
		String uid = user.getUserId();
		// 用户ID 绑定在 VALUE 下面
		List<Relations> rurs = RELATIONSSTORES.get("RU");
		for (Relations rs : rurs) {
			if (uid.equals(rs.getValue()) == true) {
				for (IRole r : ROLES) {
					if (rs.getKey().equals(r.getRoleId()) == true) {
						if (rls == null) {
							rls = new ArrayList<IRole>();
						}
						rls.add(r);
						break;
					}
				}

			}
		}
		return rls;
	}
	
	public List<IRole> getAllRoles(){
		List<IRole> roles = new ArrayList<IRole>();
		roles.addAll(ROLES);
		return roles;
	}
	
	/**
	 * 查看此角色下面配置的菜单
	 * @param role
	 * @return
	 */
	public List<IMenu> getMenus(IRole role){
		List<IMenu> mus = null;
		String rid = role.getRoleId();
		// 用户ID 绑定在 VALUE 下面
		List<Relations> rmrs = RELATIONSSTORES.get("RM");
		for (Relations r : rmrs) {
			if (rid.equals(r.getKey()) == true) {
				for (IMenu m : MENUS) {
					if (r.getValue().equals(m.getMenuId() + "") == true) {
						if (mus == null) {
							mus = new ArrayList<IMenu>();
						}
						mus.add(m);
						break;
					}
				}
			}
		}
		return mus;
	}
	
	/**
	 * 查看用户拥有的菜单
	 * 如果用户使用指定的角色进行登陆。
	 * 那么系统分配用分指定的角色菜单
	 * @param user
	 * @return
	 */
	public List<IMenu> getMenus(IUser user) {
		List<IMenu> mus = new ArrayList<IMenu>();
		if(user.getCurrentRole() != null) {
			IRole role = user.getCurrentRole();
			mus.addAll(role.getMenus());
		} else if(user.isAdmin() == true) {
			mus.addAll(MENUS);
		} else {
			List<IRole> rs = user.getRoles();
			if(rs != null) {
				for(IRole r : rs) {
					for(IMenu menu : MENUS) {
						if(mus.contains(menu) == false && r.hasMenu(menu) == true) {
							mus.add(menu);
						}
					}
				}
			}
		}
		return mus;
	}
	
	public synchronized void reload(String cacheCode) throws PlatformException {
		if(CODE_MENUS.equals(cacheCode) == true){
			MENUS.clear();
			log.info(":菜单数据进行查询加载");
			List<IMenu> list = service.queryList("plat.menuCache", null);
			MENUS.addAll(list);
		}else if(CODE_ORGS.equals(cacheCode) == true){
			log.info(":部门信息数据进行查询加载");
			DEPARTMENTS.clear();
			List<IDepartMent> depList = service.queryList("selectDeptment", null);
			DEPARTMENTS.addAll(depList);
		}else if(CODE_FUNCS.equals(cacheCode) == true){
			FUNCS.clear();
			log.info(":菜单功能缓存加载");
			List<IFunction> funcList = service.queryList("plat.funcCache", null);
			if( funcList != null){
				FUNCS.addAll(funcList);
			}
		}else if(CODE_USER_ROLES.equals(cacheCode) == true){
			log.info("用户权限树关系重新加载");
			List list = service.queryList("selectRoleUser", null);
			RELATIONSSTORES.put("RU", list);
		}else if(CODE_ROLES_MENUS.equals(cacheCode)){
			log.info("角色与菜单的关系缓存重新加载");
			//角色与菜单的关系缓存
			RELATIONSSTORES.put("RM", service.queryList("selectRoleMenu", null));
		}else{
			log.warn("系统暂 不支持重载此缓存:"+cacheCode);
		}
	}

	public void release() throws PlatformException {
		MENUS.clear();
		ROLES.clear();
		DEPARTMENTS.clear();
		PERMISSIONS.clear();
		RELATIONSSTORES.clear();
		GROUPS.clear();
	}

	public void remove(String cacheCode) throws PlatformException {
		
	}
	
	public ICommonService getService() {
		return service;
	}

	public void setService(ICommonService service) {
		this.service = service;
	}

	public String getDescription() {
		return "BaseMapper.xml{authCache} :权限管理系统开始进行缓存管理";
	}
	
}
