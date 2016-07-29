package test;

import org.junit.Test;

import carditemDao.CardItemDao;
import po.CardItem;
import utils.PageBean;

public class TestCardItem {
	private CardItemDao cardItemDao = new CardItemDao();
	
	@Test
	public void testMyCard(){
		/*
		PageBean<CardItem> pb = cardItemDao.findByU_id(2, 1);
		System.out.println(pb.getTr());
		System.out.println(pb.getBeanList());*/
	}
}
