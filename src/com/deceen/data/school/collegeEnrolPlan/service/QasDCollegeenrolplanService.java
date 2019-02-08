package	com.deceen.data.school.collegeEnrolPlan.service;

import java.util.*;
import com.deceen.data.school.collegeEnrolPlan.model.QasDCollegeenrolplan;
import com.deceen.data.school.collegeEnrolPlan.mapper.QasDCollegeenrolplanMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDCollegeenrolplanAction.java
* @Description: qas_d_collegeenrolplan
* @author upaths@gmail.com  
* @date 2017-11-22 17:40:49
* @version V1.0   
*/
@Component("qasDCollegeenrolplanService")	
@SuppressWarnings({ "rawtypes" })
public class QasDCollegeenrolplanService  extends CommonService {

		private QasDCollegeenrolplanMapper mapper;
	
		public QasDCollegeenrolplan select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDCollegeenrolplan  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDCollegeenrolplan bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */  
		public int updateWithDyna(QasDCollegeenrolplan bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		/** 批量插入 */
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDCollegeenrolplanMapper.class.getName()+".insert");
		}
		
		public List list(Map map){
			return queryPageList(QasDCollegeenrolplanMapper.class.getName()+".list", map);
		}
		
		
		public List list(QasDCollegeenrolplan bean){
			Map map=new HashMap();
			//获取下拉列表的范围(eg:5000-8000)
			if(bean.getColumn_9Scope()!=null && bean.getColumn_9Scope()!=""  && "--请选择--".equals(bean.getColumn_9Scope())==false){
				String column_9Scope=bean.getColumn_9Scope();
				if(!column_9Scope.contains("以上")){
					Integer mincolumn_9Scope=Integer.parseInt(column_9Scope.split("-")[0]);
					Integer maxcolumn_9Scope=Integer.parseInt(column_9Scope.split("-")[1]);
					map.put("mincolumn_9Scope", mincolumn_9Scope);
					map.put("maxcolumn_9Scope", maxcolumn_9Scope);
				}else{
					column_9Scope=column_9Scope.replace("以上", "");
					map.put("column_9Scope", column_9Scope);
				}
			}
			if(bean.getColumn_10Scope()!=null && bean.getColumn_10Scope()!=""  && "--请选择--".equals(bean.getColumn_10Scope())==false){
				String column_10Scope=bean.getColumn_10Scope();
				if(!column_10Scope.contains("以上")){
					Integer mincolumn_10Scope=Integer.parseInt(column_10Scope.split("-")[0]);
					Integer maxcolumn_10Scope=Integer.parseInt(column_10Scope.split("-")[1]);
					map.put("mincolumn_10Scope", mincolumn_10Scope);
					map.put("maxcolumn_10Scope", maxcolumn_10Scope);
				}else{
					column_10Scope=column_10Scope.replace("以上", "");
					map.put("column_10Scope", column_10Scope);
				}
			}
			if(bean.getColumn_11Scope()!=null && bean.getColumn_11Scope()!=""  && "--请选择--".equals(bean.getColumn_11Scope())==false){
				String column_11Scope=bean.getColumn_11Scope();
				if(!column_11Scope.contains("以上")){
					Integer mincolumn_11Scope=Integer.parseInt(column_11Scope.split("-")[0]);
					Integer maxcolumn_11Scope=Integer.parseInt(column_11Scope.split("-")[1]);
					map.put("mincolumn_11Scope", mincolumn_11Scope);
					map.put("maxcolumn_11Scope", maxcolumn_11Scope);
				}else{
					column_11Scope=column_11Scope.replace("以上", "");
					map.put("column_11Scope", column_11Scope);
				}
			}
			if(bean.getColumn_12Scope()!=null && bean.getColumn_12Scope()!=""  && "--请选择--".equals(bean.getColumn_12Scope())==false){
				String column_12Scope=bean.getColumn_12Scope();
				if(!column_12Scope.contains("以上")){
					Integer mincolumn_12Scope=Integer.parseInt(column_12Scope.split("-")[0]);
					Integer maxcolumn_12Scope=Integer.parseInt(column_12Scope.split("-")[1]);
					map.put("mincolumn_12Scope", mincolumn_12Scope);
					map.put("maxcolumn_12Scope", maxcolumn_12Scope);
				}else{
					column_12Scope=column_12Scope.replace("以上", "");
					map.put("column_12Scope", column_12Scope);
				}
			}
			if(bean.getColumn_13Scope()!=null && bean.getColumn_13Scope()!=""  && "--请选择--".equals(bean.getColumn_13Scope())==false){
				String column_13Scope=bean.getColumn_13Scope();
				if(!column_13Scope.contains("以上")){
					Integer mincolumn_13Scope=Integer.parseInt(column_13Scope.split("-")[0]);
					Integer maxcolumn_13Scope=Integer.parseInt(column_13Scope.split("-")[1]);
					map.put("mincolumn_13Scope", mincolumn_13Scope);
					map.put("maxcolumn_13Scope", maxcolumn_13Scope);
				}else{
					column_13Scope=column_13Scope.replace("以上", "");
					map.put("column_13Scope", column_13Scope);
				}
			}
			if(bean.getColumn_14Scope()!=null && bean.getColumn_14Scope()!=""  && "--请选择--".equals(bean.getColumn_14Scope())==false){
				String column_14Scope=bean.getColumn_14Scope();
				if(!column_14Scope.contains("以上")){
					Integer mincolumn_14Scope=Integer.parseInt(column_14Scope.split("-")[0]);
					Integer maxcolumn_14Scope=Integer.parseInt(column_14Scope.split("-")[1]);
					map.put("mincolumn_14Scope", mincolumn_14Scope);
					map.put("maxcolumn_14Scope", maxcolumn_14Scope);
				}else{
					column_14Scope=column_14Scope.replace("以上", "");
					map.put("column_14Scope", column_14Scope);
				}
			}
			if(bean.getColumn_15Scope()!=null && bean.getColumn_15Scope()!=""  && "--请选择--".equals(bean.getColumn_15Scope())==false){
				String column_15Scope=bean.getColumn_15Scope();
				if(!column_15Scope.contains("以上")){
					Integer mincolumn_15Scope=Integer.parseInt(column_15Scope.split("-")[0]);
					Integer maxcolumn_15Scope=Integer.parseInt(column_15Scope.split("-")[1]);
					map.put("mincolumn_15Scope", mincolumn_15Scope);
					map.put("maxcolumn_15Scope", maxcolumn_15Scope);
				}else{
					column_15Scope=column_15Scope.replace("以上", "");
					map.put("column_15Scope", column_15Scope);
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
			
		public QasDCollegeenrolplanMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDCollegeenrolplanMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDCollegeenrolplanMapper.class;
		}
}
