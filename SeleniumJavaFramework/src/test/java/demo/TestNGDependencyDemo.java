package demo;

import org.testng.annotations.Test;

public class TestNGDependencyDemo {

	@Test(dependsOnGroups = {"goldensuite"})
	public void test1 () {

		System.out.println("I am inside Test 1");
	}

	@Test
	public void test2 () {

		System.out.println("I am inside Test 2");
	}
	
		@Test(groups = {"goldensuite"})
		public void test3  (){

			System.out.println("I am inside Test 3");
		}
		
		
	}
