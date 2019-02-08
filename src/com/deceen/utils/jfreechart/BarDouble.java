package com.deceen.utils.jfreechart;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
  
/** 
 * 双柱状图
 * @author cuiran 
 * 
 */  
public class BarDouble {  
   
     
     public static void creatDoubleBar(String path,DefaultCategoryDataset dataset) throws IOException {
         
         //DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
//         dataset.addValue(23.0, "2012年2月", "机构 1");  
//         dataset.addValue(50.0, "2012年2月", "机构 2");  
//         dataset.addValue(30.0, "2012年2月", "机构 3");  
//         dataset.addValue(26.0, "2012年3月", "机构 1");  
//         dataset.addValue(37.0, "2012年3月", "机构 2");  
//         dataset.addValue(28.0, "2012年3月", "机构 3");  
//       dataset.addValue(21.0, "风险 3", "机构 1");  
//       dataset.addValue(67.0, "风险 3", "机构 2");  
//       dataset.addValue(18.0, "风险 3", "机构 3");  
         JFreeChart chart = ChartFactory.createBarChart("", // chart  
                                                                             // title  
                 "时间", // domain axis label  
                 "数量", // range axis label  
                 dataset, // data  
                 PlotOrientation.VERTICAL, // orientation  
                 true, // include legend  
                 true, // tooltips?  
                 false // URLs?  
                 );  
         configFont(chart);  
           
          CategoryPlot plot = chart.getCategoryPlot();//获得图表区域对象  
   
          //设置图表的纵轴和横轴org.jfree.chart.axis.CategoryAxis  
   
          org.jfree.chart.axis.CategoryAxis domainAxis = plot.getDomainAxis();  
   
          domainAxis.setLowerMargin(0.1);//设置距离图片左端距离此时为10%  
   
          domainAxis.setUpperMargin(0.1);//设置距离图片右端距离此时为百分之10  
   
          domainAxis.setCategoryLabelPositionOffset(10);//图表横轴与标签的距离(10像素)  
   
          domainAxis.setCategoryMargin(0.2);//横轴标签之间的距离20%  
   
          domainAxis.setMaximumCategoryLabelLines(1);  
   
          domainAxis.setMaximumCategoryLabelWidthRatio(0);  
   
   

         //设置图表的颜色  
   
          org.jfree.chart.renderer.category.BarRenderer renderer;  
   
          renderer = new org.jfree.chart.renderer.category.BarRenderer();  
//          //显示每个柱的数值，并修改该数值的字体属性  
 //  
          renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());  
 //  
          renderer.setItemLabelFont(new Font("黑体",Font.BOLD,12));//12号黑体加粗  
 //  
          renderer.setItemLabelPaint(Color.black);//字体为黑色  
 //  
          renderer.setItemLabelsVisible(true);  
          NumberFormat nf= NumberFormat.getNumberInstance();  
           StandardCategoryToolTipGenerator generator=new StandardCategoryToolTipGenerator(StandardCategoryToolTipGenerator.DEFAULT_TOOL_TIP_FORMAT_STRING,nf);  
           renderer.setToolTipGenerator(generator);  
          plot.setRenderer(renderer);//使用我们设计的效果  
 //  
 //  
 //  
//          //设置纵横坐标的显示位置  
 //  
//          plot.setDomainAxisLocation(AxisLocation.BOTTOM_OR_LEFT);//学校显示在下端(柱子竖直)或左侧(柱子水平)  
 //  
//          plot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT); //人数显示在下端(柱子水平)或左侧(柱子竖直)  
   
         ChartPanel chartPanel = new ChartPanel(chart, false);  
         chartPanel.setPreferredSize(new Dimension(800, 570));  
         
         
         FileOutputStream out = null;
         try {
             out = new FileOutputStream(path);//"F://1.jpg"

             ChartUtilities.saveChartAsPNG(new File(path), chart, 500, 350);
         } finally {
             try {
                 out.close();
             } catch (Exception ex) {
                 ex.printStackTrace();
             }
         }
     }
	//字体配置方法(解决中文问题)  
    private static void configFont(JFreeChart chart) {  
        // 配置字体  
        Font xfont = new Font("宋体", Font.PLAIN, 12);// X轴  
        Font yfont = new Font("宋体", Font.PLAIN, 12);// Y轴  
        Font kfont = new Font("宋体", Font.PLAIN, 12);// 底部  
        Font titleFont = new Font("宋体", Font.BOLD, 25); // 图片标题  
        CategoryPlot plot = chart.getCategoryPlot();// 图形的绘制结构对象  
  
        // 图片标题  
        chart.setTitle(new TextTitle(chart.getTitle().getText(), titleFont));  
  
        // 底部  
        chart.getLegend().setItemFont(kfont);  
  
        // X 轴  
        CategoryAxis domainAxis = plot.getDomainAxis();  
        domainAxis.setLabelFont(xfont);// 轴标题  
        domainAxis.setTickLabelFont(xfont);// 轴数值  
        domainAxis.setTickLabelPaint(Color.BLUE); // 字体颜色  
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45); // 横轴上的label斜显示  
  
        // Y 轴  
        ValueAxis rangeAxis = plot.getRangeAxis();  
        rangeAxis.setLabelFont(yfont);  
        rangeAxis.setLabelPaint(Color.BLUE); // 字体颜色  
        rangeAxis.setTickLabelFont(yfont);  
  
    }  
   
 }  
  
   
