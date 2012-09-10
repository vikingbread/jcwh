package edu.njit.jcwh.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.njit.jcwh.dao.SolutionDao;
import edu.njit.jcwh.pojo.Solution;
import edu.njit.jcwh.util.PageUtil;

/**
 * @author Viking
 * 解决方案Action
 *
 */
public class SolutionAction extends ActionSupport {
	private PageUtil page = new PageUtil();
	private SolutionDao dao = new SolutionDao();
	private List<Solution> list;
	private Solution solution;
	private String forword;
	private int prompt = 0;

	public String queryAll() {
		dao = new SolutionDao();
		dao.calCount(page);
		list = dao.queryAll(page);
		return "queryAll";
	}
	
	public String addSolution(){
		int ret = dao.addSolution(solution);
		prompt = 1;
		return queryAll();
	}
	
	public String queryById(){
		solution = dao.queryById(solution.getId());
		return forword;
	}
	
	public String deleteById(){
		 dao.deleteById(solution.getId());
		 prompt = 1;
		return queryAll();
	}
	
	public String update(){
		dao.update(solution);
		prompt = 1;
		return queryAll();
	}
	
    //getter & setter ~~~~~~~~~~~~
	public PageUtil getPage() {
		return page;
	}

	public void setPage(PageUtil page) {
		this.page = page;
	}

	public List<Solution> getList() {
		return list;
	}

	public void setList(List<Solution> list) {
		this.list = list;
	}

	public Solution getSolution() {
		return solution;
	}

	public void setSolution(Solution solution) {
		this.solution = solution;
	}

	public String getForword() {
		return forword;
	}

	public void setForword(String forword) {
		this.forword = forword;
	}

	public int getPrompt() {
		return prompt;
	}

	public void setPrompt(int prompt) {
		this.prompt = prompt;
	}
	
}
