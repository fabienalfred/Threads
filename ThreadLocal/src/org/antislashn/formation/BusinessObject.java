package org.antislashn.formation;

public class BusinessObject {
	public void afficher(){
		Context context = ThreadContext.get();
		System.out.printf("Transaction : %s - compteur : %d\n",context.getTransactionId(),context.getCompteur());
	}
}
