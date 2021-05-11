package com.dailydose.may;

public class ReverseOfAString {

	public static void main(String[] args) {
		
		String str = "sunil";
		String reversedStr = "";
		for (int i=str.length()-1; i >=0; i--)
		{
			reversedStr += str.charAt(i);
		}
		
		System.out.println("Reversed string is = " + reversedStr);
	}
}
