package edu.njit.jcwh.tag;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import edu.njit.jcwh.dao.AlarmRecordDao;
import edu.njit.jcwh.pojo.AlarmRecord;

public class QueryUncheckRecords extends SimpleTagSupport {

	public void doTag() throws JspException, IOException {
		//��ȡjsp�����������
		JspContext context = this.getJspContext();
		//��jspcontext��������ǿת��PageContext
		PageContext pageContext = (PageContext)context;
		AlarmRecordDao dao = new AlarmRecordDao();
		
		List<AlarmRecord> list = dao.queryAllUncheckRecords();
		int count = 0;
		if(list!=null){
			count = list.size();
		}
        pageContext.setAttribute("uncheckRecord",count);
	}
}
