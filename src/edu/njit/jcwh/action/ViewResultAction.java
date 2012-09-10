package edu.njit.jcwh.action;

import java.util.List;
import java.util.Map;
import org.jfree.chart.JFreeChart;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import edu.njit.jcwh.service.SelectResultBO;
/**
 * 
 * @author Viking
 *Jchart≤‚ ‘Action
 *
 */
public class ViewResultAction extends ActionSupport {
	
	private JFreeChart chart;
	private List<String> sports;

	public String execute(){
		
		Map app = ActionContext.getContext().getApplication();
		SelectResultBO srbo = new SelectResultBO(sports,app);
		chart = srbo.createChart();
		
//		Map app = ActionContext.getContext().getApplication();
//		SelectResultBO srbo = new SelectResultBO(sports,app);
//		chart = srbo.CreateChart();
//		ChartFrame chartFrame = new ChartFrame("—°‘Ò", chart);
//		chartFrame.pack();
//		chartFrame.setVisible(true);
		
		
		//System.out.println("execute !!");
		//System.out.println(sports);
		return SUCCESS;
	}
	
	public JFreeChart getChart() {
		return chart;
	}

	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}

	public List<String> getSports() {
		return sports;
	}

	public void setSports(List<String> sports) {
		this.sports = sports;
	}
}
