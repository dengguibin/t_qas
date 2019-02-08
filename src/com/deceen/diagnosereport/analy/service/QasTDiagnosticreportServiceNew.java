package com.deceen.diagnosereport.analy.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deceen.diagnoseformat.scheme.mapper.QasTIndicatorratedefinitionMapper;
import com.deceen.diagnoseformat.scheme.mapper.QasTSchemecatalogMapper;
import com.deceen.diagnoseformat.scheme.model.QasTIndicatorratedefinition;
import com.deceen.diagnoseformat.scheme.model.QasTSchemecatalog;
import com.deceen.diagnoseformat.task.mapper.QasTDiagnosetaskobjMapper;
import com.deceen.diagnoseformat.task.model.QasTDiagnosetaskobj;
import com.deceen.diagnosereport.analy.mapper.QasTDiagnosticelementMapper;
import com.deceen.diagnosereport.analy.mapper.QasTDiagnosticintermediaryMapper;
import com.deceen.diagnosereport.analy.mapper.QasTDiagnosticitemMapper;
import com.deceen.diagnosereport.analy.mapper.QasTDiagnosticquantitativeindicatorMapper;
import com.deceen.diagnosereport.analy.mapper.QasTDiagnosticreportMapper;
import com.deceen.diagnosereport.analy.mapper.QasTDiagnosticreportsummryMapper;
import com.deceen.diagnosereport.analy.mapper.QasTDiagnostictypeMapper;
import com.deceen.diagnosereport.analy.model.QasTDiagnosticelement;
import com.deceen.diagnosereport.analy.model.QasTDiagnosticintermediary;
import com.deceen.diagnosereport.analy.model.QasTDiagnosticitem;
import com.deceen.diagnosereport.analy.model.QasTDiagnosticquantitativeindicator;
import com.deceen.diagnosereport.analy.model.QasTDiagnosticreport;
import com.deceen.diagnosereport.analy.model.QasTDiagnosticreportsummry;
import com.deceen.diagnosereport.analy.model.QasTDiagnostictype;
import com.deceen.diagnosereport.reveal.model.AnalyGeneral;
import com.deceen.diagnosereport.reveal.model.ItemFruitPage;
import com.deceen.diagnosereport.reveal.model.map2class.BasicListMap2Class;
import com.deceen.diagnosereport.reveal.model.map2class.ElementListMap2Class;
import com.deceen.diagnosereport.reveal.model.map2class.ItemsMap2Class;
import com.deceen.diagnosereport.reveal.model.map2class.QuantitativeMap2Class;
import com.deceen.diagnosereport.reveal.model.map2class.ProblemAndImprovement;
import com.deceen.diagnosereport.reveal.model.map2class.SignMap2Class;
import com.deceen.diagnosereport.reveal.model.map2class.TableMap2Class;
import com.deceen.diagnosereport.reveal.model.molecule.Molecule;
import com.deceen.diagnosereport.reveal.model.molecule.general.ItemGeneral;
import com.deceen.diagnosereport.reveal.model.molecule.general.ObjGeneralMolecule;
import com.deceen.diagnosereport.reveal.model.molecule.general.GeneralOverview;
import com.deceen.diagnosereport.reveal.model.molecule.indicator.IndicatorResult;
import com.deceen.diagnosereport.reveal.model.molecule.item.ItemAnaly;
import com.deceen.diagnosereport.reveal.model.molecule.type.TypeAnaly;
import com.deceen.diagnosereport.reveal.service.FreemarkerService;
import com.deceen.indicator.indicatorcatalogextend.mapper.QasTIndicatorcatalogextendMapper;
import com.deceen.indicator.indicatorcatalogextend.model.QasTIndicatorcatalogextend;
import com.deceen.indicator.indicatorcontent.mapper.QasTIndicatorcontentMapper;
import com.deceen.indicator.indicatorcontent.model.QasTIndicatorcontent;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

/**
 * 
 * @ClassName: QasTDiagnosticreportAction.java
 * @Description: qas_t_diagnosticreport
 * @author upaths@gmail.com
 * @date 2017-12-1 10:05:23
 * @version V1.0
 */
@Component("qasTDiagnosticreportServiceNew")
public class QasTDiagnosticreportServiceNew extends CommonService {

	private QasTDiagnosticreportMapper diagnosticreportMapper;

	@Autowired
	private QasTSchemecatalogMapper schemecatalogMapper;

	@Autowired
	private QasTIndicatorcatalogextendMapper indicatorcatalogextendMapper;

	@Autowired
	private QasTIndicatorcontentMapper indicatorcontentMapper;// 指标内容

	@Autowired
	private QasTDiagnosetaskobjMapper diagnosetaskobjMapper;

	@Autowired
	private QasTIndicatorratedefinitionMapper IndicatorratedefinitionMapper;

	@Autowired
	private QasTDiagnosticelementMapper diagnosticelementMapper;

