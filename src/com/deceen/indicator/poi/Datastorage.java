package com.deceen.indicator.poi;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deceen.indicator.indicatorcatalog.mapper.QasTIndicatorcatalogMapper;
import com.deceen.indicator.indicatorcatalog.model.QasTIndicatorcatalog;
import com.deceen.indicator.indicatorcontent.mapper.QasTIndicatorcontentMapper;
import com.deceen.indicator.indicatorcontent.model.QasTIndicatorcontent;
import com.upath.plat.common.service.CommonService;
import com.upath.plat.common.util.IDGenerator;

@Component("datastorage")
public class Datastorage extends CommonService {
	
	@Autowired
	private QasTIndicatorcatalogMapper indicatorcatalogMapper;
	@Autowired
	private QasTIndicatorcontentMapper indicatorcontentMapper;
	
	@Test
	public void main() {
		execute(0, "学校", 4);
		execute(1, "专业", 6);
		execute(2, "课程", 7);
		execute(3, "教师", 8);
		execute(4, "学生", 9);
	}

	private void execute(int sheetAt, String typeName, int sort) {
		QasTIndicatorcatalog type = this.createQasTIndicatorcatalog(typeName, -1, null);	//创建类型
		type.setSort(sort);
		indicatorcatalogMapper.insert(type);
		this.read("D:/Doc/指标库-180422-YYH.xls", sheetAt, type);
	}
	
	public void read(String fileName, int i, QasTIndicatorcatalog type){  
        try {
//        	建立输入流  
            InputStream input = new FileInputStream(fileName);
            Workbook wb = new HSSFWorkbook(input);
			Sheet sheet = wb.getSheetAt(i);
			
			QasTIndicatorcatalog item = null;
    		QasTIndicatorcatalog element = null;
    		QasTIndicatorcatalog indicator = null;
    		QasTIndicatorcontent indicatorcontent = null;
			
            Iterator<Row> rows = sheet.rowIterator(); 						//获得行的迭代器  
            while (rows.hasNext()) {
                Row row = rows.next();  									//获得行数据  
                int rowNum = row.getRowNum();								//获得行号
                if (rowNum > 0) {											//调节从哪行开始读，第一行的行号是0
                	Iterator<Cell> cells = row.cellIterator();    			//获得列的迭代器  
                	boolean boo = false;
                	while (cells.hasNext()) {  
                		Cell cell = cells.next();  							//获得列数据
                		int columnIndex = cell.getColumnIndex();			//获得列号
						String cellValue = this.getCellStringValue(cell);	//获取值
						if (!(HSSFCell.CELL_TYPE_BLANK == cell.getCellType())) {
							if (0 == columnIndex) {
								Matcher matcher = Pattern.compile("[\u4e00-\u9fa5]+").matcher(cellValue);
								while (matcher.find()) {
									cellValue = matcher.group();
								}
								item = this.createQasTIndicatorcatalog(cellValue, columnIndex, type.getId());			//创建项目
								item.setParentid(type.getId());
								indicatorcatalogMapper.insert(item);
							}
							if (1 == columnIndex) {
								Matcher matcher = Pattern.compile("[\u4e00-\u9fa5]+").matcher(cellValue);
								while (matcher.find()) {
									cellValue = matcher.group();
								}
								element = this.createQasTIndicatorcatalog(cellValue, columnIndex, item.getId());		//创建要素
								element.setParentid(item.getId());
								boo = true;
								indicatorcatalogMapper.insert(element);
							}
							if(2 == columnIndex){
								Matcher matcher = Pattern.compile("[\u4e00-\u9fa5]+").matcher(cellValue);
								while (matcher.find()) {
									cellValue = matcher.group();
								}
								element.setLeadDept(cellValue);
								boo = true;
								indicatorcatalogMapper.updateWithDyna(element);
							}
							if(3 == columnIndex){
								Matcher matcher = Pattern.compile("[\u4e00-\u9fa5]+").matcher(cellValue);
								while (matcher.find()) {
									cellValue = matcher.group();
								}
								element.setSynergeticDept(cellValue);
								boo = true;
								indicatorcatalogMapper.updateWithDyna(element);
							}
							
						}
						if (4 == columnIndex && boo == true) {
							element.setRemark(cellValue);
							indicatorcatalogMapper.update(element);
						}
						if (5 == columnIndex) {
							if (null != cellValue && cellValue.endsWith("；")) {
								cellValue = cellValue.substring(0, cellValue.length()-1);
							}
							indicator = this.createQasTIndicatorcatalog(cellValue, columnIndex, element.getId());	//创建指标
							indicator.setParentid(element.getId());
							indicatorcatalogMapper.insert(indicator);
						}
						if (6 == columnIndex) {
							indicatorcontent = new QasTIndicatorcontent();
							indicatorcontent.setId(IDGenerator.getUUID());
							indicatorcontent.setName_(indicator.getName_());
							indicatorcontent.setIndicatorcatalogid(indicator.getId());
							indicatorcontent.setCreatedby("YYH");
							indicatorcontent.setCreatedtime(new Date());
							indicatorcontent.setUpdatedtime(new Date());
							indicatorcontent.setStandard(cellValue);			//普通院校标准
							indicatorcontent.setIndicatordatatype(getDateType(cellValue));
						}
						if (7 == columnIndex) {
							indicatorcontent.setRemark(cellValue);				//数据计算规则
							indicatorcontentMapper.insert(indicatorcontent);	
						}
						
                	}  
                }
            }
        } catch (IOException ex) {  
            ex.printStackTrace();  
        }  
    }
	
	private Integer getDateType(String cellValue) {
		if("是".equals(cellValue.trim())||"否".equals(cellValue.trim())){
			return 2;
		}
		return 1;
	}

	/**
	 * 创建指标目录
	 * @param name
	 * @param columnIndex
	 * @return
	 */
	public QasTIndicatorcatalog createQasTIndicatorcatalog(String name, int columnIndex, String parentid) {
		QasTIndicatorcatalog bean = new QasTIndicatorcatalog();
		bean.setId(IDGenerator.getUUID());
		bean.setName_(name);
		Integer indicatortype = 0;
		if (-1 == columnIndex) {
			indicatortype = 1;		//	类型
		}
		if (0 == columnIndex) {
			indicatortype = 2;		//	项目
		}
		if (1 == columnIndex) {
			indicatortype = 3;		//	要素
		}
		if (5 == columnIndex) {
			indicatortype = 0;		//	指标
		}
		bean.setIndicatortype(indicatortype);
		bean.setSort(bean.createSort(indicatorcatalogMapper, parentid));
		bean.setCreatedby("YYH");
		bean.setCreatedtime(new Date());
		bean.setUpdatedtime(new Date());
		bean.setIsvalid(QasTIndicatorcatalog.ISVALID_DEFAULT);
		return bean;
	}
    
    /**
     * 根据类型获取这一列的值
     * @param cell
     * @return
     */
    public String getCellStringValue(Cell cell) {      
        String cellValue = "";      
        switch (cell.getCellType()) {      
        case HSSFCell.CELL_TYPE_STRING://字符串类型   
            cellValue = cell.getStringCellValue().trim();      
//            if(cellValue.trim().equals("")||cellValue.trim().length()<=0) cellValue=" ";      
            break;      
        case HSSFCell.CELL_TYPE_NUMERIC: //数值类型   
            cellValue = String.valueOf(cell.getNumericCellValue());      
            break;      
        case HSSFCell.CELL_TYPE_FORMULA: //公式   
            cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);      
            cellValue = String.valueOf(cell.getNumericCellValue());      
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
