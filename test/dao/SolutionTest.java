package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import edu.njit.jcwh.dao.EngineerDao;
import edu.njit.jcwh.dao.SolutionDao;
import edu.njit.jcwh.util.HSF;
import edu.njit.jcwh.util.PageUtil;

public class SolutionTest {
	@Test
	public void getSolution(){
		Session session = HSF.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Solution");
		List<edu.njit.jcwh.pojo.Solution> list = query.list();
		for (edu.njit.jcwh.pojo.Solution solution : list) {
			System.out.println(solution );
		}
		transaction.commit();
	}
	@Test
	public void queryAll(){
		List<edu.njit.jcwh.pojo.Solution> list = new SolutionDao().queryAll(new PageUtil());
		for (edu.njit.jcwh.pojo.Solution solution : list) {
			System.out.println(solution);
		}
	}
}
