import java.util.Random;

public class ConDiv {


	static int maxCrossingSum(int arr[], int l, 
			int m, int h){ 
		// Include elements on left of mid. 
		int sum = 0; 
		int low = 0,high = 0;

		int left_sum = Integer.MIN_VALUE; 
		for (int i = m; i >= l; i--) 
		{ 
			sum = sum + arr[i]; 
			if (sum > left_sum) 
				left_sum = sum; 
		} 

		// Include elements on right of mid 
		sum = 0; 
		int right_sum = Integer.MIN_VALUE; 
		for (int i = m + 1; i <= h; i++) 
		{ 
			sum = sum + arr[i]; 
			if (sum > right_sum) 
				right_sum = sum; 
				
		} 

		// Return sum of elements on left 
		// and right of mid 

		return left_sum + right_sum; 
	} 

	// Returns sum of maxium sum subarray  
	// in aa[l..h] 
	static int maxSubArraySum(int arr[], int l,  
			int h) 
	{ 
		// Base Case: Only one element 
		if (l == h) 
			return arr[l]; 

		// Find middle point 
		int m = (l + h)/2; 


		return Math.max(Math.max(maxSubArraySum(arr, l, m), 
				maxSubArraySum(arr, m+1, h)), 
				maxCrossingSum(arr, l, m, h)); 
	} 



	public static void findMaxSumBruteForce(int arr []) {


		int maximumSum = 0; // required initialisations
		int maximumLower = 0;
		int maximumHigher = 0;
		int low = 0;
		int high = 0;
		int sum;
		int newSum;
		for (int i = 0; i < arr.length - 1; i++) { // iterating over the loop till the length of the array
			sum = 0;
			newSum = 0;
			sum = arr[i] + arr[i + 1]; // adding up the data and saving in the sum varaible
			newSum = sum; // shifting the value to the latest sum varaible
			low = i; // initialising the lower element
			high = i + 1; // initialising the higher element
			for (int j = i + 2; j < arr.length; j++) { // iterating over the loop from the second element to the end of array
				newSum = newSum + arr[j]; // getting the sum of the new array
				if (sum < newSum) { // checking for the new and old sum data
					sum = newSum; // updating the sum value
					high = j; // replacing the higher element
				}
			}
			if (sum > maximumSum) { // comparing the highest sum value
				maximumSum = sum; // shifting the value to the maximumsum value
				maximumHigher = high; // updating the higher and lower element values
				maximumLower = low;
			}
		}
		System.out.println("");
		System.out.println("The Lower Bound Element is : " + maximumLower); // printing the data
		System.out.println("The Higher Bound Element is : " + maximumHigher);
		System.out.println("The Maximum Sum is : " + maximumSum);

	}


	public static int maxSubArr1(int[] arr1) { //steps to find maxsubarr of array

		int maxSum = 0; // required initialisations
		int maxLow = Integer.MIN_VALUE;;
		int maxHigh = 0;
		int low = 0;
		int high = 0;
		int sum;
		int newSum;
		for (int i = 0; i < arr1.length - 1; i++) { // iterating over the loop till the length of the array
			sum = 0;
			newSum = 0;
			sum = arr1[i] + arr1[i + 1]; 
			newSum = sum; // shifting the value to the latest sum varaible
			low = i; // initialising the lower element
			high = i + 1; // initialising the higher element
			for (int j = i + 2; j < arr1.length; j++) { 
				newSum = newSum + arr1[j]; // getting the sum of the new array
				if (sum < newSum) { 
					sum = newSum; // updating the sum value
					high = j; // replacing the higher element
				}
			}

			if (sum > maxSum) { 
				maxSum = sum; 
				maxHigh = high; 
				maxLow = low;
			}
		}


		return maxSum;
		//		System.out.println("The Lower Bound Element is : " + maxLow); // printing the data
		//		System.out.println("The Higher Bound Element is : " + maxHigh);

	}
	/* Driver program to test maxSubArraySum */
	public static void main(String[] args) 
	{ 

		ConDiv condiv = new ConDiv();
		ConDiv brute = new ConDiv();


		Random r = new Random();
		int[] arr = new int[10];

		System.out.println("randome rarray ");

				for(int i = 0; i < arr.length; i++) {
					arr[i] = r.nextInt(30 + 1 + 10) - 20;
		
					System.out.print(arr[i] + " , ");
				}


		int arrayData[] = {-1, 2, 4, 60, 1, -3, 2, -6, 7, -9, 1}; // random array data

//		for(int i = 0; i < arrayData.length; i++) {
//
//			System.out.print(arrayData[i] + " , ");
//		}
		int n = arr.length; 
		int sum = condiv.maxSubArraySum(arrayData, 0, n-1); 
		brute.findMaxSumBruteForce(arr);
		
		
//		System.out.println("MaxSub array  is "+ 
//				sum); 
		//		
		//System.out.println("MaxSub array  is "+ sum1); 
	} 

}
