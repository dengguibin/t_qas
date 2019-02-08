package com.deceen.data.poi.main.specific;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.deceen.data.poi.main.Common;

public class CooperateCompany extends Common{

	public String BuildSql(List<String> list) {
		StringBuffer sb = new StringBuffer("INSERT INTO QAS_D_COOPERATE   ( ");
		sb.append("ID,DIRECTIONID,COMPANIES,ORDERCOUNT,TEACHCOURSE,TEACHMATERIAL,PARTTIMETCH,PRACTICESTUD,DONATEDEVVAL,READYDONATEVAL,ACCESSWORK,SERVICEVALUE,TRAINCOUNT,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)");
		sb.append(" VALUES (");
		/**
 INSERT INTO QAS_D_COOPERATE   ( ID,DIRECTIONID,COMPANIES,ORDERCOUNT,TEACHCOURSE,TEACHMATERIAL,PARTTIMETCH,PRACTICESTUD,DONATEDEVVAL,READYDONATEVAL,ACCESSWORK,SERVICEVALUE,TRAINCOUNT,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)
  VALUES ( #{id},#{directionid},#{companies},#{ordercount},#{teachcourse},#{teachmaterial},#{parttimetch},#{practicestud},#{donatedevval},#{readydonateval},#{accesswork},#{servicevalue},#{traincount},#{status},#{createdby},#{createdtime},#{updatedby},#{updatedtime},#{tenantid},#{storagetime} )
*/
		
		String s1 =  list.get(1), s2 = list.get(3), s3 = list.get(4), s4 = list.get(5), s5 = list.get(6), s6 = list.get(7), s7 = list.get(8), s8 = list.get(9), s9 = list.get(10), s10 = list.get(11), s11 = list.get(12),s12 = list.get(13);
		
		String s =s1+"-"+s2+"-"+s3;
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
	
	public String BuildSql1(List<String> list) {
		StringBuffer sb = new StringBuffer("INSERT INTO QAS_D_COOPERATECOMPANY   ( ");
		sb.append(" ID,DIRECTIONID,COMPANY,STARTTIME,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)");
		sb.append(" VALUES ");
		/**
 INSERT INTO QAS_D_COOPERATECOMPANY   ( ID,DIRECTIONID,COMPANY,STARTTIME,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)
  VALUES ( #{id},#{directionid},#{company},#{starttime},#{status},#{createdby},#{createdtime},#{updatedby},#{updatedtime},#{tenantid},#{storagetime} )
	 */
		
		String s1 =  list.get(2), s2 = list.get(14), s3 = list.get(15),s4 = list.get(16), s5 = list.get(17),s6 = list.get(18), s7 = list.get(19),s8 = list.get(20), s9 = list.get(21),s10 = list.get(22), s11 = list.get(23);
		
		String s =s1+"-"+s2+"-"+s3;
		if(this.set.contains(s)){
			return "";
		}
		set.add(s);

		sb.append("(").append("'"+UUID.randomUUID().toString()+"',").append("'"+s1+"',").append("'"+s2+"',").append("'"+s3+"',");
		sb.append("1,");
		sb.append("'system',");
		sb.append("now(),");
		sb.append("'system',");
		sb.append("now(),");
		sb.append("'',");
		sb.append("now()");
		sb.append("),");
		sb.append("(").append("'"+UUID.randomUUID().toString()+"',").append("'"+s1+"',").append("'"+s4+"',").append("'"+s5+"',");
		sb.append("1,");
		sb.append("'system',");
		sb.append("now(),");
		sb.append("'system',");
		sb.append("now(),");
		sb.append("'',");
		sb.append("now()");
		sb.append("),");
		sb.append("(").append("'"+UUID.randomUUID().toString()+"',").append("'"+s1+"',").append("'"+s6+"',").append("'"+s7+"',");
		sb.append("1,");
		sb.append("'system',");
		sb.append("now(),");
		sb.append("'system',");
		sb.append("now(),");
		sb.append("'',");
		sb.append("now()");
		sb.append("),");
		sb.append("(").append("'"+UUID.randomUUID().toString()+"',").append("'"+s1+"',").append("'"+s8+"',").append("'"+s9+"',");
		sb.append("1,");
		sb.append("'system',");
		sb.append("now(),");
		sb.append("'system',");
		sb.append("now(),");
		sb.append("'',");
		sb.append("now()");
		sb.append("),");
		sb.append("(").append("'"+UUID.randomUUID().toString()+"',").append("'"+s1+"',").append("'"+s10+"',").append("'"+s11+"',");
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
		sqls.add(BuildSql1(list));
		return sqls;
	}

}
