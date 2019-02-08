package com.deceen.data.poi.main.specific;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.deceen.data.poi.main.Common;

public class Qualification extends Common{

	public String BuildSql(List<String> list) {
		StringBuffer sb = new StringBuffer("INSERT INTO QAS_D_QUALIFICATION   ( ");
		sb.append(" ID,DIRECTIONID,CERTNAME,CERTLEVEL,CERTCOUNT,ISSUINGDEPARTMENT,IDENTIFICATIONSITE,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)");
		sb.append(" VALUES (");
		/**
 INSERT INTO QAS_D_QUALIFICATION   ( ID,DIRECTIONID,CERTNAME,CERTLEVEL,CERTCOUNT,ISSUINGDEPARTMENT,IDENTIFICATIONSITE,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)
  VALUES ( #{id},#{directionid},#{certname},#{certlevel},#{certcount},#{issuingdepartment},#{identificationsite},#{status},#{createdby},#{createdtime},#{updatedby},#{updatedtime},#{tenantid},#{storagetime} )

		 */
		
		String s1 =  list.get(2), s2 = list.get(3), s3 = list.get(4), s4 = list.get(5), s5 = list.get(6), s6 = list.get(7);
		
		String s =s1+"-"+s2+"-"+s3+"-"+s4+"-"+s5;
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
