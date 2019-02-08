/**
*/
package	com.upath.plat.common.modules.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.upath.plat.common.action.BaseActionSupport;
import com.upath.plat.common.cache.CacheManager;
import com.upath.plat.common.modules.mapper.TCommonSubkeysMapper;
import com.upath.plat.common.modules.model.TCommonSubkeys;
import com.upath.plat.common.modules.service.TCommonSubkeysService;



/**
* strut2 config :
* spring config :
* @ClassName: TCommonSubkeysAction.java
* @Description: t_common_subkeys
* @author upaths@gmail.com  
* @date2012-10-28 20:29:26
* @version V1.0   
*/

@Scope("prototype")
@Component("tCommonSubkeysAction")
@SuppressWarnings({ "rawtypes", "serial", "unused" })
public class TCommonSubkeysAction extends BaseActionSupport {

	private static final Logger log = Logger.getLogger(TCommonSubkeysAction.class);
	
	/*服务类*/
	private  TCommonSubkeysService service;
	
	/*操作实体*/
	private TCommonSubkeys bean;
	
	/*查询列表数据*/
	private List datas ;
	
	/**
	 * 查询单个实体
	 * @return select
	 */
	public String select(){
		TCommonSubkeys data = service.select(bean);
		if(data != null){
			bean = data;
		}
		
		if(bean != null){
			bean.setValid(1);
		}
		return "select";
	}
	
	/**
	 * 查询数据列表
	 * @return select
	 */
	public String list(){
		//request.setAttribute("mapper",service.getMapperClass());
		datas = service.queryPageList(TCommonSubkeysMapper.class.getName()+".list", bean);
		return "list";
	}
	
	/**
	 * 数据保存，首先从数据库检测一次是否存在 ，存在调用更新，否则调用插入
	 * @return select
	 */
	public String save(){
		boolean isNew = false;
		TCommonSubkeys data = service.select(bean);
			if(data != null){
				service.update(bean);
			}else{
				isNew = true;
				service.insert(bean);
			}
			//返回到列表重新再进行增加
		if(bean != null){
			//清空字段，在查询时不需使用此字段来查询
			bean.setSubcode(null);
		}	
		CacheManager.getInstance().reload(bean.getCode());
		return list();
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
	public void setService(TCommonSubkeysService service) {
		this.service = service;
	}

	public TCommonSubkeys getBean() {
		return bean;
	}

	public void setBean(TCommonSubkeys bean) {
		this.bean = bean;
	}

	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}
}
