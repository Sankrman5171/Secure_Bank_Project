package com.nit.Bank.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import com.nit.Bank.Bean.RegisterBean;
import com.nit.Bank.DAO.CheckDAO;
import com.nit.Bank.DAO.DepositDAO;
import com.nit.Bank.DAO.WithdrawDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/deposit")
public class DepositServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		DepositDAO ddao = new DepositDAO();
		RegisterBean rb = new RegisterBean();
		rb.setAccno(Long.parseLong(req.getParameter("accno")));
		Double bal = null;
		double amt = Float.parseFloat(req.getParameter("amt"));
		try {
			bal = new CheckDAO().checking(rb);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (amt >= 0) {
			if (bal != null) {
				int k = ddao.deposit(rb, amt);
				rb = ddao.getNewData(rb);
				System.out.println(rb);
				if (k > 0) {
					req.setAttribute("msg", "Amount deposited successfully<br>");
					req.setAttribute("bean", rb);
					req.getRequestDispatcher("Deposit.jsp").forward(req, res);
				} else {
					req.setAttribute("msg", "withdraw fail...");
					req.getRequestDispatcher("Failed.jsp").forward(req, res);
				}

			} else {
				req.setAttribute("msg", "accno wrong...");
				req.getRequestDispatcher("DepositFail.jsp").forward(req, res);
			}
		} else {
			req.setAttribute("msg", "negative amount.....");
			req.getRequestDispatcher("DepositFail.jsp").forward(req, res);
		}
	}
}
