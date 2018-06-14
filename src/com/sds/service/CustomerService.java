package com.sds.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.sds.dao.CustomerDao;
import com.sds.dao.ItemDao;
import com.sds.frame.Dao;
import com.sds.frame.Service;
import com.sds.vo.CustomerVO;
import com.sds.vo.ItemVO;

public class CustomerService extends Service<String, CustomerVO> {

	Dao<String, CustomerVO> cDao;
	Dao<String, ItemVO> iDao;

	public CustomerService() {
		cDao = new CustomerDao();
		iDao = new ItemDao();
	}

	@Override
	public void register(CustomerVO v) throws Exception {
		// 고객 정보가 들어오면 고객 정보에 아이템을 셋팅하고 Dao를 통해 저장 요청을 한다.
		Connection con = null;
		try {// 트랜잭션 처리
			con = getConnection();
			cDao.insert(v, con);
			con.commit();// 다 정상적으로 완료 됬다면 commit을 통해 트랜잭션 수행
		} catch (Exception e) {
			con.rollback();// 비정상적 오류일 때 rollback을 통해 취소
			throw e;// 발생한 Exception을 app으로 던진다.
		} finally {
			close(con);
		}
	}

	@Override
	public void remove(String t) throws Exception {
		
	}

	@Override
	public void modify(CustomerVO v) throws Exception {
		
	}

	@Override
	public CustomerVO get(String t) throws Exception {
		CustomerVO customer = null;
		Connection con = null;
		try {// select는 가져오는 역할을 하기 때문에 굳이 commit, rollback을 할 필요가 없다.
			con = getConnection();
			customer = cDao.select(t, con);
			customer.setItem(((ItemDao) iDao).selectItems(t,con));
			//customer.setItem(iDao.select(t, con));
		} catch (Exception e) {
			throw e;// 발생한 Exception을 app으로 던진다.
		} finally {
			close(con);
		}
		return customer;
	}

	@Override
	public ArrayList<CustomerVO> get() throws Exception {
		ArrayList<CustomerVO> list = null;
		Connection con = null;
		try {// 트랜잭션 처리
			con = getConnection();
			list = cDao.select(con);
			
		} catch (Exception e) {
			throw e;// 발생한 Exception을 app으로 던진다.
		} finally {
			close(con);
		}
		return list;
	}

}
