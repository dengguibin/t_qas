package	com.deceen.data.school.collegeEnrolType.service;

import java.util.*;
import com.deceen.data.school.collegeEnrolType.model.QasDCollegeenroltype;
import com.deceen.data.school.collegeEnrolType.mapper.QasDCollegeenroltypeMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDCollegeenroltypeAction.java
* @Description: qas_d_collegeenroltype
* @author upaths@gmail.com  
* @date 2017-11-22 17:41:43
* @version V1.0   
*/
@Component("qasDCollegeenroltypeService")	
@SuppressWarnings({ "rawtypes"  })
public class QasDCollegeenroltypeService  extends CommonService {

		private QasDCollegeenroltypeMapper mapper;
	
		public QasDCollegeenroltype select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDCollegeenroltype  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDCollegeenroltype bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */   
		public int updateWithDyna(QasDCollegeenroltype bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		/** 批量插入 */
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDCollegeenroltypeMapper.class.getName()+".insert");
		}
		
		public List list(Map map){
			return queryPageList(QasDCollegeenroltypeMapper.class.getName()+".list", map);
		}
		
		public List list(QasDCollegeenroltype bean){
			Map map=new HashMap();
			//获取下拉列表的范围(eg:5000-8000)
			if(bean.getCollegenumScope()!=null && bean.getCollegenumScope()!=""  && "--请选择--".equals(bean.getCollegenumScope())==false){
				String collegenumScope=bean.getCollegenumScope();
				if(!collegenumScope.contains("以上")){
					Integer mincollegenumScope=Integer.parseInt(collegenumScope.split("-")[0]);
					Integer maxcollegenumScope=Integer.parseInt(collegenumScope.split("-")[1]);
					map.put("mincollegenumScope", mincollegenumScope);
					map.put("maxcollegenumScope", maxcollegenumScope);
				}else{
					collegenumScope=collegenumScope.replace("以上", "");
					map.put("collegenumScope", collegenumScope);
				}
			}
			
			if(bean.getSeniorexamnumScope()!=null && bean.getSeniorexamnumScope()!=""  && "--请选择--".equals(bean.getSeniorexamnumScope())==false){
				String seniorexamnumScope=bean.getSeniorexamnumScope();
				if(!seniorexamnumScope.contains("以上")){
					Integer minseniorexamnumScope=Integer.parseInt(seniorexamnumScope.split("-")[0]);
					Integer maxseniorexamnumScope=Integer.parseInt(seniorexamnumScope.split("-")[1]);
					map.put("minseniorexamnumScope", minseniorexamnumScope);
					map.put("maxseniorexamnumScope", maxseniorexamnumScope);
				}else{
					seniorexamnumScope=seniorexamnumScope.replace("以上", "");
					map.put("seniorexamnumScope", seniorexamnumScope);
				}
			}
			
			if(bean.getSamepfsnumScope()!=null && bean.getSamepfsnumScope()!=""  && "--请选择--".equals(bean.getSamepfsnumScope())==false){
				String samepfsnumScope=bean.getSamepfsnumScope();
				if(!samepfsnumScope.contains("以上")){
					Integer minsamepfsnumScope=Integer.parseInt(samepfsnumScope.split("-")[0]);
					Integer maxsamepfsnumScope=Integer.parseInt(samepfsnumScope.split("-")[1]);
					map.put("minsamepfsnumScope", minsamepfsnumScope);
					map.put("maxsamepfsnumScope", maxsamepfsnumScope);
				}else{
					samepfsnumScope=samepfsnumScope.replace("以上", "");
					map.put("samepfsnumScope", samepfsnumScope);
				}
			}
			
			if(bean.getSingleexamnumScope()!=null && bean.getSingleexamnumScope()!=""  && "--请选择--".equals(bean.getSingleexamnumScope())==false){
				String singleexamnumScope=bean.getSingleexamnumScope();
				if(!singleexamnumScope.contains("以上")){
					Integer minsingleexamnumScope=Integer.parseInt(singleexamnumScope.split("-")[0]);
					Integer maxsingleexamnumScope=Integer.parseInt(singleexamnumScope.split("-")[1]);
					map.put("minsingleexamnumScope", minsingleexamnumScope);
					map.put("maxsingleexamnumScope", maxsingleexamnumScope);
				}else{
					singleexamnumScope=singleexamnumScope.replace("以上", "");
					map.put("singleexamnumScope", singleexamnumScope);
				}
			}
			
			if(bean.getMulestimatenumScope()!=null && bean.getMulestimatenumScope()!=""  && "--请选择--".equals(bean.getMulestimatenumScope())==false){
				String mulestimatenumScope=bean.getMulestimatenumScope();
				if(!mulestimatenumScope.contains("以上")){
					Integer minmulestimatenumScope=Integer.parseInt(mulestimatenumScope.split("-")[0]);
					Integer maxmulestimatenumScope=Integer.parseInt(mulestimatenumScope.split("-")[1]);
					map.put("minmulestimatenumScope", minmulestimatenumScope);
					map.put("maxmulestimatenumScope", maxmulestimatenumScope);
				}else{
					mulestimatenumScope=mulestimatenumScope.replace("以上", "");
					map.put("mulestimatenumScope", mulestimatenumScope);
				}
			}
			
			if(bean.getMidhigconnumScope()!=null && bean.getMidhigconnumScope()!=""  && "--请选择--".equals(bean.getMidhigconnumScope())==false){
				String midhigconnumScope=bean.getMidhigconnumScope();
				if(!midhigconnumScope.contains("以上")){
					Integer minmidhigconnumScope=Integer.parseInt(midhigconnumScope.split("-")[0]);
					Integer maxmidhigconnumScope=Integer.parseInt(midhigconnumScope.split("-")[1]);
					map.put("minmidhigconnumScope", minmidhigconnumScope);
					map.put("maxmidhigconnumScope", maxmidhigconnumScope);
				}else{
					midhigconnumScope=midhigconnumScope.replace("以上", "");
					map.put("midhigconnumScope", midhigconnumScope);
				}
			}
			
			if(bean.getNoexamnumScope()!=null && bean.getNoexamnumScope()!=""  && "--请选择--".equals(bean.getNoexamnumScope())==false){
				String noexamnumScope=bean.getNoexamnumScope();
				if(!noexamnumScope.contains("以上")){
					Integer minnoexamnumScope=Integer.parseInt(noexamnumScope.split("-")[0]);
					Integer maxnoexamnumScope=Integer.parseInt(noexamnumScope.split("-")[1]);
					map.put("minnoexamnumScope", minnoexamnumScope);
					map.put("maxnoexamnumScope", maxnoexamnumScope);
				}else{
					noexamnumScope=noexamnumScope.replace("以上", "");
					map.put("noexamnumScope", noexamnumScope);
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
			
		public QasDCollegeenroltypeMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDCollegeenroltypeMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDCollegeenroltypeMapper.class;
		}
}
