package	com.deceen.data.school.areaOfStructure.service;

import java.util.*;
import com.deceen.data.school.areaOfStructure.model.QasDAreaofstructure;
import com.deceen.data.school.areaOfStructure.mapper.QasDAreaofstructureMapper;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
* 
* @ClassName: QasDAreaofstructureAction.java
* @Description: qas_d_areaofstructure
* @author upaths@gmail.com  
* @date 2017-11-22 17:44:17
* @version V1.0   
*/
@SuppressWarnings("rawtypes")
@Component("qasDAreaofstructureService")	
public class QasDAreaofstructureService  extends CommonService {

	private QasDAreaofstructureMapper mapper;

	public QasDAreaofstructure select(Object id){
		return	mapper.select(id);
	}
	
	public int insert(QasDAreaofstructure  bean){
		bean.setId(IDGenerator.getUUID());
		bean.setCreatedtime(new Date());
		return	mapper.insert(bean);
	}
	
	public int update(QasDAreaofstructure bean){
		bean.setUpdatedtime(new Date());
		return mapper.update(bean);
	}
	
	/** 动态进行更新*/
	public int updateWithDyna(QasDAreaofstructure bean){
		bean.setUpdatedtime(new Date());
		return mapper.updateWithDyna(bean);
	}
	
	/** 批量插入实现*/
	public int[] batchInsert(List list){
		
		return batchDelete(list, QasDAreaofstructureMapper.class.getName()+".insert");
	}
	
	public List list(Map map){
		return queryPageList(QasDAreaofstructureMapper.class.getName()+".list", map);
	}
	
	
	public List list(QasDAreaofstructure bean){
		Map map=new HashMap();
		//获取下拉列表的范围(eg:5000-8000)
		if(bean.getAreacoveredScope()!=null && bean.getAreacoveredScope()!=""  && "--请选择--".equals(bean.getAreacoveredScope())==false){
			String areacoveredScope=bean.getAreacoveredScope();
			if(!areacoveredScope.contains("以上")){
				Integer minareacoveredScope=Integer.parseInt(areacoveredScope.split("-")[0]);
				Integer maxareacoveredScope=Integer.parseInt(areacoveredScope.split("-")[1]);
				map.put("minareacoveredScope", minareacoveredScope);
				map.put("maxareacoveredScope", maxareacoveredScope);
			}else{
				areacoveredScope=areacoveredScope.replace("以上", "");
				map.put("areacoveredScope", areacoveredScope);
			}
		}
		if(bean.getOfficeScope()!=null && bean.getOfficeScope()!=""  && "--请选择--".equals(bean.getOfficeScope())==false){
			String officeScope=bean.getOfficeScope();
			if(!officeScope.contains("以上")){
				Integer minofficeScope=Integer.parseInt(officeScope.split("-")[0]);
				Integer maxofficeScope=Integer.parseInt(officeScope.split("-")[1]);
				map.put("minofficeScope", minofficeScope);
				map.put("maxofficeScope", maxofficeScope);
			}else{
				officeScope=officeScope.replace("以上", "");
				map.put("officeScope", officeScope);
			}
		}
		if(bean.getLivingroomScope()!=null && bean.getLivingroomScope()!=""  && "--请选择--".equals(bean.getLivingroomScope())==false){
			String livingroomScope=bean.getLivingroomScope();
			if(!livingroomScope.contains("以上")){
				Integer minlivingroomScope=Integer.parseInt(livingroomScope.split("-")[0]);
				Integer maxlivingroomScope=Integer.parseInt(livingroomScope.split("-")[1]);
				map.put("minlivingroomScope", minlivingroomScope);
				map.put("maxlivingroomScope", maxlivingroomScope);
			}else{
				livingroomScope=livingroomScope.replace("以上", "");
				map.put("livingroomScope", livingroomScope);
			}
		}
		return this.list(map);
	}
		
	public int delete(Object id){
		return 	mapper.delete(id);
	}
	
	public int delete(Object[] ids){
		return mapper.batchDelete(ids);
	}
		
	public QasDAreaofstructureMapper getMapper() {
		return mapper;
	}
	
	@Autowired
	public void setMapper(QasDAreaofstructureMapper mapper) {
		this.mapper = mapper;
	}
	
	public Class getMapperClass(){
		return QasDAreaofstructureMapper.class;
	}
}
