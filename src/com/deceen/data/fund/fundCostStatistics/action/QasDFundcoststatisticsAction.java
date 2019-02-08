package	com.deceen.data.fund.fundCostStatistics.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.deceen.data.fund.fundCostStatistics.model.QasDFundcoststatistics;
import com.deceen.data.fund.fundCostStatistics.service.QasDFundcoststatisticsService;
import com.upath.plat.auth.facade.IUser;
import com.upath.plat.common.action.BaseActionSupport;


/**
* @ClassName: QasDFundcoststatisticsAction.java
* @Description: qas_d_fundcoststatistics
* @author upaths@gmail.com  
* @date2017-11-23 12:16:28
* @version V1.0   
*/
@Scope("prototype")
@Component("qasDFundcoststatisticsAction")	
@SuppressWarnings({ "rawtypes", "unchecked", "serial" ,"unused" })
public class QasDFundcoststatisticsAction  extends BaseActionSupport{

	private static final Logger log = Logger.getLogger(QasDFundcoststatisticsAction.class);

	private  QasDFundcoststatisticsService service;
	
	private QasDFundcoststatistics bean;
	
	private List datas;
	
	//查询单条记录信息
	public String queryInfo() throws Exception {
		if(bean != null && bean.getId() != null && "".equals(bean.getId()) == false){
				bean = service.select(bean.getId());
			}
		return FORWARD_SELECT;
	}
	
	//查询 列表信息
	public String queryList() throws Exception {
		if(bean == null){ 
			datas = service.list(new HashMap());
		}else{
			datas = service.list(bean);
		}
		return FORWARD_LIST;
	}
	
	/*//查询 列表信息
	public String queryList1() throws Exception {
		if(bean == null){ 
			datas = service.list1(new HashMap());
		}else{
			Map map=new HashMap();
			//获取下拉列表的范围(eg:5000-8000)
			if(bean.getSchoolexpenditureScope()!=null && bean.getSchoolexpenditureScope()!="" && "--请选择--".equals(bean.getSchoolexpenditureScope())==false){
				String schoolexpenditureScope=bean.getSchoolexpenditureScope();
				Integer minScope=Integer.parseInt(schoolexpenditureScope.split("-")[0]);
				Integer maxScope=Integer.parseInt(schoolexpenditureScope.split("-")[1]);
				map.put("minScope", minScope);
				map.put("maxScope", maxScope);
				log.info("minScope是："+minScope);
				log.info("maxScope是："+maxScope);
			}
			if(bean.getTenantid()!=null && bean.getTenantid()!=""){
				String tenantid=bean.getTenantid();
				map.put("tenantid", tenantid);
				log.info("tenantid是："+tenantid);
			}
			if(bean.getUpdatedtime()!=null){
				Date updatedtime=bean.getUpdatedtime();
				log.info("updatedtime是====："+updatedtime);
				map.put("updatedtime", updatedtime);
			}
			datas = service.list1(map);
		}
		return FORWARD_LIST;
	}*/
	
	public static void main(String[] args) {
		System.out.println(new Timestamp(System.currentTimeMillis()));
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
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(bean.getId() != null && "".equals(bean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDFundcoststatistics dsBean = service.select(bean.getId());
				if(dsBean != null){
					if (user != null) {
						bean.setUpdatedby(user.getUserId());
					}
					bean.setId(dsBean.getId());
					bean.setCreatedby(dsBean.getCreatedby());
					bean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					service.updateWithDyna(bean);
				}else{
					//是否需要输出数据不存在的异常
				}
			}else{
				if (user != null) {
				 	bean.setCreatedby(user.getUserId());
				}
				service.insert(bean);
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
		if(bean != null && bean.getId() != null){
			String idArrs[] = bean.getId().split("[,]");
			boolean checkResult = true;
//程序是否需要对此数据进行数据检验,如果是请开启此部分的数据检验			
//			for(int i = 0 ; i < idArrs.length ; i++){
//					//是否有对应的数据存在
//					Integer.valueOf(((Map)service.get2Object("查询数据的行数", bean)).get("CNUM").toString());
//					if(rows > 0){
//						checkResult = false;
//						break;
//					}
//			}	
			if(checkResult == true){
				try{
					service.delete(idArrs);
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
	
	
	public QasDFundcoststatisticsService getService() {
		return service;
	}

	@Autowired
	public void setService(QasDFundcoststatisticsService service) {
		this.service = service;
	}

	public QasDFundcoststatistics getBean() {
		return bean;
	}

	public void setBean(QasDFundcoststatistics bean) {
		this.bean = bean;
	}


	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}
}
