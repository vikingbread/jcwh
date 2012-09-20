package edu.njit.jcwh.action;

import java.util.List;

import edu.njit.jcwh.dao.MachineDao;
import edu.njit.jcwh.pojo.Machine;
import edu.njit.jcwh.util.PageUtil;
/**
 * @author Viking
 * 机床信息Action处理类
 * 转发所有与机床信息有关的请求
 *
 */
public class MachineAction {
	private PageUtil page = new PageUtil();
	private MachineDao dao = new MachineDao();
	private Machine machine;
	private List<Machine> list ;
	private String forword;
	private int prompt = 0;
	
	public String queryAll(){
		dao.calCount(page);
		list =dao.queryAll(page);
		return "queryAll";
	}
	
	public String addMachine(){
		dao.addMachine(machine);
		prompt = 1;
		return queryAll();
	}
	
	//getter & setter ~~~~~~~~~~~~~~~~~~~
	public String queryById(){
		machine = dao.queryById(machine.getId());
		return forword;
	}
	public String deleteById(){
		dao.deleteById(machine.getId());
		prompt = 1;
		return queryAll();
	}
	
	public String update(){
		dao.update(machine);
		prompt = 1;
		return queryAll();
	}
	
	public List<Machine> getList() {
		return list;
	}
	public void setList(List<Machine> list) {
		this.list = list;
	}
	public PageUtil getPage() {
		return page;
	}
	public void setPage(PageUtil page) {
		this.page = page;
	}
	public Machine getMachine() {
		return machine;
	}
	public void setMachine(Machine machine) {
		this.machine = machine;
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
