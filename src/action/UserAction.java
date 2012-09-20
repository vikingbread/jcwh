package edu.njit.jcwh.action;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.njit.jcwh.dao.LoginRecordDao;
import edu.njit.jcwh.dao.UserDao;
import edu.njit.jcwh.pojo.LoginRecord;
import edu.njit.jcwh.pojo.User;
/**
 * 
 * @author Viking
 *ÓÃ»§Action
 */
public class UserAction extends ActionSupport{
	private User user = new User();
	private UserDao userDao = new UserDao();
	
	public String login(){
		System.out.println("action login");
		User ret = userDao.checkUser(user);
		if(ret != null){
			String thisIp = ServletActionContext.getRequest().getRemoteHost();
			String lastIp = ret.getThisIp();
			ret.setLastIp(lastIp);
			ret.setThisIp(thisIp);
			int id = userDao.update(ret);
			ret = userDao.queryById(id);
			LoginRecord record = new LoginRecord();
			record.setIp(thisIp);
			record.setLoginTime(new Timestamp(new Date().getTime()));
			record.setUser(ret);
			new LoginRecordDao().save(record);
			ActionContext.getContext().getSession().put("user", ret);
			return "login";
			
		}
		return INPUT;
	}
	
	public String quit(){
		ActionContext.getContext().getSession().remove("user");
		return "quit";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
