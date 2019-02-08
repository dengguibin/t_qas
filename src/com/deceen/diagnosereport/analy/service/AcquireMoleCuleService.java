package com.deceen.diagnosereport.analy.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


import com.deceen.diagnoseformat.scheme.model.QasTSchemecatalog;
import com.deceen.diagnoseformat.task.model.QasTDiagnosetaskobj;
import com.deceen.diagnosereport.reveal.model.map2class.TableMap2Class;
import com.deceen.diagnosereport.reveal.model.molecule.Molecule;
import com.deceen.diagnosereport.reveal.model.molecule.general.ItemGeneral;
import com.deceen.indicator.indicatorcatalogextend.mapper.QasTIndicatorcatalogextendMapper;
import com.deceen.indicator.indicatorcatalogextend.model.QasTIndicatorcatalogextend;
import com.deceen.indicator.indicatorcontent.mapper.QasTIndicatorcontentMapper;
import com.deceen.indicator.indicatorcontent.model.QasTIndicatorcontent;
import com.deceen.utils.Dateutils;
import com.upath.plat.common.util.PlatUtil;


/**
* 获取统计结果
 * 1. 设置molecule的值   molecule
 * 2. 计算分数返回		score
 * 
 * 
 * 原来对应 QasTDiagnosticreportServiceNew-getMolecule()
 * @param 
 * 
 * @return 
 * @author dengguibin
 */
public class AcquireMoleCuleService {
	
	//构造器注入的参数
	QasTIndicatorcontent indicatorcontent ;//指标内容，关键是sqlstring
	QasTSchemecatalog schemecatalog ;// 模型指标关联-指标
	QasTDiagnosetaskobj diagnosetaskobj ;
	ItemGeneral itemGeneral ;
	Molecule molecule ;//需要被设置改变的对象
	
	

	private float score;//需要返回给外界的分数
	//临时参数
	private String echartData = "[";// molecule数据
	private String indicatorName = null;// 毕业生的教学满意度
	private QasTIndicatorcatalogextend indicatorcatalogextend;
	private Long mark = null;// 对于数值型指标而言，1代表双柱状图（复杂柱状图），2代表单柱状图（简单柱状图）
	private List<HashMap<String, Object>> list;
	
	
	
	
	/**
	 * 开始执行整个流程
	 * 1.计算分数
	 * 2.设置molecule
	 * 
	 * * 方法调用 鸟瞰逻辑结构
	 * 
	 * if(dataList不为空){
	 * 		if(数值型){
	 * 			if(单柱状图){
	 * 				numericalSinglebar
	 * 			}else if(双柱状图){
	 * 				numericalDoublebar
	 * 			}
	 * 		}else if(判断型){
	 * 			judgmentChart
	 * 		}
	 * }else (dataList为空,做假数据){
	 * 		if(数值型){
	 * 			if(单柱状图){
	 * 				nullNumericalSinglebar
	 * 			}else if(双柱状图){
	 * 				nullNumericalDoublebar
	 * 			}
	 * 		}else if(判断型){
	 * 			nullJudgmentChart
	 * 		}
	 * }
	 * @param 
	 * 
	 * @return 
	 * @author dengguibin
	 */
	public void startExecute(){
		if(list.size() >= 0 && !list.isEmpty()){
			if(indicatorcontent.getIndicatordatatype() == 1){//数值型
				if(mark == 2){
					numericalSinglebar();
				}else if(mark == 1){
					numericalDoublebar();
				}
			}else if(indicatorcontent.getIndicatordatatype() == 2){//判断型
				judgmentChart();
			}
		}else if(list.size() == 0 || list.isEmpty()){//dataList为空,做假数据
			if(indicatorcontent.getIndicatordatatype() == 1){
				if(mark == 2){
					numericalSinglebar();
				}else if(mark == 1){
					numericalDoublebar();
				}
			}else if(indicatorcontent.getIndicatordatatype() == 2){
				nullJudgmentChart();
			}
		}
	}
	
	
	
	/**
	 * dataList不为空
	 * indicatorcontent.getIndicatordatatype() == 1 数值型
	 * mark == 2 单柱状图
	 * 
	 * 时候的处理方式,xxx原来就有，可以借鉴
	 * @param 
	 * 
	 * @return 
	 * @author dengguibin
	 */
	private void  numericalSinglebar(){
		float resultNum1 = getResultNum1();
		
		String sinpleDesc = getSinpleDesc();

		fillNumericalSinglebarValue(resultNum1, sinpleDesc);
	}
	
