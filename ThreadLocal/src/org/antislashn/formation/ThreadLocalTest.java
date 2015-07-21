package org.antislashn.formation;

public class ThreadLocalTest extends Thread {

	@Override
	public void run(){
		Context context = new Context();
		context.setTransactionId(getName());
		ThreadContext.set(context);
		int i=(int)(Math.random()*10+1);
		for(int j=0 ; j<i ; j++)
			context.incrementer();
		BusinessObject bo = new BusinessObject();
		bo.afficher();
	}

	public static void main(String[] args) {
		Thread[] threads = new Thread[5];
		
		for(int i=0 ; i<threads.length ; i++){
			threads[i] = new ThreadLocalTest();
			threads[i].start();
		}
		
	}

}
