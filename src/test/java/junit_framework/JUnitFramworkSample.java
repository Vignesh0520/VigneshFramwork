package junit_framework;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;

public class JUnitFramworkSample {

	@BeforeClass
	public static void beforeClassMethod() {
		System.out.println("beforeClassMethod()");
	}
	
	@Before
	public void before() {
		System.out.println("before()");
	}
	
	@Test
	public void testcase1() {
		String actualResult = "Login Successfully";
		String expectedResult = "Login Successfully";
		Assert.assertEquals(expectedResult, actualResult);
		System.out.println("testcase1 validated");
	}
	
	@Test
	public void testcase2() {
		String actualResult = "Login Successfully";
		String expectedResult = "Login Successfully";
		boolean equals = actualResult.equals(expectedResult);
		Assert.assertTrue(equals);
		System.out.println("testcase2 validated");
	}
	
	@Test
	public void testcase3() {
		String actualResult = "Login Successfully";
		String expectedResult = "Your password is invalid!";
		boolean equals = actualResult.equals(expectedResult);
		Assert.assertFalse(equals);
		System.out.println("testcase3 validated");
	}
	
	@After
	public void after() {
		System.out.println("after()");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("afterClass()");
	}
	
}
