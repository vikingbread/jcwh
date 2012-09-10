package edu.njit.jcwh.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import edu.njit.jcwh.pojo.AlarmRecord;
import edu.njit.jcwh.util.HSF;
import edu.njit.jcwh.util.PageUtil;

public class AlarmRecordDao {
	
	/**
	 * ��ҳ�������м�¼��Ϣ
	 * 
	 * @param page
	 *            ��ҳ����
	 * @return list ���������ļ�¼�б�
	 */
	public List<AlarmRecord> queryAll(PageUtil page){
		int pageNum = page.getPageNum();
		int pageNo = page.getPageNo();
		int firstResultIndex = pageNum * (pageNo - 1);
		Session session = HSF.getSession();
		Transaction tr = session.beginTransaction();
		session.clear();
		Criteria cr = session.createCriteria(AlarmRecord.class).add(
				Restrictions.eq("deleted", false)).addOrder(Order.desc("id"));
		
		cr.setFirstResult(firstResultIndex);
		cr.setMaxResults(pageNum);
		List<AlarmRecord> list ;
		list = cr.list();
		tr.commit();
		checkRecords(list);
		return list;
	}
	
	/**
	 * ����id�Ų�ѯ��¼
	 * @param id ��Ҫ��ѯ�ļ�¼��id��
	 * @return ��ѯ���ļ�¼  
	 */
	public AlarmRecord queryById(int id){
		Session session = HSF.getSession();
		return (AlarmRecord) session.get(AlarmRecord.class, id);
	}
	
	/**
	 * ��鴫���б��еļ�¼�Ƿ�Ϊδ�鿴  ��������Ϊ�Բ鿴
	 * �������޸�
	 * @param list ��Ҫ�����б�
	 */
	private void checkRecords(List<AlarmRecord> list) {
		if(list==null){
			return;
		}
		Iterator<AlarmRecord> it = list.iterator();
		AlarmRecord record = null;
		Session session = HSF.getSession();
		Transaction tr = session.beginTransaction();
		while(it.hasNext()){
			record = it.next();
			if(!record.isCheck()){
				record.setCheck(true);
				session.update(record);
			} 
		}
		tr.commit();
	}

	/**
	 * ��ѯ���е�δ�鿴���쳣
	 * @return ����δ�鿴���쳣�б�
	 */
	public List<AlarmRecord> queryAllUncheckRecords(){
		Session session = HSF.getSession();
		Transaction tr = session.beginTransaction();
		Criteria cr = session.createCriteria(AlarmRecord.class).add(
				Restrictions.eq("deleted", false)).addOrder(Order.desc("id")).add(Restrictions.eq("check", false));
		List<AlarmRecord> list ;
		list = cr.list();
		tr.commit();
		return list;
		
	}
	
	/**
	 * ��ҳ��ѯδ�鿴���쳣
	 * @return ����δ�鿴���쳣�б�
	 */
	public List<AlarmRecord> queryAllUncheckRecords(PageUtil page){
		int pageNum = page.getPageNum();
		int pageNo = page.getPageNo();
		int firstResultIndex = pageNum * (pageNo - 1);
		Session session = HSF.getSession();
		Transaction tr = session.beginTransaction();
		Criteria cr = session.createCriteria(AlarmRecord.class).add(
				Restrictions.eq("deleted", false)).addOrder(Order.desc("id")).add(Restrictions.eq("check", false));
		cr.setFirstResult(firstResultIndex);
		cr.setMaxResults(pageNum);
		List<AlarmRecord> list ;
		list = cr.list();
		tr.commit();
		checkRecords(list);
		return list;
	}
	
	/**
	 * �����ڲ�ѯ��¼ ������ͼ
	 * @param page �����װ�õĵ�����������Ϣ
	 * @return ��ѯ�����б�
	 */
	public List<AlarmRecord> queryByDate(PageUtil page){
		Session session = HSF.getSession();
		Transaction tr = session.beginTransaction();
		Criteria cr = session.createCriteria(AlarmRecord.class).add(
				Restrictions.eq("deleted", false)).addOrder(Order.asc("date"));
		Map map = page.getCon();
		if(map!=null){
			for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext();) {
				Map.Entry entry = (Map.Entry) iterator.next();
				cr.add(Restrictions.ge((String)entry.getKey(), entry.getValue()));
			}
		}
		List<AlarmRecord> list ;
		list = cr.list();
		tr.commit();
		return list;
	}
	
	/**
	 * ����һ����¼
	 * @param record ��Ҫ���ӵļ�¼
	 * @return true ���ӳɹ� 
	 */
	public int addRecord(AlarmRecord record){
		Session session = HSF.getSession();
		Transaction tr = session.beginTransaction();
		Integer ret = (Integer) session.save(record); 
		tr.commit();
		if(ret==null){
			ret = 0;
		}
		return ret;
	}
	/**
	 * ���¼�¼
	 * 
	 */
	public void update(AlarmRecord record){
		Session session = HSF.getSession();
		session.clear();
		Transaction tr = session.beginTransaction();
		session.update(record); 
		tr.commit();
	}
	
	/**
	 * ��ѯ���м�¼��
	 * @return ��¼��
	 */
	public int recordSize(){
		Session session = HSF.getSession();
		Transaction tr = session.beginTransaction();
		Criteria cr = session.createCriteria(AlarmRecord.class).add(
				Restrictions.eq("deleted", false));
		List<AlarmRecord> list = cr.list();
		tr.commit();
		int size = list.size();
		return size;
	}
	/**
	 * ����ҳ���ҳ��Ϣ
	 * @param page 
	 */
	public void RecordCount(PageUtil page) {
		int recordCount = this.recordSize();
		int pageNum = page.getPageNum();
		int pageCount = (recordCount % pageNum == 0) ? recordCount / pageNum
				: recordCount / pageNum + 1;
		page.setAllPage(pageCount);
		page.setAllRecord(recordCount);
	}

	public void deleteById(int id) {
		Session session = HSF.getSession();
		session.clear();
		AlarmRecord record = queryById(id);
		Transaction tr = session.beginTransaction();
		record.setDeleted(true);
		session.update(record);
		tr.commit();
	}

	public void solvedMark(int id) {
		Session session = HSF.getSession();
		session.clear();
		AlarmRecord record = queryById(id);
		Transaction tr = session.beginTransaction();
		record.setSolved(true);
		session.update(record);
		tr.commit();
	}

}
