package com.hunglp.bmo.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hunglp.bmo.entity.City;
import com.hunglp.bmo.entity.Employee;
import com.hunglp.bmo.service.CityService;
import com.hunglp.bmo.service.RabbitMQSenderService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MainController {

	@Autowired
	RabbitMQSenderService rabbitMQSender;

	@Autowired
	CityService cityService;

	private static final Logger logger = (Logger) LogManager.getLogger(MainController.class);

	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("message", "hello");
		List<City> cities = new ArrayList<>();
		cityService.getAll().forEach(c -> cities.add(c));
		for (City city : cities) {
			System.out.println(city.get_id() + "_" + city.getName());
		}

		return "welcome";
	}

	@GetMapping("/bmo/api/v1/employees")
	public List<Employee> getAllEmployees() {
		List<Employee> temp = new ArrayList<Employee>();
		temp.add(new Employee("1", "2", "3"));

		return temp;
	}

	@GetMapping("/producer")
	public String sendMessage(Model model) {

		model.addAttribute("message", "hello");
		List<City> cities = new ArrayList<>();
		cityService.getAll().forEach(c -> cities.add(c));
		for (City city : cities) {
			rabbitMQSender.send(city);
		}
		System.out.println("send ok");
		logger.error("Oopss");
		return "welcome";
	}

}
