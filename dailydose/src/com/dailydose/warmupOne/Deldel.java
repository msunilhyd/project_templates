package com.dailydose.warmupOne;

public class Deldel {

	public static void main(String[] args) {
		System.out.println(delDel("adelbc"));
		System.out.println(delDel("adelHello"));
		System.out.println(delDel("adedbc"));
	}
	
	public static String delDel(String str) {
		
		if(str.length() > 3) {
		String s = str.substring(1, 4);
		if (s.equalsIgnoreCase("del"))
			return str.charAt(0) + str.substring(4, str.length());
		else 
			return str;
		}
		return str;
	}
}
