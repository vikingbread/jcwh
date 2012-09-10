package edu.njit.jcwh.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author Viking
 * 过滤器  拦截未情况下登录的请求，跳转到登陆界面
 */
public class AuthFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
	FilterChain chain) throws IOException, ServletException {
		
	    HttpServletRequest hsr=(HttpServletRequest)req;//将ServletRequest 的对象req转换成HttpServletRequset 对象hsr 
	   String requestURI = hsr.getRequestURI();
	   if(requestURI.indexOf("login.jsp")!=-1
			   ||requestURI.indexOf("Login")!=-1
			   ||requestURI.indexOf("css")!=-1
			   ||requestURI.indexOf("js")!=-1
			   ||requestURI.indexOf("ExcpReport")!=-1
			   ||requestURI.indexOf("UserAction")!=-1 ){//URI包含login都不过滤
		   
		   chain.doFilter(req, resp);
	    	return;
	    }
	   
	    HttpServletResponse hrp=(HttpServletResponse)resp;
		HttpSession session=hsr.getSession();
		
		//其他页面如果是成功登录再访问过的页面，则直接放行，若没有经过成功登录就访问的话，则先记录下要请求的页面URI，跳转到登陆界面
		
		if(session.getAttribute("user")==null){
			String uri = requestURI;
			session.setAttribute("uri",uri);
			String loginPath=hsr.getContextPath()+"/login.jsp";
			hrp.sendRedirect(loginPath);
		}else{
			 chain.doFilter(req, resp);// 如果用户名不为空则放行
			 
		}
     }
	

	public void init(FilterConfig config) throws ServletException {

	}

}
