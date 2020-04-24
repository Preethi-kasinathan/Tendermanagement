package model;

import java.sql.Date;
import java.time.LocalDate;

public class Admin {
	private String username;
	private String email;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Admin(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	
	private String tender_no;
	private String tender_title;
	private String tender_brief;
	private String location_tender;
	private String state_tender;
	private String amount;
	Date publish_date;
	Date due_date;
	
	public String getTender_no() {
		return tender_no;
	}
	public void setTender_no(String tender_no) {
		this.tender_no = tender_no;
	}
	public String getTender_title() {
		return tender_title;
	}
	public void setTender_title(String tender_title) {
		this.tender_title = tender_title;
	}
	public String getTender_brief() {
		return tender_brief;
	}
	public void setTender_brief(String tender_brief) {
		this.tender_brief = tender_brief;
	}
	public String getLocation_tender() {
		return location_tender;
	}
	public void setLocation_tender(String location_tender) {
		this.location_tender = location_tender;
	}
	public String getState_tender() {
		return state_tender;
	}
	public void setState_tender(String state_tender) {
		this.state_tender = state_tender;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public Date getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	
	public Admin(String username, String email, String password, String tender_no, String tender_title,
			String tender_brief, String location_tender, String state_tender, String amount, Date publish_date,
			Date due_date) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.tender_no = tender_no;
		this.tender_title = tender_title;
		this.tender_brief = tender_brief;
		this.location_tender = location_tender;
		this.state_tender = state_tender;
		this.amount = amount;
		this.publish_date = publish_date;
		this.due_date = due_date;
	}
	
	
	
	
	

}
