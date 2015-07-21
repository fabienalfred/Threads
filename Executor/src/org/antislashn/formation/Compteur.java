package org.antislashn.formation;

import java.util.concurrent.Callable;

public class Compteur implements Callable<Long> {
	private final long nb;
	
	public Compteur(long nb){
		this.nb = nb;
	}
	
	@Override
	public Long call() throws Exception {
		System.out.println(">>> "+Thread.currentThread().getName());
		long sum = 0;
		for(long i=0; i<nb; i++)
			sum+=i;
		return sum;
	}
}
