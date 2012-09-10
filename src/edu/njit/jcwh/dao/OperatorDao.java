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
	 * ��ҳ��ѯ����Ա
	 * @param page ��ҳ��Ϣ
	 * @return ����Ա�б�
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
	 * ��ѯ���еĲ���Ա
	 * @return ���в���Ա�б�
	 */
	public List<Operator> queryAll(){
		Session session = HSF.getSession();
		Criteria cr = session.createCriteria(Operator.class).add(Restrictions.eq("deleted", false));
		List<Operator> list = cr.list();
		return list;
	}
	
	/**
	 * ����Operator������
	 * @param page �洢��Ϣ�Ľ���
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
	 * �����ֳ������Ա
	 * @param name ����Ա����
	 * @return ��ѯ���Ĳ���
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
	 * ����id��ѯ����Ա
	 * @param id
	 * @return ����Ա
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
	 * ���²���Ա��Ϣ
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
