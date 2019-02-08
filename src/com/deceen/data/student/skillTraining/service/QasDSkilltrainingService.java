package	com.deceen.data.student.skillTraining.service;

import java.util.*;
import com.deceen.data.student.skillTraining.model.QasDSkilltraining;
import com.deceen.data.student.skillTraining.mapper.QasDSkilltrainingMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDSkilltrainingAction.java
* @Description: qas_d_skilltraining
* @author upaths@gmail.com  
* @date 2017-11-24 10:18:01
* @version V1.0   
*/
@Component("qasDSkilltrainingService")	
@SuppressWarnings({ "rawtypes" })
public class QasDSkilltrainingService  extends CommonService {

		private QasDSkilltrainingMapper mapper;
	
		public QasDSkilltraining select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDSkilltraining  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDSkilltraining bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
//		 需要时请开启,动态进行更新,批量插入实现
		public int updateWithDyna(QasDSkilltraining bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDSkilltrainingMapper.class.getName()+".insert");
		}
		
		public List list(Map map){
			return queryPageList(QasDSkilltrainingMapper.class.getName()+".list", map);
		}
			
		public List list(QasDSkilltraining bean){
			Map map=new HashMap();

			if(bean.getDirectionid()!=null && bean.getDirectionid()!=""){
				String directionid=bean.getDirectionid();
				map.put("directionid", directionid);
			}
			
			//获取下拉列表的范围(eg:5000-8000)
			if(bean.getGradnumScope()!=null && bean.getGradnumScope()!=""  && "--请选择--".equals(bean.getGradnumScope())==false){
				String gradnumScope=bean.getGradnumScope();
				if(!gradnumScope.contains("以上")){
					Integer mingradnumScope=Integer.parseInt(gradnumScope.split("-")[0]);
					Integer maxgradnumScope=Integer.parseInt(gradnumScope.split("-")[1]);
					map.put("mingradnumScope", mingradnumScope);
					map.put("maxgradnumScope", maxgradnumScope);
				}else{
					gradnumScope=gradnumScope.replace("以上", "");
					map.put("gradnumScope", gradnumScope);
				}
			}
			
			//获取下拉列表的范围(eg:5000-8000)
			if(bean.getJuniornumScope()!=null && bean.getJuniornumScope()!=""  && "--请选择--".equals(bean.getJuniornumScope())==false){
				String juniornumScope=bean.getJuniornumScope();
				if(!juniornumScope.contains("以上")){
					Integer minjuniornumScope=Integer.parseInt(juniornumScope.split("-")[0]);
					Integer maxjuniornumScope=Integer.parseInt(juniornumScope.split("-")[1]);
					map.put("minjuniornumScope", minjuniornumScope);
					map.put("maxjuniornumScope", maxjuniornumScope);
				}else{
					juniornumScope=juniornumScope.replace("以上", "");
					map.put("juniornumScope", juniornumScope);
				}
			}
			
			//获取下拉列表的范围(eg:5000-8000)
			if(bean.getMidnumScope()!=null && bean.getMidnumScope()!=""  && "--请选择--".equals(bean.getMidnumScope())==false){
				String midnumScope=bean.getMidnumScope();
				if(!midnumScope.contains("以上")){
					Integer minmidnumScope=Integer.parseInt(midnumScope.split("-")[0]);
					Integer maxmidnumScope=Integer.parseInt(midnumScope.split("-")[1]);
					map.put("minmidnumScope", minmidnumScope);
					map.put("maxmidnumScope", maxmidnumScope);
				}else{
					midnumScope=midnumScope.replace("以上", "");
					map.put("midnumScope", midnumScope);
				}
			}
			
			
			//获取下拉列表的范围(eg:5000-8000)
			if(bean.getHighnumScope()!=null && bean.getHighnumScope()!=""  && "--请选择--".equals(bean.getHighnumScope())==false){
				String highnumScope=bean.getHighnumScope();
				if(!highnumScope.contains("以上")){
					Integer minhighnumScope=Integer.parseInt(highnumScope.split("-")[0]);
					Integer maxhighnumScope=Integer.parseInt(highnumScope.split("-")[1]);
					map.put("minhighnumScope", minhighnumScope);
					map.put("maxhighnumScope", maxhighnumScope);
				}else{
					highnumScope=highnumScope.replace("以上", "");
					map.put("highnumScope", highnumScope);
				}
			}
			
			
			//获取下拉列表的范围(eg:5000-8000)
			if(bean.getNogradenumScope()!=null && bean.getNogradenumScope()!=""  && "--请选择--".equals(bean.getNogradenumScope())==false){
				String nogradenumScope=bean.getNogradenumScope();
				if(!nogradenumScope.contains("以上")){
					Integer minnogradenumScope=Integer.parseInt(nogradenumScope.split("-")[0]);
					Integer maxnogradenumScope=Integer.parseInt(nogradenumScope.split("-")[1]);
					map.put("minnogradenumScope", minnogradenumScope);
					map.put("maxnogradenumScope", maxnogradenumScope);
				}else{
					nogradenumScope=nogradenumScope.replace("以上", "");
					map.put("nogradenumScope", nogradenumScope);
				}
			}
			
			
			//获取下拉列表的范围(eg:5000-8000)
			if(bean.getTrainingnumScope()!=null && bean.getTrainingnumScope()!=""  && "--请选择--".equals(bean.getTrainingnumScope())==false){
				String trainingnumScope=bean.getTrainingnumScope();
				if(!trainingnumScope.contains("以上")){
					Integer mintrainingnumScope=Integer.parseInt(trainingnumScope.split("-")[0]);
					Integer maxtrainingnumScope=Integer.parseInt(trainingnumScope.split("-")[1]);
					map.put("mintrainingnumScope", mintrainingnumScope);
					map.put("maxtrainingnumScope", maxtrainingnumScope);
				}else{
					trainingnumScope=trainingnumScope.replace("以上", "");
					map.put("trainingnumScope", trainingnumScope);
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
			
		public QasDSkilltrainingMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDSkilltrainingMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDSkilltrainingMapper.class;
		}
}
