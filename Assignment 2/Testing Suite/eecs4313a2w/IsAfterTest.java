package eecs4313a2w;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import net.sf.borg.common.DateUtil;

public class IsAfterTest {

	@Test
	public void testIsAfter() {
		// test using equivalence class testing
		// variation: weak robust
		// which means we will test incorrect dates

		// ranges:
		// first date is not a real date | second date is after it - done
		// first date is not a real date | second date is not after it - done
		// first date is a real date and it is before second date - done
		// first date is a real date and it is after second date - done
		// first date is after the second date and second date is not a real
		// 		date - done

		Date d1 = new Date(2017, 8, 15);
		Date d2 = new Date(2017, 8, 16);

		assertFalse(DateUtil.isAfter(d1, d2));
		assertTrue(DateUtil.isAfter(d2, d1));

		// february 31, 2017

		Date invalid_date = new Date(2017, 2, 31);
		Date pre_invalid_date = new Date(2017, 1, 1);

		assertFalse(DateUtil.isAfter(invalid_date, d2));
		assertTrue(DateUtil.isAfter(d2, invalid_date));

		assertFalse(DateUtil.isAfter(pre_invalid_date, invalid_date));
		assertTrue(DateUtil.isAfter(invalid_date, pre_invalid_date));

	}

}
