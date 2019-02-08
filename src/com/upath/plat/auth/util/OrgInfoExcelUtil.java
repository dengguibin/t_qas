package com.upath.plat.auth.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddressList;

import com.upath.plat.common.exception.PlatformException;

/**
 * 解析机构人员信息
 * 
 * @author wangzhaoqi
 *
 */
@SuppressWarnings({"unused" })
public class OrgInfoExcelUtil {
	
	private String[] columnDefind = { "" };

	private int startRow = 3;
	private int startColumn = 0;
	private int readColumn = 0;

	private OrgInfoExcelUtil() {

	}

	/**
	 * @param columnDefind
	 *            对每列字段做一个定义，用于对excel值的映射
	 * @param startRow
	 *            从哪一行开始读取或写入， 从0开始，0是第一行
	 * @param startColumn
	 *            从哪一列开始读取或写入， 从0开始，0是第一列
	 * @param readColumn
	 *            指定某一列必填的行，以此行为基准来读取
	 */
	public OrgInfoExcelUtil(String[] columnDefind, int startRow,
			int startColumn, int readColumn) {
		this.columnDefind = columnDefind;
		this.startRow = startRow;
		this.startColumn = startColumn;
		this.readColumn = readColumn;
	}

	/**
	 * 下载模板
	 * 
	 * @param templateFile
	 *            模板的file，放在web项目的resources
	 * @param proMap
	 *            key是columnDefind中的值，value是一个list类型用于填充到模板中生成select
	 * @param ops
	 *            输出流
	 * @throws IOException
	 * @throws BiffException
	 * @throws WriteException
	 * @throws RowsExceededException
	 */
	public void downTemplate(File templateFile,
			Map<String, List<String>> proMap, OutputStream ops)
			throws Exception
		 {
		
		POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(templateFile));
		Workbook workbook = new HSSFWorkbook(fs);
		Sheet sheet0 = workbook.getSheetAt(0);
		if (proMap != null && proMap.size() > 0) {
			Set<Entry<String, List<String>>> entrySet = proMap.entrySet();
			// ------------填充select的值--------------------
			int totalRow  = sheet0.getLastRowNum();
			for (Entry<String, List<String>> entry : entrySet) {
				String key = entry.getKey();
				if(entry.getValue() == null || entry.getValue().isEmpty() == true){
					throw new PlatformException("传入的数据信息错误");
				}
				int col = ArrayUtils.indexOf(columnDefind, key);
				CellRangeAddressList regions = new CellRangeAddressList(startColumn,totalRow,col,col);
				String arr[] = new String[entry.getValue().size()];
				entry.getValue().toArray(arr);
				DVConstraint constraint = DVConstraint.createExplicitListConstraint(arr); 
				HSSFDataValidation validation = new HSSFDataValidation(regions,constraint);
				sheet0.addValidationData(validation);
			}
		}
		workbook.write(ops);
	}

	/**
	 * 解析excel文件
	 * 
	 * @param sourceFile
	 * @return
	 */
	public List<Map<String, String>> getExcelValue(File sourceFile,int keyColumn) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Workbook workbook = null;
		try {
			workbook =  new HSSFWorkbook(new FileInputStream(sourceFile));
			Sheet sheet0 = workbook.getSheetAt(0);
			// ------------获取某一列的单元格-----------
			//Cell[] colCell = sheet0.getColumn(0);
			int colSize = columnDefind.length;
			// ------------计算出有多少行--------------
			//int rowSize = colCell.length;
			int rowSize=sheet0.getLastRowNum();
			for (int i = startRow ; i <= rowSize; i++) {
				Map<String, String> tm = new TreeMap<String, String>();
				int currRow = i;
				Row row = sheet0.getRow(currRow);
				for (int colIndex = 0; colIndex < colSize; colIndex++) {
					int currCol = colIndex + startColumn;
					Cell cell = row.getCell(currCol);
					if (cell != null) {
						String value = null;
						String cellValue = cell.getStringCellValue();
						if(cellValue != null && "".equals(cellValue.trim()) == false){
							value = cellValue;
						}
						tm.put(columnDefind[colIndex],value );
					}
				}
				if(tm.get(columnDefind[keyColumn]) != null){
					list.add(tm);
				}
			}
			
		} catch (Exception e) {
			throw new PlatformException("解释数据文件失败",e);
		}
		return list;
	}

	public String[] getColumnDefind() {
		return columnDefind;
	}

	public void setColumnDefind(String[] columnDefind) {
		this.columnDefind = columnDefind;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getStartColumn() {
		return startColumn;
	}

	public void setStartColumn(int startColumn) {
		this.startColumn = startColumn;
	}

	public int getReadColumn() {
		return readColumn;
	}

	public void setReadColumn(int readColumn) {
		this.readColumn = readColumn;
	}

}
