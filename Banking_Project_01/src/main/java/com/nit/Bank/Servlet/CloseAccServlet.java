package com.nit.Bank.Servlet;

import java.io.IOException;

import com.nit.Bank.Bean.RegisterBean;
import com.nit.Bank.DAO.CloseAccDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CloseAcc")
public class CloseAccServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		CloseAccDAO cdao = new CloseAccDAO();
		RegisterBean rb = new RegisterBean();
		rb.setAccno(Long.parseLong(req.getParameter("accno")));
		rb.setUname(req.getParameter("uname"));
		rb.setPword(req.getParameter("pword"));
		int k =cdao.closeAcc(rb);
		if (k>1) {
			
			req.setAttribute("bean", rb);
			req.getRequestDispatcher("CloseAcc.jsp").forward(req, res);
		} else {
			req.setAttribute("msg", "Invalid details.");
			req.getRequestDispatcher("CloseAccFail.jsp").forward(req, res);
		}

	}

}
