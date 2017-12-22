package com.overload;

import java.util.Arrays;
import java.util.List;

public class Test {
	
	public static void main(String[] args) {
		
		String[] str = new String[] { "you", "wu" }; 
		List list = Arrays.asList(str);
		
		list.add("123");
		System.out.println(list.size());
	}
	
}	