	@Autowired
	private FreemarkerService freemarkerService;

//	@Autowired
//	private QasTDiagnosticindicatorparametersMapper diagnosticindicatorparametersMapper;

	@Autowired
	private QasTDiagnosticintermediaryMapper diagnosticintermediaryMapper;

	@Autowired
	private QasTDiagnosticitemMapper diagnosticitemMapper;

//	@Autowired
//	private QasTDiagnosticproductiveindicatorMapper diagnosticproductiveindicatorMapper;

	@Autowired
	private QasTDiagnosticquantitativeindicatorMapper diagnosticquantitativeindicatorMapper;

	@Autowired
	private QasTDiagnosticreportsummryMapper diagnosticreportsummryMapper;

	@Autowired
	private QasTDiagnostictypeMapper diagnostictypeMapper;

	private AnalyGeneral analyGeneral = null;
	private ItemGeneral itemGeneral = null;
	private ItemAnaly itemAnaly = null;
	private TypeAnaly typeAnaly = null;
	private ElementListMap2Class elementMap = null;

	/*
	 * public List<Map<String, Object>> select(QasTDiagnosticreport
	 * diagnosticreport) { return
	 * diagnosticreportMapper.select(diagnosticreport); }
	 */

	public List<Map<String, Object>> select(
			QasTDiagnosticreport diagnosticreport) {
		return diagnosticreportMapper.select(diagnosticreport);
	}

	public List<Map<String, Object>> selectDiagnosetaskId() {
		return diagnosticreportMapper.selectDiagnosetaskId();
	}

	public int insert(QasTDiagnosticreport bean) {
		return diagnosticreportMapper.insert(bean);
	}

	public int update(QasTDiagnosticreport bean) {
		return diagnosticreportMapper.update(bean);
	}

	@SuppressWarnings("rawtypes")
	public List list(QasTDiagnosticreport bean) {
		return queryPageList(QasTDiagnosticreportMapper.class.getName() + ".list", bean);
	}

	public int delete(Object id) {
		return diagnosticreportMapper.delete(id);
	}

	@SuppressWarnings("rawtypes")
	public int delete(Object[] ids) {
		List list = Arrays.asList(ids);
		batchDelete(list, QasTDiagnosticreportMapper.class.getName() + ".delete");
		return 0;
	}

	public QasTDiagnosticreportMapper getMapper() {
		return diagnosticreportMapper;
	}

	@Autowired
	public void setMapper(QasTDiagnosticreportMapper mapper) {
		this.diagnosticreportMapper = mapper;
	}

	@SuppressWarnings("rawtypes")
	public Class getMapperClass() {
		return QasTDiagnosticreportMapper.class;
	}

	/**
	 * 用于分数排序
	 * 
	 */
	class ScoreRank {
		
		String objId;
		float score;
		int rank;

		ScoreRank(String objId, float score) {
			this.objId = objId;
			this.score = score;
		}

	}

