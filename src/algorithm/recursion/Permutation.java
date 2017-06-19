package algorithm.recursion;

import java.util.ArrayList;

// Write a method to compute all permutations of a string [数] 排列；[数] 置换
public class Permutation {

	/*
	 * Let’s assume a given string S represented by the letters A1, A2, A3, ...,
	 * An To permute set S, we can select the !rst character, A1, permute the
	 * remainder of the string to get a new list. Then, with that new list, we
	 * can “push” A1 into each possible position. For example, if our string is
	 * “abc”, we would do the following: 
	 * 
	 * 1. Let first = “a” and let remainder =“bc”
	 *  2. Let list = permute(bc) = {“bc”, “cd”} 
	 *  3. Push “a” into each
	 * location of “bc” (--> “abc”, “bac”, “bca”) and “cb” (--> “acb”, “cab”,
	 * “cba”)
	 *  4. Return our new list Now, the code to do this:
	 * 
	 * This solution takes O(n!) time, since there are n! permutations.
	 */

	public static ArrayList<String> getPerms(String s) {
		
		ArrayList<String> permutations = new ArrayList<String>();
		
		if (s == null) { 
			return null;
		} else if (s.length() == 0) { // base case
			permutations.add("");
			return permutations;
		}
		
		char first=s.charAt(0);//get the first char
		String remainder=s.substring(1);//remove the first letter

		ArrayList<String> words = getPerms(remainder);
		for (String word : words) {
			for (int j = 0; j <= word.length(); j++) {

				permutations.add(insertCharAt(word,first,j));
			}
		}
		return permutations;
	}

	public static String insertCharAt(String word, char c, int i) {
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;
	}
	
	public static void main(String [] args)
	{
		String a="AbC";
		System.out.print(a.length()+"!=");
		ArrayList<String> re=getPerms("AbC");
		
		// This solution takes O(n!) time, since there are n! permutations.
		System.out.println(re.size());
		System.out.println(re);
	}
}
