package thread;

import java.util.List;

public class ThreadoRunnable2 implements Runnable {
	
	private List<Integer> listo;
	private Thread waito;
	
	public ThreadoRunnable2 (List<Integer> lintik, Thread waito) {
		this.listo = lintik;
		this.waito = waito;
	}
	
	@Override
	public void run() {
		listo.forEach(i -> {
			System.out.println(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		synchronized (waito) {
			waito.notify();
		}
	}
}
