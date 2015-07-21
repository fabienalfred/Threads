package org.antislashn.formation;

class Foo1 {
	private volatile static int a = 0;

	static void setA(int a) {
		Foo1.a = a;
	}

	static int getA() {
		return a;
	}
}

class Foo2 {
	void methodFoo2(int a) throws ClassNotFoundException {
		synchronized (this) {
			Foo1.setA(a);
			System.out.printf("%s - valeur de a : %d\n", Thread.currentThread().getName(), Foo1.getA());
		}
	}
}

class ThreadFoo2 extends Thread {
	private Foo2 foo;

	public ThreadFoo2(Foo2 foo) {
		this.foo = foo;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++)
			try {
				foo.methodFoo2(i);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	}

}

public class SynchonisationClasseMain {

	public static void main(String[] args) {
		Foo2 foo = new Foo2();

		ThreadFoo2 t0 = new ThreadFoo2(foo);
		ThreadFoo2 t1 = new ThreadFoo2(foo);

		t0.start();
		t1.start();

	}

}
