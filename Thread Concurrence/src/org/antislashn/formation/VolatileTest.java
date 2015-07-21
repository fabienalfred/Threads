package org.antislashn.formation;


class Test{
	static volatile int i=0, j=0;
	static void methodOne(){i++;j++;}
	static void methodTwo(){
		System.out.printf("i == %d,  j == %d\n",i,j);
	}
}

class ThreadTest1 extends Thread{
	private Test test;
	
	public ThreadTest1(Test test){
		this.test = test;
	}
	
	public void run(){
		for(int i=0; i<10 ; i++)
			test.methodOne();
	}
}

class ThreadTest2 extends Thread{
	private Test test;
	
	public ThreadTest2(Test test){
		this.test = test;
	}
	
	public void run(){
		for(int i=0; i<10 ; i++)
			test.methodTwo();
	}
}
public class VolatileTest {


	public static void main(String[] args) {
		Test test = new Test();
		
		ThreadTest1 t1 = new ThreadTest1(test);
		ThreadTest2 t2 = new ThreadTest2(test);
		
		t1.start();
		t2.start();

	}

}
