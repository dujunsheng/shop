package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Serivce.CardItemService;
import Serivce.OrderItemService;
import Serivce.OrderService;
import po.CardItem;
import po.OrderItem;
import po.User;
import utils.PageBean;

public class CardServlet extends BaseServlet {
	private CardItemService cardItemService = new CardItemService();
	
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
	
	public String myCard(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException , IOException, SQLException{
		User user = (User) req.getSession().getAttribute("sessionUser");
		int pc = getPc(req);
		String url = getUrl(req);
		PageBean<CardItem> pb = cardItemService.findByU_id(user.getU_id(), pc);
		pb.setUrl(req.getContextPath()+"/CardServlet?method=myCard");
		req.setAttribute("pb", pb);
		return "f:/User/cardItem.jsp";
	} 
	
	public String editCard(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException , IOException, SQLException{
		String cardId= req.getParameter("card_id");
		String gQuantity = req.getParameter("g_quantity");
		int g_quantity = Integer.valueOf(gQuantity);
		int card_id = Integer.valueOf(cardId);
		CardItem cardItem = new CardItem();
		cardItem.setCard_id(card_id);
		cardItem.setG_quantity(g_quantity);
		int result = cardItemService.updateCardItemQuantity(cardItem);
		return myCard(req, resp);
	}
	
	public String deleteCard(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException , IOException, SQLException{
		String cardId = req.getParameter("card_id");
		int card_id = Integer.valueOf(cardId);
		int result = cardItemService.deleteCardItem(card_id);
		return myCard(req, resp);
	}
	
	public String addCard(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException , IOException, SQLException{
		int goodId = Integer.valueOf(req.getParameter("goodId"));
		User user = (User)req.getSession().getAttribute("sessionUser");
		int u_id = user.getU_id();
		int quantity = 1;
		CardItem cardItem = new CardItem();
		cardItem.setG_id(goodId);
		cardItem.setG_quantity(quantity);
		cardItem.setU_id(u_id);
		int result = cardItemService.addCardItem(cardItem);
		return myCard(req, resp);
	}
	
	public String findItem(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException , IOException, SQLException{
		User user = (User) req.getSession().getAttribute("sessionUser");
		int pc = getPc(req);
		int o_id = Integer.valueOf(req.getParameter("orderId"));
		String url = getUrl(req);
		PageBean<CardItem> pb = cardItemService.findByU_id(user.getU_id(), pc);
		pb.setUrl(url);
		req.setAttribute("pb", pb);
		req.setAttribute("orderId", o_id);
		return "f:/User/addItem.jsp";
	}
	
//	将购物车物品添加到订单中并从购物车中删除该商品,并修改订单总金额,并且把该商品添加到商品条目中
	public String addItem(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException , IOException, SQLException{
		User user = (User) req.getSession().getAttribute("sessionUser");
		String g_id = req.getParameter("g_id");
		String g_quantity = req.getParameter("g_quantity");
		int gId = Integer.valueOf(g_id);
		int gQuantity = Integer.valueOf(g_quantity);
		int o_id = Integer.valueOf(req.getParameter("o_id"));
		OrderItem orderItem = new OrderItem();
		orderItem.setG_quantity(gQuantity);
		orderItem.setU_id(user.getU_id());
		orderItem.setG_id(gId);
		orderItem.setOrder_id(o_id);
		float addPrice = Float.parseFloat(req.getParameter("itemPrice"));
		int c_id = Integer.valueOf(req.getParameter("cardId"));
//		System.out.println(addPrice);
		OrderItemService orderItemService = new OrderItemService();
		int result = orderItemService.addOrderItem(orderItem);
		int result2 = cardItemService.deleteCardItem(c_id);
		OrderService orderService = new OrderService();
		orderService.updateTotal(o_id, addPrice);

		return myCard(req, resp);
	}
}
