package org.antislashn.formation;

public class Task extends Thread {
	private int delay;
	
	public Task(int seconds){
		delay = seconds*1000;
	}
	
	@Override
	public void run(){
		System.out.println(">>> DEBUT : "+this.getName());
		try {
			sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(">>> FIN : "+this.getName());
	}
}
