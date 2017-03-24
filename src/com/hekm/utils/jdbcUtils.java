package com.hekm.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class jdbcUtils {

	private static ComboPooledDataSource ds;//定义一个数据源
	static{
		//这样只会创建一次
		 ds = new ComboPooledDataSource("mysql");
	} 
	
	/*
	 * 从池中获取一个连接
	 * @throws SQLException
	 * */
	public static Connection getConnection(){
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Statement getStatement(){
		try {
			return ds.getConnection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * 返回一个数据源
	 * */
	public static DataSource getDataSource(){
		return ds;
	}
	
	/*
	 * 释放连接
	 * @param rs 结果集
	 * @param s  statement
	 * @param con Connection
	 * */
	public static void release(ResultSet rs,Statement s,Connection con){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		
		if(s!=null){
			try {
				s.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			s = null;
		}
		
		if(con != null){
			try {
				s.close();//con还在连接池中
			} catch (SQLException e) {
				e.printStackTrace();
			}
			con = null;
		}
		
	}
	
	
	
}
