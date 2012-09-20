package edu.njit.jcwh.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import edu.njit.jcwh.dao.OperatorDao;
import edu.njit.jcwh.pojo.Operator;

public class OperatorList extends SimpleTagSupport {

	public void doTag() throws JspException, IOException {
		//获取jsp对象的上下文
		JspContext context = this.getJspContext();
		//把jspcontext的上下文强转成PageContext
		PageContext pageContext = (PageContext)context;
		OperatorDao dao = new OperatorDao();
		List<Operator> list = dao.queryAll();
        pageContext.setAttribute("operator",list);
	}
}
