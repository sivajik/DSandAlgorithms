package com.karumanchi.chap19;

public class Prob11_MaxSumWithNo3ConsectiveNumbers {

	public static void main(String[] args) {
		System.out.println(maxSumWithNoThreeConsecutiveNumbers(new int[] { 1, 2, 3, 4, 5 }));

	}
/*
 sum[0] = arr[0]

// Note : All elements are positive
sum[1] = arr[0] + arr[1]

// We have three cases
// 1) Exclude arr[2], i.e., sum[2] = sum[1]
// 2) Exclude arr[1], i.e., sum[2] = sum[0] + arr[2]
// 3) Exclude arr[0], i.e., sum[2] = arr[1] + arr[2] 
sum[2] = max(sum[1], arr[0] + arr[2], arr[1] + arr[2])


In general,
// We have three cases
// 1) Exclude arr[i],  i.e.,  sum[i] = sum[i-1]
// 2) Exclude arr[i-1], i.e., sum[i] = sum[i-2] + arr[i]
// 3) Exclude arr[i-2], i.e., sum[i-3] + arr[i] + arr[i-1] 
sum[i] = max(sum[i-1], sum[i-2] + arr[i],
             sum[i-3] + arr[i] + arr[i-1])
             
 */
	static public int maxSumWithNoThreeConsecutiveNumbers(int[] a) {
		int[] m = new int[a.length + 1];

		m[0] = a[0];
		m[1] = a[1];
		m[2] = Math.max(a[1], Math.max(a[0] + a[2], a[1] + a[2]));

		for (int i = 3; i < a.length; i++) {
			m[i] = Math.max(Math.max(m[i - 1], m[i - 2] + m[i]), 
                    m[i] + m[i - 1] + m[i - 3]); 
		}
		return m[a.length - 1];
	}
}
