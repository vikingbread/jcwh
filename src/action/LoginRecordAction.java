package edu.njit.jcwh.action;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import edu.njit.jcwh.dao.LoginRecordDao;
import edu.njit.jcwh.pojo.LoginRecord;
import edu.njit.jcwh.util.PageUtil;

/**
 * @author Viking
 * 登陆Action处理类
 * 转发与登陆有关的请求
 *
 */
public class LoginRecordAction extends ActionSupport {
	
	private PageUtil page = new PageUtil();
	private LoginRecordDao dao = new LoginRecordDao();
	private List<LoginRecord> list;
	
	public String queryAll(){
		dao.calCount(page);
		list = dao.queryAll(page);
		return "queryAll";
	}
	
	//getter & setter ~~~~~~~~~~~~~~~~~~~
	public PageUtil getPage() {
		return page;
	}

	public void setPage(PageUtil page) {
		this.page = page;
	}

	public List<LoginRecord> getList() {
		return list;
	}

	public void setList(List<LoginRecord> list) {
		this.list = list;
	}
	
	
}
