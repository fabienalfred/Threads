package org.antislashn.formation;

public class ThreadTask2 implements Runnable {
	private TaskMonitor taskMonitor;
	
	public ThreadTask2(TaskMonitor taskMonitor) {
		this.taskMonitor = taskMonitor;
	}
	
	@Override
	public void run() {
		taskMonitor.doTask_2(2);
	}

}
