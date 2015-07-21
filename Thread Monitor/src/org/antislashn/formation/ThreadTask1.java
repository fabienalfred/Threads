package org.antislashn.formation;

public class ThreadTask1 implements Runnable {
	private TaskMonitor taskMonitor;
	
	public ThreadTask1(TaskMonitor taskMonitor) {
		this.taskMonitor = taskMonitor;
	}
	
	@Override
	public void run() {
		taskMonitor.doTask_1(2);
	}

}
