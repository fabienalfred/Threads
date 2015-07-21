package org.antislashn.formation;

public class Context {
	private int compteur = 0;
	private String transactionId;
	

	public int getCompteur() {
		return compteur;
	}

	public int incrementer(){
		return ++compteur;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	

}
