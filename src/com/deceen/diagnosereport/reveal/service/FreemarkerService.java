package com.deceen.diagnosereport.reveal.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deceen.diagnosereport.analy.mapper.QasTDiagnosticreportMapper;
import com.deceen.diagnosereport.analy.model.QasTDiagnosticreport;
import com.deceen.diagnosereport.analy.service.QasTDiagnosticreportService;
import com.deceen.diagnosereport.reveal.model.AnalyGeneral;
import com.deceen.diagnosereport.reveal.model.ItemFruitPage;
import com.deceen.diagnosereport.reveal.model.QasTDiagnosticmenuinfo;
import com.deceen.mty.templet.model.TMtyTemplet;
import com.deceen.mty.templet.service.TMtyTempletService;
import com.deceen.mty.utils.YyhUtil;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.SystemConfig;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * 生成静态文件,自动挂菜单
 * @author YYH
 */
@Component("freemarkerService")
public class FreemarkerService extends CommonService {
	
	/**模板文件的根目录*/
	private static final String ROOTDIRF = SystemConfig.ANALY_FREEMARKER_ROOTDIRF;//E:/Analys/
	/**静态文件的根目录*/
	private static final String ROOTDIRH = SystemConfig.ANALY_FREEMARKER_ROOTDIRH;//E:/Analys/analy
	
	@Autowired
	private TMtyTempletService tMtyTempletService;
	
	@Autowired
	private QasTDiagnosticreportService qasTDiagnosticreportService;
	
	@Autowired
	private QasTDiagnosticmenuinfoService qasTDiagnosticmenuinfoService;
	
	@Autowired
	private QasTDiagnosticreportMapper diagnosticreportMapper;
	
	//声明全局时间变量
	private String stringTime=null;//时分秒 eg:10-57-47
	private String stringDate=null;//年月日 eg:2017/12/15
	
	//诊断任务id(作为文件夹名称)
	private String taskId=null;
	//诊断对象id(作为文件夹名称)
	private String objId=null;
	//项目详情的下拉列表为多个时，其路径所对应的后缀递增，初始值为1
	//10-57-47-itemAnalyTest1.html
	//10-57-47-itemAnalyTest2.html
	int mark=1;
	
	/**
	 * @param analyResult	分析结果
	 * @param diagnosticintermediary 
	 * @return	所有页面都创建成功返回true	否则返回false
	 * @throws TemplateException 
	 * @throws IOException 
	 */
	public boolean createHtml (AnalyGeneral analyResult, String diagnosticreportid,String mediaryId,String diagnosetaskobjid) throws IOException, TemplateException {
		boolean boo = true;
			//生成总体概述的静态页面，挂菜单
			createAnalyGeneral(analyResult, diagnosticreportid,mediaryId,diagnosetaskobjid);
		return boo;
	}
	
