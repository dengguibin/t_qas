package com.deceen.data.poi.main.specific;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.deceen.data.poi.main.Common;

public class GraduateEmployment extends Common{

	public String BuildSql(List<String> list) {
		StringBuffer sb = new StringBuffer("INSERT INTO QAS_D_GRADUATEEMPLOYMENT   ( ");
		sb.append("ID,DIRECTIONID,EMPNUM,CITYEMPNUM,PRIVINCENUM,COLUMN_13AREANUM,OTHERNUM,EMPSALARY,SAMEPFSNUM,HIGHTSCHGRADNUM,HIGHTSCHNUM,TRISCHGRADNUM,TRISCHNUM,THREEADDTOWGRADNUM,THREEADDTOWNUM,COLLEGEGRADNUM,COLLEGENUM,DIFSKNOWSKGRAD,DIFSKNOWSKNUM,DIFSSAMEPFSGRAD,DIFSSAMEPFSNUM,DIFSSGLEXAMGRAD,DIFSSGLEXAMNUM,DIFSMULESTGRAD,DIFSMULESTNUM,DIFSMIDHIGGRAD,DIFSMIDHIGNUM,DIFSNOEXAMGRAD,DIFSNOEXAMNUM,DIFSOTHERGRAD,DIFSOTHERNUM,GRADNUM,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)");
		sb.append(" VALUES (");
		/**
 INSERT INTO QAS_D_GRADUATEEMPLOYMENT   ( ID,DIRECTIONID,EMPNUM,CITYEMPNUM,PRIVINCENUM,COLUMN_13AREANUM,OTHERNUM,EMPSALARY,SAMEPFSNUM,HIGHTSCHGRADNUM,HIGHTSCHNUM,TRISCHGRADNUM,TRISCHNUM,THREEADDTOWGRADNUM,THREEADDTOWNUM,COLLEGEGRADNUM,COLLEGENUM,DIFSKNOWSKGRAD,DIFSKNOWSKNUM,DIFSSAMEPFSGRAD,DIFSSAMEPFSNUM,DIFSSGLEXAMGRAD,DIFSSGLEXAMNUM,DIFSMULESTGRAD,DIFSMULESTNUM,DIFSMIDHIGGRAD,DIFSMIDHIGNUM,DIFSNOEXAMGRAD,DIFSNOEXAMNUM,DIFSOTHERGRAD,DIFSOTHERNUM,GRADNUM,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)
  VALUES ( #{id},#{directionid},#{empnum},#{cityempnum},#{privincenum},#{column_13areanum},#{othernum},#{empsalary},#{samepfsnum},#{hightschgradnum},#{hightschnum},#{trischgradnum},#{trischnum},#{threeaddtowgradnum},#{threeaddtownum},#{collegegradnum},#{collegenum},#{difsknowskgrad},#{difsknowsknum},#{difssamepfsgrad},#{difssamepfsnum},#{difssglexamgrad},#{difssglexamnum},#{difsmulestgrad},#{difsmulestnum},#{difsmidhiggrad},#{difsmidhignum},#{difsnoexamgrad},#{difsnoexamnum},#{difsothergrad},#{difsothernum},#{gradnum},#{status},#{createdby},#{createdtime},#{updatedby},#{updatedtime},#{tenantid},#{storagetime} )

		 */
		
		String s1 =  list.get(2), s2 = list.get(3), s3 = list.get(4), s4 = list.get(5), s5 = list.get(6), s6 = list.get(7),s7 = list.get(8),s8 = list.get(9), s9 = list.get(10), s10 = list.get(11), s11 = list.get(12),s12 = list.get(13),s13 = list.get(14), s14 = list.get(15),s15 = list.get(16), s16 = list.get(17),
		s17 = list.get(18),s18 = list.get(19), s19 = list.get(20), s20 = list.get(21), s21 = list.get(22),s22 = list.get(23),s23 = list.get(24), s24 = list.get(25),s25 = list.get(26), s26 = list.get(27),s27 = list.get(28),s28 = list.get(29), s29 = list.get(30),s30 = list.get(31),s31 = list.get(32);
//		String s =s1+"-"+s2+"-"+s3+"-"+s4+"-"+s5;
//		if(this.set.contains(s)){
//			return "";
//		}
//		set.add(s);

		String id = UUID.randomUUID().toString();
		sb.append("'"+id+"',");
		sb.append("'"+s1+"',");
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
		sb.append(Float.parseFloat(s13)+",");
		sb.append(Float.parseFloat(s14)+",");
		sb.append(Float.parseFloat(s15)+",");
		sb.append(Float.parseFloat(s16)+",");
		sb.append(Float.parseFloat(s17)+",");
		sb.append(Float.parseFloat(s18)+",");
		sb.append(Float.parseFloat(s19)+",");
		sb.append(Float.parseFloat(s20)+",");
		sb.append(Float.parseFloat(s21)+",");
		sb.append(Float.parseFloat(s22)+",");
		sb.append(Float.parseFloat(s23)+",");
		sb.append(Float.parseFloat(s24)+",");
		sb.append(Float.parseFloat(s25)+",");
		sb.append(Float.parseFloat(s26)+",");
		sb.append(Float.parseFloat(s27)+",");
		sb.append(Float.parseFloat(s28)+",");
		sb.append(Float.parseFloat(s29)+",");
		sb.append(Float.parseFloat(s30)+",");
		sb.append(Float.parseFloat(s31)+",");
		sb.append(Float.parseFloat(s2)+",");
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
