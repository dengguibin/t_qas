package com.upath.plat.quartz.scheduling.job;

import com.upath.plat.quartz.model.TCommonScheduling;
import com.upath.plat.quartz.scheduling.BaseStatefulJob;


public class MyJob extends BaseStatefulJob {

	private static int i = 0;

	@Override
	public void executejob(TCommonScheduling scheduling) {
		// TODO Auto-generated method stub
		System.out.println("----" + (++i));
	}

}
