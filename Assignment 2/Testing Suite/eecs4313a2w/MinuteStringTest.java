package eecs4313a2w;

import net.sf.borg.common.DateUtil;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MinuteStringTest {
	
	@Test
	public void testMinuteStringBVT(){
		/*
		 * 1. Min-:    -1 minutes
		 * 2. Min:   	0 minutes
		 * 3. Min+:  	1 minute
		 * 4. Nominal:	1073741823 minutes
		 * 5. Max-:		2147483646
		 * 6. Max: 		2147483647
		 * 7. Max+:		2147483648
		 */
		
		// 1. Min -
		assertEquals("-1 Minutes", DateUtil.minuteString(-1));
		
		// 2. Min
		assertEquals("0 Minutes", DateUtil.minuteString(0));

		// 3. Min +
		assertEquals("1 Minute", DateUtil.minuteString(1));
		
		// 4. Nominal
		assertEquals("1 Hour", DateUtil.minuteString(60));
		assertEquals("17895697 Hours 3 Minutes", DateUtil.minuteString(1073741823));
				
		// 5. Max-
		assertEquals("35791394 Hours 6 Minutes", DateUtil.minuteString(2147483646));
		
		// 6. Max
		assertEquals("35791394 Hours 7 Minutes", DateUtil.minuteString(2147483647));

		// 6. Max+
//		assertEquals("35791394 Hours 8 Minutes", DateUtil.minuteString(2147483648));
		
	}
	
}
