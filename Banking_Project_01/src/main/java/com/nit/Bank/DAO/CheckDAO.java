package com.nit.Bank.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nit.Bank.Bean.RegisterBean;
import com.nit.GetConnection.GetConnection;

public class CheckDAO {

	public Double checking(RegisterBean rb) throws SQLException {
		Double bal = null;
		Connection con = GetConnection.getCon();
		PreparedStatement ps = con.prepareStatement("select amt from ApanaBank where accno=? and uname=? and pword=?");
		ps.setLong(1, rb.getAccno());
		ps.setString(2, rb.getUname());
		ps.setString(3, rb.getPword());

		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			bal = rs.getDouble(1);
		}

		return bal;
	}

	public Double checkAcc(RegisterBean rb) throws SQLException {
		Double bal1 = null;
		Connection con = GetConnection.getCon();
		PreparedStatement ps = con.prepareStatement("select amt from ApanaBank where accno=?");
		ps.setLong(1, rb.getAccno());

		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			bal1 = rs.getDouble(1);
		}
		return bal1;
	}

}