	/**
	 * 执行分析
	 * 
	 * @param diagnosticreport
	 *            诊断报告
	 * @param objId
	 *            诊断对象的id
	 * @return 成功返回true 否则返回false
	 * @throws Exception
	 */
	public boolean excuteAnaly(QasTDiagnosticreport diagnosticreport, String objId) throws Exception {
		boolean b = true;
//		int i = 0;// 任务是否有对象的标志
		diagnosticreportMapper.insert(diagnosticreport);
		// 查询诊断对象
		List<QasTDiagnosetaskobj> list = null;
		if (objId == null) {
			list = diagnosetaskobjMapper.selectByTaskId(diagnosticreport.getDiagnosetaskid());
		} else {
			list = diagnosetaskobjMapper.selectById(objId);
		}
		// 诊断中介
		List<QasTDiagnosticintermediary> diagnosticIntermediarys = new ArrayList<QasTDiagnosticintermediary>();
		// 报告概述
		List<QasTDiagnosticreportsummry> diagnosticreportsummrys = new ArrayList<QasTDiagnosticreportsummry>();
		List<Map<String, Object>> htmlObjs = new ArrayList<Map<String, Object>>();
		TreeSet<ScoreRank> scoreRanks = new TreeSet<ScoreRank>(
				new Comparator<ScoreRank>() {
					@Override
					public int compare(ScoreRank o1, ScoreRank o2) {
						if (o1.score - o2.score > 0) {
							return -1;
						}
						return 1;
					};
				});

		// 创建总体概述各诊断对象的对比结果对象
		ObjGeneralMolecule objGeneralMolecule = new ObjGeneralMolecule();
		String generalMolecule = "";
		for (QasTDiagnosetaskobj diagnosetaskobj : list) {
			Map<String, Object> htmlObj = new HashMap<String, Object>();
//			i = 1;
			// 组装诊断概述
			QasTDiagnosticreportsummry diagnosticreportsummry = new QasTDiagnosticreportsummry();
			diagnosticreportsummry.setId(IDGenerator.getUUID());
			diagnosticreportsummry.setPrecedence(1);// 排名 ，必填字段，先随便赋值。

			// TODO 组装分析概述
			diagnosticreportsummrys.add(diagnosticreportsummry);

			// 组装诊断中介对象
			QasTDiagnosticintermediary diagnosticintermediary = new QasTDiagnosticintermediary();
			diagnosticintermediary.setId(IDGenerator.getUUID());
			diagnosticintermediary.setDiagnosticreportid(diagnosticreport.getId());
			diagnosticintermediary.setDiagnosticobjid(diagnosetaskobj.getDiagnoseobjid());
			diagnosticintermediary.setDiagnosticobjname(diagnosetaskobj.getDiagnoseobjname());
			diagnosticintermediary.setDiagnosticreportsummryid(diagnosticreportsummry.getId());
			diagnosticIntermediarys.add(diagnosticintermediary);

			analyGeneral = new AnalyGeneral();
			// 针对每个对象进行分析
			float score = this.analyByDiagnoseType(diagnosetaskobj, diagnosticintermediary.getId());

			List<ItemGeneral> itemGenerals = analyGeneral.getItemList();
			int qualifiedNum = 0;
			int earlyWarning = 0;
			int unQualifiedNum = 0;
			for (ItemGeneral itemGeneral : itemGenerals) {
				qualifiedNum += itemGeneral.getQualifiedNum();
				unQualifiedNum += itemGeneral.getUnqualifiedNum();
				earlyWarning += itemGeneral.getEarlyWarningNum();
			}

			// 创建量化指标对象
			QuantitativeMap2Class quantitativeMap = new QuantitativeMap2Class();
			quantitativeMap.setNum(qualifiedNum + unQualifiedNum + earlyWarning + "");// 量化指标的数量
			quantitativeMap.setScore(score + "");
			quantitativeMap.setQualifiedNum(qualifiedNum);// 合格
			quantitativeMap.setEarlyWarningNum(earlyWarning);// 预警
			quantitativeMap.setUnqualifiedNum(unQualifiedNum);// 不合格

			// 标志性成果指标对象
			SignMap2Class signMap = new SignMap2Class();
			signMap.setNum("0");// 标志性成果指标的数量
			signMap.setAchieve("0");// 标志性成果的达成度
			signMap.setResultCount("[{name:'国家级',total:'0',value:'0'},{name:'省级',total:'0',value:'0'},"
					+ "{name:'市级',total:'0',value:'0'},{name:'院校级',total:'0',value:'0'}]");

			// 创建总体概述总体诊断结果对象
			GeneralOverview rgm = new GeneralOverview();
			rgm.setOnjId(diagnosetaskobj.getId());
			rgm.setObjName(diagnosetaskobj.getDiagnoseobjname());
			rgm.setScore(score + "");
			rgm.setRanking("16");
			if (score > 60) {
				rgm.setFruit("合格");
			} else {
				rgm.setFruit("不合格");
			}
			scoreRanks.add(new ScoreRank(diagnosetaskobj.getId(), score));
			rgm.setQuantitativeMap(quantitativeMap);
			rgm.setSignMap(signMap);
			analyGeneral.setGeneralOverview(rgm);

			// 诊断对象横向对比图
			generalMolecule += "{name:'" + diagnosetaskobj.getDiagnoseobjname() + "',value:" + score + "},";
			// 针对每个对象创建静态页面。
			htmlObj.put("analyGeneral", analyGeneral);
			htmlObj.put("diagnosticreportid", diagnosticintermediary.getDiagnosticreportid());
			htmlObj.put("id", diagnosticintermediary.getId());
			htmlObj.put("diagnosetaskobjid", diagnosetaskobj.getDiagnoseobjid());
			htmlObjs.add(htmlObj);
		}
		objGeneralMolecule.setEchartsData("[" + generalMolecule + "]");
		// 创建静态展示页面
		for (Map<String, Object> htmlObj : htmlObjs) {

			AnalyGeneral analy = (AnalyGeneral) htmlObj.get("analyGeneral");
			// 插入排名
			GeneralOverview rgm = analy.getGeneralOverview();
			int k = 1;
			for (ScoreRank scoreRank : scoreRanks) {
				if (scoreRank.objId.equals(rgm.getOnjId())) {
					rgm.setRanking(k + "");
					k = 1;
					break;
				}
				k++;
			}

			analy.setObjGeneralMolecule(objGeneralMolecule);
			freemarkerService.createHtml(
					(AnalyGeneral) htmlObj.get("analyGeneral"),
					(String) htmlObj.get("diagnosticreportid"),
					(String) htmlObj.get("id"),
					(String) htmlObj.get("diagnosetaskobjid"));
		}
		if (diagnosticIntermediarys.size() > 0) {
			diagnosticintermediaryMapper.insertBatch(diagnosticIntermediarys);
		}
		if (diagnosticreportsummrys.size() > 0) {
			diagnosticreportsummryMapper.insertBatch(diagnosticreportsummrys);
		}
		return b;
	}

