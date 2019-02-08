/**
 * 
 * 
 * 
*/
package	com.upath.plat.auth.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.upath.plat.auth.model.TRmsAppinfo;
import com.upath.plat.auth.service.TRmsAppinfoService;
import com.upath.plat.common.action.BaseActionSupport;
/**
* strut2 config :
* spring config :
* @ClassName: TRmsAppinfoAction.java
* @Description: t_rms_appinfo
* @author upaths@gmail.com  
* @date2012-9-21 23:23:14
* @version V1.0   
*/

@Scope("prototype")
@Component("tRmsAppinfoAction")
@SuppressWarnings({ "rawtypes", "serial", "unused" })
public class TRmsAppinfoAction extends BaseActionSupport {

	private static final Logger log = Logger.getLogger(TRmsAppinfoAction.class);
	
	/*服务类*/
	private  TRmsAppinfoService service;
	
	/*操作实体*/
	private TRmsAppinfo bean;
	
	/*查询列表数据*/
	private List datas ;
	
	
	/**
	 * 查询单个实体
	 * @return select
	 */
	public String select(){
		TRmsAppinfo data = service.select(bean);
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
		if(bean == null){
			bean = new TRmsAppinfo();
		}
		datas = service.list(bean);
		return FORWARD_LIST;
	}
	
	/**
	 * 数据保存，首先从数据库检测一次是否存在 ，存在调用更新，否则调用插入
	 * @return select
	 */
	public String save(){
		boolean isNew = false;
		TRmsAppinfo data = service.select(bean);
			if(data != null){
				service.update(bean);
			}else{
				isNew = true;
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
	public void setService(TRmsAppinfoService service) {
		this.service = service;
	}

	public TRmsAppinfo getBean() {
		return bean;
	}

	public void setBean(TRmsAppinfo bean) {
		this.bean = bean;
	}

	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}
	
}
