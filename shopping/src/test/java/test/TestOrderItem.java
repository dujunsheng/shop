package test;

import org.junit.Test;

import orderItemDao.OrderItemDao;
import po.OrderItem;
import utils.PageBean;

public class TestOrderItem {
	private OrderItemDao orderItemDao = new OrderItemDao();
	@Test
	public void testOrderItem(){
		PageBean<OrderItem> pb = orderItemDao.findByOid(24,1);
//		System.out.println(pb.getBeanList());
//		System.out.println(pb.getTr());
	}
	/*
	@Test
	public void findTotal(){
		float t = orderItemDao.findTotal(29);
		System .out.println(t);
	}*/
}
