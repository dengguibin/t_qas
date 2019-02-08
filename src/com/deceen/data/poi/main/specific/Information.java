package com.deceen.data.poi.main.specific;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.deceen.data.poi.main.Common;

public class Information extends Common {

	public String BuildSql1(List<String> list) {
		StringBuffer sb = new StringBuffer(
				"INSERT INTO QAS_D_AREAOFSTRUCTURE   ( ");
		sb.append(" ID,AREACOVERED,CONSTRUCTIONAREA,SCHOOLBUILDINGAREA,SCHOOLADDBUILDING,NONSCHOOLPROPERTYAREA,"
				+ "RESEARCHANDAUXILIARY,CLASSROOM,LIBRARY,LABORATORYANDPRACTICE,SPECIALRESEARCH,STADIUM,HALL,OFFICE,LIVINGROOM,"
				+ "STUDENTDORMITORY,STUDENTCANTEEN,EMPLOYEEDORMITORY,EMPLOYEECANTEEN,WELFAREHOUSE,FACULTYRESIDENCE,OTHERRESIDENCE,"
				+ "ACREAGE,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)");
		sb.append(" VALUES (");
		/**
		 * INSERT INTO QAS_D_AREAOFSTRUCTURE (
		 * ID,AREACOVERED,CONSTRUCTIONAREA,SCHOOLBUILDINGAREA
		 * ,SCHOOLADDBUILDING,NONSCHOOLPROPERTYAREA
		 * ,RESEARCHANDAUXILIARY,CLASSROOM
		 * ,LIBRARY,LABORATORYANDPRACTICE,SPECIALRESEARCH
		 * ,STADIUM,HALL,OFFICE,LIVINGROOM
		 * ,STUDENTDORMITORY,STUDENTCANTEEN,EMPLOYEEDORMITORY
		 * ,EMPLOYEECANTEEN,WELFAREHOUSE
		 * ,FACULTYRESIDENCE,OTHERRESIDENCE,INTEGRATEDCLASSROOM
		 * ,ACREAGE,STATUS,CREATEDBY
		 * ,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME) VALUES (
		 * #{id},#{areacovered},#{constructionarea},#{schoolbuildingarea},#{
		 * schooladdbuilding
		 * },#{nonschoolpropertyarea},#{researchandauxiliary},#{
		 * classroom},#{library
		 * },#{laboratoryandpractice},#{specialresearch},#{stadium
		 * },#{hall},#{office
		 * },#{livingroom},#{studentdormitory},#{studentcanteen
		 * },#{employeedormitory
		 * },#{employeecanteen},#{welfarehouse},#{facultyresidence
		 * },#{otherresidence
		 * },#{integratedclassroom},#{acreage},#{status},#{createdby
		 * },#{createdtime
		 * },#{updatedby},#{updatedtime},#{tenantid},#{storagetime} )
		 */

		String s1 = list.get(0), s2 = list.get(2), s3 = list.get(3), s4 = list
				.get(4), s5 = list.get(5), s6 = list.get(6), s7 = list.get(7), s8 = list
				.get(8), s9 = list.get(9), s10 = list.get(10), s11 = list
				.get(11), s12 = list.get(12), s13 = list.get(13), s14 = list
				.get(14), s15 = list.get(15), s16 = list.get(16), s17 = list
				.get(17), s18 = list.get(18), s19 = list.get(19), s20 = list
				.get(20), s21 = list.get(21), s22 = list.get(1);

		String id = UUID.randomUUID().toString();
		sb.append("'" + id + "',");
		sb.append(Float.parseFloat(s1) + ",");
		sb.append(Float.parseFloat(s2) + ",");
		sb.append(Float.parseFloat(s3) + ",");
		sb.append(Float.parseFloat(s4) + ",");
		sb.append(Float.parseFloat(s5) + ",");
		sb.append(Float.parseFloat(s6) + ",");
		sb.append(Float.parseFloat(s7) + ",");
		sb.append(Float.parseFloat(s8) + ",");
		sb.append(Float.parseFloat(s9) + ",");
		sb.append(Float.parseFloat(s10) + ",");
		sb.append(Float.parseFloat(s11) + ",");
		sb.append(Float.parseFloat(s12) + ",");
		sb.append(Float.parseFloat(s13) + ",");
		sb.append(Float.parseFloat(s14) + ",");
		sb.append(Float.parseFloat(s15) + ",");
		sb.append(Float.parseFloat(s16) + ",");
		sb.append(Float.parseFloat(s17) + ",");
		sb.append(Float.parseFloat(s18) + ",");
		sb.append(Float.parseFloat(s19) + ",");
		sb.append(Float.parseFloat(s20) + ",");
		sb.append(Float.parseFloat(s21) + ",");
		sb.append(Float.parseFloat(s22) + ",");
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
		StringBuffer sb = new StringBuffer(
				"INSERT INTO QAS_D_BOOKSINLIBRARY   ( ");
		sb.append(" ID,NUMOFBOOK,NUMOFNEWBOOK,CHINESEJOURNAL,FOREIGNJOURNAL,ELECTRONICJOURNAL,STATUS,CREATEDBY,CREATEDTIME," +
				"UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)");
		sb.append(" VALUES (");
		/**
		 * INSERT INTO QAS_D_BOOKSINLIBRARY (
		 * ID,NUMOFBOOK,NUMOFNEWBOOK,CHINESEJOURNAL
		 * ,FOREIGNJOURNAL,ELECTRONICJOURNAL
		 * ,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY
		 * ,UPDATEDTIME,TENANTID,STORAGETIME) VALUES (
		 * #{id},#{numofbook},#{numofnewbook
		 * },#{chinesejournal},#{foreignjournal}
		 * ,#{electronicjournal},#{status},#
		 * {createdby},#{createdtime},#{updatedby
		 * },#{updatedtime},#{tenantid},#{storagetime} )
		 */

		String s1 = list.get(0), s2 = list.get(1), s3 = list.get(2), s4 = list
				.get(3), s5 = list.get(4);
		String id = UUID.randomUUID().toString();
		sb.append("'" + id + "',");
		sb.append(Float.parseFloat(s1) + ",");
		sb.append(Float.parseFloat(s2) + ",");
		sb.append(Float.parseFloat(s3) + ",");
		sb.append(Float.parseFloat(s4) + ",");
		sb.append(Float.parseFloat(s5) + ",");
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

	public String BuildSql3(List<String> list) {
		StringBuffer sb = new StringBuffer("INSERT INTO QAS_D_ROOMS   ( ");
		sb.append(" ID,NUMOFREADINGROOMSEAT,NUMOFCOMPUTER,NUMOFTEACHINGCOMPUTER,NUMOFTEACHINGPAD,NUMOFPUBLICCOMPUTERROOM," +
				"NUMOFSPECIALCOMPUTERROOM,NUMOFCLASSROOM,NUMOFMEDIAROOM,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME," +
				"TENANTID,STORAGETIME)");
		sb.append(" VALUES (");
		/**
		 * INSERT INTO QAS_D_ROOMS (
		 * ID,NUMOFREADINGROOMSEAT,NUMOFCOMPUTER,NUMOFTEACHINGCOMPUTER
		 * ,NUMOFTEACHINGPAD
		 * ,NUMOFPUBLICCOMPUTERROOM,NUMOFSPECIALCOMPUTERROOM,NUMOFCLASSROOM
		 * ,NUMOFMEDIAROOM
		 * ,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID
		 * ,STORAGETIME) VALUES (
		 * #{id},#{numofreadingroomseat},#{numofcomputer},
		 * #{numofteachingcomputer
		 * },#{numofteachingpad},#{numofpubliccomputerroom
		 * },#{numofspecialcomputerroom
		 * },#{numofclassroom},#{numofmediaroom},#{status
		 * },#{createdby},#{createdtime
		 * },#{updatedby},#{updatedtime},#{tenantid},#{storagetime} )
		 */

		String s1 = list.get(0), s2 = list.get(1), s3 = list.get(2), s4 = list
				.get(3), s5 = list.get(4), s6 = list.get(5), s7 = list.get(6), s8 = list
				.get(7);
		String id = UUID.randomUUID().toString();
		sb.append("'" + id + "',");
		sb.append(Float.parseFloat(s1) + ",");
		sb.append(Float.parseFloat(s2) + ",");
		sb.append(Float.parseFloat(s3) + ",");
		sb.append(Float.parseFloat(s4) + ",");
		sb.append(Float.parseFloat(s5) + ",");
		sb.append(Float.parseFloat(s6) + ",");
		sb.append(Float.parseFloat(s7) + ",");
		sb.append(Float.parseFloat(s8) + ",");
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
		StringBuffer sb = new StringBuffer(
				"INSERT INTO QAS_D_INFORMATIONCONSTRUCTION   ( ");
		sb.append(" ID,EXPORTBANDWIDTH,CAMPUSNETWORK,NETWORKINFORMATIONPOINT,ACCOUNTOFMIS,EMAILUSERCOUNT," +
				"ONLINECOURSECOUNT,TOTALDIGITALRESOURCE,ELECTRONICBOOK,ALLINONECARDUSAGE,WIRELESSCOVERAGE,STATUS," +
				"CREATEDBY,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME)");
		sb.append(" VALUES (");
		/**
		 * INSERT INTO QAS_D_INFORMATIONCONSTRUCTION (
		 * ID,EXPORTBANDWIDTH,CAMPUSNETWORK
		 * ,NETWORKINFORMATIONPOINT,ACCOUNTOFMIS,
		 * EMAILUSERCOUNT,ONLINECOURSECOUNT
		 * ,TOTALDIGITALRESOURCE,ELECTRONICBOOK,MULTIMEDIACAPACITY
		 * ,NATIONALLEVELRESOURCE
		 * ,PROVINCIALRESOURCE,ALLINONECARDUSAGE,WIRELESSCOVERAGE
		 * ,STATUS,CREATEDBY
		 * ,CREATEDTIME,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME) VALUES (
		 * #{id
		 * },#{exportbandwidth},#{campusnetwork},#{networkinformationpoint},#
		 * {accountofmis
		 * },#{emailusercount},#{onlinecoursecount},#{totaldigitalresource
		 * },#{electronicbook},#{multimediacapacity},#{nationallevelresource},#{
		 * provincialresource
		 * },#{allinonecardusage},#{wirelesscoverage},#{status}
		 * ,#{createdby},#{createdtime
		 * },#{updatedby},#{updatedtime},#{tenantid},#{storagetime} )
		 */

		String s1 = list.get(0), s2 = list.get(1), s3 = list.get(4), s4 = list
				.get(5), s5 = list.get(6), s6 = list.get(7), s7 = list.get(8), s8 = list
				.get(9), s9 = list.get(2), s10 = list.get(3);
		String id = UUID.randomUUID().toString();
		sb.append("'" + id + "',");
		sb.append(Float.parseFloat(s1) + ",");
		sb.append(Float.parseFloat(s2) + ",");
		sb.append(Float.parseFloat(s3) + ",");
		sb.append(Float.parseFloat(s4) + ",");
		sb.append(Float.parseFloat(s5) + ",");
		sb.append(Float.parseFloat(s6) + ",");
		sb.append(Float.parseFloat(s7) + ",");
		sb.append(Float.parseFloat(s8) + ",");
		sb.append("'" + s9 + "',");
		sb.append("'" + s10 + "',");
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
		StringBuffer sb = new StringBuffer(
				"INSERT INTO QAS_D_MANAGEMENTINFORMATIONSYSTEM   ( ");
		sb.append(" ID,TYPE,SYSTEMNAME,SOURCE,DEVELOPMENTUNIT,STATUS,CREATEDBY,CREATEDTIME,UPDATEDBY," +
				"UPDATEDTIME,TENANTID,STORAGETIME)");
		sb.append(" VALUES (");
		/**
		 * INSERT INTO QAS_D_MANAGEMENTINFORMATIONSYSTEM (
		 * ID,TYPE,SYSTEMNAME,SOURCE
		 * ,DEVELOPMENTUNIT,STATUS,CREATEDBY,CREATEDTIME
		 * ,UPDATEDBY,UPDATEDTIME,TENANTID,STORAGETIME) VALUES (
		 * #{id},#{type},#{
		 * systemname},#{source},#{developmentunit},#{status},#{createdby
		 * },#{createdtime
		 * },#{updatedby},#{updatedtime},#{tenantid},#{storagetime} )
		 */

		String s1 = list.get(1), s2 = list.get(2), s3 = list.get(3), s4 = list
				.get(4);
		String id = UUID.randomUUID().toString();
		sb.append("'" + id + "',");
		sb.append("'" + s1 + "',");
		sb.append("'" + s2 + "',");
		sb.append("'" + s3 + "',");
		sb.append("'" + s4 + "',");
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
		String table = list.get(list.size() - 1);
		if ("1".equals(table)) {
			sqls.add(BuildSql1(list));
		} else if ("2".equals(table)) {
			sqls.add(BuildSql2(list));
		} else if ("3".equals(table)) {
			sqls.add(BuildSql3(list));
		} else if ("4".equals(table)) {
			sqls.add(BuildSql4(list));
		} else if ("5".equals(table)) {
			sqls.add(BuildSql5(list));
		}
		return sqls;
	}

}
