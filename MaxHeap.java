package a3;

import static org.junit.Assert.*;
/**
* Name: Akmal Shaikh
* Student ID: 016450382
* Description of solution: This solution involves implementing a heap using MaxHeapify and build
* max heap. Once implementing the heap, the next step would be implementing heap sort in order 
* to find the sum of the smallest 2 numbers in the sorted array. 
**/

public class MaxHeap {
	private int[] HeapArray;
	public int[] getHeapArray() {
		return HeapArray;
	}

private int size;
private int maxsize;
private static final int FRONT = 1;

public MaxHeap(int maxsize) {
	this.maxsize = maxsize;
	this.size = maxsize;
	HeapArray = new int[maxsize];
	//initialize heap array to a set of numbers, rearranged a little
	for (int i = FRONT; i < HeapArray.length; i++) {
		HeapArray[i] = maxsize-i;
		}
	}

// Return the index of the parent of the node currently at pos
private int parent(int pos)	{
	return (pos / 2);
	}

// Return the index of the leftchild of the node currently at pos
private int leftChild(int pos) {
	return (2 * pos);
	}

// Return the index of the rightchild of the node currently at pos
private int rightChild(int pos)
{
return (2 * pos) + 1;
}

//Function to heapify the node at position i, up to the position n
private void maxHeapify(int i, int n)
{
	int largest = i;
    int left = leftChild(i);
    int right = rightChild(i);

    if (left <= n && HeapArray[left] > HeapArray[largest]) {
            largest = left;
        }

    if (right <= n && HeapArray[right] > HeapArray[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            maxHeapify(largest, n);
        }
    }

public void buildMaxHeap() {
	for (int i = size / 2; i >= FRONT; i--) {
        maxHeapify(i, size - 1);
    }
}

public void sort() {
	 buildMaxHeap();
     for (int i = size - 1; i > FRONT; i--) {
         swap(FRONT, i);
         maxHeapify(FRONT, i - 1);
     }
 }

// Swap two nodes of the heap at index first second
private void swap(int first, int seconds) {
	int tmp;
	tmp = HeapArray[first];
	HeapArray[first] = HeapArray[seconds];
	HeapArray[seconds] = tmp;
	}

public static void main(String[] args) {
	int SIZE = 30;
	MaxHeap heap = new MaxHeap(SIZE);
	heap.sort();
	int[] heapArr = heap.getHeapArray();
	
	// Find the smallest two numbers in the sorted array
    int A = heapArr[0];
    int B = heapArr[1];
    int C = A + B;

    // Print the result in the specified format
    System.out.println("The minimum sum is:");
    System.out.println(A + "+" + B + "=" + C);
	
	assertEquals(heapArr[0], 0);
	assertEquals(heapArr[1], 1);
	assertEquals(heapArr[2], 2);
	assertEquals(heapArr[SIZE-1], SIZE-1);
	assertEquals(heapArr.length, SIZE);
	}
}
