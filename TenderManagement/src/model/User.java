package model;

public class User {

	private String f_name;
	private String l_name;
	private String email_id;
	private String password;
	private String mobile_no;
	
	
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	
	public User(String f_name, String l_name, String email_id, String password, String mobile_no) {
		super();
		this.f_name = f_name;
		this.l_name = l_name;
		this.email_id = email_id;
		this.password = password;
		this.mobile_no = mobile_no;
	}
	
	
	
}
