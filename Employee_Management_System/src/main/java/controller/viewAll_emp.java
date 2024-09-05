package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.EmployeeDao;
import model.dto.Employee;

@WebServlet("/viewAll_emp")
public class viewAll_emp extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Employee emp = new Employee();
		EmployeeDao eDao = new EmployeeDao();
		
		 List<Employee> allEmployees=eDao.viewAllEmployee();
		 
		 RequestDispatcher rd = req.getRequestDispatcher("viewAll_emp.jsp");
		 RequestDispatcher rdFail = req.getRequestDispatcher("admin_function.jsp");
		 PrintWriter pw = resp.getWriter();

		 if(allEmployees!=null) {
		 	req.setAttribute("allEmployees", allEmployees);
		 		
		 	rd.forward(req, resp);
		 }
		 else {
			 rdFail.include(req, resp);
			 pw.print("Sorry no info is presneted");
		 }
	}
}
