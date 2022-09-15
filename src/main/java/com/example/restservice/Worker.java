package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

public class Worker {
	
	private static AtomicLong idLong = new AtomicLong();
	
	private final String id;
	private final String name;
	private final String position;
	
	public Worker(String name, String position) {
		this.id = createID();
		this.name = name;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public String getPosition() {
		return position;
	}
	
	public String getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Рабочий №" + id +" (ФИО - " + name + ", должность - " + position + ")";
	}
	
	private static String createID() {
		return String.valueOf(idLong.getAndIncrement());
	}
}

