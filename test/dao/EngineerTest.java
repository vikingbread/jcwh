package dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import edu.njit.jcwh.dao.EngineerDao;
import edu.njit.jcwh.util.HSF;
import edu.njit.jcwh.util.PageUtil;

public class EngineerTest {
	@Test
	public void getOperators(){
		Session session = HSF.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Engineer");
		List<edu.njit.jcwh.pojo.Engineer> list = query.list();
		for (edu.njit.jcwh.pojo.Engineer engineer : list) {
			System.out.println(engineer);
		}
		transaction.commit();
	}
	@Test
	public void queryAll(){
		List<edu.njit.jcwh.pojo.Engineer> list = new EngineerDao().queryAll(new PageUtil());
		for (edu.njit.jcwh.pojo.Engineer engineer : list) {
			System.out.println(engineer);
		}
	}
}
