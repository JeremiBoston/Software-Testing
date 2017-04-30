package eecs4313a2b;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


@Suite.SuiteClasses({ MinuteStringTest.class,IsAfterTest.class,DayListTest.class})
@RunWith(Suite.class)
public class EECS4313A2AllBlackBoxTests {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(EECS4313A2AllBlackBoxTests.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println("All tests passed? " + result.wasSuccessful());

	}

}
