package com.deceen.data.poi.main.specific;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.deceen.data.poi.main.Common;
import com.deceen.data.poi.util.DateUtil;

public class BaseInfoOfSupervisor extends Common{

	public String BuildSql(List<String> list) {
		StringBuffer sb = new StringBuffer("INSERT INTO QAS_D_BASEINFOOFSUPERVISOR   ( ");
		sb.append("ID,EMPLOYEEID,SPECIALAREA,HOURSPERWEEK,TEACHINGYEAR,DUTY,SOURCE,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)");
		sb.append(" VALUES (");
		/**
 INSERT INTO QAS_D_BASEINFOOFSUPERVISOR   ( ID,EMPLOYEEID,SPECIALAREA,HOURSPERWEEK,TEACHINGYEAR,DUTY,SOURCE,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)
  VALUES ( #{id},#{employeeid},#{specialarea},#{hoursperweek},#{teachingyear},#{duty},#{source},#{status},#{createdby},#{createdtime},#{updatedby},#{updatedtime},#{tenantid},#{storagetime} )
*/
		
		String s1 =  list.get(0), s2 = list.get(7), s3 = list.get(13),s4 = list.get(9),s5 = list.get(11),s6 = list.get(12);
		
		String s =s1+"-"+s2+"-"+s3;
		if(this.set.contains(s)){
			return "";
		}
		set.add(s);

		String data = s5.substring(0,6);
		
		String id = UUID.randomUUID().toString();
		sb.append("'"+id+"',");
		sb.append("'"+s1+"',");
		sb.append("'"+s2+"',");
		sb.append(Float.parseFloat(s3)+",");
		sb.append(DateUtil.getTimeDifference(data)+",");
		sb.append("'"+s4+"',");
		sb.append("'"+s6+"',");
		sb.append("1,");
		sb.append("'system',");
		sb.append("now(),");
		sb.append("'system',");
		sb.append("now(),");
		sb.append("'',");
		sb.append("now()");
		sb.append(");");
		
		return sb.toString();
		
	}

	
	@Override
	public List<String> BuildSqlList(List<String> list) {
		List<String> sqls = new ArrayList<String>();
		sqls.add(BuildSql(list));
		return sqls;
	}
}
