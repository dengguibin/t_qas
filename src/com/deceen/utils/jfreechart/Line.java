package com.deceen.utils.jfreechart;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *   折线图
 * 
 * @author hanwnehai
 *
 */
public class Line {

	public static void createChart( DefaultCategoryDataset mDataset,String imgPath) { 
	   
	  	StandardChartTheme mChartTheme = new StandardChartTheme("CN");
	    mChartTheme.setLargeFont(new Font("黑体", Font.BOLD, 20));
	    mChartTheme.setExtraLargeFont(new Font("宋体", Font.PLAIN, 15));
	    mChartTheme.setRegularFont(new Font("宋体", Font.PLAIN, 15));
	    ChartFactory.setChartTheme(mChartTheme);		
	   // CategoryDataset mDataset = GetDataset();
	    JFreeChart mChart = ChartFactory.createLineChart(
	        "",//图名字
	        "年份",//横坐标
	        "是/否",//纵坐标
	        mDataset,//数据集
	        PlotOrientation.VERTICAL,
	        true, // 显示图例
	        true, // 采用标准生成器 
	        false);// 是否生成超链接
	    
	    CategoryPlot mPlot = (CategoryPlot)mChart.getPlot();
	    mPlot.setBackgroundPaint(Color.LIGHT_GRAY);// 设置绘图区背景色  
	   
	    mPlot.setOutlinePaint(Color.RED);//边界线
	    mPlot.setRangeGridlinePaint(Color.BLUE); // 设置水平方向背景线颜色  
	    mPlot.setRangeGridlinesVisible(true);// 设置是否显示水平方向背景线,默认值为true  
	    mPlot.setDomainGridlinePaint(Color.BLUE); // 设置垂直方向背景线颜色  
	    mPlot.setDomainGridlinesVisible(true); // 设置是否显示垂直方向背景线,默认值为false 
	    
	    CategoryAxis domainAxis = mPlot.getDomainAxis();     
        domainAxis.setLowerMargin(0.01);// 左边距 边框距离  
        domainAxis.setUpperMargin(0.06);// 右边距 边框距离,防止最后边的一个数据靠近了坐标轴。  
        domainAxis.setMaximumCategoryLabelLines(2);  
	    
	    ValueAxis rangeAxis = mPlot.getRangeAxis();
	    rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());//Y轴显示整数 
	    rangeAxis.setLowerBound(1);   //最小值显示1
	    rangeAxis.setAutoRange(false);   //不自动分配Y轴数据 
	    rangeAxis.setTickMarkStroke(new BasicStroke(1.6f));     // 设置坐标标记大小  
	    rangeAxis.setTickMarkPaint(Color.BLACK);     // 设置坐标标记颜色 
	    
	    FileOutputStream out = null;  
	    try {  
	        File outFile = new File(imgPath);  
	        if (!outFile.getParentFile().exists()) {  
	            outFile.getParentFile().mkdirs();  
	        }  
	        out = new FileOutputStream(imgPath);  
	        // 保存为PNG文件  
	        ChartUtilities.writeChartAsPNG(out, mChart, 500, 350);  
	        // 保存为JPEG文件  
	        //ChartUtilities.writeChartAsJPEG(out, chart, 500, 400);  
	        out.flush();  
	    } catch (FileNotFoundException e) {  
	        e.printStackTrace();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    } finally {  
	        if (out != null) {  
	            try {  
	                out.close();  
	            } catch (IOException e) {  
	                // do nothing  
	            }  
	        }  
	    }
  }

  
  public static CategoryDataset GetDataset()
  {
    DefaultCategoryDataset mDataset = new DefaultCategoryDataset();
    mDataset.addValue(1, "是/否", "201802");
    mDataset.addValue(2, "是/否", "201803");
    mDataset.addValue(2, "是/否", "201804");
    mDataset.addValue(2, "是/否", "201805");
    mDataset.addValue(1, "是/否", "201806");
   
    return mDataset;
  }

public static void main(String[] args) {
	
	 DefaultCategoryDataset mDataset = new DefaultCategoryDataset();
	    mDataset.addValue(1, "是/否", "201802");
	    mDataset.addValue(2, "是/否", "201803");
	    mDataset.addValue(2, "是/否", "201804");
	    mDataset.addValue(2, "是/否", "201805");
	    mDataset.addValue(1, "是/否", "201806");
	
	createChart(mDataset,"D:/png/55588.png");
}
  
}