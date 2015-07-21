package org.antislashn.formation;

public class ThreadContext {
	private final static ThreadLocal<Context> userContext = new ThreadLocal<Context>();
	
	public static void set(Context context){
		userContext.set(context);
	}
	
	public static void unset(Context context){
		userContext.remove();
	}
	
	public static Context get(){
		return userContext.get();
	}
	

}
