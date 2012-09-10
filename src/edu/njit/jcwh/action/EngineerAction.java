package edu.njit.jcwh.action;

import java.util.List;
import edu.njit.jcwh.dao.EngineerDao;
import edu.njit.jcwh.pojo.Engineer;
import edu.njit.jcwh.util.PageUtil;
/**
 * @author Viking
 * 工程师Action处理类
 * 转发所有与工程师有关的请求
 *
 */
public class EngineerAction {
	
	private PageUtil page = new PageUtil();
	private EngineerDao dao = new EngineerDao();
	private List<Engineer> list ;
	private Engineer engineer;
	private String forword;
	private int prompt = 0;
	
	public String queryAll(){
		dao.calCount(page);
		list =dao.queryAll(page);
		return "queryAll";
	}
	
	public String addEngineer(){
		EngineerDao engineerDao = new EngineerDao();
		engineerDao.addEngineer(engineer);
		prompt = 1;
		return queryAll();
	}
	
	public String update(){
		dao.update(engineer);
		prompt = 1;
		return queryAll();
	}
	public String queryById(){
		engineer = dao.queryById(engineer.getId());
		return forword;
	}
	
	public String deleteById(){
		dao.deletById(engineer.getId()); 
		prompt = 1;
		return queryAll();
	}
	
	//getter & setter ~~~~~~~~~~~~~~~~~~~
	public List<Engineer> getList() {
		return list;
	}
	public void setList(List<Engineer> list) {
		this.list = list;
	}
	public PageUtil getPage() {
		return page;
	}
	public void setPage(PageUtil page) {
		this.page = page;
	}
	
	public Engineer getEngineer() {
		return engineer;
	}
	public void setEngineer(Engineer engineer) {
		this.engineer = engineer;
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
