package com.training.spring.pattern;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Singleton {

	private static volatile Singleton singleton;
	private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	private Singleton() {

	}

	public static Singleton getInstance() {
		if (singleton == null) {
			synchronized (Singleton.class) {
				if (singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}

	public static Singleton getInstance2() {
		if (singleton == null) {
			readWriteLock.writeLock()
			             .lock();
			try {
				if (singleton == null) {
					singleton = new Singleton();
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				readWriteLock.writeLock()
				             .unlock();
			}
		}
		return singleton;
	}

}
