package edu.njit.jcwh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.njit.jcwh.util.PageUtil;


/**
 * 所以servlet的基类，封装了所有servlet共有的行为
 * @author autumn
 *
 */
public abstract class BaseServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		changeUTF(request,response);    
		doWork(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		changeUTF(request,response);    
		doWork(request,response);       
	}
	
	/**
	 * 设置字符集
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void changeUTF(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		response.setContentType("text/html,charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	}
	
    /**
     * 各业务实现的方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
	public abstract void doWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException ;
	
}
