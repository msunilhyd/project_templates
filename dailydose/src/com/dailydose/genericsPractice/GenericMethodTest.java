package com.dailydose.genericsPractice;

import java.util.Arrays;
import java.util.Comparator;

public class GenericMethodTest<T extends Comparable<T>>{

	// generic method printArray
	public static <T> void printArray(T[] inputArray, T key) {
		// Display array elements
		for (T element: inputArray) {
			System.out.printf("%s ", element);
		}
		System.out.println();
		
		Arrays.sort(inputArray);
		System.out.printf("Sorted arr[] is : %s", Arrays.toString(inputArray));
		System.out.println();
		System.out.println("Passed key to search for is = "+ key.toString());
		int index = search(inputArray, key);
		
		System.out.println("present is " + index);
		
	}
	
	public static <T> int search(T[] a, Comparable<T> v) {
		
		int low = 0;
		int high = a.length - 1;
		
		while (low <= high) {
			int mid = (low + high) / 2;
			T midVal = a[mid];
			System.out.println("midVal is " + midVal.toString());
			int result = v.compareTo(midVal);
			System.out.println(result);
			if (result < 0) 
				high = mid-1;
			else if (result > 0) 
				low = mid + 1;
			else 
				return mid;
		}
		return -1;
	}
	
	public static void main(String[] args) {
//		Create arrays of Integer, Double and Character
		Integer[] intArray = { 1, 2, 3, 4, 5};
		Double[] doubleArray = {1.1, 2.2, 3.5, 5.6};
		Character[] charArray = {'H', 'E', 'L', 'L', 'O'};
		
		System.out.println("Array intergerArray contains:");
		printArray(intArray, 0); // Pass an integer Array
		
//		System.out.println("\nArray double Array contains:");
//		printArray(doubleArray, 2.2);
		
//		System.out.println("\nArray characterArray contains:");
//		printArray(charArray, 'O');
	}
}
