package com.sds.frame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Dao<T,V> {//Generic 활용 T값은 Key, V는 Value
	
	public void close(ResultSet rSet) throws SQLException {
		if(rSet != null) {
			rSet.close();//예외 처리를 throws를 해줘야하나 try catch를 써야하나 고민 잘해서 써줘야할것!!!!!!
		}
	}
	
	public void close(PreparedStatement pstmt) throws SQLException{
		if(pstmt != null) {
			pstmt.close();
		}
	}
	
	//뼈대를 만들어야하는데 잘 생각해야한다.
	public abstract void insert(V v, Connection con) throws Exception;
	public abstract void delete(T t, Connection con)  throws Exception;
	public abstract void update(V v, Connection con) throws Exception;
	public abstract V select(T t, Connection con) throws Exception;
	public abstract ArrayList<V> select(Connection con) throws Exception;
	
}
