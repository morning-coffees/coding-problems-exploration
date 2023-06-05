package thread;

public class Waito implements Runnable{

//	private Runnable processToWait;
//	
//	Waito(Runnable processToWait) {
//		this.processToWait = processToWait;
//	}
	
	@Override
	public void run() {
//		synchronized (processToWait) {
//			try {
//				processToWait.wait();
//				System.out.println("DONE COUTNING!!!");
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
		System.out.println("DONEEEE!!!!");
	}
}
