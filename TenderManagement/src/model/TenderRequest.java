package model;

import java.sql.Date;

public class TenderRequest {

	private String username;
	private String tender_no;
	private String company_name;
	private String contact_no;
	private String Estimated_tender_amount;
	private Date today_Date;
	
	
	public TenderRequest(String username, String tender_no, String company_name, String contact_no,
			String estimated_tender_amount, Date today_Date) {
		super();
		this.username = username;
		this.tender_no = tender_no;
		this.company_name = company_name;
		this.contact_no = contact_no;
		Estimated_tender_amount = estimated_tender_amount;
		this.today_Date = today_Date;
	}
	public String getTender_no() {
		return tender_no;
	}
	public void setTender_no(String tender_no) {
		this.tender_no = tender_no;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public String getEstimated_tender_amount() {
		return Estimated_tender_amount;
	}
	public void setEstimated_tender_amount(String estimated_tender_amount) {
		Estimated_tender_amount = estimated_tender_amount;
	}
	public Date getToday_Date() {
		return today_Date;
	}
	public void setToday_Date(Date today_Date) {
		this.today_Date = today_Date;
	}
}
