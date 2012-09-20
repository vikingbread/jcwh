package edu.njit.jcwh.util;

import java.util.HashMap;
import java.util.Map;


/**
 * ��װ��ҳ��Ϣ��ʵ��
 * @author autumn
 * @param pageNo   ��ǰ�ǵڼ�ҳ
 * @param allPage  ��ҳ��
 * @param pageNum  ÿҳ������¼
 * @param allRecord �ܼ�¼��
 * @param prePage   ��һҳ
 * @param nextpage  ��һҳ
 */
public class PageUtil {
    private int pageNo = 1;
    private int allPage =1 ;
    private int pageNum = 8;
    private int allRecord = 1;
    private int prePage = 1;
    private int nextpage = 1;
    private Map con = null;
    
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getAllPage() {
		allPage = (this.allRecord+this.pageNum-1)/this.pageNum;
		return allPage;
	}
	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getAllRecord() {
		return allRecord;
	}
	public void setAllRecord(int allRecord) {
        this.allRecord = allRecord;
	}
	public int getPrePage() {
		if(this.getPageNo()<=1){
			return 1;
		}else{
			return this.getPageNo()-1;
		}
		
	}
	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}
	public int getNextpage() {
		if(this.getPageNo()>=this.getAllPage()){
			return this.getAllPage();
		}else{
			return this.getPageNo()+1;
		}

	}
	public void setNextpage(int nextpage) {
		this.nextpage = nextpage;
	}
	
	public Map getCon() {
		return con;
	}
	public void setCon(Map con) {
		this.con = con;
	}
    
}
