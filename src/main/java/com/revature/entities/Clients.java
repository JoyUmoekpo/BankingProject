package com.revature.entities;

public class Clients {
	private int id;
	private String name;

	public Clients() {
		super();
	}

	public Clients(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Clients "
				+ "[id=" + id + 
				", name=" + name +				
				"]";
	}

}