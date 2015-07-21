package org.antislashn.formation;

import java.util.Scanner;

public class ThreadInterruptMain {

	public static void main(String[] args) {
		Thread t1 = new Thread(new ThreadInterrupt(1));
		Thread t2 = new Thread(new ThreadInterrupt(2));
		
		t1.start();
		t2.start();
		
		Scanner in = new Scanner(System.in);
		System.out.println("Entrez le numéro du thread à arrêter : ");
		int num = in.nextInt();
		switch(num){
		case 1:
			System.out.printf("Etat du thread t1 : %s\n",t1.getState());
			t1.interrupt();
			break;
		case 2:
			System.out.printf("Etat du thread t2 : %s\n",t2.getState());
			t2.interrupt();
			break;
				
		}
	}

}
