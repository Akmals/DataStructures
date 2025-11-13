package a1;

/**
 * Name: Akmal Shaikh
 * Student ID: 015460382
 * Description of solution:
 * the recursive function allows for the characters to be included and excluded to generate the substrings
 */

import java.util.ArrayList;

import static org.junit.Assert.*;

public class Q1 {

	
	// Return all substrings of the String s
	public static ArrayList<String> allSubstrings(String s){
		 ArrayList<String> result = new ArrayList<>();
	        generateSubstrings(s, "", 0, result);
	        return result;
	}
	 
	private static void generateSubstrings(String s, String current, int index, ArrayList<String> result) {
	        if (index == s.length()) {
	            result.add(current);
	            return;
	        }
	        generateSubstrings(s, current, index + 1, result);
	        generateSubstrings(s, current + s.charAt(index), index + 1, result);
	    }
	
	public static void main(String[] args) {
		ArrayList<String> s = allSubstrings("abcde");
		System.out.println("Testing...");
		assertEquals(s.size(), 32);
		/**
		 * These are all the 32 substrings that should be contained in Q1.
		 */
		assertEquals(s.contains(""), true);
		assertEquals(s.contains("a"), true);
		assertEquals(s.contains("b"), true);
		assertEquals(s.contains("c"), true);
		assertEquals(s.contains("d"), true);
		assertEquals(s.contains("e"), true);
		assertEquals(s.contains("ab"), true);
		assertEquals(s.contains("ac"), true);
		assertEquals(s.contains("ad"), true);
		assertEquals(s.contains("ae"), true);
		assertEquals(s.contains("bc"), true);
		assertEquals(s.contains("bd"), true);
		assertEquals(s.contains("be"), true);
		assertEquals(s.contains("cd"), true);
		assertEquals(s.contains("ce"), true);
		assertEquals(s.contains("de"), true);
		assertEquals(s.contains("abc"), true);
		assertEquals(s.contains("abd"), true);
		assertEquals(s.contains("abe"), true);
		assertEquals(s.contains("acd"), true);
		assertEquals(s.contains("ace"), true);
		assertEquals(s.contains("ade"), true);
		assertEquals(s.contains("bcd"), true);
		assertEquals(s.contains("bce"), true);
		assertEquals(s.contains("bde"), true);
		assertEquals(s.contains("cde"), true);
		assertEquals(s.contains("abcd"), true);
		assertEquals(s.contains("abce"), true);
		assertEquals(s.contains("acde"), true);
		assertEquals(s.contains("abde"), true);
		assertEquals(s.contains("bcde"), true);
		assertEquals(s.contains("abcde"), true);
		System.out.println("Success!");
	}

}