	/**
	 * 为numericalSinglebar（）服务，填充值
	 * @param 
	 * 
	 * @return 
	 * @author dengguibin
	 */
	private void fillNumericalSinglebarValue(float resultNum1,String sinpleDesc){
		// 随机数字k本应该是从数据库里查询出来的，建模时指定的合格标准数，有待完善
		float k = (float) (Math.random() * 1000);
		if (resultNum1 > k) {
			/** 随机数生成诊断分值 **/
			score = (int) (Math.random() * schemecatalog.getScore() / 2 + 50);
			/** 随机数生成诊断分值 **/
			molecule.setStateClass("sbox-t-q");
			itemGeneral.setQualifiedNum(itemGeneral.getQualifiedNum() + 1);
			molecule.setStateName("合格");
			molecule.setConclusion("该指标本次诊断结果合格！");
		} else if (resultNum1 < k) {
			/** 随机数生成诊断分值 **/
			score = (int) (Math.random() * schemecatalog.getScore() / 2);
			/** 随机数生成诊断分值 **/
			molecule.setStateClass("sbox-t-unq");
			itemGeneral.setUnqualifiedNum(itemGeneral.getUnqualifiedNum() + 1);
			molecule.setStateName("不合格");
			molecule.setConclusion(indicatorcatalogextend.getProblemoverview());
		}

		molecule.setType(Molecule.TYPE_ECHARTS);
		molecule.setIndicatorName(indicatorName);
		molecule.setEchartsFunction("singleBarChart");
		molecule.setEchartsData(getSinglebarEchartData());
		molecule.setSinpleDesc(sinpleDesc);
		molecule.setFirstDesc("该值随便写");
		molecule.setSecondDesc("该值随便写");
	}
	
	/**
	 * dataList不为空
	 * indicatorcontent.getIndicatordatatype() == 1 数值型
	 * mark == 1 双柱状图
	 * 
	 * 时候的处理方式,xxx原来就有，可以借鉴
	 * @param 
	 * 
	 * @return 
	 * @author dengguibin
	 */
	private void numericalDoublebar(){
		String firstDesc = getFirstDesc();
		
		String secondDesc = getSecondDesc();
		
		float firstNum1 = getFirstNum1();
		float secondNum2 = getSecondNum2();
		
		fillNumericalDoublebar(secondNum2, firstNum1, firstDesc, secondDesc);
	}
	
	/**
	 * 为NumericalDoublebar()服务，填充数据
	 * @param 
	 * 
	 * @return 
	 * @author dengguibin
	 */
	private void fillNumericalDoublebar(float secondNum2,float firstNum1,String firstDesc,String secondDesc){
		if (secondNum2 > 0) {
			if (firstNum1 / secondNum2 >= 0.6) {
				itemGeneral.setQualifiedNum(itemGeneral.getQualifiedNum() + 1);
				/** 随机数生成诊断分值 **/
				score = (int) (Math.random() * schemecatalog.getScore() / 2 + 50);
				/** 随机数生成诊断分值 **/
				molecule.setStateClass("sbox-t-q");
				molecule.setStateName("合格");
				molecule.setConclusion("该指标本次诊断结果合格！");
			} else if (firstNum1 / secondNum2 >= 0 && firstNum1 / secondNum2 < 0.6) {
				/** 随机数生成诊断分值 **/
				score = (int) (Math.random() * schemecatalog.getScore() / 2);
				/** 随机数生成诊断分值 **/
				itemGeneral.setUnqualifiedNum(itemGeneral.getUnqualifiedNum() + 1);
				molecule.setStateClass("sbox-t-unq");
				molecule.setStateName("不合格");
				molecule.setConclusion(indicatorcatalogextend.getProblemoverview());
			}
		} else {
			/** 随机数生成诊断分值 **/
			score = (int) (Math.random() * schemecatalog.getScore() / 2);
			/** 随机数生成诊断分值 **/
			itemGeneral.setUnqualifiedNum(itemGeneral.getUnqualifiedNum() + 1);
			molecule.setStateClass("sbox-t-unq");
			molecule.setStateName("不合格");
			molecule.setConclusion(indicatorcatalogextend.getProblemoverview());
		}
		molecule.setType(Molecule.TYPE_ECHARTS);
		molecule.setIndicatorName(indicatorName);
		molecule.setEchartsFunction("doubleBarChart");
		molecule.setEchartsData(getDoublebarbarEchartData());
		System.out.println("=========双柱状图molecule.getEchartsData是======:"+ molecule.getEchartsData());
		molecule.setFirstDesc(firstDesc);
		molecule.setSecondDesc(secondDesc);
		molecule.setSinpleDesc("该值随便写");
	}
	
