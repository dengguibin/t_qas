/**
*/
package	com.upath.plat.common.modules.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.upath.plat.common.action.BaseActionSupport;
import com.upath.plat.common.cache.CacheManager;
import com.upath.plat.common.exception.PlatformException;
import com.upath.plat.common.modules.model.TCommonKeys;
import com.upath.plat.common.modules.service.TCommonKeysService;



/**
* strut2 config :
* spring config :
* @ClassName: TCommonKeysAction.java
* @Description: t_common_keys
* @author upaths@gmail.com  
* @date2012-10-25 22:01:03
* @version V1.0   
*/

@Scope("prototype")
@Component("tCommonKeysAction")
@SuppressWarnings({ "rawtypes", "serial", "unused" })
public class TCommonKeysAction extends BaseActionSupport {

	private static final Logger log = Logger.getLogger(TCommonKeysAction.class);
	
	/*服务类*/
	private  TCommonKeysService service;
	
	/*操作实体*/
	private TCommonKeys bean;
	
	/*查询列表数据*/
	private List datas ;
	
	/**
	 * 查询单个实体
	 * @return select
	 */
	public String select(){
		TCommonKeys data = service.select(bean);
		if(data != null){
			bean = data;
		}else{
			
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
	 * 重新加载字典的系统缓存
	 * @return
	 */
	public String reload(){
		/*1 表示加载 不成功，否则反之*/
		String result = "0";
		try {
			if(bean != null){
				CacheManager.getInstance().reload(bean.getCode());
			}else{
				/*加载系统中所有缓存值*/
				CacheManager.getInstance().reload();
			}
			result = "1";
		} catch (PlatformException e) {
			log.error(e);
		}
			
			try {
				response.getWriter().print(result);
			} catch (IOException e) {
				e.printStackTrace();
			}
		return null;
	}
	
	/**
	 * 数据保存，首先从数据库检测一次是否存在 ，存在调用更新，否则调用插入
	 * @return select
	 */
	public String save(){
		boolean isNew = false;
		TCommonKeys data = service.select(bean);
			if(data != null){
				bean.setXgsj(new Date());
				service.update(bean);
			}else{
				isNew = true;
				bean.setCjr(getLoginUser().getUserId());
				bean.setCjsj(new Date());
				service.insert(bean);
			}
			
			CacheManager.getInstance().reload(bean.getCode());
		return this.select();
	}
	
	/**
	 * 删除数据
	 * @return select
	 */
	public String delete(){
		service.delete(bean);
		CacheManager.getInstance().reload(bean.getCode());
		return null;
	}
	
	
	@Autowired
	public void setService(TCommonKeysService service) {
		this.service = service;
	}

	public TCommonKeys getBean() {
		return bean;
	}

	public void setBean(TCommonKeys bean) {
		this.bean = bean;
	}

	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}

}
