package com.hekm.sql;
import java.sql.Connection;
import java.sql.Statement;

import com.hekm.utils.jdbcUtils;

public class createTables {
	private static Statement stat = jdbcUtils.getStatement();
	
	public static void main(String args[]){
		String createCategory = "create table category";
	}
}
