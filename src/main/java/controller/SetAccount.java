package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BankDao;
import dto.BankAccount;

@WebServlet("/setaccount")
public class SetAccount extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long accNo = Long.parseLong(req.getParameter("accNo"));
			
		req.getSession().setAttribute("accNo", accNo);
	
		req.getRequestDispatcher("AccountHome.html").include(req, resp);
	}
}
