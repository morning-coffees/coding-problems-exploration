import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {

	public static void main(String[] args) {
		int[] A = {4,0,3,1000000000,1};
		System.out.println("Start...");
		System.out.println(solution(A));
	}

	static final int ARRAY_LENGTH_MAX = 100000;
	static final int ARRAY_ELEMENT_MAX = 1000000;
	static final int ARRAY_ELEMENT_MIN = 0;

	
	public static int solution(int[] A) {
		if(A == null || A.length == 0 || A.length > ARRAY_LENGTH_MAX) {
			return 0;
		}
		List<Integer> asList = Arrays.stream(A).boxed().collect(Collectors.toList());
		asList.forEach(num -> {
			if(num < ARRAY_ELEMENT_MIN || num > ARRAY_ELEMENT_MAX) {
				throw new IllegalArgumentException("Invalid Element Value: " + num);
			}
		});
		
		int remainingStack = 0;
		for (int i = 0; i < asList.size(); i++) {
			int tokensToMove = asList.get(i) / 2;
			int remainder = asList.get(i) - (tokensToMove * 2);
			remainingStack += remainder;
			
			if (asList.size() == i + 1 && tokensToMove > 0) {
				asList.add(tokensToMove);
			} else if (tokensToMove > 0) {
				asList.set(i+1, asList.get(i+1) + tokensToMove);
			}
		}
		return remainingStack;
	}
}
