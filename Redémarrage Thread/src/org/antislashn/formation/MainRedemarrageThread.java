package org.antislashn.formation;

public class MainRedemarrageThread {

	public static void main(String[] args) throws InterruptedException {
		Task task = new Task(2);
		System.out.println("DEMARRAGE");
		task.start();
		task.join();
		System.out.println("REDEMARRAGE");
		task.start();
		task.join();
		System.out.println("FIN");

	}

}
