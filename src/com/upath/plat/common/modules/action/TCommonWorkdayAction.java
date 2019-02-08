/**
*/
package	com.upath.plat.common.modules.action;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.upath.plat.common.action.BaseActionSupport;
import com.upath.plat.common.cache.CacheManager;
import com.upath.plat.common.modules.model.TCommonWorkday;
import com.upath.plat.common.modules.service.TCommonWorkdayService;
import com.upath.plat.common.util.DateUtil;
import com.upath.plat.common.util.IDGenerator;



/**
* strut2 config :
* spring config :
* @ClassName: TCommonWorkdayAction.java
* @Description: T_COMMON_WORKDAY
* @author upaths@gmail.com  
* @date2013-3-22 14:36:14
* @version V1.0   
*/

@Scope("prototype")
@Component("tCommonWorkdayAction")
@SuppressWarnings({ "rawtypes", "serial", "unused" })
public class TCommonWorkdayAction extends BaseActionSupport {

	private static final Logger log = Logger.getLogger(TCommonWorkdayAction.class);
	
	/*服务类*/
	private  TCommonWorkdayService service;
	
	/*操作实体*/
	private TCommonWorkday bean;
	
	/*查询列表数据*/
	private List datas ;
	
	/**
	 * 查询单个实体
	 * @return select
	 */
	public String select(){
			if(bean == null){
				bean = new TCommonWorkday();
				bean.setYear(Calendar.getInstance().get(Calendar.YEAR));
			}
			bean.setTid(null);	
		request.setAttribute("year", bean.getYear());
		TCommonWorkday data = service.select(bean);
		if(data != null){
			bean = data;
		}else{
			bean.setLists(null);
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
		TCommonWorkday data = service.select(bean);
			if(data != null){
				bean.setXgsj(new Date());
				service.update(bean);
			}else{
				isNew = true;
				bean.setCjr(getLoginUser().getUserId());
				bean.setCjsj(new Date());
				bean.setTid(IDGenerator.getDateId());
				service.insert(bean);
			}
			CacheManager.getInstance().reload("WORKDAYS");
			
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
	public void setService(TCommonWorkdayService service) {
		this.service = service;
	}

	public TCommonWorkday getBean() {
		return bean;
	}

	public void setBean(TCommonWorkday bean) {
		this.bean = bean;
	}

	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}
}
