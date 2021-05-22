package com.dailydose.AnuDeep;

// working program for assignment 2
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

class Employee implements Comparable<Employee> {
	
	private String name;
	private int salary;
	
	Employee() {
		
	}
	
	Employee(String n, int a) {
		name = n;
		salary = a;
	}
	
	public String getEmployeeName() {
		return name;
	}
	
	public int getEmployeesalary() {
		return salary;
	}
	
//	Overriding the compareTo method
	public int compareTo(Employee d) {
//		System.out.println(this.name + " == " + d.getEmployeeName());
		return (this.name).compareTo(d.name);
	}
	
}

public class SearchForKeyBinary {

	public static <T extends Comparable<T>> String ifPresent(T[] arr, T element) {
		
		int low = 0;
		int high = arr.length - 1;
		
		while(low <= high) {
			int mid = (low + high) / 2;
			T midVal = arr[mid];
			int result = element.compareTo(midVal);
			if (result < 0)
				high = mid - 1;
			else if (result > 0)
				low = mid + 1;
			else 
				return "Present";
		}
		return "Not present";
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		Integer[] intArr = new Integer[100];
		
		for (int i=0;i<100;i++) {
		
			intArr[i] = random.nextInt(100);
//			System.out.print(intArr[i]+ ", ");
		}
		
		System.out.println("Integer array is :- ");

		String[] stringArr = {"d", "apple", "developer", "professor", "manager"};
		
		System.out.println(Arrays.toString(intArr));
		
		Arrays.sort(intArr);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input the integer you want to find");
		
		int key = sc.nextInt();
		
		System.out.println("Result = " + ifPresent(intArr, key));
//		System.out.println(ifPresent(intArr, 7));
		
//		System.out.println(ifPresent(stringArr, "orange"));

		System.out.println(Arrays.toString(stringArr));
		Arrays.sort(stringArr);
		String f = sc.nextLine();

		System.out.println("Please input the String :- ");
        String str = sc.nextLine();

		System.out.println("Result = " + ifPresent(stringArr, str));
		
//		Take a list of Employee objects
		Employee[] list = {new Employee("Shaggy Wilson", 30), new Employee("Lacy Lu", 20),
				new Employee("Roger Eckhart", 180), new Employee("Tommy Hilfiger", 43), new Employee("Tammy", 10)};
		
		

	    for(Employee a: list)   // printing the sorted list of ages
	         System.out.print(a.getEmployeeName() +"  : "+ a.getEmployeesalary() + ", ");
		Arrays.sort(list); // Sorts the array list

		System.out.println("Please input the first Name and last name:- ");
        String name = sc.nextLine();
        
		System.out.println("Result = " + ifPresent(list, new Employee(name, 10)));
	}
}
