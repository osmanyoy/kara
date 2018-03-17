package com.training.core.tst;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.junit.Assert;
import org.junit.Test;

public class MultiThreadTest {

	public static List<String> myList = new ArrayList<>(20_000);

	public static class Thread1 extends Thread {

		private CountDownLatch countDownLatch;
		private int count;

		public Thread1(final CountDownLatch countDownLatch, final int count) {
			this.countDownLatch = countDownLatch;
			this.count = count;
		}

		@Override
		public void run() {
			for (int i = 0; i < this.count; i++) {
				MultiThreadTest.myList.add("Test" + i);
			}
			this.countDownLatch.countDown();
		}
	}

	public static class Thread2 extends Thread {

		private CountDownLatch countDownLatch;
		private int count;

		public Thread2(final CountDownLatch countDownLatch, final int count) {
			this.countDownLatch = countDownLatch;
			this.count = count;
		}

		@Override
		public void run() {
			for (int i = 0; i < this.count; i++) {
				MultiThreadTest.myList.add("Test2" + i);
			}
			this.countDownLatch.countDown();
		}
	}

	@Test
	public void test() {
		CountDownLatch countDownLatch = new CountDownLatch(10);
		for (int i = 0; i < 5; i++) {
			Thread1 thread1 = new Thread1(countDownLatch,
			                              1000);
			thread1.start();
		}
		for (int i = 0; i < 5; i++) {
			Thread2 thread2 = new Thread2(countDownLatch,
			                              1000);
			thread2.start();
		}
		try {
			countDownLatch.await();

			Assert.assertEquals(10_000,
			                    MultiThreadTest.myList.size());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
