package org.antislashn.formation.wait.notify;

public class Heap {
	private String[] datas = new String[10];
	private int indexIn =0, indexOut=0, nbElements=0;
	private Object lock = new Object();

	public void add(String data) {
		synchronized (lock) {
			if (nbElements == data.length()) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			nbElements++;
			indexIn = (indexIn+1) % datas.length;
			datas[indexIn] = data;
			lock.notify();
		}
	}

	public String remove() {
		synchronized (lock) {
			if (nbElements==0) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			nbElements--;
			indexOut = (indexOut + 1) % datas.length;
			lock.notify();
			return datas[indexOut];
		}
	}
}