	/**
	 * dataList不为空
	 * indicatorcontent.getIndicatordatatype() == 2 判断型
	 * 
	 * 时候的处理方式,xxx原来就有，可以借鉴
	 * @param 
	 * 
	 * @return 
	 * @author dengguibin
	 */
	private void judgmentChart(){
		TableMap2Class tableMap = new TableMap2Class();
		List<String> theadList = new ArrayList<String>();
		List<String> ntdList = new ArrayList<String>();
		List<String> ytdList = new ArrayList<String>();
		for (int i = 1; i <= 4; i++) {
			theadList.add("2018年0" + i + "月");
			/** 随机数生成诊断分值 **/
			score = (int) (Math.random() * schemecatalog.getScore());
			/** 随机数生成诊断分值 **/
			if ((score) < (schemecatalog.getScore() / 2)) {// 随机数控制是和否，测试数据
				ntdList.add("<i class='icon-small unqualified'></i>");
				ytdList.add("");
			} else {
				ntdList.add("");
				ytdList.add("<i class='icon-small qualified'></i>");
			}
			tableMap.setTheadList(theadList);
			tableMap.setYtdList(ytdList);
			tableMap.setNtdList(ntdList);
			if (i == 4) {
				if ((score) < (schemecatalog.getScore() / 2)) {
					itemGeneral.setUnqualifiedNum(itemGeneral.getUnqualifiedNum() + 1);
					molecule.setStateClass("sbox-t-unq");
					molecule.setStateName("不合格");
					molecule.setConclusion(indicatorcatalogextend.getProblemoverview());
				} else {
					itemGeneral.setQualifiedNum(itemGeneral.getQualifiedNum() + 1);
					molecule.setStateClass("sbox-t-q");
					molecule.setStateName("合格");
					molecule.setConclusion("该指标本次诊断结果合格！");
				}
			}
		}
		molecule.setType(Molecule.TYPE_TABLE);
		molecule.setIndicatorName(indicatorcontent.getName_());
		molecule.setTableMap(tableMap);
	}
	
	/**
	 * dataList为空
	 * indicatorcontent.getIndicatordatatype() == 2 判断型
	 * 
	 * 时候的处理方式，xxx原来就有，可以借鉴
	 * @param 
	 * 
	 * @return 
	 * @author dengguibin
	 */
	private void nullJudgmentChart(){
		TableMap2Class tableMap = new TableMap2Class();
		List<String> theadList = new ArrayList<String>();
		List<String> ntdList = new ArrayList<String>();
		List<String> ytdList = new ArrayList<String>();
		for (int i = 1; i <= 4; i++) {
			score = (int) (Math.random() * schemecatalog.getScore());
			theadList.add("2018年0" + i + "月");
			if ((score) < (schemecatalog.getScore() / 2)) {// 随机数控制是和否，测试数据
				ntdList.add("<i class='icon-small unqualified'></i>");
				ytdList.add("");
			} else {
				ntdList.add("");
				ytdList.add("<i class='icon-small qualified'></i>");
			}
			tableMap.setTheadList(theadList);
			tableMap.setYtdList(ytdList);
			tableMap.setNtdList(ntdList);
			if (i == 4) {
				if ((score) < (schemecatalog.getScore() / 2)) {
					itemGeneral.setUnqualifiedNum(itemGeneral.getUnqualifiedNum() + 1);
					molecule.setStateClass("sbox-t-unq");
					molecule.setStateName("不合格");
					molecule.setConclusion(indicatorcatalogextend.getProblemoverview());
				} else {
					itemGeneral.setQualifiedNum(itemGeneral.getQualifiedNum() + 1);
					molecule.setStateClass("sbox-t-q");
					molecule.setStateName("合格");
					molecule.setConclusion("该指标本次诊断结果合格！");
				}
			}
		}
		molecule.setType(Molecule.TYPE_TABLE);
		molecule.setIndicatorName(indicatorcontent.getName_());
		molecule.setTableMap(tableMap);
	}
	
	/**
	 * 保留两位小数，且四舍五入
	 * 
	 * @param countScore
	 * @return
	 */
	private float twoDecimal(float countScore) {
		BigDecimal bd = new BigDecimal(countScore);
		bd = bd.setScale(2, 4);
		return bd.floatValue();
	}

	
	
