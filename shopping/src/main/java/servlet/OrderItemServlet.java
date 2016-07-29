package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Serivce.OrderItemService;
import Serivce.OrderService;
import po.OrderItem;
import utils.PageBean;

public class OrderItemServlet extends BaseServlet{
	private OrderItemService odItemService = new OrderItemService();
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
	public String findByOid(HttpServletRequest req, HttpServletResponse resp)
		throws SQLException, IOException, ServletException{
		int pc = getPc(req);
		String url = getUrl(req);
		int o_id = Integer.valueOf(req.getParameter("oId"));
		PageBean<OrderItem> pb = odItemService.findByO_id(o_id, pc);
		pb.setUrl(url);
		req.setAttribute("pb", pb);
		req.setAttribute("o_id", o_id);
		return "f:/User/orderItem.jsp";
	}
	
	public String eidtOrderItem(HttpServletRequest req, HttpServletResponse resp)
			throws SQLException, IOException, ServletException{
			int quantity = Integer.valueOf(req.getParameter("quantity"));
			int orderItem_id = Integer.valueOf(req.getParameter("orderItem_id"));
			int o_id = Integer.valueOf(req.getParameter("oId"));
			OrderItem orderItem = new OrderItem();
			orderItem.setG_quantity(quantity);
			orderItem.setOrderitem_id(orderItem_id);
			int result = odItemService.updateOrderItem(orderItem);
			orderService.editTotal(o_id);
			req.setAttribute("o_id", o_id);
			return findByOid(req, resp);
		}
	
	public String deleteOrderItem(HttpServletRequest req, HttpServletResponse resp)
			throws SQLException, IOException, ServletException{
			int orderItem_id = Integer.valueOf(req.getParameter("orderItem_id"));
			int result = odItemService.deleteOrderItem(orderItem_id);
			int o_id = Integer.valueOf(req.getParameter("oId"));
			orderService.editTotal(o_id);
			req.setAttribute("o_id", o_id);
			return findByOid(req, resp);
	}
}
