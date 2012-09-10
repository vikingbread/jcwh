package dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import edu.njit.jcwh.dao.LoginRecordDao;
import edu.njit.jcwh.dao.UserDao;
import edu.njit.jcwh.pojo.LoginRecord;
import edu.njit.jcwh.pojo.User;
import edu.njit.jcwh.util.HSF;
import edu.njit.jcwh.util.MD5Util;
import edu.njit.jcwh.util.PageUtil;

public class LoginRecordTest {
	@Test
	public void getUser() {
		Session session = HSF.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from LoginRecord");
		List<edu.njit.jcwh.pojo.LoginRecord> list = query.list();
		for (edu.njit.jcwh.pojo.LoginRecord record : list) {
			System.out.println(record);
		}
		transaction.commit();
	}
	@Test
	public void save(){
		LoginRecord record = new LoginRecord();
		record.setIp("127.0.0.1");
		record.setLoginTime(new Timestamp(new Date().getTime()));
		User u = new User();
		u.setId(1);
		record.setUser(u);
		new LoginRecordDao().save(record);
	}
	@Test
	public void queryAll(){
		PageUtil page = new PageUtil();
		List<LoginRecord> list = new LoginRecordDao().queryAll(page);
		System.out.println(list);
	}

}
