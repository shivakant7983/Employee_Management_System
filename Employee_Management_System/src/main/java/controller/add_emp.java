package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.EmployeeDao;
import model.dto.Employee;

@WebServlet("/add_emp")
public class add_emp extends HttpServlet{
	
	Employee emp = new Employee();
	EmployeeDao eDao= new EmployeeDao();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		Double salary = Double.parseDouble(req.getParameter("salary"));
		Long phone = Long.parseLong(req.getParameter("phone"));
		String password = req.getParameter("password");
		String role = req.getParameter("role");
		
		
		emp.setId(id);
		emp.setName(name);
		emp.setSalary(salary);
		emp.setPhone(phone);
		emp.setPassword(password);
		emp.setRole(role);
		
		RequestDispatcher failed = req.getRequestDispatcher("add_emp.jsp");
		RequestDispatcher success = req.getRequestDispatcher("admin_function.jsp");
		PrintWriter pw = resp.getWriter();
		
		if(eDao.addEmployee(emp)) {
			req.setAttribute("message", "employee added successfully");
			success.forward(req, resp);
			
		}
		else {
			failed.include(req, resp);
			pw.print("employee with that id already exists");
		}
	}
}
