package dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import edu.njit.jcwh.dao.OperatorDao;
import edu.njit.jcwh.pojo.Operator;
import edu.njit.jcwh.util.HSF;
import edu.njit.jcwh.util.PageUtil;

public class OperatorsTest {
	@Test
	public void getOperators() {
		Session session = HSF.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Operator");
		List<edu.njit.jcwh.pojo.Operator> list = query.list();
		transaction.commit();
		Map map = new LinkedHashMap();
		for (edu.njit.jcwh.pojo.Operator operator : list) {
			map.put(operator.getName(), operator);
			System.out.println(operator);
		}
		System.out.println("done");
		JsonConfig config = new JsonConfig();
		config.setJsonPropertyFilter(new PropertyFilter() {
			public boolean apply(Object source, String name, Object value) {
				if (name.equals("products")) {
					return true;
				} else {
					return false;
				}
			}

		});
		JSONObject jsonObj = JSONObject.fromObject(map, config);
		//jsonObj.putAll(map);
		System.out.println(jsonObj);
	}
	@Test
	public void getOperatorByPageNo(){
		PageUtil page = new PageUtil();
		page.setPageNo(1);
		List list = new OperatorDao().queryAll(page);
		System.out.println(list);
	}
	@Test
	public void queryByName(){
		Operator op = new OperatorDao().queryOperatorByName("½¯Ò»çù");
		JsonConfig config = new JsonConfig();
		config.setJsonPropertyFilter(new PropertyFilter() {
			public boolean apply(Object source, String name, Object value) {
				if (name.equals("products")) {
					return true;
				} else {
					return false;
				}
			}

		});
		JSONObject jsonObj = JSONObject.fromObject(op, config);
		System.out.println(jsonObj);
	}
	
}
