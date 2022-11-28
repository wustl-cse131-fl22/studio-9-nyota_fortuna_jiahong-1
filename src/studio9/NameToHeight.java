package studio9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import support.cse131.NotYetImplementedException;

public class NameToHeight {
	/**
	 * Construct and fill a map with your studio group members' names, each
	 * associated with his or her height.
	 * 
	 * Construct an ArgsProcessor and loop asking the args processor for a name to
	 * lookup the height. When the user cancels (that is: when args processor
	 * returns null), break from the loop. Otherwise, loop up the name in the map
	 * and output the results. Be sure to handle the case where the map does not
	 * contain a specified name.
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		int defaults = map.getOrDefault("Default", 100);
		map.put("Shangwe", 76);
		map.put("Jiahong", 50);
		map.put("Fortuna", 55);
		map.put("Jack", 60);
		map.put("Jayce", 65);
		
		boolean advance = true;
		while (advance) {
			System.out.println("Enter a name, result will be a height.");
			String name = in.next();
			if (name.equals("quit")) {
				advance = false;
			} else if (map.containsKey(name)) {
				System.out.println("The associated height of the name is: " + map.get(name));
			} else {
				System.out.println("The associated height of the name is :" + defaults);
			}
		}

		// FIXME

	}
}
