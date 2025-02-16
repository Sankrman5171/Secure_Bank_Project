package com.nit.Bank.Bean;



public class RegisterBean {
	private String uname,pword,adr;
	private long accno, phno;
	private float amt;
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	public String getPword() {
		return pword;
	}
	public void setPword(String pword) {
		this.pword = pword;
	}
	
	public String getAdr() {
		return adr;
	}
	public void setAdr(String adr) {
		this.adr = adr;
	}
	
	public long getAccno() {
		return accno;
	}
	public void setAccno(long accno) {
		this.accno = accno;
	}
	
	public long getContact() {
		return phno;
	}
	public void setContact(long phno) {
		this.phno = phno;
	}
	
	public float getAmt() {
		return amt;
	}
	public void setAmt(float amt) {
		this.amt = amt;
	}
	
	@Override
	public String toString() {
		return "RegisterBean [uname=" + uname + ", pword=" + pword + ", adr=" + adr + ", accno=" + accno + ", phno="
				+ phno + ", amt=" + amt + "]";
	}
}

