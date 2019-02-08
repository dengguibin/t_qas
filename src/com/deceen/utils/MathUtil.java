package com.deceen.utils;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.deceen.diagnosereport.dengguibin.afteranaly.buildhtml.Colors;
import com.upath.plat.common.util.SystemConfig;


public class MathUtil {
	
	
	
	
	
	/**
	 * 四舍五入
	 * @param value
	 * @return
	 * @author dengguibin
	 */
	public static double roundingMiddle(double value){
		BigDecimal b = new BigDecimal(new Double(value));
		double result = b.setScale(0, BigDecimal.ROUND_HALF_UP).doubleValue();
		return result;
	}
	
	/**
	 * 
	 * @param (Date)reportDate,mediaryId,taskId,objId
	 * @return E:/Analys/analy/pages/2018/06/01/task-01254580/obj-025635/120358
	 * @author dengguibin
	 */
	private String createRootPath(Map<String, Object> params){
		//1.定义路径
		String ROOTDIRH = SystemConfig.ANALY_FREEMARKER_ROOTDIRH + "/pages";//E:/Analys/analy/pages
		String stringDate = null;//返回年月日 :/2017/12/15
		String taskP = null;// /task-taskId
		String objP = null;// /obj-objId
		String stringTime = null;//返回时分秒 : /10-57-47
		//2.初始化路径
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		String time=sdf.format((Date)params.get("reportDate"));
	    stringTime=time.split(" ")[1].replace(":", "-");//:10-57-47
	    stringDate=time.split(" ")[0].replace("-", "/");//:2017/12/15
	    stringTime = "/"+ stringTime;
	    stringDate = "/"+ stringDate;
	    taskP = "/task-" + params.get("taskId");
	    objP = "/obj-" + params.get("objId");
		//拼接路径
		String result = ROOTDIRH + stringDate + taskP + objP + stringTime;
		
		File file = new File(result);
		if (!file.exists()) {
			file.mkdirs();
		}
		return result;
	}
	
