package org.antislashn.formation;



public class DoubleLockClassique {
	private final Object lock1 = new Object();
	private final Object lock2 = new Object();
	boolean maCondition = true;
	
	public void foo() throws InterruptedException{
		synchronized (lock1) {
			synchronized (lock2) {
				while(maCondition){
					lock2.wait();
				}
			}
		}
	}
	
	public void notifier(){
		lock2.notify();
	}
}
