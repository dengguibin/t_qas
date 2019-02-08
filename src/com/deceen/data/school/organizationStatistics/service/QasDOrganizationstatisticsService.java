package	com.deceen.data.school.organizationStatistics.service;

import java.util.*;
import com.deceen.data.school.organizationStatistics.model.QasDOrganizationstatistics;
import com.deceen.data.school.organizationStatistics.mapper.QasDOrganizationstatisticsMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDOrganizationstatisticsAction.java
* @Description: qas_d_organizationstatistics
* @author upaths@gmail.com  
* @date 2017-11-22 17:43:07
* @version V1.0   
*/
@Component("qasDOrganizationstatisticsService")	
@SuppressWarnings({ "rawtypes" })
public class QasDOrganizationstatisticsService  extends CommonService {

		private QasDOrganizationstatisticsMapper mapper;
	
		public QasDOrganizationstatistics select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDOrganizationstatistics  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			
			return	mapper.insert(bean);
		}
		
		public int update(QasDOrganizationstatistics bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		 /** 动态更新 */
		public int updateWithDyna(QasDOrganizationstatistics bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		 /** 批量插入 */
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDOrganizationstatisticsMapper.class.getName()+".insert");
		}
		
		
		public List list(Map map){
			return queryPageList(QasDOrganizationstatisticsMapper.class.getName()+".list", map);
		}
		
		public List list(QasDOrganizationstatistics bean){
			Map map=new HashMap();
			if(bean.getDepartmentid()!=null && bean.getDepartmentid()!=""){
				String departmentid=bean.getDepartmentid();
				map.put("departmentid", departmentid);
			}
			//获取下拉列表的范围(eg:5000-8000)
			if(bean.getPartworknumScope()!=null && bean.getPartworknumScope()!=""  && "--请选择--".equals(bean.getPartworknumScope())==false){
				String partworknumScope=bean.getPartworknumScope();
				if(!partworknumScope.contains("以上")){
					Integer minpartworknumScope=Integer.parseInt(partworknumScope.split("-")[0]);
					Integer maxpartworknumScope=Integer.parseInt(partworknumScope.split("-")[1]);
					map.put("minpartworknumScope", minpartworknumScope);
					map.put("maxpartworknumScope", maxpartworknumScope);
				}else{
					partworknumScope=partworknumScope.replace("以上", "");
					map.put("partworknumScope", partworknumScope);
				}
			}
			
			//获取下拉列表的范围(eg:5000-8000)
			if(bean.getFullworknumScope()!=null && bean.getFullworknumScope()!=""  && "--请选择--".equals(bean.getFullworknumScope())==false){
				String fullworknumScope=bean.getFullworknumScope();
				if(!fullworknumScope.contains("以上")){
					Integer minfullworknumScope=Integer.parseInt(fullworknumScope.split("-")[0]);
					Integer maxfullworknumScope=Integer.parseInt(fullworknumScope.split("-")[1]);
					map.put("minfullworknumScope", minfullworknumScope);
					map.put("maxfullworknumScope", maxfullworknumScope);
				}else{
					fullworknumScope=fullworknumScope.replace("以上", "");
					map.put("fullworknumScope", fullworknumScope);
				}
			}
			return this.list(map);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDOrganizationstatisticsMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDOrganizationstatisticsMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDOrganizationstatisticsMapper.class;
		}
}
