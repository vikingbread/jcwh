package edu.njit.jcwh.pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import edu.njit.jcwh.util.MD5Util;

@Entity
public class User {
	private int id;
	private String name = "";
	private String password = "";
	private String email = "";
	private String phone = "";
	private String truename = "";
	private Timestamp createTime;
	private String sex;
	private String thisIp = "";
	private String lastIp = "";
	private Set loginRecords ;
	
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTruename() {
		return truename;
	}
	public void setTruename(String truename) {
		this.truename = truename;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Column(name="this_ip")
	public String getThisIp() {
		return thisIp;
	}
	public void setThisIp(String thisIp) {
		this.thisIp = thisIp;
	}
	@Column(name="last_ip")
	public String getLastIp() {
		return lastIp;
	}
	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}
	@OneToMany(targetEntity=LoginRecord.class,mappedBy="user")
	@Cascade (value = {CascadeType.ALL,CascadeType.DELETE_ORPHAN}) 
	@Fetch(FetchMode.SUBSELECT)
	@JoinColumn(name="userid",updatable=false,insertable=false)
	public Set getLoginRecords() {
		return loginRecords;
	}
	public void setLoginRecords(Set loginRecords) {
		this.loginRecords = loginRecords;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password
				+ ", email=" + email + ", phone=" + phone + ", truename="
				+ truename + ", createTime=" + createTime + "]";
	}
	
	
}
