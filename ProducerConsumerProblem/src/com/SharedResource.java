package com;

public class SharedResource {
	int currentCount;
	boolean increamented = false;
	SharedResource() {
		
	}
	public synchronized void getCurrentCount() {
		if (!increamented) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		increamented = false;
		System.out.println("Current count is - " + currentCount);
		notify();
	}

	public synchronized void setCurrentCount() {
		if (increamented) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		currentCount = ++ currentCount;
		System.out.println("current count increamented..");
		increamented = true;
		notify();
	}

}
