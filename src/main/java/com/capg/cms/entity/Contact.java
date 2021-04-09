package com.capg.cms.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Contact implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long contactid;
	private String fullname;
	private LocalDate dateofbirth;
	private String mobile;
	
	public Contact() {
		
	}
	public Contact(Long contactid, String fullname, LocalDate dateofbirth, String mobile) {
		super();
		this.contactid = contactid;
		this.fullname = fullname;
		this.dateofbirth = dateofbirth;
		this.mobile = mobile;
	}
	public Long getContactid() {
		return contactid;
	}
	public void setContactid(Long contactid) {
		this.contactid = contactid;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public LocalDate getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(LocalDate dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Contact [contactid=" + contactid + ", fullname=" + fullname + ", dateofbirth=" + dateofbirth
				+ ", mobile=" + mobile + "]";
	}
	
	
	
	
	

}
