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

public class QueryUncheckRecords extends BaseServlet {

	@Override
	public void doWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		AlarmRecordDao arDao = new AlarmRecordDao();
		List<AlarmRecord> list = arDao.queryAllUncheckRecords();
		int count = 0;
		if(list!=null){
			count = list.size();
		}
		Map map = new HashMap();
		map.put("count",count);
		JSONObject jsonObj = JSONObject.fromObject(map);
		response.getWriter().print(jsonObj.toString());
	}
	
	

}
