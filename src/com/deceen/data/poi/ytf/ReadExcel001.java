package com.deceen.data.poi.ytf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import com.deceen.data.poi.main.Common;
import com.deceen.data.poi.main.specific.AssociationAndRedCrossAward;
import com.deceen.data.poi.main.specific.BaseInfoOfEmploymentGuidance;
import com.deceen.data.poi.main.specific.BaseInfoOfSupervisor;
import com.deceen.data.poi.main.specific.BaseInfoOfTeachingResearcher;
import com.deceen.data.poi.main.specific.CooperateCompany;
import com.deceen.data.poi.main.specific.Course;
import com.deceen.data.poi.main.specific.DropoutList;
import com.deceen.data.poi.main.specific.Empolyee;
import com.deceen.data.poi.main.specific.Empolyee1;
import com.deceen.data.poi.main.specific.Empolyee2;
import com.deceen.data.poi.main.specific.Empolyee3;
import com.deceen.data.poi.main.specific.FilesOfTeachingManageMent;
import com.deceen.data.poi.main.specific.GraduateEmployment;
import com.deceen.data.poi.main.specific.GraduateEmploymentUnits;
import com.deceen.data.poi.main.specific.Information;
import com.deceen.data.poi.main.specific.LastYearEmployment;
import com.deceen.data.poi.main.specific.LessonsOfTeache;
import com.deceen.data.poi.main.specific.Major;
import com.deceen.data.poi.main.specific.MajorLeader;
import com.deceen.data.poi.main.specific.MajorLeader1;
import com.deceen.data.poi.main.specific.Practice;
import com.deceen.data.poi.main.specific.PracticeBaseInCampus;
import com.deceen.data.poi.main.specific.Qualification;
import com.deceen.data.poi.main.specific.Recruit;
import com.deceen.data.poi.main.specific.Scholarship;
import com.deceen.data.poi.main.specific.ShoolAward;
import com.deceen.data.poi.main.specific.SkillAppraisalOrg;
import com.deceen.data.poi.main.specific.SkillTraining;
import com.deceen.data.poi.main.specific.SocialDonation;
import com.deceen.data.poi.main.specific.StudAssociatio;
import com.deceen.data.poi.main.specific.Student;
import com.deceen.data.poi.main.specific.StudentAward;
import com.deceen.data.poi.main.specific.StudentManagement;
import com.deceen.data.poi.main.specific.Teacher;
import com.deceen.data.poi.main.specific.TeachingEvaluation;
import com.deceen.data.poi.main.specific.TeachingManagement;

   
public class ReadExcel001 {  
	
	private static int i =1;
	private static int tableCount = 0;
	
	@Test
	public void test01() throws Exception {
		showExcel(getWorkbok("C:\\Users\\Administrator\\Desktop\\系统数据.xls"));
	}
	
	public void showExcel(Workbook workbook) throws Exception {
		Sheet sheet = null;
		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {//获取每个Sheet表
			sheet = workbook.getSheetAt(i);
			String sheetName = sheet.getSheetName();
			System.out.println(i +" ："+ sheetName);
			/*for (int j = 0; j < sheet.getPhysicalNumberOfRows(); j++) {//获取每行
				Row row=sheet.getRow(j);
				for (int k = 0; k < row.getPhysicalNumberOfCells(); k++) {//获取每个单元格
					System.out.print(row.getCell(k)+"\t");
				}
				System.out.println("---Sheet表"+i+"处理完毕---");
			}*/
		}
	}
	
