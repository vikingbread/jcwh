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
 * ������  ����δ����µ�¼��������ת����½����
 */
public class AuthFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
	FilterChain chain) throws IOException, ServletException {
		
	    HttpServletRequest hsr=(HttpServletRequest)req;//��ServletRequest �Ķ���reqת����HttpServletRequset ����hsr 
	   String requestURI = hsr.getRequestURI();
	   if(requestURI.indexOf("login.jsp")!=-1
			   ||requestURI.indexOf("Login")!=-1
			   ||requestURI.indexOf("css")!=-1
			   ||requestURI.indexOf("js")!=-1
			   ||requestURI.indexOf("ExcpReport")!=-1
			   ||requestURI.indexOf("UserAction")!=-1 ){//URI����login��������
		   
		   chain.doFilter(req, resp);
	    	return;
	    }
	   
	    HttpServletResponse hrp=(HttpServletResponse)resp;
		HttpSession session=hsr.getSession();
		
		//����ҳ������ǳɹ���¼�ٷ��ʹ���ҳ�棬��ֱ�ӷ��У���û�о����ɹ���¼�ͷ��ʵĻ������ȼ�¼��Ҫ�����ҳ��URI����ת����½����
		
		if(session.getAttribute("user")==null){
			String uri = requestURI;
			session.setAttribute("uri",uri);
			String loginPath=hsr.getContextPath()+"/login.jsp";
			hrp.sendRedirect(loginPath);
		}else{
			 chain.doFilter(req, resp);// ����û�����Ϊ�������
			 
		}
     }
	

	public void init(FilterConfig config) throws ServletException {

	}

}
