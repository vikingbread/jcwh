package edu.njit.jcwh.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import edu.njit.jcwh.pojo.Engineer;
import edu.njit.jcwh.util.HSF;
import edu.njit.jcwh.util.PageUtil;

public class EngineerDao {
	
	/**
	 * 分页查询工程师
	 * @param page 分页信息
	 * @return 工程师列表
	 */
	public List<Engineer> queryAll(PageUtil page){
		int pageNum = page.getPageNum();
		int pageNo = page.getPageNo();
		int firstResultIndex = pageNum * (pageNo - 1);
		Session session = HSF.getSession();
		Criteria cr = session.createCriteria(Engineer.class).add(Restrictions.eq("deleted", false));
		cr.setFirstResult(firstResultIndex);
		cr.setMaxResults(pageNum);
		List<Engineer> list = cr.list();
		return list;
		
	}
	
	/**
	 * 查询所有的工程师
	 * @return 所有工程师列表
	 */
	public List<Engineer> queryAll(){
		Session session = HSF.getSession();
		Criteria cr = session.createCriteria(Engineer.class).add(Restrictions.eq("deleted", false));
		List<Engineer> list = cr.list();
		return list;
		
	}
	
	/**
	 * 计算Engineer的数量
	 * @param page 存储信息的介质
	 */
	public void calCount(PageUtil page) {
		Session session = HSF.getSession();
		Transaction tr = session.beginTransaction();
		Criteria cr = session.createCriteria(Engineer.class).add(
				Restrictions.eq("deleted", false));
		List<Engineer> list = cr.list();
		tr.commit();
		int count = list.size();
		int pageNum = page.getPageNum();
		int pageCount = (count % pageNum == 0) ? count / pageNum
				: count / pageNum + 1;
		page.setAllPage(pageCount);
		page.setAllRecord(count);
	}
	/**
	 * 按照工程师的姓名查找工程师
	 * @param name 工程师姓名
	 * @return 查询到的工程师
	 */
	public Engineer queryEngineerByName(String name){
		Session session = HSF.getSession();
		List list = session.createCriteria(Engineer.class).add(Restrictions.eq("name", name)).list();
		if(list==null){
			return null;
		}
		return (Engineer) list.get(0);
	}
	
	public int addEngineer(Engineer engineer){
		Session session = HSF.getSession();
		Transaction tr = session.beginTransaction();
		Integer ret = (Integer) session.save(engineer); 
		tr.commit();
		if(ret==null){
			ret = 0;
		}
		return ret;
	}

	public void update(Engineer engineer) {
		Session session = HSF.getSession();
		session.clear();
		Transaction tr = session.beginTransaction();
		session.update(engineer); 
		session.flush();
		session.clear();
		tr.commit();
	}
	
	public Engineer queryById(int id){
		Session session = HSF.getSession();
		session.clear();
		Transaction tr = session.beginTransaction();
		Engineer engnieer = (Engineer) session.get(Engineer.class, id);
		tr.commit();
		return engnieer;
	}

	public void deletById(int id) {
		Engineer engineer = queryById(id);
		engineer.setDeleted(true);
		Session session = HSF.getSession();
		Transaction tr = session.beginTransaction();
		session.update(engineer); 
		session.flush();
		tr.commit();
	}
}
