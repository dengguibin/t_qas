package	com.deceen.diagnosereport.reveal.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deceen.diagnosereport.reveal.mapper.QasTDiagnosticmenuinfoMapper;
import com.upath.plat.auth.facade.IMenu;
import com.upath.plat.auth.model.TRmsMenuinfo;
import com.upath.plat.common.service.CommonService;
/**
* 
* @ClassName: QasTDiagnosticmenuinfoAction.java
* @Description: qas_t_diagnosticmenuinfo
* @author upaths@gmail.com  
* @date 2017-12-6 15:05:13
* @version V1.0   
*/
@SuppressWarnings("rawtypes")
@Component("qasTDiagnosticmenuinfoService")	
public class QasTDiagnosticmenuinfoService  extends CommonService {

	private QasTDiagnosticmenuinfoMapper mapper;
	
	/**
	 * 根据诊断中介的id获取左侧菜单数据
	 * @param DIId	诊断中介的id
	 * @return
	 */
	public List<IMenu> menuAnaly(Map<String,String> map) {
		List<IMenu> list = mapper.menuAnaly(map);
		if (null == list || list.size() == 0) {
			list = mapper.menuAnalyTest("2");
		}
		return list;
	}

	public TRmsMenuinfo select(Object id){
		return	mapper.select(id);
	}
	
	public int insert(TRmsMenuinfo bean){
		return	mapper.insert(bean);
	}
	
	public int update(TRmsMenuinfo bean){
		return mapper.update(bean);
	}
	
	/**动态进行更新*/
	public int updateWithDyna(TRmsMenuinfo bean){
		return mapper.updateWithDyna(bean);
	}
	
	/**批量插入实现*/
	public int[] batchInsert(List list){
		return batchDelete(list, QasTDiagnosticmenuinfoMapper.class.getName()+".insert");
	}
	
	public List list(TRmsMenuinfo bean){
		return queryPageList(QasTDiagnosticmenuinfoMapper.class.getName()+".list", bean);
	}
		
	public int delete(Object id){
		return 	mapper.delete(id);
	}
	
	public int delete(Object[] ids){
		List list = Arrays.asList(ids);
		batchDelete(list, QasTDiagnosticmenuinfoMapper.class.getName()+".delete");
		return 0;
	}
		
	public QasTDiagnosticmenuinfoMapper getMapper() {
		return mapper;
	}
	
	@Autowired
	public void setMapper(QasTDiagnosticmenuinfoMapper mapper) {
		this.mapper = mapper;
	}
	
	public Class getMapperClass(){
		return QasTDiagnosticmenuinfoMapper.class;
	}
}
