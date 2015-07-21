package org.antislashn.fork.join.start;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ForkJoinPool;

public class MainFolderScan {
	public static void main(String[] args) throws ScanException {

		Path chemin = Paths.get("C:\\FRANCK");
	    String filtre = "*.odp";
	     
	    //Création de notre tâche principale qui se charge de découper son travail en sous-tâches
	    FolderScanner fs = new FolderScanner(chemin, filtre);
	     
	    Long start = System.currentTimeMillis();
	     
	    fs.sequentialScan();
	    Long end = System.currentTimeMillis();
	    System.out.println("Il y a " + fs.getResultat() + " fichier(s) portant l'extension " + filtre);
	    System.out.println("Temps de traitement : " + (end - start));    
	}

}