	/**
	 * 类型诊断
	 * 
	 * @param diagnosetaskobj
	 *            诊断对象
	 * @param diagnosticintermediary
	 * @throws Exception
	 */
	public float analyByDiagnoseType(QasTDiagnosetaskobj diagnosetaskobj, String intermediaryId) throws Exception {
		// 根据任务id查出所有的类型(模型指标关联)
		List<QasTSchemecatalog> list = schemecatalogMapper.selectByTaskId(diagnosetaskobj.getDiagnosetaskid());

		// 报告-类型
		List<QasTDiagnostictype> diagnostictypes = new ArrayList<QasTDiagnostictype>();

		float countScore = 0;

		for (int i = 0; i < list.size(); i++) {
			QasTDiagnostictype diagnostictype = new QasTDiagnostictype();
			diagnostictype.setId(IDGenerator.getUUID());
			diagnostictype.setDiagnosticintermediaryid(intermediaryId);
			diagnostictype.setIndicatorcatalogid(list.get(i).getIndicatorcatalogid());
			diagnostictype.setOverview("总体概况");
			diagnostictype.setProblems("存在问题");
			diagnostictype.setSuggestions("改进建议");
			diagnostictype.setConclusion("结论");
			diagnostictype.setWeight(list.get(i).getWeight());
			diagnostictype.setSort(i + 1);

			// 项目分析
			typeAnaly = new TypeAnaly();
			float score = this.analyByDiagnoseItem(list.get(i), diagnosetaskobj, diagnostictype.getId());
			countScore += score;
			analyGeneral.setItemFruitPageList(typeAnaly.getItemFruitPageList()); // 设置所有项目的分析结果

			// TODO 组装分析类型结果
			diagnostictypes.add(diagnostictype);
		}

		if (diagnostictypes.size() > 0) {
			diagnostictypeMapper.insertBatch(diagnostictypes);
		}
		return getBigDecimal(countScore);
	}

