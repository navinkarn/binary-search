package com.example.binarysearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BinarySearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(BinarySearchApplication.class, args);
		int arr[]={10, 20,30,40,50};
		int key =30;
		int last = arr.length -1 ;
		binarySearchIterative(arr, 0, last, key);

		int result = binarySearchRecursive(arr,0,last,key);
		if (result == -1)
			System.out.println("Recursive-Element is not found !");
		else
			System.out.println("Recursive-Element is found at index: "+result);
	}

	public static void binarySearchIterative(int arr[], int first, int last, int key){
		int mid = (first+last)/2;
		while(first <= last){
			if(arr[mid] < key){
				first = mid +1;
			}else if(arr[mid] == key){
				System.out.println("Element found at index:" +mid);
				break;
			}else {
				last = mid -1;
			}
			mid = (first + last)/2;

		}
		if(first > last) {
			System.out.println("Search element not found");
		}
	}

	public static int binarySearchRecursive(int arr[], int first, int last, int key){
		if (last>=first){
			int mid = first + (last - first)/2;
			if (arr[mid] == key){
				return mid;
			}
			if (arr[mid] > key){
				return binarySearchRecursive(arr, first, mid-1, key);//search in left subarray
			}else{
				return binarySearchRecursive(arr, mid+1, last, key);//search in right subarray
			}
		}
		return -1;
	}

}
