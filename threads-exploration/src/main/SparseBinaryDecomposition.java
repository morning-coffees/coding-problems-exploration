package main;

import java.util.concurrent.TimeUnit;

public class SparseBinaryDecomposition {

	public static void main(String[] args) {
//		int a = 4 & 0x55555555;

//		System.out.println(a);
		long startTime = System.nanoTime();

		int answer = -1;
		int N = 1000000000;
		if (N >= 0 && N <= 1000000000) {
			for (int i = 0; i <= N / 2 + 1; i++) {
				int pair = N - i;
				int pairS = pair & 0xAAAAAAAA;
				int iS = i & 1;
				if (isSparse2(i) && isSparse2(pair)) {
					answer = i;
					System.out.println(i + " - " + pair + " -> " + pairS + " <> " + iS);
					break;	
//				}
				}
			}
		}
		System.out.println(answer);

		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println(TimeUnit.NANOSECONDS.toMillis(totalTime));

	}

	public static boolean isSparse(int num) {
		String binary = Integer.toBinaryString(num);
		return binary.indexOf("11") == -1;
	}

	public static boolean isSparse2(int n) {
		// stores the previous last bit
		// initially as 0
		int prev_last = 0;
		while (n != 0) {
			// if current last bit and
			// previous last bit is 1
			if ((n & 1) != 0 && prev_last != 0)
				return false;
			// stores the last bit
			prev_last = n & 1;
			// right shift the number
			n >>= 1;
		}
		return true;
	}

}
