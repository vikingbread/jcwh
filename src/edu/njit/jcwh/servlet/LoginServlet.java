package edu.njit.jcwh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import edu.njit.jcwh.dao.UserDao;
import edu.njit.jcwh.pojo.User;

public class LoginServlet extends BaseServlet {
	@Override
	public void doWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		System.out.println("login");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		boolean ret = (new UserDao().checkUser(user)!=null);//判断用户查询的返回值是否为空
		JSONObject jsonObj = JSONObject.fromObject("{}");
		jsonObj.put("ret", ret);
		if (ret) {			
			response.getWriter().print(jsonObj.toString());
		} else {
			response.getWriter().print(jsonObj.toString());
		}
	}

}
