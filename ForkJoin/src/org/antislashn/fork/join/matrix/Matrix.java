package org.antislashn.fork.join.matrix;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Matrix {
	private int height, width;
	private String[][] datas;
	private static Random rand = ThreadLocalRandom.current();
	
	public Matrix(int height, int width){
		this.height = height;
		this.width = width;
		datas = new String[height][width];
	}
	
	public static Matrix populate(int height, int width){

		Matrix m = new Matrix(height, width);
		for(int i=0 ; i<height ; i++)
			for(int j=0 ; j<width ; j++){
				StringBuffer buffer = new StringBuffer();
				m.datas[i][j] = buffer.append('(').append(i).append(',').append(j).append(')').toString();
			}
		return m;
	}
	
	public void show(){
		for(int i=0 ; i<height ; i++){
			for(int j=0 ; j<width ; j++){
				System.out.print(datas[i][j]+" | ");
			}
			System.out.println();
		}
	}
	
	public int getHeight(){
		return datas.length;
	}
	
	public int getWidth(){
		return datas[0].length;
	}
	
	public String[] line(int i){
		return datas[i];
	}
	
}
