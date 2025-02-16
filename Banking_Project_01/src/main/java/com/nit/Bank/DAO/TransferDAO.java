package com.nit.Bank.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nit.Bank.Bean.RegisterBean;
import com.nit.GetConnection.GetConnection;

public class TransferDAO {

	int k = 0, a = 0;

	public int WithdrawFromAcc1(RegisterBean rb, double amt) {
		try {
			Connection con = GetConnection.getCon();
			PreparedStatement ps = con
					.prepareStatement("update ApanaBank set amt=amt-? where accno=? and uname=? and pword=?");
			ps.setDouble(1, amt);
			ps.setLong(2, rb.getAccno());
			ps.setString(3, rb.getUname());
			ps.setString(4, rb.getPword());
			System.out.println(rb.getAccno());
			k = ps.executeUpdate();
			System.out.println(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}

	public Double checkRecBal(long acc) throws SQLException {
		Double bal1 = null;
		Connection con = GetConnection.getCon();
		PreparedStatement ps = con.prepareStatement("select amt from ApanaBank where accno=?");
		ps.setLong(1, acc);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			bal1 = rs.getDouble(1);
		}
		return bal1;
	}

	public int transferToAcc2(RegisterBean rb, double amt) {
		try {
			Connection con = GetConnection.getCon();
			PreparedStatement ps = con.prepareStatement("update ApanaBank set amt=amt+? where accno=?");
			ps.setDouble(1, amt);
			System.out.println(rb.getAccno());
			ps.setLong(2, rb.getAccno());
			a = ps.executeUpdate();
			System.out.println(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

}
