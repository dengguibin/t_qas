package	com.deceen.indicator.indicatorcontent.action;

import java.util.List;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.deceen.indicator.indicatorcatalog.model.QasTIndicatorcatalog;
import com.deceen.indicator.indicatorcatalog.service.QasTIndicatorcatalogService;
import com.deceen.indicator.indicatorcatalogextend.model.QasTIndicatorcatalogextend;
import com.deceen.indicator.indicatorcontent.model.QasTIndicatorcontent;
import com.deceen.indicator.indicatorcontent.service.QasTIndicatorcontentService;
import com.deceen.utils.ResultMap;
import com.upath.plat.auth.facade.IUser;
import com.upath.plat.common.action.BaseActionSupport;
import com.upath.plat.common.util.StringUtil;

/**
* @ClassName: QasTIndicatorcontentAction.java
* @Description: qas_t_indicatorcontent
* @author upaths@gmail.com  
* @date2017-11-9 15:56:08
* @version V1.0   
*/

@Scope("prototype")
@Component("qasTIndicatorcontentAction")	
@SuppressWarnings({ "rawtypes", "serial" })
public class QasTIndicatorcontentAction  extends BaseActionSupport{

	
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(QasTIndicatorcontentAction.class);

	private  QasTIndicatorcontentService service;
	
	@Autowired
	private  QasTIndicatorcatalogService qasTIndicatorcatalogService;
	
	private QasTIndicatorcontent bean;
	
	private QasTIndicatorcatalogextend extend;
	
	private QasTIndicatorcatalog catalog;

	private List datas;
	
	//查询单条记录信息
	public String queryInfo() throws Exception {
		ResultMap result = new ResultMap();
		if(bean != null && bean.getId() != null && "".equals(bean.getId()) == false) {
			try {
				QasTIndicatorcontent content = service.select(bean.getId());
				QasTIndicatorcatalogextend extend = service.selectextend(bean.getId());
				if(content!=null) {
					QasTIndicatorcatalog catalog = qasTIndicatorcatalogService.select(content.getIndicatorcatalogid());
					result.put("catalog",catalog);
				}
				result.put("bean", content);
				result.put("exten", extend);
				
			} catch (Exception e) {
				e.printStackTrace();
				result.setMsg("数据查询异常");
				result.setSuccess(false);
			}
		}
		response.setContentType("text/json; charset=UTF-8");
		JSONObject json = JSONObject.fromObject(result);
		response.getWriter().print(json.toString());
		return null;
	}
	
	//查询 列表信息
	public String queryList() throws Exception {
		if(bean == null){ 
			bean = new QasTIndicatorcontent();
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
	public String addOrEditContent() throws Exception {
		
		ResultMap result = new ResultMap();
		QasTIndicatorcontent dsBean = new QasTIndicatorcontent();
		if(bean != null  ){
			//单双引号转换
			String name_ = bean.getName_();
			if (StringUtil.isNotBlank(name_)) {
				name_.replace("&ldquo;", "“").replace("&rdquo;", "”").replace("&#39;", "'");
				bean.setName_(name_);
			}
			String sqlstring = bean.getSqlstring();
			if (StringUtil.isNotBlank(sqlstring)) {
				sqlstring = sqlstring.replace("&ldquo;", "“").replace("&rdquo;", "”").replace("&#39;", "'");
				sqlstring = sqlstring.replace("&lt;", "<").replace("&le;", "<=").replace("&ge;", ">=").replace("&gt;", ">");
				bean.setSqlstring(sqlstring);
			}
			String stan = bean.getStandard();
			if(StringUtil.isNotBlank(stan)) {
				stan = stan.replace("&lt;", "<").replace("&le;", "<=").replace("&ge;", ">=").replace("&gt;", ">");
				bean.setStandard(stan);
			}
			String remark = bean.getRemark();
			if (StringUtil.isNotBlank(remark)) {
				remark.replace("&ldquo;", "“").replace("&rdquo;", "”").replace("&#39;", "'");
				bean.setRemark(remark);
			}
			
			IUser user = getLoginUser();
			
			//主键记录已经存在，需要进行更新操作
			if(bean.getId() != null && "".equals(bean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				dsBean = service.select(bean.getId());
				QasTIndicatorcatalog dsIndicatorcatalog = qasTIndicatorcatalogService.select(dsBean.getIndicatorcatalogid());
				if(dsBean != null&&dsIndicatorcatalog != null){
					// 如果数据库中有此记录信息，进行更新操作
					if(user!=null){
						bean.setUpdatedby(user.getUserId());
					}
					bean.setIndicatorcatalogid(dsBean.getIndicatorcatalogid());
					bean.setId(dsBean.getId());
					service.updateWithDyna(bean,extend);
				}else{
					result.setSuccess(false);
					result.setMsg("数据不存在");
				}
			}else{
				if(user!=null){
					bean.setCreatedby(user.getUserId());
				}
				service.insert(bean,extend);
			}
		}
		if(catalog!=null) {//指标目录表
			catalog.setId(dsBean.getIndicatorcatalogid());
			qasTIndicatorcatalogService.updateWithIsMmonitor(catalog);
		}
		result.put("id", bean.getIndicatorcatalogid());
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
			String idArrs[] = bean.getId().split("[,]");
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
						service.delete(idArrs);
				}catch(Exception e){
					e.printStackTrace();
					result.setSuccess(false);
					result.setMsg("系统异常");
					result.put("error", e.getMessage());
				}
			}else{
				result.setSuccess(false);
				result.setMsg("已经存在相关联的数据，请先删除");
			}
		}else{
			result.setSuccess(false);
			result.setMsg("错误参数");
		}
		
		response.setContentType("text/json; charset=UTF-8");
		response.getWriter().print(result.getJsonStr());
		return null;
	}
	
	
	public QasTIndicatorcontentService getService() {
		return service;
	}

	@Autowired
	public void setService(QasTIndicatorcontentService service) {
		this.service = service;
	}
	
	

	public QasTIndicatorcatalogextend getExtend() {
		return extend;
	}

	public void setExtend(QasTIndicatorcatalogextend extend) {
		this.extend = extend;
	}

	public QasTIndicatorcontent getBean() {
		return bean;
	}

	public void setBean(QasTIndicatorcontent bean) {
		this.bean = bean;
	}


	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}
	
	public QasTIndicatorcatalog getCatalog() {
		return catalog;
	}

	public void setCatalog(QasTIndicatorcatalog catalog) {
		this.catalog = catalog;
	}
}