	/**
	 *为nullNumericalSinglebar方法
	 * 随机产生resultNum1
	 * 
	 * @param 
	 * 
	 * @return 
	 * @author dengguibin
	 */
	private float getResultNum1(){
		float resultNum1 = 0f;
		
		if (list !=null && list.size() >0 && list.get(0).get("resultNum") != null) {
			resultNum1 = Float.parseFloat(String.valueOf(list.get(0).get("resultNum")));
		}
		else{
			Random random=new Random();
			resultNum1 = random.nextFloat();
			resultNum1=resultNum1*1000;
		}
		return twoDecimal(resultNum1);
	}
	
	
	/**
	 *为nullNumericalSinglebar方法
	 * 产生sinpleDesc
	 * 
	 * @param 
	 * 
	 * @return 
	 * @author dengguibin
	 */
	private String getSinpleDesc(){
		
		String sinpleDesc = "";
		if (list !=null && list.size() >0 && list.get(0).get("sinpleDesc") != null) {
			sinpleDesc = (String) list.get(0).get("sinpleDesc");
		}else {
			sinpleDesc = "情况对比";
		}
		
		return sinpleDesc;
	}
	
	
	/**
	 *为nullNumericalSinglebar方法
	 * 产生echartData
	 * 
	 * @param 
	 * 
	 * @return 
	 * @author dengguibin
	 */
	private String getSinglebarEchartData(){
		if(list != null && list.size() >0){
			for (HashMap<String, Object> mapItem : list) {
				String name = (String) mapItem.get("name");
				Float resultNum = Float.parseFloat(String.valueOf(mapItem.get("resultNum")));
				echartData += "{name:'" + name + "',value:" + resultNum + "},";// 拼接数据
			}
			echartData = echartData.substring(0, echartData.length() - 1);
			echartData += "]";
		}else {
			int i=0;
			for (;i<5;i++) {
				String name = String.valueOf(2000+i);
				Float resultNum = getResultNum1();
				echartData += "{name:'" + name + "',value:" + resultNum + "},";// 拼接数据
			}
			echartData = echartData.substring(0, echartData.length() - 1);
			echartData += "]";
		}
		
		return echartData;
	}
	
	
	
	/**
	 *为nullNumericalDoublebar方法
	 * 产生getFirstDesc
	 * 
	 * @param 
	 * 
	 * @return 
	 * @author dengguibin
	 */
	private String getFirstDesc(){
		String firstDesc = "";
		if (list !=null && list.size() >0 && list.get(0).get("firstDesc") != null) {
			firstDesc = (String) list.get(0).get("firstDesc");
		}else {
			firstDesc = "局部";
		}
		return firstDesc;
	}
	
	/**
	 *为nullNumericalDoublebar方法
	 * 产生secondDesc
	 * 
	 * @param 
	 * 
	 * @return 
	 * @author dengguibin
	 */
	private String getSecondDesc(){
		String secondDesc = "";
		if (list !=null && list.size() >0 &&list.get(0).get("secondDesc") != null) {
			secondDesc = (String) list.get(0).get("secondDesc");
		}else {
			secondDesc = "总共";
		}
		return secondDesc;
	}
	
	/**
	 *为nullNumericalDoublebar方法
	 * 产生echartData
	 * 
	 * @param 
	 * @return 
	 * @author dengguibin
	 */
	private String getDoublebarbarEchartData(){
		if(list !=null && list.size()>0){
			for (HashMap<String, Object> mapItem : list) {
				String name = (String) mapItem.get("name");
				float firstNum = Float.parseFloat(String.valueOf(mapItem.get("firstNum")));
				float secondNum = Float.parseFloat(String.valueOf(mapItem.get("secondNum")));
				echartData += "{name:'" + name + "',value1:" + firstNum + ",value2:" + secondNum + "},";
			}
			echartData.substring(0, echartData.length() - 1);
			echartData += "]";
		}else{
			for (String name:obtainNames()) {
				float firstNum = getFirstNum1();
				float secondNum = getSecondNum2();
				echartData += "{name:'" + name + "',value1:" + firstNum + ",value2:" + secondNum + "},";
			}
			echartData.substring(0, echartData.length() - 1);
			echartData += "]";
		}
		
		return echartData;
	}
	
	/**
	 * 假数据molecule的name产生值
	 * 例如 201801，201802，021803，201804，201805
	 * @param 
	 * @return 
	 * @author dengguibin
	 */
	private List<String> obtainNames(){
		List<String> results=new ArrayList<>();
		int i=5;
		while(i>0){
			results.add(Dateutils.dateNextMonthstring(new Date(), i));
			i--;
		}
		return results;
	}
	
	
	/**
	 *为nullNumericalDoublebar方法
	 * 产生firstNum
	 * 
	 * @param 
	 * 
	 * @return 
	 * @author dengguibin
	 */
	private float tempFirstNum1;
	private float getFirstNum1(){
		if(list!=null && list.size()>0){
			tempFirstNum1 = Float.parseFloat(String.valueOf(list.get(0).get("firstNum")));
		}else {
			Random random=new Random();
			tempFirstNum1 = random.nextFloat();
			tempFirstNum1=tempFirstNum1*1000;
		}
		return twoDecimal(tempFirstNum1);
	}
	
