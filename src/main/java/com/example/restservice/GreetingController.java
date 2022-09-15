package com.example.restservice;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class GreetingController {

	private static ArrayList<Worker> list = new ArrayList<Worker>();

	@PostMapping("/add")
	public void addWorker(@RequestBody Worker worker) {
		worker.setUuid(UUID.randomUUID());
		list.add(worker);
//		System.err.println(worker);
	}

	@GetMapping("/get")
	public ArrayList<Worker> getWorkers() {
		return list;
	}

	@GetMapping("/get/{uuid}")
	public Worker getWorker(@PathVariable UUID uuid) {
		Worker worker = list.stream().filter(t -> t.getUuid().equals(uuid)).findFirst()
				.orElseThrow(() -> new RuntimeException("not found"));
		System.err.println(worker);
		return worker;
	}
}
