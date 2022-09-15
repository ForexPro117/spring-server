package com.example.restservice;
import java.util.ArrayList;

public class Greeting {

	private static ArrayList<String[]> Workers = new ArrayList<String[]>();
	
	private final long id;
	private final String worker;
	private final String position;

	public Greeting() {
		this.id = 1;
		this.worker = "";
		this.position = "";
	}
	
	public Greeting(long id, String content, String position) {
		this.id = id;
		this.worker = content;
		this.position = position;
		
		Workers.add(new String[] {Long.toString(id), worker, position});
	}

	public long getId() {
		return id;
	}

	public String getWorker() {
		return worker;
	}

	public String getPosition() {
		return position;
	}
}
