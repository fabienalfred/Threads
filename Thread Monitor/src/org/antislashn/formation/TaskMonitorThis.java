package org.antislashn.formation;

public class TaskMonitorThis implements TaskMonitor {

	@Override
	public void doTask_1(int delayInSecondes) {
		synchronized (this) {
			long end = System.currentTimeMillis() + delayInSecondes * 1000;
			System.out.println(">>> BEGIN doTask_1 [" + Thread.currentThread().getName() + "]");

			while (System.currentTimeMillis() < end)
				;
			System.out.println(">>> END doTask_1 [" + Thread.currentThread().getName() + "]");
		}
	}

	@Override
	public void doTask_2(int delayInSecondes) {
		synchronized (this) {
			long end = System.currentTimeMillis() + delayInSecondes * 1000;
			System.out.println(">>> BEGIN doTask_2 [" + Thread.currentThread().getName() + "]");
			while (System.currentTimeMillis() < end)
				;
			System.out.println(">>> END doTask_2 [" + Thread.currentThread().getName() + "]");
		}
	}
}
