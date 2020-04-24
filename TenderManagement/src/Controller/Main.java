package Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.AdminDAO;
import service.SendSMS;
import dao.TenderRequestDAO;
import dao.UserDAO;
import model.Admin;
import model.TenderRequest;
import model.Tender_Authority;
import model.User;
import utility.ConnectionManager;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, Exception {
		User us=new User(null, null, null, null, null);
		UserDAO usd=new UserDAO();
		System.out.println("WELCOME TO GOODLUCK PROPERTIES");
		System.out.println("Enter the option to explore");
		System.out.println("1.New User Registration");
		System.out.println("2.User Login");
		System.out.println("3.Admin Login");
		System.out.println("4.Tender Authority Login");
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int choice=Integer.parseInt(bf.readLine());
		switch(choice) {
		case 1:
			usd.NewUser(us);
			break;
		case 2:
			usd.Userlogin(us);
			break;
		case 3:
			AdminDAO addao=new AdminDAO();
			Admin ad=new Admin(null, null, null);
			addao.AdminLogin(ad);
			break;
		case 4:
			UserDAO usdao = new UserDAO();
			TenderRequest trt=new TenderRequest(null, null, null, null, null, null);
			Tender_Authority tndr_autry = new Tender_Authority(null, null);
			usdao.Authoritylogin(tndr_autry);
			UserDAO usrdao1 = new UserDAO();
			System.out.println();
			System.out.println("TENDER REQUEST DETAILS FROM USER");
			System.out.println();
			usrdao1.selectallrequest();
			System.out.println("Enter the tendor no which you want to Accept");
			String a=bf.readLine();
			ConnectionManager cmgr = new ConnectionManager();
			Connection con = cmgr.getConnection();
			trt.setTender_no(a);
			String sql = "select contact_no from tender_request where tender_no=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(3, a);
			
			ResultSet rs=stmt.executeQuery();
			if(rs.next())
			{
				String phone=rs.getString(4);
				service.SendSMS sms = new service.SendSMS();
				sms.sendSms(phone);
			}
			
			break;
		default:
			System.out.println("Invaild Access");
			
		}
		
		
		
	}

}
