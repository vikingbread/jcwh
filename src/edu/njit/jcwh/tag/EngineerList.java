package edu.njit.jcwh.tag;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import edu.njit.jcwh.dao.EngineerDao;
import edu.njit.jcwh.pojo.Engineer;

public class EngineerList extends SimpleTagSupport {

	public void doTag() throws JspException, IOException {
		//��ȡjsp�����������
		JspContext context = this.getJspContext();
		//��jspcontext��������ǿת��PageContext
		PageContext pageContext = (PageContext)context;
		EngineerDao dao = new EngineerDao();
		List<Engineer> list = dao.queryAll();
        pageContext.setAttribute("engineer",list);
	}
}