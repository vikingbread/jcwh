package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import edu.njit.jcwh.dao.MachineDao;
import edu.njit.jcwh.pojo.Engineer;
import edu.njit.jcwh.pojo.Machine;
import edu.njit.jcwh.pojo.Operator;
import edu.njit.jcwh.util.HSF;
import edu.njit.jcwh.util.PageUtil;


public class MachineTest {
	@Test
	public void getProduct(){
		Session session = HSF.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Machine");
		List<edu.njit.jcwh.pojo.Machine> list = query.list();
		for (edu.njit.jcwh.pojo.Machine product : list) {
			System.out.println(product);
		}
		transaction.commit();
	}
	@Test
	public void queryAll(){
		List<edu.njit.jcwh.pojo.Machine> list = new MachineDao().queryAll(new PageUtil());
		for (edu.njit.jcwh.pojo.Machine product : list) {
			System.out.println(product);
		}
	}
	@Test
	public void addMachine(){
		Operator op = new Operator();
		op.setId(1);
		Engineer eg = new Engineer();
		eg.setId(10001);
		Machine machine = new Machine();
		machine.setId(1050);
		machine.setOperator(op);
		machine.setEngineer(eg);
		new MachineDao().addMachine(machine);
	}
}
