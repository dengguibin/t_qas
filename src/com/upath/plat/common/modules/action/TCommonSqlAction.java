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
import org.springframework.web.util.HtmlUtils;

import com.upath.plat.common.action.BaseActionSupport;
import com.upath.plat.common.cache.SqlTemplateManager;
import com.upath.plat.common.exception.PlatformException;
import com.upath.plat.common.modules.model.TCommonSql;
import com.upath.plat.common.modules.service.TCommonSqlService;



/**
* strut2 config :
* spring config :
* @ClassName: TCommonSqlAction.java
* @Description: t_common_sql
* @author upaths@gmail.com  
* @date2012-11-28 22:24:13
* @version V1.0   
*/

@Scope("prototype")
@Component("tCommonSqlAction")
@SuppressWarnings({ "rawtypes", "serial", "unused" })
public class TCommonSqlAction extends BaseActionSupport {

	private static final Logger log = Logger.getLogger(TCommonSqlAction.class);
	
	/*服务类*/
	private  TCommonSqlService service;
	
	/*操作实体*/
	private TCommonSql bean;
	
	/*查询列表数据*/
	private List datas ;
	
	/**
	 * 查询单个实体
	 * @return select
	 */
	public String select(){
		TCommonSql data = service.select(bean);
		if(data != null){
			bean = data;
			if(bean.getPtid() != null){
				TCommonSql parent = new TCommonSql();
					parent.setTid(bean.getPtid());
					parent = service.select(parent);
					request.setAttribute("parent", parent);
			}
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
	
	
	public String listTree(){
		return "listTree";
	}
	
	public String manage(){
		return "manage";
	}
	/**
	 * 数据保存，首先从数据库检测一次是否存在 ，存在调用更新，否则调用插入
	 * @return select
	 */
	public String save(){
		boolean isNew = false;
		TCommonSql data = service.select(bean);
		//需要对脚本进行特殊化处理。
			if(bean != null){
				if(bean.getScripts() != null && "".equals(bean.getScripts()) == false){
					bean.setScripts(HtmlUtils.htmlUnescape(bean.getScripts()));
				}
			}
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
	
	public String reload() throws IOException{
		int result = 0;
		if(bean != null && bean.getTid() != null){
			try{
				SqlTemplateManager.getInstance().reload(bean.getTid()+"");
				result = 1;
			}catch(Exception e){
				e.printStackTrace();
				throw new PlatformException("加载SQL 模板功能失败",e);
			}
			
		}	
		response.getWriter().print(result);
		return null;
	}
	
	
	@Autowired
	public void setService(TCommonSqlService service) {
		this.service = service;
	}

	public TCommonSql getBean() {
		return bean;
	}

	public void setBean(TCommonSql bean) {
		this.bean = bean;
	}

	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}
}
