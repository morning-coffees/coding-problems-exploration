package main;

public class BinaryGap {

	public static int printo() {
		int N = 805306373;
		String binary = Integer.toBinaryString(N);
		int longest = 0;
		int currentSize = 0;
		System.out.println(binary);
		if (N <= 2147483647) {
			for (int i = 0; i < binary.length(); i++) {
				if (binary.charAt(i) == '0') {
					currentSize++;
				} else if (binary.charAt(i) == '1') {
					if(currentSize > longest) {
						longest = currentSize;	
					}
					currentSize = 0;
				}
			}
		}
		return longest;
	}

	public static void main(String[] args) {

		System.out.println(printo());
		// call extend thread
//		for (int i = 0; i < 5; i++) {
//			Threado threado = new Threado(i);
//			threado.start();
//		}
//		

		// Call runnable
//		int currentCountAssignment = 0;
//		for (int i = 0; i < 100; i++) {
//			ThreadoRunnable threado = new ThreadoRunnable2(i);
//			Thread myThread = new Thread(threado);
//			myThread.start();
//		}

		// Call runnable 2

//		List<Integer> lintik = new ArrayList<>();
//		for(int i = 0; i < 100; i++) {
//			lintik.add(i);
//		}
//		List<Integer> lintik2 = new ArrayList<>();
//		for(int i = 10000; i < 10100; i++) {
//			lintik2.add(i);
//		}
//		int currentCountAssignment = 0;
//		int increments = 10;
//		
//		Waito waito = new Waito();
//		Thread waitoThread = new Thread(waito);
//		
//
//		ThreadoRunnable3 threado3 = new ThreadoRunnable3(lintik2);
//		Thread myThread3 = new Thread(threado3);
//		myThread3.start();
//		
//		for (int i = 0; i < 10; i++) {
//			ThreadoRunnable2 threado = new ThreadoRunnable2(lintik.subList(currentCountAssignment, currentCountAssignment + increments), waitoThread);
//			currentCountAssignment += increments;
//			Thread myThread = new Thread(threado);
//			myThread.start();
//			synchronized (waitoThread) {
//				try {
//					waitoThread.wait();
//					waitoThread.run();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//			synchronized (myThread) {
//				try {
//					myThread.wait();
//					System.out.println("Waiting?");
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//			}
	}
}
