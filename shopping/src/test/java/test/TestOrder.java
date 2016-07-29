package test;

import org.junit.Test;

import orderDao.OrderDao;
import po.Order;
import utils.PageBean;

public class TestOrder {

	private OrderDao orderDao = new OrderDao();
/*	@Test
	public void TestFindByU_id(){
		PageBean<Order> pb = orderDao.findByU_id(2, 1);
		System.out.println(pb.getTr());
		System.out.println(pb.getBeanList());
	}*/
}
