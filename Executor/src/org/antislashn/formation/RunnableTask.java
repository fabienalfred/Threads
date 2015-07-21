package org.antislashn.formation;

public class RunnableTask implements Runnable {
	private int nbSecondes;
	
	public RunnableTask(int nbSecondes) {
		this.nbSecondes = nbSecondes;
	}
	
	@Override
	public void run() {
		System.out.println(">>> START "+Thread.currentThread().getName()+" pour "+nbSecondes+" s");
		try {
			Thread.sleep(nbSecondes*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(">>> FIN "+Thread.currentThread().getName());
	}

}
