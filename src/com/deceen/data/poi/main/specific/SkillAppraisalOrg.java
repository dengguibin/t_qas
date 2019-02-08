package com.deceen.data.poi.main.specific;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.deceen.data.poi.main.Common;

public class SkillAppraisalOrg extends Common{

	public String BuildSql(List<String> list) {
		StringBuffer sb = new StringBuffer(" INSERT INTO QAS_D_SKILLAPPRAISALORG   ( ID,NAME,GRADE,DEPARTMENT,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME) VALUES ");
		
//		  VALUES ( #{id},#{name},#{grade},#{department},#{status},#{createdby},#{createdtime},#{updatedby},#{updatedtime},#{tenantid},#{storagetime} )
		String s1 =  list.get(1), s2 = list.get(4), s3 = list.get(5);
		
		String s =s1+"-"+s2+"-"+s3;
		if(this.set.contains(s)){
			return "";
		}
		set.add(s);
		
		String id = UUID.randomUUID().toString();
		sb.append("(");
		sb.append("'"+id+"',");
		sb.append("'"+s1+"',");
		sb.append("'"+s2+"',");
		sb.append("'"+s3+"',");
		sb.append("1,");
		sb.append("'',");
		sb.append("now(),");
		sb.append("'',");
		sb.append("now(),");
		sb.append("'',");
		sb.append("now()");
		sb.append(")");
		
		return sb.toString();
		
	}
	@Override
	public List<String> BuildSqlList(List<String> list) {
		List<String> sqls = new ArrayList<String>();
		sqls.add(BuildSql(list));
		return sqls;
	}
}
