package edu.njit.jcwh.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table
public class Solution {
	private int id;
	private String alarmmodel;
	private String alarmNumberExplanation;
	private String faultType;
	private String reaction;
	private String explanation;
	private String solution;
	private String restart;
	private int historyCount;
	private int grade;
	private boolean deleted;
	private Set<AlarmRecord> alarmRecord = new HashSet<AlarmRecord>();
	
	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAlarmmodel() {
		return alarmmodel;
	}

	public void setAlarmmodel(String alarmmodel) {
		this.alarmmodel = alarmmodel;
	}

	@Column(name = "alarmnumber_explain")
	public String getAlarmNumberExplanation() {
		return alarmNumberExplanation;
	}

	public void setAlarmNumberExplanation(String alarmNumberExplanation) {
		this.alarmNumberExplanation = alarmNumberExplanation;
	}

	public String getFaultType() {
		return faultType;
	}

	public void setFaultType(String faultType) {
		this.faultType = faultType;
	}

	public String getReaction() {
		return reaction;
	}

	public void setReaction(String reaction) {
		this.reaction = reaction;
	}

	@Column(name = "explain_")
	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	@Column(name = "programcontinue")
	public String getRestart() {
		return restart;
	}

	public void setRestart(String restart) {
		this.restart = restart;
	}

	@Column(name = "historyerrorcount",updatable=false)
	public int getHistoryCount() {
		return historyCount;
	}

	public void setHistoryCount(int historyCount) {
		this.historyCount = historyCount;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	@OneToMany(targetEntity=AlarmRecord.class)
	@Cascade (value = {CascadeType.ALL,CascadeType.DELETE_ORPHAN}) 
	@Fetch(FetchMode.SUBSELECT)
	@JoinColumn(name="alarmnumber",updatable=false)
	public Set<AlarmRecord> getAlarmRecord() {
		return alarmRecord;
	}
	

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public void setAlarmRecord(Set<AlarmRecord> alarmRecord) {
		this.alarmRecord = alarmRecord;
	}

	@Override
	public String toString() {
		return "Solution [id=" + id + ", alarmmodel=" + alarmmodel
				+ ", alarmNumberExplanation=" + alarmNumberExplanation
				+ ", faultType=" + faultType + ", reaction=" + reaction
				+ ", explanation=" + explanation + ", solution=" + solution
				+ ", restart=" + restart + ", historyCount=" + historyCount
				+ ", grade=" + grade +"]";
	}

}
