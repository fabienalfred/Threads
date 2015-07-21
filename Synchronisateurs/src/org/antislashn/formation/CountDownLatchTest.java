package org.antislashn.formation;

import java.util.concurrent.CountDownLatch;

class StopThread extends Thread {
	private final CountDownLatch latch;
	private long delay;

	public StopThread(CountDownLatch latch, long ms) {
		this.latch = latch;
		this.delay = ms;
	}

	public void run() {
		try {
			System.out.printf(">>> START %s\n", Thread.currentThread()
					.getName());
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			latch.countDown();
			System.out.printf(">>> END %s countDown==%d\n", Thread
					.currentThread().getName(), latch.getCount());
		}
	}

}

public class CountDownLatchTest {

	public static void main(String[] args) throws InterruptedException {
		int nbTaches = 5;
		CountDownLatch latch = new CountDownLatch(nbTaches);
		for(int i=0 ; i< nbTaches ; i++){
			StopThread t = new StopThread(latch, 1000);
			t.start();
		}
		latch.await();
		System.out.println("FIN DE TOUTES LES TACHES");
	}

}
