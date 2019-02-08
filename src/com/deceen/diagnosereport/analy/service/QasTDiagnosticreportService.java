package com.deceen.diagnosereport.analy.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deceen.diagnoseformat.scheme.mapper.QasTIndicatorratedefinitionMapper;
import com.deceen.diagnoseformat.scheme.mapper.QasTSchemecatalogMapper;
import com.deceen.diagnoseformat.scheme.model.QasTIndicatorratedefinition;
import com.deceen.diagnoseformat.scheme.model.QasTSchemecatalog;
import com.deceen.diagnoseformat.task.mapper.QasTDiagnosetaskobjMapper;
import com.deceen.diagnoseformat.task.model.QasTDiagnosetaskobj;
import com.deceen.diagnosereport.analy.mapper.QasTDiagnosticelementMapper;
import com.deceen.diagnosereport.analy.mapper.QasTDiagnosticindicatorparametersMapper;
import com.deceen.diagnosereport.analy.mapper.QasTDiagnosticintermediaryMapper;
import com.deceen.diagnosereport.analy.mapper.QasTDiagnosticitemMapper;
import com.deceen.diagnosereport.analy.mapper.QasTDiagnosticproductiveindicatorMapper;
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
import com.deceen.indicator.indicatorcatalog.mapper.QasTIndicatorcatalogMapper;
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
@Component("qasTDiagnosticreportService")
public class QasTDiagnosticreportService extends CommonService {

	private QasTDiagnosticreportMapper diagnosticreportMapper;

	@Autowired
	private QasTSchemecatalogMapper schemecatalogMapper;

	@Autowired
	private QasTIndicatorcatalogMapper indicatorcatalogMapper;// 指标目录

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

	@Autowired
	private QasTDiagnosticindicatorparametersMapper diagnosticindicatorparametersMapper;

	@Autowired
	private QasTDiagnosticintermediaryMapper diagnosticintermediaryMapper;

	@Autowired
	private QasTDiagnosticitemMapper diagnosticitemMapper;

	@Autowired
	private QasTDiagnosticproductiveindicatorMapper diagnosticproductiveindicatorMapper;

	@Autowired
	private QasTDiagnosticquantitativeindicatorMapper diagnosticquantitativeindicatorMapper;

	@Autowired
	private QasTDiagnosticreportsummryMapper diagnosticreportsummryMapper;

	@Autowired
	private QasTDiagnostictypeMapper diagnostictypeMapper;

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

	public List list(QasTDiagnosticreport bean) {
		return queryPageList(QasTDiagnosticreportMapper.class.getName()
				+ ".list", bean);
	}

	public int delete(Object id) {
		return diagnosticreportMapper.delete(id);
	}

	public int delete(Object[] ids) {
		List list = Arrays.asList(ids);
		batchDelete(list, QasTDiagnosticreportMapper.class.getName()
				+ ".delete");
		return 0;
	}

	public QasTDiagnosticreportMapper getMapper() {
		return diagnosticreportMapper;
	}

	@Autowired
	public void setMapper(QasTDiagnosticreportMapper mapper) {
		this.diagnosticreportMapper = mapper;
	}

