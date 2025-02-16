package com.nit.Bank.Servlet;

import java.io.IOException;
import java.util.Random;

import com.nit.Bank.Bean.RegisterBean;
import com.nit.Bank.DAO.RegisterDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RegisterBean rb = new RegisterBean();
		Random r = new Random();
		long accno = r.nextLong(10000000, 99999999);
		rb.setAccno(accno);
		rb.setUname(req.getParameter("uname"));
		String fpwd = req.getParameter("pword");
		rb.setPword(fpwd);
		String spwd = req.getParameter("rpword");
		rb.setAmt(Float.parseFloat(req.getParameter("amt")));
		rb.setAdr(req.getParameter("adr"));
		rb.setContact(Long.parseLong(req.getParameter("phno")));
		if (fpwd.equals(spwd)) {
			int k = new RegisterDAO().register(rb);
			if (k > 0) {
				req.setAttribute("msg", "Registration Successfull!!!");
				req.getRequestDispatcher("Register.jsp").forward(req, res);
			} else {
				req.setAttribute("msg", "Registration Unsuccessfull!!!");
				req.getRequestDispatcher("RegisterFail.jsp").forward(req, res);
			}
		}

		else {
			req.setAttribute("msg", "Password doesn't match");
			req.getRequestDispatcher("RegisterFail.jsp").forward(req, res);
		}
	}
}
