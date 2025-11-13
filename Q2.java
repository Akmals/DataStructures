package a1;

/**
 * Name:Akmal Shaikh
 * Student ID: 016450382
 * Description of solution:
 * Utilizes the Hash Set in order generate the sum by reading the inputs from the files
 * and calculates the sum of those numbers.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.Assert.*;

public class Q2 {

	// Return all sums that can be formed from subsets of elements in arr
	public static ArrayList<Integer> allSums( ArrayList<Integer> arr ) {
		 HashSet<Integer> result = new HashSet<>();
	        generateSums(arr, 0, 0, result);
	        return new ArrayList<>(result);
	    }
	 private static void generateSums(ArrayList<Integer> arr, int index, int currentSum, HashSet<Integer> result) {
	        if (index == arr.size()) {
	            result.add(currentSum);
	            return;
	        }
	        generateSums(arr, index + 1, currentSum, result);
	        generateSums(arr, index + 1, currentSum + arr.get(index), result);
	    }
	
	public static void main(String[] args) {
		//https://www.baeldung.com/java-file-to-arraylist
		ArrayList<Integer> result = new ArrayList<Integer>();//= Files.readAllLines(Paths.get("nums.txt"));
		try {
			BufferedReader br = new BufferedReader(new FileReader("nums.txt"));
			while (br.ready()) {
				result.add(Integer.getInteger(br.readLine()));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		ArrayList<Integer> sums = allSums(result);
		
		System.out.println("Testing...");
		assertEquals(sums.size(), 8);
		assertEquals(sums.contains(0), true);
		assertEquals(sums.contains(1), true);
		assertEquals(sums.contains(2), true);
		assertEquals(sums.contains(4), true);
		assertEquals(sums.contains(3), true);
		assertEquals(sums.contains(5), true);
		assertEquals(sums.contains(6), true);
		assertEquals(sums.contains(7), true);
		System.out.println("Success!");
	}
}
