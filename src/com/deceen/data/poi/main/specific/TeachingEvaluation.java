package com.deceen.data.poi.main.specific;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.deceen.data.poi.main.Common;

public class TeachingEvaluation extends Common{

	public String BuildSql(List<String> list) {
		StringBuffer sb = new StringBuffer("INSERT INTO QAS_D_TEACHINGEVALUATION   ( ");
		sb.append("ID,TEACHINGEVALUATIONSTARTTIME,TEACHINGEVALUATIONENDTIME,NUMOFPARTICIPANTTEACHER,TOTALNUMOFTEACHER,NUMOFSTUDENT,TOTALNUMOFSTUDENT,NUMOFPARTICIPANTSCHOOLMATE,TOTALNUMOFSCHOOLMATE,NUMOFPARTICIPANTLEADER,TOTALNUMOFLEADER,NUMOFPARTICIPANTSOCIETY,TOTALNUMOFSOCIETY,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)");
		sb.append(" VALUES (");
		/**
INSERT INTO QAS_D_TEACHINGEVALUATION   ( ID,TEACHINGEVALUATIONSTARTTIME,TEACHINGEVALUATIONENDTIME,NUMOFPARTICIPANTTEACHER,TOTALNUMOFTEACHER,NUMOFSTUDENT,TOTALNUMOFSTUDENT,NUMOFPARTICIPANTSCHOOLMATE,TOTALNUMOFSCHOOLMATE,NUMOFPARTICIPANTLEADER,TOTALNUMOFLEADER,NUMOFPARTICIPANTSOCIETY,TOTALNUMOFSOCIETY,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)
  VALUES ( #{id},#{teachingevaluationstarttime},#{teachingevaluationendtime},#{numofparticipantteacher},#{totalnumofteacher},#{numofstudent},#{totalnumofstudent},#{numofparticipantschoolmate},#{totalnumofschoolmate},#{numofparticipantleader},#{totalnumofleader},#{numofparticipantsociety},#{totalnumofsociety},#{status},#{createdby},#{createdtime},#{updatedby},#{updatedtime},#{tenantid},#{storagetime} )
*/
		
		String s1 =  list.get(0), s2 = list.get(1), s3 = list.get(2),s4 = list.get(3),s5 = list.get(4),s6 = list.get(5), s7 = list.get(6),s8 = list.get(7),s9 = list.get(8),s10 = list.get(9), s11 = list.get(10), s12 = list.get(11);
		
		String s =s1+"-"+s2+"-"+s3;
		if(this.set.contains(s)){
			return "";
		}
		set.add(s);

		String id = UUID.randomUUID().toString();
		sb.append("'"+id+"',");
		sb.append("'"+s1+"',");
		sb.append("'"+s2+"',");
		sb.append(Float.parseFloat(s3)+",");
		sb.append(Float.parseFloat(s4)+",");
		sb.append(Float.parseFloat(s5)+",");
		sb.append(Float.parseFloat(s6)+",");
		sb.append(Float.parseFloat(s7)+",");
		sb.append(Float.parseFloat(s8)+",");
		sb.append(Float.parseFloat(s9)+",");
		sb.append(Float.parseFloat(s10)+",");
		sb.append(Float.parseFloat(s11)+",");
		sb.append(Float.parseFloat(s12)+",");
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
