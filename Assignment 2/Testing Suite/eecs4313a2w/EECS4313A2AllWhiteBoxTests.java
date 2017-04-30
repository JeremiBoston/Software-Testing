package eecs4313a2w;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

@Suite.SuiteClasses({DayListTest.class,IsAfterTest.class,MinuteStringTest.class  })
@RunWith(Suite.class)
public class EECS4313A2AllWhiteBoxTests {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(EECS4313A2AllWhiteBoxTests.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println("All tests passed? " + result.wasSuccessful());
	}

}
