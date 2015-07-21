package org.antislashn.formation;


class Foo{
		private int a;
		private int b = 2;
		
		public Foo(int val){
			a=val;
			b=2*a;
		}
		
		public void changer(){
			synchronized (System.out) {
				System.out.printf("DEBUT %s - a == %d, b == %d\n",Thread.currentThread().getName(),a,b);
				a++;
				b=2*a;
				System.out.printf("FIN %s - a == %d, b == %d\n",Thread.currentThread().getName(),a,b);
			}
		}
}

class ThreadFoo extends Thread{
	private Foo foo;
	
	public ThreadFoo(Foo foo){
		this.foo = foo;
	}
	
	@Override
	public void run(){
		for(int i=0 ; i<10 ; i++)
			foo.changer();
	}
	
}
public class SynchronisationMain {
	public static void main(String[] args) {
		Foo foo = new Foo(10);
		
		ThreadFoo t0 = new ThreadFoo(foo);
		ThreadFoo t1 = new ThreadFoo(foo);
		
		t0.start();
		t1.start();
	}
}
