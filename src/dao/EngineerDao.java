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
	 * ��ҳ��ѯ����ʦ
	 * @param page ��ҳ��Ϣ
	 * @return ����ʦ�б�
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
	 * ��ѯ���еĹ���ʦ
	 * @return ���й���ʦ�б�
	 */
	public List<Engineer> queryAll(){
		Session session = HSF.getSession();
		Criteria cr = session.createCriteria(Engineer.class).add(Restrictions.eq("deleted", false));
		List<Engineer> list = cr.list();
		return list;
		
	}
	
	/**
	 * ����Engineer������
	 * @param page �洢��Ϣ�Ľ���
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
	 * ���չ���ʦ���������ҹ���ʦ
	 * @param name ����ʦ����
	 * @return ��ѯ���Ĺ���ʦ
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
