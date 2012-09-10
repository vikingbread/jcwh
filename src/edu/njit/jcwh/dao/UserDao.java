package edu.njit.jcwh.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import edu.njit.jcwh.pojo.AlarmRecord;
import edu.njit.jcwh.pojo.User;
import edu.njit.jcwh.util.HSF;
import edu.njit.jcwh.util.MD5Util;

public class UserDao {
	/**
	 * 
	 * @param user 传入的user包含用户名和密码两个值
	 * 
	 * @return user 引用 如果用户名和密码存在匹配
	 */
	public User checkUser(User user){
		User ret = null;
		Session session = HSF.getSession();
		session.clear();
		Transaction tr = session.beginTransaction();
		tr.begin();
		Criteria cr = session.createCriteria(User.class)
		.add(Restrictions.eq("name", user.getName()))
		.add(Restrictions.eq("password",MD5Util.md5Encode(user.getPassword())));
		tr.commit();
		List list = cr.list();
		if(list.size()>0){
			ret = (User) list.get(0);
		}
		return ret;
	}
	
	public int update(User user){
		Session session = HSF.getSession();
		Transaction tr = session.beginTransaction();
		Integer ret = (Integer) session.save(user); 
		tr.commit();
		if(ret==null){
			ret = 0;
		}
		return ret;
	}

	public User queryById(int id) {
		Session session = HSF.getSession();
		return (User) session.get(User.class, id);
	}
	
}
