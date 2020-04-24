package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Admin;
import model.TenderRequest;
import model.Tender_Authority;
import model.User;
import service.UserDAOInterface;
import utility.ConnectionManager;

public class UserDAO implements UserDAOInterface {

	@Override
	public int NewUser(User user) throws ClassNotFoundException, Exception, NumberFormatException {
		
		BufferedReader bfrd = new BufferedReader(new InputStreamReader(System.in));
		ConnectionManager cnmgr = new ConnectionManager();
		Connection con = cnmgr.getConnection();
		
		System.out.println("ENTER FIRSTNAME:");
		String fname = bfrd.readLine();
		System.out.println("ENTER LASTNAME:");
		String lname = bfrd.readLine();
		System.out.println("ENTER EMAIL ID:");
		String email = bfrd.readLine();
		System.out.println("ENTER PASSWORD:");
		String pass = bfrd.readLine();
		System.out.println("ENTER MOBILE NUMBER:");
		String mblno = bfrd.readLine();
		
		user.setF_name(fname);
		user.setL_name(lname);
		user.setEmail_id(email);
		user.setPassword(pass);
		user.setMobile_no(mblno);
		
		// YOU HAVE TO CREATE THE TABLE IN YOUR SQL DEVELOPER
		// REPLACE THE TABLENAME INSTEAD OF PUT YOUR CREATED TABLE NAME
		
		/*CREATE TABLE USERLOGIN 
		(
		  F_NAME VARCHAR(50),
		  L_NAME VARCHAR(50),
		  EMAIL_ID VARCHAR(50),
		  PASSWORD VARCHAR(50),
		  MOBILE_NO NUMBER(11)
		);*/
		
		String sql = "insert into USERLOGIN VALUES(?,?,?,?,?)";
		PreparedStatement prestmt = con.prepareStatement(sql);
		prestmt.setString(1, user.getF_name());
		prestmt.setString(2, user.getL_name());
		prestmt.setString(3, user.getEmail_id());
		prestmt.setString(4, user.getPassword());
		prestmt.setString(5, user.getMobile_no());
		ResultSet rs = prestmt.executeQuery();
		
		if(rs!=null)
		{
			System.out.println("USER REGISTERED SUCCESSFULLY");
			con.close();
		}
		else
		{
			System.out.println("Check Your Database");
			con.close();
		}
		
		return 0;
	}

	@Override
	public boolean Userlogin(User user) throws ClassNotFoundException, Exception {
		
		BufferedReader bfrd = new BufferedReader(new InputStreamReader(System.in));
		ConnectionManager cnmgr = new ConnectionManager();
		Connection con = cnmgr.getConnection();
		
		System.out.println("ENTER EMAIL ID:");
		String emlid = bfrd.readLine();
		System.out.println("ENTER PASSWORD:");
		String pswd = bfrd.readLine();
		
		user.setEmail_id(emlid);
		user.setPassword(pswd);
		
		
		String sql = "SELECT * FROM USERLOGIN WHERE EMAIL_ID = ? AND PASSWORD = ?";
		PreparedStatement prstmt = con.prepareStatement(sql);
		prstmt.setString(1, user.getEmail_id());
		prstmt.setString(2, user.getPassword());
		ResultSet rs = prstmt.executeQuery();
		
		while(rs.next())
		{
			if(emlid.equals(rs.getString("email_id")) && pswd.equals(rs.getString("password")))
			{
				
				System.out.println("LOGIN SUCCESSFULLY");
				System.out.println();
				System.out.println("*************** WELCOME ***********************");
				System.out.println();
				System.out.println("****************** TENDER DETAILS *******************");
				System.out.println();
				all_tender_details();
				System.out.println();
				System.out.println(" Do you want to rise a Tender Request ");
				String yes = "YES";
				String no = "NO";
				String ys_no = bfrd.readLine();
				
				if(yes.equals(ys_no))
				{
					TenderRequestDAO tndrrqstdao = new TenderRequestDAO();
					tndrrqstdao.tender_request();
				}
				else
				{
					System.out.println("THANK YOU VISIT AGAIN");
				}
				
				
				return true;
				// whatever you want any method to call you can create object and call a method in this space.
			}
			else
			{
				System.out.println("INVALID USER");
			}
			
		}
		rs.close();
		con.close();

		return false;
	}

	@Override
	public List<Admin> all_tender_details() throws Exception {
		
		AdminDAO admdao = new AdminDAO();
		List<Admin> adm = new ArrayList<Admin>();
		Admin admin = null;
		
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getConnection();
		
		String sql = "select * from publisher";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next())
		{
			if(rs!=null)
			{
				System.out.println("TENDER NO: " +rs.getString(1)+"\n "+ "TENDER TITLE: "+rs.getString(2)+"\n "+"TENDER BRIEF: "+rs.getString(3)+"\n "+"TENDER LOCATION: "+rs.getString(4)+"\n "+"TENDER STATE: "+rs.getString(5)+"\n "+"TENDER AMOUNT: "+rs.getString(6)+"\n "+"TENDER PUBLISH DATE: "+rs.getString(7)+"\n "+"TENDER DUE DATE: "+rs.getString(8));
				System.out.println();
				adm.add(admin);
			}
		}
		con.close();
		rs.close();
		stmt.close();
		return adm;
	}
public boolean Authoritylogin(Tender_Authority tndr_autry) throws ClassNotFoundException, Exception {
		
		BufferedReader bfrd = new BufferedReader(new InputStreamReader(System.in));
		ConnectionManager cmgr = new ConnectionManager();
		Connection con = cmgr.getConnection();
		
		System.out.println("ENTER USERNAME: ");
		String usrnm = bfrd.readLine();
		System.out.println("ENTER PASSWORD: ");
		String pswd = bfrd.readLine();
		
		tndr_autry.setUsername(usrnm);
		tndr_autry.setPassword(pswd);
		String sql = "select * from tender_authority where username = ? and password = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, tndr_autry.getUsername());
		stmt.setString(2, tndr_autry.getPassword());
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next())
		{
			if(usrnm.equals(rs.getString("username")) && pswd.equals(rs.getString("password")))
			{
				System.out.println("TENDER DETAILS");
				//call sms() method.
			}
		}
		
		return false;
	}

	@Override
	public List<TenderRequest> selectallrequest() throws ClassNotFoundException, Exception {
		
		TenderRequestDAO tndrrqst = new TenderRequestDAO();
		List<TenderRequest> lsttndrrqst = new ArrayList<TenderRequest>();
		TenderRequest trqst = null;
		ConnectionManager cmgr = new ConnectionManager();
		Connection con = cmgr.getConnection();
		
		String sql = "select * from tender_request";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next())
		{
			trqst = new TenderRequest(null, null, null, null, null, null);
			System.out.println("NAME: " + rs.getString(1));
			System.out.println("TENDER NO: " + rs.getString(2));
			System.out.println("COMPANY NAME: " + rs.getString(3));
			System.out.println("MOBILE NUMBER: " + rs.getString(4));
			System.out.println("ESTIMATE AMOUNT: " + rs.getString(5));
			System.out.println("DATE: " + rs.getString(6));
			lsttndrrqst.add(trqst);
			
			//YOU CAN APPROVE USER THROUGH SMS API
			// CALL METHOD SMS();
		}
		
		
		
		return null;
	}
	
	


}
