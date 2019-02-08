/**
 */
package com.upath.plat.auth.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.upath.plat.auth.mapper.TRmsRoleMapper;
import com.upath.plat.auth.mapper.TRmsRoleMenuMapper;
import com.upath.plat.auth.mapper.TRmsRolePermisionsMapper;
import com.upath.plat.auth.mapper.TRmsUserRoleMapper;
import com.upath.plat.auth.model.TRmsRole;
import com.upath.plat.auth.model.TRmsRoleMenu;
import com.upath.plat.auth.model.TRmsRolePermisions;
import com.upath.plat.auth.model.TRmsUserRole;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

/**
 * 
 * @ClassName: TRmsRoleAction.java
 * @Description: t_rms_role
 * @author upaths@gmail.com
 * @date 2012-11-11 21:51:25
 * @version V1.0
 */
@SuppressWarnings({ "rawtypes", "unused" })
public class TRmsRoleService extends CommonService {

	private TRmsRoleMapper mapper;

	private TRmsRolePermisionsMapper gxMapper;
	
	private TRmsUserRoleMapper uMapper;
	
	private static final int BASE = 5000;
	
	private static final int BASEQX = 6000;
	
	private static final Logger log = Logger.getLogger(TRmsRoleService.class);

	/***=================================
	 * 注意 此类的 dao 类被 注入的 批量更新 的sqlSession execotorType ==  BATCH
	 * =================================
	 */
	
	public TRmsRole select(TRmsRole bean) {
		return mapper.select(bean);
	}

	public void insert(TRmsRole bean, List<TRmsRolePermisions> permisions) {
		int nextId = getPlatSequence().getNextDeaultId("role")+BASE;
		bean.setJsid(nextId);
		mapper.insert(bean);
		if(permisions != null && permisions.isEmpty() == false){
			int ids[] = getPlatSequence().getNextDeaultId("role_permission", permisions.size());
			for(int i = 0 ; i < ids.length ; i++){
				TRmsRolePermisions rp = permisions.get(i);
					rp.setJsqxgxid(ids[i]+BASEQX);
					rp.setJsid(bean.getJsid());
					gxMapper.insert(rp);
			}
		}
	}
	
	

	public void update(TRmsRole bean, List<TRmsRolePermisions> permisions) {
		mapper.update(bean);
		TRmsRolePermisions  query = new TRmsRolePermisions();
			query.setJsid(bean.getJsid());
			gxMapper.delete(query);
			if(permisions != null && permisions.isEmpty() == false){
				int ids[] = getPlatSequence().getNextDeaultId("role_permission", permisions.size());
				for(int i = 0 ; i < ids.length ; i++){
					TRmsRolePermisions rp = permisions.get(i);
						rp.setJsqxgxid(ids[i]+BASEQX);
						rp.setJsid(bean.getJsid());
						gxMapper.insert(rp);
				}
			}	
	}
	
	/**
	 * 维护角色菜单关系表
	 * @param bean
	 * @param adds
	 * @param dels
	 */
	public void batchMaintTree(TRmsRole bean,List<TRmsRoleMenu> adds,List<TRmsRoleMenu> dels){
			SqlSession session = this.dao.getSqlSession();
			TRmsRoleMenuMapper rmMapper = session.getMapper(TRmsRoleMenuMapper.class);
			List permission = session.getMapper(TRmsRoleMapper.class).listPermissions(bean);
			//使用默认的权限 进行赋值处理
			int qxCode = 0 ;
				if(permission != null){
					for(int i = 0 ; i < permission.size() ; i++){
						Map per = (Map) permission.get(i);
						Object code = per.get("QXCODE");
						if(code != null){
							int iCode = Integer.valueOf(code.toString());
							//进行与运算
							// qxCode = qxCode | iCode;
							// 进行权限加运算
							qxCode += 1 << iCode;
						}
					}
				}
			
			
				boolean flag = false;
				if(adds != null && adds.isEmpty() == false){
					flag = true;
					//不考虑性能的关系，此功能不经常使用
					for(TRmsRoleMenu m : adds){
						m.setJsid(bean.getJsid());
						m.setJscdgxid(m.getJsid()*10000 + m.getCdid());
						//直接 进行赋值
						m.setQx(qxCode);
						rmMapper.insert(m);
					}
				}
				if(dels != null && dels.isEmpty() == false){
					flag = true;
					for(TRmsRoleMenu m : dels){
						m.setJsid(bean.getJsid());
						rmMapper.delete(m);
					}
				}
	}
	
	/**
	 * 设置权限值
	 * @param bean
	 * @param adds
	 * @param dels
	 */
	public void batchMaintPermissions(List<TRmsRoleMenu> updates){
		SqlSession session = this.dao.getSqlSession();
		TRmsRoleMenuMapper rmMapper = session.getMapper(TRmsRoleMenuMapper.class);
		for(TRmsRoleMenu m : updates){
			rmMapper.update(m);
		}
	}
	
	/**
	 * 维护角色用户关系表
	 * @param bean
	 * @param adds
	 * @param dels
	 */
	public void batchMaintUser(TRmsRole bean,List<TRmsUserRole> adds,List<TRmsUserRole> dels){
		SqlSession session = this.dao.getSqlSession();
		TRmsUserRoleMapper rmMapper = session.getMapper(TRmsUserRoleMapper.class);
		boolean flag = false;
		if(adds != null && adds.isEmpty() == false){
			flag = true;
			for(TRmsUserRole m : adds){
				m.setJsid(bean.getJsid());
				m.setYhjsgxid(IDGenerator.getDateId());
				rmMapper.insert(m);
			}
		}
		if(dels != null && dels.isEmpty() == false){
			flag = true;
			for(TRmsUserRole m : dels){
				m.setJsid(bean.getJsid());
				rmMapper.delete(m);
			}
		}
	}
	

	public List listMenus(TRmsRole bean) {
		return mapper.menuList(bean);
	}
	
	public List listUser(TRmsRole bean) {
		return mapper.listUser(bean);
	}
	
	public List list(TRmsRole bean) {
		return mapper.list(bean);
	}
	
	public String selectByIds(List<String> ids) {
		
		String jsmc="";
		List<TRmsRole> list= mapper.selectByIds(ids);
		for (int i = 0; i < list.size(); i++) {
			TRmsRole bean =new TRmsRole();
			bean =list.get(i);
			jsmc+=bean.getJsmc();
			if(i!=list.size()-1){
				jsmc+=",";
			}
		}
		return jsmc;
	}

	public List listPermisions(TRmsRolePermisions bean) {
		return gxMapper.list(bean);
	}

	public void delete(TRmsRole bean) {
		mapper.delete(bean);
	}
	
	/**
	 * 清空删除当前权限关联的所有用户关系
	 * @param bean
	 */
	public void deleteRoleUsers(TRmsRole bean) {
		TRmsUserRole role = new TRmsUserRole();
		role.setJsid(bean.getJsid());
		uMapper.delete(role);
	}

	public TRmsRoleMapper getMapper() {
		return mapper;
	}

	public void setMapper(TRmsRoleMapper mapper) {
		this.mapper = mapper;
	}

	public Class getMapperClass() {
		return TRmsRoleMapper.class;
	}

	public TRmsRolePermisionsMapper getGxMapper() {
		return gxMapper;
	}

	public void setGxMapper(TRmsRolePermisionsMapper gxMapper) {
		this.gxMapper = gxMapper;
	}

	public TRmsUserRoleMapper getUMapper() {
		return uMapper;
	}

	public void setUMapper(TRmsUserRoleMapper mapper) {
		uMapper = mapper;
	}
}
