package com.nit.Bank.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nit.Bank.Bean.RegisterBean;
import com.nit.GetConnection.GetConnection;

public class WithdrawDAO {

	int k = 0;

	public int withdraw(RegisterBean rb, double amt) {
		try {
			Connection con = GetConnection.getCon();
			PreparedStatement ps = con.prepareStatement("update ApanaBank set amt=amt-? where accno=?");
			ps.setDouble(1, amt);
			System.out.println(rb.getAccno());
			ps.setLong(2, rb.getAccno());
			k = ps.executeUpdate();
			System.out.println(k);
//			System.out.println("dao" +k);
//			System.out.println("DAO: "+rb);

//			System.out.println(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}

	public RegisterBean getNewData(RegisterBean rb) {
		try {
			Connection con = GetConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from ApanaBank where accno=?");
			ps.setLong(1, rb.getAccno());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				rb = new RegisterBean();
				rb.setAccno(rs.getLong(1));
				rb.setUname(rs.getString(2));
				rb.setPword(rs.getString(3));
				rb.setAmt(rs.getFloat(4));
				rb.setAdr(rs.getString(5));
				rb.setContact(rs.getLong(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rb;
	}
}