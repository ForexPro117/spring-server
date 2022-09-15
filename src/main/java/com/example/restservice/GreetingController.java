package com.example.restservice;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class GreetingController {

	private static ArrayList<Worker> map = new ArrayList<Worker>();

	@PostMapping("/add")
	public void addWorker(@RequestBody Worker worker) {
		worker.setUuid(UUID.randomUUID());
		map.add(worker);
		System.err.println(worker);
	}

	@GetMapping("/get")
	public ArrayList<Worker> getWorkers() {
		return map;
	}
}
