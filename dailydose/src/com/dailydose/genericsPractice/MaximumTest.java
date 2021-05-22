package com.dailydose.genericsPractice;

public class MaximumTest {

//	determines the largest of three Comparable objects
	
	public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
		T max = x; // assume x is initially the largest
		
		if (y.compareTo(max) > 0) {
			max = y; // y is the largest so far
		}
		
		if (z.compareTo(max) > 0) {
			max = z; // z is the largest now
		}
		return max; // returns the largest object
	}
	
	public static void main(String[] args) {
//		System.out.println("Max of 4, 2, 5 is = " + maximum(4, 2, 5));
		System.out.println("Max of pear, apple, orange is = " + maximum("pear",
				"apple", "orange"));
	}
}
