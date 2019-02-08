package com.deceen.data.poi.main;

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

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.deceen.data.poi.util.DbUtil;

public class ExcelInput {

	public static void main(String[] args) throws Exception {
		readXml("C:\\Users\\Administrator\\Desktop\\系统数据.xls");
	}

	public void showExcel(Workbook workbook) throws Exception {
		Sheet sheet = null;
		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {// 获取每个Sheet表
			sheet = workbook.getSheetAt(i);
			String sheetName = sheet.getSheetName();
			System.out.println(i + " ：" + sheetName);
		}
	}

	/**
	 * 获取Workbook对象
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public Workbook getWorkbok(String fileName) throws IOException {
		// 判断是否是excel2007格式
		boolean isE2007 = false;
		if (fileName.endsWith("xlsx"))
			isE2007 = true;
		// 建立输入流
		InputStream input = new FileInputStream(fileName);
		// 根据文件格式(2003或者2007)来初始化
		return true == isE2007 ? new XSSFWorkbook(input) : new HSSFWorkbook(input);
	}

	public static void readXml(String fileName) throws Exception{  
        try {
//	                         建立输入流  
            InputStream input = new FileInputStream(fileName);
            Workbook wb = WorkbookFactory.create(input);
            FileOutputStream fs = new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\系统数据.txt"));
    		PrintStream p = new PrintStream(fs);
            for(int i =1;i< wb.getNumberOfSheets();i++){
            	 int tableCount = 0;
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
            			
            			String rowString ="{"+ (rowNum+1)+"行}";
            			List<String> columnList = new ArrayList<String>();
            			int blankCount = 0;
            			int emptyCount = 0;
            			
            			columnList.add(i+"-"+tableCount);
            			
            			while (cells.hasNext()) {  
            				Cell cell = cells.next();  					//获得列数据
            				short c = cell.getCellStyle().getFillForegroundColor();	//单元格背景色
            				short b= cell.getCellStyle().getBorderBottom();				//单元格左边框颜色
            				short f = wb.getFontAt(cell.getCellStyle().getFontIndex()).getColor();//字体颜色
            				if(c==10){
            					++enterCount;
            				}
            				if((c==64||c==9)&&b==1){
            				}else{
            					continue;
            				}
            				int columnIndex = cell.getColumnIndex();	//获得列号
            				String cellStringValue = getCellStringValue(cell);
            				if(StringUtils.isNotEmpty(cellStringValue)){		//如果单元格有内容，则字体必须为黑色
            					if(f != 32767){
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
            					p.println(i+"-"+tableCount);
            					System.out.println(tableCount+"---------:"+i);
            				}
            				columnList.set(0, i+"-"+tableCount);
            				rowList.add(columnList);
            				//System.out.println(rowString);
            				p.println(rowString);
            			}else{
            				++enterCount;
            			}
            		}
//	                if (boo) {
//	                	System.out.println();
//					}
            	}
            	Common c = new DataInsert();
        		try {
					c.batchInsert(rowList);
					DbUtil.instance.commit();
				} catch (SQLException e) {
					System.out.println(tableCount+"---------:"+i);
					e.printStackTrace();
				}
            }
            fs.close();
            p.close();
        } catch (IOException ex) {  
            ex.printStackTrace();  
        }  
    }

	public static String getCellStringValue(Cell cell) {
		String cellValue = "";
		switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_STRING:// 字符串类型
			cellValue = cell.getStringCellValue();
			if (cellValue.trim().equals("") || cellValue.trim().length() <= 0)
				cellValue = " ";
			break;
		case HSSFCell.CELL_TYPE_NUMERIC: // 数值类型
			cellValue = String.valueOf(cell.getNumericCellValue());
			break;
		case HSSFCell.CELL_TYPE_FORMULA: // 公式
			try {
				cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				cellValue = String.valueOf(cell.getNumericCellValue());
			} catch (Exception e) {
				cellValue = "error";
			}
			break;
		case HSSFCell.CELL_TYPE_BLANK:
			cellValue = " ";
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
