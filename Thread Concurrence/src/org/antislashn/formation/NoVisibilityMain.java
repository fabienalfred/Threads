package org.antislashn.formation;

public class NoVisibilityMain {

	private static boolean ready;
	private static int number;
	
	private static class ReaderThread extends Thread{
		@Override
		public void run(){
			while(!ready){
				Thread.yield();
			}
			System.out.printf(">>> number == %d\n",number);
		}
	}
	
	public static void main(String[] args) {
		new ReaderThread().start();
		number = 100;
		ready=true;

	}

}
