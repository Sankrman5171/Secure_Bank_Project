package com.nit.Bank.Servlet;

import java.util.Random;

import jakarta.servlet.annotation.WebServlet;

//@SuppressWarnings("serial")
//@WebServlet("/dis")

public class A {
	public static void main(String[] args) {
		for(int i=1;i<11;i++) {
			
			
			Random r=new Random();
			long accno=r.nextLong(10000000,99999900);
			
		//long accno = (long) (Math.random()*10000000l);
		System.out.println(accno);
		}
	}
}
