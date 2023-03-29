package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BankDao;
import dto.BankAccount;

@WebServlet("/changestatus")
public class ChangeAccountStatus extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		long accNo = Long.parseLong(req.getParameter("accNo"));

		BankDao bankDao = new BankDao();
		BankAccount bankAcc=bankDao.find(accNo);
		
		if(bankAcc.isStatus()) {
			bankAcc.setStatus(false);
		}
		else {
			bankAcc.setStatus(true);
		}
		
		bankDao.update(bankAcc);
		
		resp.getWriter().print("<h1>Update Success</h1>");
		req.setAttribute("list", bankDao.fetchAll());
		req.getRequestDispatcher("AdminHome.jsp").include(req, resp);
	}
}
