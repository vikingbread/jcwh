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
	 * 分页查找所有记录信息
	 * 
	 * @param page
	 *            分页条件
	 * @return list 符合条件的记录列表
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
	 * 按照id号查询记录
	 * @param id 需要查询的记录的id号
	 * @return 查询到的记录  
	 */
	public AlarmRecord queryById(int id){
		Session session = HSF.getSession();
		return (AlarmRecord) session.get(AlarmRecord.class, id);
	}
	
	/**
	 * 检查传入列表中的记录是否为未查看  并将其标记为以查看
	 * 否则不做修改
	 * @param list 需要检查的列表
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
	 * 查询所有的未查看的异常
	 * @return 返回未查看的异常列表
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
	 * 分页查询未查看的异常
	 * @return 返回未查看的异常列表
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
	 * 按日期查询记录 用于制图
	 * @param page 传入封装好的的日期条件信息
	 * @return 查询到的列表
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
	 * 增加一个记录
	 * @param record 需要增加的记录
	 * @return true 增加成功 
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
	 * 更新记录
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
	 * 查询所有记录数
	 * @return 记录数
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
	 * 设置页面分页信息
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
