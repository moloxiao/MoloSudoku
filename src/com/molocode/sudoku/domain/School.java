package com.molocode.sudoku.domain;

public class School {
	private int id;
	private String name;
	private String location;
	private boolean privateSchool;

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isPrivateSchool() {
		return privateSchool;
	}

	public void setPrivateSchool(boolean privateSchool) {
		this.privateSchool = privateSchool;
	}

}
