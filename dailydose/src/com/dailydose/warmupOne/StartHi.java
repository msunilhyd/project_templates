package com.dailydose.warmupOne;

public class StartHi {

	public static void main(String[] args) {
		System.out.println(startHi("hi there"));
		System.out.println(startHi("hi"));
		System.out.println(startHi("hello hi"));
	}
	
	public static boolean startHi(String str) {
		
		if (str.matches("hi.*")) {
			return true;
		}
		return false;
	}
}
