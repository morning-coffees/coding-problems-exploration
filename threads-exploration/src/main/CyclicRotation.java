package main;

import java.util.ArrayList;
import java.util.List;

public class CyclicRotation {

	public static int[] printo() {
		int K = 5;
		int[] A = {};
		if(A.length <= 100 && A.length > 0 && K <= 100 && K > 0) {
			List<Integer> B = new ArrayList<>();
			int middleLength = A.length - (K % A.length);
			for (int i = middleLength; i < A.length; i++) {
				if(A[i] >= -100000 && A[i] <= 100000) {
					B.add(A[i]);					
				} else {
					throw new IllegalArgumentException("Eh?");
				}
			}
			for (int i = 0; i < middleLength; i++) {
				if(A[i] >= -100000 && A[i] <= 100000) {
					B.add(A[i]);					
				} else {
					throw new IllegalArgumentException("Eh?");
				}
			}			
			return B.stream().mapToInt(Integer::intValue).toArray();
		} else {
			return A;
		}
	}	
	
	public static void main(String[] args) {
		printo();
	}
}
