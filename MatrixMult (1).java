package a2;


import static org.junit.Assert.*;
/**
* Name: Akmal Shaikh
* Student ID: 016450382
* Description of solution: This solution utilizes the Strassen matrix multiplication. 
* The equation of T(N) = 7T(N/2) +  O(N2) best applies to Case 1 of f(N) = O(N)^c where
*  c < logb a so to find time complexity you take f(N) = O(N^2) find logb =a which is log2 7= 2.807
*  which is about 2.81, so the time complexity is 2.81. I expect this to run faster that the naive method
*  because since it has cubic complexity. Using the Strassen Method is below the cubic complexity 
*  so it will run slightly faster for larger matrices. 
* is 
* @author name
*
*/
	public class MatrixMult {
		/** Function to multiply matrices
		 * Assumes A and B are square and have the same size!
		 * @param A - matrix A to multiply (first operand)
		 * @param B - matrix B to multiply (second operand)
		 ***/
		public static int[][] multiply(int[][] A, int[][] B){
			int n = A.length;
			int[][] R = new int[n][n];
			
			/** base case **/
			if (n == 1)
				R[0][0] = A[0][0] * B[0][0];
			else
			{
			// Divides the Matrices by 2 
				int newSize = n / 2;
				int[][] A11 = new int[newSize][newSize];
				int[][] A12 = new int[newSize][newSize];
				int[][] A21 = new int[newSize][newSize];
				int[][] A22 = new int[newSize][newSize];
				
				int[][] B11 = new int[newSize][newSize];
				int[][] B12 = new int[newSize][newSize];
				int[][] B21 = new int[newSize][newSize];
				int[][] B22 = new int[newSize][newSize];
			
				//Spliting Matrices into set of submatrices,
				split(A, A11, 0 , 0);
		        split(A, A12, 0 , newSize);
		        split(A, A21, newSize, 0);
		        split(A, A22, newSize, newSize);
		        split(B, B11, 0 , 0);
		        split(B, B12, 0 , newSize);
		        split(B, B21, newSize, 0);
		        split(B, B22, newSize, newSize);
				
				//Performing First Set of Operations, finding M(k)
				int[][] M1 = multiply(add(A11,A22),add(B11, B22));
				int[][] M2 = multiply(add(A21, A22), B11);
				int[][] M3 = multiply(A11, sub(B12, B22));
				int[][] M4 = multiply(A22, sub(B21, B11));
				int[][] M5 = multiply(add(A11, A12), B22);
				int[][] M6 = multiply(sub(A21, A11), add(B11, B12));
				int[][] M7 = multiply(sub(A12, A22), add(B21, B22));
						
				//Using M(k) to find C(i)(j)
				 int [][] C11 = add(sub(add(M1, M4), M5), M7);
		         int [][] C12 = add(M3, M5);
		         int [][] C21 = add(M2, M4);
		         int [][] C22 = add(sub(add(M1, M3), M2), M6);
		         
		         //Combine C Matrix into one 
		         join(C11, R, 0 , 0);
		         join(C12, R, 0 , newSize);
		         join(C21, R, newSize, 0);
		         join(C22, R, newSize, newSize);

			}
			/** return result **/
			return R;
		}
	/*** 
	 Function to subtract two matrices A and B
	***/
	public static int[][] sub(int[][] A, int[][] B){
		int n = A.length;
		int[][] C = new int[n][n];
		
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				C[i][j] = A[i][j] - B[i][j];
			return C;
	}
	
	/***
	Function to add two matrices A and B
	***/
	public static int[][] add(int[][] A, int[][] B){
		int n = A.length;
		int[][] C = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				C[i][j] = A[i][j] + B[i][j];
			return C;
	}

	/**
	 * Function to split parent matrix into child matrices.
	 * Assumes C is initialized.
	 * @param P - parent matrix
	 * @param C - A child matrix that will get the corresponding indices of the
	parent
	 * @param iB - start row in parent
	 * @param jB - start column in parent
	 ***/
	public static void split(int[][] P, int[][] C, int iB, int jB){
		for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
			for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
				C[i1][j1] = P[i2][j2];
	}
	/**
	 * Function to join child matrices into a parent matrix
	 * Assumes C is initialized.
	 * @param P - parent matrix
	 * @param C - A child matrix that will provide the corresponding indices of the
	parent
	 * @param iB - start row in parent
	 * @param jB - start column in parent
	 ***/
	public static void join(int[][] C, int[][] P, int iB, int jB){
		for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
			for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
				P[i2][j2] = C[i1][j1];
	}

	/**
	* @param args
	*/
	public static void main(String[] args) {
		// Ensure that multiplying the two matrices gives the correct result!
		int[][] A = {{1, 2}, {3, 4}};
		int[][] B = {{5, 6}, {7, 8}};
		int[][] C = multiply(A, B);
		System.out.println(C.toString());
		System.out.println("Testing...");
		assertEquals(C[0][0], 19);
		assertEquals(C[0][1], 22);
		assertEquals(C[1][0], 43);
		assertEquals(C[1][1], 50);
		System.out.println("Success!");
		}
	}
