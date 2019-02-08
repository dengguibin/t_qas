package	com.deceen.data.student.qualification.service;

import java.util.*;
import com.deceen.data.student.qualification.model.QasDQualification;
import com.deceen.data.student.qualification.mapper.QasDQualificationMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDQualificationAction.java
* @Description: qas_d_qualification
* @author upaths@gmail.com  
* @date 2017-11-24 10:17:24
* @version V1.0   
*/
@Component("qasDQualificationService")	
@SuppressWarnings({ "rawtypes" })
public class QasDQualificationService  extends CommonService {

		private QasDQualificationMapper mapper;
	
		public QasDQualification select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDQualification  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDQualification bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
//		 需要时请开启,动态进行更新,批量插入实现
		public int updateWithDyna(QasDQualification bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDQualificationMapper.class.getName()+".insert");
		}
		
		public List list(Map map){
			return queryPageList(QasDQualificationMapper.class.getName()+".list", map);
		}
		
		public List list(QasDQualification bean){
			Map map=new HashMap();
			if(bean.getDirectionid()!=null && bean.getDirectionid()!=""){
				String directionid=bean.getDirectionid();
				map.put("directionid", directionid);
			}
			
			if(bean.getCertname()!=null && bean.getCertname()!=""){
				String certname=bean.getCertname();
				map.put("certname", certname);
			}
			
			if(bean.getCertlevel()!=null && bean.getCertlevel()!=""){
				String certlevel=bean.getCertlevel();
				map.put("certlevel", certlevel);
			}
			//获取下拉列表的范围(eg:5000-8000)
			if(bean.getCertcountScope()!=null && bean.getCertcountScope()!=""  && "--请选择--".equals(bean.getCertcountScope())==false){
				String certcountScope=bean.getCertcountScope();
				if(!certcountScope.contains("以上")){
					Integer mincertcountScope=Integer.parseInt(certcountScope.split("-")[0]);
					Integer maxcertcountScope=Integer.parseInt(certcountScope.split("-")[1]);
					map.put("mincertcountScope", mincertcountScope);
					map.put("maxcertcountScope", maxcertcountScope);
				}else{
					certcountScope=certcountScope.replace("以上", "");
					map.put("certcountScope", certcountScope);
				}
			}
			
			if(bean.getIssuingdepartment()!=null && bean.getIssuingdepartment()!=""){
				String issuingdepartment=bean.getIssuingdepartment();
				map.put("issuingdepartment", issuingdepartment);
			}
			
			if(bean.getIdentificationsite()!=null && bean.getIdentificationsite()!=""){
				String identificationsite=bean.getIdentificationsite();
				map.put("identificationsite", identificationsite);
			}
			return this.list(map);
		}
			
		public int delete(Object id){
			return 	mapper.delete(id);
		};
		
		public int delete(Object[] ids){
			return mapper.batchDelete(ids);
		};
			
		public QasDQualificationMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDQualificationMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDQualificationMapper.class;
		}
}
