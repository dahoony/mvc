package com.sds.app;

import com.sds.frame.Service;
import com.sds.service.CustomerService;
import com.sds.service.ItemService;
import com.sds.vo.CustomerVO;
import com.sds.vo.ItemVO;

public class App {
	public static void main(String[] args) {
		Service<String, CustomerVO> service = new CustomerService();
		Service<Integer, ItemVO> itemService = new ItemService();
		CustomerVO customer = new CustomerVO("id02", "pwd02", "김말숙");
		ItemVO item = new ItemVO("탄띠",2000,"id11");
		// 예외 처리를 Service단이나 Dao단에서 처리를 해버리면 오류가 뭔지 알 수가 없다.
		// 그래서 Service, DAO에서 throws 해줘서 최종적으로 여기서 작업을 해주는 것이 맞다.
		try {
			service.register(customer);
			//itemService.register(item);
			System.out.println("입력 정상");
		} catch (Exception e) {
			System.out.println("입력 실패");
			e.printStackTrace();
		}
		// delete test
		/*try {
			service.remove("id11");
			System.out.println("삭제 정상");
		} catch (Exception e) {
			System.out.println("삭제 실패");
			e.printStackTrace();
		}*/

		/*// update test
		try {
			customer = new CustomerVO("id11","pwd11","박말숙");
			service.modify(customer);
			System.out.println("수정 정상");
		} catch (Exception e) {
			System.out.println("수정 실패");
			e.printStackTrace();
		}*/

	}
}
