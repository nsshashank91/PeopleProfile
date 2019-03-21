package com.shash;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VehicleController {
	
	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	EmployeeService empService;
	

	@RequestMapping(value = "/addVehicle", method = RequestMethod.GET)
	public ModelAndView show() {
		ModelAndView model = new ModelAndView("addVehicle");
		List<Employee> employees = empService.getAllEmployees();
		model.addObject("veh", new Vehicle());
		model.addObject("employees",employees);
		return model;
	}

	@RequestMapping(value = "/addVehicle", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("veh") Vehicle veh) {

		vehicleService.insertVehicle(veh);
		List<Vehicle> vehicles = vehicleService.getAllVehicles();
		ModelAndView model = new ModelAndView("getVehicles");
		model.addObject("vehicles", vehicles);
		return model;
	}

	@RequestMapping("/getVehicles")
	public ModelAndView getAll() {
		List<Vehicle> vehicles = vehicleService.getAllVehicles();
		ModelAndView model = new ModelAndView("getVehicles");
		model.addObject("vehicles", vehicles);
		return model;
	}
	
	@RequestMapping(value="/updateVehicle/{id}")
	public ModelAndView updateForm(@PathVariable int id) {
		Optional<Vehicle> vehicle = vehicleService.getVehicleById(id);
		ModelAndView model = new ModelAndView("updateVehicle");
		model.addObject("veh", vehicle);
		List<Employee> employees = empService.getAllEmployees();
		model.addObject("employees",employees);
		return model;
	}
	
	@RequestMapping(value = "/updateVehicle", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("veh") Vehicle vehicle) {

		vehicleService.insertVehicle(vehicle);
		List<Vehicle> vehicles = vehicleService.getAllVehicles();
		ModelAndView model = new ModelAndView("getVehicles");
		model.addObject("vehicles", vehicles);
		return model;
	}
	
	@RequestMapping(value="/deleteVehicle/{id}")
	public ModelAndView delete(@PathVariable int id) {
		vehicleService.deleteVehicle(id);
		List<Vehicle> vehicles = vehicleService.getAllVehicles();
		ModelAndView model = new ModelAndView("getVehicles");
		model.addObject("vehicles", vehicles);
	
		return model;
	}

}
