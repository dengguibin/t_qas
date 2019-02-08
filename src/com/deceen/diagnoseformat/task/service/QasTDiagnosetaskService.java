package	com.deceen.diagnoseformat.task.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deceen.diagnoseformat.task.mapper.QasTDiagnosetaskMapper;
import com.deceen.diagnoseformat.task.mapper.QasTDiagnosetaskdatesMapper;
import com.deceen.diagnoseformat.task.mapper.QasTDiagnosetasklevelMapper;
import com.deceen.diagnoseformat.task.mapper.QasTDiagnosetaskobjMapper;
import com.deceen.diagnoseformat.task.model.QasTDiagnosetask;
import com.deceen.diagnoseformat.task.model.QasTDiagnosetaskdates;
import com.deceen.diagnoseformat.task.model.QasTDiagnosetasklevel;
import com.deceen.diagnoseformat.task.model.QasTDiagnosetaskobj;
import com.deceen.diagnosereport.analy.job.DiagnosticJob;
import com.deceen.diagnosereport.analy.job.StartOrEndDiagnoseJon;
import com.deceen.system.major.mapper.QasDMajorMapper;
import com.deceen.system.major.model.QasDMajor;
import com.deceen.system.major.service.QasDMajorService;
import com.deceen.system.organization.service.QasEOrganizationService;
import com.deceen.utils.CronUtil;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;
import com.upath.plat.quartz.model.TCommonScheduling;
import com.upath.plat.quartz.service.TCommonSchedulingService;
/**
* 
* @ClassName: QasTDiagnosetaskAction.java
* @Description: qas_t_diagnosetask
* @author upaths@gmail.com  
* @date 2017-11-20 10:19:21
* @version V1.0   
*/
@SuppressWarnings({ "rawtypes", "unused" })
@Component("qasTDiagnosetaskService")	
public class QasTDiagnosetaskService  extends CommonService {
	@Autowired
	private QasTDiagnosetaskMapper diagnosetaskMapper;
	@Autowired
	private QasTDiagnosetasklevelMapper diagnosetasklevelMapper;
	@Autowired
	private QasTDiagnosetaskdatesMapper diagnosetaskdatesMapper;
	@Autowired
	private TCommonSchedulingService commonSchedulingService;
	@Autowired
	private QasTDiagnosetaskobjMapper diagnosetaskobjMapper;
	@Autowired
	private QasEOrganizationService organizationService;
	@Autowired
	private  QasDMajorService majorservice;
	@Autowired
	private QasDMajorMapper mapper;
 
	public QasTDiagnosetask select(Object id){
		return	diagnosetaskMapper.select(id);
	}
	
	public List<QasDMajor> getTree(QasTDiagnosetask gnosetask){
		return diagnosetaskMapper.listAll(gnosetask);
	}
	
	public List getdiagnosetaskzy(QasDMajor bean){
		return diagnosetaskMapper.listAllzy(bean);
	}
	
	
	public List<QasTDiagnosetaskobj> selectfind(String id){
		return	diagnosetaskobjMapper.selectfind(id);
	}
	
