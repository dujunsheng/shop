package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Serivce.OrderService;
import po.Order;
import po.User;
import utils.CommonUtils;
import utils.PageBean;

public class OrderServlet extends BaseServlet {
	private OrderService orderService = new OrderService();
	
	private int getPc(HttpServletRequest req){
		int pc = 1;
		String param = req.getParameter("pc");
		if(param != null && !param.trim().isEmpty()){
			pc = Integer.valueOf(param);
		}
		return pc;
	}
	
	private String getUrl(HttpServletRequest req){
		String url = req.getRequestURL() + "?" + req.getQueryString();
		int index = url.lastIndexOf("&pc=");
		if(index != -1){
			url = url.substring(0, index);
		}
		return url;
	}
	
	public String myOrder(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException , IOException, SQLException{
		int pc = getPc(req);
		String url = getUrl(req);
		User user = (User) req.getSession().getAttribute("sessionUser");	
		PageBean<Order> pb = orderService.findByU_id(user.getU_id(), pc);
		pb.setUrl(req.getContextPath()+"/OrderServlet?method=myOrder");
		req.setAttribute("pb", pb);
		return "f:/User/order.jsp";
	}
	
	public String addOrder(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException , IOException, SQLException{
		Order order = CommonUtils.toBean(req.getParameterMap(), Order.class);
		User user = (User) req.getSession().getAttribute("sessionUser");
		order.setuId(user.getU_id());
		int result = orderService.addOrder(order);
		return myOrder(req, resp);
	}
	
	public String deleteOrder(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException , IOException, SQLException{
		int o_id = Integer.valueOf(req.getParameter("Oid"));
		int result = orderService.deleteOrder(o_id);
		return myOrder(req, resp);
	}
	
	public String findByO_id(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException , IOException, SQLException{
		int o_id = Integer.valueOf(req.getParameter("Oid"));
		Order order = orderService.findByO_id(o_id);
		req.setAttribute("order", order);
		return "f:/User/updateOrder.jsp";
	}
	
	public String updateOrderByO_id(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException , IOException, SQLException{
		Order order = CommonUtils.toBean(req.getParameterMap(), Order.class);
		int result = orderService.updateByPrimaryKeySelective(order);
		return myOrder(req, resp);
	}
}
