package servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Serivce.UserService;
import po.User;
import utils.CommonUtils;

public class UserServlet extends BaseServlet {
	private UserService userService = new UserService();
	
	public String login(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		User formUser = CommonUtils.toBean(req.getParameterMap(), User.class);		
		User user = userService.userLoad(formUser);
		if(user != null)
		{
			// 保存用户到session			
			req.getSession().setAttribute("sessionUser", user);		
			return "r:/index.jsp";
		}
		else{
			req.setAttribute("msg", "用户名或密码错误！");
			req.setAttribute("user", formUser);
			return "f:/User/userLoad.jsp";
		}
	}
	
	public String quit(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		req.getSession().invalidate();
		return "r:/index.jsp";
	}
	
	public String regist(HttpServletRequest req, HttpServletResponse resp) 
			throws Exception {
		User formUser = CommonUtils.toBean(req.getParameterMap(), User.class);
		String reInputPass=req.getParameter("reInputPass");
		Map<String,String> errMessMap=checkRegistInfo(formUser,reInputPass);
		if(errMessMap.size()==0){
			// 验证通过，提交服务器，并转发到msg.jsp显示！
			userService.addUser(formUser);	
			req.setAttribute("code", "success");
			req.setAttribute("msg", "注册成功，请等待管理员审核！");
			return "f:/jsps/msg.jsp";
		}else{
			//验证不通过，重回注册页面
			req.setAttribute("form", formUser);
			req.setAttribute("reInputPass", reInputPass);
			req.setAttribute("errors", errMessMap);
			return "f:/";
		}
	}
		
		public String updatePassword(HttpServletRequest req, HttpServletResponse resp) throws Exception {
			User formUser = (User) req.getSession().getAttribute("sessionUser");
			String newPass=req.getParameter("newPassword");
			String oldPass=req.getParameter("oldPassword");
			Map<String,String> errMessMap=new HashMap<String,String>();
			//errors.oldPass
			if( userService.updatePassword(formUser, oldPass, newPass)){
				req.setAttribute("code", "success");
				req.setAttribute("msg", "修改密码成功！");
				return "f:/User/msg.jsp";
			}else{
				req.setAttribute("errors", errMessMap);
				req.setAttribute("newPass",newPass);
				req.setAttribute("oldPass",oldPass);
				req.setAttribute("reInputPass",newPass);
				errMessMap.put("oldPass", "原密码输入错误！");
				return "f:/User/msg.jsp";
			}
		}
		
//		检验新注册用户的信息
		private Map<String,String> checkRegistInfo(User u,String reInputPass) throws Exception{
			Map<String,String> errMessMap=new HashMap<String,String>();
			//1. 登录名校验
			User checkUserName = new User();
			checkUserName.setU_name(u.getU_name());
			List<User> list = userService.findByCondition(checkUserName);
			String u_name = u.getU_name();
			if(u_name == null || u_name.trim().isEmpty()) {
				errMessMap.put("userName", "用户名不能为空！");
			} else if(u_name.length() < 3 || u_name.length() > 20) {
				errMessMap.put("userName", "用户名长度必须在3~20之间！");
			} else if(list != null) {
				errMessMap.put("userName", "用户名已被注册！");
			}
			
			//2. 登录密码校验
			String pass =  u.getU_pw();
			if(pass == null || pass.trim().isEmpty()) {
				errMessMap.put("loginpass", "密码不能为空！");
			} else if(pass.length() < 3 || pass.length() > 20) {
				errMessMap.put("loginpass", "密码长度必须在3~20之间！");
			}
			
			// 3. 确认密码校验
			if(reInputPass == null || reInputPass.trim().isEmpty()) {
				errMessMap.put("reloginpass", "确认密码不能为空！");
			} else if(!reInputPass.equals(pass)) {
				errMessMap.put("reloginpass", "两次输入不一致！");
			}
		
			return errMessMap;	
		}
		
}
