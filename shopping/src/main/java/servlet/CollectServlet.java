package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Serivce.CollectionService;
import po.Collection;
import po.User;
import utils.PageBean;

public class CollectServlet extends BaseServlet{
	private CollectionService collectionService = new CollectionService();
	
	private int getPc(HttpServletRequest req){
		int pc = 1;
		String param = req.getParameter("pc");
		if(param != null && !param.trim().isEmpty()){
			try{
				pc = Integer.valueOf(param);
			}catch(RuntimeException e){
				
			}
		}
		return pc;
	}
	
	private String getUrl(HttpServletRequest req){
		String url = req.getRequestURI() + "?" + req.getQueryString();
		int index = url.lastIndexOf("&pc=");
		if(index != -1){
			url = url.substring(0, index);
		}
		return url;
	}
	
	public String myCollect(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException , IOException, SQLException{
		User user = (User) req.getSession().getAttribute("sessionUser");
		int u_id = user.getU_id();
		int pc = getPc(req);
		String url = getUrl(req);
		PageBean<Collection> pb = collectionService.findByU_id(u_id, pc);
		pb.setUrl(req.getContextPath()+"/CollectServlet?method=myCollect");
		req.setAttribute("pb", pb);
		return "f:/User/collect.jsp";
		
	}
	
	public String delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException , IOException, SQLException{
		String g_id = req.getParameter("gId");
		int gId = Integer.valueOf(g_id);
		User user = (User)req.getSession().getAttribute("sessionUser");
		Collection collection = new Collection();
		collection.setG_id(gId);
		collection.setU_id(user.getU_id());
		int result = collectionService.deleteCollection(collection);
		return myCollect(req, resp);
	}
	
	public String add(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException , IOException, SQLException{
		String g_id = req.getParameter("gId");
		int gId = Integer.valueOf(g_id);
		User user = (User)req.getSession().getAttribute("sessionUser");
		Collection collection = new Collection();
		collection.setG_id(gId);
		collection.setU_id(user.getU_id());
		int result = collectionService.addColleciton(collection);
		return myCollect(req, resp);
	}
}
