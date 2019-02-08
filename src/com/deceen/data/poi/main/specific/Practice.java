package com.deceen.data.poi.main.specific;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.deceen.data.poi.main.Common;

public class Practice extends Common{

	public String BuildSql(List<String> list) {
		StringBuffer sb = new StringBuffer("INSERT INTO QAS_D_PRACTICE   ( ");
		sb.append(" ID,DIRECTIONID,GRADPRACTICENUM,RECRUITEDNUM,SAMEPFSNUM,COMPANYNUM,JOINEDNUM,INSURANCENAME,PRACTICE_POSTS,PRACTICE_COMPY,PRACTICENUM,PRACTICETIME,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)");
		sb.append(" VALUES (");
		/**
 INSERT INTO QAS_D_PRACTICE   ( ID,DIRECTIONID,GRADPRACTICENUM,RECRUITEDNUM,SAMEPFSNUM,COMPANYNUM,JOINEDNUM,INSURANCENAME,PRACTICE_POSTS,PRACTICE_COMPY,PRACTICENUM,PRACTICETIME,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)
  VALUES ( #{id},#{directionid},#{gradpracticenum},#{recruitednum},#{samepfsnum},#{companynum},#{joinednum},#{insurancename},#{practice_posts},#{practice_compy},#{practicenum},#{practicetime},#{status},#{createdby},#{createdtime},#{updatedby},#{updatedtime},#{tenantid},#{storagetime} )
		 */
		
		String s1 =  list.get(2), s2 = list.get(4), s3 = list.get(5), s4 = list.get(6), s5 = list.get(7), s6 = list.get(8),s7 = list.get(10),s8 = list.get(11), s9 = list.get(12), s10 = list.get(13),s11 = list.get(14);
		
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
		sb.append(Float.parseFloat(s4)+",");
		sb.append(Float.parseFloat(s5)+",");
		sb.append(Float.parseFloat(s6)+",");
		sb.append("'"+s7+"',");
		sb.append("'"+s8+"',");
		sb.append("'"+s9+"',");
		sb.append(Float.parseFloat(s10)+",");
		sb.append(Float.parseFloat(s11)+",");
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
