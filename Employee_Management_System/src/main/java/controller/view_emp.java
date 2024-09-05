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

@WebServlet("/view_emp")
public class view_emp extends HttpServlet{

	Employee emp = new Employee();
	EmployeeDao eDao = new EmployeeDao();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		PrintWriter pw = resp.getWriter();
		emp = eDao.viewEmplyee(id);
		RequestDispatcher rd = req.getRequestDispatcher("admin_function.jsp");
		
		if(emp!=null) {
			req.setAttribute("id", emp.getId());
			req.setAttribute("name", emp.getName());
			req.setAttribute("salary", emp.getSalary());
			req.setAttribute("phone", emp.getPhone());
			req.setAttribute("password", emp.getPassword());
			req.setAttribute("role", emp.getRole());
			
			rd.forward(req, resp);
			//Redirect to the specific section of the jsp page using anchor tag
			resp.sendRedirect(req.getContextPath() + "/admin_function.jsp#dataviewempsection");
		}
		else {
			pw.print("Sorry the id entered is wrong");
		}
	}
}
