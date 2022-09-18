package com.example.restservice;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
		System.err.println(worker);
	}

	@GetMapping("/get")
	public ArrayList<Worker> getWorkers() {
		return list;
	}
	
	@DeleteMapping("/delete/{uuid}")
	public void deleteWorker(@PathVariable UUID uuid) {
		Worker worker = list.stream().filter(t -> t.getUuid().equals(uuid)).findFirst()
				.orElseThrow(() -> new RuntimeException("not found"));
		list.remove(worker);
		System.err.println(worker);
	}
	
	@PostMapping("/edit")
	public void editWorker(@RequestBody Worker worker) {
		UUID uuid = worker.getUuid();
		for (Worker workerOld:list) {
			if (workerOld.getUuid().equals(uuid) ) {
				workerOld.setName(worker.getName());
				workerOld.setPosition(worker.getPosition());
			}
		}
	}
}
