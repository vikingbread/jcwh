package edu.njit.jcwh.servlet;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import edu.njit.jcwh.dao.OperatorDao;
import edu.njit.jcwh.pojo.Operator;
import edu.njit.jcwh.util.PageUtil;

public class OperatorInfo extends BaseServlet {

	@Override
	public void doWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nameCode = request.getParameter("name");
		System.out.println(nameCode);
		if(nameCode==null||"".equals(nameCode.trim())){
			return;
		}
		String name = URLDecoder.decode(nameCode,"utf-8").trim();

		System.out.println(name);
		Operator op = new OperatorDao().queryOperatorByName(name);
		JsonConfig config = new JsonConfig();
		config.setJsonPropertyFilter(new PropertyFilter() {
			public boolean apply(Object source, String name, Object value) {
				if (name.equals("products")) {
					return true;
				} else {
					return false;
				}
			}

		});
		JSONObject jsonObj = JSONObject.fromObject(op, config);
		response.getWriter().print(jsonObj.toString());
	}

}
