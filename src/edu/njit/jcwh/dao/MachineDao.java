package edu.njit.jcwh.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import edu.njit.jcwh.pojo.Machine;
import edu.njit.jcwh.util.HSF;
import edu.njit.jcwh.util.PageUtil;
/**
 * 
 * @author Viking
 *
 *����Dao
 */
public class MachineDao {

	public List<Machine> queryAll(PageUtil page) {
		int pageNum = page.getPageNum();
		int pageNo = page.getPageNo();
		int firstResultIndex = pageNum * (pageNo - 1);
		Session session = HSF.getSession();
	//	session.clear();
		Transaction tr = session.beginTransaction();
		Criteria cr = session.createCriteria(Machine.class).add(
				Restrictions.eq("deleted", false));
		cr.setFirstResult(firstResultIndex);
		cr.setMaxResults(pageNum);
		List<Machine> list = cr.list();
		tr.commit();
		return list;
	}

	/**
	 * ����Product������
	 * 
	 * @param page
	 *            �洢��Ϣ�Ľ���
	 */
	public void calCount(PageUtil page) {
		Session session = HSF.getSession();
		Transaction tr = session.beginTransaction();
		Criteria cr = session.createCriteria(Machine.class).add(
				Restrictions.eq("deleted", false));
		List<Machine> list = cr.list();
		tr.commit();
		int count = list.size();
		int pageNum = page.getPageNum();
		int pageCount = (count % pageNum == 0) ? count / pageNum : count
				/ pageNum + 1;
		page.setAllPage(pageCount);
		page.setAllRecord(count);
	}

	public int addMachine(Machine machine) {
		Session session = HSF.getSession();
		Transaction tr = session.beginTransaction();
		Integer ret = (Integer) session.save(machine);
		tr.commit();
		if (ret == null) {
			return 0;
		}
		return ret;
	}
	/**
	 * ���ݳ����id��ѯmachine
	 * @return ��ѯ����machine
	 */
	public Machine queryById(int id) {
		Session session = HSF.getSession();
		Transaction tr = session.beginTransaction();
		Machine machine = (Machine) session.get(Machine.class, id);
		tr.commit();
		return machine;
	}
	/**����ĳ̨����
	 * 
	 * @param machine
	 */
	public void update(Machine machine) {
		Session session = HSF.getSession();
		session.clear();
		Transaction tr = session.beginTransaction();
		session.update(machine); 
		session.flush();
		session.clear();
		tr.commit();
	}

	public void deleteById(int id) {
		Session session = HSF.getSession();
		Machine machine = queryById(id);
		Transaction tr = session.beginTransaction();
		machine.setDeleted(true);
		session.update(machine); 
		session.flush();
		tr.commit();
	}
}
