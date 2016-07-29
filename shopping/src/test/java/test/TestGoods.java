package test;

import java.util.List;

import org.junit.Test;

import Serivce.GoodService;
import goodDao.GoodDao;
import po.Goods;
import utils.Condition;
import utils.PageBean;

public class TestGoods {
	private GoodDao goodDao = new GoodDao();
	private GoodService GoodService = new GoodService();
/*
	@Test
	public void testGoods(){
		GoodDao goodDao = new GoodDao();
		Goods good = goodDao.findByG_id(2);
		System.out.println(good.getgName());
	}*/
	
//	@Test
//	public void testFindAll(){
//		GoodDao goodDao = new GoodDao();
//		PageBean<Goods>  good = goodDao.findAll(1);
//		System.out.println(good.getBeanList().get(0).getgName());
//	}
	
/*	@Test
	public void testFingByc_id(){
		GoodDao goodDao = new GoodDao();
		List<Goods>  good = goodDao.findByC_id(1);
		System.out.println(good);
	}*/
/*	
	@Test
	public void testFindByName(){
		String name = "小火车";
		Goods good = GoodService.findByName(name);
		System.out.println(good.getgQuantity());
	}*/
	@Test
	public void findByCondition(){
		Condition condition = new Condition();
		condition.setCategory(1);
		condition.setMin(0);
		condition.setMax(110);
		PageBean<Goods> result = goodDao.findByCondition(condition, 1);
		System.out.println(result.getTr());
		System.out.println(result.getBeanList().size());
		System.out.println(result.getBeanList().get(0).getgName());
	}
}
