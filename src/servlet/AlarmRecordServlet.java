package edu.njit.jcwh.servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;
import edu.njit.jcwh.dao.AlarmRecordDao;
import edu.njit.jcwh.dao.EngineerDao;
import edu.njit.jcwh.pojo.AlarmRecord;
import edu.njit.jcwh.pojo.Engineer;
import edu.njit.jcwh.service.RecordChartBO;
import edu.njit.jcwh.util.DateUtil;
import edu.njit.jcwh.util.PageUtil;
/**
 * 
 * @author Administrator
 *
 */
public class AlarmRecordServlet extends BaseServlet {

	@Override
	public void doWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		AlarmRecordDao arDao = new AlarmRecordDao();
		int size = arDao.recordSize();
		//过去三个月
		Date date = DateUtil.rollMonth(-3);
		Map map = new HashMap();
		map.put("date", date);
		PageUtil page = new PageUtil();
		page.setCon(map);
		List<AlarmRecord> list = arDao.queryByDate(page);//list按时间的升序排列
		int recent3M = 0;//前三个月到现在数量
		if(list!=null){
			recent3M = list.size();
		}
		int thisM = 0;
		if(recent3M!=0){//如果前三个月到现在都未0 本月肯定也未0
			date = DateUtil.rollMonth(0);
			map.put("date", date);
			page = new PageUtil();
			page.setCon(map);
			list = arDao.queryByDate(page);//list按时间的升序排列
			thisM = list.size();
			recent3M = recent3M -thisM;
		}
		int last3M = thisM-recent3M;
		map = new HashMap();
		map.put("thisM",thisM);
		map.put("recent3M",recent3M);
		map.put("history",size);
	 
		JSONObject jsonObj = JSONObject.fromObject(map);
		response.getWriter().print(jsonObj.toString());
	}
	
	

}
