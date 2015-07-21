package org.antislashn.formation.wait.notify;

public class Consumer extends Thread {
	private Heap heap;

	public Consumer(Heap heap) {
		this.heap = heap;
	}

	@Override
	public void run() {
		try {
			while (!interrupted()) {
				String data = heap.remove();
				System.out.println("OUT : "+data);
				int delay = (int) (Math.random() * 5);
				sleep(delay*100);
			}
		} catch (Exception e) {
			interrupt();
		}
	}
}
