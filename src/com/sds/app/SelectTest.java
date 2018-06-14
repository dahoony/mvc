package com.sds.app;

import java.util.ArrayList;

import com.sds.frame.Service;
import com.sds.service.CustomerService;
import com.sds.service.ItemService;
import com.sds.vo.CustomerVO;
import com.sds.vo.ItemVO;

public class SelectTest {
	public static void main(String[] args) {
		Service<String, CustomerVO> service = new CustomerService();
		Service<Integer,ItemVO> itemService = new ItemService();
		ArrayList<ItemVO> items = new ArrayList<>();
		
		CustomerVO getCustomer = null;
		try {
			getCustomer = service.get("id11");
			System.out.println(getCustomer);
		} catch (Exception e) {
			System.out.println("조회 실패");
			e.printStackTrace();
			
		}
		
	}
}
