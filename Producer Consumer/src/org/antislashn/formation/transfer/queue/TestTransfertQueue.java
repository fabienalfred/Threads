package org.antislashn.formation.transfer.queue;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class TestTransfertQueue {

	public static void main(String[] args) {
		TransferQueue<String> queue = new LinkedTransferQueue<String>();
		Producer p1 = new Producer(queue);
		//Producer p2 = new Producer(queue);
		Consumer c1 = new Consumer(queue);
		Consumer c2 = new Consumer(queue);
		
		new Thread(p1).start();
		//new Thread(p2).start();
		new Thread(c1).start();
		new Thread(c2).start();

	}

}
