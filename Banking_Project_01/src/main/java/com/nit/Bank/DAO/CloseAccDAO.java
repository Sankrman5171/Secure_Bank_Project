package com.nit.Bank.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.nit.Bank.Bean.RegisterBean;
import com.nit.GetConnection.GetConnection;

public class CloseAccDAO {
	int k = 0;

	public int closeAcc(RegisterBean rb) {
		try {
			Connection con = GetConnection.getCon();
			PreparedStatement ps = con.prepareStatement("delete from ApanaBAnk where accno=? and uname=? pword=?");
			ps.setLong(1, rb.getAccno());
			ps.setString(2, rb.getUname());
			ps.setString(3, rb.getPword());
			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}

}
