/**
*/
package	com.upath.plat.common.modules.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.upath.plat.common.action.BaseActionSupport;
import com.upath.plat.common.modules.model.TCommonOnline;
import com.upath.plat.common.modules.service.TCommonOnlineService;



/**
* strut2 config :
* spring config :
* @ClassName: TCommonOnlineAction.java
* @Description: t_common_online
* @author upaths@gmail.com  
* @date2012-11-28 22:24:13
* @version V1.0   
*/

@Scope("prototype")
@Component("tCommonOnlineAction")
@SuppressWarnings({ "rawtypes", "serial","unused" })
public class TCommonOnlineAction extends BaseActionSupport {

	private static final Logger log = Logger.getLogger(TCommonOnlineAction.class);
	
	/*服务类*/
	private  TCommonOnlineService service;
	
	/*操作实体*/
	private TCommonOnline bean;
	
	/*查询列表数据*/
	private List datas ;
	
	/**
	 * 查询单个实体
	 * @return select
	 */
	public String select(){
		TCommonOnline data = service.select(bean);
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
		TCommonOnline data = service.select(bean);
			if(data != null){
				service.update(bean);
			}else{
				isNew = true;
				service.insert(bean);
			}
		return this.select();
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
	public void setService(TCommonOnlineService service) {
		this.service = service;
	}

	public TCommonOnline getBean() {
		return bean;
	}

	public void setBean(TCommonOnline bean) {
		this.bean = bean;
	}

	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}
}
