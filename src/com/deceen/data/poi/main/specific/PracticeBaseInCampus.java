package com.deceen.data.poi.main.specific;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.deceen.data.poi.main.Common;

public class PracticeBaseInCampus extends Common{

	public String BuildSql(List<String> list) {
		StringBuffer sb = new StringBuffer(" INSERT INTO QAS_D_PRACTICEBASEINCAMPUS   ( ID,NAME,SUPPORTDEPARTMENT,APPROVALDATE,CONSTRUCTIONAREA,ISCOCONSTRUCTION,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME) VALUES ");
		
		//判断重复
		String s1 =  list.get(1), s2 = list.get(4), s3 = list.get(5), s4 = list.get(6);
		
		String s =s1+"-"+s2+"-"+s3 + "-"+s4;
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
		sb.append(""+Float.parseFloat(s4)+",");
		sb.append("'',");
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
