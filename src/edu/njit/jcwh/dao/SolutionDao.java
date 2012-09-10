package edu.njit.jcwh.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import edu.njit.jcwh.pojo.Engineer;
import edu.njit.jcwh.pojo.Solution;
import edu.njit.jcwh.pojo.Solution;
import edu.njit.jcwh.util.HSF;
import edu.njit.jcwh.util.PageUtil;

public class SolutionDao {
	
	public List<Solution> queryAll(PageUtil page){
		int pageNum = page.getPageNum();
		int pageNo = page.getPageNo();
		int firstResultIndex = pageNum * (pageNo - 1);
		Session session = HSF.getSession();
		Criteria cr = session.createCriteria(Solution.class).add(Restrictions.eq("deleted", false));
		cr.setFirstResult(firstResultIndex);
		cr.setMaxResults(pageNum);
		List<Solution> list = cr.list();
		return list;
		
	}
	/**
	 * 计算Solution的数量
	 * @param page 存储信息的介质
	 */
	public void calCount(PageUtil page) {
		Session session = HSF.getSession();
		Transaction tr = session.beginTransaction();
		Criteria cr = session.createCriteria(Solution.class).add(
				Restrictions.eq("deleted", false));
		List<Solution> list = cr.list();
		tr.commit();
		int count = list.size();
		int pageNum = page.getPageNum();
		int pageCount = (count % pageNum == 0) ? count / pageNum
				: count / pageNum + 1;
		page.setAllPage(pageCount);
		page.setAllRecord(count);
	}
	public int addSolution(Solution solution) {
		Session session = HSF.getSession();
		Transaction tr = session.beginTransaction();
		Integer ret = (Integer) session.save(solution); 
		tr.commit();
		if(ret==null){
			ret = 0;
		}
		return ret;
	}
	
	/**
	 * 根据id查询异常
	 * @param id
	 * @return 返回查询到的异常
	 */
	public Solution queryById(int id) {
		Session session = HSF.getSession();
		session.clear();
		Transaction tr = session.beginTransaction();
		Solution solution = (Solution) session.get(Solution.class, id);
		tr.commit();
		return solution;
	}
	/**
	 * 更新操作员信息
	 * @param solution
	 */
	public void update(Solution solution) {
		Session session = HSF.getSession();
		session.clear();
		Transaction tr = session.beginTransaction();
		session.update(solution); 
		session.flush();
		session.clear();
		tr.commit();
	}
	public void deleteById(int id) {
		Session session = HSF.getSession();
		Solution solution = queryById(id);
		solution.setDeleted(true);
		Transaction tr = session.beginTransaction();
		session.update(solution); 
		session.flush();
		tr.commit();
	}
	
	
}
