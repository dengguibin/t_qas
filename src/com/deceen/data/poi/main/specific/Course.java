package com.deceen.data.poi.main.specific;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.deceen.data.poi.main.Common;

public class Course extends Common{

	public String BuildSql(List<String> list) {
		StringBuffer sb = new StringBuffer("INSERT INTO QAS_D_COURSE   ( ");
		sb.append("ID,COURSECODE,COURSENAME,COURSETYPE,COURSEPROPERTY,ISIMPORTANT,ISCOOPRATE,PERFECT,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)");
		sb.append(" VALUES (");
		/**
INSERT INTO QAS_D_COURSE (
		ID,COURSECODE,COURSENAME,COURSETYPE,COURSEPROPERTY,ISIMPORTANT,ISCOOPRATE,PERFECT,SCORE,INNOVATION,ISQUALIFICATIONCERTCOURSE,ISCOLLEGEREFORMPROJ,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)
		VALUES (
		#{id},#{coursecode},#{coursename},#{coursetype},#{courseproperty},#{isimportant},#{iscooprate},#{perfect},#{score},#{innovation},#{isqualificationcertcourse},#{iscollegereformproj},#{status},#{createdby},#{createdtime},#{updatedby},#{updatedtime},#{tenantid},#{storagetime}
		
		 */
		
		String s1 =  list.get(3), s2 = list.get(4), s3 = list.get(5), s4 = list.get(6), s5 = list.get(10), s6 = list.get(11), s7 = list.get(12);
		
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
		sb.append("'"+s7+"',");
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
	
	public String BuildSql1(List<String> list) {
		StringBuffer sb = new StringBuffer("INSERT INTO QAS_D_MAJORCOURSE   ( ");
		sb.append(" ID,DIRECTIONID,COURSEID,COURSENATURE,PLANHOURS,NORMALHOURS,CLASSGRADE,CLASSADDRESS,CLASSTYPE,EXAMEMETHOD,PAPERTOCOURSE,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)");
		sb.append(" VALUES (");
		/**
 INSERT INTO QAS_D_MAJORCOURSE   ( ID,DIRECTIONID,COURSEID,COURSENATURE,PLANHOURS,NORMALHOURS,CLASSGRADE,CLASSADDRESS,CLASSTYPE,EXAMEMETHOD,PAPERTOCOURSE,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)
  VALUES ( #{id},#{directionid},#{courseid},#{coursenature},#{planhours},#{normalhours},#{classgrade},#{classaddress},#{classtype},#{examemethod},#{papertocourse},#{status},#{createdby},#{createdtime},#{updatedby},#{updatedtime},#{tenantid},#{storagetime} )
 */
		
		String s1 =  list.get(2), s2 = list.get(3), s3 = list.get(7), s4 = list.get(8), s5 = list.get(9), s6 = list.get(19), s7 = list.get(20), s8 = list.get(21),s9 = list.get(22),s10 = list.get(23);
		
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
		sb.append(Float.parseFloat(s4)+",");
		sb.append(Float.parseFloat(s5)+",");
		sb.append("'"+s6+"',");
		sb.append("'"+s7+"',");
		sb.append("'"+s8+"',");
		sb.append("'"+s9+"',");
		sb.append("'"+s10+"',");
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
//		sqls.add(BuildSql1(list));
		return sqls;
	}

}
