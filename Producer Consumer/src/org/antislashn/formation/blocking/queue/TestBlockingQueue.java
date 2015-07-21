package org.antislashn.formation.blocking.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TestBlockingQueue {

	public static void main(String[] args) {
		BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
		Producer p1 = new Producer(queue);
		//Producer p2 = new Producer(queue);
		Consumer c1 = new Consumer(queue);
		//Consumer c2 = new Consumer(queue);
		
		new Thread(p1).start();
		//new Thread(p2).start();
		new Thread(c1).start();
		//new Thread(c2).start();

	}

}
