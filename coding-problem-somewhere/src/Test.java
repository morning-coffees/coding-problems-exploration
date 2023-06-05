import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Test {
	
	public static void main(String[] args) {
		System.out.println("Hello world");
		int[] A = {1,1};
		int[] B = {1,1};
		System.out.println(solution(A, null));
	}

	static final int ARRAY_LENGTH = 100000;
	static final int MIN_VALUE = -1000000000;
	static final int MAX_VALUE = 1000000000;
	
	public static int solution(int[] A, int[] B) {
		if(A == null || B == null || A.length != B.length || A.length > ARRAY_LENGTH) {
			return 0;
		}
		
		int arrSize = A.length;
		int sumA = IntStream.of(A).sum();
		int sumB = IntStream.of(B).sum();
		int	firstHalfSumOfA = 0;
		int	firstHalfSumOfB = 0;
		List<Integer> fairIndexes = new ArrayList<>();

		for (int i = 0; i < arrSize - 1; i++) {
			if(A[i] <= MAX_VALUE && A[i] >= MIN_VALUE || B[i] <= MAX_VALUE && B[i] >= MIN_VALUE) {
				firstHalfSumOfA += A[i];
				firstHalfSumOfB += B[i];
				
				int secondHalfSumOfA = sumA - firstHalfSumOfA;
				int secondHalfSumOfB = sumB - firstHalfSumOfB;
				boolean isAllHalfEqual = (firstHalfSumOfA == firstHalfSumOfB) && (secondHalfSumOfA == secondHalfSumOfB) && (firstHalfSumOfA == secondHalfSumOfB);
				if(isAllHalfEqual) {
					fairIndexes.add(i + 1);
				}
			} else {
				throw new IllegalArgumentException("An invalid number is found!");
			}
		}
		
		for (Integer integer : fairIndexes) {
			System.out.println("Fair Index: " + integer);
		}
		return fairIndexes.size();
    }
}