	/**
	 * 项目诊断
	 * 
	 * @param schemecatalog
	 *            类型
	 * @param diagnosetaskobj
	 *            诊断对象
	 * @param typeId
	 */
	// 模型指标关联 诊断任务与诊断对象 报告-类型id
	public float analyByDiagnoseItem(QasTSchemecatalog schemecatalog,// 模型指标关联-类型
			QasTDiagnosetaskobj diagnosetaskobj, String typeId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("IndicatorCatalogId", schemecatalog.getIndicatorcatalogid());
		params.put("schemeid", schemecatalog.getSchemeid());

		String schemecatalogId = schemecatalog.getId();// 类型id
		// 查出该类型下的所有项目
		List<QasTSchemecatalog> list = schemecatalogMapper.selectParams(params);

		List<QasTDiagnosticitem> diagnosticitems = new ArrayList<QasTDiagnosticitem>();

		List<ItemGeneral> itemGeneralList = new ArrayList<ItemGeneral>();
		List<ItemFruitPage> itemFruitPageList = new ArrayList<ItemFruitPage>();
		// 创建装问题描述与装改进意见的list
		List<ProblemAndImprovement> questionList = new ArrayList<ProblemAndImprovement>();

		String itemsAndObj = "", weight = "", itemsName = "", scores = "";
		int qualifiedNum = 0, unQualifiedNum = 0; // 达标数

		float countScore = 0;
		for (int i = 0; i < list.size(); i++) {
			// 报告-项目
			QasTDiagnosticitem diagnosticitem = new QasTDiagnosticitem();
			// TODO 组装分析项目结果
			diagnosticitem.setId(IDGenerator.getUUID());
			diagnosticitem.setDiagnostictype(typeId);
			diagnosticitem.setIndicatorcatalogid(list.get(i).getIndicatorcatalogid());
			diagnosticitem.setProjectname(list.get(i).getIndicatorcatalog().getName_());// 项目详情列表的名字
			diagnosticitem.setOverview("总体概况");
			diagnosticitem.setProblems("存在问题");
			diagnosticitem.setSuggestions("改进建议");
			diagnosticitem.setConclusion("结论");
			diagnosticitem.setWeight(list.get(i).getWeight());
			diagnosticitem.setSort(i + 1);
			diagnosticitems.add(diagnosticitem);

			// 综合评估各项目及状态
			itemGeneral = new ItemGeneral();
			itemGeneral.setItemName(list.get(i).getIndicatorcatalog().getName_());

			// 创建项目分析结果的页面对象
			ItemFruitPage ifp = new ItemFruitPage();
			float score = analyByDiagnoseElement(list.get(i), diagnosetaskobj, diagnosticitem.getId()); // 项目分析结果
			if (list.get(i).getWeight() >= 0) {
				countScore += score * list.get(i).getWeight();
			}

			qualifiedNum += itemGeneral.getQualifiedNum();
			unQualifiedNum += itemGeneral.getUnqualifiedNum();
			if (itemGeneral.getQualifiedNum() > itemGeneral.getUnqualifiedNum()) {
				itemGeneral.setResult("已达标");
				itemGeneral.setResultClass("qualified");
			} else if (itemGeneral.getQualifiedNum() == itemGeneral.getUnqualifiedNum()) {
				itemGeneral.setResult("预警");
				itemGeneral.setResultClass("warn");
			} else {
				itemGeneral.setResult("未达标");
				itemGeneral.setResultClass("unqualified");

				QasTIndicatorcatalogextend indicatorcatalogextend = indicatorcatalogextendMapper
						.select(list.get(i).getIndicatorcatalog().getId());
				ProblemAndImprovement question = new ProblemAndImprovement();
				question.setName(list.get(i).getIndicatorcatalog().getName_() + "水平有待提升");
				if (indicatorcatalogextend == null) {
					question.setQuestioninfo("未录入问题描述");
					question.setSuggestioninfo("未录入改进意见");
				} else {
					question.setQuestioninfo(indicatorcatalogextend.getProblemoverview());
					question.setSuggestioninfo(indicatorcatalogextend.getSuggestionoverview());
				}
				questionList.add(question);
			}

			/** 为了能显示雷达图的样式，重复几条数据 **/
			if (list.size() >= 3) {
				itemsAndObj = list.get(i).getIndicatorcatalog().getName_() + "," + itemsAndObj;
				scores = (int) score + "," + scores;
				weight = list.get(i).getWeight() * 100 + "," + weight;
				itemsName = "{name:'"
						+ list.get(i).getIndicatorcatalog().getName_()
						+ "',max:100}," + itemsName;
			} else {
				for (int j = 0; j < 3; j++) {
					itemsAndObj = list.get(i).getIndicatorcatalog().getName_() + "," + itemsAndObj;
					scores = (int) score + "," + scores;
					weight = list.get(i).getWeight() * 100 + "," + weight;
					itemsName = "{name:'"
							+ list.get(i).getIndicatorcatalog().getName_()
							+ "',max:100}," + itemsName;
				}
			}
			/** 为了能显示雷达图的样式，重复几条数据 **/

			itemGeneralList.add(itemGeneral);
			itemAnaly.setSchemecatalogId(schemecatalogId);// 将类型id关联到每个对象里面去
			ifp.setItemAnaly(itemAnaly);
			itemFruitPageList.add(ifp);
		}

		// 创建装所有项目的总结和雷达图数据map
		ItemsMap2Class itemsMap = new ItemsMap2Class();
		itemsMap.setItemsAndObj(itemsAndObj.substring(0,
				itemsAndObj.length() - 1)
				+ "这"
				+ list.size()
				+ "大方面对"
				+ diagnosetaskobj.getDiagnoseobjname());

		float standardRate = (float) qualifiedNum / (unQualifiedNum + qualifiedNum) * 100;

		standardRate = getBigDecimal(standardRate);
		itemsMap.setStandardRate(standardRate + "%");
		itemsMap.setItemsData("[{value:[" + scores + "],name:'得分为'},{value:["
				+ weight.substring(0, weight.length() - 1) + "],name:'占比为'}]");
		itemsMap.setItemsName("["
				+ itemsName.substring(0, itemsName.length() - 1) + "]");

		analyGeneral.setItemsMap(itemsMap);

		typeAnaly.setItemFruitPageList(itemFruitPageList);
		analyGeneral.setQuestionList(questionList);
		analyGeneral.setItemList(itemGeneralList);
		if (diagnosticitems.size() > 0) {
			diagnosticitemMapper.insertBatch(diagnosticitems);
		}
		return getBigDecimal(countScore);
	}