	/**
	 *为nullNumericalDoublebar方法
	 * 产生secondNum
	 * 
	 * @param 
	 * 
	 * @return 
	 * @author dengguibin
	 */
	private float getSecondNum2(){
		float secondNum2=0;
		if(list !=null && list.size() >0){
			secondNum2 = Float.parseFloat(String.valueOf(list.get(1).get("secondNum")));
		}else {
			Random random=new Random();
			secondNum2 = random.nextFloat();
			secondNum2=secondNum2*1000+tempFirstNum1;//secondNum2>firstNum1,局部大于整体
		}
		return twoDecimal(secondNum2);
	}
	
	/**
	 * 根据sqlstring查询出数据结果
	 * @param 
	 * 
	 * @return 
	 * @author dengguibin
	 */
	private void initQueryDataBySql(){
		list = new ArrayList<>();
		/*// 遍历取出sql语句
		String sql = indicatorcontent.getSqlstring();
		// 如果sql=null，在mapper.xml里面做了select 1 from dual处理，接收的时候做个判断即可
		if (sql != "" && sql != null) {
			list = indicatorcontentMapper.queryDataBySql(sql);
		}else{
			list = new ArrayList<>();
		}*/
	}
	
	/**
	 * 初始化mark
	 * 对于数值型指标而言，1代表双柱状图（复杂柱状图），2代表单柱状图（简单柱状图）
	 * @param 
	 * @return 
	 * @author dengguibin
	 */
	private void initMark(){
		if(indicatorcontent.getIndicatordatatype() == 1){
			if(list!=null && list.size()>0){
				mark = (Long) list.get(0).get("mark");
			}else {
				mark = getNullMarkByIndicatorContent();
			}
		}
	}
	
	/**
	 * 初始化mark
	 * 对于数值型指标而言，1代表双柱状图（复杂柱状图），2代表单柱状图（简单柱状图）
	 * 这个方法用户初始化没有写sqlstring的指标，list为空，所以Mark也为空
	 * 
	 * 对于那些指标名称是包含比率，占比的属于双柱状图，其他属于单柱状图
	 * 
	 * @param 
	 * @return 
	 * @author dengguibin
	 */
	private Long getNullMarkByIndicatorContent(){
		String indicatorname = indicatorcontent.getName_();
		
		if(indicatorname.contains("比")||indicatorname.contains("例")||indicatorname.contains("占")){
			return (long) 1;
		}
		return (long) 2;
	}
	
	public AcquireMoleCuleService(QasTIndicatorcontent indicatorcontent,
			QasTSchemecatalog schemecatalog,
			QasTDiagnosetaskobj diagnosetaskobj, ItemGeneral itemGeneral,
			Molecule molecule) {
		super();
		this.indicatorcontent = indicatorcontent;
		this.schemecatalog = schemecatalog;
		this.diagnosetaskobj = diagnosetaskobj;
		this.itemGeneral = itemGeneral;
		this.molecule = molecule;
		
		initMapper();
		initQueryDataBySql();
		initMark();
		initIndicatorcatalogextend();
		initIndicatorName();
	}
	
	

	public float getScore() {
		return score;
	}

	private void initIndicatorName(){
		indicatorName = indicatorcontent.getName_();
	}
	
	private void initMapper(){
		indicatorcontentMapper = (QasTIndicatorcontentMapper) PlatUtil
				.getApplicationContext().getBean(
						"qasTIndicatorcontentMapper");
		
		indicatorcatalogextendMapper = (QasTIndicatorcatalogextendMapper) PlatUtil
				.getApplicationContext().getBean(
						"qasTIndicatorcatalogextendMapper");
	}
	
	private void initIndicatorcatalogextend(){
		indicatorcatalogextend = indicatorcatalogextendMapper
				.select(indicatorcontent.getIndicatorcatalogid());
		if (indicatorcatalogextend == null) {
			indicatorcatalogextend = new QasTIndicatorcatalogextend();
			indicatorcatalogextend.setProblemoverview("未录入问题描述");
		}
	}
	
	private QasTIndicatorcatalogextendMapper indicatorcatalogextendMapper; 
	private QasTIndicatorcontentMapper indicatorcontentMapper;// 指标内容
	
	
}
