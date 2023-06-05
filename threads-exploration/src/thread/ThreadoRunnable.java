package thread;

public class ThreadoRunnable implements Runnable {
	private int threadNumber;
	
	public ThreadoRunnable (int threadNumber) {
		this.threadNumber = threadNumber;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 5; i++) {
			System.out.println(i + " from thread no " + threadNumber);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
