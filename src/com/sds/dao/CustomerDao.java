package com.sds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sds.frame.Dao;
import com.sds.frame.SQL;
import com.sds.vo.CustomerVO;
import com.sds.vo.ItemVO;

public class CustomerDao extends Dao<String, CustomerVO> {

	@Override
	public void insert(CustomerVO v, Connection con) throws Exception {
		// Connection을 통해 PreparedStatement 생성
		// sql 쿼리 작성하여 DB에 전송
		// Resource Close (자원 반납)
		PreparedStatement pstmt = null;
		try {// 예외처리 및 자원반납
			pstmt = con.prepareStatement(SQL.insertCustomer);
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getPwd());
			pstmt.setString(3, v.getName());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("");
			throw e;
		} finally {
			close(pstmt);
		}
	}

	@Override
	public void delete(String t, Connection con) throws Exception {
		
	}

	@Override
	public void update(CustomerVO v, Connection con) throws Exception {
		
	}

	@Override
	public CustomerVO select(String t, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CustomerVO customer = null;
		try {// 예외처리 및 자원반납
			pstmt = con.prepareStatement(SQL.getCustomer);
			pstmt.setString(1, t);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				customer = new CustomerVO(rs.getString("id"), rs.getString("pwd"), rs.getString("name"));
			}
		} catch (Exception e) {
			System.out.println("");
			throw e;
		} finally {
			close(rs);
			close(pstmt);
		}
		return customer;
	}

	@Override
	public ArrayList<CustomerVO> select(Connection con) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CustomerVO> list = new ArrayList<>();
		try {// 예외처리 및 자원반납
			pstmt = con.prepareStatement(SQL.listCustomer);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new CustomerVO(
						rs.getString("id"), 
						rs.getString("pwd"), 
						rs.getString("name")));
			}
		} catch (Exception e) {
			System.out.println("");
			throw e;
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

}
