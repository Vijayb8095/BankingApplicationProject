package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BankAccount;
import dto.Customer;

@WebServlet("/fetchactiveaccount")
public class FetchActiveAccount extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Customer customer = (Customer) req.getSession().getAttribute("customer");

		if (customer == null) {
			resp.getWriter().print("<h1>Session Expired</h1");
			req.getRequestDispatcher("Login.html");

		} else {
			List<BankAccount> list = customer.getAccounts();

			List<BankAccount> list2 = new ArrayList<>();

			for (BankAccount bankAccount : list) {

				if (bankAccount.isStatus()) {
					list2.add(bankAccount);
				}

			}

			req.setAttribute("list2", list2);
			req.getRequestDispatcher("Accounts.jsp").include(req, resp);

		}

	}

}
