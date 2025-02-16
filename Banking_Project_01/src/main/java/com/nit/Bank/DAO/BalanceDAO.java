package com.nit.Bank.DAO;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nit.Bank.Bean.RegisterBean;
import com.nit.GetConnection.GetConnection;

public class BalanceDAO {
	RegisterBean rb1 = null;
	public RegisterBean balance(Long accno) {
		try {
			Connection con = GetConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from ApanaBank where accno=?");
			ps.setLong(1, accno);
			 ResultSet rs = ps.executeQuery();
			 if(rs.next()) {
				 rb1 =  new RegisterBean();
				 rb1.setAccno(rs.getLong(1));
				 rb1.setUname(rs.getString(2));
				 rb1.setPword(rs.getString(3));
				 rb1.setAmt(rs.getFloat(4));
				 rb1.setAdr(rs.getString(5));
				 rb1.setContact(rs.getLong(6));
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rb1;
	}

}

