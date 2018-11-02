package com.springmvc.entry;

public class User {
	
	private int id;
	private String much;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMuch() {
		return much;
	}
	public void setMuch(String much) {
		this.much = much;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id+"=="+much;
	}

}
