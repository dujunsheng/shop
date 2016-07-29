package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import categoryDao.CategoryDao;
import po.Category;

public class TestCategory {

	private CategoryDao categoryDao = new CategoryDao();
/*	
	@Test
	public void testAddCategory(){
		Category category = new Category();
//		category.setcId(-1);
		category.setcName("玩具");
		int result = categoryDao.insert(category);
		System.out.println(result);
	}*/
	
	@Test
	public void testFindAll(){
		List<Category> list = new ArrayList<Category>();
		list = categoryDao.findAll();
		System.out.println(list.get(0).getcName());
	}
}
