package com.dailydose.may;

import java.util.ArrayList;
import java.util.List;

public class ObjectCastToDouble {

	public static void main(String[] args) {
		List<String> myList = new ArrayList();
		
		
		List<Object> objList = new ArrayList<Object>();
		
		objList.add("sunil");
		String str = (String) objList.get(0);
		System.out.println(str);
		
		objList.set(0, "linus");
		objList.set(0, 11.809);
		
		
		System.out.println(objList.get(0));
	}
}
