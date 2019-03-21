package com.shash;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

	@Autowired
	VehicleDao vehicleDao;
	
	public void insertVehicle(Vehicle vehicle) {
		vehicleDao.save(vehicle);
	}
	
	public List<Vehicle> getAllVehicles() {
		List<Vehicle> vehicles = new ArrayList<>();
		vehicleDao.findAll().forEach(vehicles::add);
		return vehicles;
	}

	public Optional<Vehicle> getVehicleById(int id) {
		Optional<Vehicle> vehicle = vehicleDao.findById(id);
		return vehicle;
	}
	
	public void deleteVehicle(int id) {
		vehicleDao.deleteById(id);
	}
	
}
