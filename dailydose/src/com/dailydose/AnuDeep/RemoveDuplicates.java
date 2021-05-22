package com.dailydose.AnuDeep;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RemoveDuplicates {

	public static void main(String[] args) {

		Random random = new Random();
		
			// Remove Duplicate chars
		List<Character> charList = new ArrayList<Character>();
		
		System.out.print("With Duplicates = ");

		for (int i=0;i<100;i++) {
			
			charList.add((char) (random.nextInt(26) + 'a'));
			System.out.print(charList.get(i) + ", ");
		}
		
		System.out.println();
		System.out.print("Without Duplicates = ");
		for(Object o : removeDuplicates(charList)) {
			System.out.print(o.toString() + ", ");
		}
		
		List<Integer> intList = new ArrayList<Integer>();
		
		System.out.println();
		// Remove duplicate integers
		System.out.print("With Duplicates = ");

		for (int i=0;i<100;i++) {
		
			intList.add(random.nextInt(10) + 0);
			System.out.print(intList.get(i) + ", ");
		}
		
		System.out.println();

		System.out.print("Without Duplicates = ");
		for(Object o : removeDuplicates(intList)) {
			System.out.print(o.toString() + ", ");
		}
		
		System.out.println();

	}
	
	public static <E> ArrayList<E> removeDuplicates(List<E> list) {
		
		ArrayList<E> newList = new ArrayList<E>();
		
		for(Object o : list) {
			if (!newList.contains(o)) {
				newList.add((E) o);
			}
		}
		return newList;
	}
}
