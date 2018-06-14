package com.sds.frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Service <T,V> {//DB의 Connection을 정의 및 처리
	private String user="db";
	private String password="db";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	
	//T는 argument, V는 return type
	//여기서 jdbc driver를 올린다.
	public Service() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException{
		Connection con = null;
		
		con = DriverManager.getConnection(url, user, password);
		con.setAutoCommit(false);//autocommit 해제
		return con;
	}
	
	public void close(Connection con) throws SQLException{
		if(con != null) {
			con.close();
		}
	}//커넥션 자원반납 함수
	
	public abstract void register(V v) throws Exception;
	public abstract void remove(T t)  throws Exception;
	public abstract void modify(V v) throws Exception;
	public abstract V get(T t) throws Exception;
	public abstract ArrayList<V> get() throws Exception;
	
}
