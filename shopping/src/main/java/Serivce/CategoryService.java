package Serivce;

import java.util.List;

import categoryDao.CategoryDao;
import po.Category;

public class CategoryService {
	CategoryDao categoryDao = new CategoryDao();
	
	public List<Category> findAll(){
		return categoryDao.findAll();
	}
}
