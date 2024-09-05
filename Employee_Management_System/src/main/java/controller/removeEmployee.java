package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.EmployeeDao;
import model.dto.Employee;

@WebServlet("/removeEmployee")
public class removeEmployee extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Employee emp = new Employee();
		EmployeeDao eDao = new EmployeeDao();
		
Integer id = Integer.parseInt(req.getParameter("id"));
		
		boolean isdeleted =eDao.removeEmployee(id);
		RequestDispatcher rd = req.getRequestDispatcher("viewAll_emp.jsp");
		
		if(isdeleted) {
			rd.forward(req, resp);
		}
		else {
			resp.getWriter().print("sorry");
		}
	}
}
