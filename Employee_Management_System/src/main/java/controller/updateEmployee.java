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

@WebServlet("/updateEmployee")
public class updateEmployee extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Employee emp = new Employee();
		EmployeeDao eDao = new EmployeeDao();
		

		Integer id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		Double salary = Double.parseDouble(req.getParameter("salary"));
		Long phone = Long.parseLong(req.getParameter("phone"));
		String password = req.getParameter("name");
		String role = req.getParameter("role");
		
		
		RequestDispatcher rd = req.getRequestDispatcher("updateEmployee.jsp");
		req.setAttribute("id",id);
		req.setAttribute("name",name);
		req.setAttribute("salary", salary);
		req.setAttribute("phone", phone);
		req.setAttribute("password",password);
		req.setAttribute("role",role);
		
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(req.getParameter("newid"));
		String name = req.getParameter("newname");
		Double salary = Double.parseDouble(req.getParameter("newsalary"));
		Long phone = Long.parseLong(req.getParameter("newphone"));
		String password = req.getParameter("newpassword");
		String role = req.getParameter("newrole");
		
		
		
		Employee emp = new Employee(id,name,salary,phone,password,role);
		EmployeeDao eDao = new EmployeeDao();
		
		eDao.updateEmployees(emp);
		RequestDispatcher rd = req.getRequestDispatcher("viewAll_emp.jsp");
		rd.forward(req, resp);
	}
}
