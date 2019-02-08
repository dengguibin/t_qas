package	com.deceen.data.student.retiredSoldiers.service;

import java.util.*;
import com.deceen.data.student.retiredSoldiers.model.QasDRetiredsoldiers;
import com.deceen.data.student.retiredSoldiers.mapper.QasDRetiredsoldiersMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDRetiredsoldiersAction.java
* @Description: qas_d_retiredsoldiers
* @author upaths@gmail.com  
* @date 2017-11-24 10:37:22
* @version V1.0   
*/
@Component("qasDRetiredsoldiersService")	
@SuppressWarnings({ "rawtypes" })
public class QasDRetiredsoldiersService  extends CommonService {

		private QasDRetiredsoldiersMapper mapper;
	
		public QasDRetiredsoldiers select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDRetiredsoldiers  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDRetiredsoldiers bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
//		 需要时请开启,动态进行更新,批量插入实现
		public int updateWithDyna(QasDRetiredsoldiers bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDRetiredsoldiersMapper.class.getName()+".insert");
		}
		
		public List list(Map map){
			return queryPageList(QasDRetiredsoldiersMapper.class.getName()+".list", map);
		}
			
		public List list(QasDRetiredsoldiers bean){
			Map map=new HashMap();
			//获取下拉列表的范围(eg:5000-8000)
			if(bean.getEnrolltotalScope()!=null && bean.getEnrolltotalScope()!=""  && "--请选择--".equals(bean.getEnrolltotalScope())==false){
				String enrolltotalScope=bean.getEnrolltotalScope();
				if(!enrolltotalScope.contains("以上")){
					Integer minenrolltotalScope=Integer.parseInt(enrolltotalScope.split("-")[0]);
					Integer maxenrolltotalScope=Integer.parseInt(enrolltotalScope.split("-")[1]);
					map.put("minenrolltotalScope", minenrolltotalScope);
					map.put("maxenrolltotalScope", maxenrolltotalScope);
				}else{
					enrolltotalScope=enrolltotalScope.replace("以上", "");
					map.put("enrolltotalScope", enrolltotalScope);
				}
			}
			
			if(bean.getEnrollarmymenScope()!=null && bean.getEnrollarmymenScope()!=""  && "--请选择--".equals(bean.getEnrollarmymenScope())==false){
				String enrollarmymenScope=bean.getEnrollarmymenScope();
				if(!enrollarmymenScope.contains("以上")){
					Integer minenrollarmymenScope=Integer.parseInt(enrollarmymenScope.split("-")[0]);
					Integer maxenrollarmymenScope=Integer.parseInt(enrollarmymenScope.split("-")[1]);
					map.put("minenrollarmymenScope", minenrollarmymenScope);
					map.put("maxenrollarmymenScope", maxenrollarmymenScope);
				}else{
					enrollarmymenScope=enrollarmymenScope.replace("以上", "");
					map.put("enrollarmymenScope", enrollarmymenScope);
				}
			}
			
			if(bean.getEnrollretiredsoldierScope()!=null && bean.getEnrollretiredsoldierScope()!=""  && "--请选择--".equals(bean.getEnrollretiredsoldierScope())==false){
				String enrollretiredsoldierScope=bean.getEnrollretiredsoldierScope();
				if(!enrollretiredsoldierScope.contains("以上")){
					Integer minenrollretiredsoldierScope=Integer.parseInt(enrollretiredsoldierScope.split("-")[0]);
					Integer maxenrollretiredsoldierScope=Integer.parseInt(enrollretiredsoldierScope.split("-")[1]);
					map.put("minenrollretiredsoldierScope", minenrollretiredsoldierScope);
					map.put("maxenrollretiredsoldierScope", maxenrollretiredsoldierScope);
				}else{
					enrollretiredsoldierScope=enrollretiredsoldierScope.replace("以上", "");
					map.put("enrollretiredsoldierScope", enrollretiredsoldierScope);
				}
			}
			
			if(bean.getInschooltotalScope()!=null && bean.getInschooltotalScope()!=""  && "--请选择--".equals(bean.getInschooltotalScope())==false){
				String inschooltotalScope=bean.getInschooltotalScope();
				if(!inschooltotalScope.contains("以上")){
					Integer mininschooltotalScope=Integer.parseInt(inschooltotalScope.split("-")[0]);
					Integer maxinschooltotalScope=Integer.parseInt(inschooltotalScope.split("-")[1]);
					map.put("mininschooltotalScope", mininschooltotalScope);
					map.put("maxinschooltotalScope", maxinschooltotalScope);
				}else{
					inschooltotalScope=inschooltotalScope.replace("以上", "");
					map.put("inschooltotalScope", inschooltotalScope);
				}
			}
			
			if(bean.getInschoolarmymenScope()!=null && bean.getInschoolarmymenScope()!=""  && "--请选择--".equals(bean.getInschoolarmymenScope())==false){
				String inschoolarmymenScope=bean.getInschoolarmymenScope();
				if(!inschoolarmymenScope.contains("以上")){
					Integer mininschoolarmymenScope=Integer.parseInt(inschoolarmymenScope.split("-")[0]);
					Integer maxinschoolarmymenScope=Integer.parseInt(inschoolarmymenScope.split("-")[1]);
					map.put("mininschoolarmymenScope", mininschoolarmymenScope);
					map.put("maxinschoolarmymenScope", maxinschoolarmymenScope);
				}else{
					inschoolarmymenScope=inschoolarmymenScope.replace("以上", "");
					map.put("inschoolarmymenScope", inschoolarmymenScope);
				}
			}
			
			if(bean.getInschoolretiredsoldierScope()!=null && bean.getInschoolretiredsoldierScope()!=""  && "--请选择--".equals(bean.getInschoolretiredsoldierScope())==false){
				String inschoolretiredsoldierScope=bean.getInschoolretiredsoldierScope();
				if(!inschoolretiredsoldierScope.contains("以上")){
					Integer mininschoolretiredsoldierScope=Integer.parseInt(inschoolretiredsoldierScope.split("-")[0]);
					Integer maxinschoolretiredsoldierScope=Integer.parseInt(inschoolretiredsoldierScope.split("-")[1]);
					map.put("mininschoolretiredsoldierScope", mininschoolretiredsoldierScope);
					map.put("maxinschoolretiredsoldierScope", maxinschoolretiredsoldierScope);
				}else{
					inschoolretiredsoldierScope=inschoolretiredsoldierScope.replace("以上", "");
					map.put("inschoolretiredsoldierScope", inschoolretiredsoldierScope);
				}
			}
			
			if(bean.getSocietytrainingtotalScope()!=null && bean.getSocietytrainingtotalScope()!=""  && "--请选择--".equals(bean.getSocietytrainingtotalScope())==false){
				String societytrainingtotalScope=bean.getSocietytrainingtotalScope();
				if(!societytrainingtotalScope.contains("以上")){
					Integer minsocietytrainingtotalScope=Integer.parseInt(societytrainingtotalScope.split("-")[0]);
					Integer maxsocietytrainingtotalScope=Integer.parseInt(societytrainingtotalScope.split("-")[1]);
					map.put("minsocietytrainingtotalScope", minsocietytrainingtotalScope);
					map.put("maxsocietytrainingtotalScope", maxsocietytrainingtotalScope);
				}else{
					societytrainingtotalScope=societytrainingtotalScope.replace("以上", "");
					map.put("societytrainingtotalScope", societytrainingtotalScope);
				}
			}
			
			if(bean.getSocietytrainingarmymenScope()!=null && bean.getSocietytrainingarmymenScope()!=""  && "--请选择--".equals(bean.getSocietytrainingarmymenScope())==false){
				String societytrainingarmymenScope=bean.getSocietytrainingarmymenScope();
				if(!societytrainingarmymenScope.contains("以上")){
					Integer minsocietytrainingarmymenScope=Integer.parseInt(societytrainingarmymenScope.split("-")[0]);
					Integer maxsocietytrainingarmymenScope=Integer.parseInt(societytrainingarmymenScope.split("-")[1]);
					map.put("minsocietytrainingarmymenScope", minsocietytrainingarmymenScope);
					map.put("maxsocietytrainingarmymenScope", maxsocietytrainingarmymenScope);
				}else{
					societytrainingarmymenScope=societytrainingarmymenScope.replace("以上", "");
					map.put("societytrainingarmymenScope", societytrainingarmymenScope);
				}
			}
			
			if(bean.getSocietytrainingretiredsoldierScope()!=null && bean.getSocietytrainingretiredsoldierScope()!=""  && "--请选择--".equals(bean.getSocietytrainingretiredsoldierScope())==false){
				String societytrainingretiredsoldierScope=bean.getSocietytrainingretiredsoldierScope();
				if(!societytrainingretiredsoldierScope.contains("以上")){
					Integer minsocietytrainingretiredsoldierScope=Integer.parseInt(societytrainingretiredsoldierScope.split("-")[0]);
					Integer maxsocietytrainingretiredsoldierScope=Integer.parseInt(societytrainingretiredsoldierScope.split("-")[1]);
					map.put("minsocietytrainingretiredsoldierScope", minsocietytrainingretiredsoldierScope);
					map.put("maxsocietytrainingretiredsoldierScope", maxsocietytrainingretiredsoldierScope);
				}else{
					societytrainingretiredsoldierScope=societytrainingretiredsoldierScope.replace("以上", "");
					map.put("societytrainingretiredsoldierScope", societytrainingretiredsoldierScope);
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
			
		public QasDRetiredsoldiersMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDRetiredsoldiersMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDRetiredsoldiersMapper.class;
		}
}
