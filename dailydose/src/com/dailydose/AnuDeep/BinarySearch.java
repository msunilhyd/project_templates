package com.dailydose.AnuDeep;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		Random random = new Random();

		int[] intList = new int[100];

		System.out.println("Array of random integers, size=100");
		for (int i=0;i<10;i++) {
			
			intList[i] = random.nextInt(10) + 0;
			System.out.print(intList[i] + ", ");
		}

		System.out.println();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input an integer");
		int input = sc.nextInt();
		System.out.println(input);
		
		String[] words = {"Alpha", "Bravo", "Charlie", "Delta", "Echo", 
	            "Foxtrot", "Golf", "Hotel", "India", "Juliet", "Kilo", "Lima", 
	            "Mike", "November", "Oscar", "Papa", "Quebec", "Romeo", 
	            "Sierra", "Tango", "Uniform", "Victor", "Whiskey", "X-Ray", 
	            "Yankee", "Zulu"};
	        BinarySearchClass<String> searcher = new BinarySearchClass<String>(words);
	        System.out.println(searcher.search("November"));
	        System.out.println("Expected: 13");
	        System.out.println(searcher.search("October"));
	        System.out.println("Expected: -1");
	}
}

class BinarySearchClass<T extends Comparable<T>> {
	private T[] a;
	
	public BinarySearchClass(T[] words) {
		a = words;
	}
	
	public int search(Comparable<T> v) {
		int low = 0;
		int high = a.length	- 1;
		
		while (low <= high) {
			int mid = (low + high) / 2;
			T midVal = a[mid];
			
			if (v.compareTo(midVal) < 0) {
				low = mid - 1;
			}
			else if (v.compareTo(midVal) > 0) {
					high = mid + 1;
			}
		}
		return -1;
	}
}
