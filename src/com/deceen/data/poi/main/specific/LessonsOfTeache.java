package com.deceen.data.poi.main.specific;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.deceen.data.poi.main.Common;

public class LessonsOfTeache extends Common{

	public String BuildSql(List<String> list) {
		StringBuffer sb = new StringBuffer("INSERT INTO QAS_D_LESSONSOFTEACHER   ( ");
		sb.append(" ID,EMPLOYEEID,DIRECTIONID,COURSEID,TEACHINGTASK,ISMERGECLASS,ISPARALLELCLASS,TEACHINGLOAD,EXPERIMENT,TRAINING,PRACTICE,ISEXECUTIVECLASS,TERM,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)");
		sb.append(" VALUES (");
		/**
 INSERT INTO QAS_D_LESSONSOFTEACHER   ( ID,EMPLOYEEID,DIRECTIONID,COURSEID,TEACHINGTASK,ISMERGECLASS,ISPARALLELCLASS,TEACHINGLOAD,HOUR,EXPERIMENT,TRAINING,PRACTICE,ISEXECUTIVECLASS,TERM,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)
  VALUES ( #{id},#{employeeid},#{directionid},#{courseid},#{teachingtask},#{ismergeclass},#{isparallelclass},#{teachingload},#{hour},#{experiment},#{training},#{practice},#{isexecutiveclass},#{term},#{status},#{createdby},#{createdtime},#{updatedby},#{updatedtime},#{tenantid},#{storagetime} )
*/
		
		String s1 =  list.get(1), s2 = list.get(3), s3 = list.get(5), s4 = list.get(8), s5 = list.get(9),s6 = list.get(10),s7 = list.get(13),s8 = list.get(14),s9 = list.get(15),s10 = list.get(16),
				s11 =  list.get(11), s12 = list.get(12);
		String s =s1+"-"+s2+"-"+s3;
		if(this.set.contains(s)){
			return "";
		}
		set.add(s);

		String id = UUID.randomUUID().toString();
		sb.append("'"+id+"',");
		sb.append("'"+s1+"',");
		sb.append("'"+s2+"',");
		sb.append("'"+s3+"',");
		sb.append("'"+s4+"',");
		sb.append("'"+s5+"',");
		sb.append("'"+s6+"',");
		sb.append(Float.parseFloat(s7)+",");
		sb.append("'"+s8+"',");
		sb.append("'"+s9+"',");
		sb.append("'"+s10+"',");
		sb.append("'"+s11+"',");
		sb.append("'"+s12+"',");
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
