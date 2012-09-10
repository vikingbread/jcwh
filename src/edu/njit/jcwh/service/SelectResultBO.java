package edu.njit.jcwh.service;

import java.awt.Font;
import java.awt.RenderingHints;
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
/**
 * 
 * @author Viking
 * ����Jchart��
 *
 */
public class SelectResultBO {

	private List<String> sports;
	private Map<String, Integer> app;

	public void countResult() {
		if (null == sports) {
			return;
		}
		for (String sport : sports) {
			if (app.get(sport) != null) {
				app.put(sport, app.get(sport) + 1);
			} else {
				app.put(sport, 1);
			}
		}
	}

	public JFreeChart createChart() {
		countResult();
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

		CategoryDataset defaultCategoryDataset = getCategoryDataset();
		//����ͼ�� ѡ������
		JFreeChart chart = ChartFactory.createBarChart3D("��Ȥͳ�ƽ��", "��Ŀ", "����",
				defaultCategoryDataset, PlotOrientation.VERTICAL, false, false,
				false);
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		// new Font("", Font.BOLD, size)
		plot.getDomainAxis().setCategoryLabelPositions(
				CategoryLabelPositions.UP_45);

		return chart;
	}

	private DefaultCategoryDataset getCategoryDataset() {

		DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
		defaultCategoryDataset.setValue(app.get("basketball"), "", "����");
		defaultCategoryDataset.setValue(app.get("football"), "", "����");
		defaultCategoryDataset.setValue(app.get("badminton"), "", "��ë��");
		defaultCategoryDataset.setValue(app.get("rugby"), "", "�����");

		return defaultCategoryDataset;
	}

	public SelectResultBO(List<String> sports, Map app) {
		this.sports = sports;
		this.app = app;

	}

}
