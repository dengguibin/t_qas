package	com.deceen.data.school.collegeInSchoolStudent.service;

import java.util.*;
import com.deceen.data.school.collegeInSchoolStudent.model.QasDCollegeinschoolstudent;
import com.deceen.data.school.collegeInSchoolStudent.mapper.QasDCollegeinschoolstudentMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDCollegeinschoolstudentAction.java
* @Description: qas_d_collegeinschoolstudent
* @author upaths@gmail.com  
* @date 2017-11-22 17:42:22
* @version V1.0   
*/
@Component("qasDCollegeinschoolstudentService")	
@SuppressWarnings({ "rawtypes" })
public class QasDCollegeinschoolstudentService  extends CommonService {

		private QasDCollegeinschoolstudentMapper mapper;
	
		public QasDCollegeinschoolstudent select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDCollegeinschoolstudent  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDCollegeinschoolstudent bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */  
		public int updateWithDyna(QasDCollegeinschoolstudent bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		/** 批量插入 */
		public int[] batchInsert(List list){
			return batchDelete(list, QasDCollegeinschoolstudentMapper.class.getName()+".insert");
		}
		
		
		public List list(Map map){
			return queryPageList(QasDCollegeinschoolstudentMapper.class.getName()+".list", map);
		}
		
		public List list(QasDCollegeinschoolstudent bean){
			Map map=new HashMap();
			//获取下拉列表的范围(eg:5000-8000)
			if(bean.getOffnumScope()!=null && bean.getOffnumScope()!=""  && "--请选择--".equals(bean.getOffnumScope())==false){
				String offnumScope=bean.getOffnumScope();
				if(!offnumScope.contains("以上")){
					Integer minoffnumScope=Integer.parseInt(offnumScope.split("-")[0]);
					Integer maxoffnumScope=Integer.parseInt(offnumScope.split("-")[1]);
					map.put("minoffnumScope", minoffnumScope);
					map.put("maxoffnumScope", maxoffnumScope);
				}else{
					offnumScope=offnumScope.replace("以上", "");
					map.put("offnumScope", offnumScope);
				}
			}
			if(bean.getEdustunumScope()!=null && bean.getEdustunumScope()!=""  && "--请选择--".equals(bean.getEdustunumScope())==false){
				String edustunumScope=bean.getEdustunumScope();
				if(!edustunumScope.contains("以上")){
					Integer minedustunumScope=Integer.parseInt(edustunumScope.split("-")[0]);
					Integer maxedustunumScope=Integer.parseInt(edustunumScope.split("-")[1]);
					map.put("minedustunumScope", minedustunumScope);
					map.put("maxedustunumScope", maxedustunumScope);
				}else{
					edustunumScope=edustunumScope.replace("以上", "");
					map.put("edustunumScope", edustunumScope);
				}
			}
			if(bean.getSenioredustunumScope()!=null && bean.getSenioredustunumScope()!=""  && "--请选择--".equals(bean.getSenioredustunumScope())==false){
				String senioredustunumScope=bean.getSenioredustunumScope();
				if(!senioredustunumScope.contains("以上")){
					Integer minsenioredustunumScope=Integer.parseInt(senioredustunumScope.split("-")[0]);
					Integer maxsenioredustunumScope=Integer.parseInt(senioredustunumScope.split("-")[1]);
					map.put("minsenioredustunumScope", minsenioredustunumScope);
					map.put("maxsenioredustunumScope", maxsenioredustunumScope);
				}else{
					senioredustunumScope=senioredustunumScope.replace("以上", "");
					map.put("senioredustunumScope", senioredustunumScope);
				}
			}
			if(bean.getFulltimestufarmernumScope()!=null && bean.getFulltimestufarmernumScope()!=""  && "--请选择--".equals(bean.getFulltimestufarmernumScope())==false){
				String fulltimestufarmernumScope=bean.getFulltimestufarmernumScope();
				if(!fulltimestufarmernumScope.contains("以上")){
					Integer minfulltimestufarmernumScope=Integer.parseInt(fulltimestufarmernumScope.split("-")[0]);
					Integer maxfulltimestufarmernumScope=Integer.parseInt(fulltimestufarmernumScope.split("-")[1]);
					map.put("minfulltimestufarmernumScope", minfulltimestufarmernumScope);
					map.put("maxfulltimestufarmernumScope", maxfulltimestufarmernumScope);
				}else{
					fulltimestufarmernumScope=fulltimestufarmernumScope.replace("以上", "");
					map.put("fulltimestufarmernumScope", fulltimestufarmernumScope);
				}
			}
			if(bean.getAdultcollegestunumScope()!=null && bean.getAdultcollegestunumScope()!=""  && "--请选择--".equals(bean.getAdultcollegestunumScope())==false){
				String adultcollegestunumScope=bean.getAdultcollegestunumScope();
				if(!adultcollegestunumScope.contains("以上")){
					Integer minadultcollegestunumScope=Integer.parseInt(adultcollegestunumScope.split("-")[0]);
					Integer maxadultcollegestunumScope=Integer.parseInt(adultcollegestunumScope.split("-")[1]);
					map.put("minadultcollegestunumScope", minadultcollegestunumScope);
					map.put("maxadultcollegestunumScope", maxadultcollegestunumScope);
				}else{
					adultcollegestunumScope=adultcollegestunumScope.replace("以上", "");
					map.put("adultcollegestunumScope", adultcollegestunumScope);
				}
			}
			if(bean.getParttimepfseduregnumScope()!=null && bean.getParttimepfseduregnumScope()!=""  && "--请选择--".equals(bean.getParttimepfseduregnumScope())==false){
				String parttimepfseduregnumScope=bean.getParttimepfseduregnumScope();
				if(!parttimepfseduregnumScope.contains("以上")){
					Integer minparttimepfseduregnumScope=Integer.parseInt(parttimepfseduregnumScope.split("-")[0]);
					Integer maxparttimepfseduregnumScope=Integer.parseInt(parttimepfseduregnumScope.split("-")[1]);
					map.put("minparttimepfseduregnumScope", minparttimepfseduregnumScope);
					map.put("maxparttimepfseduregnumScope", maxparttimepfseduregnumScope);
				}else{
					parttimepfseduregnumScope=parttimepfseduregnumScope.replace("以上", "");
					map.put("parttimepfseduregnumScope", parttimepfseduregnumScope);
				}
			}
			if(bean.getParttimesenioreduregnumScope()!=null && bean.getParttimesenioreduregnumScope()!=""  && "--请选择--".equals(bean.getParttimesenioreduregnumScope())==false){
				String parttimesenioreduregnumScope=bean.getParttimesenioreduregnumScope();
				if(!parttimesenioreduregnumScope.contains("以上")){
					Integer minparttimesenioreduregnumScope=Integer.parseInt(parttimesenioreduregnumScope.split("-")[0]);
					Integer maxparttimesenioreduregnumScope=Integer.parseInt(parttimesenioreduregnumScope.split("-")[1]);
					map.put("minparttimesenioreduregnumScope", minparttimesenioreduregnumScope);
					map.put("maxparttimesenioreduregnumScope", maxparttimesenioreduregnumScope);
				}else{
					parttimesenioreduregnumScope=parttimesenioreduregnumScope.replace("以上", "");
					map.put("parttimesenioreduregnumScope", parttimesenioreduregnumScope);
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
			
		public QasDCollegeinschoolstudentMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDCollegeinschoolstudentMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDCollegeinschoolstudentMapper.class;
		}
}
