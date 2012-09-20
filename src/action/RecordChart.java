package edu.njit.jcwh.action;

import org.jfree.chart.JFreeChart;
import com.opensymphony.xwork2.ActionSupport;
import edu.njit.jcwh.service.RecordChartBO;

/**
 * @author Viking
 * »ú´²´íÎóÐÅÏ¢»æÍ¼Action
 *
 */
public class RecordChart extends ActionSupport {
	
	private JFreeChart chart;

	public String viewRecent3M(){
		RecordChartBO rc = new RecordChartBO();
		chart = rc.Recent3MChart();
		return "viewRecent3M";
	}
	
	public JFreeChart getChart() {
		return chart;
	}

	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}
}
