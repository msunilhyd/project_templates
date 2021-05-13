package com.dailydose.warmupOne;

public class SleepIn 
{

	public static void main(String[] args) {
		System.out.println(sleepIn(false, false));
		System.out.println(sleepIn(true, false));
		System.out.println(sleepIn(false, true));
	}
	
	public static boolean sleepIn(boolean weekday, boolean vacation) 
	{
		if (weekday == false && vacation == false) 	
			return true;
		else if (weekday == true && vacation == false)
			return false;
		else if (weekday == false && vacation == true)
			return true;
		else
			return true;
	}
}
