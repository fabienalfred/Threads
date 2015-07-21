package org.antislashn.formation;

public class TestTaskMonitor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TaskMonitor taskMonitor = Helper.getTaskMonitor(Helper.SYNCHRONIZED_THIS_SLEEP);
		
		ThreadTask1 task1 = new ThreadTask1(taskMonitor);
		ThreadTask2 task2 = new ThreadTask2(taskMonitor);
		
		new Thread(task1).start();
		new Thread(task2).start();
	}

}
