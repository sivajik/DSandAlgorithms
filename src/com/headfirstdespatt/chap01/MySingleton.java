package com.headfirstdespatt.chap01;

public class MySingleton {
	private static volatile MySingleton myUniqInstance /*= new MySingleton()*/;

	private MySingleton() {

	}

	public /*synchronized*/ MySingleton getInstance() {
		/*if (myUniqInstance == null) {
			myUniqInstance = new MySingleton();
		}*/
		
		// return LazyLoader.INSTANCE; // Bill Pugh Method..
		return myUniqInstance;
	}
	
	public MySingleton smartwayGetInstance() {
		if (myUniqInstance == null) {
			synchronized (MySingleton.class) {
				if (myUniqInstance == null) {
					myUniqInstance = new MySingleton();
				}
			}
		}
		return myUniqInstance;
	}
	
	
	private static class LazyLoader {
		private static final MySingleton INSTANCE = new MySingleton();
	}
}
