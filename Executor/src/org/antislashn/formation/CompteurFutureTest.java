package org.antislashn.formation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompteurFutureTest {
	private static final int NB_THREADS = 50;
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(NB_THREADS);
		List<Future<Long>> futures = new ArrayList<Future<Long>>();
		for(int i=100 ; i< 120 ; i++){
			Callable<Long> callable = new Compteur(i);
			Future<Long> future = executor.submit(callable);
			futures.add(future);
		}
		executor.shutdown();
		long total = 0;
		for(Future<Long> f : futures){
			try {
				total = f.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		System.out.println("TOTAL = "+total);
	}
	
}
