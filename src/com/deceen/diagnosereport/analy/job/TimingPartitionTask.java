package com.deceen.diagnosereport.analy.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.deceen.diagnosereport.analy.mapper.QasTDiagnosticreportsummryMapper;
import com.deceen.diagnosereport.analy.service.QasTDiagnosticreportServiceNew;
import com.upath.plat.common.util.PlatUtil;
import com.upath.plat.quartz.model.TCommonScheduling;
import com.upath.plat.quartz.scheduling.BaseStatefulJob;
import com.upath.plat.quartz.scheduling.ScheduleCenter;


/**
 * 
 * 定时执行分区
 * 
 * @param 
 * 
 * @return 
 * @author dengguibin
 */
@Component("timingPartitionTask")
public class TimingPartitionTask extends BaseStatefulJob{
	
	private  QasTDiagnosticreportsummryMapper mapper;
	
	/**
	 * 每天凌晨0点执行此任务
	 * 
	 * 对t_pond_DiagnoseObjsIndicatorResult表添加LIST类型新分区
	 * 例如：分区名称为“p20180425”,分区内容为“20180425”
	 * @param 
	 * @return 
	 * @author dengguibin
	 */
	@Override
	public void executejob(TCommonScheduling scheduling) throws Exception {
		executePartition();
	}
	
	
	
	
	
	/**
	 * 
	 * 对t_pond_DiagnoseObjsIndicatorResult表添加LIST类型新分区
	 * 例如：分区名称为“p20180425”,分区内容为“20180425”
	 * @param 
	 * @return 
	 * @author dengguibin
	 */
    public void executePartition() { 
       System.out.println("添加新分区任务进行");
       String sql=appendTaskSql();
       
       QasTDiagnosticreportsummryMapper mapper = (QasTDiagnosticreportsummryMapper) PlatUtil
				.getApplicationContext().getBean(
						"qasTDiagnosticreportsummryMapper");
       mapper.newPartition(sql);
    } 
	
	/**
	 * 拼接执行新增分区的sql字符串
	 * @param 
	 * @return 
	 * @author dengguibin
	 */
	private String appendTaskSql(){
       StringBuilder sql=new StringBuilder("ALTER TABLE t_pond_DiagnoseObjsIndicatorResult");
       sql.append(" ADD PARTITION");
       sql.append("(");
       sql.append("PARTITION ");
       sql.append(newPartitionname());
       sql.append(" VALUES IN (");
       sql.append(newPartitionContent());
       sql.append(")");
       sql.append(")");
       return sql.toString();
	}
	
	/**
	 * 获得今天的日期，拼接p返回
	 * 作为新分区的名称
	 * @param 
	 * @return 
	 * @author dengguibin
	 */
	private String newPartitionname(){
		SimpleDateFormat formatter=new SimpleDateFormat("yyyyMMdd");
		String today=formatter.format(new Date());
		return "p"+today;
	}
	
	/**
	 * 新分区的内容
	 * 获得今天的日期，转为整型
	 * 例：20180425
	 * @param 
	 * @return 
	 * @author dengguibin
	 */
	private int newPartitionContent(){
		SimpleDateFormat formatter=new SimpleDateFormat("yyyyMMdd");
		String today=formatter.format(new Date());
		return Integer.parseInt(today);
	}

	public QasTDiagnosticreportsummryMapper getMapper() {
		return mapper;
	}

	public void setMapper(QasTDiagnosticreportsummryMapper mapper) {
		this.mapper = mapper;
	}

	
	
	
	
}
