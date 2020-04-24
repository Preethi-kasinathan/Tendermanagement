package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.TenderRequest;
import utility.ConnectionManager;

public class TenderRequestDAO {
	
	public void tender_request() throws ClassNotFoundException, Exception
	{
		BufferedReader bfrd = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println();
		System.out.print("ENTER YOUR NAME: ");
		String usrnm = bfrd.readLine();
		System.out.println("ENTER TENDER NUMBER: ");
		String tndr_no = bfrd.readLine();
		System.out.println("ENTER COMPANY NAME: ");
		String cmpny_name = bfrd.readLine();
		System.out.println("ENTER CONTACT NUMBER: ");
		String mbl_no = bfrd.readLine();
		System.out.println("ENTER ESTIMATE AMOUNT: ");
		String estmt_amt = bfrd.readLine();
		System.out.println("ENTER REQUEST DATE");
		Date dt= Date.valueOf(bfrd.readLine());
		
		TenderRequest tr = new TenderRequest(null, null, null, null, null, null);
		tr.setUsername(usrnm);
		tr.setTender_no(tndr_no);
		tr.setCompany_name(cmpny_name);
		tr.setContact_no(mbl_no);
		tr.setEstimated_tender_amount(estmt_amt);
		tr.setToday_Date(dt);
		
		ConnectionManager cmgr = new ConnectionManager();
		Connection con = cmgr.getConnection();
		String sql = "insert into tender_request values(?,?,?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, tr.getUsername());
		stmt.setString(2, tr.getTender_no());
		stmt.setString(3, tr.getCompany_name());
		stmt.setString(4, tr.getContact_no());
		stmt.setString(5, tr.getEstimated_tender_amount());
		stmt.setDate(6, tr.getToday_Date());
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next())
		{
			if(rs!=null)
			{
				System.out.println(" TENDER REQUEST SUCCESSFULLY POSTED ");
				System.out.println();
				System.out.println(" WAIT FOR APPROVAL WE WILL CONTACT YOU SHORTLY");
				System.out.println();
				System.out.println(" THANKS FOR VISTING OUR SITE ");
			}
			else
			{
				System.out.println(" SERVER PROBLEM ");
			}
		}
	}

}
