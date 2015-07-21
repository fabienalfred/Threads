package org.antislashn.fork.join.matrix;

import java.util.concurrent.ForkJoinPool;

public class MainMatrixTask {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
		System.out.println("Nb de processeurs "+Runtime.getRuntime().availableProcessors());
		System.out.println("Parrallélisme par défaut : "+pool.getParallelism());
		
		long deb = System.currentTimeMillis();
//		Matrix m = Matrix.populate(4_000,4_000);
		
		Matrix m = new Matrix(4_000,4_000);
		MatrixPopulateTask task = new MatrixPopulateTask(m);
		pool.invoke(task);
		//pool.isTerminated();
		
		long fin = System.currentTimeMillis();
		System.out.println("Durée : "+ (fin-deb));
		
		System.out.println("FIN");
		//m.show();
	}

}
