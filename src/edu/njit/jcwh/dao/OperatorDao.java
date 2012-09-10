package edu.njit.jcwh.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import edu.njit.jcwh.pojo.Engineer;
import edu.njit.jcwh.pojo.Operator;
import edu.njit.jcwh.util.HSF;
import edu.njit.jcwh.util.PageUtil;

public class OperatorDao {
	
	/**
	 * 分页查询操作员
	 * @param page 分页信息
	 * @return 操作员列表
	 */
	public List<Operator> queryAll(PageUtil page){
		int pageNum = page.getPageNum();
		int pageNo = page.getPageNo();
		int firstResultIndex = pageNum * (pageNo - 1);
		Session session = HSF.getSession();
		Criteria cr = session.createCriteria(Operator.class).add(Restrictions.eq("deleted", false));
		cr.setFirstResult(firstResultIndex);
		cr.setMaxResults(pageNum);
		List<Operator> list = cr.list();
		return list;
	}
	
	/**
	 * 查询所有的操作员
	 * @return 所有操作员列表
	 */
	public List<Operator> queryAll(){
		Session session = HSF.getSession();
		Criteria cr = session.createCriteria(Operator.class).add(Restrictions.eq("deleted", false));
		List<Operator> list = cr.list();
		return list;
	}
	
	/**
	 * 计算Operator的数量
	 * @param page 存储信息的介质
	 */
	public void calCount(PageUtil page) {
		Session session = HSF.getSession();
		Transaction tr = session.beginTransaction();
		Criteria cr = session.createCriteria(Operator.class).add(
				Restrictions.eq("deleted", false));
		List<Operator> list = cr.list();
		tr.commit();
		int count = list.size();
		int pageNum = page.getPageNum();
		int pageCount = (count % pageNum == 0) ? count / pageNum
				: count / pageNum + 1;
		page.setAllPage(pageCount);
		page.setAllRecord(count);
	}
	/**
	 * 按名字程序操作员
	 * @param name 操作员名称
	 * @return 查询到的操作
	 */
	public Operator queryOperatorByName(String name){
		Session session = HSF.getSession();
		List list = session.createCriteria(Operator.class).add(Restrictions.eq("name", name)).list();
		return (Operator) list.get(0);
	}
	
	public int addOperator(Operator operator){
		Session session = HSF.getSession();
		Transaction tr = session.beginTransaction();
		Integer ret = (Integer) session.save(operator); 
		tr.commit();
		if(ret==null){
			ret = 0;
		}
		return ret;
	}
	/**
	 * 根据id查询操作员
	 * @param id
	 * @return 操作员
	 */
	public Operator queryById(int id) {
		Session session = HSF.getSession();
		session.clear();
		Transaction tr = session.beginTransaction();
		Operator operator = (Operator) session.get(Operator.class, id);
		tr.commit();
		return operator;
	}
	/**
	 * 更新操作员信息
	 * @param operator
	 */
	public void update(Operator operator) {
		Session session = HSF.getSession();
		session.clear();
		Transaction tr = session.beginTransaction();
		session.update(operator); 
		session.flush();
		session.clear();
		tr.commit();
	}

	public void deleteById(int id) {
		Session session = HSF.getSession();
		session.clear();
		Operator operator = queryById(id);
		operator.setDeleted(true);
		Transaction tr = session.beginTransaction();
		session.update(operator); 
		session.flush();
		session.clear();
		tr.commit();
	}
	
	
}
