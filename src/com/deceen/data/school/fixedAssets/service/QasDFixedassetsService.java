package	com.deceen.data.school.fixedAssets.service;

import java.util.*;
import com.deceen.data.school.fixedAssets.model.QasDFixedassets;
import com.deceen.data.school.fixedAssets.mapper.QasDFixedassetsMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDFixedassetsAction.java
* @Description: qas_d_fixedassets
* @author upaths@gmail.com  
* @date 2017-11-22 17:47:30
* @version V1.0   
*/
@Component("qasDFixedassetsService")	
@SuppressWarnings({ "rawtypes" })
public class QasDFixedassetsService  extends CommonService {

		private QasDFixedassetsMapper mapper;
	
		public QasDFixedassets select(Object id){
			return	mapper.select(id);
		}
		
		public int insert(QasDFixedassets  bean){
			bean.setId(IDGenerator.getUUID());
			bean.setCreatedtime(new Date());
			return	mapper.insert(bean);
		}
		
		public int update(QasDFixedassets bean){
			bean.setUpdatedtime(new Date());
			return mapper.update(bean);
		}
		
		/** 动态进行更新 */  
		public int updateWithDyna(QasDFixedassets bean){
			bean.setUpdatedtime(new Date());
			return mapper.updateWithDyna(bean);
		}
		 /** 批量插入 */
		public int[] batchInsert(List list){
			
			return batchDelete(list, QasDFixedassetsMapper.class.getName()+".insert");
		}
		
		public List list(Map map){
			return queryPageList(QasDFixedassetsMapper.class.getName()+".list", map);
		}
		
		public List list(QasDFixedassets bean){
			Map map=new HashMap();
			//获取下拉列表的范围(eg:5000-8000)
			if(bean.getValueoffixedassetScope()!=null && bean.getValueoffixedassetScope()!=""  && "--请选择--".equals(bean.getValueoffixedassetScope())==false){
				String valueoffixedassetScope=bean.getValueoffixedassetScope();
				if(!valueoffixedassetScope.contains("以上")){
				Integer minvalueoffixedassetScope=Integer.parseInt(valueoffixedassetScope.split("-")[0]);
				Integer maxvalueoffixedassetScope=Integer.parseInt(valueoffixedassetScope.split("-")[1]);
				map.put("minvalueoffixedassetScope", minvalueoffixedassetScope);
				map.put("maxvalueoffixedassetScope", maxvalueoffixedassetScope);
				}else{
					valueoffixedassetScope=valueoffixedassetScope.replace("以上", "");
					map.put("valueoffixedassetScope", valueoffixedassetScope);
				}
			}
			if(bean.getValueofresearchequipmentScope()!=null && bean.getValueofresearchequipmentScope()!=""  && "--请选择--".equals(bean.getValueofresearchequipmentScope())==false){
				String valueofresearchequipmentScope=bean.getValueofresearchequipmentScope();
				if(!valueofresearchequipmentScope.contains("以上")){
				Integer minvalueofresearchequipmentScope=Integer.parseInt(valueofresearchequipmentScope.split("-")[0]);
				Integer maxvalueofresearchequipmentScope=Integer.parseInt(valueofresearchequipmentScope.split("-")[1]);
				map.put("minvalueofresearchequipmentScope", minvalueofresearchequipmentScope);
				map.put("maxvalueofresearchequipmentScope", maxvalueofresearchequipmentScope);
				}else{
					valueofresearchequipmentScope=valueofresearchequipmentScope.replace("以上", "");
					map.put("valueofresearchequipmentScope", valueofresearchequipmentScope);
				}
			}
			if(bean.getValueofnewresearchequipmentScope()!=null && bean.getValueofnewresearchequipmentScope()!=""  && "--请选择--".equals(bean.getValueofnewresearchequipmentScope())==false){
				String valueofnewresearchequipmentScope=bean.getValueofnewresearchequipmentScope();
				if(!valueofnewresearchequipmentScope.contains("以上")){
				Integer minvalueofnewresearchequipmentScope=Integer.parseInt(valueofnewresearchequipmentScope.split("-")[0]);
				Integer maxvalueofnewresearchequipmentScope=Integer.parseInt(valueofnewresearchequipmentScope.split("-")[1]);
				map.put("minvalueofnewresearchequipmentScope", minvalueofnewresearchequipmentScope);
				map.put("maxvalueofnewresearchequipmentScope", maxvalueofnewresearchequipmentScope);
				}else{
					valueofnewresearchequipmentScope=valueofnewresearchequipmentScope.replace("以上", "");
					map.put("valueofnewresearchequipmentScope", valueofnewresearchequipmentScope);
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
			
		public QasDFixedassetsMapper getMapper() {
			return mapper;
		}
		
		@Autowired
		public void setMapper(QasDFixedassetsMapper mapper) {
			this.mapper = mapper;
		}
		
		public Class getMapperClass(){
			return QasDFixedassetsMapper.class;
		}
}
