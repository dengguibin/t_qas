package com.deceen.data.poi.main;

import java.util.ArrayList;
import java.util.List;

public class DataInsert extends Common {

	public String BuildSql(List<String> list) {
		StringBuffer sb = new StringBuffer("insert into data_pool ( id");
		char a = 'a';
		for (int i = 0; i < list.size() - 1; i++) {
			sb.append("," + a);
			a++;
		}
		sb.append(") values(");
		for (String str : list) {
			sb.append("'" + str + "',");
		}
		String sql = "";
		sql = sb.toString().substring(0, sb.length() - 1) + ")";
		return sql;
	}

	@Override
	public List<String> BuildSqlList(List<String> list) {
		List<String> sqls = new ArrayList<String>();
		sqls.add(BuildSql(list));
		return sqls;
	}

}
