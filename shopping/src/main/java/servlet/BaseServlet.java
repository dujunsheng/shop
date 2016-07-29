package servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import utils.MyException;


public class BaseServlet extends HttpServlet {
	/**
	 * BaseServlet用来作为其它Servlet的父类
	 * 
	 * @author qdmmy6
	 * 
	 *         一个类多个请求处理方法，每个请求处理方法的原型与service相同！ 原型 = 返回值类型 + 方法名称 + 参数列表
	 */
		@Override
		public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
			String methodName = request.getParameter("method");
			Method method = null;
			try{
			method = this.getClass().getMethod(methodName,
					 HttpServletRequest.class, HttpServletResponse.class);
			}catch(Exception e){
				//跳转到错误提示页面
				request.setAttribute("msg", "调用的方法：" + methodName + "不存在");
				request.getRequestDispatcher("/User/msg.jsp").forward(request, response);
				e.printStackTrace();
			}
			
			try{
				String result = (String)method.invoke(this, request, response);
				//System.out.println(result);
				if(result !=null && !result.trim().isEmpty())
				{
					String[] strs = result.split(":");
					if(strs[0].equals("f")){
						request.getRequestDispatcher(strs[1]).forward(request, response);
					}else{
						//System.out.println(request.getContextPath() + strs[1]);
						response.sendRedirect(request.getContextPath() + strs[1]);
					}
				} 
			} catch(Exception e){
				//跳转到错误提示页面，输出错误信息
				if(e instanceof MyException){
					request.setAttribute("msg", e.getMessage());
				}else if((e.getCause() != null && e.getCause() instanceof MyException)){
					request.setAttribute("msg", e.getCause().getMessage());
				}else{
					StringBuffer sb=new StringBuffer();
					for(int i=0;i<e.getStackTrace().length;i++){
						sb.append(e.getStackTrace()[i]+"\n");
					}
					request.setAttribute("msg","系统级异常，请与系统管理员联系!\n"+sb.toString());
				}
				request.getRequestDispatcher("/User/msg.jsp").forward(request, response);
				e.printStackTrace();
			}
		}
}
