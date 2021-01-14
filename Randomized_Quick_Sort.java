package lk.ac.jfn.eng.ec4070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

/**
 * This program will sort a given input using Randomized Quick Sort
 * 
 * @author Nadeesha Maduranga (nadeesham332@gmail.com)
 *
 */

public class Randomized_Quick_Sort {

	static Random random;
	static int temp;

	/**
	 * Places pivot element at its correct position in sorted array
	 * 
	 * @param arr - unsorted array
	 * @param p   - pivot index in unsorted part
	 * @param r   - last index in unsorted part
	 * @return the position of pivot element in sorted array
	 */
	static int partition(int[] arr, int p, int r) {
		int x = arr[p]; // x is pivot element
		int i = p; // i is starting index

		for (int j = p + 1; j <= r; j++) {
			if (arr[j] <= x) {
				i = i + 1;
				// swap elements
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		// swap and save pivot element
		temp = arr[i];
		arr[i] = arr[p];
		arr[p] = temp;
		return i;
	}

	/**
	 * Gives random numbers between first and last elements
	 * 
	 * @param p - pivot index in unsorted part
	 * @param r - last index in unsorted part
	 * @return a random number between first and last indexes in unsorted part
	 */
	static int random(int p, int r) {
		Random rand = new Random();
		return rand.nextInt(r - p + 1) + p;
	}

	/**
	 * Gives random inputs to partition function
	 * 
	 * @param arr - unsorted array
	 * @param p   - pivot index in unsorted part
	 * @param r   - last index in unsorted part
	 * @return the input p and r values to partition function
	 */
	static int randamizedPartition(int[] arr, int p, int r) {

		int i = random(p, r); // i is a random number between first and last indexes in unsorted part
		// swap pivot element
		temp = arr[p];
		arr[p] = arr[i];
		arr[p] = temp;
		return partition(arr, p, r);
	}

	/**
	 * implements quick sort recursively
	 * 
	 * @param arr - unsorted array
	 * @param p   - pivot index in unsorted part
	 * @param r   - last index in unsorted part
	 */
	static void randomizedQuickSort(int[] arr, int p, int r) {
		// check whether recursion is need or not
		if (p < r) {
			int q = randamizedPartition(arr, p, r); // q is the position of pivot element in sorted array
			randomizedQuickSort(arr, p, q - 1);
			randomizedQuickSort(arr, q + 1, r);
		}
	}

	/**
	 * Drives code and displays outputs
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		System.out.print("This program will sort integer numbers in given array using bubble sort.\n" + "n - "
				+ "number of integers in input array.\n" + "Enter input array size(n): ");

		// Getting input size from user
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());

		int array[] = new int[n];
		int inputSize = 0;
		String input;

		do {
			System.out.print("Enter " + n + " integers, separated using space, to sort (n1 n2 n3 ...): ");
			input = reader.readLine();
			inputSize = input.split(" ").length;
		} while (inputSize != n);

		String[] numbers = input.split(" ");
		for (int j = 0; j < n; j++) {
			array[j] = Integer.parseInt(numbers[j]);
		}

		System.out.println("Unsorted array: " + Arrays.toString(array));
		randomizedQuickSort(array, 0, array.length - 1);
		System.out.println("Sorted array: " + Arrays.toString(array));

	}

}
