		
		
/**
*/
package	com.upath.plat.auth.action;

import java.util.*;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.upath.plat.common.action.BaseActionSupport;
import com.upath.plat.auth.model.TRmsUserPortlets;
import com.upath.plat.auth.service.TRmsUserPortletsService;
import com.upath.plat.common.util.IDGenerator;

import net.sf.json.JSONObject;


/**
* @ClassName: TRmsUserPortletsAction.java
* @Description: t_rms_user_portlets
* @author upaths@gmail.com  
* @date2015-6-9 13:59:15
* @version V1.0   
*/
@Scope("prototype")
@Component("tRmsUserPortletsAction")
@SuppressWarnings({ "rawtypes", "serial", "unchecked", "unused" })
public class TRmsUserPortletsAction  extends BaseActionSupport{

	private static final Logger log = Logger.getLogger(TRmsUserPortletsAction.class);

	private  TRmsUserPortletsService service;
	
	private TRmsUserPortlets bean;
	
	private List datas;
	
	
	
	/**用户个性化配置模板
	 * @return
	 */
	public String findUserPortlets(){
		
		return "";
	}
	
	//查询单条记录信息
	public String queryInfo() throws Exception {
		if(bean != null && bean.getCid() != null && "".equals(bean.getCid()) == false){
				bean = service.select(bean.getCid());
			}
		return FORWARD_SELECT;
	}
	
	//查询 列表信息
	public String queryList() throws Exception {
		if(bean == null){ 
			bean = new TRmsUserPortlets();
		}
		datas = service.list(bean);
		return FORWARD_LIST;
	}
	
	//进行更新和增加 的进入页面
	public String toEdit() throws Exception {
		//查询一次数据信息
		queryInfo();
		return FORWARD_TOEDIT;
	}
	
	//新增和更新操作
	public String save() throws Exception {
		if(bean != null  ){
			//主键记录已经存在，需要进行更新操作
			if(bean.getCid() != null && "".equals(bean.getCid()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				TRmsUserPortlets dsBean = service.select(bean.getCid());
				if(dsBean != null){
				// 如果数据库中有此记录信息，进行更新操作
					int rows = service.update(bean);
				}else{
					//是否需要输出数据不存在的异常
				}
			}else{
			    bean.setCid(IDGenerator.getUUID()); 
				int rows = service.insert(bean);
			}
			
		}
		return FORWARD_SAVE;	
	}
	
	/**
	 * 删除方法，如果ID 上是以","隔开的字符，会认为是一个数组,批量删除数据
	 */
	public String remove() throws Exception {
		Map result = new HashMap();
		result.put("status", "0");
		if(bean != null && bean.getCid() != null){
			String idArrs[] = bean.getCid().split("[,]");
			boolean checkResult = true;
//程序是否需要对此数据进行数据检验,如果是请开启此部分的数据检验			
//			for(int i = 0 ; i < idArrs.length ; i++){
//					//是否有对应的数据存在
//					int rows = Integer.valueOf(((Map)service.get2Object("查询数据的行数", bean)).get("CNUM").toString());
//					if(rows > 0){
//						checkResult = false;
//						break;
//					}
//			}	
			if(checkResult == true){
				try{
					int rows = service.delete(idArrs);
					result.put("status", "1");
				}catch(Exception e){
					e.printStackTrace();
					result.put("message", e.getMessage());
				}
			}else{
				result.put("status", "2");
				result.put("message", "已经存在相关联的数据，请先删除");
			}
		}else{
			result.put("message","错误参数");
		}
		
		response.setContentType("text/json; charset=UTF-8");
		JSONObject json = JSONObject.fromObject(result);
		response.getWriter().print(json.toString());
		return null;
	}
	
	
	public TRmsUserPortletsService getService() {
		return service;
	}

	@Autowired
	public void setService(TRmsUserPortletsService service) {
		this.service = service;
	}

	public TRmsUserPortlets getBean() {
		return bean;
	}

	public void setBean(TRmsUserPortlets bean) {
		this.bean = bean;
	}


	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}
}
