package org.antislashn.formation.transfer.queue;

import java.util.concurrent.TransferQueue;

public class Producer implements Runnable{
	private final TransferQueue<String> queue;
	
	public Producer(TransferQueue<String> queue){
		this.queue = queue;
	}

	@Override
	public void run() {
		try{
			for(int i=0 ; i<10 ; i++){
				queue.transfer("i == "+i);
				System.out.printf("%s add %d\n",Thread.currentThread().getName(),i);
			}
		}
		catch(InterruptedException e){
			System.out.println(e);
		}
	}
}
