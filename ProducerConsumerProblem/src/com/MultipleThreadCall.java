package com;

public class MultipleThreadCall {

	public static void main(String[] args) {
		SharedResource rs = new SharedResource();
		new Producer(rs);
		new Consumer(rs);
	}

}
