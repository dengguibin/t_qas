package com.deceen.data.poi.main.specific;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.deceen.data.poi.main.Common;

public class Major extends Common {

	public String BuildSql(List<String> list) {
		
		StringBuffer sb = new StringBuffer("INSERT INTO QAS_D_MAJOR (");
		sb.append("ID,ORGANIZATIONID,MAJORCODE,MAJORNAME,DIVISIONTYPE,ISENROLL,ENROLLDATE,NOTENROLLDATE,REVOKEMAJORCOUNT,STATUS," +
				"CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME) ");
		sb.append("VALUES (");

		String s1 = list.get(1), s2 = list.get(3), s3 = list.get(4), s4 = list.get(5), s5 = list.get(6), s6 = list.get(7), 
				s7 = list.get(8), s8 = list.get(9);

		String s = s1 + "-" + s2 + "-" + s3;
		if (this.set.contains(s)) {
			return "";
		}
		set.add(s);

		String id = UUID.randomUUID().toString();
		sb.append("'" + id + "',");
		sb.append("'" + s1 + "',");
		sb.append("'" + s2 + "',");
		sb.append(Float.parseFloat(s3) + ",");
		sb.append("'',");
		sb.append("'',");
		sb.append("'',");
		sb.append("'',");
		sb.append("'',");
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
		
		StringBuffer sb1 = new StringBuffer("INSERT INTO QAS_D_MAJORDIRECTION ");
		sb1.append(" ( ID,MAJORID,DIRECTIONCODE,DIRECTIONNAME,SETUPDATE,FIRSTRECRUITDATE,STUDYDURATION,STATUS,CREATEDBY," +
				"CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)");
		sb1.append("VALUES (");
		/**
		 * INSERT INTO QAS_D_MAJORDIRECTION (
		 * ID,MAJORID,DIRECTIONCODE,DIRECTIONNAME
		 * ,SETUPDATE,FIRSTRECRUITDATE,STUDYDURATION
		 * ,STATUS,CREATEDBY,CREATEDTIME
		 * ,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME) VALUES (
		 * #{id},#{majorid}
		 * ,#{directioncode},#{directionname},#{setupdate},#{firstrecruitdate
		 * },#{
		 * studyduration},#{status},#{createdby},#{createdtime},#{updatedby},
		 * #{updatedtime},#{tenantid},#{storagetime} )
		 */

		String s1 = list.get(1), s2 = list.get(3), s3 = list.get(4), s4 = list.get(5), s5 = list.get(6), s6 = list.get(7), 
				s7 = list.get(8), s8 = list.get(9);

		String s = s1 + "-" + s2 + "-" + s3;
		if (this.set.contains(s)) {
			return "";
		}
		set.add(s);

		String id1 = UUID.randomUUID().toString();
		sb1.append("'" + id1 + "',");
		sb1.append("'" + s2 + "',");
		sb1.append("'" + s4 + "',");
		sb1.append("'" + s5 + "',");
		sb1.append("str_to_date('" + s6 + "','%Y%m'),");
		sb1.append("str_to_date('" + s7 + "','%Y%m'),");
		sb1.append(s8 + ",");
		sb1.append("1,");
		sb1.append("'system',");
		sb1.append("now(),");
		sb1.append("'system',");
		sb1.append("now(),");
		sb1.append("'',");
		sb1.append("now()");
		sb1.append(");");
		return sb1.toString();

	}

	public String BuildSql2(List<String> list) {
		
		StringBuffer sb = new StringBuffer("INSERT INTO QAS_D_DIRECTIONSTATISTICS (");
		sb.append("ID,DIRECTIONID,NUMOFSTUDENT,NUMOFGRADEONE,NUMOFGRADETWO,NUMOFGRADETHREE,HIGHTPFSSTUNUM,MIDDLEPFSSTUNUM," +
				"MIDDLESCHTWOYEARBEHANDNUM,OTHERNUM,COREMAJOR,CHARACTERISTICMAJOR,ISINTERNATIONALMAJOR,GRADECOUNT,ORDERTRAIN," +
				"ISGRADUTIONBEFORE,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)");
		sb.append("VALUES (");
		/**
		 * INSERT INTO QAS_D_DIRECTIONSTATISTICS (
		 * ID,DIRECTIONID,NUMOFSTUDENT,NUMOFGRADEONE
		 * ,NUMOFGRADETWO,NUMOFGRADETHREE
		 * ,HIGHTPFSSTUNUM,MIDDLEPFSSTUNUM,MIDDLESCHTWOYEARBEHANDNUM
		 * ,OTHERNUM,COREMAJOR
		 * ,CHARACTERISTICMAJOR,ISINTERNATIONALMAJOR,GRADECOUNT
		 * ,ORDERTRAIN,ISGRADUTIONBEFORE
		 * ,ISCURRENTENROLL,EXCHANGEABROAD,RECEIVINGOVERSEAS
		 * ,EXCHANGESTUDENTS,STATUS
		 * ,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)
		 * VALUES ( #{id},#{directionid},#{numofstudent},#{numofgradeone},#{
		 * numofgradetwo
		 * },#{numofgradethree},#{hightpfsstunum},#{middlepfsstunum}
		 * ,#{middleschtwoyearbehandnum
		 * },#{othernum},#{coremajor},#{characteristicmajor
		 * },#{isinternationalmajor
		 * },#{gradecount},#{ordertrain},#{isgradutionbefore
		 * },#{iscurrentenroll},
		 * #{exchangeabroad},#{receivingoverseas},#{exchangestudents
		 * },#{status},#
		 * {createdby},#{createdtime},#{updatedby},#{updatedtime},#{
		 * tenantid},#{storagetime} )
		 */

		String s1 = list.get(5), s2 = list.get(10), s3 = list.get(11), s4 = list
				.get(12), s5 = list.get(13), s6 = list.get(14), s7 = list
				.get(15), s8 = list.get(16), s9 = list.get(17), s10 = list
				.get(18), s11 = list.get(19), s12 = list.get(20), s13 = list
				.get(21), s14 = list.get(22), s15 = list.get(23), s16 = list.get(24);
		String s = s1 + "-" + s2 + "-" + s3;
		if (this.set.contains(s)) {
			return "";
		}
		set.add(s);

		String id1 = UUID.randomUUID().toString();
		sb.append("'" + id1 + "',");
		sb.append("'" + s1 + "',");
		sb.append(Float.parseFloat(s2) + ",");
		sb.append(Float.parseFloat(s3) + ",");
		sb.append(Float.parseFloat(s4) + ",");
		sb.append(Float.parseFloat(s5) + ",");
		sb.append(Float.parseFloat(s6) + ",");
		sb.append(Float.parseFloat(s7) + ",");
		sb.append(Float.parseFloat(s8) + ",");
		sb.append(Float.parseFloat(s9) + ",");
		sb.append("'" + s10 + "',");
		sb.append("'" + s11 + "',");
		sb.append("'" + s12 + "',");
		sb.append(Float.parseFloat(s13) + ",");
		sb.append(Float.parseFloat(s15) + ",");
		sb.append("'" + s16 + "',");
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
		// sqls.add(BuildSql(list));
		// sqls.add(BuildSql1(list));
		sqls.add(BuildSql2(list));
		return sqls;
	}
}