	public Class getMapperClass() {
		return QasTDiagnosticreportMapper.class;
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
	public boolean excuteAnaly(QasTDiagnosticreport diagnosticreport,String objId) throws Exception {
		boolean b = true;
		int i = 0;// 任务是否有对象的标志
		diagnosticreportMapper.insert(diagnosticreport);
		// 查询诊断对象
		List<QasTDiagnosetaskobj> list = null;
		if (objId == null) {//9FC2BFDAC1E340E2BFC98E4BE4AFD56E   //D4F203B19F1744E380B82E377B27B773
			list = diagnosetaskobjMapper.selectByTaskId(diagnosticreport.getDiagnosetaskid());
		} else {
			list = diagnosetaskobjMapper.selectById(objId);
		}
		// 诊断中介
		List<QasTDiagnosticintermediary> diagnosticIntermediarys = new ArrayList<QasTDiagnosticintermediary>();
		// 报告概述
		List<QasTDiagnosticreportsummry> diagnosticreportsummrys = new ArrayList<QasTDiagnosticreportsummry>();

		for (QasTDiagnosetaskobj diagnosetaskobj : list) {
			i = 1;
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
			// diagnosticintermediary.setDiagnosticobjid(diagnosetaskobj.getId());
			diagnosticintermediary.setDiagnosticobjid(diagnosetaskobj.getDiagnoseobjid());
			diagnosticintermediary.setDiagnosticobjname(diagnosetaskobj.getDiagnoseobjname());
			diagnosticintermediary.setDiagnosticreportsummryid(diagnosticreportsummry.getId());
			diagnosticIntermediarys.add(diagnosticintermediary);
			// 针对每个对象进行分析
			AnalyGeneral analyResult = this.analyByDiagnoseType(diagnosetaskobj, diagnosticintermediary.getId());

			// 针对每个对象创建静态页面。
			//b = freemarkerService.createHtml(analyResult,diagnosticintermediary, diagnosetaskobj);
			System.out.println(diagnosetaskobj.getDiagnoseobjname()+ "========静态页面生成========" + b+ "============================");
		}
		if (diagnosticIntermediarys.size() > 0) {
			diagnosticintermediaryMapper.insertBatch(diagnosticIntermediarys);
		}
		if (diagnosticreportsummrys.size() > 0) {
			diagnosticreportsummryMapper.insertBatch(diagnosticreportsummrys);
		}
		if (i == 0) {
			b = false;// 说明该任务下无对象
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
	public AnalyGeneral analyByDiagnoseType(
			QasTDiagnosetaskobj diagnosetaskobj, String intermediaryId)
			throws Exception {
		// 根据任务id查出所有的类型(模型指标关联)
		List<QasTSchemecatalog> list = schemecatalogMapper.selectByTaskId(diagnosetaskobj.getDiagnosetaskid());

		// 报告-类型
		List<QasTDiagnostictype> diagnostictypes = new ArrayList<QasTDiagnostictype>();

		// 创建装所有项目分析结果的list
		List<ItemFruitPage> itemAnalyList = new ArrayList<ItemFruitPage>();

		List<QasTSchemecatalog> listq = new ArrayList<QasTSchemecatalog>();

		for (int i = 0; i < list.size(); i++) {
			QasTDiagnostictype diagnostictype = new QasTDiagnostictype();
			diagnostictype.setId(IDGenerator.getUUID());
			diagnostictype.setDiagnosticintermediaryid(intermediaryId);
			diagnostictype.setIndicatorcatalogid(list.get(i)
					.getIndicatorcatalogid());
			diagnostictype.setOverview("总体概况");
			diagnostictype.setProblems("存在问题");
			diagnostictype.setSuggestions("改进建议");
			diagnostictype.setConclusion("结论");
			diagnostictype.setWeight(list.get(i).getWeight());
			diagnostictype.setSort(i + 1);

			// 项目分析
			TypeAnaly typeAnaly = this.analyByDiagnoseItem(list.get(i),
					diagnosetaskobj, diagnostictype.getId());
			itemAnalyList.addAll(typeAnaly.getItemFruitPageList());

			// TODO 组装分析类型结果
			diagnostictypes.add(diagnostictype);
		}
		if (diagnostictypes.size() > 0) {
			diagnostictypeMapper.insertBatch(diagnostictypes);
		}
		// 获取该诊断对象 总体概述的分析结果
		AnalyGeneral analyGeneral = this.getAnalyGeneral(diagnosetaskobj);
		analyGeneral.setItemFruitPageList(itemAnalyList);// 设置所有项目的分析结果

		return analyGeneral;
	}

	/**
	 * 项目诊断
	 * 
	 * @param schemecatalog
	 *            类型
	 * @param diagnosetaskobj
	 *            诊断对象
	 * @param diagnostictype
	 */
	// 模型指标关联 诊断任务与诊断对象 报告-类型id
	public TypeAnaly analyByDiagnoseItem(QasTSchemecatalog schemecatalog,
			QasTDiagnosetaskobj diagnosetaskobj, String typeId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("IndicatorCatalogId", schemecatalog.getIndicatorcatalogid());
		params.put("schemeid", schemecatalog.getSchemeid());

		String schemecatalogId = schemecatalog.getId();// 类型id
		// 查出该类型下的所有项目
		List<QasTSchemecatalog> list = schemecatalogMapper.selectParams(params);
		// List<QasTIndicatorcatalog> list =
		// indicatorcatalogMapper.selectByParams(params);
		List<QasTDiagnosticitem> diagnosticitems = new ArrayList<QasTDiagnosticitem>();

		// 创建装 类型下所有项目的分析结果的list
		List<ItemFruitPage> itemFruitPageList = new ArrayList<ItemFruitPage>();

		for (int i = 0; i < list.size(); i++) {
			// 创建传递参数的关联对象
			/*
			 * QasTSchemecatalog scheme = new QasTSchemecatalog();
			 * scheme.setIndicatorcatalogid(item.getId());
			 * scheme.setSchemeid(schemecatalog.getSchemeid());
			 */

			// 报告-项目
			QasTDiagnosticitem diagnosticitem = new QasTDiagnosticitem();
			// TODO 组装分析项目结果
			diagnosticitem.setId(IDGenerator.getUUID());
			diagnosticitem.setDiagnostictype(typeId);
			diagnosticitem.setIndicatorcatalogid(list.get(i).getIndicatorcatalogid());
			diagnosticitem.setProjectname(list.get(i).getIndicatorcatalog().getName_());//项目详情列表的名字
			diagnosticitem.setOverview("总体概况");
			diagnosticitem.setProblems("存在问题");
			diagnosticitem.setSuggestions("改进建议");
			diagnosticitem.setConclusion("结论");
			diagnosticitem.setWeight(list.get(i).getWeight());
			diagnosticitem.setSort(i + 1);
			diagnosticitems.add(diagnosticitem);

			// 创建项目分析结果的页面对象
			ItemFruitPage ifp = new ItemFruitPage();
			ItemAnaly itemAnaly = this.analyByDiagnoseElement(list.get(i),diagnosetaskobj, diagnosticitem.getId()); // 项目分析结果
			itemAnaly.setSchemecatalogId(schemecatalogId);// 将类型id关联到每个对象里面去
			ifp.setItemAnaly(itemAnaly);
			itemFruitPageList.add(ifp);
		}
		if (diagnosticitems.size() > 0) {
			diagnosticitemMapper.insertBatch(diagnosticitems);
		}
		TypeAnaly typeAnaly = new TypeAnaly();
		typeAnaly.setItemFruitPageList(itemFruitPageList);
		return typeAnaly;
	}

	/**
	 * 诊断项目
	 * 
	 * @param typeid
	 *            指标类型id
	 * @param schemeid
	 *            模板id
	 */
	/*
	 * public void analyByDiagnoseProject(QasTSchemecatalog schemecatalog) {
	 * Map<String, Object> params = new HashMap<String, Object>();
	 * params.put("IndicatorCatalogId", schemecatalog.getIndicatorcatalogid());
	 * params.put("schemeid", schemecatalog.getSchemeid()); //查出该类型下的所有项目
	 * List<QasTSchemecatalog> list = schemecatalogMapper.selectParams(params);
	 * List<QasTDiagnosticitem> diagnosticitems = new
	 * ArrayList<QasTDiagnosticitem>(); for (QasTSchemecatalog scheme : list) {
	 * this.analyByDiagnoseElement(scheme); QasTDiagnosticitem diagnosticitem =
	 * new QasTDiagnosticitem(); // TODO 组装分析项目结果
	 * diagnosticitem.setId(IDGenerator.getUUID());
	 * diagnosticitems.add(diagnosticitem); } if(diagnosticitems.size()>0){
	 * diagnosticitemMapper.insertBatch(diagnosticitems); } }
	 */

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
	public ItemAnaly analyByDiagnoseElement(QasTSchemecatalog schemecatalog,
			QasTDiagnosetaskobj diagnosetaskobj, String itemId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("IndicatorCatalogId", schemecatalog.getIndicatorcatalogid());// 项目的id
		params.put("schemeid", schemecatalog.getSchemeid());// 模型的id

		// 查出该项目下的所有要素
		List<QasTSchemecatalog> list = schemecatalogMapper.selectParams(params);
		// List<QasTIndicatorcatalog> list =
		// indicatorcatalogMapper.selectByParams(params);
		List<QasTDiagnosticelement> diagnosticelements = new ArrayList<QasTDiagnosticelement>();

		// 创建装要素分析结果的list
		List<ElementListMap2Class> elementList = new ArrayList<ElementListMap2Class>();
		// 创建装要素map的list
		List<BasicListMap2Class> basicList = new ArrayList<BasicListMap2Class>();

		for (int i = 0; i < list.size(); i++) {
			// 创建传递参数的关联对象
			/*
			 * QasTSchemecatalog scheme = new QasTSchemecatalog();
			 * scheme.setIndicatorcatalogid(element.getId());
			 * scheme.setSchemeid(schemecatalog.getSchemeid());
			 */

			// this.analyByDiagnoseContent(element);
			QasTDiagnosticelement diagnosticelement = new QasTDiagnosticelement();
			// TODO 组装分析项目结果
			diagnosticelement.setId(IDGenerator.getUUID());

			List<Molecule> moleculeList = this.analyByDiagnoseIndicator(
					list.get(i), diagnosetaskobj, diagnosticelement.getId());

			diagnosticelement.setElementstate(1); // 要素合格状态，必填字段
			diagnosticelement.setDiagnosticprojectid(itemId);
			diagnosticelement.setIndicatorcatalogid(list.get(i)
					.getIndicatorcatalogid());
			diagnosticelement.setElementname(list.get(i).getIndicatorcatalog()
					.getName_());
			diagnosticelement.setWeight(list.get(i).getWeight());
			diagnosticelement.setSort(i + 1);
			diagnosticelements.add(diagnosticelement);

			// 创建装单个要素分析结果的对象
			ElementListMap2Class elementMap = new ElementListMap2Class();
			// 这里element中对象属性值是没有的，所以会报空指针异常！
			elementMap.setElement(list.get(i).getIndicatorcatalog().getName_());// 要素的名称
			//elementMap.setElement("我是要素的名称");// 要素的名称
			elementMap.setMoleculeList(moleculeList);// 该要素下指标的分析结果
			elementList.add(elementMap);

			// 创建装要素的对象
			BasicListMap2Class basicMap = new BasicListMap2Class();
			basicMap.setBasicClass(ItemAnaly.BASIC_CLASS_N);// 要素的诊断结果，后期完善
			basicMap.setBasicName(list.get(i).getIndicatorcatalog().getName_());// 要素的名称
			basicList.add(basicMap);
		}
		if (diagnosticelements.size() > 0) {
			diagnosticelementMapper.insertBatch(diagnosticelements);
		}

		ProblemAndImprovement question1 = new ProblemAndImprovement();
		question1.setName("教学科研水平有待提升");
		question1.setQuestioninfo("在教师学历组成中，研究生学历以上教师占比较低，教师总体学历层次不高");
		question1.setSuggestioninfo("教师公开出版著作数量和省级以上在研课题数量均低于标准值，反映教师整体科研水平不高");

		ProblemAndImprovement question2 = new ProblemAndImprovement();
		question2.setName("教学科研水平有待提升");
		question2.setQuestioninfo("在教师学历组成中，研究生学历以上教师占比较低，教师总体学历层次不高");
		question2.setSuggestioninfo("教师公开出版著作数量和省级以上在研课题数量均低于标准值，反映教师整体科研水平不高");

		ProblemAndImprovement question3 = new ProblemAndImprovement();
		question3.setName("教学科研水平有待提升");
		question3.setQuestioninfo("在教师学历组成中，研究生学历以上教师占比较低，教师总体学历层次不高");
		question3.setSuggestioninfo("教师公开出版著作数量和省级以上在研课题数量均低于标准值，反映教师整体科研水平不高");

		ProblemAndImprovement question4 = new ProblemAndImprovement();
		question4.setName("教学科研水平有待提升");
		question4.setQuestioninfo("在教师学历组成中，研究生学历以上教师占比较低，教师总体学历层次不高");
		question4.setSuggestioninfo("教师公开出版著作数量和省级以上在研课题数量均低于标准值，反映教师整体科研水平不高");

		ProblemAndImprovement question5 = new ProblemAndImprovement();
		question5.setName("教学科研水平有待提升");
		question5.setQuestioninfo("在教师学历组成中，研究生学历以上教师占比较低，教师总体学历层次不高");
		question5.setSuggestioninfo("教师公开出版著作数量和省级以上在研课题数量均低于标准值，反映教师整体科研水平不高");

		ProblemAndImprovement question6 = new ProblemAndImprovement();
		question6.setName("教学科研水平有待提升");
		question6.setQuestioninfo("在教师学历组成中，研究生学历以上教师占比较低，教师总体学历层次不高");
		question6.setSuggestioninfo("教师公开出版著作数量和省级以上在研课题数量均低于标准值，反映教师整体科研水平不高");

		// 创建装问题描述与装改进意见的list
		List<ProblemAndImprovement> questionList = new ArrayList<ProblemAndImprovement>();
		questionList.add(question1);
		questionList.add(question2);
		questionList.add(question3);
		questionList.add(question4);
		questionList.add(question5);
		questionList.add(question6);

		// 创建装项目分析结果的对象
		ItemAnaly itemAnaly = new ItemAnaly();
		itemAnaly.setName(schemecatalog.getIndicatorcatalog().getName_()); // 项目名称
		itemAnaly.setReachClass(ItemAnaly.REACH_CLASS_N);
		itemAnaly.setReachValue("3%");
		itemAnaly.setBasicList(basicList);
		itemAnaly.setElementList(elementList);
		itemAnaly.setQuestionList(questionList);
		itemAnaly.setDiagnoseConclusion("不合格，请持续改进");

		return itemAnaly;
	}

	/**
	 * 诊断内容
	 * 
	 * @param indicatorcontentid
	 *            指标内容id
	 * @param schemeid
	 *            模板id
	 */
	public float analyByDiagnoseContent(QasTSchemecatalog schemecatalog) {
		float countScore = (float) 0.00;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("IndicatorCatalogId", schemecatalog.getIndicatorcatalogid());
		params.put("schemeid", schemecatalog.getSchemeid());
		List<QasTIndicatorratedefinition> list = IndicatorratedefinitionMapper
				.selectByParams(params);
		List<QasTDiagnosticquantitativeindicator> diagnosticquantitativeindicators = new ArrayList<QasTDiagnosticquantitativeindicator>();
		for (QasTIndicatorratedefinition indicatorratedefinition : list) {
			// TODO 分析指标
			QasTDiagnosticquantitativeindicator diagnosticquantitativeindicator = new QasTDiagnosticquantitativeindicator();
			diagnosticquantitativeindicator.setId(IDGenerator.getUUID());
			diagnosticquantitativeindicators
					.add(diagnosticquantitativeindicator);
		}
		if (diagnosticquantitativeindicators.size() > 0) {
			diagnosticquantitativeindicatorMapper
					.insertBatch(diagnosticquantitativeindicators);
		}
		return countScore;
	}

	public List<Map<String, Object>> selectDisgnoseObjByTaskId(
			QasTDiagnosticreport diagnosticreport) {
		return diagnosticreportMapper
				.selectDisgnoseObjByTaskId(diagnosticreport);
	}

	/*
	 * public List<Map<String, Object>> selectDisgnoseObj(QasTDiagnosticreport
	 * diagnosticreport) { return
	 * diagnosticreportMapper.selectDisgnoseObj(diagnosticreport); }
	 */

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
	public List<Molecule> analyByDiagnoseIndicator(
			QasTSchemecatalog schemecatalog,
			QasTDiagnosetaskobj diagnosetaskobj, String elementId) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("IndicatorCatalogId", schemecatalog.getIndicatorcatalogid()); // 要素的id
		params.put("schemeid", schemecatalog.getSchemeid()); // 模型的id
		// 查询该要素下的所有指标
		List<QasTIndicatorcontent> list1 = indicatorcontentMapper
				.selectByParams(params);

		List<Molecule> moleculelist = new ArrayList<Molecule>();
		for (QasTIndicatorcontent qasTIndicatorcontent : list1) {
			// 获取指标的分析结果
			moleculelist.add(this.getMolecule(qasTIndicatorcontent,
					diagnosetaskobj));
		}
		return moleculelist;
	}
	
	
	/**
	 * 获取统计结果
	 * 
	 * @param ic
	 *            指标内容
	 * @param obj
	 *            诊断对象
	 * @return
	 */
	public Molecule getMolecule(QasTIndicatorcontent indicatorcontent, QasTDiagnosetaskobj diagnosetaskobj) {
		
		Molecule molecule = new Molecule();
		
		/*String sqlString="select t3.* from(select * from tqas.t_hsum_external_d thd where thd.data_id=(select num4tb from((select num4tb,table_name from(select @a := @a+1 as num4tb,table_name,table_comment from information_schema.tables,(select @a := 0) n where table_schema = 'tqas' and table_name like '%qas_d_%' order by table_name) t1  where table_name='qas_d_course'))t2)) t3 left join t_cfg_data tcd on t3.data_id=tcd.data_id order by tcd.data_time desc limit 0,1";
		
		if(sqlString!=""&&sqlString!=null){
			System.out.println("sqlString开始执行");
			List<HashMap<String,Object>> list23=indicatorcontentMapper.queryDataBySql(sqlString);
			System.out.println("================list23是：==============="+list23);
			System.out.println("sqlString结束执行");
		}*/
		
		//数值型sqlString的示例:
		//对于数值型指标而言，mark的值为1代表双柱状图（复杂柱状图），mark的值为2代表单柱状图（简单柱状图）
		
		/*select 1 as mark,'毕业生的教学满意度' as indicatorName,date_format(sysdate(),'%Y%m') as name,'毕业生对教学满意的人数' as firstDesc,'毕业生总人数' as secondDesc,ifnull((select sum(int_08) from t_hsum_external_d thd where thd.data_id=29 and date_format(data_day,'%Y%m')=name),0) as firstNum,ifnull((select sum(int_01) from t_hsum_external_d thd where thd.data_id=29 and date_format(data_day,'%Y%m')=name),0) as secondNum
		union  all
		select 1 as mark,'毕业生的教学满意度' as indicatorName,date_format(DATE_ADD(sysdate(),INTERVAL -1 MONTH),'%Y%m') as name,'毕业生对教学满意的人数' as firstDesc,'毕业生总人数' as secondDesc,ifnull((select sum(int_08) from t_hsum_external_d thd where thd.data_id=29 and date_format(data_day,'%Y%m')=name),0) as firstNum,ifnull((select sum(int_01) from t_hsum_external_d thd where thd.data_id=29 and date_format(data_day,'%Y%m')=name),0) as secondNum
		union  all
		select 1 as mark,'毕业生的教学满意度' as indicatorName,date_format(DATE_ADD(sysdate(),INTERVAL -2 MONTH),'%Y%m') as name,'毕业生对教学满意的人数' as firstDesc,'毕业生总人数' as secondDesc,ifnull((select sum(int_08) from t_hsum_external_d thd where thd.data_id=29 and date_format(data_day,'%Y%m')=name),0) as firstNum,ifnull((select sum(int_01) from t_hsum_external_d thd where thd.data_id=29 and date_format(data_day,'%Y%m')=name),0) as secondNum
		union  all
		select 1 as mark,'毕业生的教学满意度' as indicatorName,date_format(DATE_ADD(sysdate(),INTERVAL -3 MONTH),'%Y%m') as name,'毕业生对教学满意的人数' as firstDesc,'毕业生总人数' as secondDesc,ifnull((select sum(int_08) from t_hsum_external_d thd where thd.data_id=29 and date_format(data_day,'%Y%m')=name),0) as firstNum,ifnull((select sum(int_01) from t_hsum_external_d thd where thd.data_id=29 and date_format(data_day,'%Y%m')=name),0) as secondNum
		union  all
		select 1 as mark,'毕业生的教学满意度' as indicatorName,date_format(DATE_ADD(sysdate(),INTERVAL -4 MONTH),'%Y%m') as name,'毕业生对教学满意的人数' as firstDesc,'毕业生总人数' as secondDesc,ifnull((select sum(int_08) from t_hsum_external_d thd where thd.data_id=29 and date_format(data_day,'%Y%m')=name),0) as firstNum,ifnull((select sum(int_01) from t_hsum_external_d thd where thd.data_id=29 and date_format(data_day,'%Y%m')=name),0) as secondNum;
*/
		
		
		/*select 2 as mark,'校企双导师数量' as indicatorName,date_format(sysdate(),'%Y%m') as name,'校企双导师数量对比' as sinpleDesc,ifnull(count(*),0) as resultNum from t_hsum_external_d thd where thd.data_id=17 and varchar100_32='是' and date_format(data_day,'%Y%m')=date_format(sysdate(),'%Y%m')
		union all 
		select 2 as mark,'校企双导师数量' as indicatorName,date_format(DATE_ADD(sysdate(),INTERVAL -1 MONTH),'%Y%m') as name,'校企双导师数量对比' as sinpleDesc,ifnull(count(*),0) as resultNum from t_hsum_external_d thd where thd.data_id=17 and varchar100_32='是' and date_format(data_day,'%Y%m')=date_format(DATE_ADD(sysdate(),INTERVAL -1 MONTH),'%Y%m')
		union all
		select 2 as mark,'校企双导师数量' as indicatorName,date_format(DATE_ADD(sysdate(),INTERVAL -2 MONTH),'%Y%m') as name,'校企双导师数量对比' as sinpleDesc,ifnull(count(*),0) as resultNum from t_hsum_external_d thd where thd.data_id=17 and varchar100_32='是' and date_format(data_day,'%Y%m')=date_format(DATE_ADD(sysdate(),INTERVAL -2 MONTH),'%Y%m')
		union all
		select 2 as mark,'校企双导师数量' as indicatorName,date_format(DATE_ADD(sysdate(),INTERVAL -3 MONTH),'%Y%m') as name,'校企双导师数量对比' as sinpleDesc,ifnull(count(*),0) as resultNum from t_hsum_external_d thd where thd.data_id=17 and varchar100_32='是' and date_format(data_day,'%Y%m')=date_format(DATE_ADD(sysdate(),INTERVAL -3 MONTH),'%Y%m')
		union all
		select 2 as mark,'校企双导师数量' as indicatorName,date_format(DATE_ADD(sysdate(),INTERVAL -4 MONTH),'%Y%m') as name,'校企双导师数量对比' as sinpleDesc,ifnull(count(*),0) as resultNum from t_hsum_external_d thd where thd.data_id=17 and varchar100_32='是' and date_format(data_day,'%Y%m')=date_format(DATE_ADD(sysdate(),INTERVAL -4 MONTH),'%Y%m');
*/
		
		
		//遍历取出sql语句
		String sql=indicatorcontent.getSqlstring();
		List<HashMap<String,Object>> list2=new ArrayList<HashMap<String,Object>>();
		//如果sql=null，在mapper.xml里面做了select 1 from dual处理，接收的时候做个判断即可
		if(sql!=""&&sql!=null){
			list2=indicatorcontentMapper.queryDataBySql(sql);
		}
		String indicatorName=null;//毕业生的教学满意度
		
		String name1=null;//201802
		String name2=null;//201803
		String name3=null;//201804
		String name4=null;//201805
		String name5=null;//201806
		
		String firstDesc=null;//毕业生对教学满意的人数
		String secondDesc=null;//毕业生总人数
		
		Float firstNum1=null;//2356
		Float secondNum1=null;//3000
		Float firstNum2=null;//2356
		Float secondNum2=null;//3000
		Float firstNum3=null;//2356
		Float secondNum3=null;//3000
		Float firstNum4=null;//2356
		Float secondNum4=null;//3000
		Float firstNum5=null;//2356
		Float secondNum5=null;//3000

		Float resultNum1=(float)0.00;//4000
		Float resultNum2=(float)0.00;//4000
		Float resultNum3=(float)0.00;//4000
		Float resultNum4=(float)0.00;//4000
		Float resultNum5=(float)0.00;//4000
		
		String sinpleDesc=null;//C类课程数对比
		String echartData="";
		Long mark=null;//对于数值型指标而言，1代表双柱状图（复杂柱状图），2代表单柱状图（简单柱状图）
		if(list2.size()>=0 && !list2.isEmpty()){
		    mark=(Long) list2.get(0).get("mark");
			//int len=list2.size();
				if(indicatorcontent.getIndicatordatatype()==1){  //数值型
					if(mark==2){
						//单柱状图
					    indicatorName=(String) list2.get(0).get("indicatorName");
					    
						/*String a="asda";
						for (int j = 0; j < 5; j++) {
							System.out.println(a+j);
						}*/
					    
				
					    name1=(String) list2.get(0).get("name");
					    name2=(String) list2.get(1).get("name");
					    name3=(String) list2.get(2).get("name");
					    name4=(String) list2.get(3).get("name");
					    name5=(String) list2.get(4).get("name");
						
						
		//				name=name.replace("-", "");
		//				System.out.println(name);
		//				String name="20180123";
		//				System.out.println(name.substring(0, 6));
					    if(list2.get(0).get("resultNum")!=null){
					    	resultNum1=Float.parseFloat(String.valueOf(list2.get(0).get("resultNum")));
					    }else{
					    	resultNum1=(float) 0;
					    }
					    if(list2.get(1).get("resultNum")!=null){
					    	resultNum2=Float.parseFloat(String.valueOf(list2.get(1).get("resultNum")));
					    }else{
					    	resultNum2=(float) 0;
					    }
						if(list2.get(2).get("resultNum")!=null){
							resultNum3=Float.parseFloat(String.valueOf(list2.get(2).get("resultNum")));
						}else{
					    	resultNum3=(float) 0;
					    }
						if(list2.get(3).get("resultNum")!=null){
							resultNum4=Float.parseFloat(String.valueOf(list2.get(3).get("resultNum")));
						}else{
					    	resultNum4=(float) 0;
					    }
						if(list2.get(4).get("resultNum")!=null){
							resultNum5=Float.parseFloat(String.valueOf(list2.get(4).get("resultNum")));
						}else{
					    	resultNum5=(float) 0;
					    }
						
						sinpleDesc=(String) list2.get(0).get("sinpleDesc");
						System.out.println("单柱状图:"+"mark:"+mark+"      indicatorName:"+indicatorName+"       name:"+name1+"      resultNum1:"+resultNum1+"        sinpleDesc:"+sinpleDesc);
						System.out.println("===========================");
							
						echartData+="[{name:'"+name1+"',value:"+resultNum1+"},{name:'"+name2+"',value:"+resultNum2+"},{name:'"+name3+"',value:"+resultNum3+"},{name:'"+name4+"',value:"+resultNum4+"},{name:'"+name5+"',value:"+resultNum5+"}]";
					    //随机数字k本应该是从数据库里查询出来的，建模时指定的合格标准数，有待完善
						float k=(float) (Math.random()*1000);
						System.out.println("随机数k:"+k);
						System.out.println("resultNum1:"+resultNum1+"  resultNum2:"+resultNum2+"  resultNum3:"+resultNum3+"  resultNum4:"+resultNum4+"  resultNum5:"+resultNum5);
						
						if(resultNum1>k){
							molecule.setStateClass("sbox-t-q");
							molecule.setStateName("合格");
							molecule.setConclusion("该指标本次诊断结果合格！");
						}else if(resultNum1<k){
							molecule.setStateClass("sbox-t-unq");
							molecule.setStateName("不合格");
							molecule.setConclusion("该指标本次诊断结果不合格！");
						}
						
						molecule.setType(Molecule.TYPE_ECHARTS);
						molecule.setIndicatorName(indicatorName);
						molecule.setEchartsFunction("singleBarChart");
						molecule.setEchartsData(echartData);
						System.out.println("==================单柱状图molecule.getEchartsData是==================:"+molecule.getEchartsData());
						molecule.setSinpleDesc(sinpleDesc);
						molecule.setFirstDesc("该值随便写");
						molecule.setSecondDesc("该值随便写");
						}else if(mark==1){
							//双柱状图
							mark=(Long) list2.get(0).get("mark");
						    indicatorName=(String) list2.get(0).get("indicatorName");
		
						    name1=(String) list2.get(0).get("name");
						    name2=(String) list2.get(1).get("name");
						    name3=(String) list2.get(2).get("name");
						    name4=(String) list2.get(3).get("name");
						    name5=(String) list2.get(4).get("name");
						    
						    firstDesc=(String) list2.get(0).get("firstDesc");
							secondDesc=(String) list2.get(0).get("secondDesc");
							
							if(list2.get(0).get("firstNum")!=null){
								firstNum1=Float.parseFloat(String.valueOf(list2.get(0).get("firstNum")));
							}else{
								firstNum1=(float) 0;
						    }
							if(list2.get(0).get("secondNum")!=null){
								secondNum1=Float.parseFloat(String.valueOf(list2.get(0).get("secondNum")));
							}else{
								secondNum1=(float) 0;
						    }
							if(list2.get(1).get("firstNum")!=null){
								firstNum2=Float.parseFloat(String.valueOf(list2.get(1).get("firstNum")));
							}else{
								firstNum2=(float) 0;
						    }
							if(list2.get(1).get("secondNum")!=null){
								secondNum2=Float.parseFloat(String.valueOf(list2.get(1).get("secondNum")));
							}else{
								secondNum2=(float) 0;
						    }
							if(list2.get(2).get("firstNum")!=null){
								firstNum3=Float.parseFloat(String.valueOf(list2.get(2).get("firstNum")));
							}else{
								firstNum3=(float) 0;
						    }
							if(list2.get(2).get("secondNum")!=null){
								secondNum3=Float.parseFloat(String.valueOf(list2.get(2).get("secondNum")));
							}else{
								secondNum3=(float) 0;
						    }
							if(list2.get(3).get("firstNum")!=null){
								firstNum4=Float.parseFloat(String.valueOf(list2.get(3).get("firstNum")));
							}else{
								firstNum4=(float) 0;
						    }
							if(list2.get(3).get("secondNum")!=null){
								secondNum4=Float.parseFloat(String.valueOf(list2.get(3).get("secondNum")));
							}else{
								secondNum4=(float) 0;
						    }
							if(list2.get(4).get("firstNum")!=null){
								firstNum5=Float.parseFloat(String.valueOf(list2.get(4).get("firstNum")));
							}else{
								firstNum5=(float) 0;
						    }
							if(list2.get(4).get("secondNum")!=null){
								secondNum5=Float.parseFloat(String.valueOf(list2.get(4).get("secondNum")));
							}else{
								secondNum5=(float) 0;
						    }
							
							System.out.println("双柱状图:"+"mark:"+mark+"      indicatorName:"+indicatorName+"       name:"+name1+"      firstDesc:"+firstDesc+"        secondDesc:"+secondDesc+"      firstNum1:"+firstNum1+"      secondNum1:"+secondNum1+"      firstNum2:"+firstNum2+"      secondNum2:"+secondNum2+"      firstNum3:"+firstNum3+"      secondNum3:"+secondNum3+"      firstNum4:"+firstNum4+"      secondNum4:"+secondNum4+"      firstNum5:"+firstNum5+"      secondNum5:"+secondNum5);
							System.out.println("===========================");
							
							echartData+="[{name:'"+name1+"',value1:"+firstNum1+",value2:"+secondNum1+"},{name:'"+name2+"',value1:"+firstNum2+",value2:"+secondNum2+"},{name:'"+name3+"',value1:"+firstNum3+",value2:"+secondNum3+"},{name:'"+name4+"',value1:"+firstNum4+",value2:"+secondNum4+"},{name:'"+name5+"',value1:"+firstNum5+",value2:"+secondNum5+"}]";
						
							System.out.println("firstNum1:"+firstNum1+"  secondNum1:"+secondNum1+"  firstNum1/secondNum1:"+firstNum1/secondNum1);
							System.out.println("firstNum2:"+firstNum2+"  secondNum2:"+secondNum2+"  firstNum2/secondNum2:"+firstNum2/secondNum2);
							System.out.println("firstNum3:"+firstNum3+"  secondNum3:"+secondNum3+"  firstNum3/secondNum3:"+firstNum3/secondNum3);
							System.out.println("firstNum4:"+firstNum4+"  secondNum4:"+secondNum4+"  firstNum4/secondNum4:"+firstNum4/secondNum4);
							System.out.println("firstNum5:"+firstNum5+"  secondNum5:"+secondNum5+"  firstNum5/secondNum5:"+firstNum5/secondNum5);
							if(secondNum2>0){
								if(firstNum1/secondNum2>=0.6){
									molecule.setStateClass("sbox-t-q");
									molecule.setStateName("合格");
									molecule.setConclusion("该指标本次诊断结果合格！");
								}else if(firstNum1/secondNum2>=0 && firstNum1/secondNum2<0.6){
									molecule.setStateClass("sbox-t-unq");
									molecule.setStateName("不合格");
									molecule.setConclusion("该指标本次诊断结果不合格！");
								}
							}else{
								molecule.setStateClass("sbox-t-unq");
								molecule.setStateName("不合格");
								molecule.setConclusion("该指标本次诊断结果不合格！");
							}
							
							molecule.setType(Molecule.TYPE_ECHARTS);
							molecule.setIndicatorName(indicatorName);
							molecule.setEchartsFunction("doubleBarChart");
							molecule.setEchartsData(echartData);
							System.out.println("==================双柱状图molecule.getEchartsData是==================:"+molecule.getEchartsData());
							molecule.setFirstDesc(firstDesc);
							molecule.setSecondDesc(secondDesc);
							molecule.setSinpleDesc("该值随便写");
						}
				}
			}else if(indicatorcontent.getIndicatordatatype()==2){//判断型
				//判断型
				TableMap2Class tableMap = new TableMap2Class();
				List<String> theadList = new ArrayList<String>();
				List<String> ntdList = new ArrayList<String>();
				List<String> ytdList = new ArrayList<String>();
				int count = 0;
				for(int i = 1;i<=4;i++){
					theadList.add("2018年0"+i+"月");
					if(((int)(Math.random()*10+1))>5){//随机数控制是和否，测试数据
						ntdList.add("<i class='icon-small unqualified'></i>");
						ytdList.add("");
					}else{
						count ++;
						ntdList.add("");
						ytdList.add("<i class='icon-small qualified'></i>");
					}
					tableMap.setTheadList(theadList);
					tableMap.setYtdList(ytdList);
					tableMap.setNtdList(ntdList);
				}
				molecule.setType(Molecule.TYPE_TABLE);
				molecule.setIndicatorName(indicatorcontent.getName_());
				molecule.setTableMap(tableMap);
				if(count<2){//随机数控制是否合格，测试数据
					molecule.setStateClass("sbox-t-unq");
					molecule.setStateName("不合格");
					molecule.setConclusion("该指标本次诊断结果不合格！");
				}
				
				molecule.setType(Molecule.TYPE_ECHARTS);
				molecule.setIndicatorName(indicatorName);
				molecule.setEchartsFunction("singleBarChart");
				molecule.setEchartsData(echartData);
				molecule.setSinpleDesc(sinpleDesc);
				molecule.setFirstDesc("该值随便写");
				molecule.setSecondDesc("该值随便写");
			
			}else{//标志型
				
		}
		
		String echartData2="[{name:'201708',value1:4123,value2:5000}," +
				 "{name:'201709',value1:3800,value2:4000}," +
				 "{name:'201710',value1:2660,value2:4500}," +
				 "{name:'201711',value1:2875,value2:5500}," +
				 "{name:'201712',value1:1657,value2:4800}]";
		
		//无值
		/*String echartData3="[{name:'201708',value:4123}," +
				 "{name:'201709',value:3800}," +
				 "{name:'201710',value:2660}," +
				 "{name:'201711',value:2875}," +
				 "{name:'201712',value:1657}]";*/
		
		//两个很粗的柱状图
		String echartData4="[{name:'201708',value1:4123,value2:5000}]";
		
		String echartData5="[{name:'201708',value:4123}]";
		return molecule;
		
		/*molecule.setType(Molecule.TYPE_ECHARTS);
		molecule.setStateClass("sbox-t-q");
		molecule.setStateName("合格");
		molecule.setIndicatorName(indicatorName);
		molecule.setConclusion("因数据缺失，本次诊断结果为空，请补全数据再次进行诊断");
		molecule.setEchartsFunction("doubleBarChart");
		molecule.setEchartsData(echartData2);*/
		
		/*molecule.setEchartsFunction("singleBarChart");
		molecule.setEchartsData(echartData3);
		molecule.setEchartsData(echartData5);*/
		
		/*
		//柱状图(和曲线图)(data值为两个，用,隔开)
		//饼状图(data值为一个)
		//表格的map的键为tableData
		//定义变量标记形状
		int mark=-1;//0为饼状图,1为柱状图(曲线图),2为表格
		String echartData="";
		//创建装表格数据的list
		List<String> theadList = new ArrayList<String>();
		List<String> ytdList = new ArrayList<String>();
		List<String> ntdList = new ArrayList<String>();
		for (int i=0;i<list2.size();i++) {
			if(String.valueOf(list2.get(i).get("data")).indexOf(",")<0 && !list2.get(i).containsKey("tableData")){
				System.out.println("该数据是饼状图");
				mark=0;//饼状图
				String name=(String)list2.get(i).get("name");//201801,201712,201711,201710
				BigDecimal data=(BigDecimal) list2.get(i).get("data");//554.2800
				//Double data1=Double.parseDouble((String)list2.get(i).get("data"));
				if(name!=null){
					if(i==list2.size()-1){
						echartData+="{name:'"+name.split(",")[i]+"',value:"+data+"}]";
					}else if(i==0){
						echartData+="[{name:'"+name.split(",")[i]+"',value:"+data+"},";
					}else{
						echartData+="{name:'"+name.split(",")[i]+"',value:"+data+"},";
					}
				}
			}else if(String.valueOf(list2.get(i).get("data")).indexOf(",")>=0){
				System.out.println("该数据是柱状图(曲线图)");
				mark=1;//柱状图(曲线图)
				String name=(String)list2.get(i).get("name");//201801,201712,201711,201710
				String data=(String)list2.get(i).get("data");//233.6000,714.0800
				Double max=0.0;
				Double min=0.0;
				if(data!=null){
					Double a=Double.parseDouble(data.split(",")[0]);
					Double b=Double.parseDouble(data.split(",")[1]);
					max=(a>b)?a:b;
					min=(a<b)?a:b;
				}
			
				if(name!=null){
					if(i==list2.size()-1){
						echartData+="{name:'"+name.split(",")[i]+"',value1:"+min+",value2:"+max+"}]";
					}else if(i==0){
						echartData+="[{name:'"+name.split(",")[i]+"',value1:"+min+",value2:"+max+"},";
					}else{
						echartData+="{name:'"+name.split(",")[i]+"',value1:"+min+",value2:"+max+"},";
					}
				}
			}else{
				if(list2.get(i).containsKey("tableData")){
				System.out.println("该数据是表格");
				mark=2;//表格
				String[] arr={};
				String tableData=(String) list2.get(i).get("tableData");//2017年08月,2017年08月,2017年08月,2017年08月
				if(tableData!=null){
					arr=tableData.split(",");//[2017年08月,2017年08月,2017年08月,2017年08月]
				}
				for (int j = 0; j < arr.length; j++) {
					theadList.add(arr[j]);
					//theadList=Arrays.asList(arr);
					ytdList.add("<i class='icon-small qualified'></i>");
					ntdList.add("<i class='icon-small unqualified'></i>");
					}
				}
			}
		}
		System.out.println("echartData是："+echartData);
		System.out.println("theadList是："+theadList);
		System.out.println("ytdList是："+ytdList);
		System.out.println("ntdList是："+ntdList);
		//饼状图
		if(mark==0){
			//先把它当做柱状图去显示吧
			molecule.setType(Molecule.TYPE_ECHARTS);
			molecule.setStateClass("sbox-t-unq");
			molecule.setStateName("不合格");
			molecule.setIndicatorName("是否明确核心岗位和专业要求（职业能力分析）");
			molecule.setConclusion("因数据缺失，本次诊断结果为空，请补全数据再次进行诊断");
			molecule.setEchartsFunction("doubleBarChart");
			molecule.setEchartsData(echartData);
		}
		
		//柱状图(曲线图)
		if(mark==1){
			molecule.setType(Molecule.TYPE_ECHARTS);
			molecule.setStateClass("sbox-t-unq");
			molecule.setStateName("不合格");
			molecule.setIndicatorName("是否明确核心岗位和专业要求（职业能力分析）");
			molecule.setConclusion("因数据缺失，本次诊断结果为空，请补全数据再次进行诊断");
			molecule.setEchartsFunction("doubleBarChart");
			molecule.setEchartsData(echartData);
		}
		
		//表格展示数据
		if(mark==2){
			//创建装表格数据的对象
			TableMap2Class tableMap=new TableMap2Class();
			tableMap.setNtdList(ntdList);
			tableMap.setTheadList(theadList);
			tableMap.setYtdList(ytdList);
			
			molecule.setType(Molecule.TYPE_TABLE);//表格类型
			molecule.setStateClass("sbox-t-unq");
			molecule.setStateName("不合格");
			molecule.setIndicatorName("人才培养方案是否邀请三位以上行业专家和学生代表进行评审");
			molecule.setTableMap(tableMap);
			molecule.setConclusion("因数据缺失，本次诊断结果为空，请补全数据再次进行诊断");
		}*/
			//return molecule;
			
			
		
		/*if ("1".equals(indicatorcontent.getId())) {//复杂柱状图   不合格
			molecule.setType(Molecule.TYPE_ECHARTS);
			molecule.setStateClass("sbox-t-unq");
			molecule.setStateName("不合格");
			molecule.setIndicatorName("是否明确核心岗位和专业要求（职业能力分析）");
			molecule.setConclusion("因数据缺失，本次诊断结果为空，请补全数据再次进行诊断");
			molecule.setEchartsFunction("doubleBarChart");
			molecule.setEchartsData("[{name:'201708',value1:4123,value2:5000}," +
									 "{name:'201709',value1:3800,value2:4000}," +
									 "{name:'201710',value1:2660,value2:4500}," +
									 "{name:'201711',value1:2875,value2:5500}," +
									 "{name:'201712',value1:1657,value2:4800}]");
		} else if ("2".equals(indicatorcontent.getId())) {//复杂柱状图   合格
			molecule.setType(Molecule.TYPE_ECHARTS);
			molecule.setStateClass("sbox-t-q");
			molecule.setStateName("合格");
			molecule.setIndicatorName("应届毕业生自主创业所占比例");
			molecule.setConclusion("完美");
			molecule.setEchartsFunction("doubleBarChart");
			molecule.setEchartsData("[{name:'201708',value1:4123,value2:5000}," +
									  "{name:'201709',value1:3800,value2:4000}," +
									  "{name:'201710',value1:2660,value2:4500}," +
									  "{name:'201711',value1:2875,value2:5500}," +
									  "{name:'201712',value1:1657,value2:4800}]");
		} else if ("3".equals(indicatorcontent.getId())) {//简单柱状图   不合格
			molecule.setType(Molecule.TYPE_ECHARTS);
			molecule.setStateClass("sbox-t-unq");
			molecule.setStateName("不合格");
			molecule.setIndicatorName("应届毕业生自主创业所占比例");
			molecule.setConclusion("完美");
			molecule.setEchartsFunction("singleLineChart");
			molecule.setEchartsData("[{name:'201708',value1:4123,value2:5000}," +
									  "{name:'201709',value1:3800,value2:4000}," +
									  "{name:'201710',value1:2660,value2:4500}," +
									  "{name:'201711',value1:2875,value2:5500}," +
									  "{name:'201712',value1:1657,value2:4800}]");
		} else if ("4".equals(indicatorcontent.getId())) {//简单柱状图   合格
			molecule.setType(Molecule.TYPE_ECHARTS);
			molecule.setStateClass("sbox-t-q");
			molecule.setStateName("合格");
			molecule.setIndicatorName("应届毕业生自主创业所占比例");
			molecule.setConclusion("完美");
			molecule.setEchartsFunction("singleLineChart");
			molecule.setEchartsData("[{name:'201708',value1:4123,value2:5000}," +
									  "{name:'201709',value1:3800,value2:4000}," +
									  "{name:'201710',value1:2660,value2:4500}," +
									  "{name:'201711',value1:2875,value2:5500}," +
					                  "{name:'201712',value1:1657,value2:4800}]");
		} else if ("5".equals(indicatorcontent.getId())) {//表格
			//创建装表格数据的list
			List<String> theadList = new ArrayList<String>();
			theadList.add("2017年08月");
			theadList.add("2017年09月");
			theadList.add("2017年10月");
			theadList.add("2017年11月");
			List<String> ytdList = new ArrayList<String>();
			ytdList.add("<i class='icon-small qualified'></i>");
			ytdList.add("");
			ytdList.add("<i class='icon-small qualified'></i>");
			ytdList.add("");
			List<String> ntdList = new ArrayList<String>();
			ntdList.add("");
			ntdList.add("<i class='icon-small unqualified'></i>");
			ntdList.add("");
			ntdList.add("<i class='icon-small unqualified'></i>");
			
			//创建装表格数据的map
			Map<String, Object> tableMap = new HashMap<String, Object>();
			tableMap.put("theadList", theadList);
			tableMap.put("ytdList", ytdList);
			tableMap.put("ntdList", ntdList);
			
			molecule.setType(Molecule.TYPE_TABLE);//表格类型
			molecule.setStateClass("sbox-t-unq");
			molecule.setStateName("不合格");
			molecule.setIndicatorName("人才培养方案是否邀请三位以上行业专家和学生代表进行评审");
			molecule.setTableMap(tableMap);
			molecule.setConclusion("因数据缺失，本次诊断结果为空，请补全数据再次进行诊断");
		}
		return molecule;*/
	}

	/**
	 * 获取总体概述的分析结果 该方法要与入库表做数据交互，最后才分析得出数据的
	 * 
	 * @param object
	 */
	public AnalyGeneral getAnalyGeneral(QasTDiagnosetaskobj diagnosetaskobj) {
		// 创建量化指标对象
		QuantitativeMap2Class quantitativeMap = new QuantitativeMap2Class();
		quantitativeMap.setNum("30");// 量化指标的数量
		quantitativeMap.setScore("2.2");
//		quantitativeMap.setQualifiedNum("20");// 合格
//		quantitativeMap.setEarlyWarningNum("8");// 预警
//		quantitativeMap.setUnqualifiedNum("6");// 不合格

		// 标志性成果指标对象
		SignMap2Class signMap = new SignMap2Class();
		signMap.setNum("33");// 标志性成果指标的数量
		signMap.setAchieve("27");// 标志性成果的达成度
		signMap.setResultCount("[{name:'国家级',total:'30',value:'20'},{name:'省级',total:'30',value:'10'},"
				+ "{name:'市级',total:'40',value:'10'},{name:'院校级',total:'46',value:'24'}]");

		// 创建总体概述总体诊断结果对象
		GeneralOverview rgm = new GeneralOverview();
		rgm.setObjName("计算机专业");
		rgm.setScore("76.6");
		rgm.setRanking("16");
		rgm.setFruit("合格");
		rgm.setQuantitativeMap(quantitativeMap);
		rgm.setSignMap(signMap);

		// 造数据
		IndicatorResult indicatorResult01 = new IndicatorResult();
		indicatorResult01.setName("是否明确专业核心岗位和能力要求（职业能力分析）");
		indicatorResult01.setResult("是");
		indicatorResult01.setAcceptanceValue("X=是");

		IndicatorResult indicatorResult02 = new IndicatorResult();
		indicatorResult02.setName("是否明确专业核心岗位和能力要求（职业能力分析）");
		indicatorResult02.setResult("是");
		indicatorResult02.setAcceptanceValue("X=是");

		IndicatorResult indicatorResult03 = new IndicatorResult();
		indicatorResult03.setName("是否明确专业核心岗位和能力要求（职业能力分析）");
		indicatorResult03.setResult("是");
		indicatorResult03.setAcceptanceValue("X=是");

		IndicatorResult indicatorResult04 = new IndicatorResult();
		indicatorResult04.setName("是否明确专业核心岗位和能力要求（职业能力分析）");
		indicatorResult04.setResult("是");
		indicatorResult04.setAcceptanceValue("X=是");

		IndicatorResult indicatorResult05 = new IndicatorResult();
		indicatorResult05.setName("是否明确专业核心岗位和能力要求（职业能力分析）");
		indicatorResult05.setResult("是");
		indicatorResult05.setAcceptanceValue("X=是");

		IndicatorResult indicatorResult06 = new IndicatorResult();
		indicatorResult06.setName("是否明确专业核心岗位和能力要求（职业能力分析）");
		indicatorResult06.setResult("是");
		indicatorResult06.setAcceptanceValue("X=是");

		IndicatorResult indicatorResult07 = new IndicatorResult();
		indicatorResult07.setName("是否明确专业核心岗位和能力要求（职业能力分析）");
		indicatorResult07.setResult("是");
		indicatorResult07.setAcceptanceValue("X=是");

		IndicatorResult indicatorResult08 = new IndicatorResult();
		indicatorResult08.setName("是否明确专业核心岗位和能力要求（职业能力分析）");
		indicatorResult08.setResult("是");
		indicatorResult08.setAcceptanceValue("X=是");

		IndicatorResult indicatorResult09 = new IndicatorResult();
		indicatorResult09.setName("是否明确专业核心岗位和能力要求（职业能力分析）");
		indicatorResult09.setResult("是");
		indicatorResult09.setAcceptanceValue("X=是");

		IndicatorResult indicatorResult10 = new IndicatorResult();
		indicatorResult10.setName("是否明确专业核心岗位和能力要求（职业能力分析）");
		indicatorResult10.setResult("是");
		indicatorResult10.setAcceptanceValue("X=是");

		IndicatorResult indicatorResult11 = new IndicatorResult();
		indicatorResult11.setName("是否明确专业核心岗位和能力要求（职业能力分析）");
		indicatorResult11.setResult("是");
		indicatorResult11.setAcceptanceValue("X=是");

		IndicatorResult indicatorResult12 = new IndicatorResult();
		indicatorResult12.setName("是否明确专业核心岗位和能力要求（职业能力分析）");
		indicatorResult12.setResult("是");
		indicatorResult12.setAcceptanceValue("X=是");

		IndicatorResult indicatorResult13 = new IndicatorResult();
		indicatorResult13.setName("是否明确专业核心岗位和能力要求（职业能力分析）");
		indicatorResult13.setResult("是");
		indicatorResult13.setAcceptanceValue("X=是");

		IndicatorResult indicatorResult14 = new IndicatorResult();
		indicatorResult14.setName("是否明确专业核心岗位和能力要求（职业能力分析）");
		indicatorResult14.setResult("是");
		indicatorResult14.setAcceptanceValue("X=是");

		List<IndicatorResult> indicatorResultList01 = new ArrayList<IndicatorResult>();
		indicatorResultList01.add(indicatorResult01);
		indicatorResultList01.add(indicatorResult02);
		indicatorResultList01.add(indicatorResult03);
		indicatorResultList01.add(indicatorResult04);
		indicatorResultList01.add(indicatorResult05);
		indicatorResultList01.add(indicatorResult06);
		indicatorResultList01.add(indicatorResult07);
		indicatorResultList01.add(indicatorResult08);
		indicatorResultList01.add(indicatorResult09);
		indicatorResultList01.add(indicatorResult10);
		indicatorResultList01.add(indicatorResult11);
		indicatorResultList01.add(indicatorResult12);
		indicatorResultList01.add(indicatorResult13);
		indicatorResultList01.add(indicatorResult14);

		ItemGeneral itemGeneral01 = new ItemGeneral();
		itemGeneral01.setItemName("专业建设与规划");
		itemGeneral01.setResult("已达标");
		itemGeneral01.setResultClass("qualified");
		itemGeneral01.setQualifiedNum(14);
		itemGeneral01.setEarlyWarningNum(0);
		itemGeneral01.setUnqualifiedNum(0);
		itemGeneral01.setIndicatorResultList(indicatorResultList01);

		List<IndicatorResult> indicatorResultList02 = new ArrayList<IndicatorResult>();
		indicatorResultList02.add(indicatorResult01);
		indicatorResultList02.add(indicatorResult02);
		indicatorResultList02.add(indicatorResult03);
		indicatorResultList02.add(indicatorResult04);
		indicatorResultList02.add(indicatorResult05);
		indicatorResultList02.add(indicatorResult06);

		ItemGeneral itemGeneral02 = new ItemGeneral();
		itemGeneral02.setItemName("教育教学改革");
		itemGeneral02.setResult("预警");
		itemGeneral02.setResultClass("warn");
		itemGeneral02.setQualifiedNum(3);
		itemGeneral02.setEarlyWarningNum(7);
		itemGeneral02.setUnqualifiedNum(1);
		itemGeneral02.setIndicatorResultList(indicatorResultList02);

		List<IndicatorResult> indicatorResultList03 = new ArrayList<IndicatorResult>();
		indicatorResultList03.add(indicatorResult01);
		indicatorResultList03.add(indicatorResult02);
		indicatorResultList03.add(indicatorResult03);

		ItemGeneral itemGeneral03 = new ItemGeneral();
		itemGeneral03.setItemName("学生成长与发展");
		itemGeneral03.setResult("预警");
		itemGeneral03.setResultClass("warn");
		itemGeneral03.setQualifiedNum(2);
		itemGeneral03.setEarlyWarningNum(6);
		itemGeneral03.setUnqualifiedNum(2);
		itemGeneral03.setIndicatorResultList(indicatorResultList03);

		List<IndicatorResult> indicatorResultList04 = new ArrayList<IndicatorResult>();
		indicatorResultList04.add(indicatorResult01);
		indicatorResultList04.add(indicatorResult02);
		indicatorResultList04.add(indicatorResult03);

		ItemGeneral itemGeneral04 = new ItemGeneral();
		itemGeneral04.setItemName("师资建设与规划");
		itemGeneral04.setResult("已达标");
		itemGeneral04.setResultClass("qualified");
		itemGeneral04.setQualifiedNum(3);
		itemGeneral04.setEarlyWarningNum(0);
		itemGeneral04.setUnqualifiedNum(0);
		itemGeneral04.setIndicatorResultList(indicatorResultList04);

		List<IndicatorResult> indicatorResultList05 = new ArrayList<IndicatorResult>();
		indicatorResultList05.add(indicatorResult01);
		indicatorResultList05.add(indicatorResult02);
		indicatorResultList05.add(indicatorResult03);

		ItemGeneral itemGeneral05 = new ItemGeneral();
		itemGeneral05.setItemName("教学资源");
		itemGeneral05.setResult("预警");
		itemGeneral05.setResultClass("warn");
		itemGeneral05.setQualifiedNum(1);
		itemGeneral05.setEarlyWarningNum(5);
		itemGeneral05.setUnqualifiedNum(2);
		itemGeneral05.setIndicatorResultList(indicatorResultList05);

		List<IndicatorResult> indicatorResultList06 = new ArrayList<IndicatorResult>();
		indicatorResultList06.add(indicatorResult01);
		indicatorResultList06.add(indicatorResult02);
		indicatorResultList06.add(indicatorResult03);

		ItemGeneral itemGeneral06 = new ItemGeneral();
		itemGeneral06.setItemName("社会服务");
		itemGeneral06.setResult("未达标");
		itemGeneral06.setResultClass("unqualified");
		itemGeneral06.setQualifiedNum(0);
		itemGeneral06.setEarlyWarningNum(0);
		itemGeneral06.setUnqualifiedNum(7);
		itemGeneral06.setIndicatorResultList(indicatorResultList06);

		List<IndicatorResult> indicatorResultList07 = new ArrayList<IndicatorResult>();
		indicatorResultList07.add(indicatorResult01);
		indicatorResultList07.add(indicatorResult02);
		indicatorResultList07.add(indicatorResult03);

		ItemGeneral itemGeneral07 = new ItemGeneral();
		itemGeneral07.setItemName("对外交流与合作");
		itemGeneral07.setResult("未达标");
		itemGeneral07.setResultClass("unqualified");
		itemGeneral07.setQualifiedNum(0);
		itemGeneral07.setEarlyWarningNum(0);
		itemGeneral07.setUnqualifiedNum(5);
		itemGeneral07.setIndicatorResultList(indicatorResultList07);

		List<IndicatorResult> indicatorResultList08 = new ArrayList<IndicatorResult>();
		indicatorResultList08.add(indicatorResult01);
		indicatorResultList08.add(indicatorResult02);
		indicatorResultList08.add(indicatorResult03);

		ItemGeneral itemGeneral08 = new ItemGeneral();
		itemGeneral08.setItemName("科研与实训");
		itemGeneral08.setResult("已达标");
		itemGeneral08.setResultClass("qualified");
		itemGeneral08.setQualifiedNum(5);
		itemGeneral08.setEarlyWarningNum(0);
		itemGeneral08.setUnqualifiedNum(0);
		itemGeneral08.setIndicatorResultList(indicatorResultList08);

		// 创建装所有项目的诊断结果list
		List<ItemGeneral> itemList = new ArrayList<ItemGeneral>();
		itemList.add(itemGeneral01);
		itemList.add(itemGeneral02);
		itemList.add(itemGeneral03);
		itemList.add(itemGeneral04);
		itemList.add(itemGeneral05);
		itemList.add(itemGeneral06);
		itemList.add(itemGeneral07);
		itemList.add(itemGeneral08);

		// 创建装所有项目的总结和雷达图数据map
		ItemsMap2Class itemsMap = new ItemsMap2Class();
		itemsMap.setItemsAndObj("专业建设与规划，教育教学改革，学生成长与发展，师资建设与规划，教学资源，社会服务，对外交流与合作，科研与实训这8大方面对食品生物技术专业");
		itemsMap.setStandardRate("76.6%");
		// itemsMap.setItemsData("[{value:[2,8,9.6,18,7.2,9.8,8,14],name:'合格率'},{value:[2,10,12,18,8,20,16,14],name:'权重'}]");
		itemsMap.setItemsData("[{value:[2,8,9.6,18,7.2,9.8,8,14],name:'得分为'},{value:[2,10,12,18,8,20,16,14],name:'占比为'}]");
		itemsMap.setItemsName("[{name:'专业建设与规划',max:_max},{name:'教育教学改革',max:_max},{name:'学生成长与发展',max:_max},"
				+ "{name:'师资建设与规划',max:_max},{name:'教学资源',max:_max},{name:'社会服务',max:_max},{name:'对外交流与合作',max:_max},"
				+ "{name:'科研与实训',max:_max}]");

		// 创建装问题描述与装改进意见的对象
		ProblemAndImprovement question1 = new ProblemAndImprovement();
		question1.setName("教学科研水平有待提升");
		question1.setQuestioninfo("在教师学历组成中，研究生学历以上教师占比较低，教师总体学历层次不高");
		question1.setSuggestioninfo("教师公开出版著作数量和省级以上在研课题数量均低于标准值，反映教师整体科研水平不高");

		ProblemAndImprovement question2 = new ProblemAndImprovement();
		question2.setName("教学科研水平有待提升");
		question2.setQuestioninfo("在教师学历组成中，研究生学历以上教师占比较低，教师总体学历层次不高");
		question2.setSuggestioninfo("教师公开出版著作数量和省级以上在研课题数量均低于标准值，反映教师整体科研水平不高");

		ProblemAndImprovement question3 = new ProblemAndImprovement();
		question3.setName("教学科研水平有待提升");
		question3.setQuestioninfo("在教师学历组成中，研究生学历以上教师占比较低，教师总体学历层次不高");
		question3.setSuggestioninfo("教师公开出版著作数量和省级以上在研课题数量均低于标准值，反映教师整体科研水平不高");

		ProblemAndImprovement question4 = new ProblemAndImprovement();
		question4.setName("教学科研水平有待提升");
		question4.setQuestioninfo("在教师学历组成中，研究生学历以上教师占比较低，教师总体学历层次不高");
		question4.setSuggestioninfo("教师公开出版著作数量和省级以上在研课题数量均低于标准值，反映教师整体科研水平不高");
		// 创建装问题描述与装改进意见的list
		List<ProblemAndImprovement> questionList = new ArrayList<ProblemAndImprovement>();
		questionList.add(question1);
		questionList.add(question2);
		questionList.add(question3);
		questionList.add(question4);

		// 创建总体概述各诊断对象的对比结果对象
		ObjGeneralMolecule objGeneralMolecule = new ObjGeneralMolecule();
		objGeneralMolecule
				.setEchartsData("[{name:'汽车电子技术',value:80},{name:'汽车服务与营销',value:90},{name:'材料工程技术',value:39},"
						+ "{name:'市政工程技术',value:67},{name:'模具涉及与制造',value:78},{name:'电气自动化技术',value:46},"
						+ "{name:'电子信息工程技术',value:76},{name:'电气一体化技术',value:56},{name:'电气一体化技术',value:56}]");

		// 创建总体概述分析结果的页面对象
		AnalyGeneral ag = new AnalyGeneral();
		ag.setGeneralOverview(rgm); // 总体概述总体诊断结果
		ag.setItemList(itemList); // 所有项目的诊断结果
		ag.setItemsMap(itemsMap); // 所有项目的总结和雷达图数据
		ag.setQuestionList(questionList); // 问题描述与改进意见
		ag.setObjGeneralMolecule(objGeneralMolecule); // 横向对比的图表数据
		return ag;
	}
}