	/**
	 * 要素诊断
	 * 
	 * @param schemecatalog
	 *            项目
	 * @param diagnosetaskobj
	 *            诊断对象
	 * @param diagnosticitem
	 * @return
	 */
	public float analyByDiagnoseElement(QasTSchemecatalog schemecatalog,// 模型指标关联-项目
			QasTDiagnosetaskobj diagnosetaskobj, String itemId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("IndicatorCatalogId", schemecatalog.getIndicatorcatalogid());// 项目的id
		params.put("schemeid", schemecatalog.getSchemeid());// 模型的id

		// 查出该项目下的所有要素
		List<QasTSchemecatalog> list = schemecatalogMapper.selectParams(params);

		List<QasTDiagnosticelement> diagnosticelements = new ArrayList<QasTDiagnosticelement>();
		// 创建装要素分析结果的list
		List<ElementListMap2Class> elementList = new ArrayList<ElementListMap2Class>();
		// 创建装要素map的list
		List<BasicListMap2Class> basicList = new ArrayList<BasicListMap2Class>();
		// 创建装问题描述与装改进意见的list
		List<ProblemAndImprovement> questionList = new ArrayList<ProblemAndImprovement>();

		// 指标合格与不合格统计声明
		int qualifiedNum = 0, unQualifiedNum = 0;

		float countScore = 0;
		for (int i = 0; i < list.size(); i++) {
			// 创建装单个要素分析结果的对象
			elementMap = new ElementListMap2Class();
			// list.get(i)要素
			float score = analyByDiagnoseIndicator(list.get(i), diagnosetaskobj);
			if (list.get(i).getWeight() >= 0) {
				countScore += score * list.get(i).getWeight();
			}

			// 创建装要素的对象
			BasicListMap2Class basicMap = new BasicListMap2Class();
			basicMap.setBasicName(list.get(i).getIndicatorcatalog().getName_());// 要素的名称

			if (score > 50) {
				qualifiedNum++;
				basicMap.setBasicClass(ItemAnaly.BASIC_CLASS_Y);
			} else {
				unQualifiedNum++;
				QasTIndicatorcatalogextend indicatorcatalogextend = indicatorcatalogextendMapper
						.select(list.get(i).getIndicatorcatalog().getId());
				ProblemAndImprovement question = new ProblemAndImprovement();
				question.setName(list.get(i).getIndicatorcatalog().getName_() + "水平有待提升");
				if (indicatorcatalogextend == null) {
					question.setQuestioninfo("未录入问题描述");
					question.setSuggestioninfo("未录入改进意见");
				} else {
					question.setQuestioninfo(indicatorcatalogextend.getProblemoverview());
					question.setSuggestioninfo(indicatorcatalogextend.getSuggestionoverview());
				}
				questionList.add(question);
				basicMap.setBasicClass(ItemAnaly.BASIC_CLASS_N);
			}
			basicList.add(basicMap);

			// TODO 组装分析项目结果
			QasTDiagnosticelement diagnosticelement = new QasTDiagnosticelement();
			diagnosticelement.setId(IDGenerator.getUUID());
			diagnosticelement.setElementstate(1); // 要素合格状态，必填字段
			diagnosticelement.setDiagnosticprojectid(itemId);
			diagnosticelement.setIndicatorcatalogid(list.get(i).getIndicatorcatalogid());
			diagnosticelement.setElementname(list.get(i).getIndicatorcatalog().getName_());
			diagnosticelement.setWeight(list.get(i).getWeight());
			diagnosticelement.setSort(i + 1);
			diagnosticelements.add(diagnosticelement);

			// 这里element中对象属性值是没有的，所以会报空指针异常！
			elementMap.setElement(list.get(i).getIndicatorcatalog().getName_());// 要素的名称
			elementList.add(elementMap);
		}
		if (diagnosticelements.size() > 0) {
			diagnosticelementMapper.insertBatch(diagnosticelements);
		}

		// 创建装项目分析结果的对象
		float standardRate = (float) qualifiedNum / (unQualifiedNum + qualifiedNum) * 100;

		standardRate = getBigDecimal(standardRate);
		itemAnaly = new ItemAnaly();
		itemAnaly.setName(schemecatalog.getIndicatorcatalog().getName_()); // 项目名称
		itemAnaly.setReachValue(standardRate + "%");
		itemAnaly.setElementList(elementList);
		itemAnaly.setBasicList(basicList);
		itemAnaly.setQuestionList(questionList);
		if (qualifiedNum > unQualifiedNum) {
			itemAnaly.setReachClass(ItemAnaly.REACH_CLASS_Y);
			itemAnaly.setDiagnoseConclusion("合格，请持续保持");
		} else {
			itemAnaly.setReachClass(ItemAnaly.REACH_CLASS_N);
			itemAnaly.setDiagnoseConclusion("不合格，请持续改进");
		}
		return getBigDecimal(countScore);
	}

	/**
	 * 诊断内容
	 * 
	 * @param indicatorcontentid
	 *            指标内容id
	 * @param schemeid
	 *            模板id
	 */
	@SuppressWarnings("unused")
	public float analyByDiagnoseContent(QasTSchemecatalog schemecatalog) {
		float countScore = (float) 0.00;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("IndicatorCatalogId", schemecatalog.getIndicatorcatalogid());
		params.put("schemeid", schemecatalog.getSchemeid());
		List<QasTIndicatorratedefinition> list = IndicatorratedefinitionMapper.selectByParams(params);
		List<QasTDiagnosticquantitativeindicator> diagnosticquantitativeindicators = 
				new ArrayList<QasTDiagnosticquantitativeindicator>();
		for (QasTIndicatorratedefinition indicatorratedefinition : list) {
			// TODO 分析指标
			QasTDiagnosticquantitativeindicator diagnosticquantitativeindicator = new QasTDiagnosticquantitativeindicator();
			diagnosticquantitativeindicator.setId(IDGenerator.getUUID());
			diagnosticquantitativeindicators.add(diagnosticquantitativeindicator);
		}
		if (diagnosticquantitativeindicators.size() > 0) {
			diagnosticquantitativeindicatorMapper.insertBatch(diagnosticquantitativeindicators);
		}
		return countScore;
	}

