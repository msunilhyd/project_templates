package com.dailydose.junitTwo;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.dailydose.junit.TestJunit;

public class TestRunner {

	public static void main(String[] args) {
		
		Result result = JUnitCore.runClasses(TestJunit.class);
		
		for (Failure failure: result.getFailures()) {
			System.out.println(failure.toString());
		}
		
		System.out.println(result.wasSuccessful());
	}
}
