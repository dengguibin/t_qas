package	com.deceen.indicator.indicatorcatalog.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestScope;
import com.deceen.indicator.indicatorcatalog.model.QasTIndicatorcatalog;
import com.deceen.indicator.indicatorcatalog.service.QasTIndicatorcatalogService;
import com.deceen.indicator.indicatorcatalogextend.model.QasTIndicatorcatalogextend;
import com.deceen.indicator.indicatorcontent.model.QasTIndicatorcontent;
import com.deceen.indicator.indicatorcontent.service.QasTIndicatorcontentService;
import com.deceen.utils.ResultMap;
import com.upath.plat.auth.facade.IUser;
import com.upath.plat.common.action.BaseActionSupport;


/**
* @ClassName: QasTIndicatorcatalogAction.java
* @Description: qas_t_indicatorcatalog
* @author upaths@gmail.com  
* @date2017-11-8 14:18:50
* @version V1.0   
*/

@Scope("prototype")
@Component("qasTIndicatorcatalogAction")
@SuppressWarnings({ "rawtypes", "serial", "unused" })
public class QasTIndicatorcatalogAction  extends BaseActionSupport{


	private static final Logger log = Logger.getLogger(QasTIndicatorcatalogAction.class);

	private  QasTIndicatorcatalogService service;
	@Autowired
	private  QasTIndicatorcontentService indicatorcontentservice;
	
	private QasTIndicatorcatalog bean;
	
	private QasTIndicatorcatalogextend extend;

	private List datas;
	
	//查询单条记录信息
	public String queryInfo() throws Exception {
		ResultMap result = new ResultMap();
		if(bean != null && bean.getId() != null && "".equals(bean.getId()) == false) {
			try {

				QasTIndicatorcontent content = indicatorcontentservice.select(bean.getId());
				QasTIndicatorcatalogextend extend = service.selectextend(bean.getId());
				QasTIndicatorcatalog catalog=service.findById(bean.getId());
				result.put("bean", content);
				result.put("exten", extend);
				result.put("catalog", catalog);
			} catch (Exception e) {
				e.printStackTrace();
				result.setSuccess(false);
				result.setMsg("数据查询异常");
			}
		}
		response.setContentType("text/json; charset=UTF-8");
		response.getWriter().print(result.getJsonStr());
		return null;
	}
	
	//查询 指标库
	public String indicatorcatalogList() throws Exception {
		return FORWARD_LIST;
	}
	
	public String getTree() throws Exception {
		ResultMap result = new ResultMap();
		String key = request.getParameter("key");//指标名称(模糊查询)
		List<QasTIndicatorcatalog> list = new ArrayList<QasTIndicatorcatalog>();
		if(StringUtils.isEmpty(key)){    //指标名称为空(查询所有)
			list = service.getTree();
		}else{                          //指标名称不为空(根据指标名称查询)
			try {
				list = service.selectTree(key);
			} catch (Exception e) {
				e.printStackTrace();
				result.setSuccess(false);
				result.setMsg("系统异常！");
			}
		}
		result.setObj(list);
		List<Map<String,Object>> count = service.inditorCount(key);
		result.put("count",count);
		response.setContentType("text/json; charset=UTF-8");
		response.getWriter().print(result.getJsonStr());
		return null;
	}
	
	//进行更新和增加 的进入页面
	public String toEdit() throws Exception {
		//查询一次数据信息
		queryInfo();
		return FORWARD_TOEDIT;
	}
	
	//新增和更新操作
	public String addOrEditCatalog() throws Exception {
		ResultMap result = new ResultMap();
		if(bean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(bean.getId() != null && "".equals(bean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasTIndicatorcatalog dsBean = service.select(bean.getId());
				if(dsBean != null){
					// 如果数据库中有此记录信息，进行更新操作
					if(user!=null){
						bean.setUpdatedby(user.getUserId());
					}
					bean.setSort(null);//修改时确保排序不会乱
					service.updateWithDyna(bean,extend);		
				}else{
					//是否需要输出数据不存在的异常
				}
			}else{
				boolean b = true;
				if(null !=bean.getSort()){
					List<QasTIndicatorcatalog> list  = service.queryParams(bean.getSort());
					if(list.size()>0){
						b = false;
					}
				}
				if(b){
					if(user!=null){
						bean.setCreatedby(user.getUserId());
					}
					service.insert(bean,extend);
				}else{
					result.setSuccess(false);
					result.setMsg("指标类型已存在！");
				}
			}
			
		}
		result.put("id", bean.getParentid());
		response.setContentType("text/json; charset=UTF-8");
		response.getWriter().print(result.getJsonStr());
		return null;	
	}
	
	/**
	 * 删除方法，如果ID 上是以","隔开的字符，会认为是一个数组,批量删除数据
	 */
	public String remove() throws Exception {
		ResultMap result = new ResultMap();
		if(bean != null && bean.getId() != null){
//			String idArrs[] = bean.getId().split("[,]");
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
			List<QasTIndicatorcatalog> list = service.selectChilds(bean.getId());
			if(list.size()>0){
				checkResult = false;
			}
			if(checkResult){
				try{
					service.delete((Object)bean.getId());
				}catch(Exception e){
					e.printStackTrace();
					result.setSuccess(false);
					result.setMsg("系统异常");
					result.put("error", e.getMessage());
				}
			}else{
				result.setSuccess(false);
				result.setMsg("存在相关联的数据，请先删除");
			}
		}else{
			result.setSuccess(false);
			result.setMsg("错误参数");
		}
		
		response.setContentType("text/json; charset=UTF-8");
		response.getWriter().print(result.getJsonStr());
		return null;
	}
	
	
	public QasTIndicatorcatalogService getService() {
		return service;
	}

	@Autowired
	public void setService(QasTIndicatorcatalogService service) {
		this.service = service;
	}

	public QasTIndicatorcatalog getBean() {
		return bean;
	}

	public void setBean(QasTIndicatorcatalog bean) {
		this.bean = bean;
	}


	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}

	public QasTIndicatorcatalogextend getExtend() {
		return extend;
	}

	public void setExtend(QasTIndicatorcatalogextend extend) {
		this.extend = extend;
	}
	
	
}