	public int insert(QasTDiagnosetask diagnosetask, List<QasTDiagnosetasklevel> diagnosetasklevels, QasTDiagnosetaskdates diagnosetaskdates,QasTDiagnosetaskobj diagnosetaskobj){
		diagnosetask.setId(IDGenerator.getUUID());
		diagnosetask.setIsmajor(1);
		diagnosetask.setPublishstatus(0);
		diagnosetaskMapper.insert(diagnosetask);
		
		for (int i=0;i<diagnosetasklevels.size();i++) {
			diagnosetasklevels.get(i).setId(IDGenerator.getUUID());
			diagnosetasklevels.get(i).setDiagnosetaskid(diagnosetask.getId());
			diagnosetasklevels.get(i).setSort(i);
		}
		diagnosetasklevelMapper.batchInsert(diagnosetasklevels);
		
		List<QasTDiagnosetaskobj> list=new ArrayList<QasTDiagnosetaskobj>();
		String ids=diagnosetaskobj.getDiagnoseobjid();
		String[] id=ids.split(",");
		for(String i:id){
			String objParentName=null;
			QasDMajor major=majorservice.selectinfo(i);
			String objParentId=majorservice.selectParentId(i);//根据对象id查询该对象的上级id
			if(objParentId!=null && objParentId!=""){
				objParentName=majorservice.selectParentName(i);//如果该对象的上级id存在，则根据对象id查询该对象的上级名称
			}else{
				objParentName="无父级";//如果该对象的上级id不存在，则自定义插入"无父级"
			}
			QasTDiagnosetaskobj diagnosetaskobjs=new QasTDiagnosetaskobj();
			diagnosetaskobjs.setId(IDGenerator.getUUID());
			diagnosetaskobjs.setDiagnosetaskid(diagnosetask.getId());
			diagnosetaskobjs.setDiagnoseobjid(i);
			diagnosetaskobjs.setDiagnoseobjname(major.getMajorname());
			//diagnosetaskobjs.setParentName(objParentName.getParentName());
			diagnosetaskobjs.setParentName(objParentName);
			//diagnosetaskobjs.setDiagnoseobjidtype(diagnosetaskobj.getDiagnoseobjidtype());
			//确定诊断对象的类型  分学院和专业
			/*if (major.getOrganizationid() != null && "0".equals(major.getOrganizationid())){
				diagnosetaskobjs.setDiagnoseobjidtype("2");
			}*/
			diagnosetaskobjs.setDiagnoseobjidtype(diagnosetaskobj.getDiagnoseobjidtype());
			list.add(diagnosetaskobjs);
		}
		diagnosetaskobjMapper.batchInsert(list);
		
//		diagnosetaskdates.setId(IDGenerator.getUUID());
//		diagnosetaskdates.setDiagnosetaskid(diagnosetask.getId());
//		diagnosetaskdates.setDiagnosefortime(getCron(diagnosetask.getFrequency()));
//		diagnosetaskdates.setDiagnosestatus(0);
//		diagnosetaskdatesMapper.insert(diagnosetaskdates);
		return	0;
	}
	
	public int update(QasTDiagnosetask bean){
		return diagnosetaskMapper.update(bean);
	}
	
	public int updateStatus(Map<String, Object> params){
		return diagnosetaskMapper.updateStatus(params);
	}
	public List<QasTDiagnosetaskobj> selectByTaskId(String id){
		return diagnosetaskobjMapper.selectByTaskId(id);
	}
	
	
	public List<QasTDiagnosetaskobj> selectByTaskIdToStatus(String id){
		return diagnosetaskobjMapper.selectByTaskIdToStatus(id);
	}
	
	/** 动态进行更新 */
	public int updateWithDyna(QasTDiagnosetask bean)throws Exception{		
		diagnosetaskMapper.updateWithDyna(bean);
		
		// 生成调度任务
		QasTDiagnosetask diagnosetask = diagnosetaskMapper.select(bean.getId());
		TCommonScheduling SchedulingTask = new TCommonScheduling();
		SchedulingTask.setCron(CronUtil.getCron(diagnosetask.getFrequency()));
//		SchedulingTask.setCron("0/5 * * * * ? ");
		SchedulingTask.setTaskid(IDGenerator.getUUID());
		SchedulingTask.setTaskname(diagnosetask.getTaskname());
		SchedulingTask.setJobclass((new DiagnosticJob()).getClass().toString().replaceFirst("class ", ""));
		SchedulingTask.setRuntimes(0);
		SchedulingTask.setType(2);//循环执行
		SchedulingTask.setStates("0");
		SchedulingTask.setParams(bean.getId());
		SchedulingTask.setIstmed(2);
		SchedulingTask.setCreator(diagnosetask.getUpdatedby());
		SchedulingTask.setCdate(new Date());
		commonSchedulingService.insert(SchedulingTask);
		
		//生成执行上面任务的调度任务
		TCommonScheduling schedulStart = new TCommonScheduling();
		JSONObject json = new JSONObject();
		BeanUtils.copyProperties( schedulStart,SchedulingTask);
		schedulStart.setTaskid(IDGenerator.getUUID());
		schedulStart.setTaskname("执行："+diagnosetask.getTaskname());
		schedulStart.setJobclass((new StartOrEndDiagnoseJon()).getClass().toString().replaceFirst("class ", ""));
		schedulStart.setStates("1");
		Date date = null;
		if(System.currentTimeMillis()>diagnosetask.getStarttime().getTime()){
			date = new Date();
		}else{
			date = diagnosetask.getStarttime();
		}
		schedulStart.setCron(CronUtil.getCron(date));
		json.put("taskId", SchedulingTask.getTaskid());
		json.put("taskName", diagnosetask.getTaskname());
		json.put("jobClass", (new StartOrEndDiagnoseJon()).getClass().toString().replaceFirst("class ", ""));
		json.put("cron", CronUtil.getCron(diagnosetask.getEndtime()));
		json.put("status", "0");
		schedulStart.setParams(json.toString());
		commonSchedulingService.insert(schedulStart);
		
		return 0;
	}
	
