package com.example.restservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	private static ArrayList<Worker> workerlist = new ArrayList<Worker>();

	@CrossOrigin
	@PostMapping("/add")
	public void add(@RequestBody Worker worker) {
		workerlist.add(worker);
		System.err.println(worker);
	}
	
	@CrossOrigin
	@PostMapping("/list")
	public ArrayList<String> list() {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < workerlist.size(); i++) {
			list.add(workerlist.get(i).toString());
		}
		
		return list;
	}
}
