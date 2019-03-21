package com.shash;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	JdbcUserDetailsManager jdbcUserDetailsManager;
	

	
	@RequestMapping("/")
	public ModelAndView welcome() {
		System.out.println("root /");
		return new ModelAndView("welcome");
	}

	@RequestMapping("/welcome")
	public ModelAndView firstPage() {
		return new ModelAndView("welcome");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		return new ModelAndView("registration", "user", new UserRegistration());
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView processRegister(@ModelAttribute("user") UserRegistration userRegistrationObject) {
		
		// authorities to be granted
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		String encodedPassword = bCryptPasswordEncoder.encode(userRegistrationObject.getPassword());

		User user = new User(userRegistrationObject.getUsername(), encodedPassword, authorities);
		
		jdbcUserDetailsManager.createUser(user);
		return new ModelAndView("redirect:/welcome");
	}
	
	@RequestMapping(value = "/addNewEmployee", method = RequestMethod.GET)
	public ModelAndView show(Employee e) {
		List<Vehicle> vehicles = vehicleService.getAllVehicles();
		ModelAndView model = new ModelAndView("addEmployee");
		model.addObject("emp", new Employee());
		model.addObject("vehicles", vehicles);
		return model;

	}

	@RequestMapping(value = "/addNewEmployee", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("emp") @Valid  Employee emp, BindingResult result) {
		
		if(result.hasErrors()) {
			ModelAndView model = new ModelAndView("addEmployee");
			model.addObject("emp", emp);
			
			return model;
		}

		employeeService.insertEmployee(emp);
		List<Employee> employees = employeeService.getAllEmployees();
		ModelAndView model = new ModelAndView("getEmployees");
		model.addObject("employees", employees);
		return model;
	}

	@RequestMapping("/getEmployees")
	public ModelAndView getEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();
		ModelAndView model = new ModelAndView("getEmployees");
		model.addObject("employees", employees);
		return model;
	}
	
	@RequestMapping(value="/updateEmployee/{id}")
	public ModelAndView updateForm(@PathVariable int id) {
		Optional<Employee> employee = employeeService.getEmployeeById(id);
		ModelAndView model = new ModelAndView("UpdateEmployee");
		List<Vehicle> vehicles = vehicleService.getAllVehicles();
		model.addObject("emp", employee);
		model.addObject("vehicles", vehicles);
		return model;
	}
	
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public ModelAndView updateEmployee(@ModelAttribute("emp") Employee emp) {

		employeeService.insertEmployee(emp);
		List<Employee> employees = employeeService.getAllEmployees();
		ModelAndView model = new ModelAndView("getEmployees");
		model.addObject("employees", employees);
		return model;
	}
	
	@RequestMapping(value="/deleteEmployee/{id}")
	public ModelAndView deleteEmployee(@PathVariable int id) {
		employeeService.deleteEmployee(id);
		List<Employee> employees = employeeService.getAllEmployees();
		ModelAndView model = new ModelAndView("getEmployees");
		model.addObject("employees", employees);
		return model;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("errorMsg", "Your username and password are invalid.");

		if (logout != null)
			model.addAttribute("msg", "You have been logged out successfully.");

		return "login";
	}


}
