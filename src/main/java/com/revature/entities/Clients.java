package com.revature.entities;

public class Clients {
	private int id;
	private String name;
	private int acc_num;
	
	public Clients() {
		super();
	}

	public Clients(int id, String name, int acc_num) {
		super();
		this.id = id;
		this.name = name;
		this.acc_num = acc_num;
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

	public int getAcc_num() {
		return acc_num;
	}

	public void setAcc_num(int acc_num) {
		this.acc_num = acc_num;
	}

	@Override
	public String toString() {
		return "Clients [id=" + id + 
				", name=" + name + 
				", acc_num=" + acc_num + 
				", toString()=" + 
				super.toString()
				+ "]";
	}
		
}