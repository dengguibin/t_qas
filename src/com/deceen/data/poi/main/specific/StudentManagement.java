package com.deceen.data.poi.main.specific;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.deceen.data.poi.main.Common;

public class StudentManagement extends Common{

	public String BuildSql(List<String> list) {
		StringBuffer sb = new StringBuffer("INSERT INTO QAS_D_STUDENTMANAGEMENT   ( ");
		sb.append("ID,EMPLOYEEID,POSTAGE,MANAGERAGE,ISPOLITICALINSTRUCTOR,ISPSYCHOLOGIST,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)");
		sb.append(" VALUES (");
		/**
 INSERT INTO QAS_D_STUDENTMANAGEMENT   ( ID,EMPLOYEEID,POSTAGE,MANAGERAGE,ISPOLITICALINSTRUCTOR,ISPSYCHOLOGIST,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)
  VALUES ( #{id},#{employeeid},#{postage},#{managerage},#{ispoliticalinstructor},#{ispsychologist},#{status},#{createdby},#{createdtime},#{updatedby},#{updatedtime},#{tenantid},#{storagetime} )
 */
		
		String s1 =  list.get(0), s2 = list.get(15), s3 = list.get(16), s4 = list.get(17), s5 = list.get(18);
		
		String s =s1+"-"+s2+"-"+s3+"-"+s4+"-"+s5;
		if(this.set.contains(s)){
			return "";
		}
		set.add(s);

		String id = UUID.randomUUID().toString();
		sb.append("'"+id+"',");
		sb.append("'"+s1+"',");
		sb.append(Float.parseFloat(s2)+",");
		sb.append(Float.parseFloat(s3)+",");
		sb.append("'"+s4+"',");
		sb.append("'"+s5+"',");
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
