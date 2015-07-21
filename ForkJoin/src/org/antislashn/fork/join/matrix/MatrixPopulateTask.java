package org.antislashn.fork.join.matrix;

import java.util.Random;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("serial")
public class MatrixPopulateTask extends RecursiveTask<Boolean> {
	private static Random rand = ThreadLocalRandom.current();
	private Matrix m;
	private int i0, iFin, j0, jFin;
	
	public MatrixPopulateTask(Matrix m){
		this.m = m;
		i0 = 0;
		iFin = m.getHeight()-1;
		j0 = 0;
		jFin = m.getWidth()-1;
	}

	public MatrixPopulateTask(Matrix m, int iDeb, int iFin, int jDeb, int jFin){
		this.m = m;
		this.i0 = iDeb;
		this.iFin = iFin;
		this.j0 = jDeb;
		this.jFin = jFin;
		
	}
	
	@Override
	protected Boolean compute() {
		if(shouldSplit()){
			int iLim = (iFin - i0)/2 + i0;
			int jLim = (jFin - j0)/2 + j0;
		
			MatrixPopulateTask subTask1 = new MatrixPopulateTask(m, i0, iLim, j0, jLim);
			MatrixPopulateTask subTask2 = new MatrixPopulateTask(m, iLim+1, iFin, j0, jLim);
			MatrixPopulateTask subTask3 = new MatrixPopulateTask(m, i0, iLim, jLim+1, jFin);
			MatrixPopulateTask subTask4 = new MatrixPopulateTask(m, iLim+1,iFin,jLim+1,jFin);
			
			subTask2.fork();
			subTask3.fork();
			subTask4.fork();
			
			subTask1.process();
		}
		else{
			process();
		}
		return true;
	}

	private boolean shouldSplit() {
		return (iFin - i0)/4 > 0 && (jFin-j0)/4 >0;
	}

	public synchronized void process(){
		//System.out.printf("%s process from (%d,%d) to (%d,%d)\n",Thread.currentThread().getName(),i0,iFin,j0,jFin);
		for(int i=i0 ; i<iFin+1 ; i++)
			for(int j=j0 ; j<jFin+1 ; j++){
				StringBuffer buffer = new StringBuffer();
				m.line(i)[j] = buffer.append('(').append(i).append(',').append(j).append(')').toString();
			}
	}
}
