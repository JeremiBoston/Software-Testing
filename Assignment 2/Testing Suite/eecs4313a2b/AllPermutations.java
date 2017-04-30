package eecs4313a2b;

import java.util.ArrayList;
import java.util.List;

public class AllPermutations {

	static ArrayList<String> combinations = new ArrayList<String>();

	public static void printBin(String soFar, int iterations) {
		if (iterations == 0) {
			// System.out.println(soFar);
			combinations.add(soFar);
		} else {
			printBin(soFar + "0", iterations - 1);
			printBin(soFar + "1", iterations - 1);
		}
	}
	
	public static List<String> makeLists(String soFar, int iterations){
		
		List<String> lists = new ArrayList<String>();
		printBin(soFar, iterations);

		// if the digit in location 1 is a 0, then 1 is not part of the string
		// for example 0001000 would translate to "4"

		for (int i = 0; i < combinations.size(); i++) {

			String current = combinations.get(i);
			String combo = "";
			
			for (int j = 0; j < current.length(); j++) {
				if (current.charAt(j) == '1') {
					combo += j+ 1;
				}

			}
			lists.add(combo);
			

			// System.out.println(combinations.get(i));
		}
//		System.out.println(lists);
		return lists;
	}
	
	public static List<Integer> createListFromString(String sequence){
		List<Integer> combo = new ArrayList<Integer>();
		
		for (int i = 0; i < sequence.length(); i++){
			combo.add(Character.getNumericValue(sequence.charAt(i)));
		}	
		return combo;
	}
	

	public static void main(String[] args) {
		// this prints out all the binary combinations of 7 digits

		
		List<String> lists = makeLists("", 7);
		
		for (int i = 0; i < lists.size(); i++){
			List<Integer> list = createListFromString(lists.get(i));
		}

	}

}

