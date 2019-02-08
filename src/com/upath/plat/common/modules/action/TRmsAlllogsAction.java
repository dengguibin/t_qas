/**
*/
package	com.upath.plat.common.modules.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.upath.plat.common.action.BaseActionSupport;
import com.upath.plat.common.modules.model.TRmsAlllogs;
import com.upath.plat.common.modules.service.TRmsAlllogsService;



/**
* strut2 config :
* spring config :
* @ClassName: TRmsAlllogsAction.java
* @Description: T_RMS_ALLLOGS
* @author upaths@gmail.com  
* @date2015-2-11 16:20:31
* @version V1.0   
* 
* 
* 
* 
* 
* 此功能暂时未使用 可以删除 ，如果后面的人员未使用请删除 此功能
*/

@Scope("prototype")
@Component("tRmsAlllogsAction")
@SuppressWarnings({ "rawtypes", "serial", "unused" })
public class TRmsAlllogsAction extends BaseActionSupport {

	private static final Logger log = Logger.getLogger(TRmsAlllogsAction.class);
	
	/*服务类*/
	private  TRmsAlllogsService service;
	
	/*操作实体*/
	private TRmsAlllogs bean;
	
	/*查询列表数据*/
	private List datas ;
	
	/**
	 * 查询单个实体
	 * @return select
	 */
	public String select(){
		TRmsAlllogs data = service.select(bean);
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
			bean = new TRmsAlllogs();
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
		TRmsAlllogs data = service.select(bean);
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
	public void setService(TRmsAlllogsService service) {
		this.service = service;
	}

	public TRmsAlllogs getBean() {
		return bean;
	}

	public void setBean(TRmsAlllogs bean) {
		this.bean = bean;
	}

	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}
}
