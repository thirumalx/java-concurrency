package com.thread.catchuncaughtexception;

public class CatchUncaughtException {

	public static void main(String[] args) {
		Thread t = new Thread(() -> {
			int i = 10; 
			if (i/0 == 0) {
				System.out.println("Unreachable code");
			}
		});
		t.setUncaughtExceptionHandler((t1, e) -> {
				System.out.println("Thread " + t1 + " had encountered " + e.getMessage());
			}
		);
		t.start();
		try {
			t.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Finished ....");
	}

}
