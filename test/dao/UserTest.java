package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import edu.njit.jcwh.dao.UserDao;
import edu.njit.jcwh.util.HSF;
import edu.njit.jcwh.util.MD5Util;

public class UserTest {
	@Test
	public void getUser() {
		Session session = HSF.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from User");
		List<edu.njit.jcwh.pojo.User> list = query.list();
		for (edu.njit.jcwh.pojo.User user : list) {
			System.out.println(user.getLoginRecords().size());
		}
		transaction.commit();
	}
	
	@Test
	public void login(){
		edu.njit.jcwh.pojo.User user = new edu.njit.jcwh.pojo.User();
		user.setName("admin");
		user.setPassword("1234");
		Assert.assertEquals(true, new UserDao().checkUser(user));
	}

}
