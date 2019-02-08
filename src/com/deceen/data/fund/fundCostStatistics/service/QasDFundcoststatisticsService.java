/**
*/
package	com.deceen.data.fund.fundCostStatistics.service;

import java.util.*;

import com.deceen.data.fund.fundCostStatistics.model.QasDFundcoststatistics;
import com.deceen.data.fund.fundCostStatistics.mapper.QasDFundcoststatisticsMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDFundcoststatisticsAction.java
* @Description: qas_d_fundcoststatistics
* @author upaths@gmail.com  
* @date 2017-11-23 12:16:28
* @version V1.0   
*/
@Component("qasDFundcoststatisticsService")	
@SuppressWarnings("rawtypes")
public class QasDFundcoststatisticsService  extends CommonService {

	private QasDFundcoststatisticsMapper mapper;

	public QasDFundcoststatistics select(Object id) {
		return mapper.select(id);
	}

	public int insert(QasDFundcoststatistics bean) {
		bean.setId(IDGenerator.getUUID());
		bean.setCreatedtime(new Date());

		return mapper.insert(bean);
	}

	public int update(QasDFundcoststatistics bean) {
		bean.setUpdatedtime(new Date());
		return mapper.update(bean);
	}

	/** 动态进行更新 */
	public int updateWithDyna(QasDFundcoststatistics bean) {
		bean.setUpdatedtime(new Date());
		return mapper.updateWithDyna(bean);
	}

	/** 批量插入 */
	public int[] batchInsert(List list) {

		return batchDelete(list, QasDFundcoststatisticsMapper.class.getName()
				+ ".insert");
	}
	
	
	public List list(Map map) {
		return queryPageList(QasDFundcoststatisticsMapper.class.getName()+ ".list", map);
	}

	public List list(QasDFundcoststatistics bean) {
			Map map=new HashMap();
			//获取下拉列表的范围(eg:5000-8000)
			if(bean.getSchoolexpenditureScope()!=null && bean.getSchoolexpenditureScope()!=""  && "--请选择--".equals(bean.getSchoolexpenditureScope())==false){
				String schoolexpenditureScope=bean.getSchoolexpenditureScope();
				if(!schoolexpenditureScope.contains("以上")){
					Integer minScope=Integer.parseInt(schoolexpenditureScope.split("-")[0]);
					Integer maxScope=Integer.parseInt(schoolexpenditureScope.split("-")[1]);
					map.put("minScope", minScope);
					map.put("maxScope", maxScope);
				}else{
					schoolexpenditureScope=schoolexpenditureScope.replace("以上", "");
					map.put("schoolexpenditureScope", schoolexpenditureScope);
				}
			}
			if(bean.getTenantid()!=null && bean.getTenantid()!=""){
				String tenantid=bean.getTenantid();
				map.put("tenantid", tenantid);
			}
			if(bean.getUpdatedtime()!=null){
				Date updatedtime=bean.getUpdatedtime();
				System.out.println("updatedtime是====："+updatedtime);
				map.put("updatedtime", updatedtime);
			}
			//return queryPageList(QasDFundcoststatisticsMapper.class.getName()+ ".list", map);
			return this.list(map);
	}
	
	
	/*public List list1(Map map) {
			return queryPageList(QasDFundcoststatisticsMapper.class.getName()
					+ ".list", map);
	}*/
	

	public int delete(Object id) {
		return mapper.delete(id);
	};

	public int delete(Object[] ids) {
		return mapper.batchDelete(ids);
	};

	public QasDFundcoststatisticsMapper getMapper() {
		return mapper;
	}

	@Autowired
	public void setMapper(QasDFundcoststatisticsMapper mapper) {
		this.mapper = mapper;
	}

	public Class getMapperClass() {
		return QasDFundcoststatisticsMapper.class;
	}
}
