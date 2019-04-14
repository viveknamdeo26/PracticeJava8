package com;

public class Producer implements Runnable {
	SharedResource sr;
	public Producer (SharedResource obj) {
		sr = obj;
		Thread t = new Thread(this);
		t.start();
	}
	@Override
	public void run() {
		
		while (true) {
			sr.setCurrentCount();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
}
