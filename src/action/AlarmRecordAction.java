package edu.njit.jcwh.action;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import edu.njit.jcwh.dao.AlarmRecordDao;
import edu.njit.jcwh.pojo.AlarmRecord;
import edu.njit.jcwh.util.PageUtil;
/**
 * @author Viking
 * 警告记录Action
 * 转发所有与警告记录的请求
 *
 */
public class AlarmRecordAction extends ActionSupport {
	private PageUtil page = new PageUtil();
	private AlarmRecordDao dao = new AlarmRecordDao();
	private AlarmRecord record;
	private List<AlarmRecord> list;
	private String action;
	private String forword;
	private int prompt = 0;

	public String queryAll() {
		dao.RecordCount(page);
		list = (List<AlarmRecord>) dao.queryAll(page);
		action = "AlarmRecord!queryAll.action";
		return "queryAll";
	}
	
	public String queryAllUncheckRecords(){
		list = dao.queryAllUncheckRecords();
		if(list!=null){
			int recordCount = list.size();
			int pageNum = page.getPageNum();
			int pageCount = (recordCount % pageNum == 0) ? recordCount / pageNum
					: recordCount / pageNum + 1;
			page.setAllPage(pageCount);
			page.setAllRecord(recordCount);
		}
		list = (List<AlarmRecord>) dao.queryAllUncheckRecords(page);
		action = "AlarmRecord!queryAllUncheckRecords.action";
		return "queryAllUncheckRecords";
	}

	public String update(){
		dao.update(record);
		prompt=1;
		return queryAll();
	}
	
	public String addRecord() {
		int ret =  dao.addRecord(record);
		prompt=1;
		return queryAll();
	}
	
	public String deleteById(){
		dao.deleteById(record.getId());
		prompt=1;
		return queryAll();
	}
	
	public String solvedMark(){
		dao.solvedMark(record.getId());
		prompt=1;
		return queryAll();
	}
	
	public String queryById() {
		record =  dao.queryById(record.getId());
		return forword;
	}
	
	//getter & setter ~~~~~~~~~~~~~~~~~~~
	public PageUtil getPage() {
		return page;
	}

	public void setPage(PageUtil page) {
		this.page = page;
	}

	public List<AlarmRecord> getList() {
		return list;
	}

	public void setList(List<AlarmRecord> list) {
		this.list = list;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public AlarmRecord getRecord() {
		return record;
	}

	public void setRecord(AlarmRecord record) {
		this.record = record;
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
