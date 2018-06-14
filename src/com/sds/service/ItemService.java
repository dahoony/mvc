package com.sds.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.sds.dao.ItemDao;
import com.sds.frame.Dao;
import com.sds.frame.Service;
import com.sds.vo.ItemVO;

public class ItemService extends Service<Integer, ItemVO> {
	Dao<String, ItemVO> iDao;

	public ItemService() {
		iDao = new ItemDao();
	}
	
	@Override
	public void register(ItemVO v) throws Exception {
		// 고객 정보가 들어오면 고객 정보에 아이템을 셋팅하고 Dao를 통해 저장 요청을 한다.
		Connection con = null;
		try {// 트랜잭션 처리
			con = getConnection();
			iDao.insert(v, con);
			con.commit();// 다 정상적으로 완료 됬다면 commit을 통해 트랜잭션 수행
		} catch (Exception e) {
			con.rollback();// 비정상적 오류일 때 rollback을 통해 취소
			throw e;// 발생한 Exception을 app으로 던진다.
		} finally {
			close(con);
		}
	}

	@Override
	public void remove(Integer t) throws Exception {

	}

	@Override
	public void modify(ItemVO v) throws Exception {
		
	}

	@Override
	public ItemVO get(Integer t) throws Exception {
		
		return null;
	}

	@Override
	public ArrayList<ItemVO> get() throws Exception {
		return null;
	}

}
