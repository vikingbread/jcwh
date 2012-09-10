package dao;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import edu.njit.jcwh.dao.AlarmRecordDao;
import edu.njit.jcwh.pojo.AlarmRecord;
import edu.njit.jcwh.pojo.Machine;
import edu.njit.jcwh.pojo.Solution;
import edu.njit.jcwh.util.HSF;
import edu.njit.jcwh.util.PageUtil;

public class AlarmRecordTest {
	@Test
	public void getRecord(){
		Session session = HSF.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from AlarmRecord");
		List<edu.njit.jcwh.pojo.AlarmRecord> list = query.list();
		for (edu.njit.jcwh.pojo.AlarmRecord product : list) {
			System.out.println(product);
		}
		transaction.commit();
	}
	@Test
	public void queryAllUncheckRecords(){
		List<edu.njit.jcwh.pojo.AlarmRecord> list = new AlarmRecordDao().queryAllUncheckRecords();
		for (edu.njit.jcwh.pojo.AlarmRecord record : list) {
			System.out.println(record);
		}
	}
	@Test
	public void queryByDate(){
		GregorianCalendar dc =new  GregorianCalendar();
		dc.roll(GregorianCalendar.MONTH, -3);
		java.util.Date now = dc.getTime();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-01 00:00:00");
		Map map = new HashMap();
		map.put("date", Timestamp.valueOf(df.format(now)));
		PageUtil page = new PageUtil();
		page.setCon(map);
		List<edu.njit.jcwh.pojo.AlarmRecord> list = new AlarmRecordDao().queryByDate(page);
		for (edu.njit.jcwh.pojo.AlarmRecord record : list) {
			System.out.println(record);
		}
	}
	@Test
	public void save(){
		edu.njit.jcwh.pojo.AlarmRecord record = new edu.njit.jcwh.pojo.AlarmRecord();
		
		Machine machine = new Machine();
		machine.setId(1025);
		record.setMachine(machine);
		Solution solution = new Solution();
		solution.setId(2000);
		record.setSolution(solution);
		record.setComeFrom("web“≥√Ê");

		record.setDate(new Timestamp(new Date().getTime()));
		AlarmRecordDao dao = new AlarmRecordDao();
		dao.addRecord(record);
		
	}
	@Test
	public void queryById(){
		AlarmRecordDao dao = new AlarmRecordDao();
		AlarmRecord ar = dao.queryById(667);
		System.out.println(ar);
	}
}
