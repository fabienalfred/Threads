package org.antislashn.formation.blocking.queue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
	private final BlockingQueue<String> queue;
	
	public Consumer(BlockingQueue<String> queue){
		this.queue = queue;
	}

	@Override
	public void run() {
		try{
			while(true){
				String s = queue.take();
				System.out.printf("%s take \"%s\"\n",Thread.currentThread().getName(),s);
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException e){
			System.out.println(e);
		}
		
	}
}
