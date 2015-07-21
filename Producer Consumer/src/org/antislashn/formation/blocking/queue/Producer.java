package org.antislashn.formation.blocking.queue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
	private final BlockingQueue<String> queue;
	
	public Producer(BlockingQueue<String> queue){
		this.queue = queue;
	}

	@Override
	public void run() {
		try{
			for(int i=0 ; i<10 ; i++){
				queue.put(Thread.currentThread().getName()+" add "+i);
				System.out.printf("%s add %d\n",Thread.currentThread().getName(),i);
			}
		}
		catch(InterruptedException e){
			System.out.println(e);
		}
	}
}
