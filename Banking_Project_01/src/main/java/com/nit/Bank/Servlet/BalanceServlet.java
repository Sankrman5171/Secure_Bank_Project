package com.nit.Bank.Servlet;

import java.io.IOException;

import com.nit.Bank.Bean.RegisterBean;
import com.nit.Bank.DAO.BalanceDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/balance")

public class BalanceServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		BalanceDAO ddao = new BalanceDAO();
		RegisterBean rb = new RegisterBean();
		rb = ddao.balance(Long.parseLong(req.getParameter("accno")));
//		System.out.println(rb);
		if (rb != null) {
			req.setAttribute("bean", rb);
			req.getRequestDispatcher("Balance.jsp").forward(req, res);
		} else {
			req.setAttribute("msg", "Invalid details.");
			req.getRequestDispatcher("BalanceFail.jsp").forward(req, res);
		}

	}

}
