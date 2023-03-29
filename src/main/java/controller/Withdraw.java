package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BankDao;
import dto.BankAccount;
import dto.BankTransaction;
import dto.Customer;

@WebServlet("/withdraw")
public class Withdraw extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Customer customer = (Customer) req.getSession().getAttribute("customer");

		if (customer == null) {
			resp.getWriter().print("<h1>Session Expired</h1");
			req.getRequestDispatcher("Login.html");

		} else {

			double amt = Double.parseDouble(req.getParameter("amt"));
			long accNo = (long) req.getSession().getAttribute("accNo");

			BankDao bankDao = new BankDao();
			BankAccount account = bankDao.find(accNo);
			if (amt > account.getAmount()) {
				resp.getWriter().print("<h1>Insufficient Balance</h1>");
				req.getRequestDispatcher("AccountHome.html").include(req, resp);
			} else {
				if (amt > account.getAccLimit()) {
					resp.getWriter().print("<h1>Out of limit enter amount within " + account.getAccLimit() + "</h1>");
					req.getRequestDispatcher("AccountHome.html").include(req, resp);
				} else {
					account.setAmount(account.getAmount() - amt);
					BankTransaction bankTransaction = new BankTransaction();
					bankTransaction.setDeposit(0);
					bankTransaction.setWithdraw(amt);
					bankTransaction.setBalance(account.getAmount());
					bankTransaction.setDateTime(LocalDateTime.now());

					List<BankTransaction> list = account.getBankTransactions();
					list.add(bankTransaction);

					account.setBankTransactions(list);
					bankDao.update(account);

					resp.getWriter().print("<h1>Amount withdraw Successfully</h1>");
					req.getRequestDispatcher("AccountHome.html").include(req, resp);
				}
			}
		}
	}
}
