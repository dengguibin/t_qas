package	com.deceen.data.school.rooms.service;

import java.util.*;
import com.deceen.data.school.rooms.model.QasDRooms;
import com.deceen.data.school.rooms.mapper.QasDRoomsMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDRoomsAction.java
* @Description: qas_d_rooms
* @author upaths@gmail.com  
* @date 2017-11-22 17:45:25
* @version V1.0   
*/
@Component("qasDRoomsService")	
@SuppressWarnings({ "rawtypes" })
public class QasDRoomsService  extends CommonService {

		private QasDRoomsMapper mapper;
	
		public QasDRooms select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDRooms  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			
			return	mapper.insert(bean);
		}
		
		public int update(QasDRooms bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */  
		public int updateWithDyna(QasDRooms bean){
		bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		/** 批量插入 */
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDRoomsMapper.class.getName()+".insert");
		}
		
		public List list(Map map){
			return queryPageList(QasDRoomsMapper.class.getName()+".list", map);
		}

		public List list(QasDRooms bean){
			Map map=new HashMap();
			//获取下拉列表的范围(eg:5000-8000)
			if(bean.getNumofreadingroomseatScope()!=null && bean.getNumofreadingroomseatScope()!=""  && "--请选择--".equals(bean.getNumofreadingroomseatScope())==false){
				String numofreadingroomseatScope=bean.getNumofreadingroomseatScope();
				if(!numofreadingroomseatScope.contains("以上")){
					Integer minnumofreadingroomseatScope=Integer.parseInt(numofreadingroomseatScope.split("-")[0]);
					Integer maxnumofreadingroomseatScope=Integer.parseInt(numofreadingroomseatScope.split("-")[1]);
					map.put("minnumofreadingroomseatScope", minnumofreadingroomseatScope);
					map.put("maxnumofreadingroomseatScope", maxnumofreadingroomseatScope);
				}else{
					numofreadingroomseatScope=numofreadingroomseatScope.replace("以上", "");
					map.put("numofreadingroomseatScope", numofreadingroomseatScope);
				}
			}
			
			if(bean.getNumofcomputerScope()!=null && bean.getNumofcomputerScope()!=""  && "--请选择--".equals(bean.getNumofcomputerScope())==false){
				String numofcomputerScope=bean.getNumofcomputerScope();
				if(!numofcomputerScope.contains("以上")){
					Integer minnumofcomputerScope=Integer.parseInt(numofcomputerScope.split("-")[0]);
					Integer maxnumofcomputerScope=Integer.parseInt(numofcomputerScope.split("-")[1]);
					map.put("minnumofcomputerScope", minnumofcomputerScope);
					map.put("maxnumofcomputerScope", maxnumofcomputerScope);
				}else{
					numofcomputerScope=numofcomputerScope.replace("以上", "");
					map.put("numofcomputerScope", numofcomputerScope);
				}
			}
			
			if(bean.getNumofteachingcomputerScope()!=null && bean.getNumofteachingcomputerScope()!=""  && "--请选择--".equals(bean.getNumofteachingcomputerScope())==false){
				String numofteachingcomputerScope=bean.getNumofteachingcomputerScope();
				if(!numofteachingcomputerScope.contains("以上")){
					Integer minnumofteachingcomputerScope=Integer.parseInt(numofteachingcomputerScope.split("-")[0]);
					Integer maxnumofteachingcomputerScope=Integer.parseInt(numofteachingcomputerScope.split("-")[1]);
					map.put("minnumofteachingcomputerScope", minnumofteachingcomputerScope);
					map.put("maxnumofteachingcomputerScope", maxnumofteachingcomputerScope);
				}else{
					numofteachingcomputerScope=numofteachingcomputerScope.replace("以上", "");
					map.put("numofteachingcomputerScope", numofteachingcomputerScope);
				}
			}
			
			if(bean.getNumofteachingpadScope()!=null && bean.getNumofteachingpadScope()!=""  && "--请选择--".equals(bean.getNumofteachingpadScope())==false){
				String numofteachingpadScope=bean.getNumofteachingpadScope();
				if(!numofteachingpadScope.contains("以上")){
					Integer minnumofteachingpadScope=Integer.parseInt(numofteachingpadScope.split("-")[0]);
					Integer maxnumofteachingpadScope=Integer.parseInt(numofteachingpadScope.split("-")[1]);
					map.put("minnumofteachingpadScope", minnumofteachingpadScope);
					map.put("maxnumofteachingpadScope", maxnumofteachingpadScope);
				}else{
					numofteachingpadScope=numofteachingpadScope.replace("以上", "");
					map.put("numofteachingpadScope", numofteachingpadScope);
				}
			}
			
			if(bean.getNumofpubliccomputerroomScope()!=null && bean.getNumofpubliccomputerroomScope()!=""  && "--请选择--".equals(bean.getNumofpubliccomputerroomScope())==false){
				String numofpubliccomputerroomScope=bean.getNumofpubliccomputerroomScope();
				if(!numofpubliccomputerroomScope.contains("以上")){
					Integer minnumofpubliccomputerroomScope=Integer.parseInt(numofpubliccomputerroomScope.split("-")[0]);
					Integer maxnumofpubliccomputerroomScope=Integer.parseInt(numofpubliccomputerroomScope.split("-")[1]);
					map.put("minnumofpubliccomputerroomScope", minnumofpubliccomputerroomScope);
					map.put("maxnumofpubliccomputerroomScope", maxnumofpubliccomputerroomScope);
				}else{
					numofpubliccomputerroomScope=numofpubliccomputerroomScope.replace("以上", "");
					map.put("numofpubliccomputerroomScope", numofpubliccomputerroomScope);
				}
			}

			if(bean.getNumofspecialcomputerroomScope()!=null && bean.getNumofspecialcomputerroomScope()!=""  && "--请选择--".equals(bean.getNumofspecialcomputerroomScope())==false){
				String numofspecialcomputerroomScope=bean.getNumofspecialcomputerroomScope();
				if(!numofspecialcomputerroomScope.contains("以上")){
					Integer minnumofspecialcomputerroomScope=Integer.parseInt(numofspecialcomputerroomScope.split("-")[0]);
					Integer maxnumofspecialcomputerroomScope=Integer.parseInt(numofspecialcomputerroomScope.split("-")[1]);
					map.put("minnumofspecialcomputerroomScope", minnumofspecialcomputerroomScope);
					map.put("maxnumofspecialcomputerroomScope", maxnumofspecialcomputerroomScope);
				}else{
					numofspecialcomputerroomScope=numofspecialcomputerroomScope.replace("以上", "");
					map.put("numofspecialcomputerroomScope", numofspecialcomputerroomScope);
				}
			}
			
			if(bean.getNumofclassroomScope()!=null && bean.getNumofclassroomScope()!=""  && "--请选择--".equals(bean.getNumofclassroomScope())==false){
				String numofclassroomScope=bean.getNumofclassroomScope();
				if(!numofclassroomScope.contains("以上")){
					Integer minnumofclassroomScope=Integer.parseInt(numofclassroomScope.split("-")[0]);
					Integer maxnumofclassroomScope=Integer.parseInt(numofclassroomScope.split("-")[1]);
					map.put("minnumofclassroomScope", minnumofclassroomScope);
					map.put("maxnumofclassroomScope", maxnumofclassroomScope);
				}else{
					numofclassroomScope=numofclassroomScope.replace("以上", "");
					map.put("numofclassroomScope", numofclassroomScope);
				}
			}
			
			if(bean.getNumofmediaroomScope()!=null && bean.getNumofmediaroomScope()!=""  && "--请选择--".equals(bean.getNumofmediaroomScope())==false){
				String numofmediaroomScope=bean.getNumofmediaroomScope();
				if(!numofmediaroomScope.contains("以上")){
					Integer minnumofmediaroomScope=Integer.parseInt(numofmediaroomScope.split("-")[0]);
					Integer maxnumofmediaroomScope=Integer.parseInt(numofmediaroomScope.split("-")[1]);
					map.put("minnumofmediaroomScope", minnumofmediaroomScope);
					map.put("maxnumofmediaroomScope", maxnumofmediaroomScope);
				}else{
					numofmediaroomScope=numofmediaroomScope.replace("以上", "");
					map.put("numofmediaroomScope", numofmediaroomScope);
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
			
		public QasDRoomsMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDRoomsMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDRoomsMapper.class;
		}
}
