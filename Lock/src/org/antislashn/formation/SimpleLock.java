package org.antislashn.formation;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleLock {

	class Counter{
		private Lock lock = new ReentrantLock();
		private int count=0;
		
		public int increment(){
			lock.lock();
			try{
				++count;
				return count;
			}
			finally{
				lock.unlock();
			}			
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
