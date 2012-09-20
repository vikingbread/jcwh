package edu.njit.jcwh.pojo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="machine")
public class Machine {
	private int id;
	private Operator operator;
	private int errorCount;
	private Engineer engineer;
	private boolean deleted;
	private Set errRecords;
	
	@Id
	@Column(name="machinenumber")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne
	@JoinColumn(name="engineernumber")
	public Engineer getEngineer() {
		return engineer;
	}
	public void setEngineer(Engineer engineer) {
		this.engineer = engineer;
	}
	@Column(name="errorcount")
	public int getErrorCount() {
		return errorCount;
	}
	public void setErrorCount(int errorCount) {
		this.errorCount = errorCount;
	}
	@ManyToOne
	@JoinColumn(name="operatornumber")
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	@OneToMany(targetEntity=AlarmRecord.class)
	@Cascade (value = {CascadeType.ALL,CascadeType.DELETE_ORPHAN}) 
	@Fetch(FetchMode.SUBSELECT)
	@JoinColumn(name="machinenumber",updatable=false,insertable=false)
	public Set getErrRecords() {
		return errRecords;
	}
	public void setErrRecords(Set errRecords) {
		this.errRecords = errRecords;
	}
	@Override
	public String toString() {
		return "Product [machNum=" + id + ", operator=" + operator
				+ ", errorCount=" + errorCount + ", engineer=" + engineer + "]";
	}
}
