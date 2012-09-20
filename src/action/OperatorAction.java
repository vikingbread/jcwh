package edu.njit.jcwh.action;

import java.util.List;

import edu.njit.jcwh.dao.OperatorDao;
import edu.njit.jcwh.pojo.Operator;
import edu.njit.jcwh.util.PageUtil;
/**
 * @author Viking
 * 操作人员Action处理类
 * 转发所有与操作人员有关的请求
 *
 */
public class OperatorAction {
	private PageUtil page = new PageUtil();
	private OperatorDao dao  = new OperatorDao();
	private List<Operator> list ;
	private Operator operator;
	private String forword;
	private int prompt = 0;
	
	public String queryAll(){
		
		dao.calCount(page);
		list =dao.queryAll(page);
		return "queryAll";
	}
	
	public String addOperator(){
		
		int ret = dao.addOperator(operator);
		prompt = 1;
		return queryAll();
	}
	
	public String queryById(){
		operator = dao.queryById(operator.getId());
		return forword;
	}
	
	public String update(){
		dao.update(operator);
		prompt = 1;
		return queryAll();
	}
	
	public String deleteById(){
		dao.deleteById(operator.getId());
		prompt = 1;
		return queryAll();
	}
	
	//getter & setter ~~~~~~~~~~~~~~~~~~~
	public List<Operator> getList() {
		return list;
	}
	public void setList(List<Operator> list) {
		this.list = list;
	}
	public PageUtil getPage() {
		return page;
	}
	public void setPage(PageUtil page) {
		this.page = page;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
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
