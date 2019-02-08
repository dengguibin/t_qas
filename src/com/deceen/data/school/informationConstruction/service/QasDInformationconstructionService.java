package	com.deceen.data.school.informationConstruction.service;

import java.util.*;
import com.deceen.data.school.informationConstruction.model.QasDInformationconstruction;
import com.deceen.data.school.informationConstruction.mapper.QasDInformationconstructionMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDInformationconstructionAction.java
* @Description: qas_d_informationconstruction
* @author upaths@gmail.com  
* @date 2017-11-22 17:45:56
* @version V1.0   
*/
@Component("qasDInformationconstructionService")	
@SuppressWarnings({ "rawtypes" })
public class QasDInformationconstructionService  extends CommonService {

		private QasDInformationconstructionMapper mapper;
	
		public QasDInformationconstruction select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDInformationconstruction  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDInformationconstruction bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */   
		public int updateWithDyna(QasDInformationconstruction bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		/** 批量插入 */
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDInformationconstructionMapper.class.getName()+".insert");
		}
		
		public List list(Map map){
			return queryPageList(QasDInformationconstructionMapper.class.getName()+".list", map);
		}
		
		public List list(QasDInformationconstruction bean){
			
			Map map=new HashMap();
			//获取下拉列表的范围(eg:5000-8000)
			if(bean.getExportbandwidthScope()!=null && bean.getExportbandwidthScope()!=""  && "--请选择--".equals(bean.getExportbandwidthScope())==false){
				String exportbandwidthScope=bean.getExportbandwidthScope();
				if(!exportbandwidthScope.contains("以上")){
					Integer minexportbandwidthScope=Integer.parseInt(exportbandwidthScope.split("-")[0]);
					Integer maxexportbandwidthScope=Integer.parseInt(exportbandwidthScope.split("-")[1]);
					map.put("minexportbandwidthScope", minexportbandwidthScope);
					map.put("maxexportbandwidthScope", maxexportbandwidthScope);
				}else{
					exportbandwidthScope=exportbandwidthScope.replace("以上", "");
					map.put("exportbandwidthScope", exportbandwidthScope);
				}
			}
			if(bean.getCampusnetworkScope()!=null && bean.getCampusnetworkScope()!=""  && "--请选择--".equals(bean.getCampusnetworkScope())==false){
				String campusnetworkScope=bean.getCampusnetworkScope();
				if(!campusnetworkScope.contains("以上")){
					Integer mincampusnetworkScope=Integer.parseInt(campusnetworkScope.split("-")[0]);
					Integer maxcampusnetworkScope=Integer.parseInt(campusnetworkScope.split("-")[1]);
					map.put("mincampusnetworkScope", mincampusnetworkScope);
					map.put("maxcampusnetworkScope", maxcampusnetworkScope);
				}else{
					campusnetworkScope=campusnetworkScope.replace("以上", "");
					map.put("campusnetworkScope", campusnetworkScope);
				}
			}
			if(bean.getNetworkinformationpointScope()!=null && bean.getNetworkinformationpointScope()!=""  && "--请选择--".equals(bean.getNetworkinformationpointScope())==false){
				String networkinformationpointScope=bean.getNetworkinformationpointScope();
				if(!networkinformationpointScope.contains("以上")){
					Integer minnetworkinformationpointScope=Integer.parseInt(networkinformationpointScope.split("-")[0]);
					Integer maxnetworkinformationpointScope=Integer.parseInt(networkinformationpointScope.split("-")[1]);
					map.put("minnetworkinformationpointScope", minnetworkinformationpointScope);
					map.put("maxnetworkinformationpointScope", maxnetworkinformationpointScope);
				}else{
					networkinformationpointScope=networkinformationpointScope.replace("以上", "");
					map.put("networkinformationpointScope", networkinformationpointScope);
				}
			}
			if(bean.getAccountofmisScope()!=null && bean.getAccountofmisScope()!=""  && "--请选择--".equals(bean.getAccountofmisScope())==false){
				String accountofmisScope=bean.getAccountofmisScope();
				if(!accountofmisScope.contains("以上")){
					Integer minaccountofmisScope=Integer.parseInt(accountofmisScope.split("-")[0]);
					Integer maxaccountofmisScope=Integer.parseInt(accountofmisScope.split("-")[1]);
					map.put("minaccountofmisScope", minaccountofmisScope);
					map.put("maxaccountofmisScope", maxaccountofmisScope);
				}else{
					accountofmisScope=accountofmisScope.replace("以上", "");
					map.put("accountofmisScope", accountofmisScope);
				}
			}
			if(bean.getEmailusercountScope()!=null && bean.getEmailusercountScope()!=""  && "--请选择--".equals(bean.getEmailusercountScope())==false){
				String emailusercountScope=bean.getEmailusercountScope();
				if(!emailusercountScope.contains("以上")){
					Integer minemailusercountScope=Integer.parseInt(emailusercountScope.split("-")[0]);
					Integer maxemailusercountScope=Integer.parseInt(emailusercountScope.split("-")[1]);
					map.put("minemailusercountScope", minemailusercountScope);
					map.put("maxemailusercountScope", maxemailusercountScope);
				}else{
					emailusercountScope=emailusercountScope.replace("以上", "");
					map.put("emailusercountScope", emailusercountScope);
				}
			}
			if(bean.getOnlinecoursecountScope()!=null && bean.getOnlinecoursecountScope()!=""  && "--请选择--".equals(bean.getOnlinecoursecountScope())==false){
				String onlinecoursecountScope=bean.getOnlinecoursecountScope();
				if(!onlinecoursecountScope.contains("以上")){
					Integer minonlinecoursecountScope=Integer.parseInt(onlinecoursecountScope.split("-")[0]);
					Integer maxonlinecoursecountScope=Integer.parseInt(onlinecoursecountScope.split("-")[1]);
					map.put("minonlinecoursecountScope", minonlinecoursecountScope);
					map.put("maxonlinecoursecountScope", maxonlinecoursecountScope);
				}else{
					onlinecoursecountScope=onlinecoursecountScope.replace("以上", "");
					map.put("onlinecoursecountScope", onlinecoursecountScope);
				}
			}
			if(bean.getTotaldigitalresourceScope()!=null && bean.getTotaldigitalresourceScope()!=""  && "--请选择--".equals(bean.getTotaldigitalresourceScope())==false){
				String totaldigitalresourceScope=bean.getTotaldigitalresourceScope();
				if(!totaldigitalresourceScope.contains("以上")){
					Integer mintotaldigitalresourceScope=Integer.parseInt(totaldigitalresourceScope.split("-")[0]);
					Integer maxtotaldigitalresourceScope=Integer.parseInt(totaldigitalresourceScope.split("-")[1]);
					map.put("mintotaldigitalresourceScope", mintotaldigitalresourceScope);
					map.put("maxtotaldigitalresourceScope", maxtotaldigitalresourceScope);
				}else{
					totaldigitalresourceScope=totaldigitalresourceScope.replace("以上", "");
					map.put("totaldigitalresourceScope", totaldigitalresourceScope);
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
			
		public QasDInformationconstructionMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDInformationconstructionMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDInformationconstructionMapper.class;
		}
}
