package com;

public class Consumer implements Runnable {
	SharedResource sr;

	public Consumer(SharedResource obj) {
		this.sr = obj;
		Thread t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		while (true) {
			sr.getCurrentCount();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
