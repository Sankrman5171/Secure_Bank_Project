package com.nit.Bank.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.nit.Bank.Bean.RegisterBean;
import com.nit.GetConnection.GetConnection;

public class RegisterDAO {
	int k=0;
	
	public int register(RegisterBean rb) {
		try {
			Connection con = GetConnection.getCon();
			PreparedStatement ps = con.prepareStatement("insert into ApanaBank values(?,?,?,?,?,?)");
			ps.setLong(1, rb.getAccno());
			ps.setString(2, rb.getUname());
			ps.setString(3, rb.getPword());
			ps.setFloat(4, rb.getAmt());
			ps.setString(5, rb.getAdr());
			ps.setLong(6, rb.getContact());
			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
