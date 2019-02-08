package com.deceen.data.poi.main.specific;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import com.deceen.data.poi.main.Common;

public class Teacher extends Common{

	public String BuildSql3(List<String> list) {
		StringBuffer sb = new StringBuffer("INSERT INTO QAS_D_TEACHERPARTTIMEWORK   ( ");
		sb.append(" ID,EMPLOYEEID,PARTTIMEUNIT,PARTTIMEDAY,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)");
		sb.append(" VALUES (");
		/**
 INSERT INTO QAS_D_TEACHERPARTTIMEWORK   ( ID,EMPLOYEEID,PARTTIMEUNIT,PARTTIMEDAY,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)
  VALUES ( #{id},#{employeeid},#{parttimeunit},#{parttimeday},#{status},#{createdby},#{createdtime},#{updatedby},#{updatedtime},#{tenantid},#{storagetime} )
*/
		
		String s1 =  list.get(0), s2 = list.get(9);
		Float s3 =Float.parseFloat( list.get(10));
		if(StringUtils.isEmpty(s2)){
			return "";
		}
		String s =s1+"-"+s2+"-"+s3;
		if(this.set.contains(s)){
			return "";
		}
		set.add(s);

		String id = UUID.randomUUID().toString();
		sb.append("'"+id+"',");
		sb.append("'"+s1+"',");
		sb.append("'"+s2+"',");
		sb.append(s3+",");
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
		StringBuffer sb = new StringBuffer("INSERT INTO QAS_D_TEACHERTRAINING   ( ");
		sb.append(" ID,EMPLOYEEID,TRAININGNAME,TRAININGDAY,TRAININGSITE,TRAININGDISPATCHEDDEPARTMENT,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)");
		sb.append(" VALUES (");
		/**
 INSERT INTO QAS_D_TEACHERTRAINING   ( ID,EMPLOYEEID,TRAININGNAME,TRAININGDAY,TEACHINGHOUR,NATIONALITY,TRAININGSITE,TRAININGDISPATCHEDDEPARTMENT,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)
  VALUES ( #{id},#{employeeid},#{trainingname},#{trainingday},#{teachinghour},#{nationality},#{trainingsite},#{trainingdispatcheddepartment},#{status},#{createdby},#{createdtime},#{updatedby},#{updatedtime},#{tenantid},#{storagetime} )
*/
		
		String s1 =  list.get(0), s2 = list.get(1),s3 = list.get(2),s4 = list.get(3),s5 = list.get(4);
		if(StringUtils.isEmpty(s2)){
			return "";
		}
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
	
	public String BuildSql5(List<String> list) {
		StringBuffer sb = new StringBuffer("INSERT INTO QAS_D_TEACHERTECHNICALMONOPOLY   ( ");
		sb.append("ID,EMPLOYEEID,TECHNICALMONOPOLYRECEIVEDATE,TECHNICALMONOPOLYNAME,TECHNICALMONOPOLYCODE,TECHNICALMONOPOLYISHOST,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)");
		sb.append(" VALUES (");
		/**
INSERT INTO QAS_D_TEACHERTECHNICALMONOPOLY   ( ID,EMPLOYEEID,TECHNICALMONOPOLYTYPE,TECHNICALMONOPOLYRECEIVEDATE,TECHNICALMONOPOLYNAME,TECHNICALMONOPOLYCODE,TECHNICALMONOPOLYISHOST,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)
  VALUES ( #{id},#{employeeid},#{technicalmonopolytype},#{technicalmonopolyreceivedate},#{technicalmonopolyname},#{technicalmonopolycode},#{technicalmonopolyishost},#{status},#{createdby},#{createdtime},#{updatedby},#{updatedtime},#{tenantid},#{storagetime} )
*/
		
		String s1 =  list.get(0), s2 = list.get(16),s3 = list.get(17),s4 = list.get(18),s5 = list.get(19);
		if(StringUtils.isEmpty(s2)){
			return "";
		}
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
	
	public String BuildSql6(List<String> list) {
		StringBuffer sb = new StringBuffer("INSERT INTO QAS_D_TEACHERRESEARCH   ( ");
		sb.append(" ID,EMPLOYEEID,RESEARCHNATURE,RESEARCHTYPE,RESEARCHNAME,RESEARCHISHORIZONTALISSUE,RESEARCHLEVEL,RESEARCHESTABLISHDATE,RESEARCHFUND,RESEARCHAMOUNTRECEIVED,RESEARCHCOMPLETEORDER,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)");
		sb.append(" VALUES (");
		/**
 INSERT INTO QAS_D_TEACHERRESEARCH   ( ID,EMPLOYEEID,RESEARCHNATURE,RESEARCHTYPE,RESEARCHNAME,RESEARCHISHORIZONTALISSUE,RESEARCHLEVEL,RESEARCHESTABLISHDATE,RESEARCHFUND,RESEARCHAMOUNTRECEIVED,RESEARCHCOMPLETEORDER,RESEARCHSOURCE,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)
  VALUES ( #{id},#{employeeid},#{researchnature},#{researchtype},#{researchname},#{researchishorizontalissue},#{researchlevel},#{researchestablishdate},#{researchfund},#{researchamountreceived},#{researchcompleteorder},#{researchsource},#{status},#{createdby},#{createdtime},#{updatedby},#{updatedtime},#{tenantid},#{storagetime} )
*/
		
		String s1 =  list.get(0), s2 = list.get(20),s3 = list.get(21),s4 = list.get(22),s5 = list.get(23),s6 = list.get(24),s7 = list.get(25),s8 = list.get(26),s9 = list.get(27),s10 = list.get(28);
		if(StringUtils.isEmpty(s4)){
			return "";
		}
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
		sb.append("'"+s7+"',");
		sb.append("'"+s8+"',");
		sb.append(Float.parseFloat(s9)+",");
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
	
	public String BuildSql7(List<String> list) {
		StringBuffer sb = new StringBuffer("INSERT INTO QAS_D_TEACHERPUBLISHEDPAPER   ( ");
		sb.append(" ID,EMPLOYEEID,NAME,COMPANY,PUBLISHEDDATE,AUTHORORDER,KIND,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)");
		sb.append(" VALUES (");
		/**
 INSERT INTO QAS_D_TEACHERPUBLISHEDPAPER   ( ID,EMPLOYEEID,NAME,COMPANY,PUBLISHEDDATE,AUTHORORDER,KIND,ISMAIN,ISRESEARCH,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)
  VALUES ( #{id},#{employeeid},#{name},#{company},#{publisheddate},#{authororder},#{kind},#{ismain},#{isresearch},#{status},#{createdby},#{createdtime},#{updatedby},#{updatedtime},#{tenantid},#{storagetime} )
*/
		
		String s1 =  list.get(0), s2 = list.get(29),s3 = list.get(31),s4 = list.get(32),s5 = list.get(33),s6 = list.get(30);
		if(StringUtils.isEmpty(s2)){
			return "";
		}
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
	
	public String BuildSql2(List<String> list) {
		StringBuffer sb = new StringBuffer("INSERT INTO QAS_D_TEACHERSECONDMENT   ( ");
		sb.append("ID,EMPLOYEEID,SECONDMENTDEPARTMENTNAME,SECONDMENTUNIT,SECONDMENTDAY,SECONDMENTDISPATCHEDDEPARTMENT,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)");
		sb.append(" VALUES (");
		/**
 INSERT INTO QAS_D_TEACHERSECONDMENT   ( ID,EMPLOYEEID,SECONDMENTDEPARTMENTNAME,SECONDMENTUNIT,SECONDMENTDAY,SECONDMENTHOUR,SECONDMENTDISPATCHEDDEPARTMENT,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)
  VALUES ( #{id},#{employeeid},#{secondmentdepartmentname},#{secondmentunit},#{secondmentday},#{secondmenthour},#{secondmentdispatcheddepartment},#{status},#{createdby},#{createdtime},#{updatedby},#{updatedtime},#{tenantid},#{storagetime} )
*/
		
		String s1 =  list.get(0), s2 = list.get(5),s3 = list.get(6),s4 = list.get(7),s5 = list.get(8);
		if(StringUtils.isEmpty(s2)){
			return "";
		}
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
		sb.append(Float.parseFloat(s4)+",");
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
	
	public String BuildSql4(List<String> list) {
		StringBuffer sb = new StringBuffer("INSERT INTO QAS_D_TEACHERAWARD   ( ");
		sb.append(" ID,EMPLOYEEID,AWARDDATE,AWARDNAME,AWARDGRADE,AWARDINGUNIT,AWARDISHOST,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)");
		sb.append(" VALUES (");
		/**
 INSERT INTO QAS_D_TEACHERAWARD   ( ID,EMPLOYEEID,AWARDDATE,AWARDNAME,AWARDGRADE,AWARDINGUNIT,AWARDISHOST,AWARDTYPE,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)
  VALUES ( #{id},#{employeeid},#{awarddate},#{awardname},#{awardgrade},#{awardingunit},#{awardishost},#{awardtype},#{status},#{createdby},#{createdtime},#{updatedby},#{updatedtime},#{tenantid},#{storagetime} )
*/
		
		String s1 =  list.get(0), s2 = list.get(11),s3 = list.get(12),s4 = list.get(13),s5 = list.get(14),s6 = list.get(15);
		if(StringUtils.isEmpty(s2)){
			return "";
		}
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
//		sqls.add(BuildSql1(list));
//		sqls.add(BuildSql2(list));
//		sqls.add(BuildSql3(list));
//		sqls.add(BuildSql4(list));
//		sqls.add(BuildSql5(list));
//		sqls.add(BuildSql6(list));
		sqls.add(BuildSql7(list));			
		return sqls;
	}

}