	/**
	 * 任务等级的颜色选择算法
	 * 1.最多五种颜色可选：
	 * 绿，蓝，黄，橙，红
	 *选两段：绿，红
	 * 选三段：绿，黄，红
	 * 选四段：绿，蓝，黄，红
	 * 
	 * 2.最多六种颜色可选;
	 * 。。。。
	 * 
	 * 3.最多七种颜色可选
	 * 。。。。
	 * 
	 * @param colors最多可选的颜色，例如五种颜色
	 * @param segmentNum选择段数，例如五段中选三段
	 * @return 例如五种颜色选择三段，返回 绿，黄，红
	 * @author dengguibin
	 */
	public static List<String> taskLevelColor(List<String> oldColors,int segmentNum){
		List<String> result = new ArrayList<>();
		int step = (int)roundingMiddle((double)oldColors.size()/segmentNum);
		
		int low = 0;
		int high = oldColors.size() - 1;
		
		List<Integer> index = new ArrayList<>();
		while(low <= high && segmentNum > 0){
			if(low <= high ){
				index.add(low);
				low += step;
				segmentNum --;
			}
			if(low <= high){
				index.add(high);
				high -= step;
				segmentNum --;
			}
		}
		Collections.sort(index);

		for(int loca : index){
			result.add(oldColors.get(loca));
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		taskLevelColor(Colors.fiveColors, 3);
	}
	
	
	/**
	 * 将一个小矩阵覆盖一个大矩阵的一部分
	 * 大矩阵:
	 * [[a, b, c],
	 *  [d, e, f],
	 *  [d, e, f]]
	 * 小矩阵: 
	 *  [[x, y],
	 *  [x, y]]
	 *  
	 * 覆盖之后：
	 *  [[a, b, c],
	 *  [d, x, y],
	 *  [d, x, y]]
	 * @param rowIndex:从第几行开始,columnIndex:从第几列开始，上例中rowIndex和columnIndex都为1
	 * @return 
	 * @author dengguibin
	 */
	public static String[][] replaceMatrix(String[][] oldMatrix,String[][] newMatrix,int rowIndex,int columnIndex){
		String[][] result = oldMatrix;
		for(int i = rowIndex;i<result.length;i++){
			String[] rowi = result[i];
			for(int j = columnIndex;j<rowi.length;j++){
				result[i][j] = newMatrix[i-rowIndex][j-columnIndex];
			}
		}
		return result;
	}
	
	
	
	/**
	 * 单值矩阵
	 * [[50.9, 23.76, 47.36],
	 *  [45.86, 35.36, 2.39]]
	 * @param 
	 * @return 
	 * @author dengguibin
	 */
	public static String[][] singgleMatrix(int rowNum,int columnNum){
		String[][] result = new String[rowNum][columnNum];
		for(int i = 0;i<result.length;i++){
			String[] rowi = result[i];
			for(int j=0;j<rowi.length;j++){
				result[i][j] =String.valueOf(getRandomNum(100));
			}
		}
		return result;
	}
	
	/**
	 * 双值矩阵
	 * [[74.22,86.15, 10.32,68.31, 83.86,129.7], 
	 * [12.96,93.13, 11.09,93.729996, 15.49,89.9]]
	 * @param 
	 * @return 
	 * @author dengguibin
	 */
	public static String[][] doubleMatrix(int rowNum,int columnNum){
		String[][] result = new String[rowNum][columnNum];
		for(int i = 0;i<result.length;i++){
			String[] rowi = result[i];
			for(int j=0;j<rowi.length;j++){
				float num1 = getRandomNum(100);
				float num2 = num1+getRandomNum(100);
				result[i][j] =String.valueOf(num1+","+num2);
			}
		}
		return result;
		
	}
	
	
	
	/**
	 * 将集合转数组
	 * @param 
	 * @return 
	 * @author dengguibin
	 */
	public static String[] asArray(List<String> strs){
		String[] result = new String[strs.size()];
		int i = 0;
		for(String s:strs){
			result[i] = s;
			i++;
		}
		return result;
	}
	
	/**
	 * 保留两位小数，且四舍五入
	 * @param 
	 * @return 
	 * @author dengguibin
	 */
	public static float twoDecimal(float countScore) {
		BigDecimal bd = new BigDecimal(countScore);
		bd = bd.setScale(2, 4);
		return bd.floatValue();
	}
	
	/**
	 * 将小数转为百分数
	 * @param 
	 * @return 
	 * @author dengguibin
	 */
	public static String changePointToPercent(float point) {
        return String.valueOf(point*100)+"%";
    }
	
	/**
	 * 123.33变成12.33
	 * 1223.55变成12.23
	 * @param 
	 * @return 
	 * 
	 * @author dengguibin
	 */
	public static float weakenScore(float result){
		String s = String.valueOf(result);
		String[] ss = s.split("\\.");
		int l = ss[0].length();
		int n = l-2;
		if(n == 0){
			return Float.parseFloat(s);
		}else {
			int t = (int) Math.pow(10,n);
			return twoDecimal(Float.parseFloat(s)/t) ;
		}
	}
	
	
	/**
	 * 产生随机浮点数
	 * seed = 1000的时候
	 * 表示 1000以内
	 * @param 
	 * @return 
	 * 
	 * @author dengguibin
	 */
	public static float getRandomNum(int seed){
		float result = 0;
		
		Random random=new Random();
		result = random.nextFloat();
		result = result*seed;
			
		return twoDecimal(result);
	}
	
	/**
	 * 对于数值型指标而言，1代表双柱状图（复杂柱状图），2代表单柱状图（简单柱状图）
	 * 
	 * 思路：指标名称中包含“比”，“例”判定为双柱状图
	 * @param indicatorname：指标名称
	 * @return 
	 * @author dengguibin
	 */
	public static String getMark(String indicatorname){
		if(indicatorname.contains("比")||indicatorname.contains("例")||indicatorname.contains("占")){
			return "1";
		}
		return "2";
	}
	
	//传入图片的随机数
		public static double getResultNum1(){
			double resultNum1 = 0;
			
			Random random=new Random();
			resultNum1 = random.nextFloat();
			resultNum1=resultNum1*1000;
			return twoDecimal(resultNum1);
		}

		/**
		 * 保留两位小数，且四舍五入
		 * 
		 * @param countScore
		 * @return
		 */
		public static  double twoDecimal(double countScore) {
			BigDecimal bd = new BigDecimal(countScore);
			bd = bd.setScale(2, 4);
			return bd.doubleValue();
		}
	
	
}
