package com.dailydose.genericsPractice;

public class GenericMethodClass {

//	generic method printArray
	public static <E> void printArray(E[] inputArray) {
//		Display array elements
		for (E element: inputArray) {
			System.out.printf("%s ", element);
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
//		Create arrays of Integer and Character
		Integer[] intArray = {1, 2, 4, 8, 0};
		Character[] charArray = {'c', 'n', 'v', 'b'};
		printArray(intArray);
		printArray(charArray);
	}
}
