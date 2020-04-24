package service;

import java.io.IOException;
import java.sql.SQLException;

import model.Admin;

public interface AdminDAOInterface {
	boolean AdminLogin(Admin admin) throws IOException, SQLException, Exception;
	
	void insert_tender(Admin admin) throws IOException, SQLException, Exception;
	boolean delete_tender(String tender_no) throws IOException, SQLException, Exception;

}
