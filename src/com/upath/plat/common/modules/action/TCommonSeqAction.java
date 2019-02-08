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
import com.upath.plat.common.exception.PlatformException;
import com.upath.plat.common.modules.mapper.TCommonSeqMapper;
import com.upath.plat.common.modules.model.TCommonSeq;
import com.upath.plat.common.modules.service.TCommonSeqService;



/**
* strut2 config :
* spring config :
* @ClassName: TCommonSeqAction.java
* @Description: t_common_seq
* @author upaths@gmail.com  
* @date2012-10-31 21:16:23
* @version V1.0   
*/

@Scope("prototype")
@Component("tCommonSeqAction")
@SuppressWarnings({ "rawtypes", "serial", "unused" })
public class TCommonSeqAction extends BaseActionSupport {

	private static final Logger log = Logger.getLogger(TCommonSeqAction.class);
	
	/*服务类*/
	private  TCommonSeqService service;
	
	/*操作实体*/
	private TCommonSeq bean;
	
	/*查询列表数据*/
	private List datas ;
	
	/**
	 * 查询单个实体
	 * @return select
	 */
	public String select(){
		TCommonSeq data = service.select(bean);
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
	 * @throws PlatformException 
	 */
	public String save() throws PlatformException{
		boolean isNew = false;
		TCommonSeq data = service.select(bean);
			if(data != null){
				bean.setXgr(getLoginUser().getUserId());
				bean.setXgsj(new Date());
				service.update(bean);
			}else{
				isNew = true;
				service.insert(bean);
			}
		return null;
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
	public void setService(TCommonSeqService service) {
		this.service = service;
	}

	public TCommonSeq getBean() {
		return bean;
	}

	public void setBean(TCommonSeq bean) {
		this.bean = bean;
	}

	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}
}
