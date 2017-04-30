package eecs4313a3t1;

import net.sf.borg.common.DateUtil;
import static org.junit.Assert.*;
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
		assertEquals("17895697 Hours 3 Minutes", DateUtil.minuteString(1073741823));
				
		// 5. Max-
		assertEquals("35791394 Hours 6 Minutes", DateUtil.minuteString(2147483646));
		
		// 6. Max
		assertEquals("35791394 Hours 7 Minutes", DateUtil.minuteString(2147483647));

		// 6. Max+
//		assertEquals("35791394 Hours 8 Minutes", DateUtil.minuteString(2147483648));
		assertEquals("1 Hour", DateUtil.minuteString(60));

	}
	
	@Test
	public void testDataFlowMins(){
		
		// All Defs: Path AB
		// All Uses: Paths AB, ABC
		// All P-Uses / Some C-uses: Path AB
		// All C-uses / Some P-uses: Paths AB, ABC
		assertEquals("2 Minutes", DateUtil.minuteString(2));
	}
	
	@Test
	public void testDataFlowHours(){
		// All Defs: Path BCDEF
		assertEquals("2 Hours 2 Minutes", DateUtil.minuteString(122));
		
		// All Uses: Paths BCDEF, BCDEFG, BCDEFH, BCDEFHI, BCDEFHKMO
		assertEquals("1 Hour 2 Minutes", DateUtil.minuteString(62));
		assertEquals("2 Hours 2 Minutes", DateUtil.minuteString(122));
		assertEquals("1 Hour", DateUtil.minuteString(60));
		
		// All P-Uses / Some C-uses: Paths BCDEFHKMO
		assertEquals("1 Hour", DateUtil.minuteString(60));
		
		// All C-uses / Some P-uses: Paths BCDEFG, BCDEFHI
		assertEquals("1 Hour 5 Minutes", DateUtil.minuteString(65));
		assertEquals("2 Hours 12 Minutes", DateUtil.minuteString(132));
	}
	
	@Test
	public void testDataFlowMinsPast(){
		// All Defs: Path CDEFHK
		assertEquals("2 Minutes", DateUtil.minuteString(2));
		
		// All Uses: Paths CDEFHK, CDEFHKL, CDEFHKM, CDEFHKMN, CDEFHKMNOQ
		assertEquals("1 Hour 1 Minute", DateUtil.minuteString(61));
		assertEquals("0 Minutes", DateUtil.minuteString(0));
		
		// All P-Uses / Some C-uses: Paths CDEFHK, CDEFHKM
		assertEquals("1 Hour 3 Minutes", DateUtil.minuteString(63));
		assertEquals("2 Hours 1 Minute", DateUtil.minuteString(121));
		
		// All C-uses / Some P-uses: Paths CDEFHKL, CDEFHKMN, CDEFHKMNOQ
		assertEquals("1 Hour 5 Minutes", DateUtil.minuteString(65));
		assertEquals("2 Hours 12 Minutes", DateUtil.minuteString(132));
	}
	
	@Test
	public void testDataFlowMinutesString(){
		// All Defs: Path DEFHKL
		assertEquals("2 Minutes", DateUtil.minuteString(2));
		
		// All Uses: Paths DEFHKL, DEFHKMN , DEFHKMOP, DEFHKMOQ, DEFHKMOR, DEFHKMORS, ST
		assertEquals("1 Hour 1 Minute", DateUtil.minuteString(61));
		assertEquals("0 Minutes", DateUtil.minuteString(0));
		assertEquals("1 Hour", DateUtil.minuteString(60));
		
		// All P-Uses / Some C-uses: Paths DEFHKMOR
		assertEquals("2 Hours 1 Minute", DateUtil.minuteString(121));
		assertEquals("1 Hour", DateUtil.minuteString(60));
		assertEquals("0 Minutes", DateUtil.minuteString(0));
		
		// All C-uses / Some P-uses: Paths DEFHKL, DEFHKMN , DEFHKMOP, DEFHKMOQ, DEFHKMORS, ST
		assertEquals("1 Hour 5 Minutes", DateUtil.minuteString(65));
		assertEquals("2 Hours 1 Minute", DateUtil.minuteString(121));
		assertEquals("2 Minutes", DateUtil.minuteString(2));
		assertEquals("1 Hour", DateUtil.minuteString(60));

	}
	
	@Test
	public void testDataFlowHoursString(){
		
		// All Defs: Path EFG
		assertEquals("3 Hours", DateUtil.minuteString(180));
		
		// All Uses: Paths EFG, EFHI, EFHJ, EFHKMOR, EFHKMORT
		assertEquals("1 Hour 1 Minute", DateUtil.minuteString(61));
		assertEquals("2 Hours 1 Minute", DateUtil.minuteString(121));
		assertEquals("0 Minutes", DateUtil.minuteString(0));
		assertEquals("1 Hour", DateUtil.minuteString(60));
		
		// All P-Uses / Some C-uses: Paths  EFHKMOR
		assertEquals("2 Hours 1 Minute", DateUtil.minuteString(121));
		assertEquals("1 Hour", DateUtil.minuteString(60));
		assertEquals("0 Minutes", DateUtil.minuteString(0));
		
		// All C-uses / Some P-uses: Paths EFG, EFHI, EFHJ, EFHKMORT
		assertEquals("1 Hour 5 Minutes", DateUtil.minuteString(65));
		assertEquals("2 Hours 1 Minute", DateUtil.minuteString(121));
		assertEquals("2 Minutes", DateUtil.minuteString(2));

	}

}
