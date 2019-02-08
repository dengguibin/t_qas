package	com.deceen.diagnosereport.analy.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.deceen.diagnoseformat.task.model.QasTDiagnosetaskobj;
import com.deceen.diagnosereport.analy.model.QasTDiagnosticreport;
import com.deceen.diagnosereport.dengguibin.QasTDiagnosticreportService3;
import com.deceen.diagnosereport.dengguibin.QasTDiagnosticreportService4;
import com.deceen.utils.ResultMap;
import com.upath.plat.auth.facade.IUser;
import com.upath.plat.common.action.BaseActionSupport;
import com.upath.plat.common.util.IDGenerator;
import com.upath.plat.quartz.service.TCommonSchedulingService;

/**
* @ClassName: QasTDiagnosticreportAction.java
* @Description: qas_t_diagnosticreport
* @author upaths@gmail.com  
* @date2017-12-8 14:21:30
* @version V1.0   
*/
@Scope("prototype")
@Component("qasTDiagnosticreportAction")
@SuppressWarnings({ "rawtypes", "serial","unused" })
public class QasTDiagnosticreportAction  extends BaseActionSupport{

	private static final Logger log = Logger.getLogger(QasTDiagnosticreportAction.class);

	@Autowired
	private TCommonSchedulingService commonSchedulingService;
	
	@Autowired
	private QasTDiagnosticreportService4 diagnosticreportService;
	
	private QasTDiagnosticreport diagnosticreport;
	
	private List datas;
	
	
	
	
	public void getDiagnoseObj() throws Exception{
		ResultMap result = new ResultMap();
		String diagnosetaskid = request.getParameter("diagnosetaskid");
		List<QasTDiagnosetaskobj> list = new ArrayList<QasTDiagnosetaskobj>();
		list = diagnosticreportService.selectDisgnoseObj(diagnosetaskid);
		
		for(QasTDiagnosetaskobj diagnosetaskobj:list){
			if(diagnosetaskobj.getId()!=null&&diagnosetaskobj.getId()!=""){
				result.put(diagnosetaskobj.getId(), diagnosetaskobj);
			}
		}
		response.setContentType("text/json; charset=UTF-8");
		response.getWriter().print(result.getJsonStr());
	}
	
	
	/*ResultMap result = new ResultMap();
	String diagnosetaskid = request.getParameter("diagnosetaskid");
	List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
	diagnosticreport = new QasTDiagnosticreport();
	diagnosticreport.setDiagnosedatatime(diagnosedatatime);
	diagnosticreport.setDiagnosetaskid(diagnosetaskid);
	list = diagnosticreportService.selectDisgnoseObj(diagnosticreport);
	for(Map<String,Object> m:list){
		if(m.get("ID")!=null&&m.get("ID")!=""){
			result.put((String)m.get("ID"), m);
		}
	}
	response.setContentType("text/json; charset=UTF-8");
	response.getWriter().print(result.getJsonStr());*/
	
	
	
	
	
	public void excuteAnaly() throws Exception{
		ResultMap result = new ResultMap();
		result.setMsg("诊断成功");
		String taskId = request.getParameter("taskId");
		String objId = request.getParameter("objId");
		if(taskId==null || taskId==""){
			return;
		}
		IUser user = getLoginUser();
		//生成诊断报告
		QasTDiagnosticreport diagnosticreport = new QasTDiagnosticreport();
		diagnosticreport.setId(IDGenerator.getUUID());
		diagnosticreport.setDiagnosetaskid(taskId);
		diagnosticreport.setDiagnoseway(1);//手动诊断方式1，自动诊断方式2
		diagnosticreport.setCreatedby(user.getUserId());
		diagnosticreport.setCreatedtime(new Date());
		diagnosticreport.setDiagnosedatatime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(diagnosticreport.getCreatedtime()));
		
		
		boolean b = false;
		try {
			
			/*private QasTDiagnosticreportServiceNew diagnosticreportService;
			private QasTDiagnosticreportService diagnosticreportService;*/
			b = diagnosticreportService.excuteAnaly(diagnosticreport, null);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMsg("诊断过程出现异常！请联系管理员");
			e.printStackTrace();
		}
		if(!b){
			result.setSuccess(false);
			result.setMsg("诊断过程出现异常！请联系管理员");
		}
		response.setContentType("text/json; charset=UTF-8");
		response.getWriter().print(result.getJsonStr());
	}
	
	// 查询单条记录信息
	public String queryInfo() throws Exception {
		ResultMap result = new ResultMap();
		String diagnosetaskid = request.getParameter("diagnosetaskid");
		if(diagnosetaskid==null || diagnosetaskid==""){
			return null;
		}
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		diagnosticreport = new QasTDiagnosticreport();
		diagnosticreport.setDiagnosetaskid(diagnosetaskid);
		list = diagnosticreportService.select(diagnosticreport);
		result.setObj(list);
		response.setContentType("text/json; charset=UTF-8");
		response.getWriter().print(result.getJsonStr());
		return null;
	}
	
	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}

	
	
	

	//导出报告
	public void getDiagnoseReport() throws Exception{
		ResultMap result = new ResultMap();
		
		HashMap<String,String> reportMap = new HashMap<String, String>();
		String taskId = request.getParameter("taskId");
		String datetime = request.getParameter("datetime");
		String objName = request.getParameter("objName");
		
		//SELECT * from qas_t_diagnosticreport  where DiagnoseTaskId = 'A569DDB7F6954E1F8EC987521816B6B9' AND DiagnoseDataTime ='2018-04-13 15:25:24';

		//SELECT * from qas_t_diagnosticintermediary;  DiagnosticObjName = '汽车检测与维修技术'
		
		//String taskId = "A569DDB7F6954E1F8EC987521816B6B9";
		//String datetime = "2018-04-13 15:25:24";
		//String objName = "汽车检测与维修技术";
		reportMap.put("taskId", taskId);
		reportMap.put("datetime", datetime);
		reportMap.put("objName", objName);
		
		String selectBytaskId = diagnosticreportService.selectBytaskId(reportMap);
		
		result.setObj(selectBytaskId);
		response.setContentType("text/json; charset=UTF-8");
		response.getWriter().print(result.getJsonStr());
		
	
		System.out.println("diagnosetaskid111::"+taskId);
		//E:/Analys/analy/pages/2018/06/11/task-29FDD3B86F784BE3AC736BCCDF620DA9/obj-12312312312444/16-12-58/20180611161302种植专业诊断报告.doc
		System.out.println("datetime::"+datetime);
		System.out.println("datetime::"+objName);
		System.out.println("selectBytaskId::"+selectBytaskId);
	
		
	}
	

}
