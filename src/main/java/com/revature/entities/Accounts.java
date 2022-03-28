package com.revature.entities;

public class Accounts {
	private int id;
	private int bal;

	public Accounts() {
		super();
	}

	public Accounts(int id, int bal) {
		super();
		this.id = id;
		this.bal = bal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBal() {
		return bal;
	}

	public void setBal(int bal) {
		this.bal = bal;
	}

	@Override
	public String toString() {
		return "Accounts [id=" + id + 
				", bal=" + bal + ", toString()=" + 
				super.toString() + "]";
	}

};