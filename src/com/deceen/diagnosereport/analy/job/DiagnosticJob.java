package com.deceen.diagnosereport.analy.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.deceen.diagnosereport.analy.model.QasTDiagnosticreport;
import com.deceen.diagnosereport.analy.service.QasTDiagnosticreportService;
import com.deceen.diagnosereport.analy.service.QasTDiagnosticreportServiceNew;
import com.upath.plat.common.util.IDGenerator;
import com.upath.plat.common.util.PlatUtil;
import com.upath.plat.quartz.model.TCommonScheduling;
import com.upath.plat.quartz.scheduling.BaseStatefulJob;

public class DiagnosticJob extends BaseStatefulJob{

	@Override
	public void executejob(TCommonScheduling scheduling){
		try {
			QasTDiagnosticreportServiceNew diagnosticreportService = (QasTDiagnosticreportServiceNew) PlatUtil
					.getApplicationContext().getBean(
							"qasTDiagnosticreportServiceNew");
			//生成诊断报告
			QasTDiagnosticreport diagnosticreport = new QasTDiagnosticreport();
			diagnosticreport.setId(IDGenerator.getUUID());
			diagnosticreport.setDiagnosetaskid(scheduling.getParams());
			diagnosticreport.setDiagnoseway(2);
			diagnosticreport.setCreatedby(scheduling.getCreator());
			diagnosticreport.setCreatedtime(new Date());
			diagnosticreport.setDiagnosedatatime(new SimpleDateFormat(
					"YYYY-MM-dd HH:mm:ss").format(diagnosticreport
					.getCreatedtime()));
			diagnosticreportService.excuteAnaly(diagnosticreport, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
