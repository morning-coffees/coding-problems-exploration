package se11_tester.loop_test;

public class CoontinueLabel {

	public static void run() {
		int[] myNums = {1,2,3,4,5,6};
		
		someLabel: // can also be done on break:
		for (int a: myNums) {
			for(int b: myNums) {
				if(b == 4) continue someLabel;
				System.out.print(b);
			}
			System.out.println("-----");
		}
	}
	
}
