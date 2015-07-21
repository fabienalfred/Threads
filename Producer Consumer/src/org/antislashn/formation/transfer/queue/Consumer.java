package org.antislashn.formation.transfer.queue;

import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable{
	private final TransferQueue<String> queue;
	
	public Consumer(TransferQueue<String> queue){
		this.queue = queue;
	}

	@Override
	public void run() {
		try{
			while(true){
				String s = queue.take();
				System.out.printf("%s take %s\n",Thread.currentThread().getName(),s);
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException e){
			System.out.println(e);
		}
		
	}
}
