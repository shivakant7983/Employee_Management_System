package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.EmployeeDao;
import model.dto.Employee;

@WebServlet("/admin_validate")
public class admin_validate extends HttpServlet {
	
	Employee emp = new Employee();
	EmployeeDao eDao = new EmployeeDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String password = req.getParameter("password");
		
		PrintWriter pw = resp.getWriter();
		RequestDispatcher rd = req.getRequestDispatcher("admin_validate.jsp");
		
		emp.setId(id);
		emp.setPassword(password);
		
		if(eDao.adminvalidate(emp)) {
			resp.sendRedirect("admin_function.jsp");
			HttpSession session = req.getSession();
			session.setAttribute("id", id);
		}
		else {
			rd.include(req, resp);
			pw.print("sorry wrong Id , password");
		}
	}
}
