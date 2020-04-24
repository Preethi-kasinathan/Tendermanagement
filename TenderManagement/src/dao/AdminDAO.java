package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import model.Admin;
import service.AdminDAOInterface;
import utility.ConnectionManager;

public class AdminDAO implements AdminDAOInterface {

	@Override
	public boolean AdminLogin(Admin admin) throws Exception {
	  BufferedReader bfrd=new BufferedReader(new InputStreamReader(System.in));
	  
	  ConnectionManager cmgr=new ConnectionManager();
	  Connection con=cmgr.getConnection();
	  System.out.println("Enter Email Id:");
	  String eml=bfrd.readLine();
	  System.out.println("Enter your password:");
	  String pswd=bfrd.readLine();
	  
	  admin.setEmail(eml);
	  admin.setPassword(pswd);
	  
	  String sql="select * from admin_access where email = ? and password = ?";
	  PreparedStatement st=con.prepareStatement(sql);
	  
	  st.setString(1,admin.getEmail());
	  st.setString(2,admin.getPassword());
	  ResultSet rs=st.executeQuery();
	  
	  while(rs.next())
	  {
		  if(eml.equals(rs.getString("EMAIL")) && pswd.equals(rs.getString("PASSWORD")))
		  
			  System.out.println("Login Sucessful");
		      System.out.println();
		      System.out.println("****************** WELCOME TO ADMIN PORTAL ***************");
		      System.out.println(" ENTER 1 TO ADD TENDER ");
		      System.out.println(" ENTER 2 TO VIEW TENDER DETAILS");
		      System.out.println(" ENTER 3 TO DELETE TENDER");
		      System.out.println();
		      
		      int i = 0;
		      i=Integer.parseInt(bfrd.readLine());
		      
		      if(i==1)
		      {
		    	 insert_tender(admin);
		      }
		      else if(i==2)
		      {
		    	  UserDAO usrdao = new UserDAO();
		    	  usrdao.all_tender_details();
		      }
		      else if(i==3)
		      {
		    	  String tender_no = null;
		    	  delete_tender(tender_no);
		      }
		  
		  else
		  
			  System.out.println("Invalid Access");
		  
	  }
	  rs.close();
	  con.close();
	  st.close();
		return false;
	}

	@Override
	public void insert_tender(Admin admin) throws Exception {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getConnection();
		
		System.out.println();
		System.out.println("**************** INSERT TENDER *******************");
		System.out.print("ENTER TENDER NUMBER : ");
		String tndr_no = bf.readLine();
		System.out.print("ENTER TENDER TITLE : ");
		String tndr_title = bf.readLine();
		System.out.print("ENTER TENDER BRIEF : ");
		String tndr_brf = bf.readLine();
		System.out.print("ENTER TENDER LOCATION : ");
		String tndr_loctn = bf.readLine();
		System.out.print("ENTER TENDER STATE : ");
		String tndr_stat = bf.readLine();
		System.out.print("ENTER TENDER AMOUNT : ");
		String tndr_amount = bf.readLine();
		System.out.print("ENTER TENDER PUBLISH DATE : ");
		String tndr_publsh_dt = bf.readLine();
		System.out.print("ENTER TENDER DUE DATE : ");
		String tndr_due_dt = bf.readLine();
		
		admin.setTender_no(tndr_no);
		admin.setTender_title(tndr_title);
		admin.setTender_brief(tndr_brf);
		admin.setLocation_tender(tndr_loctn);
		admin.setState_tender(tndr_stat);
		admin.setAmount(tndr_amount);
		admin.setPublish_date(Date.valueOf(tndr_publsh_dt));
		admin.setDue_date(Date.valueOf(tndr_due_dt));
		
		String sql = "insert into publisher values(?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, admin.getTender_no());
		stmt.setString(2, admin.getTender_title());
		stmt.setString(3, admin.getTender_brief());
		stmt.setString(4, admin.getLocation_tender());
		stmt.setString(5, admin.getState_tender());
		stmt.setString(6, admin.getAmount());
		stmt.setDate(7, admin.getPublish_date());
		stmt.setDate(8, admin.getDue_date());
		
		ResultSet rs = stmt.executeQuery();
	
		if(rs.next())
		{
			con.close();
			System.out.println("TENDER ADDED SUCCESSFULYY");
		}
		else
		{
			con.close();
			System.out.println("CHECK CONNECTION");
		}
		
		
		
	}

	@Override
	public boolean delete_tender(String tender_no) throws Exception {
		
		BufferedReader bfrd = new BufferedReader(new InputStreamReader(System.in));
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getConnection();
		
		System.out.println();
		System.out.print("ENTER TENDER NUMBER : ");
		String tndr_no = bfrd.readLine();
		
		Admin adm = null;
		adm = new Admin(null, null, null, null, null, null, null, null, null, null, null);
		
		String sql = "delete publisher where tender_no = ? ";
		PreparedStatement stmt1 = con.prepareStatement(sql);
		stmt1.setString(1, tndr_no);
		ResultSet rs = stmt1.executeQuery();
		
		if(rs.next())
		{
			con.close();
			System.out.println("TENDER REMOVED SUCCESSFULLY");
		}
		else
		{
			con.close();
			System.out.println("CHECK CONNECTION");
		}
		
		
		
		return false;
	}

}
