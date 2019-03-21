package com.shash;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



 


@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empId;
	
	@Size(min=2, message="{name.notempty}")
	private String empName;
	
	//@NotNull(message="Phone cannot be empty")
	//@Pattern(regexp="\\d{3}",message="Invalid phone")
	@Phone
	private String phone;
	
	//@OneToMany(mappedBy="employee",cascade=CascadeType.ALL)
	//@JsonIgnoreProperties
	//@ManyToMany(mappedBy="employees",cascade=CascadeType.ALL)
	//@JsonIgnoreProperties("employee")
	//private List<Vehicle> vehicles= new ArrayList<>();
	

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", phone=" + phone + "]";
	}

	
	

}