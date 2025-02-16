package com.nit.Bank.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import com.nit.Bank.Bean.RegisterBean;
import com.nit.Bank.DAO.CheckDAO;
import com.nit.Bank.DAO.TransferDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/transfer")
public class TransferServlet extends HttpServlet {
	double amt1;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		TransferDAO tdao = new TransferDAO();
		RegisterBean rb1 = new RegisterBean();
		RegisterBean rb2 = new RegisterBean();
		rb1.setAccno(Long.parseLong(req.getParameter("accno")));
		rb1.setUname(req.getParameter("uname"));

		rb1.setPword(req.getParameter("pword"));
		rb2.setAccno(Long.parseLong(req.getParameter("acc2")));
		Double bal = null, bal1 = null;
		Double amt = Double.parseDouble(req.getParameter("amt"));
		try {
			bal = new CheckDAO().checking(rb1);
			bal1 = new CheckDAO().checkAcc(rb2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(rb1);
		System.out.println(rb2);

		if (amt >= 0) {
			if (bal != null) {
				if (bal1 != null) {
					if (bal >= amt) {
						int a = tdao.WithdrawFromAcc1(rb1, amt);
						int k = tdao.transferToAcc2(rb2, amt);
						try {
							amt1 = tdao.checkRecBal(rb2.getAccno());
						} catch (SQLException e) {
							e.printStackTrace();
						}
						if (k > 0 && a > 0) {
							req.setAttribute("msg", "Amount transfered successfully<br>");
							req.setAttribute("amt", amt1);
							req.setAttribute("bal", amt);
							req.getRequestDispatcher("Transfer.jsp").forward(req, res);
//						tarnsfer sucess

						} else {
							req.setAttribute("msg", "transfer fail...");
							req.getRequestDispatcher("Failed.jsp").forward(req, res);
//						tarnsfer failed 
						}
					} else {
						req.setAttribute("msg", "Insufficient balance...");
						req.getRequestDispatcher("Transfer.jsp").forward(req, res);
//					Insufficent balance
					}
				} else {
					req.setAttribute("msg", "Receiver's account number is wrong...");
					req.getRequestDispatcher("Transfer.jsp").forward(req, res);
//					recervers details wrong
				}
			} else {
				req.setAttribute("msg", "Sender's account number is wrong...");
				req.getRequestDispatcher("Transfer.jsp").forward(req, res);
//				Senders details wrong
			}

		} else {
			req.setAttribute("msg", "negative amount.....");
			req.getRequestDispatcher("Transfer.jsp").forward(req, res);
//			negative balance
		}

//		if (amt >= 0) {
//			if (bal >= amt) {
//				int k = tdao.WithdrawFromAcc1(rb1, amt);
//				if(bal1 != null) {
//				int a = tdao.transferToAcc2(rb2, amt);
//				System.out.println(k);
//				System.out.println(a);
//				
//				if (k > 0 && a > 0) {
//					req.setAttribute("msg", "Amount transfered successfully<br>");
//					req.setAttribute("bean", rb1);
//					req.getRequestDispatcher("Transfer.jsp").forward(req, res);
//				}else {
//					req.setAttribute("msg", "Receiver's account number is wrong...");
//					req.getRequestDispatcher("TransferFail.jsp").forward(req, res);
//				}
//				} else {
//					req.setAttribute("msg", "transfer fail...");
//					req.getRequestDispatcher("Failed.jsp").forward(req, res);
//				}
//
//			} else {
//				req.setAttribute("msg", "Insufficienr balance...");
//				req.getRequestDispatcher("TransferFail.jsp").forward(req, res);
//			}
//		} else {
//			req.setAttribute("msg", "negative amount.....");
//			req.getRequestDispatcher("TransferFail.jsp").forward(req, res);
//		}

	}

}
