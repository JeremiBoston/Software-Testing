package eecs4313a3t1;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;

import eecs4313a3t1.MinuteStringTest;
import eecs4313a3t1.DayListTest;
import eecs4313a3t1.isAfterTest;

@Suite.SuiteClasses({ MinuteStringTest.class, isAfterTest.class, DayListTest.class})
@RunWith(Suite.class)
public class EECS4313A3AllTests {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(EECS4313A3AllTests.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println("All tests passed? " + result.wasSuccessful());

	}

}