/**
*/
package	com.upath.plat.common.modules.action;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.upath.plat.common.action.BaseActionSupport;
import com.upath.plat.common.modules.model.TCommonTemplate;
import com.upath.plat.common.modules.service.TCommonTemplateService;



/**
* strut2 config :
* spring config :
* @ClassName: TCommonTemplateAction.java
* @Description: T_COMMON_TEMPLATE
* @author upaths@gmail.com  
* @date2013-5-15 10:21:41
* @version V1.0   
*/

@Scope("prototype")
@Component("tCommonTemplateAction")
@SuppressWarnings({ "rawtypes", "serial", "unused" })
public class TCommonTemplateAction extends BaseActionSupport {

	private static final Logger log = Logger.getLogger(TCommonTemplateAction.class);
	
	/*服务类*/
	private  TCommonTemplateService service;
	
	/*操作实体*/
	private TCommonTemplate bean;
	
	/*查询列表数据*/
	private List datas ;
	
	private String showType ;
	/**
	 * 查询单个实体
	 * @return select
	 */
	public String select(){
		TCommonTemplate data = service.select(bean);
		if(data != null){
			bean = data;
		}else{
			bean = new TCommonTemplate();
			bean.setMblx(2);
			bean.setSfyx(1);
		}
		
		return FORWARD_SELECT;
	}
	
	/**
	 * 查询数据列表
	 * @return select
	 */
	public String list(){
		if("select".equals(showType) == true){
			return "query"; 
		}
		return FORWARD_LIST;
	}
	
	/**
	 * 数据保存，首先从数据库检测一次是否存在 ，存在调用更新，否则调用插入
	 * @return select
	 */
	public String save(){
		boolean isNew = false;
		TCommonTemplate data = service.select(bean);
			if(data != null){
				bean.setXgr(getLoginUser().getUserId());
				bean.setXgsj(new Date());
				service.update(bean);
			}else{
				isNew = true;
				bean.setCjr(getLoginUser().getUserId());
				bean.setCjsj(new Date());
				service.insert(bean);
			}
		return this.list();
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
	public void setService(TCommonTemplateService service) {
		this.service = service;
	}

	public TCommonTemplate getBean() {
		return bean;
	}

	public void setBean(TCommonTemplate bean) {
		this.bean = bean;
	}

	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}

	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}
}
