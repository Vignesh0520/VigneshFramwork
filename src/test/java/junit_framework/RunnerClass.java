package junit_framework;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
/*
import org.junit.runner.RunWith;
import org.junit.runners.Suite;;

@RunWith(Suite.class)
@Suite.SuiteClasses({JUnit_Framework.class, JUnitFramworkSample.class}) 
*/
public class RunnerClass {
	
	@Test
	public void method() {
		Result result = JUnitCore.runClasses(JUnit_Framework.class, JUnitFramworkSample.class);
		int runCount = result.getRunCount();
		System.out.println("\nrunCount : "+runCount);
		int failureCount = result.getFailureCount();
		System.out.println("failureCount : "+failureCount);
		int ignoreCount = result.getIgnoreCount();
		System.out.println("ignoreCount : "+ignoreCount);
		long runTime = result.getRunTime();
		System.out.println("runTime : "+runTime+" milliseconds");
	}

}
