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
	 * �����������¹��ϼ�¼ͳ��ͼ
	 * 
	 * @return ����õ���ͼ��
	 */
	public JFreeChart Recent3MChart() {
		
		Date threeMonthAgo = DateUtil.rollMonth(-3);//���㵽ǰ������ǰ
		Map map = new HashMap();
		map.put("date", threeMonthAgo);
		PageUtil page = new PageUtil();
		page.setCon(map);
		AlarmRecordDao arDao = new AlarmRecordDao();
		List<AlarmRecord> list = arDao.queryByDate(page);//list��ʱ�����������
		chartData = new LinkedHashMap<String, Integer>();//�洢ͼ����Ҫ������
		
		//�����ȥ�����µ����� �洢��charData��
		Date twoMonthAgo = DateUtil.rollMonth(-2);
		handleList(list, twoMonthAgo, chartData);// ������ǰ������
		
		//�����ȥ�ڶ��µ����� �洢��charData��
		Date oneMonthAgo = DateUtil.rollMonth(-1);
		handleList(list, oneMonthAgo, chartData);// ������ǰ������
		
		//�����ȥ��һ�µ����� �洢��charData��
		Date thisMonth = DateUtil.rollMonth(0);
		handleList(list, thisMonth, chartData);// һ����ǰ������
		
		// ���µ����� ֱ�Ӽ���listʣ�������
		chartData.put("����", list.size());
		
		Map<String,String> items = new HashMap<String,String>();
		items.put("title", "��ʷͳ��");
		items.put("xTitle", "�·�");
		items.put("yTitle", "����");
		
		setCategoryDataset();//����DefaultCategoryDataset
		
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
				if(gc.get(GregorianCalendar.MONTH)!=0){//�²���12��
					month = gc.get(GregorianCalendar.MONTH)+"��";
				}else{
					month = "12��";//��ǰ����12��ʱ
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
		theme.setExtraLargeFont(new Font("����", Font.PLAIN, 18));
		theme.setLargeFont(new Font("����", Font.PLAIN, 16));
		theme.setRegularFont(new Font("����", Font.PLAIN, 14));
		theme.setSmallFont(new Font("����", Font.PLAIN, 12));
		ChartFactory.setChartTheme(theme);

		//setCategoryDataset();
		// ����ͼ�� ѡ������
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