	/** 批量插入实现 */
	public int[] batchInsert(List list){
		return batchDelete(list, QasTDiagnosetaskMapper.class.getName()+".insert");
	}
	
	public List list(QasTDiagnosetask bean){
		return queryPageList(QasTDiagnosetaskMapper.class.getName()+".list", bean);
	}
	
	public List listNoPage(QasTDiagnosetask bean){
		return diagnosetaskMapper.list(bean);
	}
		
	public int delete(Object id){
		diagnosetasklevelMapper.delete(id);
		return 	diagnosetaskMapper.delete(id);
	};
	
	
	
	public int delete(Object[] ids){
		List list = Arrays.asList(ids);
		batchDelete(list, QasTDiagnosetaskMapper.class.getName()+".delete");
		return 0;
	}
	
	public Class getMapperClass(){
		return QasTDiagnosetaskMapper.class;
	}

	public QasTDiagnosetaskMapper getDiagnosetaskMapper() {
		return diagnosetaskMapper;
	}
	
	public List<QasTDiagnosetasklevel> selectLevels(String id) {
		return diagnosetasklevelMapper.select(id);
	}

	public QasTDiagnosetaskdates selectDatas(String id) {
		return diagnosetaskdatesMapper.select(id);
	}

	public void updateWithDyna(QasTDiagnosetask diagnosetask,
			List<QasTDiagnosetasklevel> diagnosetasklevels,
			QasTDiagnosetaskdates diagnosetaskdates, QasTDiagnosetaskobj diagnosetaskobj) {
		diagnosetaskMapper.updateWithDyna(diagnosetask);
		diagnosetaskobjMapper.delete(diagnosetask.getId());
		List<QasTDiagnosetaskobj> list=new ArrayList<QasTDiagnosetaskobj>();
		String ids=diagnosetaskobj.getDiagnoseobjid();
		String[] id=ids.split(",");
		for(String i:id){
			QasDMajor major=majorservice.selectinfo(i);
			QasTDiagnosetaskobj diagnosetaskobjs=new QasTDiagnosetaskobj();
			diagnosetaskobjs.setId(IDGenerator.getUUID());
			diagnosetaskobjs.setDiagnosetaskid(diagnosetask.getId());
			diagnosetaskobjs.setDiagnoseobjid(i);
			diagnosetaskobjs.setDiagnoseobjname(major.getMajorname());
			//确定诊断对象的类型  分学院和专业
			/*if (major.getOrganizationid()!= null && "0".equals(major.getOrganizationid())){
				diagnosetaskobjs.setDiagnoseobjidtype("1");
			}*/
			diagnosetaskobjs.setDiagnoseobjidtype(diagnosetaskobj.getDiagnoseobjidtype());
			list.add(diagnosetaskobjs);
		}
		diagnosetaskobjMapper.batchInsert(list);
		/*for (int i=0;i<diagnosetaskobj.size();i++) {
			diagnosetaskobj.get(i).setId(IDGenerator.getUUID());
			diagnosetaskobj.get(i).setDiagnoseobjid(diagnoseobjid)
		}*/
		//diagnosetaskdatesMapper.updateWithDyna(diagnosetaskdates);
		diagnosetasklevelMapper.delete(diagnosetask.getId());
		for (int i=0;i<diagnosetasklevels.size();i++) {
			diagnosetasklevels.get(i).setId(IDGenerator.getUUID());
			diagnosetasklevels.get(i).setDiagnosetaskid(diagnosetask.getId());
			diagnosetasklevels.get(i).setSort(i);
		}
		diagnosetasklevelMapper.batchInsert(diagnosetasklevels);
	}

	public List<QasTDiagnosetask> selectPublishTask(QasTDiagnosetask diagnosetask) {
		return diagnosetaskMapper.selectPublishTask(diagnosetask);
	}
	public int deleteTaskObj(Object id){
		return diagnosetaskobjMapper.delete(id);
	}
	
	public static void main(String[] args) {
		System.out.println((new StartOrEndDiagnoseJon()).getClass().toString().replaceFirst("class ", ""));
	}
}
