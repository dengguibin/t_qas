package	com.deceen.diagnosereport.reveal.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.upath.plat.auth.facade.IMenu;
import com.upath.plat.auth.model.TRmsMenuinfo;

@SuppressWarnings("rawtypes")
@Component("qasTDiagnosticmenuinfoMapper")
public interface QasTDiagnosticmenuinfoMapper {
	
	/**
	 * 根据诊断中介的id获取左侧菜单数据
	 * @param DIId	诊断中介的id
	 * @return
	 */
	List<IMenu> menuAnaly(Map<String,String> map);
	List<IMenu> menuAnalyTest(String DIId);

	TRmsMenuinfo select(Object id);
	
	int insert(TRmsMenuinfo bean);
	
	int update(TRmsMenuinfo bean);
	
	/**动态更新*/
	int updateWithDyna(TRmsMenuinfo bean);
	
	List  list(TRmsMenuinfo bean);
	
	List  listMenus(TRmsMenuinfo bean);
	
	int delete(Object id);
	
}

