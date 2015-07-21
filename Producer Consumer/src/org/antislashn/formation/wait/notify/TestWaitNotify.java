package org.antislashn.formation.wait.notify;

public class TestWaitNotify {
	
	public static void main(String[] args) throws InterruptedException {
		Heap heap = new Heap();
		Consumer consumer = new Consumer(heap);
		Producer producer = new Producer(heap);
		
		producer.start();
		consumer.start();
		
		
		producer.join();
		//consumer.interrupt();
		System.out.println("END");
	}
}
