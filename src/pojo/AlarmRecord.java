package edu.njit.jcwh.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "alarm_record")
public class AlarmRecord {

	private int id;
	private Machine machine;
	private Solution solution;
	private Timestamp date;
	private boolean solved;
	private boolean deleted;
	private boolean check;
	private String comeFrom;

	@Column(name = "errdate")
	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	@Column(name = "whether_solved")
	public boolean isSolved() {
		return solved;
	}

	public void setSolved(boolean isSolved) {
		this.solved = isSolved;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "machinenumber")
	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	@ManyToOne
	@JoinColumn(name = "alarmnumber")
	public Solution getSolution() {
		return solution;
	}

	public void setSolution(Solution solution) {
		this.solution = solution;
	}

	@Column(name = "isdeleted")
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.deleted = isDeleted;
	}

	@Column(name = "checked")
	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public String getComeFrom() {
		return comeFrom;
	}

	public void setComeFrom(String comeFrom) {
		this.comeFrom = comeFrom;
	}

	@Override
	public String toString() {
		return "AlarmRecord [id=" + id + ", date=" + date + ", isSolved="
				+ solved + ", machine=" + machine + " , solution=" + solution
				+ ", deleted=" + deleted + ", check=" + check + "]";
	}

}
