package com.hekm.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class jdbcUtils {

	private static ComboPooledDataSource ds;//����һ������Դ
	static{
		//����ֻ�ᴴ��һ��
		 ds = new ComboPooledDataSource("mysql");
	} 
	
	/*
	 * �ӳ��л�ȡһ������
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
	 * ����һ������Դ
	 * */
	public static DataSource getDataSource(){
		return ds;
	}
	
	/*
	 * �ͷ�����
	 * @param rs �����
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
				s.close();//con�������ӳ���
			} catch (SQLException e) {
				e.printStackTrace();
			}
			con = null;
		}
		
	}
	
	
	
}
