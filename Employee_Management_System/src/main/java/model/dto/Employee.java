package model.dto;

import java.util.Scanner;

public class Employee {

	private int id ;
	private String name ;
	private double Salary;
	private Long Phone ;
	private String password;
	private String role;
	
	Scanner sc = new Scanner(System.in);

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String name, double salary, Long phone, String password, String role) {
		super();
		this.id = id;
		this.name = name;
		Salary = salary;
		Phone = phone;
		this.password = password;
		this.role = role;
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return Salary;
	}

	public void setSalary(double salary) {
		Salary = salary;
	}

	public Long getPhone() {
		return Phone;
	}

	public void setPhone(Long phone) {
		Phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", Salary=" + Salary + ", Phone=" + Phone + ", password="
				+ password + ", role=" + role + "]";
	}
	
	
}
