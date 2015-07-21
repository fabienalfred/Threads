package org.antislashn.formation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadRunnableTaskExecutor {
	private List<Runnable> runnables = new ArrayList<Runnable>();
	private ExecutorService service = Executors.newFixedThreadPool(10);
	
	public void add(Runnable runnable){
		runnables.add(runnable);
	}
	
	public void start(){
		for(Runnable r : runnables){
			service.execute(r);
		}
		
		service.shutdown();
	}
	
	public void untilEnd(){
		service.shutdown();
	}
	
	public static void main(String[] args) {
		MultiThreadRunnableTaskExecutor executor = new MultiThreadRunnableTaskExecutor();
		executor.add(new RunnableTask(1));
		executor.add(new RunnableTask(2));
		executor.add(new RunnableTask(4));
		executor.add(new RunnableTask(3));
		
		executor.start();
		
		
		System.out.println("Fin des exécutions");
		
	}
}
