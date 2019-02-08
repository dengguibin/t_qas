package	com.deceen.data.school.socialDonation.service;

import java.util.*;
import com.deceen.data.school.socialDonation.model.QasDSocialdonation;
import com.deceen.data.school.socialDonation.mapper.QasDSocialdonationMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDSocialdonationAction.java
* @Description: qas_d_socialdonation
* @author upaths@gmail.com  
* @date 2017-11-22 18:00:58
* @version V1.0   
*/
@Component("qasDSocialdonationService")	
@SuppressWarnings({ "rawtypes" })
public class QasDSocialdonationService  extends CommonService {

		private QasDSocialdonationMapper mapper;
	
		public QasDSocialdonation select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDSocialdonation  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			
			return	mapper.insert(bean);
		}
		
		public int update(QasDSocialdonation bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */   
		public int updateWithDyna(QasDSocialdonation bean){
		bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		/** 批量插入 */
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDSocialdonationMapper.class.getName()+".insert");
		}
		
		public List list(Map map){
			return queryPageList(QasDSocialdonationMapper.class.getName()+".list", map);
		}
	
		/*private String donationdepartment;
		 //捐赠项目 
		private String donationproject;
		 //捐赠日期（年月） 
		private String donationdate;
		 //捐赠性质 
		private String donationnature;
		 //捐赠价值（万元） 
		private Integer donationvalueScope;*/
		
		public List list(QasDSocialdonation bean){
			Map map=new HashMap();
			
			if(bean.getDonationdepartment()!=null && bean.getDonationdepartment()!=""){
				String donationdepartment=bean.getDonationdepartment();
				map.put("donationdepartment", donationdepartment);
			}
			
			if(bean.getDonationproject()!=null && bean.getDonationproject()!=""){
				String donationproject=bean.getDonationproject();
				map.put("donationproject", donationproject);
			}
			
			if(bean.getDonationdate()!=null && bean.getDonationdate()!=""){
				String donationdate=bean.getDonationdate();
				map.put("donationdate", donationdate);
			}
			
			if(bean.getDonationnature()!=null && bean.getDonationnature()!=""){
				String donationnature=bean.getDonationnature();
				map.put("donationnature", donationnature);
			}
			
			//获取下拉列表的范围(eg:5000-8000)
			if(bean.getDonationvalueScope()!=null && bean.getDonationvalueScope()!=""  && "--请选择--".equals(bean.getDonationvalueScope())==false){
				String donationvalueScope=bean.getDonationvalueScope();
				if(!donationvalueScope.contains("以上")){
					Integer mindonationvalueScope=Integer.parseInt(donationvalueScope.split("-")[0]);
					Integer maxdonationvalueScope=Integer.parseInt(donationvalueScope.split("-")[1]);
					map.put("mindonationvalueScope", mindonationvalueScope);
					map.put("maxdonationvalueScope", maxdonationvalueScope);
				}else{
					donationvalueScope=donationvalueScope.replace("以上", "");
					map.put("donationvalueScope", donationvalueScope);
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
			
		public QasDSocialdonationMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDSocialdonationMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDSocialdonationMapper.class;
		}
}
