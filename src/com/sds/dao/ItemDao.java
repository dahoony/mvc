package com.sds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sds.frame.Dao;
import com.sds.frame.SQL;
import com.sds.vo.CustomerVO;
import com.sds.vo.ItemVO;

public class ItemDao extends Dao<String, ItemVO> {

	@Override
	public void insert(ItemVO v, Connection con) throws Exception {
		// Connection을 통해 PreparedStatement 생성
		// sql 쿼리 작성하여 DB에 전송
		// Resource Close (자원 반납)
		PreparedStatement pstmt = null;
		try {// 예외처리 및 자원반납
			pstmt = con.prepareStatement(SQL.insertItem);
			pstmt.setString(1, v.getItemName());
			pstmt.setDouble(2, v.getPrice());
			pstmt.setString(3, v.getId());
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
	public void update(ItemVO v, Connection con) throws Exception {
		
	}

	@Override
	public ItemVO select(String t, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ItemVO item = null;
		try {// 예외처리 및 자원반납
			pstmt = con.prepareStatement(SQL.getCustomerItem);
			pstmt.setString(1, t);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				item = new ItemVO(rs.getInt("item_id"),rs.getString("item_name"), rs.getDouble("price"), rs.getString("id"));
			}
		} catch (Exception e) {
			System.out.println("");
			throw e;
		} finally {
			close(pstmt);
		}
		return item;
	}

	@Override
	public ArrayList<ItemVO> select(Connection con) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ItemVO item = null;
		ArrayList<ItemVO> itemList = null;
		try {// 예외처리 및 자원반납
			itemList = new ArrayList<ItemVO>();
			pstmt = con.prepareStatement(SQL.listItem);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				itemList.add(new ItemVO(rs.getInt("item_id"),rs.getString("item_name"), rs.getDouble("price"), rs.getString("id")));
			}
		} catch (Exception e) {
			System.out.println("");
			throw e;
		} finally {
			close(rs);
			close(pstmt);
		}
		return itemList;
	}
	
	public ArrayList<ItemVO> selectItems(String t,Connection con) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ItemVO> itemList = null;
		try {// 예외처리 및 자원반납
			itemList = new ArrayList<ItemVO>();
			pstmt = con.prepareStatement(SQL.getCustomerItem);
			pstmt.setString(1,t);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				itemList.add(new ItemVO(rs.getInt("item_id"),rs.getString("item_name"), rs.getDouble("price"), rs.getString("id")));
			}
		} catch (Exception e) {
			System.out.println("");
			throw e;
		} finally {
			close(rs);
			close(pstmt);
		}
		return itemList;
	}
	

}
