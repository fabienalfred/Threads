package org.antislashn.formation.wait.notify;

public class Producer extends Thread{
	private Heap heap;
	
	public Producer(Heap heap) {
		this.heap = heap;
	}
	
	@Override
	public void run(){
		for(int i=0 ; i<20 ; i++){
			System.out.println("IN : élément "+i);
			heap.add("élément "+i);
			int delay = (int)(Math.random()*5);
			try {
				sleep(delay*100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
