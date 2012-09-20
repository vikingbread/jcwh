package edu.njit.jcwh.service;

import java.awt.Font;
import java.awt.RenderingHints;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import edu.njit.jcwh.dao.AlarmRecordDao;
import edu.njit.jcwh.pojo.AlarmRecord;
import edu.njit.jcwh.util.DateUtil;
import edu.njit.jcwh.util.PageUtil;

public class RecordChartBO {
	private Map<String, Integer> chartData;
	private DefaultCategoryDataset categoryDataset;
	/**
	 * 获得最近三个月故障记录统计图
	 * 
	 * @return 处理得到的图表
	 */
	public JFreeChart Recent3MChart() {
		
		Date threeMonthAgo = DateUtil.rollMonth(-3);//计算到前三个月前
		Map map = new HashMap();
		map.put("date", threeMonthAgo);
		PageUtil page = new PageUtil();
		page.setCon(map);
		AlarmRecordDao arDao = new AlarmRecordDao();
		List<AlarmRecord> list = arDao.queryByDate(page);//list按时间的升序排列
		chartData = new LinkedHashMap<String, Integer>();//存储图表需要的数据
		
		//计算过去第三月的数据 存储在charData中
		Date twoMonthAgo = DateUtil.rollMonth(-2);
		handleList(list, twoMonthAgo, chartData);// 三个月前的数据
		
		//计算过去第二月的数据 存储在charData中
		Date oneMonthAgo = DateUtil.rollMonth(-1);
		handleList(list, oneMonthAgo, chartData);// 两个月前的数据
		
		//计算过去第一月的数据 存储在charData中
		Date thisMonth = DateUtil.rollMonth(0);
		handleList(list, thisMonth, chartData);// 一个月前的数据
		
		// 本月的数据 直接计算list剩余的数量
		chartData.put("本月", list.size());
		
		Map<String,String> items = new HashMap<String,String>();
		items.put("title", "历史统计");
		items.put("xTitle", "月份");
		items.put("yTitle", "次数");
		
		setCategoryDataset();//处理DefaultCategoryDataset
		
		return createChart(items);
	}

	private void handleList(List<AlarmRecord> list, Date limit,
			Map<String, Integer> chartData) {
		int count = 0;
		Iterator<AlarmRecord> it = list.iterator();
		Timestamp time = null;
		while (it.hasNext()) {
			AlarmRecord ar = it.next();
			time = ar.getDate();
			if (time.before(limit)) {
				it.remove();
				count++;
			} else {
				GregorianCalendar gc = new GregorianCalendar();
				gc.setTime(limit);
				String month = null;
				if(gc.get(GregorianCalendar.MONTH)!=0){//月不是12月
					month = gc.get(GregorianCalendar.MONTH)+"月";
				}else{
					month = "12月";//当前月事12月时
				}
				chartData.put(month, count);
				break;
			}
		}
	}

	public JFreeChart createChart(Map<String,String> items) {
		StandardChartTheme theme = new StandardChartTheme("gbk") {
			public void apply(JFreeChart chart) {
				chart.getRenderingHints().put(
						RenderingHints.KEY_TEXT_ANTIALIASING,
						RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
				super.apply(chart);
			}
		};
		theme.setExtraLargeFont(new Font("宋体", Font.PLAIN, 18));
		theme.setLargeFont(new Font("宋体", Font.PLAIN, 16));
		theme.setRegularFont(new Font("宋体", Font.PLAIN, 14));
		theme.setSmallFont(new Font("宋体", Font.PLAIN, 12));
		ChartFactory.setChartTheme(theme);

		//setCategoryDataset();
		// 创建图表 选择类型
		JFreeChart chart = ChartFactory.createBarChart3D(items.get("title"), items.get("xTitle"), items.get("yTitle"),
				this.categoryDataset, PlotOrientation.VERTICAL, false, false,
				false);
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		// new Font("", Font.BOLD, size)
		plot.getDomainAxis().setCategoryLabelPositions(
				CategoryLabelPositions.UP_45);

		return chart;
	}

	private void setCategoryDataset() {
		if(chartData==null){
			return;
		}
		categoryDataset = new DefaultCategoryDataset();
		for(Map.Entry<String, Integer> en:chartData.entrySet()){
			categoryDataset.setValue(en.getValue(), "", en.getKey());
		}
	}

	public RecordChartBO() {
	}
}