	/**
	 * 获取Workbook对象
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public Workbook getWorkbok(String fileName) throws IOException {
//		判断是否是excel2007格式
		boolean isE2007 = false;  
        if(fileName.endsWith("xlsx")) isE2007 = true;  
//      建立输入流  
        InputStream input = new FileInputStream(fileName);
//	 	根据文件格式(2003或者2007)来初始化
        return true==isE2007 ? new XSSFWorkbook(input) : new HSSFWorkbook(input);
	}
    
//	@Test
//	public void main() {
//		readXml("D:/test.xlsx");
//		System.out.println("-------------");
//		readXml("E:/Documents/flp/test01.xls");
//		readXml("E:/Documents/flp/test01R.xls");
//		readXml("E:/Documents/flp/test02.xls");
//		readXml("E:/Documents/flp/test03.xlsx");
//		readXml("E:/Documents/flp/12月考勤表汇总2.xlsx");
//		readXml("C:\\Users\\Administrator\\Desktop\\系统数据.xls");
//		readXml("D:/flp/13757_2016_V2.16a001(11.17).xlsx");
//	}
	
	public static void main(String[] args) throws InvalidFormatException {
		readXml("C:\\Users\\Administrator\\Desktop\\系统数据.xls");
	}
	
    public static void readXml(String fileName) throws InvalidFormatException{  
//        boolean isE2007 = false;    //判断是否是excel2007格式  
//        if(fileName.endsWith("xlsx")) isE2007 = true;  
        try {
//        	建立输入流  
            InputStream input = new FileInputStream(fileName);
//			根据文件格式(2003或者2007)来初始化
//          Workbook wb = true==isE2007 ? new XSSFWorkbook(input) : new HSSFWorkbook(input);
            Workbook wb = WorkbookFactory.create(input);
//          Workbook wb = new XSSFWorkbook(input);
//			Sheet sheet = wb.getSheetAt(0);  // 状态数据目录
//			Sheet sheet = wb.getSheetAt(1);  // A3基本办学条件表------QAS_D_ManagementInformationSystem(管理信息系统基础表)
//			Sheet sheet = wb.getSheetAt(2);  // A1院校基本信息表------QAS_D_School(院校基础表)
//			Sheet sheet = wb.getSheetAt(3);  // A1-6机构设置表
//			Sheet sheet = wb.getSheetAt(4);  // A2院校领导表
//			Sheet sheet = wb.getSheetAt(5);  // A4-1校内实践基础表------QAS_D_PracticeBaseInCampus(校内实践基地属性表)
//			Sheet sheet = wb.getSheetAt(6);  // A4-2校外实习实训基地表
//			Sheet sheet = wb.getSheetAt(7);  // A4-3职业技能鉴定机构表------QAS_D_SkillAppraisalOrg(职业技能鉴定机构)
//			Sheet sheet = wb.getSheetAt(8);  // A5-1经费收入表------QAS_D_FundCostStatistics(经费支出统计表)
//			Sheet sheet = wb.getSheetAt(9);  // A5-2经费支出表------QAS_D_FundIncomeStatistics(经费收入统计表)    手动
//			Sheet sheet = wb.getSheetAt(10); // A6-1-1校内专任教师基本情况表------QAS_D_Empolyee(教工基础表)
//			Sheet sheet = wb.getSheetAt(11); // A6-2-1校内专任教师授课情况表-----QAS_D_LessonsOfTeacher(教师授课统计)
//			Sheet sheet = wb.getSheetAt(12); // A6-2-2校内专任教师教学工作量表
//			Sheet sheet = wb.getSheetAt(13); // A6-1-3校内专任教师其他情况表------QAS_D_TeacherPartTimeWork(教师社会兼职)
//			Sheet sheet = wb.getSheetAt(14); // A6-2-1校内兼课人员基本情况表------QAS_D_Empolyee(教工基础表)
//			Sheet sheet = wb.getSheetAt(15); // A6-2-2-1校内兼课人员授课情况表-----QAS_D_LessonsOfTeacher(教师授课统计)
//			Sheet sheet = wb.getSheetAt(16); // A6-2-2-2校内兼课人员教学工作量表
//			Sheet sheet = wb.getSheetAt(17); // A6-2-3校内兼课人员其他情况表------QAS_D_TeacherPartTimeWork(教师社会兼职)
//			Sheet sheet = wb.getSheetAt(18); // A6-3-1校外兼职教师基本情况表------QAS_D_Empolyee(教工基础表)
//			Sheet sheet = wb.getSheetAt(19); // A6-3-2-1校外兼职教师授课情况表-----QAS_D_LessonsOfTeacher(教师授课统计)
//			Sheet sheet = wb.getSheetAt(20); // A6-3-2-2校外兼职教师教学工作量表
//			Sheet sheet = wb.getSheetAt(21); // A6-4-1校外兼职教师基本情况表------QAS_D_Empolyee(教工基础表)
//			Sheet sheet = wb.getSheetAt(22); // A6-4-2-1校外兼职教师授课情况表-----QAS_D_LessonsOfTeacher(教师授课统计)
//			Sheet sheet = wb.getSheetAt(23); // A6-4-2-2校外兼职教师教学工作量表
//			Sheet sheet = wb.getSheetAt(24); // A7-1-1开设专业表-----QAS_D_Major(专业信息表) --QAS_D_MajorDirection(专业方向表)
//			Sheet sheet = wb.getSheetAt(25); // A7-1-3专业负责人表------QAS_D_MajorLeader(专业带头人、专业负责人表)
//			Sheet sheet = wb.getSheetAt(26); // A7-1-2专业带头人表------QAS_D_MajorLeader(专业带头人、专业负责人表)
//			Sheet sheet = wb.getSheetAt(27); // A7-2课程设置表------QAS_D_Course(课程基础表)    !!!数据无法全部倒入，懒得研究
//			Sheet sheet = wb.getSheetAt(28); // A7-3-1职业资格证书表----QAS_D_Qualification(职业资格证书统计表)
//			Sheet sheet = wb.getSheetAt(29); // A7-3-2应届毕业生获证及社会技术培训情况表------QAS_D_SkillTraining(应届毕业生获证及社会技术培训统计表)
//			Sheet sheet = wb.getSheetAt(30); // A7-4顶岗实习表------QAS_D_Practice(顶岗实习统计表)
//			Sheet sheet = wb.getSheetAt(31); // A7-5产学合作表------QAS_D_CooperateCompany(产学合作企业基础信息)
//			Sheet sheet = wb.getSheetAt(32); // A7-6-1招生表------QAS_D_Recruit(招生统计表)
//			Sheet sheet = wb.getSheetAt(33); // A7-6-2应届毕业生就业勤情况表------QAS_D_GraduateEmployment(应届毕业生就业统计表)
//			Sheet sheet = wb.getSheetAt(34); // A7-6-3上届毕业生就业勤情况表------QAS_D_LastYearEmployment(上届毕业生就业统计表)
//			Sheet sheet = wb.getSheetAt(35); // A8-1教学与学生管理文件表------QAS_D_FilesOfTeachingManageMent(教学与学生管理文件)
//			Sheet sheet = wb.getSheetAt(36); // A8-2专职教学管理人员基本情况表------QAS_D_TeachingManagement(专职教学管理人员表)
//			Sheet sheet = wb.getSheetAt(37); // A8-3专职学生管理人员基本情况表------QAS_D_StudentManagement(专职学生管理人员表)
//			Sheet sheet = wb.getSheetAt(38); // A8-4专职招生就业指导人员基本情况表-----QAS_D_BaseInfoOfEmploymentGuidance(专职招生就业指导人员表)
//			Sheet sheet = wb.getSheetAt(39); // A8-5专职督导人员基本情况表------QAS_D_BaseInfoOfSupervisor(专职督导人员表)
//			Sheet sheet = wb.getSheetAt(40); // A8-6专职教学研究人员基本情况表------QAS_D_BaseInfoOfTeachingResearcher(专职教学研究人员表)
//			Sheet sheet = wb.getSheetAt(41); // A8-7评教情况表------QAS_D_TeachingEvaluation(评教情况)
//			Sheet sheet = wb.getSheetAt(42); // A8-8奖助学情况表------QAS_D_Scholarship(奖助学情况)
//			Sheet sheet = wb.getSheetAt(43); // A8-9重大制度创新表------QAS_D_MajorSysInnovation(重大制度创新)
//			Sheet sheet = wb.getSheetAt(44); // A9-2就业率表
//			Sheet sheet = wb.getSheetAt(45); // A9-3社会捐赠情况表------QAS_D_SocialDonation(社会（准）捐赠情况)
//			Sheet sheet = wb.getSheetAt(46); // A9-4应届毕业生主要就业单位与联系人表------QAS_D_GraduateEmploymentUnits(应届毕业生主要就业单位与联系人)
//			Sheet sheet = wb.getSheetAt(47); // A9-5质量工程表
//			Sheet sheet = wb.getSheetAt(48); // A9-6-1学生获奖情况表------QAS_D_StudentAward(学生获奖情况)
//			Sheet sheet = wb.getSheetAt(49); // A9-6-2学校获奖情况表------QAS_D_ShoolAward(学校获奖情况)
//			Sheet sheet = wb.getSheetAt(50); // A9-6-3学生社团红十字会获奖情况表 ------QAS_D_AssociationAndRedCrossAward(学生社团、红十字会获奖明细)
//			Sheet sheet = wb.getSheetAt(51); // A9-1招生情况表------
//			Sheet sheet = wb.getSheetAt(52); // A10-1在校生信息表------QAS_D_Student(学生基础表)
//			Sheet sheet = wb.getSheetAt(53); // A10-2-1辍学学生明细表------QAS_D_DropoutList(辍学学生明细表)
//			Sheet sheet = wb.getSheetAt(54); // A10-2-2辍学情况汇总表
//			Sheet sheet = wb.getSheetAt(55); // A10-3学生社团表------QAS_D_StudAssociation(学生社团基础表)
//			Sheet sheet = wb.getSheetAt(56); // A10-4红十字会表                       
//			Sheet sheet = wb.getSheetAt(57); // A10-5志愿者（义工社工）活动表                
//			Sheet sheet = wb.getSheetAt(58); // A11-1当年专业变动情况表                   
//			Sheet sheet = wb.getSheetAt(59); // A11-2在校学生的地区、户籍及民族等情况  ------QAS_D_StudRegionInfo(在校学生的地区、户口所在地及民族统计表)          
//			Sheet sheet = wb.getSheetAt(60); // A11-3复转军人及退役士兵情况------QAS_D_RetiredSoldiers(复转军人及退役士兵统计表)                 
//			Sheet sheet = wb.getSheetAt(61); // A11-4少数民族教师情况                    
//			Sheet sheet = wb.getSheetAt(62); // A12-3新生信息表                       
//			Sheet sheet = wb.getSheetAt(63); // A12补充说明                          
//			Sheet sheet = wb.getSheetAt(64); // B0学校概况                           
//			Sheet sheet = wb.getSheetAt(65); // B1办学基本条件                         
//			Sheet sheet = wb.getSheetAt(66); // B2办学目标与定位                        
//			Sheet sheet = wb.getSheetAt(67); // B3校企合作                           
//			Sheet sheet = wb.getSheetAt(68); // B4领导作用                           
//			Sheet sheet = wb.getSheetAt(69); // B5经费收支                           
//			Sheet sheet = wb.getSheetAt(70); // B6师资队伍                           
//			Sheet sheet = wb.getSheetAt(71); // B7专业与课程建设                        
//			Sheet sheet = wb.getSheetAt(72); // B8过程管理                           
//			Sheet sheet = wb.getSheetAt(73); // B9社会评价                           
//			Sheet sheet = wb.getSheetAt(74); // B10平台逻辑校验表                       
//			Sheet sheet = wb.getSheetAt(75); // B11适应社会需求能力                      
//			Sheet sheet = wb.getSheetAt(76); // 数据表导出                            
//			Sheet sheet = wb.getSheetAt(77); // 数据表导入                            
//			Sheet sheet = wb.getSheetAt(78); // 高级操作                             
//			Sheet sheet = wb.getSheetAt(79); // 填写说明                             
//			Sheet sheet = wb.getS1heetAt(80); // 帮助                               
            FileOutputStream fs = new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\系统数据.txt"));
    		PrintStream p = new PrintStream(fs);
    		
    		Sheet sheet = wb.getSheetAt(i);
        	Iterator<Row> rows = sheet.rowIterator(); 	//获得行的迭代器  
        	int enterCount = 0;
        	List<List<String>> rowList = new ArrayList<List<String>>();
        	while (rows.hasNext()) {
        		boolean boo = false;
        		Row row = rows.next();  				//获得行数据  
        		int rowNum = row.getRowNum();			//获得行号
        		if (rowNum > -1) {						//调节从哪一行开始读，第一行的行号是0
        			Iterator<Cell> cells = row.cellIterator();    	//获得列的迭代器  
        			int blankCount = 0;
        			int emptyCount = 0;
        			String rowString ="{"+ (rowNum+1)+"行}";
        			List<String> columnList = new ArrayList<String>();
        			while (cells.hasNext()) {  
        				Cell cell = cells.next();  					//获得列数据
        				short c = cell.getCellStyle().getFillForegroundColor();	//单元格背景色
        				short lb =  cell.getCellStyle().getBorderLeft();
        				short rb =  cell.getCellStyle().getBorderRight();
        				short b= cell.getCellStyle().getBorderBottom();		//单元格左边框颜色
        				short f = wb.getFontAt(cell.getCellStyle().getFontIndex()).getColor();//字体颜色
        				if(c==10){
        					++enterCount;
        				}
        				if((c==64||c==9)&&b==1){
        					if(rb != 1&&lb!=1){
        						continue;
        					}
        				}else{
        					continue;
        				}
        				int columnIndex = cell.getColumnIndex();	//获得列号
        				String cellStringValue = getCellStringValue(cell);
        				if("201415015".equals(cellStringValue)){
        					System.out.println();
        				}
        				if(StringUtils.isNotEmpty(cellStringValue)){		//如果单元格有内容，则字体必须为黑色
        					if(f != 32767&&f!=8){
        						continue;
        					}
    					}
        				boolean isWord=cellStringValue.contains("_")&&Pattern.compile("[A-Z]").matcher(cellStringValue).find();
        				if(isWord){
        					continue;
        				}
        				if (!"".equals(cellStringValue.trim())) {		//连续5个单元格为空则排除数据
    						++blankCount;
    					}else{
    						++emptyCount;
    					}
        				if ("#没有匹配上#".equals(cellStringValue)) {
        					System.err.println("******************  暂时不支持第"+(rowNum+1)+"行，第"+(columnIndex+1)+"列的数据类型！   ********");
        				} else {
        					rowString +="-["+ cellStringValue+"]";
        					if("".equals(cellStringValue.trim())){
        						columnList.add("");
        					}else{
        						boo = true;
        						columnList.add(cellStringValue);
//        						System.out.println(rowString);
        					}
        				}
        			} 
        			if(blankCount==0){
						continue;
					}
        			if(emptyCount>blankCount){
        				continue;
        			}
        			if(boo){
        				if(enterCount>0){
        					enterCount=0;
        					++tableCount;
        					System.out.println(tableCount);
        				}
        				columnList.add(tableCount+"");
        				rowList.add(columnList);
        				System.out.println(rowString);
        			}else{
        				++enterCount;
        			}
        		}
//            	if (boo) {
//            		System.out.println();
//				}
        	}
        	Common c = getObject(i);
        	try {
				c.batchInsert(rowList);
			} catch (SQLException e) {
				e.printStackTrace();
			}
//          for(int i =1;i< wb.getNumberOfSheets();i++){}
            fs.close();
            p.close();
        } catch (IOException ex) {  
            ex.printStackTrace();  
        }  
    }
    
	public static Common getObject(int i) {
		Common c = null;
		switch (i) {
		case 1:
			c = new Information();
			break;
		case 5:
			c = new PracticeBaseInCampus();
			break;
		case 7:
			c = new SkillAppraisalOrg();
			break;
		case 10:
			c = new Empolyee();
			break;
		case 11:
			c = new LessonsOfTeache();
			break;
		case 13:
			c = new Teacher();
			break;
		case 14:
			c = new Empolyee1();
			break;
		case 15:
			c = new LessonsOfTeache();
			break;
		case 17:
			c = new Teacher();
			break;
		case 18:
			c = new Empolyee2();
			break;
		case 19:
			c = new LessonsOfTeache();
			break;
		case 21:
			c = new Empolyee3();
			break;
		case 22:
			c = new LessonsOfTeache();
			break;
		case 24:
			c = new Major();
			break;
		case 25:
			c = new MajorLeader();
			break;
		case 26:
			c = new MajorLeader1();
			break;
		case 27:
			c = new Course();
			break;
		case 28:
			c = new Qualification();
			break;
		case 29:
			c = new SkillTraining();
			break;
		case 30:
			c = new Practice();
			break;
		case 31:
			c = new CooperateCompany();
			break;
		case 32:
			c = new Recruit();
			break;
		case 33:
			c = new GraduateEmployment();
			break;
		case 34:
			c = new LastYearEmployment();
			break;
		case 35:
			c = new FilesOfTeachingManageMent();
			break;
		case 36:
			c = new TeachingManagement();
			break;
		case 37:
			c = new StudentManagement();
			break;
		case 38:
			c = new BaseInfoOfEmploymentGuidance();
			break;
		case 39:
			c = new BaseInfoOfSupervisor();
			break;
		case 40:
			c = new BaseInfoOfTeachingResearcher();
			break;
		case 41:
			c = new TeachingEvaluation();
			break;
		case 42:
			c = new Scholarship();
			break;
		case 45:
			c = new SocialDonation();
			break;
		case 46:
			c = new GraduateEmploymentUnits();
			break;
		case 48:
			c = new StudentAward();
			break;
		case 49:
			c = new ShoolAward();
			break;
		case 50:
			c = new AssociationAndRedCrossAward();
			break;
		case 52:
			c = new Student();
			break;
		case 53:
			c = new DropoutList();
			break;
		case 55:
			c = new StudAssociatio();
			break;
		default:
			break;
		}
		return c;
	}

    /**
     * 根据列类型获取列值
     * @param cell
     * @return
     */
    public static String getCellStringValue(Cell cell) {      
        String cellValue = "";      
        switch (cell.getCellType()) {      
        case HSSFCell.CELL_TYPE_STRING:		//字符串类型   
            cellValue = cell.getStringCellValue();      
            if(cellValue.trim().equals("")||cellValue.trim().length()<=0)      
                cellValue=" ";      
            break;      
        case HSSFCell.CELL_TYPE_NUMERIC: 	//数值类型   
            cellValue = String.valueOf(cell.getNumericCellValue());      
            break;      
        case HSSFCell.CELL_TYPE_FORMULA: 	//公式   
            try {
				cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);      
				cellValue = String.valueOf(cell.getNumericCellValue());
			} catch (Exception e) {
				cellValue = "error";
			}      
            break;      
        case HSSFCell.CELL_TYPE_BLANK:      
            cellValue=" ";      
            break;      
        case HSSFCell.CELL_TYPE_BOOLEAN:      
            break;      
        case HSSFCell.CELL_TYPE_ERROR:      
            break;      
        default:      
        	cellValue = "#没有匹配上#";
            break;      
        }      
        return cellValue;      
    }     
    
}