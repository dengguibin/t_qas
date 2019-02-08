package	com.upath.plat.auth.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;

import com.upath.plat.auth.facade.IRole;
import com.upath.plat.auth.mapper.TRmsMenuinfoMapper;
import com.upath.plat.auth.mapper.TRmsRoleMenuMapper;
import com.upath.plat.auth.model.TRmsMenuinfo;
import com.upath.plat.auth.model.TRmsRoleMenu;
import com.upath.plat.common.cache.AuthCacheManager;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.service.ISequence;
/**
* 
* @ClassName: TRmsMenuinfoAction.java
* @Description: t_rms_menuinfo
* @author upaths@gmail.com  
* @date 2012-10-20 21:50:35
* @version V1.0   
*/
@SuppressWarnings({ "rawtypes", "unchecked" })
public class TRmsMenuinfoService extends CommonService {
		
	private TRmsMenuinfoMapper mapper;

	public TRmsMenuinfo select(TRmsMenuinfo bean) {
		return mapper.select(bean);
	}

	public List<TRmsRoleMenu> listRolesByMenuId(int menuId) {
		TRmsRoleMenu querys = new TRmsRoleMenu();
		querys.setCdid(menuId);
		return this.queryList(TRmsRoleMenuMapper.class.getName() + ".list", querys);
	}

	public void insert(TRmsMenuinfo bean) {
		ISequence sequence = getPlatSequence();
		bean.setCdid(sequence.getNextDeaultId("menu"));
		mapper.insert(bean);
		// 把菜单和角色的关系维护到数据库里面
		if (bean.getRoleIds() != null) {
			SqlSession session = this.dao.getSqlSession();
			TRmsRoleMenuMapper rmMapper = session.getMapper(TRmsRoleMenuMapper.class);
			for (String s : bean.getRoleIds()) {
				IRole role = AuthCacheManager.getInstance().getRoleById(s);
				TRmsRoleMenu m = new TRmsRoleMenu();
				m.setJsid(Integer.valueOf(s));
				m.setJscdgxid(m.getJsid() * 10000 + bean.getCdid());
				m.setCdid(bean.getCdid());
				m.setQx(role.getPermCode());
				rmMapper.insert(m);
			}
			// 重新加载菜单与角色的关系
			AuthCacheManager.getInstance().reload(AuthCacheManager.CODE_ROLES_MENUS);
		}
	}

	public void update(TRmsMenuinfo bean) {
		mapper.update(bean);
		// 把菜单和角色的关系维护到数据库里面
		SqlSession session = this.dao.getSqlSession();
		TRmsRoleMenuMapper rmMapper = session.getMapper(TRmsRoleMenuMapper.class);
		List<IRole> roles = AuthCacheManager.getInstance().getAllRoles();
		List<TRmsRoleMenu> rmsInfo = this.listRolesByMenuId(bean.getCdid());
		if (roles != null) {
			// 移除数据操作
			Set<String> extRoleids = new HashSet<String>();
			for (int i = 0; i < roles.size(); i++) {
				IRole role = roles.get(i);
				boolean exst = false;
				if (rmsInfo != null) {
					for (TRmsRoleMenu rm : rmsInfo) {
						if ((rm.getJsid() + "").equals(role.getRoleId()) == true) {
							exst = true;
							break;
						}
					}
				}
				// 系统原来就有此角色和菜单的关系
				if (exst == true) {
					boolean matched = false;
					if (bean.getRoleIds() != null) {
						for (String s : bean.getRoleIds()) {
							if (s.equals(role.getRoleId()) == true) {
								matched = true;
								extRoleids.add(s);
							}
						}
					}
					// 已经人前台移除这个关系的情况下面，那么需要做移除动作
					if (matched == false) {
						TRmsRoleMenu m = new TRmsRoleMenu();
						m.setJsid(Integer.valueOf(role.getRoleId()));
						m.setCdid(bean.getCdid());
						rmMapper.delete(m);
					}
				}
			}
			if (bean.getRoleIds() != null) {
				for (String s : bean.getRoleIds()) {
					if (extRoleids.contains(s) == true) {
						// 关系已经存在不需要再进行插入操作
						continue;
					}
					IRole role = AuthCacheManager.getInstance().getRoleById(s);
					TRmsRoleMenu m = new TRmsRoleMenu();
					m.setJsid(Integer.valueOf(s));
					m.setJscdgxid(m.getJsid() * 10000 + bean.getCdid());
					m.setCdid(bean.getCdid());
					m.setQx(role.getPermCode());
					rmMapper.insert(m);
				}
			}
			// 重新加载菜单与角色的关系
			AuthCacheManager.getInstance().reload(AuthCacheManager.CODE_ROLES_MENUS);
		}
	}

	public List list(TRmsMenuinfo bean) {
		return mapper.list(bean);
	}

	public List listMenus(TRmsMenuinfo bean) {
		return mapper.listMenus(bean);
	}

	public void delete(TRmsMenuinfo bean) {
		mapper.delete(bean);
	}

	public TRmsMenuinfoMapper getMapper() {
		return mapper;
	}

	public void setMapper(TRmsMenuinfoMapper mapper) {
		this.mapper = mapper;
	}

	public Class getMapperClass() {
		return TRmsMenuinfoMapper.class;
	}
}
