package com.gfg.ds.single.linkedlist;

public class QuickSort {
	int partition(int arr[], int low, int high) {
		int pivot = arr[high];
		int i = low - 1;

		for (int j = low; j <= high - 1; j++) {
			if (arr[j] < pivot) {
				i++;

				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}

		int nextBestPosition = i + 1;

		int temp = arr[nextBestPosition];
		arr[nextBestPosition] = pivot;
		arr[high] = temp;

		return nextBestPosition;

	}

	void sort(int arr[], int low, int high) {
		if (low < high) {
			int partitionIndex = partition(arr, low, high);
			sort(arr, low, partitionIndex - 1);
			sort(arr, partitionIndex + 1, high);
		}
	}

	/* A utility function to print array of size n */
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	// Driver program
	public static void main(String args[]) {
		int arr[] = { 10, 7, 8, 9, 1, 5 };
		int n = arr.length;

		QuickSort ob = new QuickSort();
		ob.sort(arr, 0, n - 1);

		System.out.println("sorted array");
		printArray(arr);
	}
}