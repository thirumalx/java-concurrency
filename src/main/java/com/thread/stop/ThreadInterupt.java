/**
 * 
 */
package com.thread.stop;

import java.math.BigInteger;

/**
 * 
 */
public class ThreadInterupt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//--------------Blocking Thread
		Thread t = new Thread(new BlockingThread());
		t.start();
		t.interrupt();
		//---------------- LongComputationThread
//		Thread t1 = new Thread(new LongCompurationTask(BigInteger.valueOf(10L), BigInteger.valueOf(21979878979829L)));
//		t1.setDaemon(true);// Another way to terminate, when main thread end
//		t1.start();
//		t1.interrupt();
		
		
	}
	
	static class BlockingThread implements Runnable {

		@Override
		public void run() {
			
			try {
				Thread.sleep(1000000000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	static class LongCompurationTask implements Runnable {

		BigInteger base;
		BigInteger power;
		
		public LongCompurationTask(BigInteger base, BigInteger power) {
			this.base = base;
			this.power = power;
		}
		
		@Override
		public void run() {
			System.out.println(base + "^" + power + " = " + pow(base, power));
		}

		private BigInteger pow(BigInteger base2, BigInteger power2) {
			BigInteger result = BigInteger.ONE;
			for (BigInteger i = BigInteger.ZERO; i.compareTo(power2) != 0; i = i.add(BigInteger.ONE)) {
				if (Thread.interrupted()) {
					System.out.println("Thread is prematurly exiting");
					return BigInteger.ZERO;
				}
				result = result.multiply(base2);
			}
			return result;
		}
		
	}

}