	//给全局时间变量初始化赋值方法
	public  void initTime(String diagnosticreportId) {
		QasTDiagnosticreport qasTDiagnosticreport=diagnosticreportMapper.selectById(diagnosticreportId);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		String time=sdf.format(qasTDiagnosticreport.getCreatedtime());
		/*SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=sdf.format(new Date());*/
	    stringTime=time.split(" ")[1].replace(":", "-");//返回时分秒 eg:10-57-47
	    stringDate=time.split(" ")[0].replace("-", "/");//返回年月日 eg:2017/12/15
	}
	
	
	/**
	 * 生成总体概述的静态页面，挂菜单
	 * @param analyResult				分析结果
	 * @param diagnosticintermediary	诊断中介
	 * @throws IOException
	 * @throws TemplateException
	 */
	@SuppressWarnings({"unchecked" })
	public void createAnalyGeneral(AnalyGeneral analyResult, String diagnosticreportid,String id,String diagnosetaskobjid) 
			throws IOException, TemplateException {
		
		//创建对象
		Configuration cft = new Configuration(Configuration.getVersion());
		
		//设置模板所在的根路径
		cft.setDirectoryForTemplateLoading(new File(ROOTDIRF));//E:/Analys
		
		//设置字符编码
		cft.setDefaultEncoding("UTF-8");
		
		//获取模板对象
		TMtyTemplet templet = tMtyTempletService.select("5C08E3ABC06F4E95B3E3E4AFC1A8D146");
		String path_relative = templet.getPath_relative();//tqas/analy/171211/analyGeneral.ftl
		Template template = cft.getTemplate(path_relative);
		
		//获取数据
//		AnalyGeneral analyGeneral = qasTDiagnosticreportService.getAnalyGeneral(diagnosetaskobj);

		//创建指标明细页面
		//diagnosticintermediary.setDiagnosticreportid(diagnosticreport.getId());
		//String time = YyhUtil.getNowTime(YyhUtil.TIME);//10-57-47(时分秒)
		//给全局时间变量初始化赋值 
		//this.initTime("0440CBC45437464985FB4D94AA38599B");
		this.initTime(diagnosticreportid);//10-57-47(时分秒)  年月日 eg:2017/12/15
		//Map<String, Object> map = new HashMap<String, Object>();
		//map.put("TIME",time);
//		map.put("DIAGNOSETASKOBJ", diagnosetaskobj);
		
		//诊断任务id(作为文件夹名称)
		taskId=diagnosetaskobjid;
		if(taskId==null){
			return;
		}
		//诊断对象id(作为文件夹名称)
		objId=diagnosetaskobjid;
		if(objId==null){
			return;
		}
		
		String indexDetail = createIndexDetail();//10-57-47-indexDetail.html
		analyResult.setIndexDetail(indexDetail);
		
		//创建根容器
		Map root = new HashMap();
		root.put("analyGeneral", analyResult);	//将项目分析结果的页面对象存入根容器
		
		//创建保存静态文件的文件夹
		String dateDirH = YyhUtil.mkdirs(ROOTDIRH+"/pages/",stringDate,taskId+"/"+objId);//2017/12/15/task00/obj/
		
		//创建HTML文件并绑定输出流
					//tqas/analy/171211/analyGeneral.ftl  //10-57-47(时分秒)
		String html = YyhUtil.ftlToHtml(path_relative, stringTime, "",1000000000);//10-57-47-analyGeneral.html
		String pathname = dateDirH + html;//存入数据库的值//2017/12/15/task00/obj/10-57-47-analyGeneral.html
		String fileH = ROOTDIRH+"/pages/" + pathname;//E:/Analys/analy/pages/2017/12/15/task00/obj/10-57-47-analyGeneral.html
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(fileH)),"UTF-8"));
		
		//生成静态页面
		template.process(root, writer);
		
		//关流释放资源
		writer.close();
		
		//挂菜单
		QasTDiagnosticmenuinfo menuinfo = new QasTDiagnosticmenuinfo();
		menuinfo.setCdid(null);
		menuinfo.setDiagnosticintermediaryid(id);
		menuinfo.setPcdid(300);
		menuinfo.setCdmc("总体概述");
		menuinfo.setCdcj(2);
		menuinfo.setPxh(1);
		menuinfo.setLjdz("/pages/"+pathname);
		menuinfo.setCdcs("/skins/uimaker/images/leftico41.png");
		menuinfo.setLjlx(1);
		qasTDiagnosticmenuinfoService.insert(menuinfo);
		
		QasTDiagnosticmenuinfo itemInfo = new QasTDiagnosticmenuinfo();
		//itemInfo.setCdid(1);// TODO 后期完善
		itemInfo.setCdid(null);// TODO 后期完善
		itemInfo.setDiagnosticintermediaryid(id);
		itemInfo.setPcdid(300);
		itemInfo.setCdmc("项目详情");
		itemInfo.setCdcj(2);
		itemInfo.setPxh(2);
		itemInfo.setLjdz(null);
		itemInfo.setCdcs("/skins/uimaker/images/leftico53.png");
		itemInfo.setLjlx(1);
		qasTDiagnosticmenuinfoService.insert(itemInfo);
		
		//循环创建每个项目的分析页面。
		List<ItemFruitPage> itemFruitPageList = analyResult.getItemFruitPageList();
		//所有类型
		//List<QasTSchemecatalog> list=analyResult.getList();
		
		for (ItemFruitPage itemFruitPage : itemFruitPageList) {
			createAnalyItem(itemFruitPage, itemInfo);
		}
	}
	
	/**
	 * 生成项目分析结果的静态页面，挂菜单
	 * @throws IOException
	 * @throws TemplateException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void createAnalyItem(ItemFruitPage itemFruitPage, QasTDiagnosticmenuinfo itemInfo) 
			throws IOException, TemplateException {
		//创建对象
		Configuration cft = new Configuration(Configuration.getVersion());
		
		//设置模板所在的根路径
		cft.setDirectoryForTemplateLoading(new File(ROOTDIRF));//E:/Analys
		
		//设置字符编码
		cft.setDefaultEncoding("UTF-8");
		
		//获取模板对象
		TMtyTemplet templet = tMtyTempletService.select("51840A618ACC43EBA876F3C6E916395F");
		String path_relative = templet.getPath_relative();//tqas/analy/171211/itemAnaly.ftl
		Template template = cft.getTemplate(path_relative);
		
		//获取数据
		//ItemFruitPage ifp = qasTDiagnosticreportService.getItemFruitPage(scheme, diagnosetaskobj);

		//创建根容器
		Map root = new HashMap();
		root.put("itemFruitPage", itemFruitPage);	//将项目分析结果的页面对象存入根容器
		
		String type=itemFruitPage.getItemAnaly().getSchemecatalogId();//该项目的类型id
		
		//创建保存静态文件的文件夹
		String dateDirH = YyhUtil.mkdirs(ROOTDIRH+"/pages/",stringDate,taskId+"/"+objId+"/"+type);//2017/12/15/task00/obj/type/
		
		//创建HTML文件并绑定输出流
		//String html = YyhUtil.ftlToHtml(path_relative, stringTime, "Test",mark);//10-57-47-itemAnalyTest.html
		String html = YyhUtil.ftlToHtml(path_relative, stringTime, "",mark);//10-57-47-itemAnalyTest.html
		String pathname = dateDirH + html;//存入数据库的值//2017/12/15/task00/obj/type/10-57-47-itemAnalyTest.html
		String fileH = ROOTDIRH+"/pages/" + pathname;//E:/Analys/analy/pages/2017/12/15/task00/obj/type/10-57-47-itemAnalyTest.html
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(fileH)),"UTF-8"));
		
		//生成静态页面
		template.process(root, writer);
		
		//关流释放资源
		writer.close();
		
		//挂菜单
		QasTDiagnosticmenuinfo menuinfo = new QasTDiagnosticmenuinfo();
		menuinfo.setCdid(null);
		//menuinfo.setDiagnosticintermediaryid("3");
		menuinfo.setDiagnosticintermediaryid(itemInfo.getDiagnosticintermediaryid());
		menuinfo.setPcdid(itemInfo.getCdid());
		menuinfo.setCdmc(itemFruitPage.getItemAnaly().getName());
		menuinfo.setCdcj(3);
		menuinfo.setPxh(3);
		menuinfo.setLjdz("/pages/"+pathname);
		menuinfo.setLjlx(1);
		qasTDiagnosticmenuinfoService.insert(menuinfo);
		mark++;
	}
	
	/**
	 * 创建指标明细页面
	 * @param icl
	 * @param map	(TIME:总体概述页面的生成时间)
	 * @return
	 * @throws IOException
	 * @throws TemplateException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String createIndexDetail() throws IOException, TemplateException {
		
		//创建对象
		Configuration cft = new Configuration(Configuration.getVersion());
		
		//设置模板所在的根路径
		cft.setDirectoryForTemplateLoading(new File(ROOTDIRF));//E:/Analys
		
		//设置字符编码
		cft.setDefaultEncoding("UTF-8");
		
		//获取模板对象
		TMtyTemplet templet = tMtyTempletService.select("E0B9A07855074369B1A21DE6B4928645");
		String path_relative = templet.getPath_relative();//tqas/analy/171211/indexDetail.ftl
		Template template = cft.getTemplate(path_relative);
		
		//获取数据
//		ItemFruitPage ifp = qasTDiagnosticreportService.getItemFruitPage(icl, obj);
		
		//创建根容器
		Map root = new HashMap();
		root.put("itemFruitPage", null);	//将项目分析结果的页面对象存入根容器
		
		//创建保存静态文件的文件夹
		String dateDirH = YyhUtil.mkdirs(ROOTDIRH+"/pages/",stringDate,taskId+"/"+objId);//2017/12/15/task00/obj/

		//创建HTML文件并绑定输出流
								//tqas/analy/171211/indexDetail.ftl  //10-57-47(时分秒) //""
		String html = YyhUtil.ftlToHtml(path_relative,stringTime, "",1000000000);//10-57-47-indexDetail.html
		String pathname = dateDirH + html;//存入数据库的值//2017/12/15/task00/obj/10-57-47-indexDetail.html
		String fileH = ROOTDIRH+"/pages/" + pathname;//E:/Analys/analy/pages/2017/12/15/task00/obj/10-57-47-indexDetail.html
		
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(fileH)),"UTF-8"));
		
		//生成静态页面
		template.process(root, writer);
		
		//关流释放资源
		writer.close();
		
		return html;
	}
}
