/**
*/
package	com.upath.plat.common.modules.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.upath.plat.common.action.BaseActionSupport;
import com.upath.plat.common.modules.model.TCommonSeqvalue;
import com.upath.plat.common.modules.service.TCommonSeqvalueService;



/**
* strut2 config :
* spring config :
* @ClassName: TCommonSeqvalueAction.java
* @Description: t_common_seqvalue
* @author upaths@gmail.com  
* @date2012-10-31 21:16:23
* @version V1.0   
*/

@Scope("prototype")
@Component("tCommonSeqvalueAction")
@SuppressWarnings({ "rawtypes", "serial", "unused" })
public class TCommonSeqvalueAction extends BaseActionSupport {

	private static final Logger log = Logger.getLogger(TCommonSeqvalueAction.class);
	
	/*服务类*/
	private  TCommonSeqvalueService service;
	
	/*操作实体*/
	private TCommonSeqvalue bean;
	
	/*查询列表数据*/
	private List datas ;
	
	/**
	 * 查询单个实体
	 * @return select
	 */
	public String select(){
		TCommonSeqvalue data = service.select(bean);
		if(data != null){
			bean = data;
		}else{
			
		}
		return "select";
	}
	
	/**
	 * 查询数据列表
	 * @return select
	 */
	public String list(){
		request.setAttribute("mapper",service.getMapperClass());
		return "list";
	}
	
	/**
	 * 数据保存，首先从数据库检测一次是否存在 ，存在调用更新，否则调用插入
	 * @return select
	 */
	public String save(){
		boolean isNew = false;
		TCommonSeqvalue data = service.select(bean);
			if(data != null){
				service.update(bean);
			}else{
				isNew = true;
				service.insert(bean);
			}
		return select();
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
	public void setService(TCommonSeqvalueService service) {
		this.service = service;
	}

	public TCommonSeqvalue getBean() {
		return bean;
	}

	public void setBean(TCommonSeqvalue bean) {
		this.bean = bean;
	}

	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}
}
