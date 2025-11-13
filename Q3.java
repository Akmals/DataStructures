package a1;

/**
 * Name: Akmal Shaikh
 * Student ID: 016450382
 * Description of solution:
 * Returns the number of ways by using the recursive case
 */

import static org.junit.Assert.*;

public class Q3 {

	// Return the number of ways to choose a subset of k distinct elements from a set of n elements  
    public static int C(int n, int k) {
        // Base cases
        if (k == 0 || k == n) {
            return 1;
        }
        // Recursive case
        return C(n - 1, k - 1) + C(n - 1, k);
    }
	
	public static void main(String[] args) {
		System.out.println("Testing...");
		assertEquals(C(14,3), 364);
		assertEquals(C(14,11), 364);
		assertEquals(C(18,8), 43758);
		System.out.println("Success!");
	}

}
