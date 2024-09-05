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

@WebServlet("/emp_validate")
public class emp_validate extends HttpServlet {

	Employee emp = new Employee();
	Employee currentEmp = new Employee();
	EmployeeDao eDao = new EmployeeDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		Integer id = Integer.parseInt(req.getParameter("id"));
		String password = req.getParameter("password");
		
		PrintWriter pw = resp.getWriter();
		RequestDispatcher rd = req.getRequestDispatcher("emp_validate.jsp");

		
		
		emp.setId(id);
		emp.setPassword(password);
		
		if(eDao.empValidate(emp)) {
			resp.sendRedirect("emp_view.jsp");
			HttpSession session = req.getSession();
			session.setAttribute("id", id);
			
			currentEmp = eDao.viewEmplyee(id);
			
			req.setAttribute("id", currentEmp.getId());
			req.setAttribute("name", currentEmp.getName());
			req.setAttribute("salary", currentEmp.getSalary());
			req.setAttribute("phone", currentEmp.getPhone());
			req.setAttribute("password", currentEmp.getPassword());
			req.setAttribute("role", currentEmp.getRole());
			
		}
		else {
			rd.include(req, resp);
			pw.print("sorryy Wrong Id Password");
		}
	}
}
