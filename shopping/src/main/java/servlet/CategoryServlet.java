package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Serivce.CategoryService;
import po.Category;

public class CategoryServlet extends BaseServlet {
		CategoryService cService = new CategoryService();
	
	public String findAll(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException, SQLException{
		List<Category> result = cService.findAll();
		req.setAttribute("category", result);
		return "f:/User/gj.jsp";
	}
}
