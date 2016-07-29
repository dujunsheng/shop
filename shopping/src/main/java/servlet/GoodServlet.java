package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Serivce.GoodService;
import po.Goods;
import utils.CommonUtils;
import utils.Condition;
import utils.PageBean;

public class GoodServlet extends BaseServlet {
	private GoodService goodService = new GoodService();
	
	private int getPc(HttpServletRequest req){
		int pc = 1;
		String param = req.getParameter("pc");
//		System.out.println(param);
		if(param != null && !param.trim().isEmpty()){
			try{
				pc = Integer.parseInt(param);
//				System.out.println(pc);
			}catch(RuntimeException e){
				System.out.println("页码不能正常获得");
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
	
	public String findAll(HttpServletRequest req, HttpServletResponse resp)throws
		ServletException, IOException{
		String url = getUrl(req);
		int pc = getPc(req);
		PageBean<Goods> pb = goodService.findAll(pc);
		pb.setUrl(req.getContextPath()+"/GoodServlet?method=findAll");
		req.setAttribute("pb", pb);
		return "f:/User/good.jsp";
		
	}
	
	public String findByCategory(HttpServletRequest req, HttpServletResponse resp)throws
	ServletException, IOException, SQLException{
	String url = getUrl(req);
	int pc = getPc(req);
	PageBean<Goods> pb = goodService.findAll(pc);
	pb.setUrl(req.getContextPath()+"/GoodServlet?method=findByCategory");
	req.setAttribute("pb", pb);
	return "f:/User/good.jsp";
	}
	
	
	public String findByGid(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException{
		String gId = req.getParameter("gId");
		int g_id = Integer.valueOf(gId);
		Goods good = goodService.findByG_id(g_id);
		req.setAttribute("goods", good);
		return "f:/User/goodDesc.jsp";
	}
	
	public String  findByGname(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException{
		Goods good = CommonUtils.toBean(req.getParameterMap(), Goods.class);
		Goods goods = goodService.findByName(new String(good.getgName().getBytes("ISO-8859-1"), "UTF-8"));
		req.setAttribute("goods", goods);
		return "f:/User/goodDesc.jsp";
	}
	
	public String findByCondition(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException{
		int pc = getPc(req);
		String url = getUrl(req);
		Condition condition = CommonUtils.toBean(req.getParameterMap(), Condition.class);
		PageBean<Goods> pb = goodService.findByCondition(condition, pc);
		pb.setUrl(url);
		req.setAttribute("pb", pb);
		return "f:/User/good.jsp";
		
	}
}