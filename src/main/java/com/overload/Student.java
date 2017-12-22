package com.overload;

public class Student extends User{
	
	private String nianji;
	private String banji;
	
	
	@Override
	public void getUser(String name) {
		// TODO Auto-generated method stub
		System.out.println("i am student");
	}

	public String getNianji() {
		return nianji;
	}

	public void setNianji(String nianji) {
		this.nianji = nianji;
	}

	public String getBanji() {
		return banji;
	}

	public void setBanji(String banji) {
		this.banji = banji;
	}
	
	
}
