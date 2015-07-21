package org.antislashn.formation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class BoundedList<T>{
	private final List<T> liste;
	private final Semaphore semaphore;
	
	public BoundedList(int bound){
		this.liste = Collections.synchronizedList(new ArrayList<T>());
		this.semaphore = new Semaphore(bound);
	}
	
	public boolean add(T item) throws InterruptedException{
		semaphore.acquire();
		boolean ok = false;
		try{
			ok = liste.add(item);
			return ok;
		}
		finally{
			if(!ok)
				semaphore.release();
		}
	}
	
	public boolean remove(T item){
		boolean ok = liste.remove(item);
		if(ok)
			semaphore.release();
		return ok;
	}
}


public class SemaphoreTest {

	public static void main(String[] args) throws InterruptedException {
		BoundedList<String> liste = new BoundedList<String>(5);
		
		for(int i=0 ; i<10 ; i++)
		{
			boolean ok = liste.add("item "+i);
			if(ok)
				System.out.println("item "+i+" ajouté");
		}
		
		System.out.println("FIN");
	}

}
