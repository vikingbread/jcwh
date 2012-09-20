package edu.njit.jcwh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import edu.njit.jcwh.dao.AlarmRecordDao;
import edu.njit.jcwh.dao.UserDao;
import edu.njit.jcwh.pojo.AlarmRecord;
import edu.njit.jcwh.pojo.Machine;
import edu.njit.jcwh.pojo.Solution;
import edu.njit.jcwh.pojo.User;

public class ExceptionReport extends BaseServlet {

	@Override
	/**
	 * 分析从Android客户端提交来的信息
	 */
	public void doWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//获得认证信息
		if(!checkAuth(request)){
			System.out.println("有未授权的报告!");
		//	jsonObj.put("status", "Unauthorized Post!!\nWarning:you have been recorded!!!");
			out.println("Unauthorized Post!!\nWarning:you have been recorded!!!");
			return;
		}
		System.out.println("Error Detected!!!");
		//接收参数
		String s_machineNum = request.getParameter("machineNum");
		String s_alarmNum = request.getParameter("alarmNum");
		String s_time = request.getParameter("time");
		String s_machineMod = request.getParameter("machineMod");
		
		int machineNum = s_machineNum == null ||"".equals(s_machineNum.trim())? 0
				: Integer.parseInt(s_machineNum);
		int alarmNum = s_alarmNum == null ||"".equals(s_alarmNum.trim())? 0 : Integer
				.parseInt(s_alarmNum);
		int machineMod = s_machineMod == null ||"".equals(s_time.trim())? 0
				: Integer.parseInt(s_machineMod);
		long time = s_time == null||"".equals(s_time.trim()) ? new Date().getTime()
				: Long.parseLong(s_time);
		AlarmRecord record = new AlarmRecord();
		Machine machine = new Machine();
		machine.setId(machineNum);
		record.setMachine(machine);
		Solution solution = new Solution();
		
		solution.setId(alarmNum);
		record.setSolution(solution);
		record.setComeFrom("Android客户端");

		record.setDate(new Timestamp(time * 1000));
		AlarmRecordDao dao = new AlarmRecordDao();
		// 存储收到的记录
		int ret = 0;
		JSONObject jsonObj = JSONObject.fromObject("{}");//用来存储JSON数据
		try {
			ret = dao.addRecord(record);
		} catch (Exception e) {
			jsonObj.put("status", "serverError");
			out.println(jsonObj.toString());
			return;
		}
		if (ret != 0) {
			jsonObj.put("status", "ok");
			out.println(jsonObj.toString());
		} else {
			jsonObj.put("status", "error" );
			out.println(jsonObj.toString());
		}
	}
	
	
	/**
	 * 检查请求的来源是否拥有权限
	 * @return true 拥有
	 * 		false 没有
	 */
	private boolean checkAuth(HttpServletRequest request){
		boolean ret = false;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User();
		user.setName(username);
		user.setPassword(password);
		UserDao userDao = new UserDao();
		User u = userDao.checkUser(user);
		if(u!=null){
			ret = true;
		}
		return ret ;
	}

}
