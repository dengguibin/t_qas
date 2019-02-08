package com.deceen.data.poi.main.specific;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.deceen.data.poi.main.Common;

public class Recruit extends Common{

	public String BuildSql(List<String> list) {
		StringBuffer sb = new StringBuffer("INSERT INTO QAS_D_RECRUIT   ( ");
		sb.append(" ID,DIRECTIONID,PLANENROLNUM,ENROLEDNUM,REGNUM,LOCALREGNUM,PROVREGNUM,AREAREGNUM,BRANDRSNNUM,HOBBIESRSNNUM,EMPRSNNUM,TRAINRSNNUM,SITERSNNUM,RECOMMENDRSNNUM,OTHERRSNNUM,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)");
		sb.append(" VALUES (");
		/**
 INSERT INTO QAS_D_RECRUIT   ( ID,DIRECTIONID,PLANENROLNUM,ENROLEDNUM,REGNUM,LOCALREGNUM,PROVREGNUM,AREAREGNUM,BRANDRSNNUM,HOBBIESRSNNUM,EMPRSNNUM,TRAINRSNNUM,SITERSNNUM,RECOMMENDRSNNUM,OTHERRSNNUM,OVERLASTYEARSCORE,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)
  VALUES ( #{id},#{directionid},#{planenrolnum},#{enrolednum},#{regnum},#{localregnum},#{provregnum},#{arearegnum},#{brandrsnnum},#{hobbiesrsnnum},#{emprsnnum},#{trainrsnnum},#{sitersnnum},#{recommendrsnnum},#{otherrsnnum},#{overlastyearscore},#{status},#{createdby},#{createdtime},#{updatedby},#{updatedtime},#{tenantid},#{storagetime} )

		 */
		
		String s1 =  list.get(2), s2 = list.get(3), s3 = list.get(4), s4 = list.get(5), s5 = list.get(6), s6 = list.get(7),s7 = list.get(8),s8 = list.get(9), s9 = list.get(10), s10 = list.get(11), s11 = list.get(12),s12 = list.get(13),s13 = list.get(14), s14 = list.get(15);
		
//		String s =s1+"-"+s2+"-"+s3+"-"+s4+"-"+s5;
//		if(this.set.contains(s)){
//			return "";
//		}
//		set.add(s);

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
		sb.append(Float.parseFloat(s13)+",");
		sb.append(Float.parseFloat(s14)+",");
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
