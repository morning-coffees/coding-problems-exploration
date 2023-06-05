package thread;

import java.util.List;

public class ThreadoRunnable3 implements Runnable {
	private List<Integer> listo;
	
	public ThreadoRunnable3 (List<Integer> lintik) {
		this.listo = lintik;
	}
	
	@Override
	public void run() {
		listo.forEach(i -> {
			System.out.println(i);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
}
