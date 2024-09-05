package model.dao;

import java.sql.Statement;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import model.Exceptions.DuplicatedException;
import model.dto.Employee;

public class EmployeeDao {


	FileInputStream fis;
	Properties property = new Properties();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	List<Employee> employees;
	Statement stm;
	{
	
	try {
		fis = new FileInputStream("D:\\Employee_Management_System\\Employee_Management_System\\db_config.properties");
		
		property.load(fis);
		
		String driverPath = property.getProperty("driver");
		
		//setp1 load the driver
		Class.forName(driverPath);
		
		String url = property.getProperty("url");
		
		//providing the connection
		con = DriverManager.getConnection(url , property);
		System.out.println("Connection Establish");
		
		stm = con.createStatement();
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}//end of initializer
	
	// Admin Validate 
	public boolean adminvalidate(Employee emp) {
		String Query = "select password , role from employee where id = ? ";
		try {
			ps = con.prepareStatement(Query);
			ps.setInt(1, emp.getId());
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				if(emp.getPassword().equals(rs.getString(1)) && rs.getString(2).equalsIgnoreCase("Admin")) {
					return true;
				}
				else {
					return false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	// employee validate
	public boolean empValidate(Employee emp) {
		String Query = "select password from employee where id = ?";
		try {
			ps = con.prepareStatement(Query);
			ps.setInt(1, emp.getId());
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				if(emp.getPassword().equals(rs.getString(1))) {
					return true;
				}
				else {
					return false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean isDuplicateID(int id) {
		String query = "select * from employee where id = ?";
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean addEmployee(Employee emp) {
		String query = "insert into employee values(?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, emp.getId());
			ps.setString(2, emp.getName());
			ps.setDouble(3, emp.getSalary());
			ps.setLong(4, emp.getPhone());
			ps.setString(5, emp.getPassword());
			ps.setString(6, emp.getRole());
			
			if(ps.executeUpdate()>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			if(e.getMessage().contains("duplicate key value violates unique constraint")) {
				try {
					throw new DuplicatedException("This id is already presnet in the table");
				}catch (DuplicatedException d) {
					   System.out.println(d.getMessage());
				}
			}
		}
		return false;
		
	}
	
	public boolean removeEmployee(int id)  {
		String query = "delete from employee where id = ? ";
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			
			if(ps.executeUpdate()>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public Employee viewEmplyee(int id) {
		String query = "select * from employee where id = ?";
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs= ps.executeQuery();
			if(rs.next()) {
				return new Employee(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getLong(4),rs.getString(5),rs.getString(6));
			}
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Employee> viewAllEmployee(){
		employees = new ArrayList<Employee>();
		String query = "select * from employee";
		
		try {
			rs = stm.executeQuery(query);
			if(rs.next()) {
				do {
					employees.add(new Employee(rs.getInt(1) , rs.getString(2), rs.getDouble(3) , rs.getLong(4),rs.getString(5) , rs.getString(6)));
				}while(rs.next());
				return employees;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return null;
		
	}
	
	// update all employee by admin
	public boolean updateEmployees(Employee emp) {
		String query = "update employee set name = ? , salary = ? , phone = ? , password = ? , role = ? where id = ? ";
		try {
			ps= con.prepareStatement(query);
			ps.setString(1, emp.getName());
			ps.setDouble(2,emp.getSalary());
			ps.setLong(3, emp.getPhone());
			ps.setString(4, emp.getPassword());
			ps.setString(5,emp.getRole());
			ps.setInt(6,emp.getId());
			
			if(ps.executeUpdate()>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	// update employee by employee
	public boolean updateEmp(Employee emp) {
		String query = "update employee phone =? ,password = ? where id = ?";
		try {
			ps= con.prepareStatement(query);
			ps.setLong(1, emp.getPhone());
			ps.setString(2, emp.getPassword());
			ps.setInt(3,emp.getId());
			
			if(ps.executeUpdate()>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public static void main(String[] args) {
		EmployeeDao e = new EmployeeDao();
		
	}
}
