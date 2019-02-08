package com.deceen.data.poi.main;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.deceen.data.poi.util.DbUtil;

public abstract class Common {

	protected Set<String> set = new HashSet<String>();

	public void batchInsert(List<List<String>> list) throws SQLException {
		int i = 1;
		for (List<String> list2 : list) {
			List<String> sqls = BuildSqlList(list2);
			for (String sql : sqls) {
				if (StringUtils.isNotEmpty(sql)) {
					excuteSql(sql);
					System.out.println("--------" + (i++) + "----------");
				}
			}
		}
		set.clear();
		DbUtil.instance.commit();
	}

	public abstract List<String> BuildSqlList(List<String> list);

	public boolean excuteSql(String sql) throws SQLException {
		Statement statement = DbUtil.instance.getConnectionStatement();
		System.out.println(sql);
		return statement.execute(sql);
	}
	
}
