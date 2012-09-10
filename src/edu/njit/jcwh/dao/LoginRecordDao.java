package edu.njit.jcwh.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import edu.njit.jcwh.pojo.LoginRecord;
import edu.njit.jcwh.pojo.Operator;
import edu.njit.jcwh.util.HSF;
import edu.njit.jcwh.util.PageUtil;

/**
 * @author Viking
 * 登陆记录 记录Dao
 *
 */
public class LoginRecordDao {
	/**
	 * 保存登陆记录
	 * @param loginRecord 需要保存的记录
	 */
	public void save(LoginRecord loginRecord){
		Session session = HSF.getSession();
		session.clear();
		Transaction tr = session.beginTransaction();
		session.save(loginRecord); 
		tr.commit();
	}
	/**
	 * 登陆记录查询
	 * @param page  分页工具
	 * @return      封装好的记录表
	 */
	public List<LoginRecord> queryAll(PageUtil page){
		int pageNum = page.getPageNum();
		int pageNo = page.getPageNo();
		int firstResultIndex = pageNum * (pageNo - 1);
		Session session = HSF.getSession();
		Criteria cr = session.createCriteria(LoginRecord.class).add(Restrictions.eq("deleted", false)).addOrder(Order.desc("loginTime"));
		cr.setFirstResult(firstResultIndex);
		cr.setMaxResults(pageNum);
		List<LoginRecord> list = cr.list();
		return list;
	}
	
	/**
	 * 查询记录数(公用方法)
	 * @param page 分页工具
	 */
	 public void calCount(PageUtil page) {
		Session session = HSF.getSession();
		Transaction tr = session.beginTransaction();
		Criteria cr = session.createCriteria(LoginRecord.class).add(
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
	
}