	public List<Map<String, Object>> selectDisgnoseObjByTaskId(
			QasTDiagnosticreport diagnosticreport) {
		return diagnosticreportMapper.selectDisgnoseObjByTaskId(diagnosticreport);
	}

	public List<QasTDiagnosetaskobj> selectDisgnoseObj(String diagnosticreport) {
		return diagnosetaskobjMapper.selectByTaskId(diagnosticreport);
	}

	/**
	 * 指标诊断
	 * 
	 * @param schemecatalog
	 *            要素
	 * @param diagnosetaskobj
	 *            诊断对象
	 * @param elementId
	 * @return
	 */
	public float analyByDiagnoseIndicator(QasTSchemecatalog schemecatalog,// 模型指标关联-要素
			QasTDiagnosetaskobj diagnosetaskobj) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("IndicatorCatalogId", schemecatalog.getIndicatorcatalogid()); // 要素的id
		params.put("schemeid", schemecatalog.getSchemeid()); // 模型的id

		List<IndicatorResult> indicatorResultList = new ArrayList<IndicatorResult>();

		// 查询该要素下的所有指标
		List<QasTIndicatorcontent> list1 = indicatorcontentMapper.selectByParams(params);

		List<Molecule> moleculelist = new ArrayList<Molecule>();
		float countScore = 0;
		for (QasTIndicatorcontent qasTIndicatorcontent : list1) {

			// 项目下指标的诊断结果
			IndicatorResult indicatorResult = new IndicatorResult();
			indicatorResult.setName(qasTIndicatorcontent.getName_());
			indicatorResult.setAcceptanceValue(qasTIndicatorcontent.getStandard());

			Map<String, String> params1 = new HashMap<String, String>();
			params1.put("indicatorcatalogid", qasTIndicatorcontent.getIndicatorcatalogid());
			params1.put("schemeid", schemecatalog.getSchemeid());
			QasTSchemecatalog schemecatalog1 = schemecatalogMapper.select(params1);// 模型指标关联-指标

			// 获取指标的分析结果
			Molecule molecule = new Molecule();
			float score = getMolecule(qasTIndicatorcontent, schemecatalog1, diagnosetaskobj, molecule);
			/** 组装假数据 **/
			if (qasTIndicatorcontent.getIndicatordatatype() == 1) {
				indicatorResult.setResult(score + "");
			} else if (qasTIndicatorcontent.getIndicatordatatype() == 2) {
				if ((score) >= (schemecatalog1.getScore() / 2)) {
					indicatorResult.setResult("是");
				} else {
					indicatorResult.setResult("否");
				}
			} else {
				indicatorResult.setResult("5");
			}
			/** 组装假数据 **/
			indicatorResultList.add(indicatorResult);

			countScore += score / schemecatalog1.getScore() * 100; // 算出百分之分数
			moleculelist.add(molecule);
		}
		itemGeneral.getIndicatorResultList().addAll(indicatorResultList);
		elementMap.setMoleculeList(moleculelist);
		return getBigDecimal(countScore / list1.size());
	}

	/**
	 * 保留两位小数，且四舍五入
	 * 
	 * @param countScore
	 * @return
	 */
	private float getBigDecimal(float countScore) {
		BigDecimal bd = new BigDecimal(countScore);
		bd = bd.setScale(2, 4);
		return bd.floatValue();
	}

	
	/**
	* 获得sqlstring查询出来的list结果
	 * @param 
	 * 
	 * @return 
	 * @author dengguibin
	 */
	private List<HashMap<String, Object>> queryDataBySql(QasTIndicatorcontent indicatorcontent){
		// 遍历取出sql语句
		String sql = indicatorcontent.getSqlstring();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		// 如果sql=null，在mapper.xml里面做了select 1 from dual处理，接收的时候做个判断即可
		if (sql != "" && sql != null) {
			list = indicatorcontentMapper.queryDataBySql(sql);
		}else{
			//TODO
			//诊断分析假数据
		}
		return list;
	}
	
	
	/**
	* 获取统计结果
	 * 1. 设置molecule的值
	 * 2. 计算分数返回
	 * @param 
	 * 
	 * @return acquireMoleCule.getScore():计算分数返回
	 * @author dengguibin
	 */
	public float getMolecule(QasTIndicatorcontent indicatorcontent,
			QasTSchemecatalog schemecatalog,// 模型指标关联-指标
			QasTDiagnosetaskobj diagnosetaskobj, Molecule molecule) {
		
		AcquireMoleCuleService acquireMoleCule=new AcquireMoleCuleService(indicatorcontent, schemecatalog, diagnosetaskobj, itemGeneral, molecule);
		acquireMoleCule.startExecute();
		return acquireMoleCule.getScore();
	}
	
	
	
	
	/**
	 * 获取统计结果
	 * 
	 * @param schemecatalog
	 * @param molecule
	 * 
	 * @param ic
	 *            指标内容
	 * @param obj
	 *            诊断对象
	 * @return
	 */
	public float getMolecule1(QasTIndicatorcontent indicatorcontent,
			QasTSchemecatalog schemecatalog,// 模型指标关联-指标
			QasTDiagnosetaskobj diagnosetaskobj, Molecule molecule) {

		// 遍历取出sql语句
		String sql = indicatorcontent.getSqlstring();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		// 如果sql=null，在mapper.xml里面做了select 1 from dual处理，接收的时候做个判断即可
		if (sql != "" && sql != null) {
			list = indicatorcontentMapper.queryDataBySql(sql);
		}else{
			//TODO
			//诊断分析假数据
		}
		String indicatorName = null;// 毕业生的教学满意度

		String echartData = "[";// molecule数据

		QasTIndicatorcatalogextend indicatorcatalogextend = indicatorcatalogextendMapper
				.select(indicatorcontent.getIndicatorcatalogid());
		if (indicatorcatalogextend == null) {
			indicatorcatalogextend = new QasTIndicatorcatalogextend();
			indicatorcatalogextend.setProblemoverview("未录入问题描述");
		}

		float score = 0;

		Long mark = null;// 对于数值型指标而言，1代表双柱状图（复杂柱状图），2代表单柱状图（简单柱状图）
		if (list.size() >= 0 && !list.isEmpty()) {
			if (indicatorcontent.getIndicatordatatype() == 1) { // 数值型
				mark = (Long) list.get(0).get("mark");

				if (mark == 2) {
					float resultNum1 = 0f;
					if (list.get(0).get("resultNum") != null) {
						resultNum1 = Float.parseFloat(String.valueOf(list.get(0).get("resultNum")));
					}

					if (list.get(0).get("indicatorName") != null) {
						indicatorName = (String) list.get(0).get("indicatorName");
					} else {
						indicatorName = "";
					}
					String sinpleDesc = "";
					if (list.get(0).get("sinpleDesc") != null) {
						sinpleDesc = (String) list.get(0).get("sinpleDesc");
					}
					for (HashMap<String, Object> mapItem : list) {
						String name = (String) mapItem.get("name");
						Float resultNum = Float.parseFloat(String.valueOf(mapItem.get("resultNum")));
						echartData += "{name:'" + name + "',value:" + resultNum + "},";// 拼接数据
					}
					echartData = echartData.substring(0, echartData.length() - 1);
					echartData += "]";
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
					molecule.setEchartsData(echartData);
					molecule.setSinpleDesc(sinpleDesc);
					molecule.setFirstDesc("该值随便写");
					molecule.setSecondDesc("该值随便写");

				} else if (mark == 1) {
					// xxx
					mark = (Long) list.get(0).get("mark");
					if (list.get(0).get("indicatorName") != null) {
						indicatorName = (String) list.get(0).get("indicatorName");
					} else {
						indicatorName = "";
					}
					String firstDesc = "";
					if (list.get(0).get("firstDesc") != null) {
						firstDesc = (String) list.get(0).get("firstDesc");
					}
					String secondDesc = "";
					if (list.get(0).get("secondDesc") != null) {
						secondDesc = (String) list.get(0).get("secondDesc");
					}

					for (HashMap<String, Object> mapItem : list) {
						String name = (String) mapItem.get("name");
						float firstNum = Float.parseFloat(String.valueOf(mapItem.get("firstNum")));
						float secondNum = Float.parseFloat(String.valueOf(mapItem.get("secondNum")));
						echartData += "{name:'" + name + "',value1:" + firstNum + ",value2:" + secondNum + "},";
					}
					echartData.substring(0, echartData.length() - 1);
					echartData += "]";
					float secondNum2 = Float.parseFloat(String.valueOf(list.get(1).get("secondNum")));
					float firstNum1 = Float.parseFloat(String.valueOf(list.get(0).get("firstNum")));
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
					molecule.setEchartsData(echartData);
					System.out.println("=========双柱状图molecule.getEchartsData是======:"+ molecule.getEchartsData());
					molecule.setFirstDesc(firstDesc);
					molecule.setSecondDesc(secondDesc);
					molecule.setSinpleDesc("该值随便写");
				}
			} else if (indicatorcontent.getIndicatordatatype() == 2) {// 判断型
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
			} else {// 标志型

			}
		} else {
			if (indicatorcontent.getIndicatordatatype() == 2) {// 判断型
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
		}

		return score;

	}

}
