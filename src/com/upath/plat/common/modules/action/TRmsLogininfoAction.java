/**
*/
package	com.upath.plat.common.modules.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.upath.plat.common.action.BaseActionSupport;
import com.upath.plat.common.modules.model.TRmsLogininfo;
import com.upath.plat.common.modules.service.TRmsLogininfoService;



/**
* strut2 config :
* spring config :
* @ClassName: TRmsLogininfoAction.java
* @Description: t_rms_logininfo
* @author upaths@gmail.com  
* @date2015-3-3 13:36:50
* @version V1.0   
*/

@Scope("prototype")
@Component("tRmsLogininfoAction")
@SuppressWarnings({ "rawtypes", "serial", "unused" })
public class TRmsLogininfoAction extends BaseActionSupport {

	private static final Logger log = Logger.getLogger(TRmsLogininfoAction.class);
	
	/*服务类*/
	private  TRmsLogininfoService service;
	
	/*操作实体*/
	private TRmsLogininfo bean;
	
	/*查询列表数据*/
	private List datas ;
	
	/**
	 * 查询单个实体
	 * @return select
	 */
	public String select(){
		TRmsLogininfo data = service.select(bean);
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
		
		return FORWARD_LIST;
	}
	
	/**
	 * 数据保存，首先从数据库检测一次是否存在 ，存在调用更新，否则调用插入
	 * @return select
	 */
	public String save(){
		boolean isNew = false;
		TRmsLogininfo data = service.select(bean);
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
	public void setService(TRmsLogininfoService service) {
		this.service = service;
	}

	public TRmsLogininfo getBean() {
		return bean;
	}

	public void setBean(TRmsLogininfo bean) {
		this.bean = bean;
	}

	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}
}
