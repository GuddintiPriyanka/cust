package com.management.CustomerMS.dto;



public class LifeDTO {

    String name;
	
	String email;

	String phonenumber;
	
	String password;
	
	String policynumber;
	
	Integer isactive;
	
	Double dueamount;
	

	
	public LifeDTO() {
		super();
	}
		public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPolicynumber() {
		return policynumber;
	}
	public void setPolicynumber(String policynumber) {
		this.policynumber = policynumber;
	}
	public Integer getIsactive() {
		return isactive;
	}
	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}
	public Double getDueamount() {
		return dueamount;
	}
	public void setDueamount(Double dueamount) {
		this.dueamount = dueamount;
	}
	
	
	@Override
	public String toString() {
		return "MotorDTO [name=" + name + ", email=" + email + ", phonenumber=" + phonenumber + ", password=" + password
				+ ", policynumber=" + policynumber + ", isactive=" + isactive + ", dueamount=" + dueamount + "]";
	}



}
