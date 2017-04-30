package eecs4313a2b;

import net.sf.borg.model.Repeat;

import static org.junit.Assert.*;
import eecs4313a2b.AllPermutations;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DayListTest {
	
	@Test
	public void testDayList(){
		
		/*
		 * Conditions:
		 * C1: Input is empty
		 * C2: Input has a comma seperator between "dlist" and the day values
		 * C3: Input doesn't have a comma seperator between "dlist" and the day values
		 * C4: Input has "dlist" but no numbers afterwards
		 * C5: Input contains a valid sequence of numbers
		 * C6: Non number after "dlist"
		 * C7: Non number in between numbers
		 * 
		 * Actions:
		 * A1: Return empty list
		 * A2: Return a list of the extracted numbers
		 * 
		 * 
		 * C1 -> A1
		 * C2 -> A2
		 * C3 -> A2
		 * C4 -> A1
		 * C5 -> A2
		 * C6 -> A1
		 * C7 -> A2
		 */
		
				
		List<Integer> sq = new ArrayList<Integer>();
		
		// C1 -> A1
		assertEquals(sq, Repeat.getDaylist(""));
		
		//C4 -> A1
		assertEquals(sq, Repeat.getDaylist("dlist, "));
		
		//C6 -> A1
		assertEquals(sq, Repeat.getDaylist("dlist, agc"));
		
		//C2 -> A2
		sq.add(1);
		assertEquals(sq, Repeat.getDaylist("dlist, 1"));
		
		//C3 -> A2
		sq.add(2);
		assertEquals(sq, Repeat.getDaylist("dlist 12"));
		
		//C7 -> A2
		assertEquals(sq, Repeat.getDaylist("dlist, 1agc2"));

		
		// C5 => A2
		
		List<String> lists = AllPermutations.makeLists("", 7);
		
		for (int i = 0; i < lists.size(); i++){
			String f = "dlist, ";
			List<Integer> list = AllPermutations.createListFromString(lists.get(i));
			assertEquals(list, Repeat.getDaylist(f + lists.get(i)));
		}
		
		
		
	}
	
}
