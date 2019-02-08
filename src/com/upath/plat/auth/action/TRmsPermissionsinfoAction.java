/**
*/
package	com.upath.plat.auth.action;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.upath.plat.auth.facade.IUser;
import com.upath.plat.auth.model.TRmsPermissionsinfo;
import com.upath.plat.auth.service.TRmsPermissionsinfoService;
import com.upath.plat.common.action.BaseActionSupport;
import com.upath.plat.common.util.RequestHelper;



/**
* strut2 config :
* spring config :
* @ClassName: TRmsPermissionsinfoAction.java
* @Description: t_rms_permissionsinfo
* @author upaths@gmail.com  
* @date2012-11-11 21:51:25
* @version V1.0   
*/

@Scope("prototype")
@Component("tRmsPermissionsinfoAction")
@SuppressWarnings({ "rawtypes", "serial", "unused" })
public class TRmsPermissionsinfoAction extends BaseActionSupport {

	private static final Logger log = Logger.getLogger(TRmsPermissionsinfoAction.class);
	
	/*服务类*/
	private  TRmsPermissionsinfoService service;
	
	/*操作实体*/
	private TRmsPermissionsinfo bean;
	
	/*查询列表数据*/
	private List datas ;
	
	
	/**
	 * 查询单个实体
	 * @return select
	 */
	public String select(){
		TRmsPermissionsinfo data = service.select(bean);
		if(data != null){
			bean = data;
		}
		
		
		return FORWARD_SELECT;
	}
	
	/**
	 * 查询数据列表
	 * @return select
	 */
	public String list(){
		request.setAttribute("mapper",service.getMapperClass());
		return FORWARD_LIST;
	}
	
	/**
	 * 数据保存，首先从数据库检测一次是否存在 ，存在调用更新，否则调用插入
	 * @return select
	 */
	public String save(){
		boolean isNew = false;
		IUser user  = RequestHelper.getInstance().getLoginUser();
		TRmsPermissionsinfo data = service.select(bean);
			if(data != null){
				bean.setXgr(user.getUserName());
				bean.setXgsj(new Date());
				service.update(bean);
			}else{
				isNew = true;
				bean.setCjr(user.getUserName());
				bean.setCjsj(new Date());
				service.insert(bean);
			}
		return FORWARD_SAVEOK;
	}
	
	/**
	 * 删除数据
	 * @return select
	 */
	public String delete(){
		service.delete(bean);
		return null;
	}
	
	
	@Autowired
	public void setService(TRmsPermissionsinfoService service) {
		this.service = service;
	}

	public TRmsPermissionsinfo getBean() {
		return bean;
	}

	public void setBean(TRmsPermissionsinfo bean) {
		this.bean = bean;
	}

	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}

	
}
